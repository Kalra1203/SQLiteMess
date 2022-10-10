package com.example.databasesqlite;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.databasesqlite.handlers.MyDbHandler;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText date, breakfast, lunch, snacks, dinner;
    Button addData, listdata, PickDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        breakfast = findViewById(R.id.breakfast);
        lunch = findViewById(R.id.lunch);
        snacks = findViewById(R.id.snacks);
        dinner = findViewById(R.id.dinner);
        addData = findViewById(R.id.addData);
        listdata = findViewById(R.id.listdata);
        PickDate = findViewById(R.id.PickDate);


        PickDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayofmoth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog pickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                    }
                }, year, month, dayofmoth);
                pickerDialog.show();
            }
        });


        MyDbHandler dbHandler = new MyDbHandler(MainActivity.this);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dates = date.getText().toString();
                String breakfasts = breakfast.getText().toString();
                String lunchs = lunch.getText().toString();
                String snackss = snacks.getText().toString();
                String dinners = dinner.getText().toString();


                if (date.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Date must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    dbHandler.addData(dates, breakfasts, lunchs, snackss, dinners);
                    Toast.makeText(MainActivity.this, "Data has been added", Toast.LENGTH_SHORT).show();

                    date.setText("");
                    breakfast.setText("");
                    snacks.setText("");
                    lunch.setText("");
                    dinner.setText("");
                }
            }
        });

        listdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewData.class);
                startActivity(intent);
            }
        });


    }


}
