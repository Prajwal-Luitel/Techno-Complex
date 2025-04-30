<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/about.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body>
	<jsp:include page="header.jsp" />

	<section class="hero">
        <img src="${pageContext.request.contextPath}/resources/images/system/Apartment.png" alt="Modern Apartment">
        <div class="hero-content">
            <h1>About Techno Complex</h1>
            <p>Your Modern Living Experience in Nepal</p>
        </div>
    </section>

    <section class="about-section">
        <div class="container">
            <h2 class="section-title">Our Story</h2>
            <div class="about-content">
                <div class="about-text">
                    <p>Established in 2018, Techno Complex was born from a vision to transform the apartment living experience in Nepal. Our founders recognized the growing need for housing solutions that combine quality construction, modern amenities, and community living.</p>

                    <p>Today, we stand as a testament to that vision, providing homes that truly enhance the quality of life for our residents. At Techno Complex, we believe that a home is more than just four walls. It's a sanctuary where memories are created, dreams are nurtured, and lives are lived to the fullest.</p>

                    <p>Our commitment extends beyond providing elegant living spaces—we strive to create a vibrant community where residents feel secure, connected, and inspired. With properties strategically located across Nepal, we offer the perfect blend of comfort, convenience, and contemporary living.</p>   
                </div>
                <div class="about-img">
                    <img src="${pageContext.request.contextPath}/resources/images/system/Happy Family.png" alt="About Techno Complex">
                </div>
            </div>
          
        </div>
    </section>

    <section class="features">
        <div class="container">
            <h2 class="section-title">Why Choose Techno Complex?</h2>
            <div class="features-grid">
                <div class="feature-box">
                    <div class="feature-icon"><i class="fas fa-map-marker-alt"></i></div>
                    <h3>Premium Locations</h3>
                    <p>Our properties are strategically located with easy access to essential services, shopping centers, educational institutions, and transportation hubs.</p>
                </div>
                <div class="feature-box">
                    <div class="feature-icon"><i class="fas fa-building"></i></div>
                    <h3>Modern Design</h3>
                    <p>Experience contemporary architecture with thoughtful floor plans, maximizing space and natural light while providing privacy and comfort.</p>
                </div>
                <div class="feature-box">
                    <div class="feature-icon"><i class="fas fa-tools"></i></div>
                    <h3>Quality Construction</h3>
                    <p>We use high-quality materials and adhere to international safety standards, ensuring durability and peace of mind for our residents.</p>
                </div>
                <div class="feature-box">
                    <div class="feature-icon"><i class="fas fa-swimming-pool"></i></div>
                    <h3>Comprehensive Amenities</h3>
                    <p>From 24/7 security and power backup to fitness centers and communal spaces, we provide everything needed for comfortable modern living.</p>
                </div>
            </div>
        </div>
    </section>

   <!--  <section class="properties">
        <div class="container">
            <h2 class="section-title">Our Properties</h2>
            <p style="text-align: center; max-width: 800px; margin: 0 auto 30px;">Techno Complex currently manages multiple residential complexes across Nepal, each with its unique charm while maintaining our signature quality and service standards. Whether you're looking for a cozy studio apartment or a spacious family home, we have options to suit various preferences and budgets.</p>
        </div>
    </section>

    <section class="cta">
        <div class="container">
            <h2>Join Our Community</h2>
            <p>We invite you to explore what Techno Complex has to offer and join our growing community of satisfied residents. Experience the difference of living in a space designed with your needs and aspirations in mind.</p>
            <a href="#" class="cta-button">View Available Properties</a>
        </div>
    </section>
 -->
	<jsp:include page="footer.jsp" />
</body>
</html>