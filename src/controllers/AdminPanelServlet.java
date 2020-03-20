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
import java.util.logging.Logger;

@WebServlet(name = "adminPanel",urlPatterns = {"/profile/moderate","/profile/logout"})
public class AdminPanelServlet extends HttpServlet {

    private UserService userService=new UserService();
    private static Logger logger=Logger.getLogger(AdminPanelServlet.class.toString());



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getRequestURI().equals("/profile/logout")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/logout");
            rd.include(request, response);
        }

        User user = (User) getServletContext().getAttribute("find_user");
        String makeAdmin, makeModerator, deleteUser;
        logger.info("user " + user);
        makeAdmin = request.getParameter("makeAdmin");
        makeModerator = request.getParameter("makeModerator");
        deleteUser = request.getParameter("deleteUser");
        if ((makeAdmin != null && deleteUser != null)
                || (makeModerator != null && deleteUser != null) || (makeAdmin == null && deleteUser == null && makeModerator == null))
        {
            Cookie failedOperation = new Cookie("failed_operation", "Error!");
            response.addCookie(failedOperation);
            request.setAttribute("fail", "Error!");
            response.sendRedirect("/profile");
        }
        if (deleteUser != null && makeAdmin==null && makeModerator==null) {
                userService.deleteUser(user.getId());
                request.setAttribute("success_delete", "User " + user.getNickname() + " was deleted successfully!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirm_moderate.jsp");
            rd.forward(request, response);
        }
        if (makeModerator != null && deleteUser==null && makeAdmin==null) {
                if (!user.getRolesList().contains(Roles.MODERATOR)) {
                    userService.addRole(user.getId(), Roles.MODERATOR);
                    request.setAttribute("success_moder", "User with nickname " + user.getNickname() +
                            " was given a moderator status");
                }
             else {
                request.setAttribute("failed_moder", user.getNickname() + " has already been a moderator");
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirm_moderate.jsp");
            rd.forward(request, response);
        }
        if (makeAdmin != null && deleteUser==null && makeModerator==null) {
            {
                if (!user.getRolesList().contains(Roles.ADMIN)) {
                    userService.addRole(user.getId(), Roles.ADMIN);
                    request.setAttribute("success_admin", "User with nickname " + user.getNickname() +
                            " was given an admin status");
                } else {
                    request.setAttribute("failed_admin", user.getNickname() + " has already been an admin");
                }
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirm_moderate.jsp");
            rd.forward(request, response);
        }
        if (makeModerator != null && deleteUser==null && makeAdmin!=null) {
            if (!(user.getRolesList().contains(Roles.MODERATOR) && user.getRolesList().contains(Roles.ADMIN))) {
                userService.addRole(user.getId(), Roles.MODERATOR);
                userService.addRole(user.getId(),Roles.ADMIN);
                request.setAttribute("success_moder_admin", "User with nickname " + user.getNickname() +
                        " was given an admin status and a moderator status");
            }
            else {
                request.setAttribute("failed_moder_admin", user.getNickname() + " has already been an admin and " +
                        "a moderator");
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirm_moderate.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/profile");
    }
}
