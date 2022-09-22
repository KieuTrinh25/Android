package com.example.nongsan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nongsan.data.model.Category;
import com.example.nongsan.data.model.Product;
import com.example.nongsan.ui.adapter.CategoryAdapter;
import com.example.nongsan.ui.constract.HomeFragmentConstract;
import com.example.nongsan.ui.constract.HomeFragmentPresenter;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeFragmentConstract.IView {
    private HomeFragmentConstract.IPresenter mPresenter;
    private  RecyclerView rc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // vì ảnh ở drawable trả int
        // vì ở database chưa có dữ liệu ảnh thì mình thêm vô trc
        // đạt thêm đại nha
        // trước khi chạy kiểm tra database đã có đủ 4 cột id, name, description, image chưa
        // tiếp đó mỗi lần chạy là thay đổi cái phần "R.drawable." để ảnh ở trùng vào database dạng int
        // bật lên để đạt xem file trinh ơi mở điện thoại cho chấp nhận
 //      Category category = new Category("Rau Củ", "Rau củ sạch không thuốc", R.drawable.raucu);
 //    Category category = new Category("Trái Cây", "Trái cây sạch 4 mùa", R.drawable.traicay);
//     Category category = new Category("Hải Sản", "Hải sản tươi sống", R.drawable.haisan);
//       Category category = new Category("Thịt Tươi - Trứng", "Thịt - trứng sạch ", R.drawable.thit);

//        mPresenter = new HomePresenter(this);
//        mPresenter.insertCategory(category);
//        // muốn thêm thì cứ đóng hai cái dưới mở ba 3 cái dòng trên rồi thay đỏi t tin là đc
           initGUI();
           initData();

    }
    private void initGUI(){
        rc = findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(this));
//
//        rc = findViewById(R.id.rc1);
//        rc.setLayoutManager(new LinearLayoutManager(this));



    }

    private void initData(){
        mPresenter = new HomeFragmentPresenter(this);
        mPresenter.setView(this);
        mPresenter.getCategoryList();
      //  mPresenter.getProductList();

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

    @Override
    public void setProductListToView(List<Product> productList) {
//        ProductAdapter adapter = new ProductAdapter(productList);
//        rc.setAdapter(adapter);
//        rc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showProduct(Product product) {

    }
}