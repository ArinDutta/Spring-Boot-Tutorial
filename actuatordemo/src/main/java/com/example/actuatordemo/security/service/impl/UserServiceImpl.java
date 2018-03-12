package com.example.actuatordemo.security.service.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.actuatordemo.security.model.User;
import com.example.actuatordemo.security.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Value("#{${users}}")
	private Map<String,String> userMap;
	
	@Value("#{${usersroles}}")
	private Map<String,String> roleMap;

	@Override
	public User getUser(String name) {
		Optional<User> optionalUser=userMap.entrySet()
		.stream()
		.filter(e -> e.getKey().equals(name))
		.map(m -> {
			User user=new User();
			user.setUserName(m.getKey());
			user.setUserName(m.getValue());
			return user;
		}).findAny();
		User u=optionalUser.orElseThrow(() ->new UsernameNotFoundException("User not found"));
		u.setUserRole(getRoles(name));
		return u;
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
