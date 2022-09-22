package com.example.nongsan.ui.constract;

import android.content.Context;

import com.example.nongsan.data.DatabaseDao;
import com.example.nongsan.data.DatabaseSQlite;
import com.example.nongsan.data.dao.ProductDao;
import com.example.nongsan.data.model.Product;

import java.util.List;

public class ProductPresenter implements ProductConstract.IPresenter {
    private ProductConstract.IView mView;
    public ProductPresenter(Context context){
        DatabaseDao.init((new DatabaseSQlite(context)));
    }

    @Override
    public void setView(ProductConstract.IView view) {
        mView = view;
    }

    @Override
    public void getProductList() {
        List<Product> productList = DatabaseDao.getInstance().getProductDao().all();
        mView.setProductListToView(productList);
    }

    @Override
    public void getProduct(int productId) {
        Product product = DatabaseDao.getInstance().getProductDao().find(productId);
        mView.showProduct(product);
    }

    @Override
    public void getHotProducts() {

    }

    @Override
    public void getNewProducts() {

    }

    @Override
    public void insertProduct(Product product) {
        DatabaseDao.getInstance().getProductDao().insert(product);
    }
}
