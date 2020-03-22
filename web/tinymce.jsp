
<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<!DOCTYPE html>
<html>
<head>
    <title>Tinymce</title>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/tinymce/4.5.6/tinymce.min.js"></script>--%>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>--%>
   <script src="http://cdnjs.cloudflare.com/ajax/libs/tinymce/4.5.6/jquery.tinymce.min.js"></script>--%>
</head>
<body >

    <form id="get-data-form" action="/create" method="post">
        <textarea name="ckeditor" id="ckeditor"></textarea>
        <input type="submit" name="submit" value="Get Data">
    </form>

    <script src="ckeditor5-build-classic/ckeditor.js"></script>

    <script>
        ClassicEditor.create(document.getElementById('ckeditor'));
    </script>
</body>
</html>
