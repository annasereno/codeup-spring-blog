package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	@ResponseBody
	public String getAllPosts(){
		return "All post index page";
	};

	@GetMapping("/posts/{id}")
	@ResponseBody
	public String getPostsID(@PathVariable long id){
		return "view an individual post " + id;
	};

	@GetMapping("/posts/create")
	@ResponseBody
	public String getCreatePage(){
		return "view the form for creating a post";
	};

	@PostMapping("/posts/create")
	@ResponseBody
	public String postCreatePage(){
		return "create a new post";
	};

}
