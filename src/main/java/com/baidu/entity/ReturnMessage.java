package com.baidu.entity;


/**
 * 统一结果返回类
 * @author chenzg
 * @date 2019年8月23日 下午5:36:01 
 * @param <T> 泛型
 */
public class ReturnMessage<T> {
	//返回信息描述
	private String message;
	
	//返回代码
	private Integer code;
	
	//返回数据实体
	private T data;
	
	private ReturnMessage(String message, Integer code, T data) {
		this.message = message;
		this.code = code;
		this.data = data;
	}
	
	/**
	 * 成功时调用
	 * @author chenzg
	 * @date 2019年8月23日 下午5:54:01 
	 * @param data	成功时返回数据
	 * @return
	 */
	public static<T> ReturnMessage<T> success(T data) {
		return new ReturnMessage<T>("成功",200,data);
	}
	
	/**
	 * 失败时调用
	 * @author chenzg
	 * @date 2019年8月23日 下午5:51:33 
	 * @param message	失败时返回信息
	 * @return
	 */
	public static<T> ReturnMessage<T> error(String message) {
		return new ReturnMessage<T>(message,500,null);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
