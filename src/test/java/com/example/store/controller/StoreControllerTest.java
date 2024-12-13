//package com.example.store.controller;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.example.store.entity.Seller;
//import com.example.store.repo.OrderEnquiryRepo;
//import com.example.store.service.StoreService;
//
//@WebMvcTest(StoreController.class)
//public class StoreControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private StoreService storeService;
//	@MockBean
//	private OrderEnquiryRepo orderEnquiryRepo;
//
//	@MockBean
//	private AuthenticationManager authenticationManagerBean;
//
//	@BeforeEach
//	public void setup() {
//		MockitoAnnotations.openMocks(this);
//	}
//
//	@Test
//	public void testFindStore() throws Exception {
//		final Long storeId = 1L;
//		final Seller seller = new Seller();
//		seller.setId(storeId);
//		seller.setName("John Doe");
//
//		when(storeService.findStore(storeId)).thenReturn(seller);
//
//		mockMvc.perform(get("/store/" + storeId)).andExpect(status().isOk());
//
//		verify(storeService, times(1)).findStore(storeId);
//	}
//
//	@Test
//	public void testFindStoreNotFound() throws Exception {
//		final Long storeId = 1L;
//
//		when(storeService.findStore(storeId)).thenReturn(null);
//
//		mockMvc.perform(get("/store/" + storeId)).andExpect(status().isNotFound());
//
//		verify(storeService, times(1)).findStore(storeId);
//	}
//
//}
