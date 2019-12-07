package Request;
/** Request user log in*/
public class UserLoginRequest {
    /** User's username for the user*/
    private String userName;
    /** User account password*/
    private String password;
    /**Default Constructor to set username and password*/
    public UserLoginRequest() {
        userName = null;
        password = null;
    }

    /** Constructor to set username and password to the current username and password
     * @param username the user's username
     * @param password the user's password for the username
     */
    public UserLoginRequest(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) { this.userName = username; }
    public void setPassword(String password) { this.password = password; }
}
