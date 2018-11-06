package com.example.andrew.foodie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.GridLayoutManager;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MealItem> mealListData;
    private MealAdapter mealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));


        mealListData = new ArrayList<>();
        mealAdapter = new MealAdapter(this,mealListData);

        recyclerView.setAdapter(mealAdapter);
        loadMealData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mealAdapter.addContent();
            }
        });

        MyReceiver myReciever = new MyReceiver(mealListData);
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("com.example.andrew.I_AM_HOME");
        registerReceiver(myReciever, intentFilter);
    }

    public void loadMealData(){
        mealListData.clear();

        TypedArray mealImages = getResources().obtainTypedArray(R.array.meal_images);
        String [] mealTitles = getResources().getStringArray(R.array.titles);
        String [] mealInfo = getResources().getStringArray(R.array.description);
        String[] mealingredients = getResources().getStringArray(R.array.ingredients);
        String [] mealLinks = getResources().getStringArray(R.array.links);
        String [] mealCalories = getResources().getStringArray(R.array.calories);

        List<String> titles = Arrays.asList(mealTitles);



        for (int i = 0; i < mealImages.length();i++){
            MealItem currMeal = new MealItem(
                    mealTitles[i],
                    mealInfo[i],
                    mealingredients[i],
                    mealCalories[i],
                    mealLinks[i],
                    mealImages.getResourceId(i,0));
            mealListData.add(currMeal);
        }

        mealAdapter.notifyDataSetChanged();
        mealImages.recycle();
    }
}
