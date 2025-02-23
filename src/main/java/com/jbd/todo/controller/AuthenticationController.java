package com.jbd.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbd.todo.dto.PasswordResetRequest;
import com.jbd.todo.dto.PasswordResetResponse;
import com.jbd.todo.dto.UserLoginAuth;
import com.jbd.todo.entity.User;
import com.jbd.todo.service.TwilioService;
import com.jbd.todo.service.UserServiceImpl;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private TwilioService twilioService;
	
	private UserController userController;
	
	@PostMapping("/login")
	public Object loginUser(@RequestBody UserLoginAuth loginUser) {
		Object status = userService.loginUser(loginUser);
		return status;
		
	}
	
	
	@PostMapping("/forgetpass")
	public Mono<PasswordResetResponse> forgetPass(@RequestBody PasswordResetRequest passwordResetRequest ){
		return twilioService.sendOTPForPasswordReset(passwordResetRequest);
	}
	
	@PostMapping("/validate")
	public Mono<String> validateOTP(@RequestBody PasswordResetRequest passwordResetRequest) {
		return twilioService.validateOTP(passwordResetRequest.getOneTimePassword(), passwordResetRequest.getUserName());
	}
	
	
	@PostMapping("/newpass")
	public String newPass(@RequestBody User user) {
		String status = userController.updateUser(user);
		return status;
	}

}
