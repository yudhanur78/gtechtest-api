package com.gtechtest.service.serviceImpl;

import com.gtechtest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gtechtest.repository.UserRepo;
import com.gtechtest.service.UserService;

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
}
