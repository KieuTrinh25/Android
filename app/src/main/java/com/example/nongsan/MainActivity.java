package com.example.nongsan;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.nongsan.ui.fragment.FavouriteFragment;
import com.example.nongsan.ui.fragment.HomeFragment;
import com.example.nongsan.ui.fragment.NotificationFragment;
import com.example.nongsan.ui.fragment.OrderFragment;
import com.example.nongsan.ui.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment = new HomeFragment();
//    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGUI();

//        int images [] = {R.drawable.banner_list12, R.drawable.banner1, R.drawable.banner2};
//        v_flipper = findViewById(R.id.v_flipper);
//
////        for (int i = 0; i < images.length; i++){
////            flipperImages(images[i]);
////        }
//
//        for (int image: images){
//            flipperImages(image);
//        }

    }
//    public void flipperImages(int image){
//        ImageView view = new ImageView(this);
//        view.setBackgroundResource(image);
//
//        v_flipper.addView(view);
//        v_flipper.setFlipInterval(3000);
//        v_flipper.setAutoStart(true);
//
//        //animation
//        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
//        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
//    }

    private void initGUI(){
        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                    return true;
                case R.id.order:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new OrderFragment()).commit();
                    return true;
                case R.id.favourite:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new FavouriteFragment()).commit();
                    return true;
                case R.id.user:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new UserFragment()).commit();
                    return true;
            }
            return false;
        });
    }
}