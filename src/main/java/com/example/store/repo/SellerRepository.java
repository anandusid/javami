package com.example.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
	// You can add custom query methods here if needed
}