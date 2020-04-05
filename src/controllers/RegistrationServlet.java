package controllers;

import entities.Roles;
import entities.User;
import filters.SHA1;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "RegistrationServlet",urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(RegistrationServlet.class.toString());
    private UserService userService;

    public void init() {
        userService=new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        synchronized (this) {
            String nickname = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            String errorMsg = null;
            User user = null;

            if (nickname == null || nickname.equals("")) {
                errorMsg = "Nickname can`t be null or empty!";
            }
            if (email == null || email.equals("")) {
                errorMsg = "User Email can't be null or empty";
            }
            if (password == null || password.equals("")) {
                errorMsg = "Password can't be null or empty";
            }

            if (errorMsg != null) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>" + errorMsg + "</font>");
                rd.include(request, response);

            } else if (!userService.isExist(email, nickname)) {
                SHA1 sha1 = new SHA1();
                user = new User(email, true, nickname, sha1.hash(password));
                user.setRolesList(userService.getUserRoles(user));
                userService.addUser(user);
                logger.warning("USERID= " + user.getId());
                userService.addRole(user.getId(), Roles.USER);
                HttpSession session = request.getSession();
                session.setAttribute("User", user);
                session.setMaxInactiveInterval(30 * 60);

                Cookie loginCookie = new Cookie("user_cookie", user.getNickname());
                loginCookie.setMaxAge(10 * 60);
                response.addCookie(loginCookie);
                response.sendRedirect("/home");
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
                PrintWriter printWriter = response.getWriter();
                printWriter.println("<font color=red> User found with given email " + email + " is exist </font>");
                requestDispatcher.include(request, response);

            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/registration.jsp");
        rd.forward(request,response);
    }
}
