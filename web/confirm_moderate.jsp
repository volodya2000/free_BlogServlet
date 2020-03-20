<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 12.03.2020
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/css/main.css"%></style>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">
          <c:if test="${requestScope.success_delete!=null}">
              <p>Delete was successfully!</p>
          </c:if>

            <c:if test="${requestScope.success_moder!=null}">
                <p><c:out value="${requestScope.success_moder}">
                </c:out></p>
            </c:if>

            <c:if test="${requestScope.failed_moder!=null}">
                <p><c:out value="${requestScope.failed_moder}">
                </c:out></p>
            </c:if>

            <c:if test="${requestScope.success_admin!=null}">
                <p><c:out value="${requestScope.success_admin}">
                </c:out></p>
            </c:if>

            <c:if test="${requestScope.failed_admin!=null}">
                <p><c:out value="${requestScope.failed_admin}">
                </c:out></p>
            </c:if>

            <c:if test="${requestScope.success_moder_admin!=null}">
                <p><c:out value="${requestScope.success_moder_admin}">
                </c:out></p>
            </c:if>

            <c:if test="${requestScope.failed_moder_admin!=null}">
                <p><c:out value="${requestScope.failed_moder_admin}">
                </c:out></p>
            </c:if>
            <a href="<c:url value = "/profile"/>" >Go to profile menu!</a>
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
