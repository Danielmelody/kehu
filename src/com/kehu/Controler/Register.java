package com.kehu.Controler;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huyiming on 15/11/27.
 */

@WebServlet(urlPatterns = "/register")
public class Register extends VelocityViewServlet{
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        return getTemplate("/register.html");
    }
}
