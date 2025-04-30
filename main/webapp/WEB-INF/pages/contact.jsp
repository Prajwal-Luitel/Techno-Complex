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
	href="${pageContext.request.contextPath}/css/contact.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css" />
</head>
<body>
	<jsp:include page="header.jsp" />

	<!-- Contact Hero Section -->
	<section class="contact-hero">
		<div class="container">
			<h1 class="section-title">Contact Us</h1>
			<p class="contact-subtitle">We're here to answer any questions
				you may have about our apartments. Reach out to us and we'll respond
				as soon as possible.</p>
		</div>
	</section>

	<!-- Contact Content Section -->
	<section class="container">
		<div class="contact-content">
			<!-- Contact Information -->
			<div class="contact-info">
				<div class="info-item">
					<h3>
						<i class="fas fa-map-marker-alt info-icon"></i> Address
					</h3>
					<p>Techno Complex Headquarters</p>
					<p>123 Durbar Marg</p>
					<p>Kathmandu, Nepal</p>
				</div>

				<div class="info-item">
					<h3>
						<i class="fas fa-phone-alt info-icon"></i> Phone
					</h3>
					<p>Main Office: +977-1-XXXXXXX</p>
					<p>Leasing Inquiries: +977-1-XXXXXXX</p>
				</div>

				<div class="info-item">
					<h3>
						<i class="fas fa-envelope info-icon"></i> Email
					</h3>
					<p>General Inquiries: info@technocomplex.com.np</p>
					<p>Leasing: leasing@technocomplex.com.np</p>
					<p>Support: support@technocomplex.com.np</p>
				</div>

				<div class="info-item">
					<h3>
						<i class="fas fa-clock info-icon"></i> Office Hours
					</h3>
					<div class="office-hours">
						<h4>Main Office:</h4>
						<p>Monday - Friday: 9:00 AM - 6:00 PM</p>
						<p>Saturday: 10:00 AM - 4:00 PM</p>
						<p>Sunday: Closed</p>
					</div>

					<div class="office-hours">
						<h4>Property Tours:</h4>
						<p>Monday - Saturday: 10:00 AM - 5:00 PM</p>
						<p>(By appointment only)</p>
					</div>
				</div>

				<div class="info-item">
					<h3>
						<i class="fas fa-share-alt info-icon"></i> Connect With Us
					</h3>
					<div class="social-links">
						<a href="https://facebook.com" class="social-link"><i
							class="fab fa-facebook-f"></i></a> <a href="https://linkedin.com"
							class="social-link"><i class="fab fa-linkedin-in"></i></a> <a
							href="https://instagram.com" class="social-link"><i
							class="fab fa-instagram"></i></a> <a href="https://twitter.com"
							class="social-link"><i class="fab fa-twitter"></i></a>
					</div>
				</div>
			</div>

			<!-- Contact Form - Simplified -->
			<div class="contact-form-container">
				<h3 class="section-title" style="font-size: 24px;">Send Us a
					Message</h3>
				<form class="contact-form">
					<div>
						<label for="full-name">Full Name</label> <input type="text"
							id="full-name" placeholder="Enter your full name" required>
					</div>

					<div>
						<label for="email">Email Address</label> <input type="email"
							id="email" placeholder="Enter your email address" required>
					</div>

					<div>
						<label for="phone">Phone Number</label> <input type="tel"
							id="phone" placeholder="Enter your phone number">
					</div>

					<div>
						<label for="message">Your Message</label>
						<textarea id="message" placeholder="Type your message here..."
							required></textarea>
					</div>

					<div>
						<button type="submit" class="submit-btn">Send Message</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- Map Section -->
	<section class="map-section">
		<div class="container">
			<h2 class="section-title">Our Location</h2>
			<div class="map-container">
				<iframe width="100%" height="100%" frameborder="0" style="border: 0"
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3532.2704223580737!2d85.31304851507313!3d27.711902582790346!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39eb190a74aa1f23%3A0x221bcacbede9d346!2sDurbar%20Marg%2C%20Kathmandu%2044600%2C%20Nepal!5e0!3m2!1sen!2sus!4v1650500000000!5m2!1sen!2sus"
					allowfullscreen="" loading="lazy"></iframe>
			</div>
		</div>
	</section>

	<jsp:include page="footer.jsp" />
</body>
</html>