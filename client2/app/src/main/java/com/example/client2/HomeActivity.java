package com.example.client2;

import Model.Data;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Data data = Data.getData();
        Button timerButton = findViewById(R.id.home_timer);
        Button trackerButton = findViewById(R.id.home_tracker);
        TextView homeName = findViewById(R.id.home_name);
        TextView homeAge = findViewById(R.id.home_age);
        TextView homeWeight = findViewById(R.id.home_weight);
        TextView homeHeight = findViewById(R.id.home_height);

        homeName.setText(data.getName());
        homeAge.setText(data.getAge());
        homeWeight.setText(data.getWeight());
        homeHeight.setText(data.getHeight());

        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        trackerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TrackerActivity.class);
                startActivity(intent);
            }
        });
    }
}
