package com.gtechtest.service.serviceImpl;

import com.gtechtest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gtechtest.repository.UserRepo;
import com.gtechtest.service.UserService;

import java.util.ArrayList;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    public User findUser(String username) {
        return userRepo.findUser(username);
    }

    public void save(User user) {
        user.setCreatedDt(new Date());
        userRepo.save(user);
    }

    public void update(User user) {
        user.setModifiedDt(new Date());
        userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findUser(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}
