package Response;

public class GetSingleFoodResponse {
    private int food_item_id;
    private int meal_id;
    private String food_name;
    private int portion_size;

    public GetSingleFoodResponse(){}

    public GetSingleFoodResponse(int meal_id, int food_item_id, String food_name, int portion_size){
        this.meal_id = meal_id;
        this.food_item_id = food_item_id;
        this.food_name = food_name;
        this.portion_size = portion_size;
    }

    public int getFood_item_id() {
        return food_item_id;
    }

    public void setFood_item_id(int food_item_id) {
        this.food_item_id = food_item_id;
    }

    public int getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(int meal_id) {
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
