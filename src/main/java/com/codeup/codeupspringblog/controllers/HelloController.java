package com.codeup.codeupspringblog.controllers;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller// tells spring this is a class to care about

public class HelloController {

	private int counter;
	@GetMapping("/counter/{counterInit}")
	@ResponseBody
	public String initCounter(@PathVariable int counterInit){
		counter = counterInit;
		return "counter reset to " + counter;
	}

	@GetMapping("/increment")
	@ResponseBody
	public String incrementCounter (){
		counter ++;
		return "counter is now " + counter;
	};


//    @RequestMapping(method= RequestMethod.GET, name = "/hello")
//    @GetMapping("/hello")//tells spring to look for a git request to an end point "/hello"
//	@GetMapping(path = "hello", produces = "application/json")
//	@ResponseBody //whatever the method returns will be sent as the body
//
//	public String hello() {
////        return "Hello from Spring!";
//		return """
//				{
//				     "message" :  "hello json from spring"
//				}
//				""";
//	}

//	@GetMapping(path = "/hello/{personName}")
//	@ResponseBody //whatever the method returns will be sent as the body
//
//	public String hello(@PathVariable String personName) {
//		return "Hello " + personName ;
//	}

	//    @GetMapping(path = "/hello-msg", produces = "application/json")
//    @ResponseBody
//    public String helloMessage() {
//
//        return String.format("Hello from JSON %s", LocalDateTime.now());
//    }
	@GetMapping(path = "/hello-msg/{personName}", produces = "application/json")
	@ResponseBody
	public String helloMessage(@PathVariable String personName) {

		return String.format("Hello from JSON %s %S", personName, LocalDateTime.now());
	}

	@RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
	@ResponseBody
	public String addOne(@PathVariable int number) {
		return number + " plus one is " + (number + 1) + "!";
	}


	@PostMapping(path = "/hello/{personName}")
	public String hello (@PathVariable String personName, Model model){
		model.addAttribute ("name", personName);
		return "hello";
	}

}
