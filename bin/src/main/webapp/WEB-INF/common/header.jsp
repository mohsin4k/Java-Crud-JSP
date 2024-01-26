<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

    <head>
        <title>Manage Employee</title>

        <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">

        <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
        <script src="webjars/jquery-validation/1.19.5/jquery.validate.min.js"></script>
        <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>

        <style>
            .footer{
                position: absolute;
                bottom: 0;
                height: 60px;
                width: 100%;
                background-color: #f5f5f5;
            }

            .form-control.error {
                background-color: #fce4e4;
                border: 1px solid #cc0033;
                outline: none;
            }

            label.error{
                color: red;
            }

        </style>
    </head>

    <body>
        <c:set var="user" value="${sessionScope.username}"/>
        <ul class="navbar navbar-light bg-light navbar-header nav">
            <a class="navbar-brand ps-3" href="${pageContext.request.contextPath}/">Manage Employee</a>

            <ul class="navbar-right pe-3 nav">
                <li class="text-end nav-item me-3">
                    <a href="${pageContext.request.contextPath}/employee-list.do">Employee List</a>
                </li>
                <c:if test="${not empty user}">
                    <li class="nav-item me-3">
                        <a href="${pageContext.request.contextPath}/logout.do">Logout</a>
                    </li>
                </c:if>
                <c:if test="${empty user}">
                    <li class="nav-item me-3">
                        <a href="${pageContext.request.contextPath}/login.do">Login</a>
                    </li>
                </c:if>
            </ul>
        </ul>