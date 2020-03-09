<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 07.03.2020
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <title>Registration Page</title>
</head>
<body>
<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">
            <form class="registration" action="registration" method="post">

    <div><label for="email">Email</label>
        <input type="email" name="email" id="email"></div>
    <div><label for="username">Username</label>
        <input type="text" name="nickname" id="username"></div>
    <div><label for="password">Password</label>
        <input type="password" name="password" id="password"></div>

    <div class="actions">
        <input type="submit" name="registrate" value="Registrate"> <a href="login.jsp">Do you have an account? Please, sign in.</a>
    </div>
</form>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>