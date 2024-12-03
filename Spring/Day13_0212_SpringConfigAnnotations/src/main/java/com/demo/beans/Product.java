package com.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	@Value("1")
	private int pid;
	@Value("G310R")
	private String pname;
	@Value("5")
	private int qty;
	
	public Product() {
		super();
	}
	public Product(int pid, String pname,int qty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty=qty;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + "]";
	}
}
