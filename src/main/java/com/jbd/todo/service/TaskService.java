package com.jbd.todo.service;

import java.util.ArrayList;
import java.util.HashSet;

import com.jbd.todo.entity.Task;

public interface TaskService {
	public String createTask(Task task, String user_name);
	public Object getTask(long id);
	public String deleteTask(long id);
	public Object updateTask( Task task);

}
