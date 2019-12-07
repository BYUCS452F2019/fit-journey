package Response;
/** Response for register requirements*/
public class UserRegisterResponse {
    /** user's auth token*/
    private String userID;
    /** user's username*/
    private String userName;
    /** Throw a message if an error occurs*/
    private String message;
    /** Default constructor to set register response info*/
    public UserRegisterResponse() {
    }

    /** Constructor to set register response info
     * @param userID Unique auth token for the user
     * @param username Username of the user
     * @param message Error handler
     */
    public UserRegisterResponse(String userID, String username, String message) {
        this.userID = userID;
        this.userName = username;
        this.message = message;
    }

    // Getters
    public String getAuthToken() {
        return userID;
    }
    public String getUsername() { return userName; }
    public String getMessage() { return message; }

    // Setters
    public void setUsername(String username) { this.userName = username; }
    public void setAuthToken(String authToken) { this.userID = authToken; }
    public void setMessage(String message) {
        this.message = message;
    }
}
