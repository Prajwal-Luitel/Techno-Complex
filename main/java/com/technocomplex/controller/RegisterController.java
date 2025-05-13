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
import java.util.Arrays;

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

	private final ImageUtil imageUtil;
	private final RegisterService registerService;

	/**
	 * Default constructor.
	 */
	public RegisterController() {
		super();
		this.imageUtil = new ImageUtil();
		this.registerService = new RegisterService();
	}

	/**
	 * Handles GET requests for user registration.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
	}

	/**
	 * Handles the HTTP POST request for user registration. Validates input, creates
	 * a user model, attempts to store user data, handles image upload, and manages
	 * success or error responses.
	 *
	 * @param request  HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Validate and extract student model
			String[] validationMessage = validateRegistrationForm(req);

			long errorCount = Arrays.stream(validationMessage).filter(x -> x != null).count(); // return no of error

			if (errorCount != 0) { // validation message is present
				handleError(req, resp, validationMessage);
				return;
			}

			UserModel userModel = extractUserModel(req);
			Boolean isAdded = registerService.addUser(userModel);

			if (isAdded == null) {
				handleDataBaseError(req, resp, "Our server is under maintenance. Please try again later!");
			} else if (isAdded) {
				try {
					if (uploadImage(req)) {
						handleSuccess(req, resp, "Your account is successfully created!",
								"/WEB-INF/pages/register.jsp");
					} else {
						handleDataBaseError(req, resp, "Could not upload the image. Please try again later!");
					}
				} catch (IOException | ServletException e) {
					handleDataBaseError(req, resp,
							"An error occurred while uploading the image. Please try again later!");
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

	/**
	 * Validates the user registration form fields name, phone, email, date of
	 * birth, gender, username, password, and profile image.
	 *
	 * @param req the HttpServletRequest object
	 * @return an array of validation error messages corresponding to each input
	 *         field
	 */
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
		} else if (!ValidationUtil.isAlphabetic(name)) {
			error[0] = "Name must be alphabetic.";
		}

		if (ValidationUtil.isNullOrEmpty(phone)) {
			error[1] = "Phone is required.";
		} else if (!ValidationUtil.isValidPhoneNumber(phone)) {
			error[1] = "Phone number must be 10 digits and start with 98.";
		} else if (registerService.isPhoneTaken(phone)) {
			error[1] = "Phone number already exist.";
		}

		if (ValidationUtil.isNullOrEmpty(email)) {
			error[2] = "Email is required.";
		} else if (!ValidationUtil.isValidEmail(email)) {
			error[2] = "Invalid email format.";
		} else if (registerService.isEmailTaken(email)) {
			error[2] = "Email already exist.";
		}

		if (ValidationUtil.isNullOrEmpty(dobStr)) {
			error[3] = "Date of birth is required.";
		} else {
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

		if (ValidationUtil.isNullOrEmpty(gender)) {
			error[4] = "Gender is required.";
		} else if (!ValidationUtil.isValidGender(gender)) {
			error[4] = "Gender must be 'male' or 'female'.";
		}

		if (ValidationUtil.isNullOrEmpty(username)) {
			error[5] = "Username is required.";
		} else if (!ValidationUtil.isAlphanumericStartingWithLetter(username)) {
			error[5] = "Username must start with a letter and contain only letters and numbers.";
		} else if (registerService.isUsernameTaken(username)) {
			error[5] = "Username already exists.";
		}

		if (ValidationUtil.isNullOrEmpty(password)) {
			error[6] = "Password is required.";
		} else if (!ValidationUtil.isValidPassword(password)) {
			error[6] = "Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.";
		}

		if (ValidationUtil.isNullOrEmpty(retypePassword)) {
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

	/**
	 * Extracts user input from the request and creates a UserModel instance.
	 * Encrypts the password and generates image name from uploaded file.
	 *
	 * @param req the HttpServletRequest object
	 * @return a populated UserModel object
	 * @throws Exception if any error occurs during parameter extraction or
	 *                   encryption
	 */
	private UserModel extractUserModel(HttpServletRequest req) throws Exception {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// Password validation is already done in validateRegistrationForm
		password = PasswordUtil.encrypt(username, password);

		Part image = req.getPart("profile");
		String imageUrl = imageUtil.getImageNameFromPart(image);

		return new UserModel(name, phone, email, dob, gender, username, password, imageUrl);
	}

	/**
	 * Uploads the profile image file submitted with the registration form.
	 *
	 * @param req the HttpServletRequest containing the image file
	 * @return true if the image was uploaded successfully, false otherwise
	 * @throws IOException      if an I/O error occurs during file processing
	 * @throws ServletException if a servlet-specific error occurs during file
	 *                          retrieval
	 */
	private boolean uploadImage(HttpServletRequest req) throws IOException, ServletException {
		Part image = req.getPart("profile");
		return imageUtil.uploadImage(image, req.getServletContext().getRealPath("/"), "customer");
	}

	/**
	 * Handles successful user registration by setting a success message and
	 * forwarding the request to the appropriate JSP page.
	 *
	 * @param req          the HttpServletRequest object
	 * @param resp         the HttpServletResponse object
	 * @param message      the success message to be displayed
	 * @param redirectPage the path of the JSP page to be forwarded to
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs during forwarding
	 */
	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
			throws ServletException, IOException {
		req.setAttribute("success", message);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
	}

	/**
	 * Handles validation errors by setting error messages and previously entered
	 * data back to the registration form and forwarding the request to the form
	 * page.
	 *
	 * @param req     the HttpServletRequest object
	 * @param resp    the HttpServletResponse object
	 * @param message the array of error messages
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs during forwarding
	 */
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

	/**
	 * Handles database or unexpected server errors during registration process.
	 *
	 * @param req     the HttpServletRequest object
	 * @param resp    the HttpServletResponse object
	 * @param message the database or server error message
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs during forwarding
	 */
	private void handleDataBaseError(HttpServletRequest req, HttpServletResponse resp, String message)
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
