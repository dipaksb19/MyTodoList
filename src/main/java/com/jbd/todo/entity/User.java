package com.jbd.todo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	@Column(name = "full_name",nullable = false, unique = false)
	private String fullName;
	
	@Column(name = "contact", nullable = false, unique = false)
	private String contact;
	
	@Column(name = "e_mail", nullable = false, unique = false)
	private String email;
	
	@Id
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	
	@Column(name = "password", nullable = false, unique = true)
	private String password;
	
	//Mapping
	@OneToMany(cascade = CascadeType.ALL) //mappedBy = "user"
	@JoinColumn(name = "user_id", referencedColumnName = "user_name")
	private List<Task> task = new ArrayList<>();
	
	User(){
		
	}

	public User(String fullName, String contact, String email, String userName, String password) {
		super();
		this.fullName = fullName;
		this.contact = contact;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", contact=" + contact + ", email=" + email + ", userName=" + userName
				+ ", password=" + password + ", task=" + task + "]";
	}

	

}
