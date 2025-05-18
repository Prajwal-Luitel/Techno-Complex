<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,jakarta.servlet.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<title>Flat</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/flat.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body>
	<nav>
		<div class="logo">
			<a href="${contextPath}/home"><img
				src="${pageContext.request.contextPath}/resources/images/system/logo.png"
				alt="logo" /></a>
			<div class="logo-text">
				<span>Techno</span> <span>Complex</span>
			</div>
		</div>

		<form class="search-form"
			action="${pageContext.request.contextPath}/flat" method="get">
			<div class="search-container">
				<input type="text" name="searchQuery"
					placeholder="Search apartments, locations..." value="${searchQuery}">
				<button type="submit">
					<i class="fas fa-search"></i>
				</button>

				<!-- Hidden fields to carry filter/sort data -->
				<input type="hidden" name="category" value="any"> <input
					type="hidden" name="sort" value="low">
			</div>
		</form>



		<div class="nav-links">
			<a href="${pageContext.request.contextPath}/home">Home</a> <a
				href="${pageContext.request.contextPath}/flat">Flat</a> <a
				href="${pageContext.request.contextPath}/about">About</a> <a
				href="${pageContext.request.contextPath}/contact">Contact</a>

			<div class="profile-container">
				<img
					src="${pageContext.request.contextPath}/resources/images/customer/${profileUrl}"
					alt="Profile" class="profile-pic">
				<div class="profile-dropdown">
					<a href="${pageContext.request.contextPath}/profile">Profile</a> <a
						href="${pageContext.request.contextPath}/myflat">My Flats</a>
					<!-- <a href="#">Logout</a>  -->
					<form action="${pageContext.request.contextPath}/logout"
						method="post">
						<button type="submit" class="logout-btn">Logout</button>
					</form>

				</div>
			</div>
		</div>
	</nav>
	<main>
		<aside class="sidebar">

			<div class="filter-section">
				<h2>Filters</h2>
				<h3>Category</h3>
				<div class="category-item">
					<input type="radio" id="any" name="category" value="any" checked >
					<div class="custom-radio"></div>
					<label for="any">Any</label>
				</div>
				<div class="category-item">
					<input type="radio" id="studio" value="studio" name="category" ${category == 'studio' ? 'checked' : ''}>
					<div class="custom-radio"></div>
					<label for="studio">Studio</label>
				</div>
				<div class="category-item">
					<input type="radio" id="duplex" value="duplex" name="category" ${category == 'duplex' ? 'checked' : ''}>
					<div class="custom-radio"></div>
					<label for="duplex">Duplex</label>
				</div>
				<div class="category-item">
					<input type="radio" id="garden" value="garden" name="category" ${category == 'garden' ? 'checked' : ''}>
					<div class="custom-radio"></div>
					<label for="garden">Garden</label>
				</div>
				<div class="category-item">
					<input type="radio" id="loft" value="loft" name="category" ${category == 'loft' ? 'checked' : ''}>
					<div class="custom-radio"></div>
					<label for="loft">Loft</label>
				</div>
				<div class="category-item">
					<input type="radio" id="penthouse" value="penthouse"
						name="category" ${category == 'penthouse' ? 'checked' : ''}>
					<div class="custom-radio"></div>
					<label for="penthouse">Penthouse</label>
				</div>
			</div>

			<div class="filter-section">
				<h3>Sort By</h3>
				<select class="sort-select" name="sort">
					<option value="low" ${sort == 'low' ? 'selected' : ''}>Price: Low to High</option>
					<option value="high" ${sort == 'high' ? 'selected' : ''} >Price: High to Low</option>
				</select>
			</div>
		</aside>

		<section class="content">

			<c:if test="${empty flatList}">
				<div class="empty-flat">No apartments found matching your
					search criteria.</div>
			</c:if>
			<div class="apartments-grid">
				<!-- Apartment 1 -->
				<c:forEach items="${flatList}" var="flat">
					<div class="apartment-card">
						<img
							src="${pageContext.request.contextPath}/resources/images/flat/${flat.image_Path}"
							class="apartment-image" alt="${flat.name}">
						<div class="apartment-details">
							<div class="apartment-header">
								<h2 class="apartment-name">${flat.name}</h2>
								<div class="furnished-status">${flat.furnishing}</div>
							</div>

							<div class="apartment-category-container">
								<div class="apartment-category">${flat.category}</div>
							</div>

							<div class="apartment-specs">
								<div class="spec-item">
									<span class="spec-label">Size:</span> <span class="spec-value">${flat.size}
										sq.ft</span>
								</div>
								<div class="spec-item">
									<span class="spec-label">Living:</span> <span
										class="spec-value">${flat.livingroom}</span>
								</div>
								<div class="spec-item">
									<span class="spec-label">Bedroom:</span> <span
										class="spec-value">${flat.bedroom}</span>
								</div>
								<div class="spec-item">
									<span class="spec-label">Kitchen:</span> <span
										class="spec-value">${flat.kitchen}</span>
								</div>
							</div>

							<div class="apartment-price">Rs. ${flat.price}/month</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</main>
	<jsp:include page="footer.jsp" />
</body>

<script>
	document
			.querySelector('.search-form')
			.addEventListener(
					'submit',
					function(e) {
						// Get selected category
						const selectedCategory = document
								.querySelector('input[name="category"]:checked');
						if (selectedCategory) {
							this.querySelector('input[name="category"]').value = selectedCategory.value;
						}

						// Get selected sort option
						const selectedSort = document
								.querySelector('.sort-select');
						if (selectedSort) {
							this.querySelector('input[name="sort"]').value = selectedSort.value;
						}
					});
</script>



</html>