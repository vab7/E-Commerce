package com.example.e_commerce.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.CoursePage;
import com.example.e_commerce.R;
import com.example.e_commerce.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View course_item = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseViewHolder(course_item);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        int img_id = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.course_img.setImageResource(img_id);

        holder.course_bg.setBackgroundColor(Color.parseColor(courses.get(position).getBg()));
        holder.course_title.setText(courses.get(position).getTitle());
        holder.course_start.setText(courses.get(position).getStart());
        holder.course_level.setText(courses.get(position).getLevel());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CoursePage.class);

            intent.putExtra("course_page_bg", Color.parseColor(courses.get(position).getBg()));
            intent.putExtra("course_page_img", img_id);
            intent.putExtra("course_page_title", courses.get(position).getTitle());
            intent.putExtra("course_page_start", courses.get(position).getStart());
            intent.putExtra("course_page_level", courses.get(position).getLevel());
            intent.putExtra("course_page_text", courses.get(position).getText());
            intent.putExtra("course_page_id", courses.get(position).getId());

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<>(holder.course_img, "course_img")
            );

            context.startActivity(intent, options.toBundle());
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        LinearLayout course_bg;
        ImageView course_img;
        TextView course_title, course_start, course_level;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            course_bg = itemView.findViewById(R.id.course_bg);
            course_img = itemView.findViewById(R.id.course_img);
            course_title = itemView.findViewById(R.id.course_title);
            course_start = itemView.findViewById(R.id.course_start);
            course_level = itemView.findViewById(R.id.course_level);
        }
    }

}
