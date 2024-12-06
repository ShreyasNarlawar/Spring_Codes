package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//@RequestMapping("/hello")
			@GetMapping("/")
			public String welcomefile() {
				System.out.println("in welcome file");
				return "index";
			}
			
		//@RequestMapping("/hello")
		@GetMapping("/hello")
		public String sayHello() {
			return "hello";
		}
		@GetMapping("/message")
		public ModelAndView getMessage() {
			String message = "Hello Frds,  This is Shreyas..";
			return new ModelAndView("showmessage","msg",message);
		}
}
