<%--
  Created by IntelliJ IDEA.
  User: Izochora
  Date: 2017-04-16
  Time: 00:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <title>IzaNatSeries</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">IzaNatSeries</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user"><span class="glyphicon glyphicon-check"></span> ${user.login}</a></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class= "main col-xs-9">
            <div>
                <h3>Change your subscriptions</h3>
                <table class="table">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Rating</th>
                        <th>Station</th>
                        <th>Add</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty userSeries}">
                        <c:forEach var="listValue" items="${userSeries}">
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
                                    <c:forEach begin="${listValue.rating}" end="4" varStatus="loop">
                                        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    </c:forEach>
                                </td>
                                <td style="vertical-align: middle">${listValue.station}</td>
                                <td style="vertical-align: middle">
                                    <FORM NAME="form1" METHOD="POST">
                                        <input type="hidden" value="${listValue.title}" name="delete">
                                        <input type="submit" value="delete" class="btn btn-primary btn-md"/>
                                    </FORM>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${not empty notUserSeries}">
                        <c:forEach var="listValue" items="${notUserSeries}">
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
                                    <c:forEach begin="${listValue.rating}" end="4" varStatus="loop">
                                        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    </c:forEach>
                                </td>
                                <td style="vertical-align: middle">${listValue.station}</td>
                                <td style="vertical-align: middle">
                                    <FORM NAME="form1" METHOD="POST">
                                        <input type="hidden" value="${listValue.title}" name="add">
                                        <input type="submit" value="add" class="btn btn-primary btn-md"/>
                                    </FORM>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="sidebar col-xs-3">
            <div class="well">
                <c:if test="${not empty youMightLike}">
                    <ul class="nav">
                        <li class="nav-header">You also might like</li>
                        <c:forEach var="listValue" items="${youMightLike}">
                            <li>
                                <a href=${listValue.seriesWebsite} target="_blank">
                                        ${listValue.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
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


<script src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
