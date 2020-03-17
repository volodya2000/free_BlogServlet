package controllers;

import entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(LogoutServlet.class.toString());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Cookie []cookies= request.getCookies();
        if(cookies!=null)
        {
            for(Cookie cookie:cookies)
            {
                if(cookie.getName().equals("JSESSIONID"))
                {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if(cookie.getName().equals("user_cookie"))
                {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
            }
                if(cookie.getName().equals("findUser"))
                {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
        }
        }
        HttpSession session = request.getSession(false);
        logger.info("User="+session.getAttribute("User"));
        if(session!=null)
        {session.invalidate();}

        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
