package controllers;

import entities.Post;
import services.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "LastNewsServlet",urlPatterns = "/home")
public class LastNewsServlet extends HttpServlet {

    private static Logger logger=Logger.getLogger(LastNewsServlet.class.toString());
    private PostService postService=new PostService();

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Post> latestNews=postService.getLatestNews();

        request.setAttribute("latestNews",latestNews.get(0));
        latestNews.remove(0);
        request.setAttribute("latestNewsList",latestNews);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/lastNews.jsp");
        rd.forward(request,response);
    }
}
