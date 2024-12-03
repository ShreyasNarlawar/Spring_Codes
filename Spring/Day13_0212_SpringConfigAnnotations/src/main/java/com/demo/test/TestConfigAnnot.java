package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Category;
import com.demo.beans.Product;

public class TestConfigAnnot {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Product p = (Product)ctx.getBean(Product.class);
		Category c = (Category)ctx.getBean(Category.class);
		System.out.println(p);
		System.out.println(c);
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
