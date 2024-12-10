package com.demo.DemoProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.DemoProject.beans.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{

}
