package controllers;

import entities.Roles;
import entities.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "profile",urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

        private UserService userService=new UserService();
        private static Logger logger=Logger.getLogger(ProfileServlet.class.toString());

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user;
            String nickname=request.getParameter("user");
            logger.info("nickname= "+nickname);
            if((user=userService.findUserByNickname(nickname))!=null)
            {
                request.setAttribute("findUser",user);
                getServletContext().setAttribute("find_user",user);
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/adminPage.jsp");
                rd.forward(request,response);
            }else {
                PrintWriter pw=response.getWriter();
                pw.print("<p>User does not exist!</p>");
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/adminPage.jsp");
                rd.include(request,response);
                }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession(false).getAttribute("User");
        List<Roles> roles = user.getRolesList();
        String url;
        request.setAttribute("userRoles",roles);
        if(roles.contains(Roles.ADMIN))
        {
            url="/adminPage.jsp";
        }
        else{
            if(roles.contains(Roles.MODERATOR))
            {
                url="/moderatorPage.jsp";
            }
            else{
                url="/userPage.jsp" ;
            }
        }
        RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
        rd.forward(request,response);
    }

}
