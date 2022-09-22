package com.example.nongsan.ui.constract;

import com.example.nongsan.data.model.Category;
import com.example.nongsan.data.model.Product;

import java.util.List;

public interface HomeFragmentConstract {
    interface IView{
        void setCategoryListToView(List<Category> categoryList);
        void showCategory(Category category);

        void setProductListToView(List<Product> productList);
        void showProduct(Product product);
    }

    interface IPresenter{
        void setView(IView view);
        void getCategoryList();
        void getProductList();
        void getCategory(int categoryId);
        void insertCategory(Category category);
    }
}
