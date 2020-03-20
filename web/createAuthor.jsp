<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 19.03.2020
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/css/main.css"%></style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<html>
<head>
    <title>Author page</title>
</head>
<body>
<div class="wrapper">
        <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">

            <form action="/profile/author" method="post">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name" id="name" aria-describedby="emailHelp" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label for="surname">Surname</label>
                    <input type="text" class="form-control" name="surname" id="surname" placeholder="Enter surname">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <c:if test="${requestScope.author_exist!=null}">
                <p><c:out value="${requestScope.author_exist}"/></p>
            </c:if>
            <a class="btn btn-dark" href="<c:url value = "/profile"/>" role="button">Back to profile</a>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>

</body>
</html>
