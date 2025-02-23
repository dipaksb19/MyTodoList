package com.jbd.todo.service;

import com.jbd.todo.dto.UserLoginAuth;
import com.jbd.todo.entity.User;

public interface UserService {

	public String createUser(User user);
	public String deleteUser(String userName);
	public String updateUser(User user);
	public Object loginUser(UserLoginAuth loginUser);
	
}
