<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Servlet Blog</title>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/login-form.css" type="text/css" />
    <script src="https://kit.fontawesome.com/10404fa3b3.js" crossorigin="anonymous"></script>
</head>
<body>

<div class="wrapper">
    <header class="main-head">
        <div class="logo">
            <a href="home"><h1>Free ServletBlog</h1></a>
        </div>

        <nav class="main-nav">

        </nav>
    </header>
    <div class="content">
        <div class="main-content">

            <div class="main">
                <div class="grid">

                    <form action="${pageContext.request.contextPath}/login" method="post" class="form login">

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

                            <p><span class="icon icon--info">?</span><a href="registration">Sign Up</a></p>
                        </footer>

                    </form>

                </div>
            </div>
            <aside class="ads">

                <div class="social-icons">
                    <h6>Contact us:</h6>
                    <a href="https://www.facebook.com/studporohvezha/?eid=ARDeGuagdD44jyIXwjOZKDbpRJAgLe9D7arvmn1lf2dpO6W1n4PLsAYNWQIy9T71eu1LdPlvdSO0WrwO"> <i class="fab fa-facebook"></i></a>
                    <a href="">  <i class="fab fa-instagram"></i></a>
                    <a href=""> <i class="fab fa-twitter"></i></a>



                </div>
            </aside>
        </div>

    </div>
    <footer class="main-footer"><p>Copyright&copy; 2020</p></footer>
</div>
</body>
</html>