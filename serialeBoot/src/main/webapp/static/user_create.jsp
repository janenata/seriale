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
    <title>Register Page</title>
</head>
<body>
<h1>Create a new user</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="login">Login</label>
        <input type="login" name="login" id="login"  required autofocus/>
    </div>
    <div>
        <label for="email">Email address</label>
        <input type="email" name="email" id="email"  required />
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="passwordRepeated">Repeat</label>
        <input type="password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>

    <button type="submit">Save</button>
</form>
</body>
</html>
