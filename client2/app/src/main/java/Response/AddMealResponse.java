package Response;

public class AddMealResponse {
    private String meal_id;
    private String time;
    private int calories;
    private String user_id;
    private String message;

    public AddMealResponse(){
        this.meal_id = "";
        this.message = "";
        this.time = "";
        this.calories = 0;
        this.user_id = "";
    }
    public AddMealResponse(String mealID, String message, String time, int calories, String user_id) {
        this.meal_id = mealID;
        this.message = message;
        this.time = time;
        this.calories = calories;
        this.user_id = user_id;
    }

    public String getMealId() {
        return meal_id;
    }

    public void setMealId(String foodId) {
        this.meal_id = foodId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMealID() {
        return meal_id;
    }

    public void setMealID(String mealID) {
        this.meal_id = mealID;
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

    public String getUserID() {
        return user_id;
    }

    public void setUserID(String userID) {
        this.user_id = userID;
    }
}
