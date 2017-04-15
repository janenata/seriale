<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <script src="webjars/jquery/2.1.4/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <title>IzaNatSeries</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">IzaNatSeries</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user/create"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/user"><span class="glyphicon glyphicon-log-in"></span>My series</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h2>Lista dostępnych seriali </h2>
    <c:if test="${not empty lista}">
        <ul class="list-group">
            <c:forEach var="listValue" items="${lista}">
                <li class="list-group-item" style="border: none" >
                    <c:forEach begin="1" end="${listValue.rating}" varStatus="loop">
                        <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                    </c:forEach>
                    <c:forEach begin="${listValue.rating}" end="9" varStatus="loop">
                        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                    </c:forEach>&nbsp;
                    <a href=${listValue.seriesWebsite} target="_blank">
                            ${listValue.title}
                    </a>
                </li>
            </c:forEach>
        </ul>

    </c:if>
</div>
</body>
</html>
