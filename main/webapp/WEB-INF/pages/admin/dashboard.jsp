<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Techno Complex Admin Dashboard</title>

<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
</head>
<body>
	<div class="dashboard-container">
		<!-- Sidebar -->
		<div class="sidebar">
			<div class="sidebar-header">
				<div class="logo">
					<i class="fas fa-microchip"></i>
				</div>
				<h3>Techno Complex</h3>
				<p>Admin Panel</p>
			</div>
			<div class="sidebar-menu">
				<div class="menu-item active">
					<i class="fas fa-th-large"></i> <span>Dashboard</span>
				</div>
				<div class="menu-item">
					<i class="fas fa-building"></i> <span>Manage Flat</span>
				</div>
				<div class="menu-item logout">
					<i class="fas fa-sign-out-alt"></i> <span>Log Out</span>
				</div>
			</div>
		</div>

		<!-- Main Content -->
		<div class="main-content">
			<div class="header">
				<div class="user-info">
					<img src="/api/placeholder/45/45" alt="Admin Avatar"> <span>Admin
						User</span>
				</div>
			</div>

			<div class="dashboard-content">
				<h2 class="section-title">Dashboard Overview</h2>
				<p>Welcome back, Admin User</p>

				<div class="dashboard-cards">
					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Total Flats</div>
								<div class="card-value">124</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-building"></i>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Occupied Flats</div>
								<div class="card-value">98</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-key"></i>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Vacant Flats</div>
								<div class="card-value">26</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-door-open"></i>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Total Revenue</div>
								<div class="card-value">$154,280</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-dollar-sign"></i>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-header">
							<div>
								<div class="card-title">Registered Users</div>
								<div class="card-value">218</div>
							</div>
							<div class="card-icon">
								<i class="fas fa-users"></i>
							</div>
						</div>
					</div>
				</div>

				<!-- Flat Table -->
				<div class="data-table-container">
					<div class="data-table-header">
						<h3>Flat Management</h3>
					</div>
					<table class="data-table">
						<thead>
							<tr>
								<th>Flat ID</th>
								<th>Image</th>
								<th>Name</th>
								<th>Category</th>
								<th>Price</th>
								<th>Size</th>
								<th>Living</th>
								<th>Bedroom</th>
								<th>Kitchen</th>
								<th>Furnished</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>#F-1024</td>
								<td><img src="/resources/images/T (1).png" alt="Flat"
									class="flat-image"></td>
								<td>Luxury Suite</td>
								<td>Premium</td>
								<td>$2,450</td>
								<td>1200 sq.ft</td>
								<td>1</td>
								<td>2</td>
								<td>1</td>
								<td>Yes</td>
								<td>Occupied</td>
							</tr>
							<tr>
								<td>#F-1022</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
								<td>Modern Studio</td>
								<td>Standard</td>
								<td>$1,180</td>
								<td>650 sq.ft</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>Yes</td>
								<td class="status status-pending">Maintenance</td>
							</tr>
							<tr>
								<td>#F-1019</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
								<td>Family Apartment</td>
								<td>Premium</td>
								<td>$3,200</td>
								<td>1850 sq.ft</td>
								<td>1</td>
								<td>3</td>
								<td>2</td>
								<td>Yes</td>
								<td class="status status-inactive">Vacant</td>
							</tr>
							<tr>
								<td>#F-1018</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
								<td>Cozy Loft</td>
								<td>Standard</td>
								<td>$950</td>
								<td>550 sq.ft</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>No</td>
								<td class="status status-active">Occupied</td>
							</tr>
							<tr>
								<td>#F-1015</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
								<td>Executive Suite</td>
								<td>Luxury</td>
								<td>$4,500</td>
								<td>2100 sq.ft</td>
								<td>2</td>
								<td>3</td>
								<td>2</td>
								<td>Yes</td>
								<td class="status status-active">Occupied</td>
							</tr>
						</tbody>
					</table>
				</div>

				<!-- User Table -->
				<div class="data-table-container">
					<div class="data-table-header">
						<h3>User Management</h3>
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
								<th>Role</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>#U-142</td>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>John Doe</td>
								<td>+1 234-567-8901</td>
								<td>john.doe@example.com</td>
								<td>1985-06-12</td>
								<td>Male</td>
								<td>johndoe</td>
								<td>Tenant</td>
							</tr>
							<tr>
								<td>#U-138</td>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>Sarah Johnson</td>
								<td>+1 345-678-9012</td>
								<td>sarah.j@example.com</td>
								<td>1992-11-23</td>
								<td>Female</td>
								<td>sarajohn</td>
								<td>Tenant</td>
							</tr>
							<tr>
								<td>#U-125</td>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>Michael Chen</td>
								<td>+1 456-789-0123</td>
								<td>michael.c@example.com</td>
								<td>1980-04-05</td>
								<td>Male</td>
								<td>mchen</td>
								<td>Landlord</td>
							</tr>
							<tr>
								<td>#U-119</td>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>Emily Wilson</td>
								<td>+1 567-890-1234</td>
								<td>emily.w@example.com</td>
								<td>1994-09-17</td>
								<td>Female</td>
								<td>ewilson</td>
								<td>Tenant</td>
							</tr>
							<tr>
								<td>#U-106</td>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>Robert Brown</td>
								<td>+1 678-901-2345</td>
								<td>robert.b@example.com</td>
								<td>1976-12-30</td>
								<td>Male</td>
								<td>rbrown</td>
								<td>Admin</td>
							</tr>
						</tbody>
					</table>
				</div>

				<!-- User_Flat Table -->
				<div class="data-table-container">
					<div class="data-table-header">
						<h3>User-Flat Relationship</h3>
					</div>
					<table class="data-table">
						<thead>
							<tr>
								<th>User Profile</th>
								<th>User Name</th>
								<th>Flat ID</th>
								<th>Flat Name</th>
								<th>Move In Date</th>
								<th>Flat Image</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>John Doe</td>
								<td>#F-1024</td>
								<td>Luxury Suite</td>
								<td>2024-09-01</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
							</tr>
							<tr>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>Sarah Johnson</td>
								<td>#F-1018</td>
								<td>Cozy Loft</td>
								<td>2024-10-15</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
							</tr>
							<tr>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>Emily Wilson</td>
								<td>#F-1015</td>
								<td>Executive Suite</td>
								<td>2024-07-22</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
							</tr>
							<tr>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>Michael Chen</td>
								<td>#F-1010</td>
								<td>Garden Apartment</td>
								<td>2025-01-05</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
							</tr>
							<tr>
								<td><img src="/api/placeholder/50/50" alt="User"
									class="user-avatar"></td>
								<td>David Smith</td>
								<td>#F-1008</td>
								<td>Urban Studio</td>
								<td>2024-11-30</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>