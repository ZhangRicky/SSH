package com.mark.service;

import java.util.List;


import com.mark.entity.User;


public interface UserService {
	
	//测试
	String test();
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	List<User> findAll();
	
}
