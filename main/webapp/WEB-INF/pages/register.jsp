<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,jakarta.servlet.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<!-- Set contextPath variable for reuse -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/register.css" />
</head>

<body>
	<div class="wrapper">
		<form action="${contextPath}/register" method="post"
			enctype="multipart/form-data">
			<h2>Sign Up</h2>

			<!-- Display database error if present -->
			<c:if test="${not empty databaseError}">
				<p class="error">${databaseError}</p>
			</c:if>

			<div class="form-row">
				<div class="input-field">
					<!-- Error for name -->
					<c:if test="${not empty error[0]}">
						<p class="error">${error[0]}</p>
					</c:if>
					<input type="text" id="name" name="name" value="${name}" required>
					<label for="name">Name</label>
				</div>

				<div class="input-field">
					<!-- Error for phone -->
					<c:if test="${not empty error[1]}">
						<p class="error">${error[1]}</p>
					</c:if>
					<input type="number" id="phone" name="phone" value="${phone}"
						required> <label for="phone">Phone</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-field">
					<!-- Error for email -->
					<c:if test="${not empty error[2]}">
						<p class="error">${error[2]}</p>
					</c:if>
					<input type="email" id="email" name="email" placeholder=" "
						value="${email}" required> <label for="email">Email</label>
				</div>

				<div class="input-field date-field">
					<!-- Error for date of birth -->
					<c:if test="${not empty error[3]}">
						<p class="error">${error[3]}</p>
					</c:if>
					<input type="date" id="dob" name="dob" value="${dob}" required>
					<label for="dob">Date of Birth</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-field">
					<!-- Error for gender -->
					<c:if test="${not empty error[4]}">
						<p class="error">${error[4]}</p>
					</c:if>
					<select required id="gender" name="gender">
						<!-- <option value="" disabled selected hidden></option> -->
						<option value="male" ${gender == 'male' ? 'selected' : ''}>Male</option>
						<option value="female" ${gender == 'female' ? 'selected' : ''}>Female</option>
					</select> <label for="gender">Gender</label>
				</div>

				<div class="input-field">
					<!-- Error for username -->
					<c:if test="${not empty error[5]}">
						<p class="error">${error[5]}</p>
					</c:if>
					<input type="text" id="username" name="username"
						value="${username}" required> <label for="username">Username</label>
				</div>
			</div>

			<div class="form-row">
				<div class="input-field password-field">
					<!-- Error for password -->
					<c:if test="${not empty error[6]}">
						<p class="error">${error[6]}</p>
					</c:if>
					<input type="password" id="password" name="password"
						value="${password}" required> <i
						class="toggle-password fas fa-eye-slash"
						onclick="togglePasswordVisibility('password')"></i> <label
						for="password">Password</label>
				</div>

				<div class="input-field password-field">
					<!-- Error for retype password -->
					<c:if test="${not empty error[7]}">
						<p class="error">${error[7]}</p>
					</c:if>
					<input type="password" id="retypePassword" name="retypePassword"
						value="${retypePassword}" required> <i
						class="toggle-password fas fa-eye-slash"
						onclick="togglePasswordVisibility('retypePassword')"></i> <label
						for="retypePassword">Confirm Password</label>
				</div>
			</div>

			<div class="file-input">
				<!-- Error for profile image -->
				<c:if test="${not empty error[8]}">
					<p class="error">${error[8]}</p>
				</c:if>
				<input type="file" id="profile" name="profile" accept="image/*"
					required> <label for="profile"></label>
			</div>

			<!-- Success message if present -->
			<c:if test="${not empty success}">
				<p class="success">${success}</p>
			</c:if>

			<button type="submit">Sign Up</button>
		</form>

		<div class="login">
			<p>
				Already have an account? <a
					href="${pageContext.request.contextPath}/login">Login</a>
			</p>
		</div>
	</div>
</body>
<script>
    function togglePasswordVisibility(inputId) {
        const passwordInput = document.getElementById(inputId);
        const toggleIcon = passwordInput.nextElementSibling;
        
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            toggleIcon.classList.remove("fa-eye-slash");
            toggleIcon.classList.add("fa-eye");
        } else {
            passwordInput.type = "password";
            toggleIcon.classList.remove("fa-eye");
            toggleIcon.classList.add("fa-eye-slash");
        }
    }
</script>
</html>