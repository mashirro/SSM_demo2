package com.baidu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapper.FunctionMapper;
import com.baidu.service.FunctionService;


@Service
public class FunctionServiceImpl implements FunctionService{

	@Autowired
	private FunctionMapper functionMapper;
	
	
}
