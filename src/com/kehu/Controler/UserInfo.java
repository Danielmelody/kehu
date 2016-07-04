package com.kehu.Controler;

import com.kehu.Model.Answer;
import com.kehu.Model.Question;
import com.kehu.Model.User;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by huyiming on 15/11/27.
 */
@WebServlet(urlPatterns = "/user/*")
public class UserInfo extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {

        String userId = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
        userId = userId.substring(1);
        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.WARNING);
        log.warning(userId);
        User user = User.query("id", userId, 1).get(0);
        ctx.put("user", user);

        Vector<Answer> answers = Answer.query("userId", user.get("id"), 20);
        ctx.put("answers", answers);

        Vector<Question> questions = Question.query("userId", user.get("id"), 20);
        ctx.put("questionList", questions);

        Enumeration<String> stringEnumeration = request.getSession().getAttributeNames();
        while(stringEnumeration.hasMoreElements()){
            log.warning("=====" + stringEnumeration.nextElement());
        }

        return getTemplate("/self.html");
    }
}
