<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<i class="fas fa-microchip"></i>
				</div>
				<h3>Techno Complex</h3>
				<p>Admin Panel</p>
			</div>
			<div class="sidebar-menu">
				<div class="menu-item">
					<i class="fas fa-th-large"></i> <span>Dashboard</span>
				</div>
				<div class="menu-item active">
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
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>#F-1024</td>
								<td><img src="/api/placeholder/100/75" alt="Flat"
									class="flat-image"></td>
								<td>Luxury Suite</td>
								<td>Premium</td>
								<td>$2,450</td>
								<td>1200 sq.ft</td>
								<td>1</td>
								<td>2</td>
								<td>1</td>
								<td>Yes</td>
								<td class="status status-active">Occupied</td>
								<td>
									<div class="action-buttons">
										<button class="btn btn-warning edit-flat" data-id="F-1024">
											<i class="fas fa-edit"></i>
										</button>
										<button class="btn btn-danger delete-flat" data-id="F-1024">
											<i class="fas fa-trash"></i>
										</button>
									</div>
								</td>
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
								<td>
									<div class="action-buttons">
										<button class="btn btn-warning edit-flat" data-id="F-1022">
											<i class="fas fa-edit"></i>
										</button>
										<button class="btn btn-danger delete-flat" data-id="F-1022">
											<i class="fas fa-trash"></i>
										</button>
									</div>
								</td>
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
								<td>
									<div class="action-buttons">
										<button class="btn btn-warning edit-flat" data-id="F-1019">
											<i class="fas fa-edit"></i>
										</button>
										<button class="btn btn-danger delete-flat" data-id="F-1019">
											<i class="fas fa-trash"></i>
										</button>
									</div>
								</td>
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
								<td>
									<div class="action-buttons">
										<button class="btn btn-warning edit-flat" data-id="F-1018">
											<i class="fas fa-edit"></i>
										</button>
										<button class="btn btn-danger delete-flat" data-id="F-1018">
											<i class="fas fa-trash"></i>
										</button>
									</div>
								</td>
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
								<td>
									<div class="action-buttons">
										<button class="btn btn-warning edit-flat" data-id="F-1015">
											<i class="fas fa-edit"></i>
										</button>
										<button class="btn btn-danger delete-flat" data-id="F-1015">
											<i class="fas fa-trash"></i>
										</button>
									</div>
								</td>
							</tr>
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
				<form id="flatForm">
					<div class="form-row">
						<div class="form-group">
							<label for="flatId">Flat ID</label> <input type="text"
								class="form-control" id="flatId" placeholder="#F-XXXX">
						</div>
						<div class="form-group">
							<label for="flatName">Flat Name</label> <input type="text"
								class="form-control" id="flatName" placeholder="Enter flat name">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group">
							<label for="category">Category</label> <select
								class="form-control" id="category">
								<option value="Standard">Standard</option>
								<option value="Premium">Premium</option>
								<option value="Luxury">Luxury</option>
							</select>
						</div>
						<div class="form-group">
							<label for="price">Price ($)</label> <input type="number"
								class="form-control" id="price" placeholder="Enter price">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group">
							<label for="size">Size (sq.ft)</label> <input type="text"
								class="form-control" id="size" placeholder="Enter size">
						</div>
						<div class="form-group">
							<label for="status">Status</label> <select class="form-control"
								id="status">
								<option value="Occupied">Occupied</option>
								<option value="Vacant">Vacant</option>
								<option value="Maintenance">Maintenance</option>
							</select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group">
							<label for="living">Living Rooms</label> <input type="number"
								class="form-control" id="living" min="0" max="5">
						</div>
						<div class="form-group">
							<label for="bedroom">Bedrooms</label> <input type="number"
								class="form-control" id="bedroom" min="0" max="10">
						</div>
						<div class="form-group">
							<label for="kitchen">Kitchens</label> <input type="number"
								class="form-control" id="kitchen" min="0" max="5">
						</div>
					</div>
					<div class="form-group">
						<label for="furnished">Furnished</label> <select
							class="form-control" id="furnished">
							<option value="Yes">Yes</option>
							<option value="No">No</option>
						</select>
					</div>
					<div class="form-group">
						<label for="flatImage">Flat Image</label> <input type="file"
							class="form-control" id="flatImage">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" id="saveFlat">Save Flat</button>
				<button class="btn btn-danger close-btn">Cancel</button>
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
                const flatId = this.getAttribute('data-id');
                modalTitle.textContent = 'Edit Flat';
                
                // Populate form with flat data (this would normally come from a database)
                // For demo purposes, we'll just pre-fill with some data
                document.getElementById('flatId').value = '#' + flatId;
                document.getElementById('flatName').value = this.closest('tr').cells[2].textContent;
                document.getElementById('category').value = this.closest('tr').cells[3].textContent;
                document.getElementById('price').value = this.closest('tr').cells[4].textContent.replace('$', '').replace(',', '');
                document.getElementById('size').value = this.closest('tr').cells[5].textContent.replace(' sq.ft', '');
                document.getElementById('living').value = this.closest('tr').cells[6].textContent;
                document.getElementById('bedroom').value = this.closest('tr').cells[7].textContent;
                document.getElementById('kitchen').value = this.closest('tr').cells[8].textContent;
                document.getElementById('furnished').value = this.closest('tr').cells[9].textContent;
                document.getElementById('status').value = this.closest('tr').cells[10].textContent;
                
                flatModal.style.display = 'flex';
            });
        });

        // Delete buttons
        const deleteButtons = document.querySelectorAll('.delete-flat');
        let flatToDelete = null;
        
        deleteButtons.forEach(button => {
            button.addEventListener('click', function() {
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

        // Save flat (no actual implementation, just close the modal)
        document.getElementById('saveFlat').addEventListener('click', function() {
            // In a real application, this would save the flat data
            alert('Flat saved successfully!');
            flatModal.style.display = 'none';
        });

        // Confirm delete
        document.getElementById('confirmDelete').addEventListener('click', function() {
            // In a real application, this would delete the flat
            alert('Flat #' + flatToDelete + ' deleted successfully!');
            deleteModal.style.display = 'none';
        });

    </script>
</body>
</html>