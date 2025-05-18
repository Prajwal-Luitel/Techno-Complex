package com.technocomplex.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;
import jakarta.servlet.http.Part;

/**
 * Utility class for validating various input fields commonly used in forms,
 * such as names, email addresses, passwords, phone numbers, and dates.
 */
public class ValidationUtil {

	/**
	 * Checks if a string is null or empty after trimming whitespace.
	 *
	 * @param value The string to check
	 * @return true if the string is null or empty; false otherwise
	 */
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

	/**
	 * Checks if a string is null or empty after trimming whitespace.
	 *
	 * @param value The string to check
	 * @return true if the string is null or empty; false otherwise
	 */
	public static boolean isAlphabetic(String value) {
		return value != null && value.matches("^[a-zA-Z ]+$");
	}

	/**
	 * Checks if a string starts with a letter and contains only letters and digits.
	 *
	 * @param value The string to check
	 * @return true if the string is alphanumeric and starts with a letter; false
	 *         otherwise
	 */
	public static boolean isAlphanumericStartingWithLetter(String value) {
		return value != null && value.matches("^[a-zA-Z][a-zA-Z0-9]*$");
	}

	/**
	 * Validates if the input string matches either "male" or "female", ignoring
	 * case.
	 *
	 * @param value The gender string to check
	 * @return true if the string is "male" or "female"; false otherwise
	 */
	public static boolean isValidGender(String value) {
		return value != null && (value.equalsIgnoreCase("male") || value.equalsIgnoreCase("female"));
	}

	/**
	 * Validates the format of an email address using a regular expression.
	 *
	 * @param email The email string to check
	 * @return true if the email is in a valid format; false otherwise
	 */
	public static boolean isValidEmail(String email) {
		String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		return email != null && Pattern.matches(emailRegex, email);
	}

	/**
	 * Checks whether the input string is a 10-digit phone number starting with 98.
	 *
	 * @param number The phone number to check
	 * @return true if the phone number is valid; false otherwise
	 */
	public static boolean isValidPhoneNumber(String number) {
		return number != null && number.matches("^98\\d{8}$");
	}

	/**
	 * Validates whether a password contains at least one uppercase letter, one
	 * digit, one special character, and is at least 8 characters long.
	 *
	 * @param password The password string to validate
	 * @return true if the password meets all requirements; false otherwise
	 */
	public static boolean isValidPassword(String password) {
		String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		return password != null && password.matches(passwordRegex);
	}
 
	/**
	 * Validates if the file submitted as a Part object is an image with a supported
	 * extension: jpg, jpeg, png, or gif.
	 *
	 * @param imagePart The uploaded file part
	 * @return true if the file extension is a supported image type; false otherwise
	 */
	public static boolean isValidImageExtension(Part imagePart) {
		if (imagePart == null || isNullOrEmpty(imagePart.getSubmittedFileName())) {
			return false;
		}
		String fileName = imagePart.getSubmittedFileName().toLowerCase();
		return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")
				|| fileName.endsWith(".gif");
	}

	/**
	 * Checks whether the password and retyped password are equal.
	 *
	 * @param password       The original password
	 * @param retypePassword The retyped password
	 * @return true if both passwords match; false otherwise
	 */
	public static boolean doPasswordsMatch(String password, String retypePassword) {
		return password != null && password.equals(retypePassword);
	}

	/**
	 * Validates if the given date of birth is at least 16 years before the current
	 * date.
	 *
	 * @param dob The date of birth
	 * @return true if the person is at least 16 years old; false otherwise
	 */
	public static boolean isAgeAtLeast16(LocalDate dob) {
		if (dob == null) {
			return false;
		}
		LocalDate today = LocalDate.now();
		return Period.between(dob, today).getYears() >= 16;
	}
}
