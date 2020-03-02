//package controller;
//
//import entity.User;
//import service.UserService;
//import sun.rmi.server.UnicastServerRef2;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.logging.Logger;
//
//@WebServlet(name = "Login",urlPatterns = "/login")
//public class LoginServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    private UserService userService;
//
//    static Logger logger = Logger.getLogger(LoginServlet.class.toString());
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String errorMsg = null;
//        if(email == null || email.equals("")){
//            errorMsg ="User Email can't be null or empty";
//        }
//        if(password == null || password.equals("")){
//            errorMsg = "Password can't be null or empty";
//        }
//
//        if(errorMsg != null){
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
//            PrintWriter out= response.getWriter();
//            out.println("<font color=red>"+errorMsg+"</font>");
//            rd.include(request, response);
//        }else{
//
//            if(userService.findUserByI) {
//            }
//
//                    session.setAttribute("User", user);
//                    response.sendRedirect("home.jsp");;
//                }else{
//                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//                    PrintWriter out= response.getWriter();
//                    logger.error("User not found with email="+email);
//                    out.println("<font color=red>No user found with given email id, please register first.</font>");
//                    rd.include(request, response);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                logger.error("Database connection problem");
//                throw new ServletException("DB Connection problem.");
//            }finally{
//                try {
//                    rs.close();
//                    ps.close();
//                } catch (SQLException e) {
//                    logger.error("SQLException in closing PreparedStatement or ResultSet");;
//                }
//
//            }
//        }
//
//    }
//}
//
//
//
//
//
//
//
//
//
//



