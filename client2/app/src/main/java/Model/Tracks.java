package Model;

public class Tracks {

    int run_id;
    int user_id;
    double distance;
    String start_time;
    String end_time;
    double pace;
    int calories_burned;

    public Tracks() {

    }

    public Tracks(int run_id, int user_id, double distance, String start_time, String end_time, double pace, int calories_burned) {
        this.run_id = run_id;
        this.user_id = user_id;
        this.distance = distance;
        this.start_time = start_time;
        this.end_time = end_time;
        this.pace = pace;
        this.calories_burned = calories_burned;
    }

    // Getters
    public int getRun_id() { return run_id; }
    public int getUser_id() { return user_id; }
    public double getDistance() { return distance; }
    public String getStart_time() { return start_time; }
    public String getEnd_time() { return end_time; }
    public double getPace() { return pace; }
    public int getCalories_burned() { return calories_burned; }

    // Setters
    public void setRun_id(int run_id) { this.run_id = run_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setDistance(double distance) { this.distance = distance; }
    public void setStart_time(String start_time) { this.start_time = start_time; }
    public void setEnd_time(String end_time) { this.end_time = end_time; }
    public void setPace(double pace) { this.pace = pace; }
    public void setCalories_burned(int calories_burned) { this.calories_burned = calories_burned; }
}
