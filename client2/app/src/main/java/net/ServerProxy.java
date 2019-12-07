package net;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import Model.FoodItemsModel;
import Model.MealModel;
import Request.AddFoodRequest;
import Request.AddMealRequest;
import Request.UserLoginRequest;
import Request.UserRegisterRequest;
import Response.AddFoodResponse;
import Response.AddMealResponse;
import Response.GetListFoodsResponse;
import Response.GetListMealsResponse;
import Response.UserLoginResponse;
import Response.UserRegisterResponse;

public class ServerProxy {
    private String serverHost = "192.168.253.105";
    private String serverPort = "5000";

    public ServerProxy(){

    }

    public UserLoginResponse login(UserLoginRequest loginRequest) {

        UserLoginResponse loginResult = new UserLoginResponse();
        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/login");

            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.connect();

            Gson gson = new Gson();
            String reqData = gson.toJson(loginRequest);

            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                System.out.print("here in the sever");
                loginResult = gson.fromJson(respData, UserLoginResponse.class);

            }
            else {
                loginResult.setMessage(null);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return loginResult;
    }

    public UserRegisterResponse register(String userID, UserRegisterRequest registerRequest) {

        UserRegisterResponse registerResult = new UserRegisterResponse();

        try {

            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/" + userID);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.addRequestProperty("Accept", "application/json");

            http.connect();

            Gson gson = new Gson();
            String reqData = gson.toJson(registerRequest);
            System.out.println(reqData);
            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {

                System.out.println("Got here");
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                registerResult = gson.fromJson(respData, UserRegisterResponse.class);

            }
            else {
                registerResult.setMessage(null);
                System.out.println("null");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return registerResult;
    }


    public AddFoodResponse addFood(String foodID, AddFoodRequest addFoodRequest){
        AddFoodResponse addFoodResponse = new AddFoodResponse();

        try {

            URL url = new URL("http://" + serverHost + ":" + serverPort + "/food_item/" + foodID);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.addRequestProperty("Accept", "application/json");

            http.connect();

            Gson gson = new Gson();
            String reqData = gson.toJson(addFoodRequest);
            System.out.println(reqData);
            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {

                System.out.println("Got here");
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                addFoodResponse = gson.fromJson(respData, AddFoodResponse.class);

            }
            else {
                addFoodResponse.setMessage(null);
                System.out.println("null");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return addFoodResponse;
    }


    public AddMealResponse addMeal(String mealID, AddMealRequest addMealRequest){
        AddMealResponse addMealResponse = new AddMealResponse();

        try {

            URL url = new URL("http://" + serverHost + ":" + serverPort + "/meal/" + mealID);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.addRequestProperty("Accept", "application/json");

            http.connect();

            Gson gson = new Gson();
            String reqData = gson.toJson(addMealRequest);
            System.out.println(reqData);
            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {

                System.out.println("Got here");
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                addMealResponse = gson.fromJson(respData, AddMealResponse.class);

            }
            else {
                addMealResponse.setMessage(null);
                System.out.println("null");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return addMealResponse;
    }

    public GetListMealsResponse getMeals(String userID) {
        GetListMealsResponse mealsResponse = new GetListMealsResponse();
        try {
            //TODO: unknown URL
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/meal");

            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("GET");
            http.setDoOutput(false);

            http.addRequestProperty("Accept", "application/json");/////

            http.connect();

            Gson gson = new Gson();
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                mealsResponse = gson.fromJson(respData, GetListMealsResponse.class);
                if(mealsResponse.getMessage() != null){
                    return mealsResponse;
                }
                List<MealModel> mealsArray = gson.fromJson(respData, GetListMealsResponse.class).getListMeals();

                MealModel.getModel().setMeals(mealsArray);
                return mealsResponse;
            }
            else {
                mealsResponse.setMessage(null);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return mealsResponse;
    }

    public GetListFoodsResponse getFoods(String mealID) {
        GetListFoodsResponse foodsResponse = new GetListFoodsResponse();
        try {
            //TODO: unknown url
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/person");

            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("GET");
            http.setDoOutput(false);

            http.addRequestProperty("Accept", "application/json");/////

            http.connect();

            Gson gson = new Gson();
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                foodsResponse = gson.fromJson(respData, GetListFoodsResponse.class);
                if(foodsResponse.getMessage() != null){
                    return foodsResponse;
                }
                List<FoodItemsModel> foodsArray = gson.fromJson(respData, GetListFoodsResponse.class).getListMeals();
                FoodItemsModel model = FoodItemsModel.getModel();
                model.setListFoods(foodsArray);
                return foodsResponse;
            }
            else {
                foodsResponse.setMessage(null);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return foodsResponse;
    }

    private String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] string = new char[1024];
        int len;
        while ((len = sr.read(string)) > 0) {
            sb.append(string, 0, len);
        }
        return sb.toString();
    }

    /*
        The writeString method shows how to write a String to an OutputStream.
    */
    private void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }

}
