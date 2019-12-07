package Model;

public class RunModel {

    String run_id;
    int user_id;
    double distance;
    String start_time;
    String end_time;
    double pace;
    int calories_burned;
    String route;

    public RunModel() {

    }

    public RunModel(String run_id, int user_id, double distance, String start_time, String end_time, double pace, int calories_burned, String route) {
        this.run_id = run_id;
        this.user_id = user_id;
        this.distance = distance;
        this.start_time = start_time;
        this.end_time = end_time;
        this.pace = pace;
        this.calories_burned = calories_burned;
        this.route = route;
    }

    // Getters
    public String getRun_id() { return run_id; }
    public int getUser_id() { return user_id; }
    public double getDistance() { return distance; }
    public String getStart_time() { return start_time; }
    public String getEnd_time() { return end_time; }
    public double getPace() { return pace; }
    public int getCalories_burned() { return calories_burned; }
    public String getRoute() { return route; }

    // Setters
    public void setRun_id(String run_id) { this.run_id = run_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setDistance(double distance) { this.distance = distance; }
    public void setStart_time(String start_time) { this.start_time = start_time; }
    public void setEnd_time(String end_time) { this.end_time = end_time; }
    public void setPace(double pace) { this.pace = pace; }
    public void setCalories_burned(int calories_burned) { this.calories_burned = calories_burned; }
    public void setRoute(String route) { this.route = route; }
}
