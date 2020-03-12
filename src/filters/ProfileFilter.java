//package filters;
//
//import entities.Roles;
//import entities.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.logging.Logger;
//
//@WebFilter(filterName = "ProfileFilter",urlPatterns = {"/profile/*","/admin/*","/create/*"})
//public class ProfileFilter implements Filter {
//
//    private static Logger logger=Logger.getLogger(ProfileFilter.class.toString());
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        User user=(User)request.getAttribute("User");
//        Roles roles=Roles.MODERATOR;
//        if(!(((User) request.getAttribute("User")).getRolesList().contains(roles)))
//        {
//            response.sendRedirect("/profile/userPage.jsp");
//        }
//        else
//        {
//            chain.doFilter(req, resp);
//
//        }
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//        logger.info("ProfileFilter is initialized");
//    }
//
//}
