package controllers;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "CreatePostServlet",urlPatterns ="/create")
public class CreatePostServlet extends HttpServlet {
    private static Logger logger =Logger.getLogger(CreatePostServlet.class.toString());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String html= (String) request.getAttribute("content");
        logger.warning(html);
        response.sendRedirect("/tinymce.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
