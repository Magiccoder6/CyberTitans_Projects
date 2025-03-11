package com.intellibus.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellibus.api.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByUsername(String username);
}
