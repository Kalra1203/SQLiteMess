package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.databasesqlite.adapters.MyAdapter;
import com.example.databasesqlite.handlers.MyDbHandler;
import com.example.databasesqlite.models.Model;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {
    RecyclerView recyclerView;
    public ArrayList<Model> courseModalArrayList;
    public MyDbHandler dbHandler;
    public MyAdapter courseRVAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        recyclerView= findViewById(R.id.recyclerView);
        courseModalArrayList = new ArrayList<>();
        dbHandler = new MyDbHandler(ViewData.this);



        courseModalArrayList = dbHandler.readCourses();

        courseRVAdapter = new MyAdapter(courseModalArrayList, ViewData.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewData.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recyclerView.setAdapter(courseRVAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}