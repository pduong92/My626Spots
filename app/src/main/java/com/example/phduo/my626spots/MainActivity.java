package com.example.phduo.my626spots;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private Resources res = this.getResources();
    private ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView)findViewById(R.id.grid_list);

        categories = new ArrayList<Category>();
        categories.add(new Category(FoodActivity.class, R.drawable.ic_local_dining_white_24dp, getResources().getString(R.string.food_category), R.color.test));
        categories.add(new Category(CafeActivity.class, R.drawable.ic_local_cafe_white_24dp, getResources().getString(R.string.cafe_category), R.color.test));
        categories.add(new Category(DessertsActivity.class, "Desserts", R.color.test));
        categories.add(new Category(HappyHourActivity.class, R.drawable.ic_local_bar_white_24dp, getResources().getString(R.string.happyhour_category), R.color.test));
        categories.add(new Category(ActiveActivity.class, R.drawable.ic_terrain_white_24dp, getResources().getString(R.string.active_category), R.color.test));

        CategoryAdapter listAdapter = new CategoryAdapter(MainActivity.this, categories);

        gridview.setAdapter(listAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = categories.get(position);
                Class currentClass = category.obtainClass();

                startActivity(new Intent(MainActivity.this, currentClass));
            }
        });

    }
}
