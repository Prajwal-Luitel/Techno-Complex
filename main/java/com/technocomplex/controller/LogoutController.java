package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.technocomplex.util.CookieUtil;
import com.technocomplex.util.SessionUtil;

/**
 * Servlet implementation class HeaderController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
    }

    /**
	 * Handles POST requests for Logout .
	 * It delete the cookies and session.
	 * 
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CookieUtil.deleteCookie(response, "role");
		SessionUtil.invalidateSession(request);
		response.sendRedirect(request.getContextPath() + "/login");
	}

}
