package Response;

public class AddMealResponse {
    private String mealID;
    private String time;
    private int calories;
    private String userID;
    private String message;

    public AddMealResponse(){

    }
    public AddMealResponse(String mealID, String message, String time, int calories) {
        this.mealID = mealID;
        this.message = message;
        this.time = time;
        this.calories = calories;
    }

    public String getMealId() {
        return mealID;
    }

    public void setMealId(String foodId) {
        this.mealID = foodId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}