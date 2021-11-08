package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.CourseAdapter;
import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courses = new ArrayList<>();
    static List<Course> fullCourses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Игры"));
        categories.add(new Category(2, "Сайты"));
        categories.add(new Category(3, "Языки"));
        categories.add(new Category(4, "Прочее"));

        setCategoryAdapter(categories);


        courses.add(new Course(1, 3, "java", "Профессия Java \nразработчик", "1 января", "средний", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере. \n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        courses.add(new Course(2, 3, "python", "Профессия Python \nразработчик", "1 февраля", "средний", "#9FA52D", "Программа обучения Джава – рассчитана на новичков в данной сфере. \n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        courses.add(new Course(3, 1, "unity", "Профессия Unity \nразработчик", "1 марта", "средний", "#690058", "Программа обучения Джава – рассчитана на новичков в данной сфере. \n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        courses.add(new Course(4, 2, "front_end", "Профессия Front-End \nразработчик", "1 апреля", "начальный", "#D02100", "Программа обучения Джава – рассчитана на новичков в данной сфере. \n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        courses.add(new Course(5, 2, "back_end", "Профессия Back-End \nразработчик", "1 мая", "средний", "#0043C2", "Программа обучения Джава – рассчитана на новичков в данной сфере. \n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        courses.add(new Course(6, 2, "full_stack", "Профессия Full-Stack \nразработчик", "1 июня", "трудный", "#FFC107", "Программа обучения Джава – рассчитана на новичков в данной сфере. \n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!"));

        fullCourses.addAll(courses);

        setCourseAdapter(courses);

        ImageView img_filter = findViewById(R.id.img_filter);
        img_filter.setOnClickListener(v -> {
            courses.clear();
            courses.addAll(fullCourses);
            courseAdapter.notifyDataSetChanged();
        });

    }

    public void openShoppingCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);

        startActivity(intent);
    }

    public static void findCoursesByCategory(int category) {

        courses.clear();
        courses.addAll(fullCourses);

        List<Course> filterCourse = new ArrayList<>();

        for (Course c : courses) {
            if (c.getCategory() == category)
                filterCourse.add(c);
        }

        courses.clear();
        courses.addAll(filterCourse);
        courseAdapter.notifyDataSetChanged();

    }

    private void setCourseAdapter(List<Course> courses) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.course_recycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courses);
        courseRecycler.setAdapter(courseAdapter);

    }

    private void setCategoryAdapter(List<Category> categories) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.category_recycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categories);
        categoryRecycler.setAdapter(categoryAdapter);

    }
}