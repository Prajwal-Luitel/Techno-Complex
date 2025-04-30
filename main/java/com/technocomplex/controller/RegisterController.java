package com.technocomplex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.technocomplex.model.UserModel;
import com.technocomplex.service.RegisterService;
import com.technocomplex.util.ImageUtil;
import com.technocomplex.util.PasswordUtil;
import com.technocomplex.util.ValidationUtil;

/**
 * RegisterController handles user registration requests and processes form
 * submissions. It also manages file uploads and account creation.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final ImageUtil imageUtil = new ImageUtil();
	private final RegisterService registerService = new RegisterService();

	/**
	 * Default constructor.
	 */
	public RegisterController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// Validate and extract student model
			String[] validationMessage = validateRegistrationForm(req);
			
			long  errorCount = Arrays.stream(validationMessage)
			      .filter(x -> x != null)
			      .count(); // return no of error
		
			if(errorCount != 0) { // validation message is present
				handleError(req, resp, validationMessage);
				System.out.println("Error 1"); 			
				return;
			}
			
			UserModel userModel = extractUserModel(req);
			Boolean isAdded = registerService.addUser(userModel); 
            System.out.println(isAdded);
			if (isAdded == null) {
				handleDataBaseError(req, resp, "Our server is under maintenance. Please try again later!");
			} else if (isAdded) {
				System.out.println("Error 2"); 	
				try {
					if (uploadImage(req)) {
						System.out.println("Error 3"); 	
						handleSuccess(req, resp, "Your account is successfully created!", "/WEB-INF/pages/register.jsp");
					} else {
						System.out.println("Error 4"); 	
						handleDataBaseError(req, resp, "Could not upload the image. Please try again later!");
					}
				} catch (IOException | ServletException e) {
					handleDataBaseError(req, resp, "An error occurred while uploading the image. Please try again later!");
					e.printStackTrace(); // Log the exception
				}
			} else {
				handleDataBaseError(req, resp, "Could not register your account. Please try again later!");
			}
		} catch (Exception e) {
			handleDataBaseError(req, resp, "An unexpected error occurred. Please try again later!");
			e.printStackTrace(); // Log the exception
		}
	}
		
	private String[] validateRegistrationForm(HttpServletRequest req) {
		String[] error = new String[9];

		String name = req.getParameter("name"); // 0
		String phone = req.getParameter("phone");// 1
		String email = req.getParameter("email");// 2
		String dobStr = req.getParameter("dob");// 3
		String gender = req.getParameter("gender");// 4
		String username = req.getParameter("username");// 5
		String password = req.getParameter("password");// 6
		String retypePassword = req.getParameter("retypePassword");// 7
       
		// Check for null or empty fields first
		if (ValidationUtil.isNullOrEmpty(name)) {
			error[0] = "Name is required.";
		} else if(!ValidationUtil.isAlphabetic(name)) {
			error[0] = "Name must be alphabetic.";
		}
			
		if (ValidationUtil.isNullOrEmpty(phone)){
			error[1] = "Phone is required.";
		} else if(!ValidationUtil.isValidPhoneNumber(phone)) {
			error[1] = "Phone number must be 10 digits and start with 98.";
		} else if(registerService.isPhoneTaken(phone)) {
			error[1] = "Phone number already exist.";
		}
			
		if (ValidationUtil.isNullOrEmpty(email)){
			error[2] = "Email is required.";
		} else if(!ValidationUtil.isValidEmail(email)) {
			error[2] = "Invalid email format.";
		} else if(registerService.isEmailTaken(email)) {
			error[2] = "Email already exist.";
		}
			
		if (ValidationUtil.isNullOrEmpty(dobStr)){
			error[3] = "Date of birth is required.";
		} else{
			LocalDate dob;
			try {
				dob = LocalDate.parse(dobStr);
				// Check if the date of birth is at least 16 years before today
				if (!ValidationUtil.isAgeAtLeast16(dob))
					error[3] = "You must be at least 16 years old to register.";
			} catch (Exception e) {
				error[3] = "Invalid date format. Please use YYYY-MM-DD.";
			}
		}
			
		if (ValidationUtil.isNullOrEmpty(gender)){
			error[4] = "Gender is required.";
		} else if (!ValidationUtil.isValidGender(gender)) {
			error[4] = "Gender must be 'male' or 'female'.";
		}
			
		if (ValidationUtil.isNullOrEmpty(username)){
			error[5] = "Username is required.";
		} else if(!ValidationUtil.isAlphanumericStartingWithLetter(username)) {
			error[5] = "Username must start with a letter and contain only letters and numbers.";
		} else if(registerService.isUsernameTaken(username)) {
			error[5] = "Username already exists.";
		}
			
		if (ValidationUtil.isNullOrEmpty(password)){
			error[6] = "Password is required.";
		} else if(!ValidationUtil.isValidPassword(password)) {
			error[6] = "Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.";
		}
			
		if (ValidationUtil.isNullOrEmpty(retypePassword)){
			error[7] = "Please retype the password.";
		} else if (!ValidationUtil.doPasswordsMatch(password, retypePassword)) {
			error[7] = "Passwords do not match.";
		}
		

		try {
			Part image = req.getPart("profile");
			if (!ValidationUtil.isValidImageExtension(image)) {
				error[8] = "Invalid image format. Only jpg, jpeg, png, and gif are allowed.";
			}
		} catch (IOException | ServletException e) {
			error[8] = "Error handling image file. Please ensure the file is valid.";
		}

		return error; 
	}

	private UserModel extractUserModel(HttpServletRequest req) throws Exception {
	
		String name = req.getParameter("name"); 
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		

		// Assuming password validation is already done in validateRegistrationForm
		password = PasswordUtil.encrypt(username, password);

		Part image = req.getPart("profile");
		String imageUrl = imageUtil.getImageNameFromPart(image);

		return new UserModel(name, phone, email, dob, gender, username, password, imageUrl);
	}

	private boolean uploadImage(HttpServletRequest req) throws IOException, ServletException {
		Part image = req.getPart("profile");
		return imageUtil.uploadImage(image, req.getServletContext().getRealPath("/"), "customer");
	}

	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
			throws ServletException, IOException {
		req.setAttribute("success", message);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
	}

	private void handleError(HttpServletRequest req, HttpServletResponse resp, String[] message)
			throws ServletException, IOException {
		req.setAttribute("error", message);
		req.setAttribute("name", req.getParameter("name"));
		req.setAttribute("phone", req.getParameter("phone"));
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("dob", req.getParameter("dob"));
		req.setAttribute("gender", req.getParameter("gender"));
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}

	private void handleDataBaseError(HttpServletRequest req, HttpServletResponse resp,String message)
			throws ServletException, IOException {
		req.setAttribute("databaseError", message);
		req.setAttribute("name", req.getParameter("name"));
		req.setAttribute("phone", req.getParameter("phone"));
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("dob", req.getParameter("dob"));
		req.setAttribute("gender", req.getParameter("gender"));
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}
}
