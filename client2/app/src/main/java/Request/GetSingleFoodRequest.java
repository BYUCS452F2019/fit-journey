package Request;

public class GetSingleFoodRequest {
    /** ID for the event*/
    String food_id;
    /** Auth token for the user*/
    String meal_id;

    /** Default Constructor set eventID and authToken*/
    public GetSingleFoodRequest() {
        food_id = "";
        meal_id = "";
    }

    /** Constructor to set eventID and authToken
     * @param foodID ID for events
     * @param meal_id Auth token for user who have the event
     */
    public GetSingleFoodRequest(String foodID, String meal_id) {
        this.food_id = foodID;
        this.meal_id = meal_id;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }
}
