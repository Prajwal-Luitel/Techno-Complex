<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,jakarta.servlet.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Techno Complex Admin Dashboard</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
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
            <a href="${pageContext.request.contextPath}/dashboard" class="menu-item active">
                <i class="fas fa-th-large"></i> <span>Dashboard</span>
            </a>
            <a href="${pageContext.request.contextPath}/manageflat" class="menu-item">
                <i class="fas fa-building"></i> <span>Manage Flat</span>
            </a>
            <a href="${pageContext.request.contextPath}/customer" class="menu-item">
                <i class="fas fa-users"></i> <span>Customer</span>
            </a>
            <a href="${pageContext.request.contextPath}/logout" class="menu-item logout">
                <i class="fas fa-sign-out-alt"></i> <span>Log Out</span>
            </a>
        </div>
		</div>
		<!-- Main Content -->
		<div class="main-content">
			<!-- div class="header">
				<div class="user-info">
					<img src="/api/placeholder/45/45" alt="Admin Avatar"> <span>Admin
						User</span>
				</div>
			</div> -->

			<div class="dashboard-content">
				<h2 class="section-title">Dashboard Overview</h2>
				<p>Welcome back, Admin User</p>

				<%-- <div class="dashboard-cards">
					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Monthly Revenue</div>
								<div class="card-value">${monthlyRevenue}</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-building"></i>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Popular Flat Category</div>
								<div class="card-value">${popularFlatCategory}</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-key"></i>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Highest Flat Price</div>
								<div class="card-value">${highestFlatPrice}</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-door-open"></i>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Recently Booked Flat</div>
								<div class="card-value">${recentlyBookedFlat}</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-dollar-sign"></i>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Flat Booked This Month</div>
								<div class="card-value">${flatBookedThisMonth}</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-users"></i>
							</div>
						</div>
					</div>
				</div> --%>
				<div class="dashboard-cards">
  <div class="card">
    <div class="card-header">
      <div>
        <div class="card-title">Monthly Revenue</div>
        <div class="card-value">${monthlyRevenue}</div>
      </div>
      <div class="card-icon">
        <i class="fas fa-chart-line"></i>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header">
      <div>
        <div class="card-title">Popular Flat Category</div>
        <div class="card-value">${popularFlatCategory}</div>
      </div>
      <div class="card-icon">
        <i class="fas fa-home"></i>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header">
      <div>
        <div class="card-title">Highest Flat Price</div>
        <div class="card-value">${highestFlatPrice}</div>
      </div>
            <div class="card-icon">
        <i class="fas fa-coins"></i>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header">
      <div>
        <div class="card-title">Recently Booked Flat</div>
        <div class="card-value">${recentlyBookedFlat}</div>
      </div>
      <div class="card-icon">
        <i class="fas fa-calendar-check"></i>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header">
      <div>
        <div class="card-title">Flat Booked This Month</div>
        <div class="card-value">${flatBookedThisMonth}</div>
      </div>
      <div class="card-icon">
        <i class="fas fa-clipboard-list"></i>
      </div>
    </div>
  </div>
</div>

				<!-- User_Flat Table -->
				<div class="data-table-container">
					<div class="data-table-header">
						<h3>Active Flat</h3>
					</div>
					<table class="data-table">
						<thead>
							<tr>
								<th>User Id</th>
								<th>User Profile</th>
								<th>User Name</th>
								<th>Flat ID</th>
								<th>Flat Name</th>
								<th>Move In Date</th>
								<th>Flat Image</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="userFlat" items="${userFlatList}">
								<tr>
									<td>${userFlat.userId}</td>
									<td><img src="${pageContext.request.contextPath}/resources/images/customer/${userFlat.profile}" alt="User"
										class="user-avatar" /></td>
									<td>${userFlat.userName}</td>
									<td>${userFlat.flat_Id}</td>
									<td>${userFlat.flatName}</td>
									<td>${userFlat.move_In_Date}</td>
									<td><img src="${pageContext.request.contextPath}/resources/images/flat/${userFlat.flatImage}" alt="Flat"
										class="flat-image" /></td>
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