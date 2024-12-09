package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Category;
import com.demo.service.Catservice;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	Catservice cserv;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category>clist = cserv.getAllCat();
		return ResponseEntity.ok(clist);
	}
	
	@GetMapping("/categories/{cid}")
	public ResponseEntity<Category> getById(@PathVariable int id){
		Category c = cserv.getByCid(id);
		return ResponseEntity.ok(c);
		
	}
	
	@PutMapping("/categories/{cid}")
	public ResponseEntity<String> updateById(@PathVariable int id){
		boolean status = cserv.updateById(id);
	
		if(status)
			return ResponseEntity.ok("Data updated successfully");
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	
}
