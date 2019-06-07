package com.yash.CMA.test;

import com.yash.CMA.daoimpl.userDoaImpl;
import com.yash.CMA.domain.User;

public class testUpdateUser {

	public static void main(String[] args) {
		
		userDoaImpl ud=new userDoaImpl();
		User user=new User();
		user.setUserid(2);
		user.setName("shakir");
		user.setEmail("shakir@yash.com");
		user.setPhone("9806243387");
		user.setAddress("khargaon");
		user.setLoginName("sh07");
		user.setPassword("sh@1234");
		user.setRole(1);
		
		ud.updateUser(user);
		System.out.println("Record Updated successfully");
	}
}
