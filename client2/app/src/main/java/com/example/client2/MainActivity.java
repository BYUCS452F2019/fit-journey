package com.example.client2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ui.LoginFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame_container);

//        Data data = Data.getData();
//        String authToken = data.getAuthToken();
        String authToken = "fake";
//        if(authToken != null){
//            fragment = new MapFragment();
//            fm.beginTransaction()
//                    .add(R.id.frame_container, fragment)
//                    .commit();
//        }
//        if (fragment == null) {
            fragment = new LoginFragment();
            fm.beginTransaction()
                    .add(R.id.frame_container, fragment)
                    .commit();
//        }
    }
}
