package Request;

public class GetMealRequest {
    private String userID;
    private String mealID;

    public GetMealRequest(String userID, String mealID) {
        this.userID = userID;
        this.mealID = mealID;
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
}
