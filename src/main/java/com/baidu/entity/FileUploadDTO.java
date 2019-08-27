package com.baidu.entity;

import java.io.File;
import java.util.UUID;
import com.baidu.util.FileUtil;

/**
 * 附件上传帮助类
 * @author chenzg
 * @date 2019年8月22日 下午12:01:50
 */
public class FileUploadDTO {
	/**
	 * 对外显示时使用的文件名(比如待办表.xls)
	 */
	private String openName;

	/**
	 * 服务器上保存时使用的文件名(比如uuid.xls)
	 */
	private String realName;

	/**
	 * 文件在服务器上保存的所在目录
	 */
	private String realDirectory;

	/**
	 * 文件在服务器上保存的真实路径
	 */
	private String realPath;

	/**
	 * 上传结果(0失败,1成功)
	 */
	private Integer result;

	/**
	 * 上传结果文字说明
	 */
	private String message;
	
	public FileUploadDTO() {}

	/**
	 * 根据传入的本地文件信息,初始化某些值
	 */
	public FileUploadDTO(String openName) { // 待办表.xls
		this.openName = openName;
		// 计算文件类型
		String fileType = openName.substring(openName.lastIndexOf(".") + 1); // xls
		// 计算真实保存的文件名
		this.realName = UUID.randomUUID().toString().concat(".").concat(fileType); // b5ee4904-a75a-4ac8-a66e-05b100d9047d.xls
		// 获取服务器根路径
		String nasPath = FileUtil.NAS_PATH; // D:\naspath
		// 获取年月日文件夹路径
		String datePath = FileUtil.getDatePath();// 2019\08\22
		// 计算文件在服务器上保存的所在目录
		this.realDirectory = nasPath.concat(nasPath.endsWith(File.separator) ? "" : File.separator).concat(datePath);// D:\naspath\2019\08\22
		// 计算文件在服务器上保存的真实路径
		this.realPath = this.realDirectory.concat(File.separator).concat(this.realName);// D:\naspath\2019\08\22\b5ee4904-a75a-4ac8-a66e-05b100d9047d.xls
	}
	
	// --------------上传成功或失败时需要set值,后面也需要get值---------------------
	
	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// -------------下面都是自主计算得来的,只需要get值,不需要set值------------------
	
	/**
	 * 获取对外显示时使用的文件名(比如待办表.xls)
	 * @author chenzg
	 * @date 2019年8月26日 下午5:41:10 
	 * @return
	 */
	public String getOpenName() {
		return openName;
	}

	/**
	 * 获取服务器上保存时使用的文件名(比如uuid.xls)
	 * @author chenzg
	 * @date 2019年8月26日 下午5:40:46 
	 * @return
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 获取文件在服务器上保存的真实路径
	 * @author chenzg
	 * @date 2019年8月26日 下午5:40:27 
	 * @return
	 */
	public String getRealPath() {
		return realPath;
	}

	/**
	 * 获取文件在服务器上保存的所在目录
	 * @author chenzg
	 * @date 2019年8月26日 下午5:40:05 
	 * @return
	 */
	public String getRealDirectory() {
		return realDirectory;
	}
}
