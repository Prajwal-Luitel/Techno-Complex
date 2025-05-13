package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.technocomplex.model.User_FlatModel;
import com.technocomplex.service.DashboardService;

/*
 * @author Prajwal Luitel
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/dashboard"})
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DashboardService dashboardService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
        this.dashboardService = new DashboardService();
    }


    /**
	 * Handles GET requests for Dashboard.
	 * Dashboard show 5 statistical data and booking table
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   List<User_FlatModel> userFlatList = dashboardService.getUserFlatInformation();
		   
		    request.setAttribute("monthlyRevenue", dashboardService.getMonthlyRevenue());
		    request.setAttribute("popularFlatCategory", dashboardService.getPopularFlatCategory());
		    request.setAttribute("highestFlatPrice", dashboardService.getHigestFlatPrice());
		    request.setAttribute("recentlyBookedFlat", dashboardService.getRecentlyBookedFlat());
		    request.setAttribute("flatBookedThisMonth", dashboardService.getFlatBookedThisMonth());
		    
			request.setAttribute("userFlatList", userFlatList);
		    request.getRequestDispatcher("/WEB-INF/pages/admin/dashboard.jsp").forward(request, response);
	}
}

