package com.baidu.mapper;

import java.util.List;

import com.baidu.entity.Function;

public interface FunctionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);

    /**
     * 获取根节点list
     * @author chenzg
     * @date 2019年9月6日 下午3:57:26 
     * @return
     */
	List<Function> getParentMenuList();

	/**
	 * 根据parentId获取子菜单list
	 * @author chenzg
	 * @date 2019年9月6日 下午4:47:54 
	 * @param parentId
	 * @return
	 */
	List<Function> getChildren(String parentId);
}