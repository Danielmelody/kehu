package com.kehu.Utils;

/**
 * Created by huyiming on 15/11/17.
 */

import com.kehu.Model.BaseModel;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.StreamingNotifiable;

import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;

public class JDBCHelper {


    public static Connection getConnection() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://127.0.0.1/kehu?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String psw = "";
        Connection con = DriverManager.getConnection(url, user, psw);
        return con;
    }

    /*public static <T> Vector<BaseModel> query(String querySql) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(querySql);
        Vector<BaseModel> models = new Vector<>();
        while(results.next()){
            HashMap<String, String> data = new HashMap<>();
            ResultSetMetaData metaData = results.getMetaData();
            for(int i = 0; i < metaData.getColumnCount() ; ++i){
                data.put(metaData.getColumnName(i), results.getString(i));
            }
            models.addElement(new T());

        }


    }*/


    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {

                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {

                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {

                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
