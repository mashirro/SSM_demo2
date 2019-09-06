package com.baidu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.entity.Function;
import com.baidu.service.FunctionService;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/function")
public class FunctionController {

	@Autowired
	private FunctionService functionService;

	/**
	 * 获取根节点list
	 * 
	 * @author chenzg
	 * @date 2019年9月6日 下午3:40:39
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMenuList")
	public List<Function> getMenuList() {
		// 先获取顶级节点list(一级菜单)
		List<Function> parentList = functionService.getParentMenuList();
		for (Function function : parentList) {
			// 获取子菜单list
			function.setChildren(getChildren(function.getId()));
		}
		return parentList;
	}

	/**
	 * getChildren()方法传入父菜单id查询出其子菜单list，然后递归调用getChildren()方法 实现树形菜单结构树
	 * 
	 * @author chenzg
	 * @date 2019年9月6日 下午4:39:38
	 * @return
	 */
	@RequestMapping("/getChildren")
	@ResponseBody
	public List<Function> getChildren(String parentId) {
		List<Function> children = functionService.getChildren(parentId);
		for (Function function : children) {
			function.setChildren(getChildren(function.getId()));
		}
		return children;
	}
}
