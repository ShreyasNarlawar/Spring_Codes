package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void save(Product p);

	boolean removeById(int id);

	boolean modifyById(Product p);

	List getAll();

	Product searchProdById(int id);

	List<Product> showByPrice(double price);

}
