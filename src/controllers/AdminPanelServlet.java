package controllers;

import entities.Roles;
import entities.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet(name = "adminPanel",urlPatterns = {"/profile/moderate"})
public class AdminPanelServlet extends HttpServlet {

    private UserService userService=new UserService();
    private static Logger logger=Logger.getLogger(AdminPanelServlet.class.toString());


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user;
        String makeAdmin,makeModerator,deleteUser;
        makeAdmin=request.getParameter("makeAdmin");
        makeModerator=request.getParameter("makeModerator");
        deleteUser=request.getParameter("deleteUser");
        List<String>moderate= Arrays.asList(makeAdmin,makeModerator,deleteUser);
        if((makeAdmin!=null&&deleteUser!=null)
                ||(makeModerator!=null&&deleteUser!=null)||(makeAdmin==null&&deleteUser==null&&makeModerator==null))
        {
            Cookie failedOperation=new Cookie("failed_operation","Error!");
            response.addCookie(failedOperation);
            request.setAttribute("fail","Error!");
            response.sendRedirect("/profile");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd=getServletContext().getRequestDispatcher("/adminPage.jsp");
        rd.forward(request,response);
    }
}
