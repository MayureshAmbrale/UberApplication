package com.Uber.Project.UberApp.Project.repository;

import com.Uber.Project.UberApp.Project.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
