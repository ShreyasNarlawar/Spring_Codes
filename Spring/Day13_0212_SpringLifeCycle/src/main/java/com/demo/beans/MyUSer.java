package com.demo.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyUSer implements ApplicationContextAware,BeanNameAware,InitializingBean,DisposableBean{
	private int pid;
	private String pname;
	public MyUSer() {
		super();
		System.out.println("In Default Constructor");
	}
	public MyUSer(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
		System.out.println("In Parameterized Constructor");
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		System.out.println("In Pid Setter Method");
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "MyUSer [pid=" + pid + ", pname=" + pname + "]";
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("In destroy Method");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("In after Properties Set Method");
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("In set Bean Name :"+name);
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("In set Application Context");
	}
	public void myinit() {
		System.out.println("in myinit method");
	}
	public void mydestroy() {
		System.out.println("in mydestroy method");
	}
}
