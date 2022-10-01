package com.example.nongsan.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nongsan.R;
import com.example.nongsan.data.remote.entity.Category;
import com.example.nongsan.data.remote.entity.Product;
import com.example.nongsan.ui.adapter.CategoryAdapter;
import com.example.nongsan.ui.adapter.ProductAdapter;
import com.example.nongsan.ui.constract.HomeFragmentConstract;
import com.example.nongsan.ui.constract.HomeFragmentPresenter;

import java.util.List;

public class HomeFragment extends Fragment implements HomeFragmentConstract.IView {

    private HomeFragmentConstract.IPresenter mPresenter;
    private RecyclerView rc;
    private RecyclerView rcHotProducts;
    private ViewFlipper v_flipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initGUI(rootView);
        initData();

        return rootView;
    }
    private void initGUI(View rootView){
        rc = rootView.findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rcHotProducts = rootView.findViewById(R.id.rc_hot_products);

        int images [] = {R.drawable.banner_list12, R.drawable.banner1, R.drawable.banner2};
        v_flipper = rootView.findViewById(R.id.v_flipper);

        for (int image: images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView view = new ImageView(getContext());
        view.setBackgroundResource(image);

        v_flipper.addView(view);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }

    private void initData(){
        mPresenter = new HomeFragmentPresenter(getContext());
        mPresenter.setView(this);
        mPresenter.getCategoryList();
        mPresenter.getHotProducts();
    }

    @Override
    public void setCategoryListToView(List<Category> categoryList) {
        CategoryAdapter adapter = new CategoryAdapter(getContext(), categoryList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void showCategory(Category category) {

    }

    @Override
    public void setHotProductsToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(getContext(), productList);
        rcHotProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcHotProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



}
