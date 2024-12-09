package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao pdao;

	@Override
	public List<Product> getAllProds() {
		// TODO Auto-generated method stub
		return pdao.getAll();
	}
	
	public boolean addNewProduct(Product p) {
		return pdao.addNewProd(p);
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return pdao.getById(id);
	}

	@Override
	public boolean updateById(Product p) {
		// TODO Auto-generated method stub
		return pdao.modifyById(p);
	}

	@Override
	public boolean removeById(int id) {
		// TODO Auto-generated method stub
		return pdao.deleteById(id);
	}

	@Override
	public List<Product> findByCategory(int cid) {
		// TODO Auto-generated method stub
		return pdao.getByCategoryId(cid);
	}
}
