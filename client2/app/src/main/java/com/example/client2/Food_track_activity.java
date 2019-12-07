package com.example.client2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Food_track_activity extends AppCompatActivity {
    private Button history;
    private Button addMeal;
    private Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_track);

        history = (Button) findViewById(R.id.food_history);
        addMeal = (Button) findViewById(R.id.add_new_meal);
        home = (Button) findViewById(R.id.back);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food_track_activity.this, MealHistoryActivity.class);
//                intent.putExtra("mealDetail", mealModel.getMealID());
                startActivity(intent);

            }
        });
        addMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food_track_activity.this, Add_meal_activity.class);
//                intent.putExtra("userDetail", userModel.getUserID());
                startActivity(intent);

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food_track_activity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }
}
