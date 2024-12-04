package com.demo.dao;

import com.demo.beans.Product;

public interface ProductDao {

	void save(Product p);

	boolean removeById(int id);

	boolean modifyById(int id);

	boolean getAll();

}
