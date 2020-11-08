package com.gtechtest.service;

import com.gtechtest.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUser(String username);
    void save(User user);
    void update(User user);
}
