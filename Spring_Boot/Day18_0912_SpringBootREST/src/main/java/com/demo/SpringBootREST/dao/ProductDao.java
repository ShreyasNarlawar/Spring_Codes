package com.demo.SpringBootREST.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.SpringBootREST.beans.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query(value="select * from product where cid=:cid",nativeQuery=true)
	List<Product> getProductsByCid(int cid);
	
	@Query(value="select * from product where price between :lpr and :hpr",nativeQuery=true)
	List<Product> getByPrice(int lpr, int hpr);
}
