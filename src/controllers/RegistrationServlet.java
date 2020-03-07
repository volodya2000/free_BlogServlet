package controllers;

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
        String nickname =request.getParameter("nickname");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        boolean isAlreadyExist=true;

        String errorMsg = null;
        User user=null;

        if(nickname==null||nickname.equals(""))
        {
         errorMsg="Nickname can`t be null or empty!";
        }
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

        }else
            user=new User(email,true,nickname,password);
//            if()
//            {
//
//            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
