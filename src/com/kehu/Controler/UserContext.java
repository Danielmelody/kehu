package com.kehu.Controler;

import com.kehu.Model.Question;
import com.kehu.Model.User;
import org.apache.velocity.context.Context;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by huyiming on 15/11/27.
 */
public class UserContext {


    public static User getCurrentUser(HttpServletRequest request,
                               HttpServletResponse response, Context ctx) {
        Cookie cookies[] = request.getCookies();
        ctx.put("isLogin", false);
        if (cookies != null) {
            Logger log = Logger.getLogger("lavasoft");
            log.setLevel(Level.WARNING);
            for (int i = 0; i < cookies.length; ++i) {
                log.warning("cookies: " + cookies[i].getName());
                if (cookies[i].getName().equals("email")) {
                    ctx.put("email", cookies[i].getValue());
                    Vector<User> users = User.query("email", cookies[i].getValue(), 1);
                    if (users.size() > 0) {
                        request.setAttribute("user", users.get(0));
                        User user = users.get(0);
                        ctx.put("user", user);
                        ctx.put("isLogin", true);
                        return user;
                    }
                }
            }
        }
        return null;
    }

    public static void login(HttpServletRequest request,
                             HttpServletResponse response, Context ctx, User user){
        try {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(600);
            session.setAttribute("user", user);
            Cookie cookie = new Cookie("email", user.get("email"));
            cookie.setMaxAge(600);
            response.addCookie(cookie);
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logout(HttpServletRequest request,
                              HttpServletResponse response, Context ctx) {

        request.removeAttribute("user");
        Cookie cookie = request.getCookies()[0];
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        try {
            request.logout();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        ctx.put("isLogin", false);
    }


}

