<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 27/11/24
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${mess}</h1>
<form action="/login" method="post">
    Username:<input type="text" name="username"/>
    <br/>
    Password:<input type="password" name="password"/>
    <br/>
    <button type="submit">Login</button>
</form>
</body>
</html>
