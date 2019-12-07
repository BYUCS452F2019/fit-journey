package com.example.client2;

import Adopter.TrackAdopter;
import Model.Data;
import Model.RunModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RunsHistoryActivity extends AppCompatActivity {

    private TextView name;
    private Data data = Data.getData();
    private RecyclerView trackerRecyclerView;
    private TrackAdopter trackAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runs_history);

        name = findViewById(R.id.track_name);
        name.setText(data.getName());

        trackerRecyclerView = (RecyclerView) findViewById(R.id.tracker_recycler_view);
        trackerRecyclerView.setHasFixedSize(true);
        trackerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        trackerRecyclerView.setVisibility(View.VISIBLE);

        updateTrackerUI();
    }

    private void updateTrackerUI() {
        ArrayList<RunModel> history = data.getRunsHistory();

        if(history != null) {
            trackAdopter = new TrackAdopter(history);
            trackerRecyclerView.setAdapter(trackAdopter);
        }
    }
}
