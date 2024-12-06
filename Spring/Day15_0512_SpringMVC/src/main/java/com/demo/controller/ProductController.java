package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/addproduct")
	public String displayForm(Model m) {
		m.addAttribute("u1", new Product());
		return "insertproduct";
	}
	@PostMapping("/insertproduct")
	//public ModelAndView inserProduct(@RequestParam int pid,@RequestParam String  pname,@RequestParam int qty,@RequestParam double price,@RequestParam String ldt,@RequestParam int cid) {
	public ModelAndView insertProduct(@ModelAttribute Product p) {
		boolean status = pserv.addNewProduct(p);
		return new ModelAndView("redirect:/product/getproduct");
	}
	@GetMapping("/editproduct/${pid}")
	public ModelAndView editProduct(@PathVariable int pid) {
		Product p = pserv.getById(pid);
		return null;
		
	}

}
