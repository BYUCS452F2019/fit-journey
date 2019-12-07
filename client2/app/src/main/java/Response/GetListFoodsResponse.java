package Response;

import java.util.List;

import Model.FoodItemsModel;

public class GetListFoodsResponse {
    private List<FoodItemsModel> data;
    private String message;

    public GetListFoodsResponse(List<FoodItemsModel> data, String message) {
        this.data = data;
        this.message = message;
    }

    public GetListFoodsResponse() {
    }

    public List<FoodItemsModel> getListMeals() {
        return data;
    }

    public void setListMeals(List<FoodItemsModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
