package Model;

import java.util.ArrayList;
import java.util.List;

public class MealModel {
    private static MealModel sMealModel;
    private String mealID;
    private String time;
    private int calories;
    private String userID;
    private List<MealModel> meals;

    public MealModel() {
        this.mealID = "";
        this.time = "";
        this.calories = 0;
        this.userID = "";
        this.meals = new ArrayList<>();
    }
    //returns the instance of the Model
    public static MealModel getModel() {
        if (sMealModel == null) {
            sMealModel = new MealModel();
        }
        return sMealModel;
    }

    public MealModel(String userID, String mealID, String time, int calories) {
        this.mealID = mealID;
        this.time = time;
        this.calories = calories;
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMealID() {
        return mealID;
    }

    public void setMealID(String mealID) {
        this.mealID = mealID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public List<MealModel> getMeals() {
        return meals;
    }

    public void setMeals(List<MealModel> meals) {
        this.meals = meals;
    }
}
