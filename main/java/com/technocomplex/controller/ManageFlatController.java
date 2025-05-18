package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

import com.technocomplex.model.FlatModel;
import com.technocomplex.service.ManageFlatService;
import com.technocomplex.util.ImageUtil;

/*
 * @author Prajwal Luitel
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/manageflat" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ManageFlatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ImageUtil imageUtil;
	private final ManageFlatService manageFlatService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageFlatController() {
		super();
		this.imageUtil = new ImageUtil();
		this.manageFlatService = new ManageFlatService();
	}

	/**
	 * Handles GET requests to retrieve a list of flats for manageflat page
	 * 
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FlatModel> flatList = manageFlatService.getFlatList();
		request.setAttribute("flatList", flatList);
		request.getRequestDispatcher("WEB-INF/pages/admin/manageflat.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests to add, update, or delete a flat based on request
	 * parameters.
	 *
	 * @param req  the HttpServletRequest object
	 * @param resp the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String deleteId = req.getParameter("deleteId");
			String isEdit = req.getParameter("isEdit");
			if (isEdit != null && isEdit.equals("true")) {
				updateFlat(req, resp);
			} else if (deleteId != null && !deleteId.isEmpty()) {
				deleteFlat(req, resp);
			} else {
				addFlat(req, resp);
			}

		} catch (Exception e) {
			handleDataBaseError(req, resp, "An unexpected error occurred. Please try again later!");
			e.printStackTrace(); // Log the exception
		}
		doGet(req, resp);
	}

	/**
	 * Adds a new flat based on request parameters.
	 *
	 * @param req  the HttpServletRequest object
	 * @param resp the HttpServletResponse object
	 * @throws Exception if an error occurs while adding the flat
	 */
	private void addFlat(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		FlatModel flatModel = extractFlatModel(req);
		Boolean isAdded = manageFlatService.addFlat(flatModel);
	}

	/**
	 * Updates an existing flat based on request parameters.
	 *
	 * @param req  the HttpServletRequest object
	 * @param resp the HttpServletResponse object
	 * @throws Exception if an error occurs while updating the flat
	 */
	private void updateFlat(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		FlatModel flatModel = extractFlatModel(req);
		flatModel.setFlat_Id(Integer.parseInt(req.getParameter("flatId")));
		 Boolean isUpdated = manageFlatService.updateFlat(flatModel); 
	}

	/**
	 * Deletes a flat identified by the 'deleteId' parameter.
	 *
	 * @param req  the HttpServletRequest object
	 * @param resp the HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void deleteFlat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int flatId = Integer.parseInt(req.getParameter("deleteId"));
		Boolean isDeleted = manageFlatService.deleteFlat(flatId);
		if (isDeleted == null || !isDeleted) {
			handleDataBaseError(req, resp, "Our server is under maintenance. Please try again later!");
		}
	}
	
	/**
	 * Handles and displays database-related error messages.
	 *
	 * @param req     the HttpServletRequest object
	 * @param resp    the HttpServletResponse object
	 * @param message the error message to display
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleDataBaseError(HttpServletRequest req, HttpServletResponse resp, String message)
			throws ServletException, IOException {
		req.setAttribute("databaseError", message);
		req.getRequestDispatcher("/WEB-INF/pages/manageflat.jsp").forward(req, resp);
	}

	/**
	 * Extracts flat details from the request and creates a FlatModel object.
	 *
	 * @param req the HttpServletRequest object
	 * @return the FlatModel object populated with request parameters
	 * @throws Exception if an error occurs during parameter parsing or image
	 *                   processing
	 */
	private FlatModel extractFlatModel(HttpServletRequest req) throws Exception {

		String name = req.getParameter("name");
		String category = req.getParameter("category");
		int price = Integer.parseInt(req.getParameter("price"));
		int size = Integer.parseInt(req.getParameter("size"));
		int living = Integer.parseInt(req.getParameter("living"));
		int bedroom = Integer.parseInt(req.getParameter("bedroom"));
		int kitchen = Integer.parseInt(req.getParameter("kitchen"));
		String status = req.getParameter("status");
		String furnishing = req.getParameter("furnishing");

		Part image = req.getPart("flatImage");
		String imageUrl = imageUtil.getImageNameFromPart(image);

		return new FlatModel(name, category, price, size, living, bedroom, kitchen, furnishing, imageUrl, status);
	}
}
