package com.example.store.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.store.entity.Seller;
import com.example.store.repo.SellerRepository;

@DataJpaTest
public class StoreRepoTest {
	@Autowired
	private SellerRepository sellerRepo;

	@Test
	void testData() {

		final Seller seller = new Seller();
		final long sellerId = 1L;
		seller.setId(sellerId);
		seller.setName("Anandu");
		seller.setLocation("Kollam");
		sellerRepo.save(seller);

		final var result = sellerRepo.findById(sellerId);
		assertTrue(result.isPresent());

	}

}
