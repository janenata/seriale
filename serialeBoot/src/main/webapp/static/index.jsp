<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css">
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
    <div class="row">
        <div class= "main col-xs-9">
            <div>
                <h2>Lista dostępnych seriali </h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Rating</th>
                        <th>Station</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty lista}">
                        <c:forEach var="listValue" items="${lista}">

                            <tr>
                                <th scope="row">
                                    <a href=${listValue.seriesWebsite} target="_blank">
                                        <img src="${listValue.imageLink}" height="132" width="100"/> &nbsp;${listValue.title}
                                    </a>
                                </th>
                                <td style="vertical-align: middle">
                                    <c:forEach begin="1" end="${listValue.rating}" varStatus="loop">
                                        <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    </c:forEach>
                                    <c:forEach begin="${listValue.rating}" end="9" varStatus="loop">
                                        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    </c:forEach>
                                </td>
                                <td style="vertical-align: middle">${listValue.station}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="sidebar col-xs-3">
            <div class="well">
                <c:if test="${not empty mostPopular}">
                    <ul class="nav">
                        <li class="nav-header">Most popular series</li>
                        <c:forEach var="listValue" items="${mostPopular}">
                            <li>
                                <a href=${listValue.seriesWebsite} target="_blank">
                                        ${listValue.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${not empty topRated}">
                    <ul class="nav">
                        <li class="nav-header">Top rated series</li>
                        <c:forEach var="listValue" items="${topRated}">
                            <li>
                                <a href=${listValue.seriesWebsite} target="_blank">
                                        ${listValue.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
        </div>
    </div>
</div>
<script src="/webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
