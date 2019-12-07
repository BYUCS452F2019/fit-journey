package Request;

public class AddMealRequest {
    private String mealID;
    private String userID;
    private String time;

    public AddMealRequest() {
    }

    public AddMealRequest(String mealID, String userID,String time) {
        this.mealID = mealID;
        this.time = time;
        this.userID = userID;
    }

    public String getMealID() {
        return mealID;
    }

    public void setMealID(String mealID) {
        this.mealID = mealID;
    }

    public String getUserID() {
        return userID;
    }

    public void serUserID(String userID) {
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
