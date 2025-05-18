package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.technocomplex.model.FlatModel;
import com.technocomplex.model.UserModel;
import com.technocomplex.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 * 
 * @author Prajwal Luitel
 * LMU Id 23048626
 */
@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CustomerService customerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
    	super();
    	customerService = new CustomerService();
    }

    /**
	 * Handles GET requests for customer page
	 * It load all the customer data in table.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserModel> userList = customerService.getUserList();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("WEB-INF/pages/admin/customer.jsp").forward(request, response);
	}
}
