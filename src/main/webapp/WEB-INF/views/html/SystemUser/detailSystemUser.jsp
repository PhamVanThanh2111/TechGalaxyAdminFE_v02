<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.enumeration.Gender" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
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

    <title>Detail System User</title>

    <!-- Custom fonts for this template-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link href="<c:url value="/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin-2.min.css"/>" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!--    Sidebar -->
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
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">System User Detail</h1>
                </div>

                <div class="row">

                    <div class="col-lg-12">

                        <!-- Basic Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h5 class="m-0 font-weight-bold text-primary">Information</h5>
                            </div>
                            <div class="card-body">

                                <!-- Profile Picture -->
                                <div class="mb-3 text-center">
                                    <c:if test="${systemUser.gender == Gender.MALE}">
                                        <img src="<c:url value='${"/img/undraw_profile.svg"}' />"
                                             alt="avatar"
                                             class="img-thumbnail"
                                             style="width: 200px; height: 200px; border-width: 0; border-radius: 50%;">
                                    </c:if>
                                    <c:if test="${systemUser.gender == Gender.FEMALE}">
                                        <img src="<c:url value='${"/img/undraw_profile_1.svg"}' />"
                                             alt="avatar"
                                             class="img-thumbnail"
                                             style="width: 200px; height: 200px; border-width: 0; border-radius: 50%;">

                                    </c:if>
                                </div>

                                <!-- User General Information -->
                                <div class="mb-3">
                                    <h6 class="font-weight-bold text-primary">User Information</h6>
                                    <ul class="list-group">
                                        <li class="list-group-item"><strong>Full Name:</strong>
                                            ${systemUser.name}
                                        </li>
                                        <li class="list-group-item">
                                            <%--                                            <strong>Email:</strong> ${systemUser.account.email}--%>
                                            <strong>Email:</strong> phamtrung21112003@gmail.com
                                        </li>
                                        <li class="list-group-item">
                                            <%--                                            <strong>Phone Number:</strong> ${systemUser.phone}--%>
                                            <strong>Phone Number:</strong> 0934004524
                                        </li>
                                        <li class="list-group-item">
                                            <%--                                            <strong>Address:</strong> ${systemUser.address}--%>
                                            <strong>Address:</strong> Binh Tan
                                        </li>
                                        <li class="list-group-item">
                                            <%--                                            <strong>Gender:</strong> ${systemUser.gender}--%>
                                            <strong>Gender:</strong> MALE
                                        </li>
                                    </ul>
                                </div>

                                <!-- Additional User Details -->
                                <div class="mb-3">
                                    <h6 class="font-weight-bold text-primary">Additional Information</h6>
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>Attribute</th>
                                            <th>Details</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>Level</td>
                                            <%--                                            <td>${systemUser.level}</td>--%>
                                            <td>ADMIN</td>
                                        </tr>
                                        <tr>
                                            <td>Customer ID</td>
                                            <%--                                            <td>${systemUser.id}</td>--%>
                                            <td>jfwfyh793r32ur82ury278rhe2ye28yyhdo</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <!-- Status Information -->
                                <div class="mb-3">
                                    <h6 class="font-weight-bold text-primary">Status</h6>
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <%--                                            <strong>Status:</strong> ${systemUser.systemUserStatus}</li>--%>
                                            <strong>Status:</strong> ACTIVE
                                        </li>
                                    </ul>
                                </div>
                            </div>

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
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<jsp:include page="../General/LogoutModal.jsp"/>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.bundle.min.js" />"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/jquery-easing/jquery.easing.min.js" />"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/js/sb-admin-2.min.js" />"></script>

</body>

</html>