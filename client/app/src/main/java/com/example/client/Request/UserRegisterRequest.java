package com.example.client.Request;
/** Request to register a new account*/
public class UserRegisterRequest {
    /** Username for new account*/
    private String userName;
    /** New password for the new username*/
    private String password;
    /** Age for the new account*/
    private String age;
    /** First name for the new user account*/
    private String firstName;
    /** Last name for the new user account*/
    private String lastName;
    /** User's gender for new user account*/
    private String gender;
    private String height_foot;
    private String height_inch;
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
    public UserRegisterRequest(String username, String password, String age, String height_foot, String height_inch, String current_weight, String goal_weight,String firstName, String lastName, String gender) {
        this.userName = username;
        this.password = password;
        this.age = age;
        this.height_foot = height_foot;
        this.height_inch = height_inch;
        this.current_weight = current_weight;
        this.goal_weight = goal_weight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight_foot() {
        return height_foot;
    }

    public void setHeight_foot(String height_foot) {
        this.height_foot = height_foot;
    }

    public String getHeight_inch() {
        return height_inch;
    }

    public void setHeight_inch(String height_inch) {
        this.height_inch = height_inch;
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

    /** Default constructor to set account info*/
    public UserRegisterRequest(){
        userName = null;
        password = null;
        age = null;
        height_inch = null;
        height_foot = null;
        current_weight = null;
        goal_weight = null;

        firstName = null;
        lastName = null;
        gender = null;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
