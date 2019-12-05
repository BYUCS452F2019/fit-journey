package com.example.client.Response;
/** Response for user login requirement*/
public class UserLoginResponse {
    /** user's authToken*/
    private String authToken;
    /** user's username*/
    private String userName;
    /** user's person ID*/
    private String personID;
    /**Throw a message if an error occurs*/
    private String message;
    /** Default constructor to set all the user's login response info*/
    public UserLoginResponse() {
    }

    /** Constructor to set all the login response info
     * @param authToken Unique auth token for the user
     * @param username The username of the user
     * @param personID The personID of the user
     * @param message Error handler
     */
    public UserLoginResponse(String authToken, String username, String personID, String message) {
        this.authToken = authToken;
        this.userName = username;
        this.personID = personID;
        this.message = message;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
