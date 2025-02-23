package com.jbd.todo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbd.todo.dto.PasswordResetRequest;
import com.jbd.todo.dto.UserLoginAuth;
import com.jbd.todo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String createUser(User user) {
		try {
			Session session = sessionFactory.openSession();
			User dbuser = session.get(User.class, user.getUserName());
			if(dbuser == null) {
				session.save(user);
				session.beginTransaction().commit();
				return "User Added Successfully";
			}else {
				return "User Exist Already";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception Occured";
		}
		
	}

	@Override
	public String deleteUser(String userName) {
		try {
			Session session = sessionFactory.openSession();
			
			User dbuser = session.get(User.class, userName);
			
			if(dbuser != null) {
				session.delete(dbuser);
				session.beginTransaction().commit();
				return "User Successfully Deleted";
			}else {
				return "User does not Exist";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception Occured";
			
		}
		
	}

	@Override
	public String updateUser(User user) {
		try {
			Session session = sessionFactory.openSession();
			
			User dbuser = session.get(User.class, user.getUserName());
			
			if(dbuser != null) {
				session.merge(user);
				session.beginTransaction().commit();
				return "User Updated Successfully";
			}else {
				return "User does Not Exist";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception Occured";
		}
	}

	@Override
	public Object loginUser(UserLoginAuth loginUser) {
		try {
			Session session = sessionFactory.openSession();
			
			User dbuser = session.get(User.class, loginUser.getUserName());
			
			if(dbuser != null) {
				if(loginUser.getPassword().equals(dbuser.getPassword())) {
					return dbuser;
				}else {
					return "Wrong Password";
				}
			}else {
				return "User Does Not Exist";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception Occured";
		}
	}

	@Override
	public int checkUser(PasswordResetRequest passwordResetRequest) {
		try {
			Session session = sessionFactory.openSession();
			
			User dbuser = session.get(User.class, passwordResetRequest.getUserName());
			
			if(dbuser != null) {
								
				if(passwordResetRequest.getPhoneNumber().equals(dbuser.getContact())) {
					System.out.println("ENtered");
					return 1;
				}else {
					return 2;
				}
			}else {
				return 3;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
