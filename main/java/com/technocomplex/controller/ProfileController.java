
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
import com.technocomplex.service.ProfilePicService;
import com.technocomplex.service.ProfileService;
import com.technocomplex.util.CookieUtil;
import com.technocomplex.util.ImageUtil;
import com.technocomplex.util.PasswordUtil;
import com.technocomplex.util.SessionUtil;
import com.technocomplex.util.ValidationUtil;

/**
 * LoginController is responsible for handling login requests. It interacts with
 * the LoginService to authenticate users.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/profile" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ImageUtil imageUtil;
	private final ProfileService profileService;
	private final ProfilePicService profilePicService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileController() {
		this.imageUtil = new ImageUtil();
		this.profileService = new ProfileService();
		this.profilePicService = new ProfilePicService();
	}

	/**
	 * Handles GET requests to display the user's profile. Retrieves the logged-in
	 * user's information from the session and uses the profileService to load user
	 * details and profile picture URL.
	 * 
	 * @param request  HttpServletRequest containing session and request info
	 * @param response HttpServletResponse to forward the result
	 * @throws ServletException if servlet-specific error occurs
	 * @throws IOException      if I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("username") != null) {
			String username = (String) SessionUtil.getAttribute(request, "username");

			UserModel userModel = profileService.getUserInformation(username);
			userModel.setPassword(PasswordUtil.decrypt(userModel.getPassword(), username));

			String profileUrl = profilePicService
					.getUserProfile((String) SessionUtil.getAttribute(request, "username"));
			request.setAttribute("profileUrl", profileUrl);
			request.setAttribute("user", userModel);
		}
		request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
	}

	/**
	 * Handles the HTTP POST request to update the user's profile information.
	 * 
	 * @param req  the HttpServletRequest object that contains the request from the
	 *             client
	 * @param resp the HttpServletResponse object to assist in sending a response
	 * @throws ServletException if the request could not be handled
	 * @throws IOException      if an input or output error occurs
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// If userId is null catch block will handle it
			Integer userId = profileService.getUserId((String) req.getSession().getAttribute("username"));

			// Validate and extract student model
			String[] validationMessage = validateRegistrationForm(req, userId);
			long errorCount = Arrays.stream(validationMessage).filter(x -> x != null).count(); // return no of error

			if (errorCount != 0) { // validation message is present
				handleError(req, resp, validationMessage);
				return;
			}
			UserModel userModel = extractUserModel(req);
			Boolean isAdded = profileService.updateUser(userModel);
			if (isAdded == null) {
				handleDataBaseError(req, resp, "Our server is under maintenance. Please try again later!");
			} else if (isAdded) {
				try {
					if (uploadImage(req)) {
						// Save the updated username in the session.
						SessionUtil.setAttribute(req, "username", req.getParameter("username"));
						handleSuccess(req, resp, "Your Profile is successfully Updated!", "/WEB-INF/pages/profile.jsp");
					} else {
						handleDataBaseError(req, resp, "Could not upload the image. Please try again later!");
					}
				} catch (IOException | ServletException e) {
					handleDataBaseError(req, resp,
							"An error occurred while uploading the image. Please try again later!");
					e.printStackTrace(); // Log the exception
				}
			} else {
				handleDataBaseError(req, resp, "Could not Update your profile. Please try again later!");
			}
		} catch (Exception e) {
			handleDataBaseError(req, resp, "An unexpected error occurred. Please try again later!");
			e.printStackTrace(); // Log the exception
		}
	}

	/**
	 * Validates user-submitted form fields for profile update.
	 * 
	 *
	 * @param req           the HttpServletRequest containing form parameters
	 * @param currentUserId the ID of the currently logged-in user for uniqueness
	 *                      checks
	 * @return an array of error messages for each field; null values indicate no
	 *         errors
	 */
	private String[] validateRegistrationForm(HttpServletRequest req, int currentUserId) {
		String[] error = new String[9];

		String name = req.getParameter("name"); // 0
		String phone = req.getParameter("phone");// 1
		String email = req.getParameter("email");// 2
		String dobStr = req.getParameter("dob");// 3
		String gender = req.getParameter("gender");// 4
		String username = req.getParameter("username");// 5
		String password = req.getParameter("password");// 6

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
		} else if (profileService.isPhoneTaken(phone, currentUserId)) {
			error[1] = "Phone number already exist.";
		}

		if (ValidationUtil.isNullOrEmpty(email)) {
			error[2] = "Email is required.";
		} else if (!ValidationUtil.isValidEmail(email)) {
			error[2] = "Invalid email format.";
		} else if (profileService.isEmailTaken(email, currentUserId)) {
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
		} else if (profileService.isUsernameTaken(username, currentUserId)) {
			error[5] = "Username already exists.";
		}

		if (ValidationUtil.isNullOrEmpty(password)) {
			error[6] = "Password is required.";
		} else if (!ValidationUtil.isValidPassword(password)) {
			error[6] = "Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.";
		}

		try {
			Part image = req.getPart("profileImage");
			if (image != null && image.getSize() > 0) {
				if (!ValidationUtil.isValidImageExtension(image)) {
					error[8] = "Invalid image format. Only jpg, jpeg, png, and gif are allowed.";
				}
			}

		} catch (IOException | ServletException e) {
			error[8] = "Error handling image file. Please ensure the file is valid.";
		}

		return error;
	}

	/**
	 * Extracts form values and constructs a UserModel object from the HTTP request.
	 * Reuses the old image URL if no new image is uploaded.
	 *
	 * @param req the HttpServletRequest containing form parameters
	 * @return a fully constructed UserModel object based on the form input
	 * @throws Exception if an error occurs during parsing or data retrieval
	 */
	private UserModel extractUserModel(HttpServletRequest req) throws Exception {
		Integer userId = profileService.getUserId((String) req.getSession().getAttribute("username"));
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// password validation is already done in validateRegistrationForm
		password = PasswordUtil.encrypt(username, password);

		Part image = req.getPart("profileImage");

		String imageUrl;

		if (image != null && image.getSize() > 0) {
			imageUrl = imageUtil.getImageNameFromPart(image);
		} else {
			// Fallback to old image if not updated
			imageUrl = profileService.getUserInformation((String) req.getSession().getAttribute("username"))
					.getProfileImageUrl();
		}

		return new UserModel(userId, name, phone, email, dob, gender, username, password, imageUrl);
	}

	/**
	 * Uploads the user's profile image to the server.
	 *
	 * @param req the HttpServletRequest containing the image part
	 * @return true if the upload is successful, false otherwise
	 * @throws IOException      if an I/O error occurs during upload
	 * @throws ServletException if a servlet-specific error occurs
	 */
	private boolean uploadImage(HttpServletRequest req) throws IOException, ServletException {
		Part image = req.getPart("profileImage");
		return imageUtil.uploadImage(image, req.getServletContext().getRealPath("/"), "customer");
	}

	/**
	 * Handles a successful profile update.
	 *
	 * @param req          the HttpServletRequest object
	 * @param resp         the HttpServletResponse object
	 * @param message      the success message to be shown
	 * @param redirectPage the path of the JSP page to forward to
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
			throws ServletException, IOException {
		resendData(req);
		req.setAttribute("success", message);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
	}

	/**
	 * Reloads form data into request attributes to repopulate the form after
	 * submission. Uses existing image if no new image is provided.
	 *
	 * @param req the HttpServletRequest object containing form parameters
	 * @throws IOException      if an I/O error occurs
	 * @throws ServletException if a servlet-specific error occurs
	 */

	private void resendData(HttpServletRequest req) throws IOException, ServletException {
		Part image = req.getPart("profileImage");

		String imageUrl;

		if (image != null && image.getSize() > 0) {
			imageUrl = imageUtil.getImageNameFromPart(image);
		} else {
			// Fallback to old image if not updated
			imageUrl = profileService.getUserInformation((String) req.getSession().getAttribute("username"))
					.getProfileImageUrl();
		}

		UserModel userModel = new UserModel(req.getParameter("name"), req.getParameter("phone"),
				req.getParameter("email"), LocalDate.parse(req.getParameter("dob")), req.getParameter("gender"),
				req.getParameter("username"), req.getParameter("password"),
				CookieUtil.getCookie(req, "role").getValue(), // role
				imageUrl);
		req.setAttribute("user", userModel);
	}

	/**
	 * Handles validation errors by redisplaying the form with error messages.
	 *
	 * @param req     the HttpServletRequest object
	 * @param resp    the HttpServletResponse object
	 * @param message an array of validation error messages
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleError(HttpServletRequest req, HttpServletResponse resp, String[] message)
			throws ServletException, IOException {
		resendData(req);
		req.setAttribute("error", message);
		req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
	}

	/**
	 * Handles unexpected or database-related errors.
	 * 
	 * @param req     the HttpServletRequest object
	 * @param resp    the HttpServletResponse object
	 * @param message the error message to be shown
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleDataBaseError(HttpServletRequest req, HttpServletResponse resp, String message)
			throws ServletException, IOException {

		resendData(req);
		req.setAttribute("databaseError", message);
		req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
	}
}
