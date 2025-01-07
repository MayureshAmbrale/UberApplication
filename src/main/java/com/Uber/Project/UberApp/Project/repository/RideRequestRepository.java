package com.Uber.Project.UberApp.Project.repository;

import com.Uber.Project.UberApp.Project.entity.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {

}
