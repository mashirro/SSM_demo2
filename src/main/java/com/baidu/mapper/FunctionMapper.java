package com.baidu.mapper;

import com.baidu.entity.Function;

public interface FunctionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
}