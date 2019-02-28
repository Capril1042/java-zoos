package com.cjs.zoos.repositories;

import com.cjs.zoos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}