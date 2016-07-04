package com.kehu.Controler;

import com.kehu.Model.Answer;
import com.kehu.Model.Question;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by huyiming on 15/11/20.
 */

@WebServlet(name = "questionDetail", urlPatterns = "/q/*")
public class QueDetail extends VelocityViewServlet {
    @Override
    protected void setContentType(HttpServletRequest request,
                                  HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {



        String qID = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
        qID = qID.substring(1);
        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.WARNING);
        log.warning("qID:" + qID);
        Question question = null;

        ctx.put("user", UserContext.getCurrentUser(request, response, ctx));

        if(qID.equals("new")) {

            try {
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HashMap<String, String> datas = new HashMap<>();

            if (request.getParameter("title") != null && null != UserContext.getCurrentUser(request, response, ctx)) {
                datas.put("title", request.getParameter("title"));

                if (request.getParameter("contant") != null) {
                    datas.put("contant", request.getParameter("contant"));
                }


                datas.put("userId", UserContext.getCurrentUser(request, response, ctx).get("id"));
                question = new Question(datas, true);
                ctx.put("question", question);
                question.save();
            }
        }else {

            question = Question.query("id", qID, 1).get(0);

            ctx.put("question",question);
        }

        if(request.getParameter("answer") != null){
            HashMap<String, String> datas = new HashMap<>();
            datas.put("questionId", qID);
            datas.put("userId", UserContext.getCurrentUser(request, response, ctx).get("id"));
            datas.put("userName", UserContext.getCurrentUser(request, response, ctx).get("name"));
            datas.put("contant", request.getParameter("answer"));
            datas.put("questionTitle", question.get("title"));
            new Answer(datas, true).save();
        }

        Vector<Answer> answers = Answer.query("questionId", qID, 100);
        ctx.put("answers", answers);

        return getTemplate("detail.html");
    }
}
