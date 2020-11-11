package com.gtechtest.controller;

import com.gtechtest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.gtechtest.service.UserService;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @GetMapping(path = "/{username}")
    public User findUser(@PathVariable("username") String username) {
        return userService.findUser(username);
    }

    @PutMapping(path = "/{username}")
    public ResponseEntity update(@PathVariable("username") String username, @RequestBody Map<String, ?> param) {
        User user = userService.findUser(username);
        if (user != null) {
            if (param.get("email") != null) {
                user.setEmail((String) param.get("email"));
            }
            if (param.get("mobile_number") != null) {
                user.setMobileNumber((String) param.get("mobile_number"));
            }
            if (param.get("first_name") != null) {
                user.setFirstName((String) param.get("first_name"));
            }
            if (param.get("last_name") != null) {
                user.setLastName((String) param.get("last_name"));
            }
            if (param.get("gender") != null) {
                user.setGender((String) param.get("gender"));
            }
            if (param.get("date_of_birth") != null) {
                user.setDateOfBirth((Date) param.get("date_of_birth"));
            }
            if (param.get("password") != null) {
                user.setPassword(bcryptEncoder.encode((String) param.get("password")));
            }
            userService.update(user);
            return ResponseEntity.ok().body("UPDATE USER SUCCESS");
        } else {
            return ResponseEntity.ok().body("UPDATE USER FAILED");
        }
    }
}
