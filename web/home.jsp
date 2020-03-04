<%@ page import="entities.User" %><%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 01.03.2020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <title>Home Page</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<%
    String sessionName=null;
    sessionName=session.getId();
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
<h1>Welcome to home <%=userName %>. Your JsessionID is <%=sessionID%>. Your sessionId is <%=sessionName%> </h1>

<form action="logout" method="post">
    <input type="submit" value="Logout" >
</form>
<jsp:include page="/common/footer.jsp" />
</body>
</html>
