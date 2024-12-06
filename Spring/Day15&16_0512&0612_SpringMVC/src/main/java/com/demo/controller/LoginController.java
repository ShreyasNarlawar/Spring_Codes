package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/security")
public class LoginController {
	@Autowired
	LoginService lserv;
	@GetMapping("/login")
	public String showlogin() {
		return "loginpage";
	}
		
	@PostMapping("/validate")
	public ModelAndView authenticateuser(@RequestParam("uname") String uname,@RequestParam String passwd,HttpSession session) {
		MyUser user = lserv.SearchUser(uname,passwd);
		System.out.println(user);
		if(user !=null) {
			session.setAttribute("user", user);
			return  new ModelAndView("redirect:/product/getproducts");
		}else
			return new ModelAndView("loginpage","msg","Wrong Credentials Plzz reEnter...");
	}

}
