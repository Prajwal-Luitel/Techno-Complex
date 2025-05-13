<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Techno complex</title>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>

	<div class="wrapper">
		<form action="${pageContext.request.contextPath}/login" method="post">
			<h2>Login</h2>
			<!-- Display error message if available -->
			<c:if test="${not empty error}">
				<p class="error">${error}</p>
			</c:if>


			<div class="input-field">
				<input type="text" id="username" name="username" required> <label>Username</label>
			</div>
			<div class="input-field">
				<input type="password" id="password" name="password" required>
				<label>Password</label> <i class="fas fa-eye-slash password-toggle"
					id="togglePassword"></i>
			</div>

			<button type="submit">Log In</button>
			<div class="register">
				<p>
					Don't have an account? <a
						href="${pageContext.request.contextPath}/register">Register</a>
				</p>
			</div>
		</form>
	</div>


    <!-- Popup success box -->
    <div class="popup-container">
        <div class="success-popup">
            <div class="popup-header">
                <div class="icon-container">
                    <div class="success-icon">
                        <i class="fas fa-check"></i>
                    </div>
                    <div class="title">
                        <h3>Login Successful</h3>
                    </div>
                </div>
            </div>
            
            <p>${success}</p>
            
            <button class="confirm-btn">Okay</button>
        </div>
    </div>

</body>
<script>
	document.getElementById('togglePassword').addEventListener(
			'click',
			function() {
				const passwordInput = document.getElementById('password');
				const passwordToggle = document
						.getElementById('togglePassword');

				if (passwordInput.type === 'password') {
					passwordInput.type = 'text';
					passwordToggle.classList.remove('fa-eye-slash');
					passwordToggle.classList.add('fa-eye');
				} else {
					passwordInput.type = 'password';
					passwordToggle.classList.remove('fa-eye');
					passwordToggle.classList.add('fa-eye-slash');
				}
			});
</script>

<c:if test="${not empty success}">
    <script>
        //  functionality to show the popup
        const closeButton = document.querySelector('.close-btn');
        const popup = document.querySelector('.popup-container');
        const confirmButton = document.querySelector('.confirm-btn');
        popup.style.display = "flex"; // Show the popup
       
        setTimeout(() => {
        	window.location.href = "${redirect}";
        }, 3000); //If user don't click okay in 3s this will redirect to related page i.e home or dashboard.
        
        confirmButton.addEventListener('click', () => {
        	window.location.href = "${redirect}";
        });
    </script>
</c:if>

</html>