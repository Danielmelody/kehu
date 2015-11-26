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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String, String[]> map = request.getParameterMap();
        if(!(map.get("title").length > 0)){
            HashMap<String, String> datas = new HashMap<>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry = (Map.Entry)iterator.next();
                datas.put((String)entry.getKey(), ((String[])entry.getValue())[0]);
            }
            Question question = new Question(datas, true);
            question.save();

            Vector<Answer> answers = Answer.queryByQuestion(question.get("id"));

            ctx.put("question", question);
            ctx.put("answers", answers);



        }

        return getTemplate("detail.html");
    }
}
