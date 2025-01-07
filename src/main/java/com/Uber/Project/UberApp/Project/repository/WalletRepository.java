package com.Uber.Project.UberApp.Project.repository;

import com.Uber.Project.UberApp.Project.entity.User;
import com.Uber.Project.UberApp.Project.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUser(User user);
}
