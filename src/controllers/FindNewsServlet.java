package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Post;
import flexjson.JSONSerializer;
import services.PostService;

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

@WebServlet(name = "FindNewsServlet", urlPatterns = "/find")
public class FindNewsServlet extends HttpServlet {

    private PostService postService=new PostService();
    private Logger logger=Logger.getLogger(FindNewsServlet.class.toString());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String postName =request.getParameter("post");
        logger.info("name of post: "+postName);

        List<Post> findPosts = postService.getPostByName(postName);
        if(findPosts!=null) {
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("<ul style=\"width: 100%; height: 400px; overflow: auto\">");
        for (Post post:
             findPosts) {
            printWriter.write("<li style=\"justify-content: center; height:60px\">" +
                    "<a href=\"/post?id="+post.getId()+"\">" +
                    " <img src='"+post.getImageSource()+"'style=\"height: 50px ;width: 50px\" >"
            +post.getNameOfPost()+"</li>");
        }
            printWriter.write("</ul>");

            printWriter.flush();
            printWriter.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/findNews.jsp");
        requestDispatcher.forward(request,response);
    }
}
