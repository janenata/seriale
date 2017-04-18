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
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user/create"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <c:if test="${error.isPresent()}">
        <p style="color:red"> Invalid login or password, try again</p>
    </c:if>
    <form role="form" action="/login" method="post">
        <div>
            <br><label for="login">Login</label><br>
            <input type="login" placeholder="Enter Login" name="login" id="login" required autofocus>
        </div>
        <div>
            <br><label for="password">Password</label><br>
            <input type="password" placeholder="Enter Password" name="password" id="password" required>
        </div>
        <div>
            <br><label for="remember-me" style="vertical-align: middle">Remember me</label>
            <input type="checkbox" name="remember-me" id="remember-me" >
        </div>
        <br><button class="btn btn-primary" type="submit">Sign in</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <p>Don't have account? <a href="/user/create" >Sign up!</a></p>

</div>
<script src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
