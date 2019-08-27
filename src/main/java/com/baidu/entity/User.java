package com.baidu.entity;

import java.util.Objects;

public class User {
	private Long id;
	private String username;
	private String password;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User user = (User) obj;
		//如果两个参数都为 null， Objects.equals(a，b) 调用将返回 true ; 如果其中一个参数为 null ,则返回 false ; 否则， 如果两个参数都不为 null，则调用 a.equals(b)。
		return Objects.equals(id,user.id)&&Objects.equals(username,user.username)&&Objects.equals(password,user.password);
	}
	
	@Override
	public int hashCode() {
		//返回一个散列码，由提供的所有对象的散列码组合而得到。
		return Objects.hash(id,username,password);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
