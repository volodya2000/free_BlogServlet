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

@WebServlet(name = "HomeServlet",urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private PostService postService=new PostService();

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int currentPage = 1;
        int recordsPerPage =4;
        if(request.getParameter("id")!=null)
        {
            int currentPostId=Integer.parseInt(request.getParameter("id"));
            request.setAttribute("content",postService.getPostById(currentPostId).getInformation());
            request.setAttribute("title",postService.getPostById(currentPostId).getNameOfPost());
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/post.jsp");
            rd.forward(request,response);
        }else {
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }
            List<Post> currentPosts = postService.findPosts(currentPage, recordsPerPage);

            request.setAttribute("currentPosts", currentPosts);

            int rows = postService.getAll().size();

            int nOfPages = rows / recordsPerPage;

            if (nOfPages % recordsPerPage > 0) {
                nOfPages++;
            }

            request.setAttribute("noOfPages", nOfPages);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("recordsPerPage", recordsPerPage);


            RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
            dispatcher.forward(request, response);
        }
    }
}
