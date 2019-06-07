package com.yash.CMA.dao;

import java.util.List;

import com.yash.CMA.domain.User;

public interface UserDao {

	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userid);
	public User findUserByID(int userid);
	public List<User> dispalyUser();
}
