<%--
  Created by IntelliJ IDEA.
  User: Izochora
  Date: 2017-04-16
  Time: 00:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="webjars/jquery/2.1.4/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
    <h3>Jaki serial dodać do subskrybcji?</h3>
    <form method="POST">
        <c:forEach var="listValue" items="${allSeries}">
            <form:checkbox path="allSeries" value="listValue" />${listValue.title}<br>
        </c:forEach>
        <input type="submit" name="submit" value="Submit">
    </form>
</div>

</body>
</html>
