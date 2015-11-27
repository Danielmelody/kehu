package com.kehu.Controler;

import com.kehu.Model.User;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by huyiming on 15/11/27.
 */
@WebServlet(urlPatterns = "/user/*")
public class UserInfo extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        Current.getCurrentUser(request, response, ctx);
        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.WARNING);
        Enumeration<String> stringEnumeration = request.getSession().getAttributeNames();
        while(stringEnumeration.hasMoreElements()){
            log.warning("=====" + stringEnumeration.nextElement());
        }

        return getTemplate("/self.html");
    }
}
