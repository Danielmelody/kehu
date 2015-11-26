package com.kehu.Model;

import com.kehu.Utils.JDBCHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by huyiming on 15/11/17.
 */
public abstract class BaseModel{

    boolean isNew = false;

    protected String tableName;

    protected Map<String ,String> datas;

    public void save() {
        Iterator iter = datas.entrySet().iterator();
        String sql= "";
        if(isNew) {
            String columns = "";
            String values = "";
            if(!datas.isEmpty()) {

                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    columns += entry.getKey();
                    values += "'"+entry.getValue()+"'";
                    if(iter.hasNext()){
                        columns += ",";
                        values += ",";
                    }
                }
            }
            sql = "INSERT INTO question (" + columns + ") VALUES (" + values + ")";
        }
        else {
            sql = "UPDATE question SET ";
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                sql += entry.getKey();
                sql += " = " + entry.getValue();
                if(iter.hasNext()){
                    sql += ",";
                }
            }
        }
        try {
            Connection connection = JDBCHelper.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            iter = datas.entrySet().iterator();
            Logger log = Logger.getLogger("lavasoft");
            log.setLevel(Level.WARNING);
            log.warning(sql);
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                log.warning("{" + (String) entry.getKey() + " : " + (String) entry.getValue() + "}");
            }
            e.printStackTrace();
        }
    }

    public String  get(String key){
        return datas.get(key);
    }

    public void set(String key, String value){
        datas.put(key, value);
    }

}
