package com.vn.dao;

import java.util.List;

import com.vn.entities.Product;

public interface ProductDAO {

	Product create(Product product);
	Product update(Product product);
	Product delete(Integer id);
	List<Product> findAll(Integer pageNum, Integer pageSize);
	Product detail(Integer id);
	
	
}