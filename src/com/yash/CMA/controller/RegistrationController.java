package com.yash.CMA.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.yash.CMA.daoimpl.ContactDaoImpl;
import com.yash.CMA.domain.Contact;
import com.yash.CMA.domain.User;
import com.yash.CMA.serviceimpl.UserServiceImpl;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserServiceImpl uservice;
	ContactDaoImpl contactService;
	User user;
	Contact contact;

	public RegistrationController() {

		uservice = new UserServiceImpl();
		contactService= new ContactDaoImpl();
		user = new User();
		contact=new Contact();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("Register".equalsIgnoreCase(request.getParameter("RegisterUser"))) {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			// user.setUserid(Integer.parseInt(request.getParameter("userid")));
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPhone(request.getParameter("phone"));
			user.setAddress(request.getParameter("address"));
			user.setLoginName(request.getParameter("loginname"));
			user.setPassword(request.getParameter("password"));
			user.setRole(1);

			uservice.registerUser(user);
			JOptionPane.showMessageDialog(null, "Registered SuccessFully", "Success", JOptionPane.PLAIN_MESSAGE);
			RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
			view.forward(request, response);

		} else if ("Update".equalsIgnoreCase(request.getParameter("updateUser"))) {
			user.setName(request.getParameter("name"));
			user.setUserid(Integer.parseInt(request.getParameter("userid")));
			user.setEmail(request.getParameter("email"));
			user.setPhone(request.getParameter("phone"));
			user.setAddress(request.getParameter("address"));
			user.setRole(Integer.parseInt(request.getParameter("role")));

			uservice.updateUser(user);
			List<User> userList=uservice.dispalyUserList();
			request.setAttribute("userList", userList);
			JOptionPane.showMessageDialog(null, "Updated SuccessFully", "Success", JOptionPane.PLAIN_MESSAGE);
			RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
			view.forward(request, response);

		}
		
		else if("Save".equalsIgnoreCase(request.getParameter("saveContact")))
		{
			HttpSession session=request.getSession(true);
			contact.setName(request.getParameter("name"));
			contact.setContactid(Integer.parseInt(request.getParameter("contactid")));
			contact.setEmail(request.getParameter("email"));
			contact.setPhone(request.getParameter("phone"));
			int userid=(int) session.getAttribute("userid");
			contact.setUserid(userid);
			
			contactService.saveContact(contact);
			List<Contact> userList=contactService.dispalyUser(userid);
			request.setAttribute("userList", userList);
			JOptionPane.showMessageDialog(null, "Contact Added SuccessFully", "Success", JOptionPane.PLAIN_MESSAGE);
			RequestDispatcher view = request.getRequestDispatcher("User.jsp");
			view.include(request, response);
			
		}
		
		else if ("Update".equalsIgnoreCase(request.getParameter("updatContact"))) {
			HttpSession session=request.getSession(true);
			contact.setName(request.getParameter("name"));
			contact.setUserid(Integer.parseInt(request.getParameter("contactid")));
			contact.setEmail(request.getParameter("email"));
			contact.setPhone(request.getParameter("phone"));

			contactService.updateContact(contact);
			int userid=(int) session.getAttribute("userid");
			List<Contact> userList=contactService.dispalyUser(userid);
			request.setAttribute("userList", userList);
			JOptionPane.showMessageDialog(null, "Updated SuccessFully", "Success", JOptionPane.PLAIN_MESSAGE);
			RequestDispatcher view = request.getRequestDispatcher("User.jsp");
			view.forward(request, response);

		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
