package Response;

import java.util.ArrayList;
import java.util.List;
import Model.MealModel;

public class GetListMealsResponse {
    private List<MealModel> data;
    private String message;

    public GetListMealsResponse(List<MealModel> data, String message) {
        this.data = data;
        this.message = message;
    }

    public GetListMealsResponse() {
        data = new ArrayList<>();
        message = "";
    }

    public List<MealModel> getListMeals() {
        return data;
    }

    public void setListMeals(List<MealModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
