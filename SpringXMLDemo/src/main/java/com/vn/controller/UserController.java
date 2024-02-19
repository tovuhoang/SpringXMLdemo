package com.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.services.UserServices;

@Controller
public class UserController {
	
	@Autowired
	UserServices userServices;
	
	@GetMapping("/admin/user/list")
	public String list( 
		@RequestParam(name = "pageNum", required = false, defaultValue = "10") String pageNum) {
			System.out.println("pageNum :" + pageNum);
			userServices.getAll();
			return "/admin/user/list";
		}

	}
