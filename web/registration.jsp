<%--
  Created by IntelliJ IDEA.
  User: vovan
  Date: 07.03.2020
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common/header.jsp"/>
    <link rel="stylesheet" href="css/login.css" type="text/css" />
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <title>Registration Page</title>
</head>
<body>
<div class="wrapper">

    <form action="registration" method="post">
            <fieldset>
                <legend>Контактная информация</legend>
                <p><label for="name">Имя <em>*</em></label><input type="text" id="name" name="nickname"></p>
                <p><label for="email">E-mail</label><input type="email"id="email" name="email"></p>
                <p><label for="password">E-mail</label><input type="password"id="password" name="password"></p>
            </fieldset>
            <p><input type="submit" value="Отправить"></p>

    </form>

    <div class="footer">
        <jsp:include page="common/footer.jsp"/>
    </div>
</div>
</body>
</html>