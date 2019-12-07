package Model;

import java.util.ArrayList;

public class Data {

    private static Data data;
    private int user_id;
    private String username;
    private String name;
    private String age;
    private String height;
    private String weight;
    private String authToken;
    private ArrayList<RunModel> runsHistory;


    private Data() { }

    // Getters
    public static Data getData() {
        if (data == null) {
            data = new Data();

            // TODO: Remove mock data and use actual data after finishing ServerProxy and Request/Response
            data.name = "Johne Doe";
            data.username = "johndoe";
            data.age = "23";
            data.height = "5ft 9in";
            data.weight = "200lbs";
            data.authToken = "1234567";
            data.runsHistory = new ArrayList<>();
//            RunModel track1 = new RunModel("1",1,104.2,"08:29:48","12:34:25",6,570);
//            RunModel track2 = new RunModel("2",2,14.2,"14:35:48","15:34:25",5,238);
//            RunModel track3 = new RunModel("3",3,8.6,"06:47:25","07:57:43",7,423);
//            RunModel track4 = new RunModel("4",4,7.3,"06:29:48","08:34:25",6,360);
//
//            data.runsHistory.add(track1);
//            data.runsHistory.add(track2);
//            data.runsHistory.add(track3);
//            data.runsHistory.add(track4);
        }
        return data;
    }
    public String getName() { return name; }
    public int getUser_id() { return user_id; }
    public String getUsername() { return username; }
    public String getAge() { return age; }
    public String getHeight() { return height; }
    public String getWeight() { return weight; }
    public String getAuthToken() { return authToken; }
    public ArrayList<RunModel> getRunsHistory() {

        return runsHistory;
    }

    // Setters
    public static void setData(Data data) { Data.data = data; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setName(String name) { name = this.name; }
    public void setUsername(String username) { username = this.username; }
    public void setAge(String age) { this.age = age; }
    public void setHeight(String height) { this.height = height; }
    public void setWeight(String weight) { this.weight = weight; }
    public void setAuthToken(String authToken) { this.authToken = authToken; }
    public void setRunsHistory(ArrayList<RunModel> runsHistory) { this.runsHistory = runsHistory; }
}
