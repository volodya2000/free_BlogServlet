<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/home-style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
                        <li><a href="#" id="setttings">Actions</a></li>
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
                    <h2 id="date">Sunday, 28 March</h2>
                </div>
                <form id="get-data-form" action="/create" method="post">
                    <textarea name="ckeditor" id="ckeditor"></textarea>
                    <input type="text" placeholder="Write a short description" name="description">
                    <input type="text" placeholder="Insert image link" name="imageSource">
                    <input type="text" placeholder="Post name" name="postName">
                    <input type="submit" name="submit" value="Create post">
                </form>

                <script src="ckeditor_4.14.0_full/ckeditor/ckeditor.js"  charset="utf-8"></script>
                <script>
                    CKEDITOR.replace('ckeditor');
                </script>
            </div>

        </div>

    </div>

</div>
<footer class="main-footer"><p>Copyright&copy; 2020</p></footer>
</div>
<script src="js/search.js"></script>
<script src="js/currentDate.js"></script>
</body>
</html>


