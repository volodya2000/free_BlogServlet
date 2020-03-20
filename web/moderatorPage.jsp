<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 18.03.2020
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/css/main.css"%></style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<html>
<head>
    <title>Moderator Page</title>
</head>
<body>
<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">
            <a class="btn btn-dark" href="<c:url value = "/profile/author"/>" role="button">Create an author account</a>

            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">Nickname</th>
                    <th scope="col">Email</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>${User.nickname}</th>
                    <th>${User.email}</th>
                </tr>
                </tbody>
            </table>
            <form action="/profile/delete" method="post">
                <input class="btn btn-dark" type="submit" value="Delete an author">
                <a class="btn btn-dark" type="submit" href="<c:url value = "/profile/delete"/>" role="button">Delete an author account</a>
            </form>
            <c:if test="${requestScope.success_deletion_author!=null}">
                <p><c:out value="${requestScope.success_deletion_author}"/></p>
            </c:if>
            <c:if test="${requestScope.failed_deletion_author!=null}">
                <p><c:out value="${requestScope.failed_deletion_author}"/></p>
            </c:if>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
