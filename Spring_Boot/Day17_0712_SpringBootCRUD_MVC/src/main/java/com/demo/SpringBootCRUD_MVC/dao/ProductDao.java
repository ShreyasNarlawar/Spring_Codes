package com.demo.SpringBootCRUD_MVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringBootCRUD_MVC.beans.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{

}
