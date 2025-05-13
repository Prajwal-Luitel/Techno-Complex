<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,jakarta.servlet.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Techno Complex Admin - Manage Flats</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/manageflat.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
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
            <a href="${pageContext.request.contextPath}/dashboard" class="menu-item">
                <i class="fas fa-th-large"></i> <span>Dashboard</span>
            </a>
            <a href="${pageContext.request.contextPath}/manageflat" class="menu-item active">
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
			

			<div class="dashboard-content">
				<h2 class="section-title">Manage Flats</h2>

				<!-- Flat Table -->
				<div class="data-table-container">
					<div class="data-table-header">
						<h3>Flat List</h3>
						<button class="btn btn-primary" id="addFlatBtn">
							<i class="fas fa-plus"></i> Add Flat
						</button>
					</div>
					<table class="data-table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Image</th>
								<th>Name</th>
								<th>Category</th>
								<th>Price</th>
								<th>Size</th>
								<th>Living</th>
								<th>Bedroom</th>
								<th>Kitchen</th>
								<th>Furnishing</th>
								<th>Status</th>
								<th>Actions</th>
							</tr>
						</thead>

						<tbody>

							<tr>
								<c:forEach var="flat" items="${flatList}">
									<tr>
										<td>${flat.flat_Id}</td>
										<td><img
											src="${pageContext.request.contextPath}/resources/images/flat/${flat.image_Path}"
											alt="Flat" class="flat-image"></td>
										<td>${flat.name}</td>
										<td>${flat.category}</td>
										<td>Rs ${flat.price}</td>
										<td>${flat.size}</td>
										<td>${flat.livingroom}</td>
										<td>${flat.bedroom}</td>
										<td>${flat.kitchen}</td>
										<td>${flat.furnishing}</td>
										<td>${flat.status}</td>
										<td>
											<div class="action-buttons">
												<button class="btn btn-warning edit-flat">
													<i class="fas fa-edit"></i>
												</button>
												<button class="btn btn-danger delete-flat">
													<i class="fas fa-trash"></i>
												</button>
											</div>
										</td>
									</tr>
								</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Add/Edit Flat Modal -->
	<div class="modal-overlay" id="flatModal">
		<div class="modal">
			<div class="modal-header">
				<h4 class="modal-title" id="modalTitle">Add New Flat</h4>
				<button class="close-modal">&times;</button>
			</div>
			<div class="modal-body">
				<form id="flatForm"
					action="${pageContext.request.contextPath}/manageflat"
					method="post" enctype="multipart/form-data">
					<input type="hidden" name="flatId" id="flatId"> <input
						type="hidden" name="isEdit" id="isEdit" value="false">

					<div class="form-row">
						<div class="form-group">
							<label for="name">Flat Name</label> <input type="text"
								class="form-control" id="name" name="name" value="${flat.name}"
								required placeholder="Enter flat name">
						</div>
						<div class="form-group">
							<label for="category">Category</label> <select
								class="form-control" name="category" id="category">
								<option value="studio"
									${flat.category == 'studio' ? 'selected' : ''}>Studio</option>
								<option value="loft"
									${flat.category == 'loft' ? 'selected' : ''}>Loft</option>
								<option value="duplex"
									${flat.category == 'duplex' ? 'selected' : ''}>Duplex</option>
								<option value="garden"
									${flat.category == 'garden' ? 'selected' : ''}>Garden</option>
								<option value="penthouse"
									${flat.category == 'penthouse' ? 'selected' : ''}>Penthouse</option>
							</select>
						</div>
					</div>
					<div class="form-row">

						<div class="form-group">
							<label for="price">Price (Rs.)</label> <input type="number"
								class="form-control" id="price" name="price"
								value="${flat.price}" required placeholder="Enter price">
						</div>
						<div class="form-group">
							<label for="size">Size (sq.Ft)</label> <input type="number"
								class="form-control" id="size" name="size" value="${flat.size}"
								required placeholder="Enter size">
						</div>
					</div>
					<div class="form-row">

						<div class="form-group">
							<label for="status">Status</label> <select class="form-control"
								name="status" id="status">
								<option value="Available"
									${flat.status == 'Available' ? 'selected' : ''}>Available</option>
								<option value="Not Available"
									${flat.status == 'Not Available' ? 'selected' : ''}>Not
									Available</option>
							</select>

						</div>
						<div class="form-group">
							<label for="furnishing">Furnished</label> <select
								class="form-control" name="furnishing" id="furnishing">
								<option value="furnished"
									${flat.furnishing == 'furnished' ? 'selected' : ''}>Furnished</option>
								<option value="not furnished"
									${flat.furnishing == 'not furnished' ? 'selected' : ''}>Not
									Furnished</option>
							</select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group">
							<label for="living">Living Rooms</label> <select
								class="form-control" name="living" id="living">
								<option value="1" ${flat.living == 1 ? 'selected' : ''}>1</option>
								<option value="2" ${flat.living == 2 ? 'selected' : ''}>2</option>
								<option value="3" ${flat.living == 3 ? 'selected' : ''}>3</option>
								<option value="4" ${flat.living == 4 ? 'selected' : ''}>4</option>
								<option value="5" ${flat.living == 5 ? 'selected' : ''}>5</option>
							</select>
						</div>
						<div class="form-group">
							<label for="bedroom">Bedrooms</label> <select
								class="form-control" name="bedroom" id="bedroom">
								<option value="1" ${flat.bedroom == 1 ? 'selected' : ''}>1</option>
								<option value="2" ${flat.bedroom == 2 ? 'selected' : ''}>2</option>
								<option value="3" ${flat.bedroom == 3 ? 'selected' : ''}>3</option>
								<option value="4" ${flat.bedroom == 4 ? 'selected' : ''}>4</option>
								<option value="5" ${flat.bedroom == 5 ? 'selected' : ''}>5</option>
							</select>
						</div>
						<div class="form-group">
							<label for="kitchen">Kitchens</label> <select
								class="form-control" name="kitchen" id="kitchen">
								<option value="1" ${flat.kitchen == 1 ? 'selected' : ''}>1</option>
								<option value="2" ${flat.kitchen == 2 ? 'selected' : ''}>2</option>
								<option value="3" ${flat.kitchen == 3 ? 'selected' : ''}>3</option>
								<option value="4" ${flat.kitchen == 4 ? 'selected' : ''}>4</option>
								<option value="5" ${flat.kitchen == 5 ? 'selected' : ''}>5</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="flatImage">Flat Image</label> <input type="file"
							accept="image/*" required class="form-control" name="flatImage"
							id="flatImage">
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" id="saveFlat" type="submit">Save Flat</button>
						<button class="btn btn-danger close-btn" type="button">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Delete Confirmation Modal -->
	<div class="modal-overlay confirm-modal" id="deleteModal">
		<div class="modal">
			<div class="modal-header">
				<h4 class="modal-title">Confirm Deletion</h4>
				<button class="close-modal">&times;</button>
			</div>
			<div class="modal-body">
				<div class="modal-icon">
					<i class="fas fa-exclamation-triangle"></i>
				</div>
				<h4>Are you sure you want to delete this flat?</h4>
				<p>This action cannot be undone.</p>
			</div>
			<div class="modal-footer">
				<form id="deleteForm" action="${pageContext.request.contextPath}/manageflat" method="post">
					<input type="hidden" name="deleteId" id="deleteId">
				</form>

				<button class="btn btn-danger" id="confirmDelete">Delete</button>
				<button class="btn btn-primary close-btn">Cancel</button>
			</div>
		</div>
	</div>

	<script>

        // Modal functionality
       const flatModal = document.getElementById('flatModal');
        const deleteModal = document.getElementById('deleteModal');
        const addFlatBtn = document.getElementById('addFlatBtn');
        const closeButtons = document.querySelectorAll('.close-modal, .close-btn');
        const modalTitle = document.getElementById('modalTitle');
        const flatForm = document.getElementById('flatForm');

        // Edit buttons
        const editButtons = document.querySelectorAll('.edit-flat');
        editButtons.forEach(button => {
            button.addEventListener('click', function() {
            	flatModal.style.display = 'flex';
                modalTitle.textContent = 'Edit Flat';
                const row = this.closest('tr');
                document.getElementById('isEdit').value = "true"; 
                document.getElementById('flatId').value = row.cells[0].textContent.trim();
                document.getElementById('name').value = row.cells[2].textContent.trim();
                document.getElementById('category').value = row.cells[3].textContent.trim();
                document.getElementById('price').value = row.cells[4].textContent.replace('Rs', '').replace(/,/g, '').trim();
                document.getElementById('size').value = row.cells[5].textContent.trim();
                document.getElementById('living').value = row.cells[6].textContent.trim();
                document.getElementById('bedroom').value = row.cells[7].textContent.trim();
                document.getElementById('kitchen').value = row.cells[8].textContent.trim();
                document.getElementById('furnishing').value = row.cells[9].textContent.trim();
                document.getElementById('status').value = row.cells[10].textContent.trim();
                     
            });
            
        });

        // Delete buttons
        const deleteButtons = document.querySelectorAll('.delete-flat');
        let flatToDelete = null;
        
        deleteButtons.forEach(button => {
            button.addEventListener('click', function() {
            	document.getElementById('deleteId').value = this.closest('tr').cells[0].textContent.trim();
                flatToDelete = this.getAttribute('data-id');
                deleteModal.style.display = 'flex';
            });
        });

        // Add Flat button
        addFlatBtn.addEventListener('click', function() {
            modalTitle.textContent = 'Add New Flat';
            flatForm.reset();
            flatModal.style.display = 'flex';
        });

        // Close modals
        closeButtons.forEach(button => {
            button.addEventListener('click', function() {
                flatModal.style.display = 'none';
                deleteModal.style.display = 'none';
            });
        });

        // Confirm delete
        document.getElementById('confirmDelete').addEventListener('click', function() {
        	 document.getElementById('deleteForm').submit();
        });

    </script>
</body>
</html>