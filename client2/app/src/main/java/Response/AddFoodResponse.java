package Response;

public class AddFoodResponse {
    private String food_id;
    private String message;
    private String meal_id;
    private String food_name;
    private int portion_size;

    public AddFoodResponse(){
        this.food_id = "";
        this.message = "";
        this.meal_id = "";
        this.portion_size = 0;
        this.food_name = "";
    }
    public AddFoodResponse(String foodID, String message, String meal_id, int portion_size, String food_name) {
        this.food_id = foodID;
        this.message = message;
        this.meal_id = meal_id;
        this.portion_size = portion_size;
        this.food_name = food_name;
    }

    public String getFoodId() {
        return food_id;
    }

    public void setFoodId(String foodId) {
        this.food_id = foodId;
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
