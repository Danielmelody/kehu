package com.kehu.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huyiming on 15/11/17.
 */
public abstract class BaseModel{

    boolean isNew = false;

    protected String tableName;

    protected HashMap<String ,String> datas;

    public abstract void updateDataFromDataBase();

    public void save(){

    }

    public String  get(String key){
        return datas.get(key);
    }

    public void set(String key, String value){
        datas.put(key, value);
    }

}
