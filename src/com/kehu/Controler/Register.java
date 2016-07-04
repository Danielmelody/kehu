package com.kehu.Controler;

import com.kehu.Model.User;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by huyiming on 15/11/27.
 */

@WebServlet(urlPatterns = "/register")
public class Register extends VelocityViewServlet{
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        if(request.getParameter("email")!=null){
            HashMap<String, String> datas = new HashMap<>();
            datas.put("email", request.getParameter("email"));
            datas.put("name", request.getParameter("name"));
            datas.put("password", request.getParameter("password"));
            User user = new User(datas, true);
            user.save();
            UserContext.login(request, response, ctx, user);
        }
        return getTemplate("/rigist.html");
    }
}
