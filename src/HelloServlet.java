import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        Map<String,String[]> map=new HashMap<>();
        map=request.getParameterMap();
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html><h1>Hello, "+name+"</h1></html>");
        printWriter.println("<html><h1>Map, "+request.getPathTranslated()+"</h1></html>");
        Cookie[] cookies = request.getCookies();
        HttpSession httpSession=request.getSession();
        Enumeration<String>enumeration=httpSession.getAttributeNames();
        while(enumeration.hasMoreElements())
        {
            String s=enumeration.nextElement();
            System.out.println(s+" value:"+httpSession.getAttribute(s));
        }
        httpSession.setAttribute("one","two");
    }
}
