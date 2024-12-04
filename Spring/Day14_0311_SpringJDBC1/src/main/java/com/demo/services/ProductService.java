package com.demo.services;

public interface ProductService {

	void addProduct();

	boolean deleteProduct(int id);

	boolean updateById(int id);

	boolean displayAll();

}
