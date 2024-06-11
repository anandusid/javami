package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.entity.Enquiry;
import com.example.store.entity.Seller;
import com.example.store.entity.Store;
import com.example.store.pojo.StorePojo;
import com.example.store.repo.OrderEnquiryRepo;
import com.example.store.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private OrderEnquiryRepo repo;

	@GetMapping("/test")
	public String test() {
		return "working";
	}

	@PostMapping("/store")
	public ResponseEntity<Store> createStore(@RequestBody final StorePojo storeRequest) {
		final Store createdStore = storeService.createStore(storeRequest);
		return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
	}

	@PostMapping("/store/{storeId}/seller")
	public ResponseEntity<Seller> createSeller(@PathVariable final Long storeId, @RequestBody final Seller seller) {
		final Seller createdSeller = storeService.createSeller(storeId, seller);
		return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
	}

	@GetMapping("/store")
	public ResponseEntity<List<Seller>> findStores() {
		final List<Seller> createdSeller = storeService.findStores();
		return new ResponseEntity<>(createdSeller, HttpStatus.OK);
	}

	@GetMapping("store/{id}")
	public ResponseEntity<Seller> findStore(@PathVariable final Long id) {
		System.out.println(" Main controller");
		final Seller createdSeller = storeService.findStore(id);
		final Enquiry obj = new Enquiry();
		obj.setSellerId(String.valueOf(id));
		obj.setName("User");
		repo.save(obj);
		return new ResponseEntity<>(createdSeller, createdSeller != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
}
