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

@WebServlet(name = "adminPanel",urlPatterns = {"/profile/moderate","/profile/logout","/profile/profile"})
public class AdminPanelServlet extends HttpServlet {

    private UserService userService=new UserService();
    private static Logger logger=Logger.getLogger(AdminPanelServlet.class.toString());


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getRequestURI().equals("/profile/logout"))
        {
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/logout");
            rd.include(request,response);
        }
        User user;
        user=(User)getServletContext().getAttribute("find_user");
        String makeAdmin,makeModerator,deleteUser;
        logger.info("user"+user);
        makeAdmin=request.getParameter("makeAdmin");
        makeModerator=request.getParameter("makeModerator");
        deleteUser=request.getParameter("deleteUser");
        if((makeAdmin!=null&&deleteUser!=null)
                ||(makeModerator!=null&&deleteUser!=null)||(makeAdmin==null&&deleteUser==null&&makeModerator==null))
        {
            Cookie failedOperation=new Cookie("failed_operation","Error!");
            response.addCookie(failedOperation);
            request.setAttribute("fail","Error!");
            response.sendRedirect("/profile");
        }else {
            if(deleteUser!=null)
            {
                userService.deleteUser(user.getId());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher rd=getServletContext().getRequestDispatcher("/adminPage.jsp");
//        rd.include(request,response);
        response.sendRedirect("/profile");
    }
}
