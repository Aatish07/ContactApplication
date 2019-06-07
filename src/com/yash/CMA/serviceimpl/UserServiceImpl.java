package com.yash.CMA.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yash.CMA.dao.UserDao;
import com.yash.CMA.daoimpl.userDoaImpl;
import com.yash.CMA.domain.User;
import com.yash.CMA.service.UserService;
import com.yash.CMA.utility.DBConnection;

public class UserServiceImpl extends userDoaImpl implements UserService {
	userDoaImpl userdao;
	
	public UserServiceImpl() {

		 userdao=new userDoaImpl();
	}

	@Override
	public void registerUser(User user) {
		 
		userdao.saveUser(user);
	}

	@Override
	public User authentication(String loginname, String password) {

	Connection con = DBConnection.connection();
	User user = null;
	List<User> userList=new ArrayList<User>();
	try {
		String sql = "select * from users";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		 while (rs.next()) {
			String loginame=rs.getString("loginname");
			System.out.println(loginame);
			 String name=rs.getString(8);
			 System.out.println(name);
		
	          if(rs.getString("loginname").equals(loginname) && rs.getString("Password").equals(password)){
	        	  
	        	   user=new User();
	    		   
		           	user.setName(rs.getString("name"));
		           	user.setEmail(rs.getString("email"));
		           	user.setRole(rs.getInt("role"));
		           	user.setUserid(rs.getInt("userid"));
		   //        	user.setPhone(rs.getString("pho;ne"));
		           	
		           
		      
	        	  
	        	  
	          }

	        }
	} catch (Exception e) {

		e.getStackTrace();
	}
	return user;
	
	}

	@Override
	public User SearchUser(int userid) {
	User user=userdao.findUserByID(userid);
		return user;
	}
	
	public List<User> dispalyUserList(){
		
		List<User> userlist=userdao.dispalyUser();
		return userlist;
		
		
	}

}
