package com.baidu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.entity.Attachment;
import com.baidu.mapper.AttachmentMapper;
import com.baidu.service.AttachmentService;


@Service
public class AttachmentServiceImpl implements AttachmentService{
	
	@Autowired
	private AttachmentMapper attachmentMapper;

	@Override
	public int insert(Attachment attachment) {
		return attachmentMapper.insert(attachment);
	}

	@Override
	public Attachment selectById(String id) {
		return attachmentMapper.selectByPrimaryKey(id);
	}

}
