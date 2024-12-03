package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyUSer;

public class TestMyUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("Springconfig.xml");
		MyUSer mu1 = (MyUSer)ctx.getBean(MyUSer.class);
		System.out.println(mu1);
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
