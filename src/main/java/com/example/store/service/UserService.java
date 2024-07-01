package com.example.store.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.store.entity.User;

public interface UserService {
	User signUp(User newUser);

	UserDetails loadUserByUsername(String username);
}
