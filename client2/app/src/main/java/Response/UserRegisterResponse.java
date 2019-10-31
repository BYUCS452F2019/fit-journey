package Response;
/** Response for register requirements*/
public class UserRegisterResponse {
    /** user's auth token*/
    private String authToken;
    /** user's username*/
    private String userName;
    /** user's person ID*/
    private String personID;
    /** Throw a message if an error occurs*/
    private String message;
    /** Default constructor to set register response info*/
    public UserRegisterResponse() {
    }

    /** Constructor to set register response info
     * @param authToken Unique auth token for the user
     * @param username Username of the user
     * @param message Error handler
     */
    public UserRegisterResponse(String authToken, String username, String message) {
        this.authToken = authToken;
        this.userName = username;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
