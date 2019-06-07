package com.yash.CMA.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.URLEncoder;

import com.yash.CMA.daoimpl.ContactDaoImpl;
import com.yash.CMA.domain.Contact;
import com.yash.CMA.domain.User;
import com.yash.CMA.service.UserService;
import com.yash.CMA.serviceimpl.UserServiceImpl;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserServiceImpl uservice;
	ContactDaoImpl contactService;
    public UserController() {
    	
    	 uservice=new UserServiceImpl();
    	 contactService=new ContactDaoImpl();
     
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = null;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			System.out.println("aaya to hai service me");
			String loginname = request.getParameter("name");
			String password = request.getParameter("password");
			User user = uservice.authentication(loginname, password);
			if (user != null) {

				session = request.getSession();

				System.out.println("Here let see what role is coming" + user.getRole());
				// System.out.println("UsEe Role"+user.getRole());
				if (user.getRole() == 1) {
					session.setAttribute("USER", user.getRole());
					request.setAttribute("UserDetails", user);
					session.setAttribute("userid", user.getUserid());
					List<Contact> contactlist = contactService.dispalyUser(user.getUserid());
					request.setAttribute("userList", contactlist);
					
					RequestDispatcher view = request.getRequestDispatcher("User.jsp");
					view.forward(request, response);
				} else if (user.getRole() == 2) {
					session.setAttribute("USER", user.getRole());
					List<User> userList = uservice.dispalyUserList();
					request.setAttribute("userList", userList);
					RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
					view.forward(request, response);

				}
			} else {
				String message = "InCorrect USername and Password";
				request.setAttribute("Messageid", message);
				System.out.println("Messageid :::" + request.getAttribute("Messageid"));
				RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
				view.include(request, response);
				// String message = "InCorrect USername and Password";
				// response.sendRedirect("Login.jsp?message=");

			}
		}
		catch(Exception e) {
			
			  e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("aaya to hai get me");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("aaya to hai post me");
	
	}

}
