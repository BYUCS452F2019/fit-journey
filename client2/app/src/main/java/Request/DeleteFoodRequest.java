package Request;

public class DeleteFoodRequest {
    /** ID for the event*/
    int foodID;
    /** Auth token for the user*/
    int mealID;

    /** Default Constructor set eventID and authToken*/
    public DeleteFoodRequest() {
    }

    /** Constructor to set eventID and authToken
     * @param foodID ID for events
     * @param mealID Auth token for user who have the event
     */
    public DeleteFoodRequest(int foodID, int mealID) {
        this.foodID = foodID;
        this.mealID = mealID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getAuthToken() {
        return mealID;
    }

    public void setAuthToken(int mealID) {
        this.mealID = mealID;
    }
}
