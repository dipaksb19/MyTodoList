package com.jbd.todo.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbd.todo.entity.Task;
import com.jbd.todo.entity.User;


@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public String createTask(Task task, String user_name) {
		try {
			Session session = sessionFactory.openSession();
			
			User dbuser = session.get(User.class, user_name);
			
			if(dbuser != null) {
	
					task.setUser_id(user_name);
			//		task.setUser(user_name);
			//		dbuser.setTask((Set<Task>) task);
					session.saveOrUpdate(task);
					session.beginTransaction().commit();
					return "Task Added Successfully";
			
			}else {
				return "User Does Not Exist";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception Occured";
		}
	}

	@Override
	public Object getTask(long id) {
		try {
			Session session = sessionFactory.openSession();
			Task dbtask = session.get(Task.class, id);
			if(dbtask != null) {
				session.beginTransaction().commit();
				return dbtask;
			}else {
				return "Task Does Not Exist of Given Id";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception Occured";
		}
		
	}

	@Override
	public String deleteTask(long id) {
		try {
			Session session = sessionFactory.openSession();
			
			Task dbuser = session.get(Task.class, id);
			
			if(dbuser != null) {
				session.delete(dbuser);
				session.beginTransaction().commit();
				return "Task Deleted Successfully";
			}else {
				return "Task Does Not Exist";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception Occured";
		}
		
	}

	@Override
	public Object updateTask(Task task) {
		try {
			Session session = sessionFactory.openSession();
			
			Task dbuser = session.get(Task.class,task.getId());
			
			if(dbuser != null) {
				session.merge(task);
				session.beginTransaction().commit();
				return task + "Task Updated Successfully";
			}else {
				return "Task does not Exist";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception Occured";
		}
	
	}
}
