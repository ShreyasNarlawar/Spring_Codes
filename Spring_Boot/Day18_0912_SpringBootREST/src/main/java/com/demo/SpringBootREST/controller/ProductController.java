package com.demo.SpringBootREST.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootREST.dto.ProductDto;
import com.demo.SpringBootREST.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService pserv;
	
	@GetMapping("/getproducts")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> plist = pserv.getAllProds();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<ProductDto> getById(@PathVariable int pid){
		ProductDto p = pserv.getById(pid);
		if(p!= null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(500).body(null);
	}
	
	@GetMapping("/category/products/{pid}")
	public ResponseEntity<List<ProductDto>> getByCid(@PathVariable int cid){
		List<ProductDto> plist = pserv.findByCid(cid);
		return ResponseEntity.ok(plist);
	}
	
	
	@PostMapping("/products/{pid}")
	public ResponseEntity<String> addNewProduct(@RequestBody ProductDto p){
		boolean status = pserv.addNewProduct(p);
		if(status)
			return ResponseEntity.ok("Data added successfully");
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto p){
		boolean status = pserv.updateProduct(p);
		if(status)
			return ResponseEntity.ok("Data Updated Successfully.");
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid){
		boolean status = pserv.deleteById(pid);
		if(status)
			return ResponseEntity.ok("Data Deleted re...");
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
