package com.example.store.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "ORDER")
public interface UserServiceClient {
	@GetMapping("order/test")
	void getTest();
}
