package net;

        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.URL;

        import Request.RunRequest;
        import Request.UserLoginRequest;
        import Request.UserRegisterRequest;
        import Response.RunResponse;
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
//    public static UserRegisterResponse login(String serverHost, String serverPort, UserLoginRequest request) {
//
//        try {
//            UserRegisterResponse result;
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
//                result = gson.fromJson(respBody, UserRegisterResponse.class);
//                System.out.println(result);
//                return result;
//            }
//            else {
//                System.out.println("ERROR: " + http.getResponseMessage());
//                result = new UserRegisterResponse("authtoken", "username", "ERROR: " + http.getResponseMessage());
//                return result;
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static RunResponse run(String serverHost, String serverPort, RunRequest request) {
//
//        try {
//            RunResponse result;
//
//            URL url = new URL("http://" + serverHost + ":" + serverPort + "/run/" + request.getRunID());
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
//                result = gson.fromJson(respBody, UserRegisterResponse.class);
//                System.out.println(result);
//                return result;
//            }
//            else {
//                System.out.println("ERROR: " + http.getResponseMessage());
//                result = new RunResponse("authtoken", "username", "ERROR: " + http.getResponseMessage());
//                return result;
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private static void writeString(String str, OutputStream os) throws IOException {
//        OutputStreamWriter sw = new OutputStreamWriter(os);
//        sw.write(str);
//        sw.flush();
//    }
}
