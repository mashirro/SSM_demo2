package com.baidu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.entity.User;
import com.baidu.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<User> findAll(){
		List<User> list = userService.findAll();	
		//分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
		//或者使用PageInfo类,PageInfo包含了非常全面的分页属性
		PageInfo<User> info = new PageInfo<User>(list);
		long total = info.getTotal();
		System.out.println(total);	
		return list;
	}

	@RequestMapping("/getUserById")
	@ResponseBody
	public User getUserById(Integer id) {
		User user = userService.getUserById(id);
		return user;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Integer insert(User user) {
		int count = userService.insert(user);
		return count;
	}
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public Integer insertUser(@RequestBody User user) {
		int count = userService.insert(user);
		return count;
	}
}
