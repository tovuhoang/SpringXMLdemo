package com.vn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.dao.UserDAO;
import com.vn.model.Users;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void create(Users users) {
		userDAO.create(users);
		//validate
		
		//check duplicate username
		
		//check password.
		
		//show message...
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

}
