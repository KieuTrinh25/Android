package com.example.nongsan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nongsan.data.model.Product;
import com.example.nongsan.ui.adapter.ProductAdapter;
import com.example.nongsan.ui.constract.ProductConstract;
import com.example.nongsan.ui.constract.ProductPresenter;

import java.util.List;

public class ProductActivity extends AppCompatActivity implements ProductConstract.IView {
    private ProductConstract.IPresenter mPresenter;
    private  RecyclerView rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
//        Product product = new Product("Cà rốt",20,20000,R.drawable.raucu,1);
////
//        mPresenter = new ProductPresenter(this);
//        mPresenter.insertProduct(product);

        initGUI();
        initData();
    }

    private void initGUI(){
        rc.findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initData(){
        mPresenter = new ProductPresenter(this);
        mPresenter.setView(this);
        mPresenter.getProductList();
    }
    @Override
    public void setProductListToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void setHotProductsToView(List<Product> productList) {

    }

    @Override
    public void setNewProductsToView(List<Product> productList) {

    }

    @Override
    public void showProduct(Product product) {

    }
}