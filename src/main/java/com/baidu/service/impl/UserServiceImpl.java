package com.baidu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.entity.User;
import com.baidu.mapper.UserMapper;
import com.baidu.service.UserService;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() {
		//在你需要进行分页的 MyBatis 查询方法前调用 PageHelper.startPage 静态方法即可，紧跟在这个方法后的第一个MyBatis 查询方法会被进行分页。
		PageHelper.startPage(1, 5, true);		//true:表示进行count查询
		return userMapper.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

}
