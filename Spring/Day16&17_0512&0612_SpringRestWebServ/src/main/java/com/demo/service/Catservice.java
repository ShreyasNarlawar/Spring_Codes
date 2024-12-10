package com.demo.service;

import java.util.List;

import com.demo.beans.Category;

public interface Catservice {

	List<Category> getAllCat();

	Category getByCid(int id);

	boolean addNewCat(Category c);

	boolean deleteCat(int cid);

	boolean updateById(Category C);

}
