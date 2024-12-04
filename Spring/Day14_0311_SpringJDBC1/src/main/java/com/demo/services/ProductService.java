package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addProduct();

	boolean deleteProduct(int id);

	boolean updateById(int id);

	List displayAll();

	Product searchById(int id);

	List<Product> displaybyPrice();

}
