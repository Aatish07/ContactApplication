package com.yash.CMA.dao;

import java.util.List;

import com.yash.CMA.domain.Contact;

public interface ContactDao {

	public void saveContact(Contact user);
	public void updateContact(Contact user);
	public void deleteContact(int userid);
	public Contact findContactByID(int userid);
	public List<Contact> dispalyUser(int userid);
}
