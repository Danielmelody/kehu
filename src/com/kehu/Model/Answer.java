package com.kehu.Model;

import com.jfinal.plugin.activerecord.Model;
import com.kehu.Utils.JDBCHelper;

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
public class Answer extends BaseModel{
    public static Vector<Answer> queryByQuestion(String questionId, int limit){
        try {

            Connection connection = JDBCHelper.getConnection();
            String sql = "SELECT * FROM answer WHERE questionId = " + questionId + " ORDER BY updateTime DESC  LIMIT " + limit;
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);

            Vector<Answer> answers= new Vector<>();

            while(results.next()) {
                HashMap<String, String> datas = new HashMap<>();
                transform(results, datas);
                answers.addElement(new Answer(datas, false));
            }

            return answers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Answer(HashMap<String, String> datas, boolean isNew){
        this.tableName = "answer";
        init(datas, isNew);
    }

    private static void transform(ResultSet results, Map<String, String> datas) {
        try {
            datas.put("id", Integer.toString(results.getInt("id")));
            datas.put("questionId", results.getString("questionId"));
            datas.put("contant", results.getString("contant"));
            datas.put("agree", Integer.toString(results.getInt("agree")));
            datas.put("userName", results.getString("userName"));
            Logger log = Logger.getLogger("lavasoft");
            log.setLevel(Level.WARNING);
            log.warning("userName:" + results.getString("userName"));
            datas.put("updateTime", results.getString("updateTime"));
            datas.put("disagree", Integer.toString(results.getInt("disagree")));

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


    @Override
    protected void update() {
        try {
            Connection connection = JDBCHelper.getConnection();
            String sql = "SELECT * FROM answer  WHERE questionId = LAST_INSERT_ID()";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            results.first();
            transform(results, datas);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
