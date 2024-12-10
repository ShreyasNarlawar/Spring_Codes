package com.demo.DemoProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.DemoProject.beans.Product;
import com.demo.DemoProject.service.ProductService;

@Controller
//@RequestMapping("/hello")
@RequestMapping("/")
public class ProdController {
	@Autowired
	ProductService pserv;

	@GetMapping("/getproducts")
	public ModelAndView getAllProducts() {
		System.out.println("Hello");
		List<Product>plist=pserv.getAllProducts();
		return new ModelAndView("showproduct","plist",plist);
	}
	
	@GetMapping("/addproduct")
	public String displayForm(Model m) {
		m.addAttribute("u1",new Product());
		return "insertproduct";
	}
	
	@PostMapping("/insertproduct")
	public ModelAndView insertProduct(@ModelAttribute Product p) {
		pserv.addNewProd(p);
		return new ModelAndView("redirect:/product/products");
	}
	
	@GetMapping("editproduct/{pid}")
	public ModelAndView editProduct(@PathVariable int pid) {
		Product p = pserv.GetById(pid);
		if(p!=null)
			return new ModelAndView("editproduct","prod",p);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@PostMapping("updateproduct")
	public ModelAndView updateProduct(@RequestParam int pid ,@RequestParam String pname,
										@RequestParam int qty , @RequestParam double price) {
		Product p = new Product(pid,pname,qty,price);
		pserv.updateProd(p);
		return new ModelAndView("redirect:/product/getproducts");
		
	}
	@DeleteMapping("deleteproduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable int pid) {
		pserv.deleteById(pid);
		return new ModelAndView("redirect:/product/getproducts");
		
	}
}
