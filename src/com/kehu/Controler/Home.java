package com.kehu.Controler;

import com.kehu.Model.Question;
import org.apache.velocity.Template;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import java.util.HashMap;
import java.util.Map;
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

        Vector questions = Question.query(20);

        ctx.put("questionList", Question.query(20));
        return getTemplate("index.html");
    }
}

