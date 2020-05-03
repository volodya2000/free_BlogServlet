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

@WebServlet(name = "AllNewsServlet",urlPatterns = "/news")
public class AllNewsServlet extends HttpServlet {

    private PostService postService=new PostService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentPage=1;
        int numberOfPage;
        int pagesPerPage=9;
        List<Post> posts=postService.findPosts(currentPage,pagesPerPage);
        numberOfPage=postService.getAll().size()/pagesPerPage;
            if(request.getParameter("currentPage")!=null)
                {
                    currentPage=Integer.parseInt(request.getParameter("currentPage"));
                }

            if(postService.getAll().size()%pagesPerPage>0)
            {
                numberOfPage++;
            }
            request.setAttribute("currentPage",currentPage);
            request.setAttribute("numberOfPages",numberOfPage);
            request.setAttribute("news",posts);

            RequestDispatcher rd= getServletContext().getRequestDispatcher("/news.jsp");
            rd.forward(request,response);

    }
}
