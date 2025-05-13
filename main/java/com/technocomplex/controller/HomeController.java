package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.technocomplex.model.FlatModel;
import com.technocomplex.service.HomeService;
import com.technocomplex.service.ProfilePicService;
import com.technocomplex.util.SessionUtil;

/**
 * @author Prajwal Luitel
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/home", "/index", "/" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProfilePicService profilePicService;
	private final HomeService homeService;

	public HomeController() {
		super();
		this.profilePicService = new ProfilePicService();
		this.homeService = new HomeService();
	}

	/**
	 * Handles GET requests for Home.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String profileUrl = profilePicService.getUserProfile((String) SessionUtil.getAttribute(request, "username"));

		List<FlatModel> flatList = homeService.getFlatList();
		request.setAttribute("flatList", flatList);
		request.setAttribute("profileUrl", profileUrl);
		request.getRequestDispatcher("WEB-INF/pages/home.jsp").forward(request, response);
	}

}
