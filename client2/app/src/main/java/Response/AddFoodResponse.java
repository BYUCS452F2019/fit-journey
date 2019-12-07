package Response;

public class AddFoodResponse {
    private String foodId;
    private String message;

    public AddFoodResponse(){

    }
    public AddFoodResponse(String foodID, String message) {
        this.foodId = foodId;
        this.message = message;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
