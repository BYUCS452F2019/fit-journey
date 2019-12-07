package Response;
/** Response for register requirements*/
public class UserRegisterResponse {
    /** user's auth token*/
    private String user_id;
    /** user's username*/
    private String username;
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
        this.user_id = userID;
        this.username = username;
        this.message = message;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
