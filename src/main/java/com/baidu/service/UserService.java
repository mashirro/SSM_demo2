package com.baidu.service;

import java.util.List;

import com.baidu.entity.User;

public interface UserService {

	List<User> findAll();

	User getUserById(Integer id);
	
	int insert(User user);

}
