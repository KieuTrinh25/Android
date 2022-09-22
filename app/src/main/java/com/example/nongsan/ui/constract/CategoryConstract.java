package com.example.nongsan.ui.constract;

import com.example.nongsan.data.model.Product;

import java.util.List;

public interface CategoryConstract {
    interface IView{
        void setProductListToView(List<Product> productList);
    }

    interface IPresenter{
        void setView(CategoryConstract.IView view);
        void getProductList(int categoryId);
    }
}
