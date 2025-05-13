package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.technocomplex.service.ProfilePicService;
import com.technocomplex.util.SessionUtil;

/**
 * @author Prajwal Luitel
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/about" })
public class AboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProfilePicService profilePicService;

	public AboutController() {
		super();
		this.profilePicService = new ProfilePicService();
	}

	/**
	 * Handles GET requests for profile image.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String profileUrl = profilePicService.getUserProfile((String) SessionUtil.getAttribute(request, "username"));
		request.setAttribute("profileUrl", profileUrl);
		request.getRequestDispatcher("WEB-INF/pages/about.jsp").forward(request, response);
	}
}
