<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<c:url value='/images/favicon/favicon.ico' />">
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/images/favicon/favicon-16x16.png' />">
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/images/favicon/favicon-32x32.png' />">
    <link rel="icon" type="image/png" sizes="192x192" href="<c:url value='/images/favicon/android-chrome-192x192.png' />">
    <link rel="icon" type="image/png" sizes="512x512" href="<c:url value='/images/favicon/android-chrome-512x512.png' />">
    <link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/images/favicon/apple-touch-icon.png' />">
    <link rel="manifest" href="<c:url value='/images/favicon/site.webmanifest' />">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="<c:url value='/images/favicon/android-chrome-192x192.png' />">
    <meta name="theme-color" content="#ffffff">

    <title>Add Variant Detail</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="<c:url value='/css/sb-admin-2.min.css' />" rel="stylesheet">
</head>

<body id="page-top">

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
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <a href="/products/${productId}/variants/${variantId}/details" class="btn btn-outline-primary btn-lg me-3">
                        <i class="fas fa-arrow-left"></i> Back
                    </a>
                    <h1 class="h3 mb-0 text-gray-800">Add Variant Detail</h1>
                </div>

                <!-- Add Variant Detail Form -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Add Details</h6>
                    </div>
                    <div class="card-body">
                        <form:form method="post" modelAttribute="variantDetailRequest"
                                   action="/products/${productId}/variants/${variantId}/details/add"
                                   enctype="multipart/form-data">

                            <!-- Memory -->
                            <div class="form-group">
                                <label for="memid">Memory</label>
                                <form:select path="memid" cssClass="form-control" required="required">
                                    <form:option value="">-- Select Memory --</form:option>
                                    <c:forEach var="memory" items="${memories}">
                                        <form:option value="${memory.id}">${memory.name}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="memid" cssClass="text-danger"/>
                            </div>

                            <!-- Price -->
                            <div class="form-group">
                                <label for="price">Price</label>
                                <form:input path="price" cssClass="form-control" step="0.01" min="0"/>
                                <form:errors path="price" cssClass="text-danger"/>
                            </div>

                            <!-- Sale -->
                            <div class="form-group">
                                <label for="sale">Sale (%)</label>
                                <form:input path="sale" cssClass="form-control" step="0.01" min="0" max="100"/>
                                <form:errors path="sale" cssClass="text-danger"/>
                            </div>

                            <!-- Colors -->
                            <c:forEach var="color" items="${variantDetailRequest.colors}" varStatus="i">
                                <div class="color-group mt-4">
                                    <div class="form-group">
                                        <label>Color</label>
                                        <form:select path="colors[${i.index}].colorId" cssClass="form-control">
                                            <form:option value="">-- Select Color --</form:option>
                                            <c:forEach var="c" items="${availableColors}">
                                                <form:option value="${c.id}">${c.name}</form:option>
                                            </c:forEach>
                                        </form:select>
                                        <form:errors path="colors[${i.index}].colorId" cssClass="text-danger"/>
                                    </div>

                                    <div class="form-group">
                                        <label>Quantity</label>
                                        <form:input path="colors[${i.index}].quantity" type="number" cssClass="form-control" min="1"/>
                                        <form:errors path="colors[${i.index}].quantity" cssClass="text-danger"/>
                                    </div>

                                    <div class="form-group">
                                        <label>Images</label>
                                        <input type="file" name="colors[${i.index}].images" class="form-control-file" multiple>
                                    </div>
                                </div>
                            </c:forEach>

                            <!-- Submit -->
                            <button type="submit" class="btn btn-success btn-block mt-4">Save Details</button>
                        </form:form>
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

<jsp:include page="../General/LogoutModal.jsp" />

<!-- JavaScript -->
<script src="<c:url value='/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<script src="<c:url value='/js/sb-admin-2.min.js' />"></script>

</body>

</html>
