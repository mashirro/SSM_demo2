package com.baidu.entity;

/**
 * 附件实体类
 * @author chenzg
 * @date 2019年8月26日 上午8:57:35
 */
public class Attachment {
	private String id;

	//对外显示时使用的文件名(比如待办表.xls)
	private String wjm;

	//服务器上保存时使用的文件名(比如uuid.xls)
	private String fjmc;

	//文件保存在服务器中的所在目录
	private String fjlj;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getWjm() {
		return wjm;
	}

	public void setWjm(String wjm) {
		this.wjm = wjm == null ? null : wjm.trim();
	}

	public String getFjmc() {
		return fjmc;
	}

	public void setFjmc(String fjmc) {
		this.fjmc = fjmc == null ? null : fjmc.trim();
	}

	public String getFjlj() {
		return fjlj;
	}

	public void setFjlj(String fjlj) {
		this.fjlj = fjlj == null ? null : fjlj.trim();
	}
}