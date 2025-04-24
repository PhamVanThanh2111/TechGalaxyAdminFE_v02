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
    <link rel="icon" type="image/png" sizes="192x192"
          href="<c:url value='/images/favicon/android-chrome-192x192.png' />">
    <link rel="icon" type="image/png" sizes="512x512"
          href="<c:url value='/images/favicon/android-chrome-512x512.png' />">
    <link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/images/favicon/apple-touch-icon.png' />">
    <link rel="manifest" href="<c:url value='/images/favicon/site.webmanifest' />">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="<c:url value='/images/favicon/android-chrome-192x192.png' />">
    <meta name="theme-color" content="#ffffff">

    <title>Edit Variant</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/css/sb-admin-2.min.css' />" rel="stylesheet">
    <style>
        #avatarPreview {
            max-width: 100%;
            max-height: 250px;
            border: 1px solid #ccc;
            margin-top: 10px;
            display: none; /* Default to hidden */
        }
    </style>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../General/Sidebar.jsp"/>

    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <jsp:include page="../General/Topbar.jsp"/>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-flex align-items-center mb-4">
                    <a href="/products" class="btn btn-outline-primary btn-lg me-3">
                        <i class="fas fa-arrow-left"></i> Back
                    </a>
                    <h1 class="h3 mb-0 text-gray-800">
                        Edit Variant: <span class="text-primary">${variant.name}</span>
                    </h1>
                </div>

                <!-- Edit Variant Form -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Edit Variant</h6>
                    </div>
                    <div class="card-body">
                        <form:form action="/products/variants/update/${variant.id}"
                                   method="post" modelAttribute="variant" enctype="multipart/form-data">
                            <!-- Name -->
                            <div class="form-group">
                                <label for="variantName">Name</label>
                                <form:input path="name" id="variantName" cssClass="form-control"/>
                                <form:errors path="name" cssClass="text-danger"/>
                            </div>

                            <!-- Description -->
                            <div class="form-group">
                                <label for="variantDescription">Description</label>
                                <form:textarea path="description" id="variantDescription" cssClass="form-control"
                                               rows="3"/>
                            </div>

                            <!-- Content -->
                            <div class="form-group">
                                <label for="variantContent">Content</label>
                                <form:textarea path="content" id="variantContent" cssClass="form-control" rows="5"/>
                            </div>

                            <!-- Avatar -->
                            <div class="form-group">
                                <label for="variantAvatar">Avatar</label>
                                <input type="file" class="form-control-file" id="variantAvatar" name="avatar"
                                       accept=".png, .jpg, .jpeg">
                                <img id="avatarPreview" alt="Avatar Preview"/>
                            </div>

                            <!-- Featured -->
                            <div class="form-group">
                                <label for="variantFeatured">Featured</label>
                                <form:select path="featured" id="variantFeatured" cssClass="form-control">
                                    <form:option value="">-- Select --</form:option>
                                    <form:option value="true">Yes</form:option>
                                    <form:option value="false">No</form:option>
                                </form:select>
                                <form:errors path="featured" cssClass="text-danger"/>
                            </div>

                            <!-- Status -->
                            <div class="form-group">
                                <label for="variantStatus">Status</label>
                                <form:select path="status" id="variantStatus" cssClass="form-control">
                                    <form:option value="">-- Select --</form:option>
                                    <form:option value="AVAILABLE">Available</form:option>
                                    <form:option value="OUT_OF_STOCK">Out of Stock</form:option>
                                    <form:option value="DISCONTINUED">Discontinued</form:option>
                                </form:select>
                                <form:errors path="status" cssClass="text-danger"/>
                            </div>

                            <!-- Usage Category -->
                            <div class="form-group">
                                <label for="usageCategoryId">Usage Category</label>
                                <form:select path="usageCategoryId" id="usageCategoryId" cssClass="form-control">
                                    <form:option value="">-- Select --</form:option>
                                    <c:forEach items="${usageCategories}" var="usageCategory">
                                        <form:option value="${usageCategory.id}">${usageCategory.name}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="usageCategoryId" cssClass="text-danger"/>
                            </div>
                            <button type="submit" class="btn btn-success btn-block">Update Variant</button>
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

<jsp:include page="../General/LogoutModal.jsp"/>

<!-- JavaScript -->
<script src="<c:url value='/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<script src="<c:url value='/js/sb-admin-2.min.js' />"></script>
<script>
    $(document).ready(() => {
        const avatarFile = $("#variantAvatar");
        const orgImage = "${variant.avatar}";

        // Check if the avatar already exists and display it
        if (orgImage) {
            const urlImage = "http://localhost:8081/storage/" + orgImage;
            $("#avatarPreview").attr("src", urlImage).css("display", "block");
        }

        // Handle file selection for new image upload
        avatarFile.change((e) => {
            const imgURL = URL.createObjectURL(e.target.files[0]);
            $("#avatarPreview").attr("src", imgURL).css("display", "block");
        });
    });
</script>
</body>

</html>
