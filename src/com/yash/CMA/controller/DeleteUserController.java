package com.yash.CMA.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.CMA.domain.User;
import com.yash.CMA.serviceimpl.UserServiceImpl;

public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserServiceImpl uservice;
	User user;

	public DeleteUserController() {
		super();
		uservice = new UserServiceImpl();
		user = new User();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> userList = uservice.dispalyUserList();
		request.setAttribute("userList", userList);
		RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String s = request.getParameter("deleteMultiple");

		System.out.println(s);

		if ("DeleteMultiple".equalsIgnoreCase(request.getParameter("deleteMultiple"))) {

			String[] names = request.getParameterValues("delete");
			if (names != null && names.length > 0) {

				for (String string : names) {
					System.out.println(string);
					uservice.deleteUser(Integer.parseInt(string));
				}
			}

				List<User> userList = uservice.dispalyUserList();
				request.setAttribute("userList", userList);
				RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
				view.include(request, response);
			
		} else if ("DeleteSingle".equalsIgnoreCase(request.getParameter("DeleteUser"))) {
			int useridnew = Integer.parseInt(request.getParameter("deleteUserid"));
			uservice.deleteUser(useridnew);
			List<User> userList = uservice.dispalyUserList();
			request.setAttribute("userList", userList);
			RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
			view.include(request, response);

		}

		else if ("SearchUser".equalsIgnoreCase(request.getParameter("searchUser"))) {
			int useridnew = Integer.parseInt(request.getParameter("searchuserid"));
			User user = uservice.SearchUser(useridnew);
			List<User> userList = new ArrayList<User>();
			userList.add(user);
			request.setAttribute("userList", userList);
			RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
			view.include(request, response);
		}
		else if("Edit".equalsIgnoreCase(request.getParameter("EditUser")))
		{
			int editUserID = Integer.parseInt(request.getParameter("EditUserId"));
			User user = uservice.SearchUser(editUserID);
			request.setAttribute("user", user);
			RequestDispatcher view = request.getRequestDispatcher("EditUser.jsp");
			view.include(request, response);
		}

	}

}
