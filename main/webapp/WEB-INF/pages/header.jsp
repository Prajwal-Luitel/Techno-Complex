<nav>
	<div class="logo">
		<a href="${contextPath}/home"><img
			src="${pageContext.request.contextPath}/resources/images/system/logo.png"
			alt="logo" /></a>
		<div class="logo-text">
			<span>Techno</span> <span>Complex</span>
		</div>
	</div>

	<div class="search-container">
		<input type="text" placeholder="Search apartments, locations...">
		<button type="submit">
			<i class="fas fa-search"></i>
		</button>
	</div>

	<div class="nav-links">
		<a href="${pageContext.request.contextPath}/home">Home</a> <a href="${pageContext.request.contextPath}/flat">Flat</a> <a
			href="${pageContext.request.contextPath}/about">About</a> <a href="${pageContext.request.contextPath}/contact">Contact</a>

		<div class="profile-container">
			<img src="/api/placeholder/50/50" alt="Profile" class="profile-pic">
			<div class="profile-dropdown">
				<a href="${pageContext.request.contextPath}/profile">Profile</a> 
				<a href="${pageContext.request.contextPath}/myflat">My Flats</a>
					 <a href="#">Logout</a> <!--TODO::  -->
			</div>
		</div>
	</div>
</nav>