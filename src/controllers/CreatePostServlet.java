package controllers;

import services.PostService;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "CreatePostServlet",urlPatterns ="/create")
public class CreatePostServlet extends HttpServlet {

    private PostService postService=new PostService();
    private static Logger logger =Logger.getLogger(CreatePostServlet.class.toString());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String content=request.getParameter("ckeditor");
        logger.info("content= "+content);
        postService.addPost("test",content);
        response.sendRedirect("/tinymce.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
