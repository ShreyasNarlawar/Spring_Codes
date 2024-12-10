package com.demo.DemoProject.service;

import java.util.List;

import com.demo.DemoProject.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	boolean addNewProd(Product p);

	Product GetById(int pid);

	boolean updateProd(Product p);

	boolean deleteById(int pid);

}
