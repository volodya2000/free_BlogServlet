<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet " href="css/pagination.css"/>
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/home-style.css"/>
    <script src="https://kit.fontawesome.com/10404fa3b3.js" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Last news</title>

</head>
<body>
<div class="wrapper">
    <header class="main-head">
        <div class="logo">
            <a href="home"><h1>Free ServletBlog</h1></a>
        </div>

        <nav class="main-nav">
            <ul class="nav-bar">
                <li><a href="home">Top Posts</a></li>
                <li><a href="news">All posts</a></li>
                <li><a href="find">Find post</a></li>
                <li>Account <i  class="fas fa-bars"></i>
                    <ul class="inner-list" >
                        <li><a href="profile" id="profile">Profile</a></li>
                        <li><a href="#" id="settings">Actions</a></li>
                        <li id="logout">
                            <a href="logout" id="settings">Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </header>
    <div class="content">
        <div class="main-content">

            <div class="main">
                <div class="greeting_and_date">
                    <h2>Welcome to my blog!</h2>
                    <h2 id="date">Sunday, 28 March</h2>
                </div>

                <div class="titles"><h2>Last news</h2></div>

                <div class="news last_news">
                    <c:forEach var="post" items="${requestScope.news}">
                        <div class="news1">
                            <div class="posts_body"><div class="image"><a href="/post?id=${post.getId()}"><img src="${post.getImageSource()}" alt="coronavirus"></a></div><div class="title"> <h2>${post.getNameOfPost()}</h2>
                                <p>${post.getDescription()}</p></div></div>


                            <div class="meta_tags"><div class="author_date"><div class="author"><i class="fas fa-user-circle"></i><a href="">Admin</a> </div>
                                <div class="posts_date">${post.getDate().toString()}</div></div>
                                <a href="/post?id=${post.getId()}">Read more...</a></div>

                        </div>
                    </c:forEach>
                </div>

            </div>
            <div class="pagination">
                <c:if test="${requestScope.currentPage != 1}">
                    <a href="news?currentPage=${requestScope.currentPage-1}">Previous</a>
                </c:if>
                <c:forEach begin="1" end="${requestScope.numberOfPages}" var="i">

                    <c:choose>
                        <c:when test="${requestScope.currentPage eq i}">
                            <a class="active"href="news?currentPage=${i}">${i}</a>
                        </c:when>
                        <c:otherwise><a  href="news?currentPage=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${requestScope.currentPage lt requestScope.numberOfPages}">
                    <a href="news?currentPage=${requestScope.currentPage+1}">Next</a>
                </c:if>
            </div>

        </div>

    </div>
    <footer class="main-footer"><p>Copyright&copy; 2020</p></footer>
</div>
<script src="js/currentDate.js"></script>
</body>
</html>