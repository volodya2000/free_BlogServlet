package controllers;

import entities.Post;
import services.PostService;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "CreatePostServlet",urlPatterns ="/create")
public class CreatePostServlet extends HttpServlet {

    private PostService postService=new PostService();
    private static Logger logger =Logger.getLogger(CreatePostServlet.class.toString());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String EMPTY_POST="Dear moderator. Empty post is very bed :)";
        String content=request.getParameter("ckeditor");
        String imageSource=request.getParameter("imageSource");
        String description=request.getParameter("description");
        String postName=request.getParameter("postName");
        logger.info("content= "+content);
        if(content.equals("") || imageSource.equals("") || description.equals(""))
        {
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/createPost.jsp");
            PrintWriter printWriter=response.getWriter();
            printWriter.println("<font color=red>" + EMPTY_POST + "</font>");
            rd.include(request, response);
        }else
        {
            Post post=new Post();
            post.setNameOfPost(postName);
            post.setImageSource(imageSource);
            post.setDescription(description);
            post.setInformation(content);
            postService.addPost(post);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/createPost.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/createPost.jsp");
        rd.forward(request,response);
    }

}
