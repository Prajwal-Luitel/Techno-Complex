<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User Profile</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

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
	<form action="${contextPath}/profile" method="post" enctype="multipart/form-data">
		<div class="profile-box">
			<!-- Left Side -->
			<div class="profile-left">
				<img
					src="${pageContext.request.contextPath}/resources/images/customer/${user.profileImageUrl}"
					alt="Profile Picture" /> <input type="file" id="profileImage"
					name="profileImage" style="display: none;" /> <label
					for="profileImage" class="upload-btn">Upload Image</label>

				<div class="form-field" style="width: 100%;">
					<label for="username">Username</label> <input type="text"
						id="username" name="username" value="${user.userName}" />
				</div>

				<p class="role-text">${user.role}</p>
			</div>

			<!-- Right Side -->
			<div class="profile-right">
				<h2 class="title">Edit Profile</h2>
				<div class="form-group">
					<div class="form-field">
						<label for="name">Name</label> <input type="text" id="name"
							name="name" value="${user.name}" />
					</div>
					<div class="form-field">
						<label for="phone">Phone</label> <input type="text" id="phone"
							name="phone" value="${user.phone}" />
					</div>
					<div class="form-field">
						<label for="email">Email</label> <input type="email" id="email"
							name="email" value="${user.email}" />
					</div>
					<div class="form-field">
						<label for="dob">Date of Birth</label> <input type="date" id="dob"
							name="dob" value="${user.dob}" />
					</div>
					<div class="form-field">
						<label for="gender">Gender</label> <select id="gender"
							name="gender">
							<option value="Male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
							<option value="Female"
								${user.gender == 'Female' ? 'selected' : ''}>Female</option>
						</select>
					</div>
					<div class="form-field">
						<label for="password">Password</label> <input type="password"
							id="password" name="password" value="${user.password}" />
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
</html>
