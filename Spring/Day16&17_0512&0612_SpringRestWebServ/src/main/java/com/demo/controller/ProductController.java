package com.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Product;
import com.demo.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService pserv;
    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> plist = pserv.getAllProds();
        return ResponseEntity.ok(plist);
    }
    
    @GetMapping("/products/{pid}")
    public ResponseEntity<Product> getById(@PathVariable int id){
    	Product p = pserv.getById(id);
    	if(p != null)
    		return ResponseEntity.ok(p);
    	else
    		return ResponseEntity.status(500).body(null);
    	
    }
    
    @GetMapping("products/category/{cid}")
    public ResponseEntity<List<Product>> getByCategoryId(@PathVariable int cid){
    	List<Product> plist = pserv.findByCategory(cid);
    	return ResponseEntity.ok(plist);
    		
    }
    
    @PutMapping("/products/{pid}")
    public ResponseEntity<String> updateProduct(@RequestBody Product p){
    	boolean status = pserv.updateById(p);
    	if(status)
    		return ResponseEntity.ok("Data updated successfully");
    	else
    		return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/products/{pid}")
    public ResponseEntity<String> addNewProduct(@RequestBody Product p){
    	boolean status = pserv.addNewProduct(p);
    	if(status)
    		return ResponseEntity.ok("Data added successfully");
    	else
    		return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/products/{pid}")
    public ResponseEntity <String> deleteProduct(@PathVariable int id){
    	boolean status = pserv.removeById(id);
    	if(status)
    		return ResponseEntity.ok("Data deleted successfully");
    	else
    		return new ResponseEntity(HttpStatus.NOT_FOUND);
    		
    }
    
    
}
