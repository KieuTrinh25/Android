package com.example.nongsan.data.remote;

import com.example.nongsan.data.entity.Category;
import com.example.nongsan.data.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("categories/")
    Call<List<Category>> categoryList();

    @GET("categories/show.php")
    Call<Category> category(@Query("id") int id);

    @GET("products/")
    Call<List<Product>> productList();

    @GET("products/show.php")
    Call<Product> product(@Query("id") int id);
}
