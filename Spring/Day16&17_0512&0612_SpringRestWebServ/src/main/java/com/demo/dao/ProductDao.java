package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getAll();

	boolean addNewProd(Product p);

	Product getById(int id);

	boolean modifyById(Product p);

	boolean deleteById(int id);

	List<Product> getByCategoryId(int cid);

}
