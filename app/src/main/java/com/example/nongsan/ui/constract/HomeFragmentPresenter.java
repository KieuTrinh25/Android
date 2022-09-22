package com.example.nongsan.ui.constract;

import android.content.Context;

import com.example.nongsan.data.DatabaseDao;
import com.example.nongsan.data.DatabaseSQlite;
import com.example.nongsan.data.entity.Category;
import com.example.nongsan.data.entity.Product;
import com.example.nongsan.data.remote.RetrofitContrller;
import com.example.nongsan.data.remote.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        WebService service = RetrofitContrller.service();
        service.categoryList().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                mView.setCategoryListToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getProductList() {
        WebService service = RetrofitContrller.service();
        service.productList().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setProductListToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getCategory(int categoryId) {
        WebService service = RetrofitContrller.service();
        service.category(categoryId).enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {

            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {

            }
        });
    }

}
