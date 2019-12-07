package Response;
/** Response for user login requirement*/
public class UserLoginResponse {
    /** user's authToken*/
    private String user_id;
    /** user's username*/
    private String username;
    /**Throw a message if an error occurs*/
    private String message;
    /** Default constructor to set all the user's login response info*/
    public UserLoginResponse() {
    }

    /** Constructor to set all the login response info
     * @param user_id Unique auth token for the user
     * @param username The username of the user
     * @param message Error handler
     */
    public UserLoginResponse(String user_id, String username, String message) {
        this.user_id = user_id;
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
