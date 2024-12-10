package com.demo.DemoProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DemoProject.beans.Product;
import com.demo.DemoProject.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductDao pdao;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public boolean addNewProd(Product p) {
		// TODO Auto-generated method stub
		Product p1= pdao.save(p);
		return p1!=null;
	}

	@Override
	public Product GetById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> op= pdao.findById(pid);
		if(op.isPresent())
			return op.get();
		return null;
	}

	@Override
	public boolean updateProd(Product p) {
		// TODO Auto-generated method stub
		Optional<Product>op = pdao.findById(p.getPid());
		if(op.isPresent()) {
			Product p2=op.get();
			p2.setPname(p.getPname());
			p2.setQty(p.getQty());
			p2.setPrice(p.getPrice());
			pdao.save(p2);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> op = pdao.findById(pid);
		if(op.isPresent()) {
			pdao.delete(op.get());
			return true;
		}
		return false;
	}

}
