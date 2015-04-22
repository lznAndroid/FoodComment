package com.znli.foodcomment.bean;

public class User {
	private String name;
	private int id;
	private String password;
	private String nickName;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, int id, String password, String nickName) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.nickName = nickName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", password=" + password
				+ ", nickName=" + nickName + "]";
	}

}
