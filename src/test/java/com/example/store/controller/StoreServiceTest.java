package com.example.store.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.store.entity.Seller;
import com.example.store.repo.SellerRepository;
import com.example.store.service.StoreServiceImpl;

public class StoreServiceTest {

	@Mock
	private SellerRepository sellerRepo;

	@InjectMocks
	private StoreServiceImpl storeService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindStoreWithValidId() {
		// Arrange
		final Seller seller = new Seller();
		final long sellerId = 1L;
		seller.setId(sellerId);
		seller.setName("Anandu");
		seller.setLocation("Kollam");

		when(sellerRepo.findById(sellerId)).thenReturn(Optional.of(seller));

		// Act
		final Seller result = storeService.findStore(sellerId);

		// Assert
		assertEquals(sellerId, result.getId());
		assertEquals("Anandu", result.getName());
		assertEquals("Kollam", result.getLocation());
	}

	@Test
	public void testFindStoreWithInvalidId() {
		// Arrange
		final long invalidSellerId = -1L;
		when(sellerRepo.findById(invalidSellerId)).thenReturn(Optional.empty());

		// Act and Assert
		final Exception exception = assertThrows(IllegalArgumentException.class,
				() -> storeService.findStore(invalidSellerId));
		assertEquals("Store not found  with id: " + invalidSellerId, exception.getMessage());
	}
}
