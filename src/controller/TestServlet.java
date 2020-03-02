package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname=request.getParameter("username");
        String pword=request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(uname.equals("volodymyr")&&pword.equals("admin")) {
            ServletContext servletContext=request.getServletContext();
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/loginWithError.html");
            rd.include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
