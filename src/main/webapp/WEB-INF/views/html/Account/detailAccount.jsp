<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
    <link rel="icon" type="image/png" sizes="192x192" href="<c:url value='/images/favicon/android-chrome-192x192.png' />">
    <link rel="icon" type="image/png" sizes="512x512" href="<c:url value='/images/favicon/android-chrome-512x512.png' />">
    <link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/images/favicon/apple-touch-icon.png' />">
    <link rel="manifest" href="<c:url value='/images/favicon/site.webmanifest' />">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="<c:url value='/images/favicon/android-chrome-192x192.png' />">
    <meta name="theme-color" content="#ffffff">

    <title>Detail Customer</title>

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
                    <h1 class="h3 mb-0 text-gray-800">Account Detail</h1>
                </div>

                <div class="row">

                    <div class="col-lg-12">

                        <!-- Basic Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h5 class="m-0 font-weight-bold text-primary">Information</h5>
                            </div>
                            <div class="card-body">
                                <!-- User General Information -->
                                <div class="mb-3">
                                    <h6 class="font-weight-bold text-primary">Account Information</h6>
                                    <ul class="list-group">
                                        <li class="list-group-item">
<%--                                            <strong>Id:</strong> ${account.id}--%>
                                            <strong>Id:</strong> 8u34trhn832hj289h8e27
                                        </li>
                                        <li class="list-group-item">
<%--                                            <strong>Email:</strong> ${account.email}--%>
                                            <strong>Email:</strong> thanhpham21112003@gmail.com
                                        </li>
                                    </ul>
                                </div>

                                <!-- System User Details -->
                                <div class="mb-3">
                                    <h6 class="font-weight-bold text-primary">System User Information</h6>
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>Attribute</th>
                                            <th>Details</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>Customer ID</td>
<%--                                            <td>${user.id}</td>--%>
                                            <td>87yru2892hjr1r82</td>
                                        </tr>
                                        <tr>
                                            <td>Name</td>
<%--                                            <td>${user.name}</td>--%>
                                            <td>Phạm Văn Thành</td>
                                        </tr>
                                        <tr>
                                            <td>Gender</td>
<%--                                            <td>${user.gender}</td>--%>
                                            <td>MALE</td>
                                        </tr>
                                        <tr>
                                            <td>Status</td>
<%--                                            <td>${user.systemUserStatus}</td>--%>
                                            <td>ACTIVE</td>
                                        </tr>
                                        <tr>
                                            <td>Level</td>
<%--                                            <td>${user.level}</td>--%>
                                            <td>MANAGER</td>
                                        </tr>
                                        <tr>
                                            <td>Phone</td>
<%--                                            <td>${user.phone}</td>--%>
                                            <td>0934004524</td>
                                        </tr>
                                        <tr>
                                            <td>Address</td>
<%--                                            <td>${user.address}</td>--%>
                                            <td>Binh Tan</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <!-- Roles Information -->
                                <div class="mb-3">
                                    <h6 class="font-weight-bold text-primary">Roles</h6>
                                    <ul class="list-group">
<%--                                        <c:forEach items="${roles}" var="role" varStatus="index">--%>
<%--                                            <c:if test="${index.index == 0}">--%>
<%--                                                <li class="list-group-item">--%>
<%--                                                    <strong>Role:</strong> ${role.name}</li>--%>
<%--                                            </c:if>--%>
<%--                                            <c:if test="${index.index != 0}">--%>
<%--                                                <li class="list-group-item">--%>
<%--                                                        ${role.name}</li>--%>
<%--                                            </c:if>--%>
<%--                                        </c:forEach>--%>
                                        <li class="list-group-item">
                                            <strong>Role:</strong> MANAGER ROLE
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