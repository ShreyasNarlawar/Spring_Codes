package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Category;
import com.demo.dao.CatDao;

@Service
public class catServImpl implements Catservice{
@Autowired
CatDao cdao;

	@Override
	public boolean updateById(Category C) {
		// TODO Auto-generated method stub
		return cdao.modifybyId(C);
	}

	@Override
	public List<Category> getAllCat() {
		// TODO Auto-generated method stub
		return cdao.displayAll();
	}

	@Override
	public Category getByCid(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id);
	}

	@Override
	public boolean addNewCat(Category c) {
		// TODO Auto-generated method stub
		return cdao.addNew(c);
	}

	@Override
	public boolean deleteCat(int cid) {
		// TODO Auto-generated method stub
		return cdao.removeCat(cid);
	}

}
