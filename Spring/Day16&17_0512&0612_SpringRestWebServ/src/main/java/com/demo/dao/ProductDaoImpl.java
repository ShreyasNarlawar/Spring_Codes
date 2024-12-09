package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbctemp;
	
	@Override
	public List<Product> getAll() {
		return jdbctemp.query("select * from product", (rs,rownum)->{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
//			p.setLdt(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			
			return p;
		});
	}

	@Override
	public boolean addNewProd(Product p) {
		int n=jdbctemp.update("insert into product values (?,?,?,?,?,?)", new Object[] {
				p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid()});
		return n>0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Product getById(int id) {
		return jdbctemp.queryForObject("select * from product where pid =?", new Object[] {id},(rs,rownum)->{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setLdt(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			
			return p;	
		});
	}

	@Override
	public boolean modifyById(Product p) {
		// TODO Auto-generated method stub
		int n = jdbctemp.update("update product set pid=?,pname=?,qty=?,price=?,date=?,cid=?",new Object[]{
				p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid()});
		return n > 0;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		int n = jdbctemp.update("delete from product where pid = ?", new Object[] {id});
		return n > 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Product> getByCategoryId(int cid) {
		// TODO Auto-generated method stub
		return jdbctemp.query("select * from product where cid=?",new Object[] {cid},(rs,rownum)->{
				Product p = new Product();
				 p.setPid(rs.getInt(1));
				 p.setPname(rs.getString(2));
				 p.setQty(rs.getInt(3));
				 p.setPrice(rs.getDouble(4));
//				 p.setLdt(rs.getDate(5).toLocalDate());
				 p.setCid(rs.getInt(6));
				return p;
		});
	}
	
	
}
