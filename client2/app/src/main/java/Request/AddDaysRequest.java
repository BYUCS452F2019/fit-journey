package Request;

public class AddDaysRequest {
    private int day_id;
    private int user_id;
    private String date;

    public AddDaysRequest(int day_id, int user_id, String date) {
        this.day_id = day_id;
        this.user_id = user_id;
        this.date = date;
    }

    public int getDay_id() {
        return day_id;
    }

    public void setDay_id(int day_id) {
        this.day_id = day_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
