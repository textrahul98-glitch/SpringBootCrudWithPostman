package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.model.User;
import com.example.demo.service.CartService;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="User", description=" User API Information")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	@PostMapping("/save") //// http://localhost:8080/user/save
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);

	}

	@PostMapping("/saveCartUser") //// http://localhost:8080/user/saveCartUser
	public ResponseEntity<User> saveCartUser(@RequestBody User user) {

		User saveUser=userService.saveUser(user);
		for (Cart carts : user.getCarts()) {

			carts.setUserCartId(saveUser.getId());
			cartService.saveCart(carts);

		}

		return ResponseEntity.ok().body(user);

	}

}
