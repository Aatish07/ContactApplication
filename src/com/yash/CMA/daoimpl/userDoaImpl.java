package com.yash.CMA.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.CMA.dao.UserDao;
import com.yash.CMA.domain.User;
import com.yash.CMA.utility.DBConnection;


public class userDoaImpl implements UserDao {

	@Override
	public void saveUser(User user) {

		Connection con = DBConnection.connection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(
					"insert into users(name,email,phone,address,loginname,Password,role) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getLoginName());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setInt(7, user.getRole());
			int i = preparedStatement.executeUpdate();
			System.out.println(i + "record inserted");

		} catch (Exception e) {

			e.getStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {

		Connection con = DBConnection.connection();
		try {
			String sql = "update users set name=?,email=?,phone=?,address=?,role=? where userid=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setInt(5, user.getRole());
			preparedStatement.setInt(6, user.getUserid());
			int i = preparedStatement.executeUpdate();
			System.out.println(i + "record Updated");

		} catch (Exception e) {

			e.getStackTrace();
		}
	}

	@Override
	public void deleteUser(int userid) {
		Connection con = DBConnection.connection();
		String sql = "delete from users where userid=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStatement.setInt(1, userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		try {
			i = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i + "record Updated");

	}

	@Override
	public User findUserByID(int userid) {
		
		Connection con = DBConnection.connection();
		User user=null;
		List<User> userList=new ArrayList<User>();
		try {
			String sql = "select userid,name,email,phone,address,role from users where userid=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,userid);
			
			ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 
		           user=new User();
		   
		           user.setUserid(rs.getInt("userid"));
		           	user.setName(rs.getString("name"));
		           	user.setEmail(rs.getString("email"));
		           	user.setPhone(rs.getString("phone"));
		          user.setAddress(rs.getString("address"));
		           	user.setRole(rs.getInt("role"));
		
		      

		        }
		} catch (Exception e) {

			e.getStackTrace();
		}
		
		return user;
	}

	@Override
	public List<User> dispalyUser() {
		
		Connection con = DBConnection.connection();
		User user;
		List<User> userList=new ArrayList<User>();
		try {
			String sql = "select userid,name,email,phone from users";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
	
			ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 
		           user=new User();
		           user.setUserid(rs.getInt("userid"));
		           	user.setName(rs.getString("name"));
		           	user.setEmail(rs.getString("email"));
		           	user.setPhone(rs.getString("phone"));
		           	
		           	userList.add(user);
		      

		        }
		} catch (Exception e) {

			e.getStackTrace();
		}
		
		return userList;
	}

}
