package ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.client2.HomeActivity;
import com.example.client2.MainActivity;
import com.example.client2.R;
import com.example.client2.TimerActivity;

import Model.LoginModel;
import Request.UserLoginRequest;
import Request.UserRegisterRequest;
import Response.UserLoginResponse;
import Response.UserRegisterResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class LoginFragment extends Fragment {

    private EditText userNameText;
    private EditText passwordText;
    private EditText firstNameText;
    private EditText lastNameText;
    private EditText ageText;
    private EditText heightFootText;
    private EditText heightInchText;
    private EditText currentWeightText;
    private EditText goalWeightText;
    private RadioButton femaleText;
    private RadioButton maleText;
    private static Button signinText;
    private static Button registerText;

    private MainActivity mainActivity;

    private String host = "";
    private String port = "";
    private String userName = "";
    private String password = "";
    private String firstName= "";
    private String lastName = "";
    private String age = "";
    private String height_foot = "";
    private String height_inch = "";
    private String current_weight = "";
    private String goal_weight = "";
    private String gender = "";

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        userNameText = (EditText) v.findViewById(R.id.userName);
        passwordText = (EditText) v.findViewById(R.id.password);
        firstNameText = (EditText) v.findViewById(R.id.firstName);
        lastNameText = (EditText) v.findViewById(R.id.lastName);
        ageText = (EditText) v.findViewById(R.id.age);
        heightFootText = (EditText) v.findViewById(R.id.height_foot);
        heightInchText = (EditText) v.findViewById(R.id.height_inch);
        currentWeightText = (EditText) v.findViewById(R.id.current_weight);
        goalWeightText = (EditText) v.findViewById(R.id.goal_weight);
        maleText = (RadioButton) v.findViewById(R.id.male);
        femaleText = (RadioButton) v.findViewById(R.id.female);
        signinText = (Button) v.findViewById(R.id.signIn);
        registerText = (Button) v.findViewById(R.id.register);

        registerText.setEnabled(false);
        signinText.setEnabled(false);
        gender = "m";
        //public void beforeTextChanged()

        userNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
                checkSigninButton();

            }
        });
        passwordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
                checkSigninButton();
            }
        });
        firstNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                firstName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
            }
        });

        lastNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lastName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
            }
        });

        ageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                age = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
            }
        });

        heightFootText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                height_foot = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
            }
        });

        heightInchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                height_inch = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
            }
        });

        currentWeightText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                current_weight = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
            }
        });

        goalWeightText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                goal_weight = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRegisterButton();
            }
        });

        femaleText.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gender = "f";
                }
            }
        });

        maleText.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gender = "m";
                }
            }
        });

        signinText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switch to timer
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);

//                Intent intent = new Intent();
//                intent.setClass(getActivity(), TimerActivity2.class);
//                getActivity().startActivity(intent);
//                LoginAsyncTask loginTask = new LoginAsyncTask();
//                loginTask.execute();
            }
        });
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switch to timer
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
//                RegisterAsyncTask registerTask = new RegisterAsyncTask();
//                registerTask.execute();
            }
        });


        return v;
    }
    protected void checkSigninButton(){
        if(userNameText.getText().toString().equals("") || passwordText.getText().toString().equals("")){
            signinText.setEnabled(false);
        }
        else{
            signinText.setEnabled(true);
        }

    }
    protected void checkRegisterButton(){
        if(userNameText.getText().toString().equals("") || passwordText.getText().toString().equals("") || firstNameText.getText().toString().equals("")
                || lastNameText.getText().toString().equals("") || ageText.getText().toString().equals("")|| heightFootText.getText().toString().equals("")
                || heightInchText.getText().toString().equals("")|| currentWeightText.getText().toString().equals("")|| goalWeightText.getText().toString().equals("")){
            registerText.setEnabled(false);
        }
        else{
            registerText.setEnabled(true);
        }
    }

    private class LoginAsyncTask extends AsyncTask<Void, String, UserLoginResponse> {
        @Override
        protected UserLoginResponse doInBackground (Void... voids){
            UserLoginRequest loginRequest = new UserLoginRequest();
            loginRequest.setPassword(password);
            loginRequest.setUsername(userName);

            publishProgress("Logging in...");

//            ServerProxy serverProxy = new ServerProxy();
//            return serverProxy.login(host, port, loginRequest);
            return null;
        }
        @Override
        protected void onProgressUpdate(String... toast) {
            Toast.makeText(getContext(), toast[0], Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onPostExecute (UserLoginResponse loginResponses){
            try {
                if (loginResponses.getAuthToken() == null) {
                    Toast.makeText(getContext(), loginResponses.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else{
                    LoginModel model = LoginModel.getModel();

                    model.setLoginResult(loginResponses);
                    model.setAuthtoken(loginResponses.getAuthToken());

                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private class RegisterAsyncTask extends AsyncTask <Void, String, UserRegisterResponse> {
        @Override
        protected UserRegisterResponse doInBackground(Void... voids) {
            System.out.println("I am here");
            UserRegisterRequest registerRequest = new UserRegisterRequest();
            registerRequest.setUsername(userName);
            registerRequest.setPassword(password);
            registerRequest.setFirstName(firstName);
            registerRequest.setLastName(lastName);
            registerRequest.setAge(age);
            registerRequest.setHeight_foot(height_foot);
            registerRequest.setHeight_inch(height_inch);
            registerRequest.setCurrent_weight(current_weight);
            registerRequest.setGoal_weight(goal_weight);
            registerRequest.setGender(gender);

            publishProgress("Register a new user...");

//            ServerProxy serverProxy = new ServerProxy();
//            return serverProxy.register(host, port, registerRequest);
            return null;
        }
        @Override
        protected void onProgressUpdate(String... toast){
            System.out.println(toast[0]);
            Toast.makeText(getContext(), toast[0], Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onPostExecute(UserRegisterResponse registerResponse){
            if(registerResponse.getAuthToken()==null){
                Toast.makeText(getContext(), registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
            else{
                LoginModel model = LoginModel.getModel();
                model.setRegisterResult(registerResponse);
                model.setAuthtoken(registerResponse.getAuthToken());
                model.setServerHost(host);
                model.setServerPort(port);

            }
        }

    }



}
