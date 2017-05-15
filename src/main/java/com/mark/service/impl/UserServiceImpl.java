package com.mark.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mark.entity.User;
import com.mark.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public List<User> findAll() {
		
		return null;
	}

	@Override
	public String test() {
		
		return "Hello world";
	}

	
	

}
