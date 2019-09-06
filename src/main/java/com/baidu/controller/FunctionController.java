package com.baidu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.entity.Function;
import com.baidu.service.FunctionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/function")
public class FunctionController {
	
	@Autowired
	private FunctionService functionService;

	/**
	 * 获取树形菜单list
	 * @author chenzg
	 * @date 2019年9月6日 下午3:40:39 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMenuList")
	public List<Function> getMenuList(){
		
		return null;
	}
}
