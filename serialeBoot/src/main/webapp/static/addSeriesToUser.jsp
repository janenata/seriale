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
    <title>IzaNatSeries ${user.login}</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">IzaNatSeries</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/home">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user"><span class="glyphicon glyphicon-check"></span> ${user.login}</a></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h3>Change your subscriptions</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Tittle</th>
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
                                ${listValue.title}
                        </a>
                    </th>
                    <td>
                        <c:forEach begin="1" end="${listValue.rating}" varStatus="loop">
                            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        </c:forEach>
                        <c:forEach begin="${listValue.rating}" end="9" varStatus="loop">
                            <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                        </c:forEach>
                    </td>
                    <td>${listValue.station}</td>
                    <td>
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
                                ${listValue.title}
                        </a>
                    </th>
                    <td>
                        <c:forEach begin="1" end="${listValue.rating}" varStatus="loop">
                            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        </c:forEach>
                        <c:forEach begin="${listValue.rating}" end="9" varStatus="loop">
                            <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                        </c:forEach>
                    </td>
                    <td>${listValue.station}</td>
                    <td>
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
<script src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
