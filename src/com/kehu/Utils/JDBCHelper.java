package com.kehu.Utils;

/**
 * Created by huyiming on 15/11/17.
 */
import com.mysql.jdbc.Driver;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCHelper {


    public static Connection getConnection() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://127.0.0.1/kehu?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String psw = "";
        Connection con = DriverManager.getConnection(url, user, psw);
        return con;
    }


    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{

                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{

                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try{

                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
