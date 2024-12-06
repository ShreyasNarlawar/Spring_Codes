package com.demo.dao;

import java.util.List;

import javax.sql.RowSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
@Autowired
JdbcTemplate jdbctemp;

@GetMapping("/getproducts")
public List<Product> getProds() {
	String q = "select * from product";
	return jdbctemp.query(q,(rs,rownum)->{
		Product p = new Product();
		p.setPid(rs.getInt(1));
		p.setPname(rs.getString(2));
		p.setQty(rs.getInt(3));
		p.setPrice(rs.getDouble(4));
		p.setDate(rs.getDate(5).toLocalDate());
		p.setCid(rs.getInt(6));
		return p;
	});
}

	@Override
	public boolean addProds(Product p) {
		// TODO Auto-generated method stub
		String q = "insert into product values (?,?,?,?,?,?)";
		int n = jdbctemp.update(q,new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getDate(),p.getCid()});
		 return n > 0;
	
	}	

}
