package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FoodItemsModel {
    private static FoodItemsModel model;
    private String food_item_id;
    private String meal_id;
    private String food_name;
    private int portion_size;
    private List<FoodItemsModel> listFoods;
    private TreeMap<String, List<FoodItemsModel>> mealID_foods;
    public FoodItemsModel(){
        food_item_id = "";
        meal_id = "";
        food_name = "";
        portion_size = 0;
        listFoods = new ArrayList<>();
        mealID_foods = new TreeMap<>();
    }
    //returns the instance of the Model
    public static FoodItemsModel getModel() {
        if (model == null) {
            model = new FoodItemsModel();
        }
        return model;
    }

    public FoodItemsModel(String food_item_id, String meal_id, String food_name, int portion_size){
        this.food_item_id = food_item_id;
        this.meal_id = meal_id;
        this.food_name = food_name;
        this.portion_size = portion_size;
    }

    public List<FoodItemsModel> getListFoods() {
        return listFoods;
    }

    public void setListFoods(List<FoodItemsModel> listFoods) {
        this.listFoods = listFoods;
    }

    public String getFood_item_id() {
        return food_item_id;
    }

    public void setFood_item_id(String food_item_id) {
        this.food_item_id = food_item_id;
    }

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getPortion_size() {
        return portion_size;
    }

    public void setPortion_size(int portion_size) {
        this.portion_size = portion_size;
    }

    public TreeMap<String, List<FoodItemsModel>> getMealID_foods() {
        return mealID_foods;
    }

    public void setMealID_foods(TreeMap<String, List<FoodItemsModel>> mealID_foods) {
        this.mealID_foods = mealID_foods;
    }
}
