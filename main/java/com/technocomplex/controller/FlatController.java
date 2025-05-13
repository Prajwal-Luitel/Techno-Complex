
package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.technocomplex.model.FlatModel;
import com.technocomplex.service.FlatService;
import com.technocomplex.service.ProfilePicService;
import com.technocomplex.util.SessionUtil;

/**
 * @author Prajwal Luitel
 * 
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/flat" })
public class FlatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final FlatService flatService;
	private final ProfilePicService profilePicService;
    
    public FlatController() {
    	super();
    	this.flatService = new FlatService();
        this.profilePicService = new ProfilePicService();
    }

    /**
	 * Handles Get requests for flat page.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String profileUrl = profilePicService.getUserProfile((String) SessionUtil.getAttribute(request, "username"));
		List<FlatModel> flatList = flatService.getFlatList();
		request.setAttribute("flatList", flatList);
		request.setAttribute("profileUrl", profileUrl);
		request.getRequestDispatcher("WEB-INF/pages/flat.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests for search in flat page.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		String category = request.getParameter("category");
		String sort = request.getParameter("sort");
		String searchQuery =request.getParameter("searchQuery");
		
		List<FlatModel> flatList = flatService.searchFlatList(searchQuery,category,sort);
		request.setAttribute("flatList", flatList);
		request.getRequestDispatcher("WEB-INF/pages/flat.jsp").forward(request, response);
	}

}
