package com.kehu.Controler;

import com.kehu.Model.User;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            Vector<User> users = User.query("email",email, 1);
            Logger log = Logger.getLogger("lavasoft");
            log.setLevel(Level.WARNING);
            log.warning("---------" +email);
            if (users != null && users.size() > 0) {
                if(users.get(0).get("password").equals(password)) {
                    UserContext.login(request, response, ctx, users.get(0));
                }
            }
        }
        return getTemplate("/login.html");
    }
}
