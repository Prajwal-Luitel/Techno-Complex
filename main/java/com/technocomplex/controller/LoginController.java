package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.technocomplex.model.UserModel;
import com.technocomplex.service.LoginService;
import com.technocomplex.util.CookieUtil;
import com.technocomplex.util.SessionUtil;

/**
 * LoginController is responsible for handling login requests. It interacts with
 * the LoginService to authenticate users.
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/login"})

public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final LoginService loginService;

	/**
	 * Constructor initializes the LoginService.
	 */
	public LoginController() {
		this.loginService = new LoginService();
	}
	
	/**
	 * Handles GET requests for user login.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests for user login.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserModel userModel = new UserModel(username, password);
		Boolean loginStatus = loginService.loginUser(userModel);
		String role = loginService.userRole(username);
 
		if (loginStatus != null && loginStatus) {
			SessionUtil.setAttribute(req, "username", username);
			if (role.equals("admin")) {
				req.setAttribute("success", "Redirecting to Dashboard");
				
				CookieUtil.addCookie(resp, "role", "admin", 60 * 60); //3 minute
				req.setAttribute("redirect", req.getContextPath() + "/dashboard"); // Redirect to /dashboard
				req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
			} else {
				req.setAttribute("success", "Redirecting to Home");

				CookieUtil.addCookie(resp, "role", "customer", 60* 60); // 3 minute
				req.setAttribute("redirect", req.getContextPath() + "/home"); // Redirect to /home
				req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
			}
		} else {
			handleLoginFailure(req, resp, loginStatus);
		}
	}

	/**
	 * Handles login failures by setting attributes and forwarding to the login
	 * page.
	 *
	 * @param req         HttpServletRequest object
	 * @param resp        HttpServletResponse object
	 * @param loginStatus Boolean indicating the login status
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus)
			throws ServletException, IOException {
		String errorMessage;
		if (loginStatus == null) {
			errorMessage = "Our server is under maintenance. Please try again later!";
		} else {
			errorMessage = "User credential mismatch. Please try again!";
		}
		req.setAttribute("error", errorMessage);
		req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
	}
}
