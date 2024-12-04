package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Before("execution(* com.demo.beans.*.m3*(..))")
	public void beforeAdvice(){
		System.out.println("In Before Advice 111");
	}
	
	@After ("execution(* com.demo.beans.*.m3*(..))")
	public void afterAdvice() {
		System.out.println("In After Advice 111");
	}
	
	@Around("execution(* com.demo.beans.*.m*(..))")
	public Object aroundAdviseStart(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("In Around Advise Start method before Method Calling...");
		Object ob=pjp.proceed();
		System.out.println("In Around Advise Start method After Method Calling...");
		return ob;
	}
}
