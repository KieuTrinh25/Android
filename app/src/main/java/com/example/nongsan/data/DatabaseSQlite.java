package com.example.nongsan.data;

import android.content.Context;

import com.example.nongsan.data.dao.CategoryDao;
import com.example.nongsan.data.implement.CategoryDaoImplement;

public class DatabaseSQlite extends DatabaseDao{
    private Context context;

    public DatabaseSQlite(Context context){
        this.context = context;
    }
    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImplement(context);
    }



}
