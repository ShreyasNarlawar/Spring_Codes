package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyClass;

public class TestAspect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		MyClass mc = (MyClass)ctx.getBean(MyClass.class);
		mc.m1();
		mc.m3(56441);
	}

}
