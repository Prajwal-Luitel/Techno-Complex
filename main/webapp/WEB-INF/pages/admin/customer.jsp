<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,jakarta.servlet.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Techno Complex Admin - Manage Flats</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/customer.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
	<div class="dashboard-container">
		<!-- Sidebar -->
		<div class="sidebar">
			<div class="sidebar-header">
				<div class="logo">
					 <img src="${pageContext.request.contextPath}/resources/images/system/logo.png" alt="Admin Avatar"> 
				</div>
				<h3>Techno Complex</h3>
				<p>Admin Panel</p>
			</div>
			<div class="sidebar-menu">
            <a href="${pageContext.request.contextPath}/dashboard" class="menu-item">
                <i class="fas fa-th-large"></i> <span>Dashboard</span>
            </a>
            <a href="${pageContext.request.contextPath}/manageflat" class="menu-item">
                <i class="fas fa-building"></i> <span>Manage Flat</span>
            </a>
            <a href="${pageContext.request.contextPath}/customer" class="menu-item active">
                <i class="fas fa-users"></i> <span>Customer</span>
            </a>
            <a href="${pageContext.request.contextPath}/logout" class="menu-item logout">
                <i class="fas fa-sign-out-alt"></i> <span>Log Out</span>
            </a>
        </div>
		</div>

		<!-- Main Content -->
		<div class="main-content">
			
			<div class="dashboard-content">
				<h2 class="section-title">Customer</h2>

				<div class="data-table-container">
					<div class="data-table-header">
						<h3>Customer Lists</h3>
					</div>
					<table class="data-table">
						<thead>
							<tr>
								<th>User ID</th>
								<th>Profile</th>
								<th>Name</th>
								<th>Phone</th>
								<th>Email</th>
								<th>DOB</th>
								<th>Gender</th>
								<th>Username</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="user">
								<tr>
									<td>${user.userId}</td>
									<td><img
										src="${pageContext.request.contextPath}/resources/images/customer/${user.profileImageUrl}"
										class="user-avatar"></td>
									<td>${user.name}</td>
									<td>${user.phone}</td>
									<td>${user.email}</td>
									<td>${user.dob}</td>
									<td>${user.gender}</td>
									<td>${user.userName}</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>