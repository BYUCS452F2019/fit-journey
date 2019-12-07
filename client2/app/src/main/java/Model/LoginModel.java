package Model;

import Response.UserLoginResponse;
import Response.UserRegisterResponse;

public class LoginModel {
    private static LoginModel model;
    private String userID;
    private String rootPersonID;
    private UserLoginResponse loginResult;
    private UserRegisterResponse registerResult;
    private String userName;

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
        return userID;
    }

    public void setAuthtoken(String authtoken) {
        this.userID = authtoken;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
