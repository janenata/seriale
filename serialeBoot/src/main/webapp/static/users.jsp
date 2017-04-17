<%--
  Created by IntelliJ IDEA.
  User: Nathalie
  Date: 15.04.2017
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <title>Users</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">IzaNatSeries</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user/create"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/user"><span class="glyphicon glyphicon-log-in"></span>My series</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <p>Hello users!</p>
</div>
<script src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
