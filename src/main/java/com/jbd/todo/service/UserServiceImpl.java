package com.jbd.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbd.todo.dao.UserDaoImpl;
import com.jbd.todo.dto.UserLoginAuth;
import com.jbd.todo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl userDao;
	
	@Override
	public String createUser(User user) {
		String status = userDao.createUser(user);
		return status;
	}

	@Override
	public String deleteUser(String userName) {
		String status = userDao.deleteUser(userName);
		return status;
	}

	@Override
	public String updateUser(User user) {
		String status = userDao.updateUser(user);
		return status;
	}

	@Override
	public Object loginUser(UserLoginAuth loginUser) {
		Object status = userDao.loginUser(loginUser);
		return status;
	}

}
