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

    private static Logger logger =Logger.getLogger(CreateAuthorServlet.class.toString());
    private AuthorService authorService= new AuthorService();
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Cookie[] cookies = request.getCookies();
        Optional<Cookie>findUser=Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("user_cookie")).findAny();
        User user= userService.findUserByNickname(findUser.get().getValue());
        logger.info("user= "+user.getId());
        logger.info("user roles= "+user.getRolesList());
        String name = request.getParameter("name");
        String surname =request.getParameter("surname");
        if(!authorService.isAuthorExist(user.getId()))
        {
            authorService.addAuthor(user,name,surname);
            RequestDispatcher rd = request.getRequestDispatcher("/createAuthor.jsp");
            rd.forward(request,response);
        }else {
            request.setAttribute("author_exist", "You have already been an author");
            RequestDispatcher rd = request.getRequestDispatcher("/createAuthor.jsp");
            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/createAuthor.jsp");
        rd.forward(request,response);
    }
}
