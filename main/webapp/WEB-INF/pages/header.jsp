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
				placeholder="Search apartments, locations...">
			<button type="submit">
				<i class="fas fa-search"></i>
			</button>
			<!-- Hidden fields to carry filter/sort data -->
			<input type="hidden" name="category" value="any">
			<input type="hidden" name="sort" value="price-low">
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
				<form action="${pageContext.request.contextPath}/logout" method="post">
					<button type="submit" class="logout-btn">Logout</button>
				</form>

			</div>
		</div>
	</div>
</nav>