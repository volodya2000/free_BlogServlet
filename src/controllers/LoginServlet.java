package controllers;

import dal.UserImplDAO;
import entities.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService userService=new UserService();

    private static Logger logger=Logger.getLogger(LoginServlet.class.toString());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String errorMsg = null;
        User user=null;

        if (email == null || email.equals("")) {
            errorMsg = "User Email can't be null or empty";
        }
        if (password == null || password.equals("")) {
            errorMsg = "Password can't be null or empty";
        }

        if (errorMsg != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>" + errorMsg + "</font>");
            rd.include(request, response);

        }
        else
        {
            if((user=userService.findByEmailAndPassword(email,password))!=null)
            {
                logger.info("User found with details="+user);
                HttpSession session = request.getSession();
                session.setAttribute("User", user);
                session.setMaxInactiveInterval(30*60);

                Cookie loginCookie = new Cookie("user_cookie",user.getNickname());
                loginCookie.setMaxAge(30*60);
                response.addCookie(loginCookie);
                response.sendRedirect("home.jsp");
            }else
            {
                RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/login.jsp");
                PrintWriter out= response.getWriter();
                logger.warning("User not found with email="+email);
                out.println("<font color=red>No user found with given email id, please register first.</font>");
                requestDispatcher.include(request, response);
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
