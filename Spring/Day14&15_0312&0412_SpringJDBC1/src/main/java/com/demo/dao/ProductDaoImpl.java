package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public void save(Product p) {
		// TODO Auto-generated method stub
		int cnt=jdbctemplate.update("insert into product values(?,?,?,?,?,?)",new Object[] {
			p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid()
		});
		if(cnt>0)
			System.out.println(cnt+" Rows Updated.");
		else
			System.out.println("Error Occured..");
	}

	@Override
	public boolean removeById(int id) {
		// TODO Auto-generated method stub
		int n = jdbctemplate.update("delete from product where pid = ?",new Object[] {id});
		if(n > 0)
			return true;
		return false;
	}

	@Override
	public boolean modifyById(Product p) {
		// TODO Auto-generated method stub
		int n = jdbctemplate.update("update product set pname=?, qty=?,price=?, date=?, cid=? where pid=?",new Object[] {
				p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid(),p.getPid()
		});
		if(n> 0)
			return true;
		return false;
	}

	@Override
	public List<Product> getAll() {
		String sql = "select * from product"; 
		// Use JdbcTemplate to execute query and map ResultSet to Product objects 
		return jdbctemplate.query(sql, new RowMapper<Product>() {
			@Override public Product mapRow(ResultSet rs, int rowNum) throws SQLException { 
				Product product = new Product(); 
				product.setPid(rs.getInt("pid")); 
				product.setPname(rs.getString("pname")); 
				product.setQty(rs.getInt("qty")); 
				product.setPrice(rs.getDouble("price")); 
				product.setLdt(rs.getDate("date").toLocalDate());
				product.setCid(rs.getInt("cid")); 
				return product; }
			});
	}

	@Override
	public Product searchProdById(int id) {
		try{
			String sql = "select * from product where pid = ?";
			// Use JdbcTemplate to execute query and map ResultSet to 
			Product p= jdbctemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(Product.class));
			return p;
		}catch(Exception e){
			System.out.println("Exception Found while finding Product..\n Product Not Found..");
			return null;
		}
	}	

	public List<Product> showByPrice(double price) {
		String sql = "select * from product where price >? order by price"; 
		List<Product>plist= jdbctemplate.query(sql,new Object[]{price},BeanPropertyRowMapper.newInstance(Product.class));
		if(plist.size()>0)
			return plist;
		return null;
		
	}
}
