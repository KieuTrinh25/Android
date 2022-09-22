package com.example.nongsan.ui.constract;

import com.example.nongsan.data.model.Category;
import com.example.nongsan.data.model.Product;

import java.util.List;

public interface ProductConstract {
    interface IView{
        void setProductListToView(List<Product> productList);
        void setHotProductsToView(List<Product> productList);
        void setNewProductsToView(List<Product> productList);
        void showProduct(Product product);
    }

    interface IPresenter{
        void setView(IView view);
        void getProductList();
        void getProduct(int productId);
        void getHotProducts();
        void getNewProducts();

        void insertProduct(Product product);
    }
}
