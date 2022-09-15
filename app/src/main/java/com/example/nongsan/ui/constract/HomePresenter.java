package com.example.nongsan.ui.constract;

import android.content.Context;

import com.example.nongsan.data.DatabaseDao;
import com.example.nongsan.data.DatabaseSQlite;
import com.example.nongsan.data.model.Category;

import java.util.List;

public class HomePresenter implements  HomeConstract.IPresenter{
    private HomeConstract.IView mView;

    public HomePresenter(Context context){
        DatabaseDao.init((new DatabaseSQlite(context)));
    }
    @Override
    public void setView(HomeConstract.IView view) {
        mView = view;
    }

    @Override
    public void getCategoryList() {
        List<Category> categoryList = DatabaseDao.getInstance().getCategoryDao().all();
        mView.setCategoryListToView(categoryList);
    }

    @Override
    public void getCategory(int categoryId) {
        Category category = DatabaseDao.getInstance().getCategoryDao().find(categoryId);
        mView.showCategory(category);
    }
}
