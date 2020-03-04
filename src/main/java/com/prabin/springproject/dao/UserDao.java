package com.prabin.springproject.dao;

import com.prabin.springproject.model.User;

public interface UserDao {
	
	void addUser(User user);
	User login(String un, String psw);

}
