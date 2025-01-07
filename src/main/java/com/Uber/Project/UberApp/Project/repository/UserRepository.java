package com.Uber.Project.UberApp.Project.repository;

import com.Uber.Project.UberApp.Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> getUserById(Long userId);
}

