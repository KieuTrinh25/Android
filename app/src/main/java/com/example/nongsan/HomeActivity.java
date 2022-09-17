package com.example.nongsan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nongsan.data.model.Category;
import com.example.nongsan.ui.adapter.CategoryAdapter;
import com.example.nongsan.ui.constract.HomeConstract;
import com.example.nongsan.ui.constract.HomePresenter;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeConstract.IView {
    private HomeConstract.IPresenter mPresenter;
    private  RecyclerView rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initGUI();
        initData();
    }
    private void initGUI(){
        rc = findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initData(){
        mPresenter = new HomePresenter(this);
        mPresenter.setView(this);
        mPresenter.getCategoryList();
    }

    @Override
    public void setCategoryListToView(List<Category> categoryList) {
        CategoryAdapter adapter = new CategoryAdapter(categoryList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void showCategory(Category category) {

    }
}