package com.baidu.service;

import com.baidu.entity.Attachment;

public interface AttachmentService {

	/**
	 * 插入附件表
	 * @author chenzg
	 * @date 2019年8月26日 下午5:44:07 
	 * @param attachment
	 * @return
	 */
	int insert(Attachment attachment);
	
	/**
	 * 根据主键查询附件
	 * @author chenzg
	 * @date 2019年8月26日 下午8:30:36 
	 * @param id
	 * @return
	 */
	Attachment selectById(String id);
}
