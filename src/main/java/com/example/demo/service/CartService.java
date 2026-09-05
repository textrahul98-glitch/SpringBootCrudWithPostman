package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;

@Service
public interface CartService {
	
	public Cart saveCart(Cart cart);

}
