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

@WebServlet(name = "DeleteAuthorServlet",urlPatterns = "/profile/delete")
public class DeleteAuthorServlet extends HttpServlet {
    private AuthorService authorService=new AuthorService();
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        synchronized (this)
        {Cookie[] cookies = request.getCookies();
        Optional<Cookie> findUser= Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("user_cookie")).findAny();
        User user= userService.findUserByNickname(findUser.get().getValue());
        if(authorService.getAuthorByUserId(user.getId())!=null)
        {
            request.setAttribute("success_deletion_author","Author  was deleted");
            authorService.deleteAuthorByUserId(user.getId());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/moderatorPage.jsp");
            rd.forward(request,response);
        }else
        {
            request.setAttribute("failed_deletion_author","You don`t have an author account.Please,create it.");
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/moderatorPage.jsp");
            rd.forward(request,response);
        }
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/moderatorPage.jsp");
        rd.forward(request,response);
    }
}
