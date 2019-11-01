package Request;

public class RunRequest {
    private String userName;
    private String runID;

    public RunRequest() {
        userName = null;
        runID = null;
    }

    public RunRequest(String username, String password) {
        this.userName = username;
        this.runID = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getRunID() {
        return runID;
    }

    public void setRunID(String runID) {
        this.runID = runID;
    }
}
