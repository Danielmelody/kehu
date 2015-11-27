package com.kehu.Model;

import com.jfinal.plugin.activerecord.Model;
import com.kehu.Utils.JDBCHelper;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by huyiming on 15/11/17.
 */
public class Question extends BaseModel {

    public static Vector<Question> query(String id) {

        try {

            Connection connection = JDBCHelper.getConnection();
            String sql = "SELECT * FROM question WHERE id = " + id;
            Statement statement = connection.createStatement();
            Vector<Question> questions = new Vector<>();
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                HashMap<String, String> datas = new HashMap<>();
                transform(results, datas);
                questions.addElement(new Question(datas, false));
            }

            return questions;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static Vector<Question> query(int limit){
        String sql = "SELECT * FROM question ORDER BY updateTime DESC LIMIT " + limit;
        try {
            Connection connection = JDBCHelper.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);

            Vector<Question> questions = new Vector<>();

            while (results.next()) {
                HashMap<String, String> datas = new HashMap<>();
                transform(results, datas);
                questions.addElement(new Question(datas, false));
            }

            return questions;

        } catch (SQLException e) {
            Logger log = Logger.getLogger("lavasoft");
            log.setLevel(Level.WARNING);
            log.warning(sql);
            e.printStackTrace();
        }
        return null;
    }

    public Question(HashMap<String, String> datas, boolean isNew) {
        this.tableName = "question";
        init(datas, isNew);
    }


    private static void transform(ResultSet results, Map<String, String> datas) {
        try {
            datas.put("id", Integer.toString(results.getInt("id")));
            datas.put("userId", results.getString("userId"));
            datas.put("title", results.getString("title"));
            datas.put("contant", results.getString("contant"));
            datas.put("answerCount", results.getString("answerCount"));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    protected void update() {
        Connection connection = null;
        String sql = "SELECT * FROM question WHERE id = LAST_INSERT_ID()";
        try {
            connection = JDBCHelper.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            results.first();
            if(results.getRow() > 0) {
                transform(results, this.datas);
            }

        } catch (SQLException e1) {
            Logger log = Logger.getLogger("lavasoft");
            log.setLevel(Level.WARNING);
            log.warning(sql);
            e1.printStackTrace();
        }

    }
}
