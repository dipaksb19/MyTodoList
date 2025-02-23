package com.jbd.todo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jbd.todo.enums.Priority;
import com.jbd.todo.enums.Status;

@Entity
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "task_name", nullable = false, unique = false)
	private String taskName;
	
	@Column(name = "description", nullable = false, unique = false)
	private String description;
	
	@Column(name = "status", nullable = false, unique = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "priority", nullable = false, unique = false)
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Column(name = "creation_date", nullable = false, unique = false)
	private LocalDateTime creationDate;
	
	@Column(name = "due_date", nullable = false, unique = false)
	private LocalDateTime dueDate;
	@Column(name = "user_id", nullable = false, unique = false)
	private String user_id;
	
	
	Task (){
		
	}

	public Task(long id, String taskName, String description, Status status, Priority priority,
			LocalDateTime creationDate, LocalDateTime dueDate, String user_id) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.user_id = user_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", description=" + description + ", status=" + status
				+ ", priority=" + priority + ", creationDate=" + creationDate + ", dueDate=" + dueDate + ", user="
				+  "]";
	}


	
	
	
}
