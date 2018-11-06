package com.example.andrew.foodie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;




public class DetailsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView mealTitle = findViewById(R.id.mealTitle);
        TextView mealCalories = findViewById(R.id.mealCalories);

        TextView mealIngredients = findViewById(R.id.mealIngredients);

        TextView mealDescription = findViewById(R.id.mealInfo);

        TextView mealLink = findViewById(R.id.mealLink);

        ImageView imageView = (ImageView) findViewById(R.id.mealImage);


        mealTitle.setText(getIntent().getStringExtra("Title"));
        mealIngredients.setText(getIntent().getStringExtra("Ingredients"));
        mealCalories.setText(getIntent().getStringExtra("Calories"));
        mealDescription.setText(getIntent().getStringExtra("Description"));
        mealLink.setText(getIntent().getStringExtra("Link"));
        int imgID = getIntent().getIntExtra("Image_ID",0);

        imageView.setImageResource(getIntent().getIntExtra("Image_ID",0));


        //mealTitle.setText(getResources().getString(R.string.m));

    }
}
