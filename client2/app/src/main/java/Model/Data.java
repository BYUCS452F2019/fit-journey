package Model;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static Data data;
    private String username;
    private String name;
    private String age;
    private String height;
    private String weight;
    private String authToken;
    private ArrayList<Tracks> trackHistory;


    private Data() { }

    // Getters
    public static Data getData() {
        if (data == null) {
            data = new Data();
            data.name = "Johne Doe";
            data.username = "johndoe";
            data.age = "23";
            data.height = "5ft 9in";
            data.weight = "200lbs";
            data.authToken = "1234567";
            data.trackHistory = new ArrayList<>();
            Tracks track1 = new Tracks(1,1,104.2,"08:29:48","12:34:25",6,570);
            Tracks track2 = new Tracks(2,2,14.2,"14:35:48","15:34:25",5,238);
            Tracks track3 = new Tracks(3,3,8.6,"06:47:25","07:57:43",7,423);
            Tracks track4 = new Tracks(4,4,7.3,"06:29:48","08:34:25",6,360);

            data.trackHistory.add(track1);
            data.trackHistory.add(track2);
            data.trackHistory.add(track3);
            data.trackHistory.add(track4);
        }
        return data;
    }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getAge() { return age; }
    public String getHeight() { return height; }
    public String getWeight() { return weight; }
    public String getAuthToken() { return authToken; }
    public ArrayList<Tracks> getTrackHistory() {

        return trackHistory;
    }

    // Setters
    public static void setData(Data data) { Data.data = data; }
    public void setName(String name) { name = this.name; }
    public void setUsername(String username) { username = this.username; }
    public void setAge(String age) { age = this.age; }
    public void setHeight(String height) { height = this.height; }
    public void setWeight(String weight) { weight = this.weight; }
    public void setAuthToken(String authToken) { authToken = this.authToken; }
    public void setTrackHistory(ArrayList<Tracks> trackHistory) { trackHistory = this.trackHistory; }
}
