package Request;

import Response.UserRegisterResponse;

/** Request to register a new account*/
public class UserRegisterRequest {
    /** Username for new account*/
    private String username;
    private String user_id;
    /** New password for the new username*/
    private String password;
    /** Age for the new account*/
    private String age;
    /** First name for the new user account*/
    private String first_name;
    /** Last name for the new user account*/
    private String last_name;
    /** User's gender for new user account*/
    private String gender;
    private String height;
    private String current_weight;
    private String goal_weight;

    /**Constructor to set all the new account info
     * @param username The username for the new account
     * @param password The password for the new account
     * @param age The email address for the new account
     * @param firstName First name for the new account
     * @param lastName Last name for the new account
     * @param gender Gender for the new account
     */
    public UserRegisterRequest(String userID, String username, String password, String age, String height_foot, String height_inch, String current_weight, String goal_weight,String firstName, String lastName, String gender) {
        this.user_id = userID;
        this.username = username;
        this.password = password;
        this.age = age;
        this.height = height_foot;
        this.current_weight = current_weight;
        this.goal_weight = goal_weight;
        this.first_name = firstName;
        this.last_name = lastName;
        this.gender = gender;
    }
    public UserRegisterRequest() {

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCurrent_weight() {
        return current_weight;
    }

    public void setCurrent_weight(String current_weight) {
        this.current_weight = current_weight;
    }

    public String getGoal_weight() {
        return goal_weight;
    }

    public void setGoal_weight(String goal_weight) {
        this.goal_weight = goal_weight;
    }
}
