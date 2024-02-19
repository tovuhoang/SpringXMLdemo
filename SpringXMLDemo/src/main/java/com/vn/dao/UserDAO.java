package com.vn.dao;

import org.apache.catalina.User;

import com.vn.model.Users;

public interface UserDAO {
	
	void create(Users users);
	void update();
	Users checklogin(String uname, String upass);

}
