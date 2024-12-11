package com.demo.SpringBootREST.service;

import java.util.List;

import com.demo.SpringBootREST.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProds();

	ProductDto getById(int pid);

	List<ProductDto> findByCid(int cid);

	boolean addNewProduct(ProductDto p);

	boolean updateProduct(ProductDto p);

	boolean deleteById(int pid);

}
