<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="CONTEXT_PATH" value="${pageContext.request.contextPath}"
       scope="application" />
<c:set var="RESOURCES_PATH" value="${CONTEXT_PATH}/resources"
       scope="application" />
<!DOCTYPE html>
<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
      data-theme="theme-default" data-assets-path="../assets/"
      data-template="vertical-menu-template-free">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="text/javascript">
        var CONTEXT_PATH = "${CONTEXT_PATH}";
        var RESOURCES_PATH = "${RESOURCES_PATH}";
    </script>

    <meta name="description" content="" />

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="${RESOURCES_PATH}/assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="${RESOURCES_PATH}/assets/vendor/fonts/boxicons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="${RESOURCES_PATH}/assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="${RESOURCES_PATH}/assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="${RESOURCES_PATH}/assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="${RESOURCES_PATH}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

    <!-- Page CSS -->
    <!-- Page -->
    <link rel="stylesheet" href="${RESOURCES_PATH}/assets/vendor/css/pages/page-auth.css" />
    <!-- Helpers -->
    <script src="${RESOURCES_PATH}/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="${RESOURCES_PATH}/assets/js/config.js"></script>
</head>

<body>
<!-- Content -->

<div class="container-xxl">
    <div class="authentication-wrapper authentication-basic container-p-y">
        <tiles:insertAttribute name="body" />
    </div>
</div>

<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="${RESOURCES_PATH}/assets/vendor/libs/jquery/jquery.js"></script>
<script src="${RESOURCES_PATH}/assets/vendor/libs/popper/popper.js"></script>
<script src="${RESOURCES_PATH}/assets/vendor/js/bootstrap.js"></script>
<script src="${RESOURCES_PATH}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="${RESOURCES_PATH}/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->

<!-- Main JS -->
<script src="${RESOURCES_PATH}/assets/js/main.js"></script>

<!-- Page JS -->

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>
