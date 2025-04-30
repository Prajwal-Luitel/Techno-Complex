<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Flat</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/about.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/flat.css" />
</head>
<body>
<jsp:include page="header.jsp" />
	<main>
		<aside class="sidebar">
			<div class="filter-section">
				<h2>Filters</h2>
				<h3>Category</h3>
				<div class="category-item">
					<input type="radio" id="any" name="category" checked>
					<div class="custom-radio"></div>
					<label for="any">Any</label>
				</div>
				<div class="category-item">
					<input type="radio" id="studio" name="category">
					<div class="custom-radio"></div>
					<label for="studio">Studio</label>
				</div>
				<div class="category-item">
					<input type="radio" id="duplex" name="category">
					<div class="custom-radio"></div>
					<label for="duplex">Duplex</label>
				</div>
				<div class="category-item">
					<input type="radio" id="garden" name="category">
					<div class="custom-radio"></div>
					<label for="garden">Garden</label>
				</div>
				<div class="category-item">
					<input type="radio" id="loft" name="category">
					<div class="custom-radio"></div>
					<label for="loft">Loft</label>
				</div>
				<div class="category-item">
					<input type="radio" id="penthouse" name="category">
					<div class="custom-radio"></div>
					<label for="penthouse">Penthouse</label>
				</div>
			</div>

			<div class="filter-section">
				<h3>Sort By</h3>
				<select class="sort-select">
					<option value="price-low">Price: Low to High</option>
					<option value="price-high">Price: High to Low</option>
				</select>
			</div>
		</aside>

		<section class="content">
			<div class="apartments-grid">
				<!-- Apartment 1 -->
				<div class="apartment-card">
					<img src="/api/placeholder/800/600" alt="Skyline Studio"
						class="apartment-image">
					<div class="apartment-details">
						<div class="apartment-header">
							<h2 class="apartment-name">Skyline Studio</h2>
							<div class="furnished-status">Furnished</div>
						</div>
						<div class="apartment-price">$1,250/month</div>
						<div class="apartment-specs">
							<div class="spec-item">
								<span class="spec-label">Size:</span> <span class="spec-value">450
									sq.ft</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Living:</span> <span class="spec-value">1</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Bedroom:</span> <span
									class="spec-value">0</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Kitchen:</span> <span
									class="spec-value">1</span>
							</div>
						</div>
						<div class="apartment-category-container">
							<div class="apartment-category">Studio</div>
						</div>
					</div>
				</div>

				<!-- Apartment 2 -->
				<div class="apartment-card">
					<img src="/api/placeholder/800/600" alt="Urban Loft"
						class="apartment-image">
					<div class="apartment-details">
						<div class="apartment-header">
							<h2 class="apartment-name">Urban Loft</h2>
							<div class="furnished-status">Not Furnished</div>
						</div>
						<div class="apartment-price">$2,450/month</div>
						<div class="apartment-specs">
							<div class="spec-item">
								<span class="spec-label">Size:</span> <span class="spec-value">850
									sq.ft</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Living:</span> <span class="spec-value">1</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Bedroom:</span> <span
									class="spec-value">1</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Kitchen:</span> <span
									class="spec-value">1</span>
							</div>
						</div>
						<div class="apartment-category-container">
							<div class="apartment-category">Loft</div>
						</div>
					</div>
				</div>

				<!-- Apartment 3 -->
				<div class="apartment-card">
					<img src="/api/placeholder/800/600" alt="Garden Haven"
						class="apartment-image">
					<div class="apartment-details">
						<div class="apartment-header">
							<h2 class="apartment-name">Garden Haven</h2>
							<div class="furnished-status">Furnished</div>
						</div>
						<div class="apartment-price">$3,150/month</div>
						<div class="apartment-specs">
							<div class="spec-item">
								<span class="spec-label">Size:</span> <span class="spec-value">1200
									sq.ft</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Living:</span> <span class="spec-value">1</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Bedroom:</span> <span
									class="spec-value">2</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Kitchen:</span> <span
									class="spec-value">1</span>
							</div>
						</div>
						<div class="apartment-category-container">
							<div class="apartment-category">Garden</div>
						</div>
					</div>
				</div>

				<!-- Apartment 4 -->
				<div class="apartment-card">
					<img src="/api/placeholder/800/600" alt="Luxury Penthouse"
						class="apartment-image">
					<div class="apartment-details">
						<div class="apartment-header">
							<h2 class="apartment-name">Luxury Penthouse</h2>
							<div class="furnished-status">Furnished</div>
						</div>
						<div class="apartment-price">$5,800/month</div>
						<div class="apartment-specs">
							<div class="spec-item">
								<span class="spec-label">Size:</span> <span class="spec-value">2100
									sq.ft</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Living:</span> <span class="spec-value">2</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Bedroom:</span> <span
									class="spec-value">3</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Kitchen:</span> <span
									class="spec-value">1</span>
							</div>
						</div>
						<div class="apartment-category-container">
							<div class="apartment-category">Penthouse</div>
						</div>
					</div>
				</div>

				<!-- Apartment 5 -->
				<div class="apartment-card">
					<img src="/api/placeholder/800/600" alt="Modern Duplex"
						class="apartment-image">
					<div class="apartment-details">
						<div class="apartment-header">
							<h2 class="apartment-name">Modern Duplex</h2>
							<div class="furnished-status">Not Furnished</div>
						</div>
						<div class="apartment-price">$3,750/month</div>
						<div class="apartment-specs">
							<div class="spec-item">
								<span class="spec-label">Size:</span> <span class="spec-value">1600
									sq.ft</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Living:</span> <span class="spec-value">1</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Bedroom:</span> <span
									class="spec-value">2</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Kitchen:</span> <span
									class="spec-value">2</span>
							</div>
						</div>
						<div class="apartment-category-container">
							<div class="apartment-category">Duplex</div>
						</div>
					</div>
				</div>

				<!-- Apartment 6 -->
				<div class="apartment-card">
					<img src="/api/placeholder/800/600" alt="Cozy Studio"
						class="apartment-image">
					<div class="apartment-details">
						<div class="apartment-header">
							<h2 class="apartment-name">Cozy Studio</h2>
							<div class="furnished-status">Not Furnished</div>
						</div>
						<div class="apartment-price">$980/month</div>
						<div class="apartment-specs">
							<div class="spec-item">
								<span class="spec-label">Size:</span> <span class="spec-value">400
									sq.ft</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Living:</span> <span class="spec-value">1</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Bedroom:</span> <span
									class="spec-value">0</span>
							</div>
							<div class="spec-item">
								<span class="spec-label">Kitchen:</span> <span
									class="spec-value">1</span>
							</div>
						</div>
						<div class="apartment-category-container">
							<div class="apartment-category">Studio</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<%-- <jsp:include page="footer.jsp" /> --%> <!-- TODO -->
</body>
</html>