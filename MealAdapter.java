package com.example.andrew.foodie;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
//import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import org.w3c.dom.Text;

import java.util.ArrayList;


public class MealAdapter extends RecyclerView.Adapter<com.example.andrew.foodie.MealAdapter.ViewHolder> {


    private Context context;
    private ArrayList<MealItem> mealData;

    public MealAdapter(Context context, ArrayList<MealItem> meals) {
        this.context = context;
        mealData = meals;
    }

    public void addContent() {

        android.util.Log.d("addContent", "inside editItemContent");
        android.content.Context contx = context;
        android.support.v7.app.AlertDialog.Builder dialogBuilder = new android.support.v7.app.AlertDialog.Builder(context);

        android.view.LayoutInflater inflater = android.view.LayoutInflater.from(contx);
        final android.view.View dialogView = inflater.inflate(R.layout.activity_dialog, null);
        dialogBuilder.setView(dialogView);
        final android.widget.EditText editText = (android.widget.EditText) dialogView.findViewById(R.id.addItem);
        final android.widget.EditText description = (android.widget.EditText) dialogView.findViewById(R.id.et_description);
        final android.widget.EditText ingredients = (android.widget.EditText) dialogView.findViewById(R.id.ingredients_et);
        final android.widget.EditText calories = (android.widget.EditText) dialogView.findViewById(R.id.calories);
        final android.widget.EditText link = (android.widget.EditText) dialogView.findViewById(R.id.link_torecipe);

//            dialogBuilder.setTitle(R.string.dialog_title);

        dialogBuilder.setPositiveButton("DONE", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("addContent", "DONE");

                String text = editText.getText().toString();
                String des = description.getText().toString();
                String ing = ingredients.getText().toString();
                String cal = calories.getText().toString();
                String lin = link.getText().toString();
                MealItem curMeal = new MealItem(text, des, ing, cal, lin, 0);
                if (text.length() + des.length() + ing.length() + cal.length() > 0) {
                    mealData.add(mealData.size(), curMeal);
                    notifyDataSetChanged();//update the RecyclerView by notifying the Adapter

                }
            }
        });

        dialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("WordViewHolderEDIT", "Cancelled");
            }
        });

        dialogBuilder.create().show();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdapter.ViewHolder viewHolder, int position) {
        MealItem currMeal = mealData.get(position);
        viewHolder.bindItem(currMeal);
    }

    @Override
    public int getItemCount() {

        return mealData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener{

        private TextView textTitle, textInfo, textIngredients;
        private ImageView imageMeal;

        public ViewHolder(View itemView){
            super(itemView);
            textInfo = (TextView) itemView.findViewById(R.id.textDescript);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            //textIngredients = (TextView) itemView.findViewById(R.id.textIngredients);
            imageMeal = (ImageView) itemView.findViewById(R.id.imageMeal);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bindItem(MealItem currMeal){
            textInfo.setText(currMeal.getDescription());
            textTitle.setText(currMeal.getTitle());
            //textIngredients.setText(currMeal.getIngredients());

            imageMeal.setImageResource(currMeal.getImageID());

        }

        @Override
        public void onClick(View v) {
            Log.d("MealAdapter","In on click");

            MealItem currMeal = mealData.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailsActivity.class);
            Log.d("MealAdapter", "putting in intent");
            intent.putExtra("Image_ID", currMeal.getImageID());
            intent.putExtra("Title", currMeal.getTitle());
            intent.putExtra("Calories", currMeal.getCalories());
            intent.putExtra("Ingredients", currMeal.getIngredients());
            intent.putExtra("Description", currMeal.getDescription());
            intent.putExtra("Link", currMeal.getLink());
            context.startActivity(intent);


        }

        @Override
        public boolean onLongClick(View v) {

            Log.d("MealAdapter", "OnlongClicked");
            MealItem currMeal = mealData.get(getAdapterPosition());
            mealData.remove(currMeal);
            notifyDataSetChanged();
            return true;

        }

    }

}
