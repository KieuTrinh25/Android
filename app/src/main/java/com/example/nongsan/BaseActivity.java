package com.example.nongsan;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nongsan.data.DatabaseDao;
import com.example.nongsan.data.DatabaseSQlite;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseDao.init(new DatabaseSQlite(this));
    }
}
