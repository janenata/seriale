<%--
  Created by IntelliJ IDEA.
  User: Nathalie
  Date: 14.04.2017
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <li><a href="/addUserToSeries"><span class="glyphicon glyphicon-pencil"></span> Add series</a></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h1>User details</h1>
    <p>Login: ${user.login}</p>
    <p>Email: ${user.email}</p>
    <c:if test="${not empty userSeries}">
        <ul class="list-group">
            <c:forEach var="listValue" items="${userSeries}">
                <li class="list-group-item" style="border: none">
                    <a href=${listValue.seriesWebsite} target="_blank">
                            ${listValue.title}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </c:if>

</div>
<script src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
