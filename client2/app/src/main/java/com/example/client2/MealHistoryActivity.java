package com.example.client2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import Model.Data;
import Model.FoodItemsModel;
import Model.LoginModel;
import Model.MealModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MealHistoryActivity extends AppCompatActivity {
    private Button home;
    private TextView userID_textView;
    private String user_id;
    private RecyclerView meals;
    private LinearLayoutManager mealManager;
    private MealAdapter mealAdapter;
    private TextView mealTitleHeader;
    private boolean mealListOpen = false;
    private MealModel mealModel = new MealModel();
    private Data userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user_id = LoginModel.getModel().getAuthtoken();
        setContentView(R.layout.activity_meal_history);
        home = (Button) findViewById(R.id.back);
        userID_textView = (TextView) findViewById(R.id.userNameText);
        meals = (RecyclerView) findViewById(R.id.recyclerViewMeal);

        mealManager = new LinearLayoutManager(getApplicationContext());
        mealManager.setOrientation(LinearLayoutManager.VERTICAL);

        meals.setLayoutManager(mealManager);
        final ArrayList<MealModel> list_of_meals = new ArrayList<>();
        for(MealModel tempMeal: MealModel.getModel().getMeals()){
            list_of_meals.add(tempMeal);
        }

        mealAdapter = new MealAdapter(list_of_meals);


        meals.setAdapter(mealAdapter);

        //set text view and icon
        userID_textView.setText(LoginModel.getModel().getUserName());

        mealTitleHeader = findViewById(R.id.mealTitle);
        mealTitleHeader.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mealAdapter = new MealAdapter(list_of_meals);
                meals.setAdapter(mealAdapter);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switch to timer
                Intent intent = new Intent(MealHistoryActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }

    private class MealAdapter extends RecyclerView.Adapter<MealAdapter.EventViewHolder> {
        private ArrayList<MealModel> listOfMeals = new ArrayList<>();
        public MealAdapter(ArrayList<MealModel> mealList){
            listOfMeals = mealList;
        }

        public class EventViewHolder extends RecyclerView.ViewHolder {
            public TextView firstLine;
            public TextView secondLine;

            //connect to view holder
            public EventViewHolder(View itemView) {
                super(itemView);

                firstLine = (TextView) itemView.findViewById(R.id.listFirstTextView);
                secondLine = (TextView) itemView.findViewById(R.id.listSecondTextView);
            }
        }
        //link adapter and view holder
        @Override
        public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            final View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_viewholder, parent, false);
            return new EventViewHolder(eventView);
            //return null;
        }
        //set values for view holder
        @Override
        public void onBindViewHolder(EventViewHolder holder, int position) {

            System.out.print("position " +position);
            MealModel mealModel = listOfMeals.get(position);
            List<FoodItemsModel> foods = new ArrayList<>();

            holder.firstLine.setText("Time: " + mealModel.getTime());

            //get the foods belong to the certain mealID
            foods = FoodItemsModel.getModel().getMealID_foods().get(mealModel.getMealID());
            String food_string="";
            for (FoodItemsModel food :foods ){
                food_string += food.getFood_name();
                food_string += ", ";
            }

            holder.secondLine.setText("Foods: " + food_string);
        }
        @Override
        public int getItemCount() {
            return listOfMeals.size();
        }
    }

}
