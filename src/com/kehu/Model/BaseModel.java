package com.kehu.Model;

import com.kehu.Utils.JDBCHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by huyiming on 15/11/17.
 */
public abstract class BaseModel{

    boolean isNew = false;

    protected String tableName;

    protected HashMap<String ,String> datas;

    public void save() throws SQLException {
        Iterator iter = datas.entrySet().iterator();
        String columns = "";
        String values = "";
        if(!datas.isEmpty()) {
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                columns += (String) entry.getKey();
                values += (String) entry.getValue();
                if(iter.hasNext()){
                    columns += ",";
                    values += ",";
                }
            }
        }
        String sql= "";
        if(isNew) {
            sql = "INSERT INTO question (" + columns + ") VALUES (" + values + ")";
            Connection connection = JDBCHelper.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }
        else {
            sql = "UPDATE "
        }

    }

    public String  get(String key){
        return datas.get(key);
    }

    public void set(String key, String value){
        datas.put(key, value);
    }

}
