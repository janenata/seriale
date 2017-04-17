<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nathalie
  Date: 13.04.2017
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <title>Register Page</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">IzaNatSeries</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user"><span class="glyphicon glyphicon-log-in"></span>My series</a></li>
        </ul>
    </div>
</nav>
<div class="container">
<h3>Create a new user</h3>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <br><label for="login">Login</label><br>
        <input type="login" placeholder="Enter Login" name="login" id="login"  required autofocus/>
    </div>
    <div>
        <br><label for="email">Email address</label><br>
        <input type="email" placeholder="Enter email" name="email" id="email"  required />
    </div>
    <div>
        <br><label for="password">Password</label><br>
        <input type="password" placeholder="Enter password" name="password" id="password" required/>
    </div>
    <div>
        <br><label for="passwordRepeated">Repeat</label><br>
        <input type="password" placeholder="Repeat password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>
    <br>
    <button class = "btn btn-primary" type="submit">Save</button>


</form>
</div>
<script src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
