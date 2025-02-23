package com.jbd.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbd.todo.entity.User;
import com.jbd.todo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/create-user")
	public String createUser(@RequestBody User user) {
		String status = userService.createUser(user);
		return status;
		
	}
	
	@DeleteMapping("/delete-user/{userName}")
	public String deleteUser(@PathVariable String userName ) {
		String status = userService.deleteUser(userName);
		return status;
		
	}
	
	@PutMapping("/update-user")
	public String updateUser(@RequestBody User user) {
		String status = userService.updateUser(user);
		return status;
	}
}
