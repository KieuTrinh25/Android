package com.example.nongsan.data.implement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nongsan.data.DatabaseHelper;
import com.example.nongsan.data.dao.CategoryDao;
import com.example.nongsan.data.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImplement extends DatabaseHelper implements CategoryDao {
    public CategoryDaoImplement(Context context){
        super(context);
    }

    @Override
    public Category find(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("categories", null, "id = ?", new String[] { String.valueOf(id) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Category category = new Category(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
        return category;

    }

    @Override
    public List<Category> all() {
        List<Category>  categoryList = new ArrayList<>();
        String query = "SELECT * FROM CATEGORIES";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Category category = new Category(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            categoryList.add(category);
            cursor.moveToNext();
        }
        return categoryList;
    }
    @Override
    public void insert(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // ben database phải có cột image, name, description nha
        values.put("name", category.name);
        values.put("description", category.description);
        values.put("image", category.image);

        db.insert("categories", null, values);
        db.close();

    }
    @Override
    public void update(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", category.name);

        db.update("categories", values, "id = ?", new String[] { String.valueOf(category.id) });
        db.close();
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("categories", "id = ?", new String[] { String.valueOf(id) });
        db.close();
    }

    @Override
    public List<Category> findByName(String name) {
        List<Category>  categoryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("categories", null, "name = ?", new String[] { name },null, null, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Category category = new Category(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            categoryList.add(category);
            cursor.moveToNext();
        }
        return categoryList;
    }
}
