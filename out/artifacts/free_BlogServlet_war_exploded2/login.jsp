<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 01.03.2020
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="common/header.jsp"/>
    <link rel="stylesheet" href="css/login.css" type="text/css" />
    <title>Login Page</title>
</head>
<body>
<H1>helloword</H1>
<div class="wrapper">

<form action="login" method="post">

    Username: <input type="text" name="email">
    <br>
    Password: <input type="password" name="password">
    <br>
    <input type="submit" value="Login">
</form>

    <div class="footer">
<jsp:include page="common/footer.jsp"/>
    </div>
</div>
</body>
</html>