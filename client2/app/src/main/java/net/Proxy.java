package net;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.TreeMap;

import Model.Data;
import Model.Tracks;
import Request.RunRequest;
import Request.UserLoginRequest;
import Request.UserRegisterRequest;
import Response.RunResponse;
import Response.UserLoginResponse;
import Response.UserRegisterResponse;


public class Proxy {

//    public static UserRegisterResponse register(String serverHost, String serverPort, UserRegisterRequest request) {
//
//        try {
//            UserRegisterResponse result;
//
//            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/" + request.getUserName());
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
//                result = gson.fromJson(respBody, UserRegisterResponse.class);
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
//
//    public static UserLoginResponse login(String serverHost, String serverPort, UserLoginRequest request) {
//
//        try {
//            UserLoginResponse result;
//
//            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/" + request.getUsername());
//
//            HttpURLConnection http = (HttpURLConnection)url.openConnection();
//            http.setRequestMethod("POST");
//            http.setDoOutput(true);
//
//            http.addRequestProperty("Accept", "application/json");
//            http.connect();
//
//            Gson gson = new Gson();
//            String reqData = gson.toJson(request);
//
//            OutputStream reqBody = http.getOutputStream();
//            writeString(reqData, reqBody);
//            reqBody.close();
//
//            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                InputStreamReader respBody = new InputStreamReader(http.getInputStream());
//                result = gson.fromJson(respBody, UserLoginResponse.class);
//                System.out.println(result);
//                return result;
//            }
//            else {
//                System.out.println("ERROR: " + http.getResponseMessage());
//                result = new UserLoginResponse("authtoken", "username", "personID", "ERROR: " + http.getResponseMessage());
//                return result;
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void GetRuns(String serverHost, String serverPort) {
//
//        try {
//            RunResponse result;
//
//            URL url = new URL("http://" + serverHost + ":" + serverPort + "/run");
//
//            HttpURLConnection http = (HttpURLConnection)url.openConnection();
//            http.setRequestMethod("GET");
//            http.setDoOutput(false);
//
//            Data data = Data.getData();
//            http.addRequestProperty("Authorization", data.getAuthToken());
//            http.addRequestProperty("Accept", "application/json");
//            http.connect();
//
//            Gson gson = new Gson();
//
//            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                InputStreamReader respBody = new InputStreamReader(http.getInputStream());
//                result = gson.fromJson(respBody, RunResponse.class);
//
//                ArrayList<Tracks> history = result.getHistory();
//                data.setTrackHistory(history);
//            }
//            else {
//                System.out.println("ERROR: " + http.getResponseMessage());
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    private static void writeString(String str, OutputStream os) throws IOException {
//        OutputStreamWriter sw = new OutputStreamWriter(os);
//        sw.write(str);
//        sw.flush();
//    }
}
