<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,jakarta.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/home.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<section class="hero">
	<img src="${pageContext.request.contextPath}/resources/images/system/Apartment.png" alt="Modern Apartment">
        <div class="hero-content">
            <h1>Modern Living in Nepal</h1>
            <p>Experience premium apartment living with the perfect blend of comfort, convenience, and contemporary design at Techno Complex.</p>
            <a href="#" class="btn">Explore Properties</a>
        </div>
    </section>

    <section class="apartments">
        <div class="container">
            <h2 class="section-title">Featured Apartments</h2>
            <div class="apartment-container">
            
            <c:forEach items="${flatList}" var="flat">
                <div class="apartment-card">
                    <div class="apartment-image">
                        <img src="${pageContext.request.contextPath}/resources/images/flat/${flat.image_Path}" alt="Luxury Apartment">
                        <a href="${pageContext.request.contextPath}/flat" class="view-btn">View Details</a>
                    </div>
                    <div class="apartment-info">
                        <h4 class="apartment-name">${flat.name}</h4>
                        <span class="apartment-category">${flat.category}</span>
                        <div class="apartment-details">
                            <div class="detail-item">
                                <span class="detail-label">Size:</span>
                                <span class="detail-value">${flat.size} sq.ft</span>
                            </div>
                            <div class="detail-item">
                                <span class="detail-label">Living:</span>
                                <span class="detail-value">${flat.livingroom}</span>
                            </div>
                            <div class="detail-item">
                                <span class="detail-label">Bedroom:</span>
                                <span class="detail-value">${flat.bedroom}</span>
                            </div>
                            <div class="detail-item">
                                <span class="detail-label">Kitchen:</span>
                                <span class="detail-value">${flat.kitchen} </span>
                            </div>
                            <div class="detail-item">
                                <span class="detail-label">Furnishing</span>
                                <span class="detail-value">${flat.furnishing}</span>
                            </div>
                        </div>
                        <p class="price">Rs. ${flat.price}/month</p>
                    </div>
                </div>
            </c:forEach>    
                
                <!-- <div class="apartment-card">
                    <div class="apartment-image">
                        <img src="/api/placeholder/500/350" alt="Modern Apartment">
                        <a href="flat-details.html?id=modern-2br" class="view-btn">View Details</a>
                    </div>
                    <div class="apartment-info">
                        <h4 class="apartment-name">Modern 2BR Apartment</h4>
                        <span class="apartment-category">Luxury</span>
                        <div class="apartment-details">
                            <div class="detail-item">
                                <span class="detail-label">Size:</span>
                                <span class="detail-value">850 sq ft</span>
                            </div>
                            <div class="detail-item">
                                <span class="detail-label">Living:</span>
                                <span class="detail-value">1 Room</span>
                            </div>
                            <div class="detail-item">
                                <span class="detail-label">Bedroom:</span>
                                <span class="detail-value">2</span>
                            </div>
                            <div class="detail-item">
                                <span class="detail-label">Kitchen:</span>
                                <span class="detail-value">1</span>
                            </div>
                            <div class="detail-item">
                                <span class="detail-label">Furnished:</span>
                                <span class="detail-value">Partially</span>
                            </div>
                        </div>
                        <p class="price">NPR 26,000/month</p>
                    </div>
                </div> -->
                
            </div>
        </div>
    </section>

    <section class="about-preview">
        <div class="container">
            <h2 class="section-title">About Techno Complex</h2>
            <div class="about-content">
                <div class="about-text">
                    <p>Established in 2018, Techno Complex was born from a vision to transform the apartment living experience in Nepal. Our founders recognized the growing need for housing solutions that combine quality construction, modern amenities, and community living.</p>

                    <p>At Techno Complex, we believe that a home is more than just four walls. It's a sanctuary where memories are created, dreams are nurtured, and lives are lived to the fullest. Our commitment extends beyond providing elegant living spaces—we strive to create a vibrant community where residents feel secure, connected, and inspired.</p>
                    
                    <a href="about.html" class="read-more">Read more about our story <i class="fas fa-arrow-right"></i></a>
                </div>
                <div class="about-img">
                    <img src="${pageContext.request.contextPath}/resources/images/system/Happy Family.png" alt="About Techno Complex">
                </div>
            </div>
        </div>
    </section>

    <section class="cta">
        <div class="container">
            <h2>Ready to Find Your Perfect Home?</h2>
            <p>Have questions or ready to schedule a viewing? Our team is ready to assist you in finding your ideal living space. Contact us today to learn more about our available properties or to discuss your specific housing needs.</p>
            <a href="contact.html" class="cta-button">Contact Us</a>
        </div>
    </section>
	
	<jsp:include page="footer.jsp" />
</body>
</html>