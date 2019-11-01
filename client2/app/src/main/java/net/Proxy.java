package net;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import Request.UserRegisterRequest;
import Response.UserRegisterResponse;

public class Proxy {

//    public static UserRegisterResponse register(String serverHost, String serverPort, UserRegisterRequest request) {
//
//        try {
//            UserRegisterResponse result;
//
//            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/register");
//
//            HttpURLConnection http = (HttpURLConnection)url.openConnection();
//            http.setRequestMethod("POST");
//            http.setDoOutput(true);
//
//            http.addRequestProperty("Accept", "application/json");
//            http.connect();
//
//            Gson gson  = new Gson();
//            String reqData = gson.toJson(request);
//
//            OutputStream reqBody = http.getOutputStream();
//            writeString(reqData, reqBody);
//            reqBody.close();
//
//            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                InputStreamReader respBody = new InputStreamReader(http.getInputStream());
//                result = gson.fromJson(respBody, LoginRegisterResult.class);
//                return result;
//            }
//            else {
//                System.out.println("ERROR: " + http.getResponseMessage());
//                result = new UserRegisterResponse("authtoken","username","ERROR: " + http.getResponseMessage());
//                return result;
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
