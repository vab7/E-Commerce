package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout course_page_bg = findViewById(R.id.course_page_bg);
        ImageView course_page_img = findViewById(R.id.course_page_img);
        TextView course_page_title = findViewById(R.id.course_page_title);
        TextView course_page_start = findViewById(R.id.course_page_start);
        TextView course_page_level = findViewById(R.id.course_page_level);
        TextView course_page_text = findViewById(R.id.course_page_text);

        course_page_bg.setBackgroundColor(getIntent().getIntExtra("course_page_bg", 0));
        course_page_img.setImageResource(getIntent().getIntExtra("course_page_img", 0));
        course_page_title.setText(getIntent().getStringExtra("course_page_title"));
        course_page_start.setText(getIntent().getStringExtra("course_page_start"));
        course_page_level.setText(getIntent().getStringExtra("course_page_level"));
        course_page_text.setText(getIntent().getStringExtra("course_page_text"));
    }

    public void addToShop(View view) {
        int id = getIntent().getIntExtra("course_page_id", 0);

        if (!Order.order_list.contains(id))
            Order.order_list.add(id);

        Toast.makeText(this, "Добавленно", Toast.LENGTH_SHORT).show();
    }

}