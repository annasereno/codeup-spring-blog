package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.PostDao;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Post;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

	//private List<Post> post = new ArrayList<>(List.of());

	private final PostDao postDao; //instance interface
//	private final UserRepository userDao;

	//every time a post controller gets creater a postDao should be a part of it
	private List<Post> post = new ArrayList<>();

	public PostController(PostDao postDao){
		this.postDao = postDao;
//		this.userDao = userDao;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	@ResponseBody
	public String getAllPosts(){
		return "All post index page";
	};

	@GetMapping("/posts/{id}")
	@ResponseBody
	public String getPostsID(@PathVariable long id, Model model){
		Post post;
		if (postDao.findById(id).isPresent()){
			post = postDao.findById(id).get();
		} else {
			post = new Post("Post not found", "");
		}
		model.addAttribute("post", post);
		return "/post/show";
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
