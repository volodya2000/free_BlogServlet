<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 12.03.2020
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
</head>
<body>
<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">
            <div class="info">
                <form action="profile" name="findUser" method="post">
                    <input type="text" name="user" id="user">
                    <button type="submit"> Find user.</button>
                </form>
                <c:if test="${requestScope.findUser!=null}">
                    <c:out value="${requestScope.findUser.getEmail()}"/>

                   <form action="profile/moderate" method="post">
                        <div class="check-box">
                            <div class="form-check form-check-inline">
                                <input class="makeAdmin" type="checkbox" name="makeAdmin" id="makeAdmin">
                                <label class="makeAdmin" for="makeAdmin">make admin</label>
                            </div>
                        <div class="form-check form-check-inline">
                                <input class="makeModerator" type="checkbox" name="makeModerator" id="makeModerator">
                                <label class="makeModerator" for="makeModerator">make moder</label>
                        </div>
                            <div class="form-check form-check-inline">
                                <input class="deleteUser" type="checkbox" name="deleteUser" id="deleteUser">
                                <label class="deleteUser" for="deleteUser">delete</label>
                            </div>
                        </div>
                       <input type="submit" value="Send Request">
                    </form>
                </c:if>
                <c:if test="${requestScope.fail!=null}">
                    <c:out value="Error!"/>
                </c:if>
            </div>
            <div class="table">
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
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
