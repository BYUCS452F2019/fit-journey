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
}
