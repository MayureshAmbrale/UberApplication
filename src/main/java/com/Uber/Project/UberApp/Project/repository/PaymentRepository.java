package com.Uber.Project.UberApp.Project.repository;

import com.Uber.Project.UberApp.Project.entity.Payment;
import com.Uber.Project.UberApp.Project.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);
}
