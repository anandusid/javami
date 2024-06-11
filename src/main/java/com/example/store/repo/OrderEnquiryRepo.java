package com.example.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.entity.Enquiry;

@Repository
public interface OrderEnquiryRepo extends JpaRepository<Enquiry, Long> {

}