package com.demo.beans;

public class MyUser {
	private String uname;
	private String password;
	private String role;
	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyUser(String uname, String password, String role) {
		super();
		this.uname = uname;
		this.password = password;
		this.role = role;
	}
	public String getUname() {
		return uname;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MyUser [uname=" + uname + ", password=" + password + ", role=" + role + "]";
	}
	
	

}
