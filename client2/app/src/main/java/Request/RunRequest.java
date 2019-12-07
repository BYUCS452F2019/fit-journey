package Request;

public class RunRequest {
    private String userName;
    private int run_id;
    private int user_id;
    private double distance;
    private String start_time;
    private String end_time;
    private double pace;
    private int calories_burned;

    public RunRequest(String userName, int run_id, int user_id, double distance, String start_time, String end_time, double pace, int calories_burned) {
        this.userName = userName;
        this.run_id = run_id;
        this.user_id = user_id;
        this.distance = distance;
        this.start_time = start_time;
        this.end_time = end_time;
        this.pace = pace;
        this.calories_burned = calories_burned;
    }

    // Getters
    public String getUserName() {
        return userName;
    }
    public int getRun_id() {
        return run_id;
    }
    public int getUser_id() { return user_id; }
    public double getDistance() { return distance; }
    public String getStart_time() { return start_time; }
    public String getEnd_time() { return end_time; }
    public double getPace() { return pace; }
    public int getCalories_burned() { return calories_burned; }

    // Setters
    public void setUsername(String userName) {
        this.userName = userName;
    }
    public void setRun_id(int run_id) { this.run_id = run_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setDistance(double distance) { this.distance = distance; }
    public void setStart_time(String start_time) { this.start_time = start_time; }
    public void setEnd_time(String end_time) { this.end_time = end_time; }
    public void setPace(double pace) { this.pace = pace; }
    public void setCalories_burned(int calories_burned) { this.calories_burned = calories_burned; }
}

