package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService pserv;
	
	@GetMapping("/getproducts")
	public ModelAndView getAllProducts() {
		List<Product>plist=pserv.getAllProds();
		return new ModelAndView("showproduct","plist",plist);
	}

}
