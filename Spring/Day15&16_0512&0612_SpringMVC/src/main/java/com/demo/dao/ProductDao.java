package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getProds();

	boolean addProds(Product p);

	boolean updateProduct(Product p);

	boolean removeById(int pid);

	Product getById(int pid);

}
