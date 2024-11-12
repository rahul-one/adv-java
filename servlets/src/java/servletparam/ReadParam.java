package servletparam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadParam extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String uname = request.getParameter("uname");
        String passwd = request.getParameter("passwd");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReadParam</title>");            
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Servlet ReadParam at " + request.getContextPath() + "</h1>");
            out.println("<h1>Username :" + uname  + "</h1>");
            out.println("<h1>Password :" + passwd + "</h1>");
            out.println("<h1>Request URI :" + request.getRequestURI() + "</h1>");
            out.println("<h1>Servlet Path :" + request.getServletPath() + "</h1>");

            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
