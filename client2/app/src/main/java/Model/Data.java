package Model;

public class Data {

    private static Data data;
    private String username;
    private String name;
    private String age;
    private String height;
    private String weight;
    private String authToken;


    // Getters
    public static Data getData() {
        if (data == null) {
            data = new Data();
        }
        return data;
    }
    public String getName() {
        if (name == null) {
            return "John Doe";
        }
        return name;
    }
    public String getUsername() {
        if (username == null) {
            return "johnD";
        }
        return username;
    }
    public String getAge() {
        if (age == null) {
            return "23";
        }
        return age;
    }
    public String getHeight() {
        if (height == null) {
        return "5ft 8in";
        }
        return height;
    }
    public String getWeight() {
        if (weight == null) {
            return "145lbs";
        }
        return weight;
    }
    public String getAuthToken() {
        if (authToken == null) {
            return "32324s";
        }
        return authToken;
    }

    // Setters
    public static void setData(Data data) { Data.data = data; }
    public void setName(String name) { name = this.name; }
    public void setUsername(String username) { username = this.username; }
    public void setAge(String age) { age = this.age; }
    public void setHeight(String height) { height = this.height; }
    public void setWeight(String weight) { weight = this.weight; }
    public void setAuthToken(String authToken) { authToken = this.authToken; }
}
