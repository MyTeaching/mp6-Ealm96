package com.example.andrew.foodie;
import android.widget.ArrayAdapter;

public class MealItem {
    private String description;
    private int imageID;
    private String title;
    private String ingredients;
    private String calories;
    private String link;

    public MealItem(String title, String description, String ingedients,
                    String calories, String link, int imgRes){

        this.title = title;
        this.description = description;
        this.ingredients = ingedients;
        this.calories = calories;
        this.link = link;
        imageID = imgRes;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageID() {
        return imageID;
    }

    public String getIngredients(){
        return ingredients;
    }

    public String getCalories(){
        return calories;
    }

    public String getLink(){
        return link;
    }


}
