package com.yash.CMA.test;

import java.util.List;

import com.yash.CMA.daoimpl.userDoaImpl;
import com.yash.CMA.domain.User;

public class TestDisplayUser {

	public static void main(String[] args) {
userDoaImpl ud=new userDoaImpl();
		
		
		List<User> userlist=ud.dispalyUser();
		for (User user : userlist) {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getPhone());
		}
	}
}
