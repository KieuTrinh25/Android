package com.example.nongsan.data;

import com.example.nongsan.data.dao.CategoryDao;

public abstract class DatabaseDao {
    private static DatabaseDao instance;
    public static void init(DatabaseDao inst){
        instance = inst;
    }
    public static DatabaseDao getInstance(){
        return instance;
    }
    public abstract CategoryDao getCategoryDao();

}
