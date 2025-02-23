package com.jbd.todo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jbd.todo.config.TwilioConfig;
import com.twilio.Twilio;

@SpringBootApplication
public class MyTodoListApplication {
	
	@Autowired
	private TwilioConfig twilioConfig;
	
	@PostConstruct  // it will act as a init method
	public void initTwilio() {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(MyTodoListApplication.class, args);
		System.out.println("---Project Running---");
	}

}
