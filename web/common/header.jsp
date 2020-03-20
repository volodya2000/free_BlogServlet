<%@ page import="entities.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 01.03.2020
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>
<header class="main-head">
    <div class="logo">
        <a href=""></a>
    </div>
    <% User users =(User)request.getAttribute("User");
        request.setAttribute("User",users);
    %>
    <nav class="main-nav">
        <ul class="nav-bar">
            <li><a href="">News</a></li>
            <li><a href="">Find news</a></li>
            <li><a href="">About</a></li>
            <li><a href="">Ukraine</a></li>
            <li><a href="">Account</a>
                <ul class="inner-list" >
                    <li><a href="/profile" id="profile">Profile</a></li>
                    <li><a href="#" id="settings">Plugins</a></li>
                    <li><a href="/logout" id="logout">Logout</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>
</body>
</html>
