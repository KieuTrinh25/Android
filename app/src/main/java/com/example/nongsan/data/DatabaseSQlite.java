package com.example.nongsan.data;

import android.content.Context;

import com.example.nongsan.data.dao.CategoryDao;
import com.example.nongsan.data.dao.ProductDao;
import com.example.nongsan.data.implement.CategoryDaoImplement;
import com.example.nongsan.data.implement.ProductDaoImplement;

public class DatabaseSQlite extends DatabaseDao{
    private Context context;

    public DatabaseSQlite(Context context){
        this.context = context;
    }
    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImplement(context);
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImplement(context);
    }


}
