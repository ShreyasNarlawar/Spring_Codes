package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProds();
	
	public boolean addNewProduct(Product p);
	
	Product getById(int id);
	
	boolean updateById(Product p);
	
	boolean removeById(int id);

	List<Product> findByCategory(int cid);

}
