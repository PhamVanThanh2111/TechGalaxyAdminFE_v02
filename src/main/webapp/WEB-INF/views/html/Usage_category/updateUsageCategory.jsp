<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<c:url value='/images/favicon/favicon.ico' />">
<link rel="icon" type="image/png" sizes="16x16"
	href="<c:url value='/images/favicon/favicon-16x16.png' />">
<link rel="icon" type="image/png" sizes="32x32"
	href="<c:url value='/images/favicon/favicon-32x32.png' />">
<link rel="icon" type="image/png" sizes="192x192"
	href="<c:url value='/images/favicon/android-chrome-192x192.png' />">
<link rel="icon" type="image/png" sizes="512x512"
	href="<c:url value='/images/favicon/android-chrome-512x512.png' />">
<link rel="apple-touch-icon" sizes="180x180"
	href="<c:url value='/images/favicon/apple-touch-icon.png' />">
<link rel="manifest"
	href="<c:url value='/images/favicon/site.webmanifest' />">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="<c:url value='/images/favicon/android-chrome-192x192.png' />">
<meta name="theme-color" content="#ffffff">

<title>System User</title>

<!-- Custom fonts for this template -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/css/sb-admin-2.min.css" />" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="<c:url value="/datatables/dataTables.bootstrap4.min.css" />"
	rel="stylesheet">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link href="<c:url value="/css/toast.css"/> " rel="stylesheet">
</head>

<body id="page-top">

	<!-- Toast container -->
	<c:if test="${not empty successMessage}">
		<div class="toast-container position-fixed top-0 end-0 p-3">
			<div id="successToast" class="toast success-toast" role="alert"
				aria-live="assertive" aria-atomic="true">
				<div class="toast-header">
					<strong class="me-auto">Success!</strong>
					<button type="button" class="btn-close" data-bs-dismiss="toast"
						aria-label="Close"></button>
				</div>
				<div class="toast-body">${successMessage}</div>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty errorMessage}">
		<div class="toast-container position-fixed top-0 end-0 p-3">
			<div id="errorToast" class="toast error-toast" role="alert"
				aria-live="assertive" aria-atomic="true">
				<div class="toast-header">
					<strong class="me-auto">Unsuccessful!</strong>
					<button type="button" class="btn-close" data-bs-dismiss="toast"
						aria-label="Close"></button>
				</div>
				<div class="toast-body">${errorMessage}</div>
			</div>
		</div>
	</c:if>

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="../General/Sidebar.jsp" />
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include page="../General/Topbar.jsp" />
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Usage Categories</h1>
					<p class="mb-4">This is a Usage Category management table,
						displaying user data such as name, phone, status and so on.</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Add Usage
								Category</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">

									<form:form method="POST" modelAttribute="usageCategory"
										enctype="multipart/form-data"
										action="${pageContext.request.contextPath}/usagecategories/update">
										<input type="hidden" name="id" value="${usageCategory.id}" />
										<div class="form-group">

											<label for="name">Name</label>
											<form:input path="name" cssClass="form-control" id="name" />

										</div>

										<div class="form-group">
											<label>Status</label>
											<div class="form-check" style="margin-left: 5px;">
												<input class="form-check-input" type="radio" name="status"
													id="statusActive" value="active" checked> <label
													class="form-check-label" for="statusActive">Active</label>
											</div>
											<div class="form-check" style="margin-left: 5px;">
												<input class="form-check-input" type="radio" name="status"
													id="statusInactive" value="inactive"> <label
													class="form-check-label" for="statusInactive">Inactive</label>
											</div>
										</div>

										<div class="form-group">
											<div class="mb-3">
												<label for="avatar" class="form-label">Avatar</label> <input
													class="form-control" type="file" id="avatar" name="avatar"
													accept="image/*">
											</div>
										</div>
										<div class="form-group">
											<label for="description">Description</label>
											<form:textarea path="description" cssClass="form-control"
												id="description" rows="5"></form:textarea>
										</div>

										<div class="button-group">
											<button type="submit" class="btn btn-outline-primary">Submit</button>
											<a href="${pageContext.request.contextPath}/usagecategories"
												class="btn btn-outline-danger">Cancel</a>
										</div>
									</form:form>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->
		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<jsp:include page="../General/LogoutModal.jsp" />

	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value="/jquery/jquery.min.js" />"></script>
	<script src="<c:url value="/bootstrap/js/bootstrap.bundle.min.js" />"></script>

	<!-- Core plugin JavaScript-->
	<script src="<c:url value="/jquery-easing/jquery.easing.min.js" />"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value="/js/sb-admin-2.min.js" />"></script>

	<!-- Page level plugins -->
	<script src="<c:url value="/datatables/jquery.dataTables.min.js" />"></script>
	<script
		src="<c:url value="/datatables/dataTables.bootstrap4.min.js" />"></script>

	<!-- Page level custom scripts -->
	<script src="<c:url value="/js/demo/datatables-demo.js" />"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Thêm script để hiển thị Toast -->
	<script>
		var successToast = new bootstrap.Toast(document
				.getElementById('successToast'));
		var errorToast = new bootstrap.Toast(document
				.getElementById('errorToast'));

		// Hiển thị các toast
		<c:if test="${not empty successMessage}">
		successToast.show();
		</c:if>
		<c:if test="${not empty errorMessage}">
		errorToast.show();
		</c:if>
	</script>

</body>

</html>