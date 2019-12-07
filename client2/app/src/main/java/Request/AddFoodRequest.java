package Request;

public class AddFoodRequest {
    private String food_item_id;
    private String meal_id;
    private String food_name;
    private int portion_size;

    public AddFoodRequest(){
        this.meal_id = "";
        this.food_item_id = "";
        this.food_name = "";
        this.portion_size = 0;
    }

    public AddFoodRequest(String meal_id,String food_item_id, String food_name, int portion_size){
        this.meal_id = meal_id;
        this.food_item_id = food_item_id;
        this.food_name = food_name;
        this.portion_size = portion_size;
    }

    public String getFood_item_id() {
        return food_item_id;
    }

    public void setFood_item_id(String food_item_id) {
        this.food_item_id = food_item_id;
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
