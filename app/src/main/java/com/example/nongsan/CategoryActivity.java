package com.example.nongsan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nongsan.data.model.Category;
import com.example.nongsan.data.model.Product;
import com.example.nongsan.ui.adapter.ProductAdapter;
import com.example.nongsan.ui.constract.CategoryConstract;
import com.example.nongsan.ui.constract.CategoryPresenter;
import com.example.nongsan.ui.fragment.HomeFragment;
import com.example.nongsan.utils.Constants;

import java.util.List;

public class CategoryActivity extends BaseActivity implements CategoryConstract.IView{
    CategoryConstract.IPresenter mPresenter;
    private RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initGUI();
        initData();
    }

    private void initGUI(){
        rc = findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData(){
        mPresenter = new CategoryPresenter();
        mPresenter.setView(this);

        int categoryId = getIntent().getIntExtra(Constants.CATEGORY_ID, 1);
        mPresenter.getProductList(categoryId);
    }

    @Override
    public void setProductListToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }
}