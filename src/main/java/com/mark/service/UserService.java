package com.mark.service;

import java.util.List;


import com.mark.entity.User;


public interface UserService {
	
	//����
	String test();
	
	/**
	 * ��ѯ���е��û�
	 * @return
	 */
	List<User> findAll();
	
}
