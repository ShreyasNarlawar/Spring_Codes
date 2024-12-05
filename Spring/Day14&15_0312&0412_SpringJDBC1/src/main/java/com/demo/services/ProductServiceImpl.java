package com.demo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	Scanner sc = new Scanner(System.in);
	@Autowired
	ProductDao pdao;

	@Override
	public void addProduct() {
		// TODO Auto-generated method stub
		System.out.println("Enter product id");
		int id = sc.nextInt();
		System.out.println("Enter product name");
		String name = sc.next();
		System.out.println("Enter qty");
		int qty = sc.nextInt();
		System.out.println("Enter price");
		double price = sc.nextDouble();
		System.out.println("enter date");
		String dt = sc.next();
		LocalDate date = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter category id");
		int cid = sc.nextInt();
		
		Product p = new Product(id,name,qty,price,date,cid);
		pdao.save(p);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return pdao.removeById(id);
	}

	@Override
	public boolean updateById(int id) {
		
		System.out.println("Enter product name");
		String name = sc.next();
		System.out.println("Enter qty");
		int qty = sc.nextInt();
		System.out.println("Enter price");
		double price = sc.nextDouble();
		System.out.println("enter date");
		String dt = sc.next();
		LocalDate date = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter category id");
		int cid = sc.nextInt();
		
		Product p = new Product(id,name,qty,price,date,cid);
	
		return pdao.modifyById(p);
	}

	@Override
	public List displayAll() {
		// TODO Auto-generated method stub
		return pdao.getAll();
	}

	@Override
	public Product searchById(int id) {
		// TODO Auto-generated method stub
		return pdao.searchProdById(id);
	}

	@Override
	public List<Product> displaybyPrice(double price) {
		// TODO Auto-generated method stub
		return pdao.showByPrice(price);
	}
	
}
