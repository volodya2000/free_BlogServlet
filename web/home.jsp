<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 01.03.2020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <title>Home Page</title>
</head>
<body>
<%
    String sessionName=null;
    sessionName=(String)session.getAttribute("name");
    String userName=null;
    String sessionID=null;

    Cookie [] cookies=request.getCookies();
    if(cookies!=null)
    {
        for(Cookie cookie:cookies)
        {
            if (cookie.getName().equals("JSESSIONID"))sessionID=cookie.getValue();
            if(cookie.getName().equals("user_cookie"))userName=cookie.getValue();
        }
    }

%>

<div class="wrapper">
        <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">

            <c:forEach items="${users}" var="dept">
                <h3>${dept.getNickname()}</h3>

            </c:forEach>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
