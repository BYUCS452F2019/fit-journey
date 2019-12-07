package Response;

public class AddMealResponse {
    private String mealID;
    private String message;

    public AddMealResponse(){

    }
    public AddMealResponse(String mealID, String message) {
        this.mealID = mealID;
        this.message = message;
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
}
