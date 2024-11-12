package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rahul-one
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String page = "<!DOCTYPE html>\n"
                    + "<html lang='en'>\n"
                    + "\n"
                    + "<head>\n"
                    + "    <meta charset='UTF-8'>\n"
                    + "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n"
                    + "    <title>Login</title>\n"
                    + "    <style>\n"
                    + "        .main { width: 50%; margin: 50px auto; }\n"
                    + "        .title{ margin:20px; }\n"
                    + "        .form-border { width: 50%; margin:10px; padding: 10px; }\n"
                    + "        .form-element{ margin:5px; padding: 5px; }\n"
                    + "        .ele-spacer{ width: 50%; display: inline; margin: 10px; padding: 10px; margin-right: auto; }\n"
                    + "        .button{ margin: 5px 30px; padding: 2px 2px; }\n"
                    + "    </style>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <div class='main'>\n"
                    + "        <h1 class='title'>Please Login</h1>\n"
                    + "        <div class='form-border'>\n"
                    + "            <form action='/adv-java/login-check' method='POST'>\n"
                    + "                <div class='form-element'>\n"
                    + "                   <div class='ele-spacer'><label for='user'>Username</label></div>\n"
                    + "                   <div class='ele-spacer'><input type='text' id='user' name='uname'></div>\n"
                    + "                </div>\n"
                    + "                <div class='form-element'>\n"
                    + "                    <div class='ele-spacer'><label for='pass'>Password</label></div>\n"
                    + "                    <div class='ele-spacer'><input type='password' id='pass' name='passwd'></div>\n"
                    + "                </div>\n"
                    + "                <div>\n"
                    + "                    <button class='button' type='submit'>Login</button>\n"
                    + "                </div>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            out.println(page);
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
