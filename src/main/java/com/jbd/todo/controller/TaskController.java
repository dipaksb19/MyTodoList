package com.jbd.todo.controller;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbd.todo.entity.Task;
import com.jbd.todo.service.TaskServiceImpl;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskService;


	@PostMapping("/add-task/{user_name}")
	public String createTask(@RequestBody Task task,@PathVariable String user_name) {
		String taskStatus = taskService.createTask(task, user_name);
		return taskStatus;
		
	}
	
	@GetMapping("/get-task")
	public Object getTask(@RequestParam long id) {
		Object task = taskService.getTask(id);
		return task;
	}
	
	@DeleteMapping("/delete-task/{id}")
	public String deleteTask(@PathVariable long id) {
		String status = taskService.deleteTask(id);
		return status;
	}
	
	@PutMapping("/update-task")
	public Object updateTask(@RequestBody Task task) {
		Object taskStatus = taskService.updateTask(task);
		return taskStatus;
	}

}
