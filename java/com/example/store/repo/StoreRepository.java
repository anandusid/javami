package com.example.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	// You can add custom query methods here if needed
}
