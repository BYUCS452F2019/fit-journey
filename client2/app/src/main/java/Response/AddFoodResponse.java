package Response;

public class AddFoodResponse {
    private String foodId;
    private String message;
    private String meal_id;
    private String food_name;
    private int portion_size;

    public AddFoodResponse(){

    }
    public AddFoodResponse(String foodID, String message, String meal_id, int portion_size) {
        this.foodId = foodId;
        this.message = message;
        this.meal_id = meal_id;
        this.portion_size = portion_size;
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

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getPortion_size() {
        return portion_size;
    }

    public void setPortion_size(int portion_size) {
        this.portion_size = portion_size;
    }
}
