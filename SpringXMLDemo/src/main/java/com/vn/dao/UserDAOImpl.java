package com.vn.dao;

import org.springframework.stereotype.Repository;
import com.vn.model.Users;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public void create(Users users) {
		//save - none logic
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users checklogin(String uname, String upass) {
		// TODO Auto-generated method stub
		if(uname.equals("huypn")) {
			return new Users(1, "tovuhuang", "huang", "to", upass);
		}
		return null;
	}

}
