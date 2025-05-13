<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User Profile</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/profile.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="profile-body">
		<form action="${contextPath}/profile" method="post"
			enctype="multipart/form-data">
			<div class="profile-box">
				<!-- Left Side -->
				<div class="profile-left">
					<!--  Error for profile image  -->
					<c:if test="${not empty error[8]}">
						<p class="error">${error[8]}</p>
					</c:if>
					<img
						src="${pageContext.request.contextPath}/resources/images/customer/${user.profileImageUrl}"
						id="preview" alt="Profile Picture" /> <input type="file"
						id="profileImage" name="profileImage" accept="image/*"
						style="display: none;" onchange="previewImage()" /> <label
						for="profileImage" class="upload-btn">Upload Image</label>

					<div class="form-field" style="width: 100%;">
						<!-- Error for username  -->
						<c:if test="${not empty error[5]}">
							<p class="error">${error[5]}</p>
						</c:if>
						<label for="username">Username</label> <input type="text"
							id="username" name="username" value="${user.userName}" required/>
					</div>

					<p class="role-text">${user.role}</p>
				</div>

				<!-- Right Side -->
				<div class="profile-right">
					<h2 class="title">Edit Profile</h2>
					<div class="form-group">
						<div class="form-field">
							<!-- Error for name -->
							<c:if test="${not empty error[0]}">
								<p class="error">${error[0]}</p>
							</c:if>
							<label for="name">Name</label> <input type="text" id="name"
								name="name" value="${user.name}" required />
						</div>
						<div class="form-field">
							<!-- Error for phone -->
							<c:if test="${not empty error[1]}">
								<p class="error">${error[1]}</p>
							</c:if>
							<label for="phone">Phone</label> <input type="text" id="phone"
								name="phone" value="${user.phone}" required />
						</div>
						<div class="form-field">
							<!-- Error for email -->
							<c:if test="${not empty error[2]}">
								<p class="error">${error[2]}</p>
							</c:if>
							<label for="email">Email</label> <input type="email" id="email"
								name="email" value="${user.email}" required />
						</div>
						<div class="form-field">
							<!-- Error for date of birth -->
							<c:if test="${not empty error[3]}">
								<p class="error">${error[3]}</p>
							</c:if>
							<label for="dob">Date of Birth</label> <input type="date"
								id="dob" name="dob" value="${user.dob}" required />
						</div>
						<div class="form-field">
							<!-- Error for gender -->
							<c:if test="${not empty error[4]}">
								<p class="error">${error[4]}</p>
							</c:if>
							<label for="gender">Gender</label> <select id="gender"
								name="gender">
								<option value="Male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
								<option value="Female"
									${user.gender == 'Female' ? 'selected' : ''}>Female</option>
							</select>
						</div>
						<div class="form-field">
							<!-- Error for password -->
							<c:if test="${not empty error[6]}">
								<p class="error">${error[6]}</p>
							</c:if>
							<label for="password">Password</label> <input type="password"
								id="password" name="password" value="${user.password}" required />
						</div>
					</div>
					<div class="form-buttons">
						<button type="submit" class="btn-save">Save Changes</button>
					</div>
				</div>

			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>

<script>
	function previewImage() {
		var file = document.getElementById("profileImage").files
		if (file.length > 0) {
			var fileReader = new FileReader()

			fileReader.onload = function(event) {
				document.getElementById("preview").setAttribute("src",
						event.target.result)
			}

			fileReader.readAsDataURL(file[0])
		}
	}
</script>
</html>
