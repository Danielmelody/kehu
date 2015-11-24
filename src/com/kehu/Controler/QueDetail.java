package com.kehu.Controler;

import com.kehu.Model.Question;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 * Created by huyiming on 15/11/20.
 */

@WebServlet(name = "questionDetail", urlPatterns = "/q/*")
public class QueDetail extends VelocityViewServlet{
    @Override
    protected void setContentType(HttpServletRequest request,
                                  HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    protected Template handleRequest(HttpServletRequest request,
                                     HttpServletResponse response, Context ctx) {


        return getTemplate("detail.html");
    }
}
