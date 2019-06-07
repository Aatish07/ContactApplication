package com.yash.CMA.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.CMA.dao.ContactDao;
import com.yash.CMA.domain.Contact;
import com.yash.CMA.domain.User;
import com.yash.CMA.utility.DBConnection;

public class ContactDaoImpl implements ContactDao {

	@Override
	public void saveContact(Contact contact) {
		
		Connection con = DBConnection.connection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(
					"insert into contacts(contactid,name,email,phone,userid) values(?,?,?,?,?)");
			preparedStatement.setInt(1, contact.getContactid());
			preparedStatement.setString(2, contact.getName());
			preparedStatement.setString(3, contact.getEmail());
			preparedStatement.setString(4, contact.getPhone());
			preparedStatement.setInt(5, contact.getUserid());
		
			int i = preparedStatement.executeUpdate();
			System.out.println(i + "record inserted");

		} catch (Exception e) {

			e.getStackTrace();
		}
	}

	@Override
	public void updateContact(Contact contact) {
		
		Connection con = DBConnection.connection();
		try {
			String sql = "update Contacts set name=?,email=?,phone=? where contactid=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, contact.getName());
			preparedStatement.setString(2, contact.getEmail());
			preparedStatement.setString(3, contact.getPhone());
			preparedStatement.setInt(4,contact.getUserid());
			int i = preparedStatement.executeUpdate();
			System.out.println(i + "record Updated");

		} catch (Exception e) {

			e.getStackTrace();
		}

	}

	@Override
	public void deleteContact(int userid) {
	
		
		
		Connection con = DBConnection.connection();
		String sql = "delete from contacts where contactid=?";
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
	public Contact findContactByID(int userid) {
		
		Connection con = DBConnection.connection();
		Contact contact=null;
		List<Contact> userList=new ArrayList<Contact>();
		try {
			String sql = "select contactid,name,email,phone from contacts where contactid=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,userid);
			
			ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 
				 contact=new Contact();
		   
				 contact.setContactid((rs.getInt("contactid")));
				 contact.setName(rs.getString("name"));
				 contact.setEmail(rs.getString("email"));
				 contact.setPhone(rs.getString("phone"));
		        
		           
		
		      

		        }
		} catch (Exception e) {

			e.getStackTrace();
		}
		
		return contact;
	}

	@Override
	public List<Contact> dispalyUser(int userid) {
		

		Connection con = DBConnection.connection();
		Contact contact;
		List<Contact> userList=new ArrayList<Contact>();
		try {
			String sql = "select contactid,name,email,phone from Contacts where userid=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,userid);
			ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 
				 contact=new Contact();
				 contact.setContactid(rs.getInt("contactid"));
				 contact.setName(rs.getString("name"));
				 contact.setEmail(rs.getString("email"));
				 contact.setPhone(rs.getString("phone"));
		           	
		           	userList.add(contact);
		      

		        }
		} catch (Exception e) {

			e.getStackTrace();
		}
		
		return userList;
	}

}
