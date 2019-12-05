package com.example.client.Model;


import com.example.client.Response.UserLoginResponse;
import com.example.client.Response.UserRegisterResponse;


public class ClientModel {
    private static ClientModel model;
    private String authToken;
    private String rootPersonID;
    private UserLoginResponse loginResult;
    private UserRegisterResponse registerResult;

    private ClientModel() {

    }
    public static ClientModel getModel() {
        if (model == null) {
            model = new ClientModel();
        }
        return model;
    }

    //model for login and register
    public void setLoginResult(UserLoginResponse loginResult) {
        this.loginResult = loginResult;
    }
    public void setRegisterResult(UserRegisterResponse registerResult) { this.registerResult = registerResult; }
    public String getAuthToken() {
        return authToken;
    }
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
