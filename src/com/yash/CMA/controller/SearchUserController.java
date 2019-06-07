package com.yash.CMA.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.CMA.domain.User;
import com.yash.CMA.serviceimpl.UserServiceImpl;


public class SearchUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserServiceImpl uservice;
    public SearchUserController() {
    	
    	 uservice=new UserServiceImpl();
     
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("aaya to hai service me");
		int  userid=Integer.parseInt(request.getParameter("userid"));
	
		User user=uservice.SearchUser(userid);
		System.out.println(user.getName());
		request.setAttribute("userlist", user);
        RequestDispatcher view = request.getRequestDispatcher("/SearchUser.jsp");
        view.include(request, response);
		
		//User user=uservice.authentication(loginname, password);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
