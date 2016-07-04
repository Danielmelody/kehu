package com.kehu.Model;

import com.kehu.Utils.JDBCHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.Vector;

/**
 * Created by huyiming on 15/11/17.
 */
public class User extends BaseModel {

    public static Vector<User> query(String colunm, String value, int limit) {

        try {
            String sql = "SELECT * FROM user WHERE " + colunm + " = '" + value + "'" + " LIMIT " + limit;
            Connection connection = JDBCHelper.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);

            Vector<User> questions = new Vector<>();

            while (results.next()) {
                HashMap<String, String> datas = new HashMap<>();
                transform(results, datas);
                questions.addElement(new User(datas, false));
            }

            return questions;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void transform(ResultSet results, Map<String, String> datas) {
        try {
            datas.put("id", Integer.toString(results.getInt("id")));
            datas.put("email", results.getString("email"));
            datas.put("password", results.getString("password"));
            datas.put("name", results.getString("name"));
            datas.put("agree", results.getString("agree"));
            datas.put("disagree", results.getString("disagree"));
            datas.put("askNum", results.getString("askNum"));
            datas.put("ansNum", results.getString("ansNum"));
            datas.put("attentionTo", results.getString("attentionTo"));
            datas.put("attentionFrom", results.getString("attentionFrom"));

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public User(HashMap<String, String> datas, boolean isNew) {
        this.tableName = "user";
        init(datas, isNew);
    }

    @Override
    public void update() {
        try {
            String sql = "SELECT * FROM user WHERE id = " + get("id");
            Connection connection = JDBCHelper.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            transform(results, datas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


