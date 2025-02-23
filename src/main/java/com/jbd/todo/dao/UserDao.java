package com.jbd.todo.dao;

import com.jbd.todo.dto.PasswordResetRequest;
import com.jbd.todo.dto.UserLoginAuth;
import com.jbd.todo.entity.User;

public interface UserDao {

	public String createUser(User user);
	public String deleteUser(String userName);
	public String updateUser(User user);
	public Object loginUser(UserLoginAuth loginUser);
	public int checkUser(PasswordResetRequest passwordResetRequest);
}
