package com.example.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.entity.Seller;
import com.example.store.entity.Store;
import com.example.store.pojo.StorePojo;
import com.example.store.repo.SellerRepository;
import com.example.store.repo.StoreRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private SellerRepository sellerRepo;
	@Autowired
	private StoreRepository storeRepo;

	@Override
	public Store createStore(final StorePojo storeRequest) {
		final Store store = new Store();
		store.setName(storeRequest.getName());
		store.setLocation(storeRequest.getLocation());
		return storeRepo.save(store);
	}

	@Override
	public Store getStore(final Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStore() {
		// TODO Auto-generated method stub

	}

	@Override
	public Store updateStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller createSeller(final Long storeId, final Seller seller) {
		final Store store = storeRepo.findById(storeId)
				.orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));
		final Seller sellerObj = new Seller();
		sellerObj.setName(seller.getName());
		sellerObj.setLocation(seller.getLocation());

		sellerObj.setStore(store);

		return sellerRepo.save(sellerObj);
	}

	@Override
	public List<Seller> findStores() {
		return sellerRepo.findAll();
	}

	@Override
	public Seller findStore(final Long storeId) {
		return sellerRepo.findById(storeId)
				.orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));
	}

}
