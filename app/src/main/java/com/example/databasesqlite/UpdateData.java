package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasesqlite.handlers.MyDbHandler;

public class UpdateData extends AppCompatActivity {
    EditText updateDate, updateBreakfast, updateLunch, updateSnacks, updateDinner;
    Button updateData, deleteData;
    MyDbHandler dbHandler;
    String dateupdate, breakfastupdate, lunchupdate, snacksupdate, dinnerupdate;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        updateDate = findViewById(R.id.updateDate);
        updateBreakfast = findViewById(R.id.updateBreakfast);
        updateLunch = findViewById(R.id.updateLunch);
        updateSnacks = findViewById(R.id.updateSnacks);
        updateDinner = findViewById(R.id.updateDinner);
        updateData = findViewById(R.id.updateData);
        deleteData = findViewById(R.id.deleteData);
        toolbar= findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        dbHandler = new MyDbHandler(UpdateData.this);

        dateupdate = getIntent().getStringExtra("Date");
        breakfastupdate = getIntent().getStringExtra("Breakfast");
        lunchupdate = getIntent().getStringExtra("Lunch");
        snacksupdate = getIntent().getStringExtra("Snacks");
        dinnerupdate = getIntent().getStringExtra("Dinner");

        updateDate.setText(dateupdate);
        updateBreakfast.setText(breakfastupdate);
        updateLunch.setText(lunchupdate);
        updateSnacks.setText(snacksupdate);
        updateDinner.setText(dinnerupdate);

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.updateData(dateupdate, updateDate.getText().toString(), updateBreakfast.getText().toString(), updateLunch.getText().toString(), updateSnacks.getText().toString(), updateDinner.getText().toString());

                Toast.makeText(UpdateData.this, "Data Updated..", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(UpdateData.this, MainActivity.class);
                startActivity(i);
            }
        });

        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteData(updateDate.getText().toString());
                Toast.makeText(UpdateData.this, "Deleted the course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateData.this, MainActivity.class);
                startActivity(i);
            }
        });


    }


}