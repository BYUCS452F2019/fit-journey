package Request;

public class AddMealRequest {
    private String meal_id;
    private String user_id;
    private String time;
    private int calories;

    public AddMealRequest() {
        meal_id = "";
        user_id = "";
        time = "";
        calories = 0;
    }

    public AddMealRequest(String mealID, String userID,String time, int calories) {
        this.meal_id = mealID;
        this.time = time;
        this.user_id = userID;
        this.calories = calories;
    }

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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
}