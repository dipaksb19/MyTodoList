package com.jbd.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbd.todo.config.TwilioConfig;
import com.jbd.todo.dao.UserDao;
import com.jbd.todo.dto.PasswordResetRequest;
import com.jbd.todo.dto.PasswordResetResponse;
import com.jbd.todo.enums.otpStatus;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



@Service
public class TwilioService{

	@Autowired
	private TwilioConfig twilioConfig;

	@Autowired
	private UserDao userDao;

	//key user, value otp
	Map<String, String> otpMap = new HashMap<>();

	// Instead void using spring webflux
	public Mono<PasswordResetResponse> sendOTPForPasswordReset(PasswordResetRequest passwordResetRequest) {

		PasswordResetResponse passwordResetResponse = null;

		int status = userDao.checkUser(passwordResetRequest);
		if(status == 1) {
			try{
				//passwordResetRequest.getPhoneNumber()

				PhoneNumber to = new PhoneNumber("+91".concat(passwordResetRequest.getPhoneNumber()));
				PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
				String otp = generateOTP();

				String otpMessage = "\nDear Customerd, \nYour OTP to reset ToDo List Password is " + otp + "\nThis code is valid for 5 minutes, For your security please do not share this OTP with anyone. \r\n"
						+ "If you did not request this, please contact us immediately.\r\n"
						+ "Thank you,\r\n"
						+ "MyTodo List / DSB Technologies";

				Message message = Message.creator(to, from, otpMessage).create();

				otpMap.put(passwordResetRequest.getUserName(), otp); // this is not recommended way to store user and password should fetch from UI scope or session scope

				passwordResetResponse = new PasswordResetResponse(otpStatus.DELIVIRED, otpMessage);
			}catch(Exception e){
				passwordResetResponse = new PasswordResetResponse(otpStatus.FAILED, e.getMessage());
			}
			return Mono.just(passwordResetResponse);
		}
		return null;

	}

	//6 digit otp
	private String generateOTP() {
		return new DecimalFormat("000000").format(new Random().nextInt(999999));

	}

	public Mono<String> validateOTP(String userInputOtp, String userName){
		if(userInputOtp.equals(otpMap.get(userName))) {
			return Mono.just("OTP Validated Please Enter New Password !");
		}else {
			return Mono.error(new IllegalArgumentException("Invalid OTP Please Retry"));
		}
	}
}
