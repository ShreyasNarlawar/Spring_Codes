package com.demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.services.ProductService;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

public class TestSpringCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc = new Scanner(System.in);
		ProductService pserv = (ProductService)ctx.getBean("productServiceImpl");
		int ch = 0;
		do {
			System.out.println("\n\t\tMenu\n\n1.add new product\n2.delete product\n3.modify product");
			System.out.println("4.display by id\n5.display all\n6.display by price\n7.exit\n\tchoice: ");
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
					System.out.println("Enter Id for Search");
					id = sc.nextInt();
					Product p = pserv.searchById(id);
					System.out.println(p);
					System.out.println("	___________________________________________________________________________________________________________________");
					break;
				
			case 5:
					List<Product> plist = pserv.displayAll();
					plist.forEach(System.out::println);
					System.out.println("	___________________________________________________________________________________________________________________");
					
					break;
				
			case 6:
					System.out.println("Enter price to view above price products :");
					double price = sc.nextDouble(); 
					List<Product> plist2 = pserv.displaybyPrice(price);
					plist2.forEach(System.out::println);
					System.out.println("	__________________________________________________________________________________________________________________");
					
					break;
				
			case 7:
					System.out.println("THank you..");
					sc.close();
					((ClassPathXmlApplicationContext)ctx).close();
					break;
			default :
					System.out.println("Invalid Input..");
					break;
			}
		}while(ch != 7);
	}

}
