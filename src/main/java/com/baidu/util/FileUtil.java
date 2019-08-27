package com.baidu.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import javax.servlet.http.HttpServletResponse;

import com.baidu.entity.FileUploadDTO;

public class FileUtil {
	// 文件根路径------>java中 \ 是转义字符
	public static final String NAS_PATH = "D:\\naspath";

	// 取得年月日文件夹
	public static String getDatePath() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datapath = sdf.format(new Date()).replaceAll("-", Matcher.quoteReplacement(File.separator));
		return datapath;
	}

	/**
	 * 上传附件到服务器
	 * 
	 * @author chenzg
	 * @date 2019年8月23日 上午10:24:07
	 * @param inputStream
	 * @param openName
	 * @return
	 */
	public static FileUploadDTO uploadAttachment(InputStream inputStream, String openName) {
		FileUploadDTO uploadDTO;
		int fileSize = 0;
		try {
			fileSize = inputStream.available();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (fileSize == 0) {
			uploadDTO = new FileUploadDTO();
			uploadDTO.setResult(0);
			uploadDTO.setMessage("文件上传失败: 文件为空!");
			return uploadDTO;
		}
		// 初始化uploadDTO
		uploadDTO = new FileUploadDTO(openName);
		// 根据远程目录创建file实例
		File file = new File(uploadDTO.getRealDirectory());
		if (!file.exists()) {
			// 若远程目录不存在,则创建
			file.mkdirs();
		}
		// 文件输出流
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(uploadDTO.getRealPath());
			int len;
			byte[] byteArray = new byte[2048];
			// 从输入流中读取一些字节(b的长度).并存储到缓冲区数组中,如果流位于文件末尾而没有字节可用，则返回值-1
			while ((len = inputStream.read(byteArray)) != -1) {
				fos.write(byteArray, 0, len);
			}
			return uploadDTO;
		} catch (Exception e) {
			uploadDTO = new FileUploadDTO();
			uploadDTO.setMessage("文件上传失败!");
			uploadDTO.setResult(0);
			return uploadDTO;
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 附件下载
	 * @author chenzg
	 * @date 2019年8月23日 上午11:58:47 
	 * @param response	
	 * @param realPath	文件在服务器上保存的真实路径
	 * @param openName	下载附件时显示的名字(对外显示时使用的文件名(比如待办表.xls))
	 */
	public static void downloadAttachment(HttpServletResponse response, String realPath, String openName) {
		//清空输出流
		response.reset();
		BufferedInputStream bis=null;
		OutputStream os=null;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File(realPath)));
			os = response.getOutputStream();
			response.setCharacterEncoding("UTF-8");
			// 设定响应头(如果下载的是中文文件名，则会乱码，需要用url编码)
			response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(openName, "UTF-8"));
			// 定义输出类型
			response.setContentType("application/x-msdownload");
			int len;
			byte[] byteArray = new byte[2048];
			// 从输入流中读取一些字节(b的长度).并存储到缓冲区数组中,如果流位于文件末尾而没有字节可用，则返回值-1
			while ((len = bis.read(byteArray)) != -1) {
				os.write(byteArray, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(os!=null) {
					os.close();
				}
				if(bis!=null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
