package com.example.anotherprocess;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnQueryData;
    private Button btnAddData;
    private Button btnUpdateData;
    private Button btnDeleteData;
    private final static String authority = "com.example.demo.provider";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
    }

    private void initView() {
        btnDeleteData = findViewById(R.id.btn_delete_data);
        btnDeleteData.setOnClickListener(this);
        btnQueryData = findViewById(R.id.btn_query_data);
        btnQueryData.setOnClickListener(this);
        btnAddData = findViewById(R.id.btn_add_data);
        btnAddData.setOnClickListener(this);
        btnUpdateData = findViewById(R.id.btn_update_data);
        btnUpdateData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_query_data) {
            queryByContentProvider();
        }
    }

    private void queryByContentProvider() {
//        Uri uri = Uri.parse("content://" + authority + "/user");
        Uri uri = Uri.parse("content://com.example.demo.provider/user");

        Cursor cursor = getContentResolver().query(uri, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex("username"));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex("email"));

                Log.e("AnotherProcess", "id : " + id);
                Log.e("AnotherProcess", "username : " + username);
                Log.e("AnotherProcess", "password : " + password);
                Log.e("AnotherProcess", "email : " + email);
            }
            cursor.close();
        }

    }
}