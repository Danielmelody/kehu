package com.kehu.Model;

import com.jfinal.plugin.activerecord.Model;
import com.kehu.Utils.JDBCHelper;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by huyiming on 15/11/17.
 */
public class Answer extends BaseModel{


    @Override
    public void updateDataFromDataBase() {
        try {
            Connection connection = JDBCHelper.getConnection();
            String sql = "SELECT * FROM answer ORDER BY updateTime ";




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
