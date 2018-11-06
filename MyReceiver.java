package com.example.andrew.foodie;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.Random;

public class MyReceiver extends BroadcastReceiver {

    private java.util.ArrayList<com.example.andrew.foodie.MealItem> items;
    protected static final String ACTION_MY_CUSTOM_BROADCAST = "" +
            "com.example.andrew.I_AM_HOME";
    private final String TAG = "MyReceiver";



    public MyReceiver(java.util.ArrayList<MealItem> foods){
        items = foods;
    }

    @Override
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        android.util.Log.d("MyReciever", "Broadcast Received");
        Random ran = new Random();
        int index = ran.nextInt(3);
        String act = intent.getAction();
        MealItem curMeal = items.get(index);
        Intent start = new Intent(context, DetailsActivity.class);
        start.putExtra("Image_ID", curMeal.getImageID());
        start.putExtra("Title", curMeal.getTitle());
        start.putExtra("Calories", curMeal.getCalories());
        start.putExtra("Ingredients", curMeal.getIngredients());
        start.putExtra("Description", curMeal.getDescription());
        start.putExtra("Link", curMeal.getLink());
        context.startActivity(start);
        android.widget.Toast.makeText(context, "Happy Cooking " + curMeal.getTitle(), android.widget.Toast.LENGTH_LONG).show();
        android.util.Log.d(TAG, "index = " + index);
    }
}
