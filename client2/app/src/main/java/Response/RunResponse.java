package Response;

import java.util.ArrayList;
        import Model.Tracks;

public class RunResponse {
    private String authToken;
    private String userName;
    private ArrayList<Tracks> history;
    private String message;

    public RunResponse() { }

    public RunResponse(String authToken, String userName, ArrayList<Tracks> history,  String message) {
        this.authToken = authToken;
        this.userName =userName;
        this.message = message;
        this.history = history;
    }

    // Getters
    public String getAuthToken() {
        return authToken;
    }
    public String getUserName() {
        return userName;
    }
    public String getMessage() { return message; }
    public ArrayList<Tracks> getHistory() { return history; }

    // Setters
    public void setAuthToken(String authToken) { this.authToken = authToken; }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setMessage(String message) { this.message = message; }
    public void setHistory(ArrayList<Tracks> history) { this.history = history; }
}
