package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServImpl implements ProductService{
@Autowired
ProductDao pdao;
	
	@Override
	public List<Product> getAllProds() {
		// TODO Auto-generated method stub
		return pdao.getProds();
	}

	@Override
	public boolean addNewProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.addProds(p);
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.updateProduct(p);
	}

	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		return pdao.removeById(pid);
	}

	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.getById(pid);
	}

}
