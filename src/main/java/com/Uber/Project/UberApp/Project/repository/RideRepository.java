package com.Uber.Project.UberApp.Project.repository;

import com.Uber.Project.UberApp.Project.entity.Driver;
import com.Uber.Project.UberApp.Project.entity.Ride;
import com.Uber.Project.UberApp.Project.entity.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    Page<Ride> findByRider(Rider rider, Pageable pageRequest);

    Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
}

