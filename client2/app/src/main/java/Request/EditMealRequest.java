package Request;

public class EditMealRequest {
    private int mealID;
    private int dayID;
    private String time;
    private int calories;

    public EditMealRequest() {
    }

    public EditMealRequest(int mealID, int dayID, String time, int calories) {
        this.mealID = mealID;
        this.dayID = dayID;
        this.time = time;
        this.calories = calories;
    }

    public int getMealID() {
        return mealID;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public int getDayID() {
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
