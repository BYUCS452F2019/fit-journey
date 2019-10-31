package Model;

import Response.UserLoginResponse;
import Response.UserRegisterResponse;


public class LoginModel {
    private static LoginModel model;
    private String authtoken;
    private String rootPersonID;
    private UserLoginResponse loginResult;
    private UserRegisterResponse registerResult;

    private String serverHost;
    private String serverPort;

    // constructor is private
    private LoginModel() {

    }

    //returns the instance of the Model
    public static LoginModel getModel() {
        if (model == null) {
            model = new LoginModel();
        }
        return model;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public UserLoginResponse getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(UserLoginResponse loginResult) {
        this.loginResult = loginResult;
    }

    public UserRegisterResponse getRegisterResult() {
        return registerResult;
    }

    public void setRegisterResult(UserRegisterResponse registerResult) {
        this.registerResult = registerResult;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }
}
