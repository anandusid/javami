package com.example.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.store.entity.Seller;
import com.example.store.entity.Store;
import com.example.store.pojo.StorePojo;

@Service
public interface StoreService {

	Store createStore(StorePojo store);

	Store getStore(Integer id);

	void removeStore();

	Store updateStore();

	Seller createSeller(Long storeId, Seller seller);

	List<Seller> findStores();

	Seller findStore(Long id);

}
