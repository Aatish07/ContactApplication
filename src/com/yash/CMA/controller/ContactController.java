package com.yash.CMA.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.CMA.daoimpl.ContactDaoImpl;
import com.yash.CMA.domain.Contact;

public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContactDaoImpl contactservice;
	Contact contact;

	public ContactController() {
		super();
		contactservice = new ContactDaoImpl();
		contact = new Contact();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String s = request.getParameter("deleteMultiple");

		HttpSession session=request.getSession(true);
		int userid=(int)session.getAttribute("userid");
		System.out.println(s);

		if ("DeleteMultiple".equalsIgnoreCase(request.getParameter("deleteMultipleContact"))) {

			String[] names = request.getParameterValues("delete");
			if (names != null && names.length > 0) {

				for (String string : names) {
					System.out.println(string);
					contactservice.deleteContact(Integer.parseInt(string));
				}
			}

				List<Contact> userList = contactservice.dispalyUser(userid);
				request.setAttribute("userList", userList);
				RequestDispatcher view = request.getRequestDispatcher("User.jsp");
				view.include(request, response);
			
		} else if ("Delete".equalsIgnoreCase(request.getParameter("DeleteContact"))) {
			int useridnew = Integer.parseInt(request.getParameter("deleteContactid"));
			contactservice.deleteContact(useridnew);
			List<Contact> contactList = contactservice.dispalyUser(userid);
			request.setAttribute("userList",contactList );
			RequestDispatcher view = request.getRequestDispatcher("User.jsp");
			view.include(request, response);

		}

		else if ("SearchContact".equalsIgnoreCase(request.getParameter("searchContact"))) {
			int useridnew = Integer.parseInt(request.getParameter("searchuserid"));
			Contact contact = contactservice.findContactByID(useridnew);
			List<Contact> userList = new ArrayList<Contact>();
			userList.add(contact);
			request.setAttribute("userList", userList);
			RequestDispatcher view = request.getRequestDispatcher("User.jsp");
			view.include(request, response);
		}
		else if("Edit".equalsIgnoreCase(request.getParameter("EditContact")))
		{
			int editUserID = Integer.parseInt(request.getParameter("EditContactId"));
			Contact contact = contactservice.findContactByID(editUserID);
			request.setAttribute("user", contact);
			RequestDispatcher view = request.getRequestDispatcher("EditCustomer.jsp");
			view.include(request, response);
		}
		else if("AddCustomer".equalsIgnoreCase(request.getParameter("AddCustomer"))) {
			
			RequestDispatcher view = request.getRequestDispatcher("RegisterConact.jsp");
			view.include(request, response);
			
		}
	}

}
