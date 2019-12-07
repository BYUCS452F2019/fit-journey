package Request;

public class GetMealRequest {
    private String user_id;
    private String meal_id;

    public GetMealRequest() {
        user_id = "";
        meal_id = "";
    }

    public GetMealRequest(String userID, String mealID) {
        this.user_id = userID;
        this.meal_id = mealID;
    }

    public String getUserID() {
        return user_id;
    }

    public void setUserID(String userID) {
        this.user_id = userID;
    }

    public String getMealID() {
        return meal_id;
    }

    public void setMealID(String mealID) {
        this.meal_id = mealID;
    }
}
