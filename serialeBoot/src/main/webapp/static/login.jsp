<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nathalie
  Date: 13.04.2017
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">IzaNatSeries</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user/create"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <form role="form" action="/login" method="post">
        <div>
            <label for="login">Login</label>
            <input type="login" name="login" id="login" required autofocus>
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required>
        </div>
        <div>
            <label for="remember-me">Remember me</label>
            <input type="checkbox" name="remember-me" id="remember-me">
        </div>
        <button type="submit">Sign in</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <c:if test="${error.isPresent()}">
        <p>The login or password you have entered is invalid, try again.</p>
    </c:if>
</div>
<script src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
