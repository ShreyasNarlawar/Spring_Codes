package com.demo.SpringBootREST.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootREST.beans.Product;
import com.demo.SpringBootREST.beans.mapper.ProductDTOMapper;
import com.demo.SpringBootREST.dao.ProductDao;
import com.demo.SpringBootREST.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao pdao;
	
	@Override
	public List<ProductDto> getAllProds() {
		// TODO Auto-generated method stub
		List<Product>plist = pdao.findAll();
		plist.forEach(System.out::println);
		List<ProductDto> plst = plist.stream()
				.map(prod->ProductDTOMapper.mapToProductDto(prod))
				.collect(Collectors.toList());
		return plst;
	}
	
	@Override
	public ProductDto getById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> op = pdao.findById(pid);
		if(op.isPresent())
			return ProductDTOMapper.mapToProductDto(op.get());
		
		return null;
	}

	@Override
	public List<ProductDto> findByCid(int cid) {
		// TODO Auto-generated method stub]\
		List<Product> plist = pdao.getProductsByCid(cid);
		List<ProductDto> plst = plist.stream()
				.map(prod ->ProductDTOMapper.mapToProductDto(prod))
				.collect(Collectors.toList());
		return plst;
	}

	@Override
	public boolean addNewProduct(ProductDto p) {
		// TODO Auto-generated method stub
		Product p2 = ProductDTOMapper.mapToProduct(p);
		Product p1 = pdao.save(p2);
		
		return p1 != null;
	}

	@Override
	public boolean updateProduct(ProductDto p) {
		// TODO Auto-generated method stub
		Optional<Product>op = pdao.findById(p.getPid());
		if(op.isPresent()) {
			Product p2 = op.get();
			p2.setPname(p.getPname());
			p2.setQty(p.getQty());
			p2.setPrice(p.getPrice());
			p2.setExpdate(LocalDate.parse(p.getLdstr(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			pdao.save(p2);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(int pid) {
		Optional<Product>op = pdao.findById(pid);
		if(op.isPresent()) {
			pdao.delete(op.get());
			return true;
		}
		return false;
	}
	
	
	

}
