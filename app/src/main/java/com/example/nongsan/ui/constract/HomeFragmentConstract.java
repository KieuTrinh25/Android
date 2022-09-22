package com.example.nongsan.ui.constract;

import com.example.nongsan.data.entity.Category;
import com.example.nongsan.data.entity.Product;

import java.util.List;

public interface HomeFragmentConstract {
    interface IView{
        void setCategoryListToView(List<Category> categoryList);
        void showCategory(Category category);
        void setProductListToView(List<Product> productList);
    }

    interface IPresenter{
        void setView(IView view);
        void getCategoryList();
        void getProductList();
        void getCategory(int categoryId);

    }
}
