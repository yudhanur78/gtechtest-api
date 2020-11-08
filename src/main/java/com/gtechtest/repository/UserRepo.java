package com.gtechtest.repository;

import com.gtechtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface UserRepo extends JpaRepository<User, String> {
    @Query("SELECT x FROM User x WHERE x.email = ?1 OR x.mobileNumber = ?1")
    User findUser(String username);
}
