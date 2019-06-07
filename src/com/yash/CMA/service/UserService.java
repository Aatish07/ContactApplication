package com.yash.CMA.service;

import java.util.List;

import com.yash.CMA.domain.User;

public interface UserService {

	 void registerUser(User user);
	 User authentication(String loginname,String password);
	 User SearchUser(int userid);
	 List<User> dispalyUserList(); 
}
