package com.example.nongsan.data.dao;

import com.example.nongsan.data.model.Category;

import java.util.List;

public interface CategoryDao {
    Category find(int id);
    List<Category> all();
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    List<Category> findByName(String name);
}
