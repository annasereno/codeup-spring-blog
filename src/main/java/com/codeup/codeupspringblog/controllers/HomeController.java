package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

//	@GetMapping ("/")
//	@ResponseBody
//		public String hello() {
//		return "This is the landing page!";
//	}


	//This will give you a 500 error
	@GetMapping ("/home")
	public String landingPage() {
		return "home";
	}

}
