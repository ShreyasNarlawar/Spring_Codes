package com.demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.demo.beans.Category;
import com.demo.beans.Product;

import org.springframework.context.ApplicationContext;

public class TestProperPlaceHolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Product p1 = (Product)ctx.getBean(Product.class);
		System.out.println(p1);
//		Category c1 =(Category)ctx.getBean(Category.class);
//		System.out.println(c1);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
