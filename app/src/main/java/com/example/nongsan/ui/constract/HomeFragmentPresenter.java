package com.example.nongsan.ui.constract;

import android.content.Context;

import com.example.nongsan.data.DatabaseDao;
import com.example.nongsan.data.DatabaseSQlite;
import com.example.nongsan.data.model.Category;
import com.example.nongsan.data.model.Product;

import java.util.List;

public class HomeFragmentPresenter implements  HomeFragmentConstract.IPresenter{
    private HomeFragmentConstract.IView mView;

    public HomeFragmentPresenter(Context context){
        DatabaseDao.init((new DatabaseSQlite(context)));
    }
    @Override
    public void setView(HomeFragmentConstract.IView view) {
        mView = view;
    }

    @Override
    public void getCategoryList() {
        List<Category> categoryList = DatabaseDao.getInstance().getCategoryDao().all();

        mView.setCategoryListToView(categoryList);
    }

    @Override
    public void getProductList() {
        List<Product> productList = DatabaseDao.getInstance().getProductDao().all();

        mView.setProductListToView(productList);
    }

    @Override
    public void getCategory(int categoryId) {
        Category category = DatabaseDao.getInstance().getCategoryDao().find(categoryId);
        mView.showCategory(category);
    }

    @Override
    public void insertCategory(Category category) {
        DatabaseDao.getInstance().getCategoryDao().insert(category);
    }
}
