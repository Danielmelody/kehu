package com.kehu.Model;

import com.jfinal.plugin.activerecord.Model;
import com.kehu.Utils.JDBCHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by huyiming on 15/11/17.
 */
public class Answer extends BaseModel{
    public static Vector<Answer> queryByQuestion(int questionId){
        try {

            Connection connection = JDBCHelper.getConnection();
            String sql = "SELECT * FROM answer  WHERE questionId = " + questionId;
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);

            Vector<Answer> answers= new Vector<>();

            while(results.next()) {
                HashMap<String, String> datas = new HashMap<>();
                datas.put("id", Integer.toString(results.getInt("id")));
                datas.put("userId", results.getString("userId"));
                datas.put("title", results.getString("title"));
                datas.put("contant", results.getString("contant"));

                answers.addElement(new Answer(datas, false));
            }

            return answers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Answer(HashMap<String, String> datas, boolean isNew){
        this.datas = datas;
        this.isNew = isNew;
    }

}
