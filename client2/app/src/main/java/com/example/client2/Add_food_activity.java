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

import Model.FoodItemsModel;
import Request.AddFoodRequest;
import Response.AddFoodResponse;
import androidx.appcompat.app.AppCompatActivity;


public class Add_food_activity extends AppCompatActivity {
    private Button home;
    private EditText foodName;
    private EditText portionSize;
    private Button submit;

    private String food;
    private int portion;
    private String mealID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealID = (String) getIntent().getSerializableExtra("mealDetail");
        setContentView(R.layout.activity_add_meal_activity);
        foodName = (EditText) findViewById(R.id.foodName);
        portionSize = (EditText) findViewById(R.id.portionSize);
        home = (Button) findViewById(R.id.back);

        submit.setEnabled(false);

        /*check text changed*/
        foodName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                food = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkSubmitButton();
            }
        });
        portionSize.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                portion = Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkSubmitButton();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switch to timer
                Intent intent = new Intent(Add_food_activity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFoodAsyncTask addFoodAsyncTask = new AddFoodAsyncTask();
                addFoodAsyncTask.execute();
            }
        });
    }

    protected void checkSubmitButton(){
        if(foodName.getText().toString().equals("") || portionSize.getText().toString().equals("") ){
            submit.setEnabled(false);
        }
        else{
            submit.setEnabled(true);
        }

    }
    private class AddFoodAsyncTask extends AsyncTask<Void, String, AddFoodResponse> {

        @Override
        protected AddFoodResponse doInBackground(Void... voids) {
            System.out.println("I am here");
            UUID food_id = UUID.randomUUID();
            AddFoodRequest addFoodRequest = new AddFoodRequest(mealID, food_id.toString(), food, portion);
            publishProgress("Adding a new food");

            ServerProxy serverProxy = new ServerProxy();
            return serverProxy.addFood(food_id.toString(),addFoodRequest);

        }
        @Override
        protected void onProgressUpdate(String... toast) {
            Toast.makeText(Add_food_activity.this, toast[0], Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onPostExecute (AddFoodResponse addFoodResponse){
            try {
                if (addFoodResponse.getFoodId() == null) {
                    Toast.makeText(Add_food_activity.this, addFoodResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else{
                    FoodItemsModel model = FoodItemsModel.getModel();
                    model.setFood_item_id(addFoodResponse.getFoodId());

                    foodName.setText("");
                    portionSize.setText("");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }

}
