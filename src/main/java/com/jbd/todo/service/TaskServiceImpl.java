package com.jbd.todo.service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbd.todo.dao.TaskDaoImpl;
import com.jbd.todo.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDaoImpl taskDao;

	@Override
	public String createTask(Task task, String user_name) {
		String taskStatus = taskDao.createTask(task,user_name);
		return taskStatus;
	}

	@Override
	public Object getTask(long id) {
		Object task = taskDao.getTask(id);
		return task;
	}

	@Override
	public String deleteTask(long id) {
		String status = taskDao.deleteTask(id);
		return status;
	}

	@Override
	public Object updateTask(Task task) {
		Object taskStatus = taskDao.updateTask(task);
		return taskStatus;
	}
}
