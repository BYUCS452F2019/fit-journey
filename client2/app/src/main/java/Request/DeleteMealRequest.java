package Request;

public class DeleteMealRequest {
    private int mealID;
    private int dayID;

    public DeleteMealRequest(int mealID, int dayID) {
        this.mealID = mealID;
        this.dayID = dayID;
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
}
