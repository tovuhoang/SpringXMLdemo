package com.vn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.dao.UserDAO;
import com.vn.entities.Product;
import com.vn.model.Users;

@Controller
public class HomeController {
	
	@Autowired
	UserDAO userDAO;
	
	@GetMapping(value = { "/index", "/home", "" })
	public String homePage() {
		return "index";
	}
	
	//@RequestMapping(method = RequestMethod.GET, value = "/login")
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String checkLogin(
//			@RequestParam("username") String uname,
//			@RequestParam String password,
			@ModelAttribute("userObject") Users users,
			Model model,
			RedirectAttributes redirectAttributes,
			HttpSession httpSession,
			HttpServletRequest request
	) {
		//1. validate input
		boolean hasError = false;
		if(users.getUsername() == null || "".equals(users.getUsername().trim())) {
			model.addAttribute("messageUsername", "Username must be not empty");
			hasError = true;
		}
		if(users.getPassword() == null || "".equals(users.getPassword().trim())) {
			model.addAttribute("messagePassword", "Password must be not empty");
			hasError = true;
		}
		if(hasError) {
			return "login";
		}
		
		//2. check login => dao
		Users usersDB = userDAO.checklogin(users.getUsername(), users.getPassword());
		
		//3.1 user is exist, redirect => home
		if(usersDB != null) {
			//TODO insert usersDB to session
			httpSession.setAttribute("message", "Login is successfully");
			return "redirect:/home";
		}
		//3.2 user is not exist => show message error.
		model.addAttribute("message", "Username or password is incorrect");
		return "login";
	}
	
	
	
//	/product/1
//	/author/1/post/10               => PathVariAble
//	
//	/author/post?author=1&postId=10 => RequestParam
	@RequestMapping(value = "/product/{id}")
	public ModelAndView showDetailProduct(
			@PathVariable("id") Integer productId
	) {
		ModelAndView m = new ModelAndView();
		m.setViewName("/product/detail");
		
		
		//TODO remove fake code
		Product product = new Product();
		product.setId(10);
		product.setName("San pham dien thoai");
		product.setPrice(200.0);
		product.setQuantity(0);
		
		m.addObject("productDB", product);
		
		System.out.println("productId: "+ productId);
		return m;
	}
	
	@RequestMapping(value = "/author/{authorId}/post/{postId}")
	public String showDetailProduct(
			@PathVariable Integer authorId,
			@PathVariable Integer postId
	) {
		System.out.println("authorId: "+ authorId);
		System.out.println("postId: "+ postId);
		return null;
	}
}

