<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.User" %><%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 12.03.2020
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Profile Page</title>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
</head>
<body>
<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">
            <h1>USER PAGE</h1>
            <table border="1">
                <tr>
                    <td>Nickname</td>
                    <td>Email</td>
                </tr>

                    <tr>
                        <th>${User.nickname}</th>
                        <th>${User.email}</th>
                    </tr>
            </table>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
