package com.example.nongsan.ui.constract;

import com.example.nongsan.data.DatabaseDao;
import com.example.nongsan.data.model.Category;
import com.example.nongsan.data.model.Product;

import java.util.List;

public class CategoryPresenter implements CategoryConstract.IPresenter{
    CategoryConstract.IView mView;
    @Override
    public void setView(CategoryConstract.IView view) {
        mView = view;
    }

    @Override
    public void getProductList(int categoryId) {
        List<Product> productList = DatabaseDao.getInstance().getProductDao().getProductsByCategory(categoryId);

        mView.setProductListToView(productList);
    }

}
