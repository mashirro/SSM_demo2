package com.baidu.service;

import java.util.List;

import com.baidu.entity.Function;

public interface FunctionService {

	/**
	 * 获取根节点list
	 * @author chenzg
	 * @date 2019年9月6日 下午3:54:59 
	 * @return
	 */
	List<Function> getParentMenuList();

	/**
	 * 根据parentId获取子菜单list
	 * @author chenzg
	 * @date 2019年9月6日 下午4:47:12 
	 * @param parentId
	 * @return
	 */
	List<Function> getChildren(String parentId);

}
