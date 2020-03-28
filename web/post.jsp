<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/home.css" type="text/css" />
    <title>${requestScope.title}</title>
    <style>
        table, th, td {
            border: 1px solid black;
            justify-content: center;
            align-content: center;
        }
    </style>
</head>
<body>

<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">
            ${requestScope.content}
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
