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
                <li><a href="">Find post</a></li>
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
                    <h2 id="date">Sunday, 28 March</h2>
                </div>
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

    </div>
    <footer class="main-footer"><p>Copyright&copy; 2020</p></footer>
</div>
<script src="js/currentDate.js"></script>
</body>
</html>
