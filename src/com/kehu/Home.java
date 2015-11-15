package com.kehu;

import org.apache.velocity.Template;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;


/**
 * Created by huyiming on 15/11/14.
 */
@WebServlet(name = "Home", urlPatterns = "/")
public class Home extends VelocityViewServlet {


    @Override
    protected void setContentType(HttpServletRequest request,
                                  HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    protected Template handleRequest(HttpServletRequest request,
                                     HttpServletResponse response, Context ctx) {

        return getTemplate("index.html");
    }
}

