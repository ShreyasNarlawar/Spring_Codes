package com.demo.SpringBootCRUD_MVC.service;

import java.util.List;

import com.demo.SpringBootCRUD_MVC.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	boolean addNewProd(Product p);

	Product GetById(int pid);

	boolean updateProd(Product p);

	boolean deleteById(int pid);

}
