package com.yash.CMA.test;

import com.yash.CMA.dao.UserDao;
import com.yash.CMA.daoimpl.userDoaImpl;
import com.yash.CMA.domain.User;

public class testSaveUser {

	public static void main(String[] args) {
		userDoaImpl ud=new userDoaImpl();
		User user=new User();
		user.setName("sonali");
		user.setEmail("sonali@yash.com");
		user.setPhone("9806243386");
		user.setAddress("ujjain");
		user.setLoginName("sp01");
		user.setPassword("sp@1234");
		user.setRole(2);
		
		ud.saveUser(user);
		System.out.println("Record inserted successfully");
		
		
		
		
		
	}
	
}
