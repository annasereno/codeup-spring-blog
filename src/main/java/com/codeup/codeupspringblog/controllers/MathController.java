package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class MathController {

	@RequestMapping(path = "/add/{a}/and/{b}", method = RequestMethod.GET)
	@ResponseBody
	public String addition(@PathVariable int a, @PathVariable int b){
//		return a + " + " + b + " = " + (a+b);
		return String.valueOf(a+b);
	}

	@GetMapping( "/subtract/{a}/from/{b}")
	@ResponseBody
	public String subtraction (@PathVariable int a, @PathVariable int b){
		return b + " - " + a + " = " + (b - a);
	}


// CHANGED FROM STRING TO INT
	@GetMapping( "/multiply/{a}/and/{b}")
	@ResponseBody
	public int multiply (@PathVariable int a, @PathVariable int b){
		return a * b;
	}

	@GetMapping( "/divide/{a}/by/{b}")
	@ResponseBody
	public String divide (@PathVariable int a, @PathVariable int b){
		return a + " / " + b + " = " + (a / b);
	}


}
