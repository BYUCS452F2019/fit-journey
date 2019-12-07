package Response;

import java.util.ArrayList;

import Model.RunModel;

public class GetRunsHistoryResponse {

    private String message;
    private ArrayList<RunModel> runHistory;

    public GetRunsHistoryResponse() { }

    public GetRunsHistoryResponse(ArrayList<RunModel> runHistory, String message) {
        this.runHistory = runHistory;
        this.message = message;
    }

    // Getters
    public ArrayList<RunModel> getRunHistory() { return runHistory; }
    public String getMessage() { return message; }

    // Setters
    public void setRunHistory(ArrayList<RunModel> runHistory) { this.runHistory = runHistory; }
    public void setMessage(String message) { this.message = message; }
}

