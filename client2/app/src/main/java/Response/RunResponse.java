package Response;

import Request.RunRequest;

public class RunResponse {
    private String authToken;
    private String username;
    private String runID;
    private String distance;
    private String startTime;
    private String endTime;
    private String message;
    public RunResponse() {
    }

    public RunResponse(String authToken, String username, String message) {
        this.authToken = authToken;
        this.username =username;
        this.message = message;
    }

    public RunResponse(String authToken, String username, String runID, String distance, String startTime, String endTime, String message) {
        this.authToken = authToken;
        this.username = username;
        this.runID = runID;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
        this.message = message;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRunID() {
        return runID;
    }

    public void setRunID(String personID) {
        this.runID = runID;
    }

    public String getDistance() { return distance; }

    public void setDistance(String distance) { this.distance = distance; }

    public String getStartTime() { return startTime; }

    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }

    public void setEndTime(String endTime) {  this.endTime = endTime; }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
