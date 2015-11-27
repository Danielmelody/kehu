package com.kehu.Controler;

import com.kehu.Model.User;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by huyiming on 15/11/27.
 */
@WebServlet(urlPatterns = "/login")
public class Login extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email != null) {
            Vector<User> user = User.query("email",email, 1);
            Logger log = Logger.getLogger("lavasoft");
            log.setLevel(Level.WARNING);
            log.warning("---------" +email);
            if (user.size() > 0) {
                try {
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(600);
                    session.setAttribute("user", user);
                    Cookie cookie = new Cookie("email", email);
                    cookie.setMaxAge(600);
                    response.addCookie(cookie);
                    response.sendRedirect("/");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return getTemplate("/login.html");
    }
}
