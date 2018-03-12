package com.example.actuatordemo.security.service.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.actuatordemo.security.model.User;
import com.example.actuatordemo.security.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Value("#{${users}}")
	private Map<String,String> userMap;
	
	@Value("#{${usersroles}}")
	private Map<String,String> roleMap;

	@Override
	public User getUser(String name) {
		return userMap.entrySet()
		.stream()
		.filter(e -> e.getKey().equals(name))
		.map(m -> {
			User user=new User();
			user.setUserName(m.getKey());
			user.setUserPassword(m.getValue());
			user.setUserRole(getRoles(name));
			return user;
		}).findAny().orElseThrow(() ->new UsernameNotFoundException("User not found"));
	}

	@Override
	public Set<String> getRoles(String name) {
		return roleMap.entrySet()
		.stream()
		.filter(e -> e.getKey().equals(name)).map(
		  m -> {
			  StringTokenizer st=new StringTokenizer(m.getValue(),",");
			  Set<String> roleSet=new HashSet<String>();
			  while(st.hasMoreTokens()) {
				  roleSet.add(st.nextToken());
			  }
			  return roleSet;
		  }
        ).findAny().orElse(new HashSet<String>());
	}

}
