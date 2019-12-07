package com.example.client2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.ServerProxy;

import java.util.UUID;

import Model.Data;
import Model.LoginModel;
import Model.MealModel;
import Request.AddMealRequest;
import Response.AddMealResponse;
import androidx.appcompat.app.AppCompatActivity;

public class Add_meal_activity extends AppCompatActivity {
    private Button add_meal;
    private Button home;
    private EditText time;
    private String time_text;
    private Data user;
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal_activity);
        add_meal = (Button) findViewById(R.id.add_food);
        home = (Button) findViewById(R.id.back);
        time = (EditText) findViewById(R.id.meal_time);

        time.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                time_text = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkSubmitButton();
            }

        });
        add_meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switch to timer
                AddMealAsyncTask addMealAsyncTask = new AddMealAsyncTask();
                addMealAsyncTask.execute();
//                Intent intent = new Intent(Add_meal_activity.this, Add_food_activity.class);
//                intent.putExtra("mealDetail", mealModel.getMealID());
//                startActivity(intent);

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switch to timer
                Intent intent = new Intent(Add_meal_activity.this, HomeActivity.class);
//                intent.putExtra("mealDetail", mealModel.getMealID());
                startActivity(intent);

            }
        });
    }

    private class AddMealAsyncTask extends AsyncTask<Void, String, AddMealResponse> {

        @Override
        protected AddMealResponse doInBackground(Void... voids) {
            System.out.println("I am here");
            UUID mealID = UUID.randomUUID();
            userID = LoginModel.getModel().getAuthtoken();
            AddMealRequest addMealRequest = new AddMealRequest(mealID.toString(), userID, time_text);


            publishProgress("Adding a new food");

            ServerProxy serverProxy = new ServerProxy();
            return serverProxy.addMeal(mealID.toString(), addMealRequest);
        }
        @Override
        protected void onProgressUpdate(String... toast) {
            Toast.makeText(Add_meal_activity.this, toast[0], Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onPostExecute (AddMealResponse addMealResponse){
            try {
                if (addMealResponse.getMealId() == null) {
                    Toast.makeText(Add_meal_activity.this, addMealResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else{
                    MealModel model = MealModel.getModel();
                    model.setMealID(addMealResponse.getMealId());

                    Intent intent = new Intent(Add_meal_activity.this, Add_food_activity.class);
                    intent.putExtra("mealDetail", model.getMealID());
                    startActivity(intent);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    protected void checkSubmitButton(){
        if(time.getText().toString().equals("")){
            add_meal.setEnabled(false);
        }
        else{
            add_meal.setEnabled(true);
        }

    }
}
