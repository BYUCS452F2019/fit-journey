package Response;

import java.util.ArrayList;
        import Model.RunModel;

public class AddRunResponse {
    private String user_id;
    private String message;

    public AddRunResponse() { }

    public AddRunResponse(String authToken, String userName, ArrayList<RunModel> history, String message) {
        this.user_id = user_id;
        this.message = message;
    }

    // Getters
    public String getUser_id() { return user_id; }
    public String getMessage() { return message; }

    // Setters
    public void setUser_id(String user_id) { this.user_id = user_id; }
    public void setMessage(String message) { this.message = message; }

}
