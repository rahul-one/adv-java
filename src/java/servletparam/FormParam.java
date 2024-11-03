/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servletparam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author commander
 */
public class FormParam extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String loginPage = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <title>Login Page</title>\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Arial, sans-serif;\n"
                + "            background-color: #f2f2f2;\n"
                + "        }\n"
                + "\n"
                + "        .container {\n"
                + "            max-width: 400px;\n"
                + "            margin: 0 auto;\n"
                + "            padding: 20px;\n"
                + "            background-color: #fff;\n"
                + "            border-radius: 5px;\n"
                + "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n"
                + "        }\n"
                + "\n"
                + "        h2 {\n"
                + "            text-align: center;\n"
                + "            margin-bottom: 20px;\n"
                + "        }\n"
                + "\n"
                + "        .form-group {\n"
                + "            margin-bottom: 20px;\n"
                + "        }\n"
                + "\n"
                + "        .form-group label {\n"
                + "            display: block;\n"
                + "            font-weight: bold;\n"
                + "            margin-bottom: 5px;\n"
                + "        }\n"
                + "\n"
                + "        .form-group input {\n"
                + "            width: 100%;\n"
                + "            padding: 10px;\n"
                + "            border: 1px solid #ccc;\n"
                + "            border-radius: 4px;\n"
                + "        }\n"
                + "\n"
                + "        .form-group button {\n"
                + "            width: 100%;\n"
                + "            padding: 10px;\n"
                + "            background-color: #4CAF50;\n"
                + "            color: #fff;\n"
                + "            border: none;\n"
                + "            border-radius: 4px;\n"
                + "            cursor: pointer;\n"
                + "        }\n"
                + "\n"
                + "        .form-group button:hover {\n"
                + "            background-color: #45a049;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <h2>Login</h2>\n"
                + "        <form action=\"read-param\" method=\"GET\">\n"
                + "            <div class=\"form-group\">\n"
                + "                <label for=\"username\">Username:</label>\n"
                + "                <input type=\"text\" id=\"username\" name=\"uname\" placeholder=\"Enter your username\">\n"
                + "            </div>\n"
                + "            <div class=\"form-group\">\n"
                + "                <label for=\"password\">Password:</label>\n"
                + "                <input type=\"password\" id=\"password\" name=\"passwd\" placeholder=\"Enter your password\">\n"
                + "            </div>\n"
                + "            <div class=\"form-group\">\n"
                + "                <button type=\"submit\">Login</button>\n"
                + "            </div>\n"
                + "        </form>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";

        try (PrintWriter out = response.getWriter()) {
            out.println(loginPage);

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
