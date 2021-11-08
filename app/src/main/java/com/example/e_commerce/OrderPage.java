package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.e_commerce.model.Course;
import com.example.e_commerce.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        List<String> order_title = new ArrayList<>();

        ListView order_list = findViewById(R.id.order_list);

        for (Course c : MainActivity.fullCourses) {
            if (Order.order_list.contains(c.getId()))
                order_title.add(c.getTitle());
        }

        order_list.setAdapter(new ArrayAdapter<>(this, R.layout.order_item, order_title));

        Button clearCourses = findViewById(R.id.clearCourses);
        clearCourses.setOnClickListener(v -> {
            Order.order_list.clear();
            order_list.setAdapter(null);
        });

    }

}