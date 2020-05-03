package controllers;

import entities.User;
import services.AuthorService;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet(name = "CreateAuthorServlet",urlPatterns = {"/profile/author"})
public class CreateAuthorServlet extends HttpServlet {


    private final String AUTHOR_EXIST="You have already been an author";
    private final String AUTHOR_CREDENTIALS_EMPTY="Name or username can not be empty";
    private static Logger logger =Logger.getLogger(CreateAuthorServlet.class.toString());
    private AuthorService authorService= new AuthorService();
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        synchronized (this) {
            Cookie[] cookies = request.getCookies();
            Optional<Cookie> findUser = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("user_cookie")).findAny();
            User user = userService.findUserByNickname(findUser.get().getValue());

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            if (!authorService.isAuthorExist(user.getId()) && name != null && surname != null) {
                authorService.addAuthor(user, name, surname);
                RequestDispatcher rd = request.getRequestDispatcher("/createAuthor.jsp");
                rd.forward(request, response);
            } else {
                if (name == null || surname == null) {
                    request.setAttribute("empty_author", AUTHOR_CREDENTIALS_EMPTY);
                    getServletContext().getRequestDispatcher("/createAuthor.jsp").forward(request, response);
                }
                request.setAttribute("author_exist", AUTHOR_EXIST);
                RequestDispatcher rd = request.getRequestDispatcher("/createAuthor.jsp");
                rd.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/createAuthor.jsp");
        rd.forward(request,response);
    }
}
