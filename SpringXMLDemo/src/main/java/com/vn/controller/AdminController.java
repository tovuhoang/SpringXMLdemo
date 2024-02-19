package com.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.dao.ProductDAO;

@Controller
public class AdminController {
	
	@Autowired
	ProductDAO productDAO;
	
	@GetMapping("/admin/product/all")
	public String showAll(
			@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
			ModelMap map
	) {
		map.addAttribute("list", productDAO.findAll(pageNumber, pageSize));
		return "/admin/product/list";
	}

}
