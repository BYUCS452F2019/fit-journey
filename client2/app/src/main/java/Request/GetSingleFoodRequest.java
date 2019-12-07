package Request;

public class GetSingleFoodRequest {
    /** ID for the event*/
    String foodID;
    /** Auth token for the user*/
    String authToken;

    /** Default Constructor set eventID and authToken*/
    public GetSingleFoodRequest() {
    }

    /** Constructor to set eventID and authToken
     * @param foodID ID for events
     * @param authToken Auth token for user who have the event
     */
    public GetSingleFoodRequest(String foodID, String authToken) {
        this.foodID = foodID;
        this.authToken = authToken;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
