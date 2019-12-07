package com.example.client2;

import Model.Data;
import Model.FoodItemsModel;
import Model.LoginModel;
import Model.MealModel;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import net.ServerProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class HomeActivity extends AppCompatActivity {

    private String mealID;
    private TreeMap<String, List<FoodItemsModel>> foodsMaps = new TreeMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Data data = Data.getData();
        Button timerButton = findViewById(R.id.home_timer);
        Button trackerButton = findViewById(R.id.home_tracker);
        Button food = (Button) findViewById(R.id.meal_track);
        TextView homeName = findViewById(R.id.home_name);
        TextView homeAge = findViewById(R.id.home_age);
        TextView homeWeight = findViewById(R.id.home_weight);
        TextView homeHeight = findViewById(R.id.home_height);


        homeName.setText(data.getName());
        homeAge.setText(data.getAge());
        homeWeight.setText(data.getWeight());
        homeHeight.setText(data.getHeight());

        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        trackerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RunsHistoryActivity.class);
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MealsAsyncTask addMealAsyncTask = new MealsAsyncTask();

                addMealAsyncTask.execute();
//                Intent intent = new Intent(HomeActivity.this, Food_track_activity.class);
//                startActivity(intent);

            }
        });
    }
    //family asyncTask to fill people and events
    private class MealsAsyncTask extends AsyncTask<Void, String, Void> {
        @Override
        protected Void doInBackground(Void... voids){
            publishProgress("Generating Meals");

            ServerProxy serverProxy = new ServerProxy();
            serverProxy.getMeals(LoginModel.getModel().getAuthtoken());
            return null;
        }

        @Override
        protected void onProgressUpdate(String... toast){
            Toast.makeText(HomeActivity.this, toast[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void voids){
            List<MealModel> meals = new ArrayList<>();
            meals = MealModel.getModel().getMeals();

            for(MealModel tempMeal : meals){
                mealID = tempMeal.getMealID();
                FoodsAsyncTask foodsAsyncTask = new FoodsAsyncTask();
                foodsAsyncTask.execute();
            }
            //TODO: maybe buggy
            FoodItemsModel.getModel().setMealID_foods(foodsMaps);
            Intent intent = new Intent(HomeActivity.this, Food_track_activity.class);
            startActivity(intent);
        }

    }
    //family asyncTask to fill people and events
    private class FoodsAsyncTask extends AsyncTask<Void, String, Void> {
        @Override
        protected Void doInBackground(Void... voids){
            publishProgress("Generating Foods");

            ServerProxy serverProxy = new ServerProxy();

            serverProxy.getFoods(mealID);
            return null;
        }

        @Override
        protected void onProgressUpdate(String... toast){
            Toast.makeText(HomeActivity.this, toast[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void voids){
            foodsMaps.put(mealID, FoodItemsModel.getModel().getListFoods());
        }

    }
}
