<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 01.03.2020
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <link rel="stylesheet" href="css/login.css" type="text/css" />
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/login-form.css" type="text/css" />
    <title>Login Page</title>
</head>
<body>

<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">


                <div class="grid">

                    <form action="login" method="post" class="form login">

                        <header class="login__header">
                            <h3 class="login__title">Login</h3>
                        </header>

                        <div class="login__body">

                            <div class="form__field">
                                <input type="email" name="email" placeholder="Email" required>
                            </div>

                            <div class="form__field">
                                <input type="password" name="password" placeholder="Password" required>
                            </div>

                        </div>

                        <footer class="login__footer">
                            <input type="submit" value="Login">

                            <p><span class="icon icon--info">?</span><a href="registration.jsp">Sign Up</a></p>
                        </footer>

                    </form>

                </div>

        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
