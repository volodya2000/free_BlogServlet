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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<%--    <link rel="stylesheet" href="css/mainOld.css" type="text/css" />--%>
    <link rel="stylesheet" href="css/home.css" type="text/css"/>
    <link rel="stylesheet " href="css/pagination.css" type="text/css"/>
    <title>Home Page</title>

</head>
<body>

<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">


    <div class="home-content">
    <c:forEach var="post"  items="${requestScope.currentPosts}" >
        <div class="posts">
            <c:out value="${post.getId()}"> </c:out>
            <a href="/home?id=${post.getId()}">${post.getNameOfPost()}>

                <img src="data:image/jpeg;base64,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" alt="альтернативный текст">
            </a>
        </div>
    </c:forEach>
    </div>

    <div class="pagination">
        <c:if test="${requestScope.currentPage != 1}">
            <a href="home?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${requestScope.currentPage-1}">Previous</a>
        </c:if>
        <c:forEach begin="1" end="30" var="i">

           <c:choose>
               <c:when test="${requestScope.currentPage eq i}">
                   <a class="active"href="home?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${i}">${i}</a>
               </c:when>
               <c:otherwise><a  href="home?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${i}">${i}</a>
               </c:otherwise>
           </c:choose>
       </c:forEach>
        <c:if test="${requestScope.currentPage lt requestScope.noOfPages}">
            <a href="home?recordsPerPage=${requestScope.recordsPerPage}&currentPage=${requestScope.currentPage+1}">Next</a>
        </c:if>
    </div>
        </div>
    </div>
<%--    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>--%>
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>--%>

    <jsp:include page="common/footer.jsp"/>
</div>

</body>
</html>
