package com.kehu;

import org.apache.velocity.Template;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import java.util.Vector;


/**
 * Created by huyiming on 15/11/14.
 */
@WebServlet(
        name = "Home",
        urlPatterns = "",
        initParams = {
                @WebInitParam(name="org.apache.velocity.properties", value = "/WEB-INF/velocity.properties")
        }

)
public class Home extends VelocityViewServlet {


    @Override
    protected void setContentType(HttpServletRequest request,
                                  HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    protected Template handleRequest(HttpServletRequest request,
                                     HttpServletResponse response, Context ctx) {
        Vector questionList = new Vector();
        questionList.addElement("问题一");
        questionList.addElement("问题二");
        questionList.addElement("问题三");
        questionList.addElement("问题四");
        questionList.addElement("问题五");
        ctx.put("questionList", questionList);
        return getTemplate("index.html");
    }
}

