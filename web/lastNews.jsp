<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 28.03.2020
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="css/main.css">
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
                <li><a href="find">Find post</a></li>
                <li><a href="">About</a></li>
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
                <div class="titles"><h2>Top news</h2></div>
                <div class="main_news">
                    <div class="foto"><a href="/post?id=${requestScope.latestNews.getId()}"><img src="${requestScope.latestNews.getImageSource()}" alt="coronavirus"></a></div>
                    <div class="signature">
                        <div class="title"> <h1>${requestScope.latestNews.getNameOfPost()}</h1>
                            <p>${requestScope.latestNews.getDescription()}</p></div>
                        <div class="meta_tags"><div class="author_date"><div class="author"><i class="fas fa-user-circle"></i><a href="">Admin</a> </div>
                            <div class="posts_date">${requestScope.latestNews.getDate().toString()}</div></div>
                            <a href="/post?id=${requestScope.latestNews.getId()}">Read more...</a></div>
                    </div>
                </div>

                <div class="titles"><h2>Last news</h2></div>

                <div class="news last_news">
                    <c:forEach var="post" items="${requestScope.latestNewsList}">
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
            <aside class="ads">

                <div class="social-icons">
                    <h6>Contact us:</h6>
                    <a href=""> <i class="fab fa-facebook"></i></a>
                    <a href="">  <i class="fab fa-instagram"></i></a>
                    <a href=""> <i class="fab fa-twitter"></i></a>



                </div>
            </aside>
        </div>

    </div>
    <footer class="main-footer"><p>Copyright&copy; 2020</p></footer>
</div>
<script src="js/currentDate.js"></script>
</body>
</html>
