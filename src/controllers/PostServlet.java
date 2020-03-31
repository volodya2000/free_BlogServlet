package controllers;

import services.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostServlet",urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    private static PostService postService=new PostService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        if(id!=null)
        {

            String content=postService.getPostById(Integer.parseInt(id)).getInformation();
            request.setAttribute("content",content);
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/postNews.jsp");
            rd.forward(request,response);
        }
    }
}
