package com.gtechtest.controller;

import com.gtechtest.base.JwtResponse;
import com.gtechtest.config.JwtTokenUtil;
import com.gtechtest.entity.User;
import com.gtechtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @PostMapping(path = "/register", consumes = "application/json")
    public ResponseEntity create(@RequestBody Map<String, ?> param) {
        User user = new User();
        if ((param.get("email") != null) && (param.get("mobile_number") != null) && (param.get("password") != null)) {
            user.setEmail((String) param.get("email"));
            user.setMobileNumber((String) param.get("mobile_number"));
            user.setPassword(bcryptEncoder.encode((String) param.get("password")));
            userService.save(user);
            return ResponseEntity.ok().body("CREATE USER SUCCESS");
        } else {
            return ResponseEntity.ok().body("CREATE USER FAILED");
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, ?> param) throws Exception {
        authenticate((String) param.get("username"), (String) param.get("password"));
        final UserDetails userDetails = userService.loadUserByUsername((String) param.get("username"));
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
