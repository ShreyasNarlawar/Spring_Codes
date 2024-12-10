package com.demo.dao;

import java.util.List;

import com.demo.beans.Category;

public interface CatDao {

	boolean modifybyId(Category C);

	List<Category> displayAll();

	Category findById(int id);

	boolean addNew(Category c);

	boolean removeCat(int cid);

}
