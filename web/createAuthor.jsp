
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
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
                <li><a href="find">Find post</a></li>
                <li><a href="">About</a></li>
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
                <div class="createAuthor">
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
<script src="js/search.js"></script>
<script src="js/currentDate.js"></script>
</body>
</html>


