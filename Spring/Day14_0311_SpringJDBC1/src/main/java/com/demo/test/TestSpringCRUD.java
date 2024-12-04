package com.demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import com.demo.services.*;
public class TestSpringCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc = new Scanner(System.in);
		ProductService pserv = new ProductServiceImpl();
		int ch = 0;
		do {
			System.out.println("1. add new product\n 2. delete product\n 3. modify product\n");
			System.out.println("4. display by id\n 5. display all\n 6. display by price\n7.exit\nchoice: ");
			ch = sc.nextInt();
			switch(ch) {
			case 1:
					pserv.addProduct();
					break;
			case 2:
					System.out.println("Enter id to delete");
					int id = sc.nextInt();
					boolean status = pserv.deleteProduct(id);
					if(status)
						System.out.println("Product deleted successfully");
					else
						System.out.println("error occured");
					break;
			case 3:
					System.out.println("Enter id for update");
					id = sc.nextInt();
					status = pserv.updateById(id);
					if(status)
						System.out.println("Product updated successfully");
					else
						System.out.println("not found");
					break;
			case 4:
					status = pserv.displayAll();
					break;
			}
		}while(ch != 7);
	}

}
