package com.jbd.todo.dto;

import com.jbd.todo.enums.otpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetResponse {

	private otpStatus status;
	private String message;
	
	
}
