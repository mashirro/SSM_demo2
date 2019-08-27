package com.baidu.mapper;

import com.baidu.entity.Attachment;

public interface AttachmentMapper {
	//----------使用mybatis代码生成器生成----------------
    int deleteByPrimaryKey(String id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
    //----------使用mybatis代码生成器生成----------------
}