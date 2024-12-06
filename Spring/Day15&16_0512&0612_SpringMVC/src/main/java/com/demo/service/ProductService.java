package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProds();

	boolean addNewProduct(Product p);

	boolean updateProduct(Product p);

	boolean deleteById(int pid);

	Product getById(int pid);

}
