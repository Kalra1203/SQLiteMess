package com.example.databasesqlite.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.databasesqlite.MainActivity;
import com.example.databasesqlite.R;
import com.example.databasesqlite.UpdateData;
import com.example.databasesqlite.models.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.holder> {
    private ArrayList<Model> modelArrayList;
    private Context context;

    public MyAdapter(ArrayList<Model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    public MyAdapter(ArrayList<Model> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Model modal = modelArrayList.get(position);
        holder.mydate.setText(modal.getDate());
        holder.myBreakfast.setText(modal.getBreakfast());
        holder.myLunch.setText(modal.getLunch());
        holder.mySnacks.setText(modal.getSnacks());
        holder.myDinner.setText(modal.getDinner());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, UpdateData.class);

                i.putExtra("Date", modal.getDate());
                i.putExtra("Breakfast", modal.getBreakfast());
                i.putExtra("Lunch", modal.getLunch());
                i.putExtra("Snacks", modal.getSnacks());
                i.putExtra("Dinner", modal.getDinner());

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }



    public class holder extends ViewHolder {
        TextView mydate, myBreakfast, myLunch, mySnacks, myDinner;

        public holder(@NonNull View itemView) {
            super(itemView);

            mydate = itemView.findViewById(R.id.mydate);
            myBreakfast = itemView.findViewById(R.id.myBreakfast);
            myLunch = itemView.findViewById(R.id.myLunch);
            mySnacks = itemView.findViewById(R.id.mySnacks);
            myDinner = itemView.findViewById(R.id.myDinner);


        }

    }
}

