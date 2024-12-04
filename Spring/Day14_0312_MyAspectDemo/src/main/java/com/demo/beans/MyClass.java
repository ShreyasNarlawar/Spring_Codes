package com.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
	public void m1() {
		System.out.println("In m1 Method.");
	}
	public void m2() {
		System.out.println("In m2 Method.");
	}
	public void m3(int a) {
		System.out.println("In m3 Method."+a);
	}
	public void newLike() {
		System.out.println("In newLike method");
	}
}
