package com.gtechtest.service;

import com.gtechtest.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User findUser(String username);
    void save(User user);
    void update(User user);
}
