package com.baidu.mapper;

import java.util.List;

import com.baidu.entity.User;

public interface UserMapper {
	
	List<User> findAll();

	User getUserById(Integer id);
	
	int insert(User user);

}
