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
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <title>Post</title>
</head>
<body>

<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <div class="content">
        <div class="main-content">
            <form id="get-data-form" action="/create" method="post">
                <textarea name="ckeditor" id="ckeditor"></textarea>
                <input type="submit" name="submit" value="Get Data">
            </form>

            <script src="ckeditor5-build-classic/ckeditor.js"></script>

            <script>
               // CKEDITOR_TRANSLATIONS.replace('ckeditor');
                ClassicEditor.create(document.getElementById('ckeditor'));
            </script>


        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
