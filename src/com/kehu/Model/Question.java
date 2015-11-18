package com.kehu.Model;

import com.jfinal.plugin.activerecord.Model;
import com.kehu.Utils.JDBCHelper;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by huyiming on 15/11/17.
 */
public class Question extends BaseModel{

    public static Vector<Question> query(int limit){

        try {

            Connection connection = JDBCHelper.getConnection();
            String sql = "SELECT * FROM question ORDER BY updateTime LIMIT "+limit;
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);

            Vector<Question> questions = new Vector<>();

            while(results.next()) {
                HashMap<String, String> datas = new HashMap<>();
                datas.put("id", Integer.toString(results.getInt("id")));
                datas.put("userId", results.getString("userId"));
                datas.put("title", results.getString("title"));
                datas.put("contant", results.getString("contant"));

                questions.addElement(new Question(datas, false));
            }

            return questions;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Question(HashMap<String, String> datas, boolean isNew){
        this.datas = datas;
        this.isNew = isNew;
    }





    @Override
    public void updateDataFromDataBase() {


    }
}
