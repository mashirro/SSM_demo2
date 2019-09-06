package com.baidu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.entity.Function;
import com.baidu.mapper.FunctionMapper;
import com.baidu.service.FunctionService;


@Service
public class FunctionServiceImpl implements FunctionService{

	@Autowired
	private FunctionMapper functionMapper;

	@Override
	public List<Function> getParentMenuList() {
		return functionMapper.getParentMenuList();
	}
}
