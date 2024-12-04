package com.demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;
import java.util.Scanner;
import java.util.spi.ResourceBundleControlProvider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
public class TestLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc = new Scanner (System.in);
		int ch = 0;
		do {
			System.out.println("1.US English \n2. UK English \n3. Marathi \n4. Other \n5.Exit");
			System.out.println("Enter choice : ");
			MessageSource ms = (MessageSource)ctx.getBean(ResourceBundleMessageSource.class);
			String m = null,w = null,d = null,c = null;
			ch = sc.nextInt();
			Locale locale = null;
			switch(ch) {
			case 1 :
				locale = Locale.US;
				System.out.println("Country :"+locale.getCountry()+" "+"Languange : "+locale.getLanguage());
				break;
			case 2:
				locale = Locale.UK;
				System.out.println("Country :"+locale.getCountry()+" "+"Languange : "+locale.getLanguage());
				break;
			case 3:
				locale = new Locale("marathi","maharashtra");
				System.out.println("Country :"+locale.getCountry()+" "+"Language : "+locale.getLanguage());
				break;
			case 4:
				locale = new Locale("aa","test");
				break;
			case 5:
				System.out.println("Thank you for visiting ..");
				break;
			default:
				System.out.println("Invalid choice");	
				break;
			}
			m = ms.getMessage("msg.pay",null,locale);
			w = ms.getMessage("msg.welcome",new Object[] {"Shreyas"},locale);
			d = ms.getMessage("msg.data",null,locale);
			c = ms.getMessage("msg.currency",null,locale);
			
			System.out.println("pay :"+ m);
			System.out.println("welcome :"+ w);
			System.out.println("data :"+ d);
			System.out.println("currency :"+ c);
		}while(ch != 5 );
	}

}
