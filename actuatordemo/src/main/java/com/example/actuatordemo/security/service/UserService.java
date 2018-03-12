package com.example.actuatordemo.security.service;

import java.util.Set;

import com.example.actuatordemo.security.model.User;

public interface UserService {
	
	User getUser(String name);
	Set<String> getRoles(String name);

}
