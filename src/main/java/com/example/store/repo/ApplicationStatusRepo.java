package com.example.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.entity.ApplicationStatus;

@Repository
public interface ApplicationStatusRepo extends JpaRepository<ApplicationStatus, Long> {

}