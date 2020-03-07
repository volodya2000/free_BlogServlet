package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "AuthenticationFilter",urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    private static Logger logger =Logger.getLogger(AuthenticationFilter.class.toString());


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();
        logger.info("Requested Resource::"+uri);

        //HttpSession httpSession=request.getSession(false);
        if((request.getSession(true).getAttribute("User")==null) && !(uri.equals("/login.jsp")
                ||uri.equals("/login") || uri.contains("/css/")||uri.equals("/registration.jsp")) )
        {
            logger.info("Unauthorized request");
//            RequestDispatcher dispatcher =request.getRequestDispatcher("login.jsp");
//            dispatcher.forward(request, response);
            response.sendRedirect("login.jsp");
        }
        else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        logger.info("AuthenticationLogger initialized!");
    }

}