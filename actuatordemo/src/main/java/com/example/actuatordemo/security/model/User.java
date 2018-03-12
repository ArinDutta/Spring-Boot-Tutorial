package com.example.actuatordemo.security.model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2585357112568793048L;
	private String userName;
	private String userPassword;
	private Set<String> userRole;
	
	public User() {
		super();
	}
	
	public User(User u) {
		this.userName=u.userName;
		this.userPassword=u.userPassword;
		this.userRole=u.userRole;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Set<String> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<String> userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", userRole=" + userRole + "]";
	}
	
}
