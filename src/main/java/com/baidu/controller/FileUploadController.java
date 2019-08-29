package com.baidu.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.baidu.entity.Attachment;
import com.baidu.entity.FileUploadDTO;
import com.baidu.entity.ReturnMessage;
import com.baidu.service.AttachmentService;
import com.baidu.util.FileUtil;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	private AttachmentService attachmentService;
	
//	@RequestMapping("/upload")
//	@ResponseBody
//	public ReturnMessage<String> fileUpload(HttpServletRequest request) {
//		if(request instanceof MultipartHttpServletRequest) {
//			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
//			//生成附件id
//			String attachmentId = UUID.randomUUID().toString();
//			MultipartFile file = mRequest.getFile("fileinput");
//			try {
//				//上传附件到服务器
//				FileUploadDTO uploadDTO = FileUtil.uploadAttachment(file.getInputStream(), file.getOriginalFilename());
//				//写入数据库记录
//				Attachment attachment = new Attachment();
//				attachment.setId(attachmentId);
//				attachment.setWjm(file.getOriginalFilename());
//				attachment.setFjlj(uploadDTO.getRealDirectory());
//				attachment.setFjmc(uploadDTO.getRealName());
//				attachmentService.insert(attachment);
//				//将附件id返回----->下载时使用
//				return ReturnMessage.success(attachmentId);
//			} catch (IOException e) {
//				logger.error("附件上传失败:"+e);
//				return ReturnMessage.error("附件上传失败!");
//			}
//		}else {
//			return ReturnMessage.error("附件上传失败!");
//		}
//	}
	
	
	@RequestMapping("/upload")
	@ResponseBody
	public ReturnMessage<String> fileUpload(MultipartFile file) {
		//生成附件id
		String attachmentId = UUID.randomUUID().toString();
		try {
			//上传附件到服务器
			FileUploadDTO uploadDTO = FileUtil.uploadAttachment(file.getInputStream(), file.getOriginalFilename());
			//写入数据库记录
			Attachment attachment = new Attachment();
			attachment.setId(attachmentId);
			attachment.setWjm(file.getOriginalFilename());
			attachment.setFjlj(uploadDTO.getRealDirectory());
			attachment.setFjmc(uploadDTO.getRealName());
			attachmentService.insert(attachment);
			//将附件id返回----->下载时使用
			return ReturnMessage.success(attachmentId);
		} catch (IOException e) {
			logger.error("附件上传失败,请联系管理员:"+e);
			return ReturnMessage.error("附件上传失败!");
		}
	}
	
	/**
	 * 文件下载
	 * @author chenzg
	 * @throws IOException 
	 * @date 2019年8月26日 下午8:28:58
	 */
	@RequestMapping("/download")
	public void download(String id,HttpServletResponse response){
		logger.info("入参【获取下载文件id：id=" + id + "】");
		Attachment attachment = attachmentService.selectById(id);
		// 文件在服务器上保存的真实路径
		String realPath = attachment.getFjlj().concat(File.separator).concat(attachment.getFjmc());
		File file = new File(realPath);
		if(file.exists()) {
			FileUtil.downloadAttachment(response, realPath, attachment.getWjm());
		}else {
			logger.error("文件不存在:下载失败!");
		}
	}
}
