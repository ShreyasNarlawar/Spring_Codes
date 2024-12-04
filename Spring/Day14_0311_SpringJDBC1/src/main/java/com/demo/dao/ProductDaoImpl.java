package com.demo.dao;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public void save(Product p) {
		// TODO Auto-generated method stub
		int n = jdbctemplate.update("insert into product values(?,?,?,?,?,?)",new Object[] {
			p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid()
		});
	}

	@Override
	public boolean removeById(int id) {
		// TODO Auto-generated method stub
		int n = jdbctemplate.update("delete from product where id = ?");
		if(n > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean modifyById(int id) {
		// TODO Auto-generated method stub
		int n = jdbctemplate.update("update from product set pname=?,set qty=?,set price=?,set ldt=?,set cid=? where pid=?");
		if(n> 0)
			return true;
		return false;
	}

	@Override
	public boolean getAll() {
		// TODO Auto-generated method stub
//		ResultSet rs = jdbctemplate.query("select * from product");
		
		
		return false;
	}
	
}
