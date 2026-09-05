package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepo;
import com.example.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepo cartRepo;

	@Override
	public Cart saveCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepo.save(cart);
	}

}
