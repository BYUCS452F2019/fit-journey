package com.example.client2;

import Adopter.TrackAdopter;
import Model.Data;
import Model.Tracks;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TrackerActivity extends AppCompatActivity {

    private TextView name;
    private Data data = Data.getData();
    private RecyclerView trackerRecyclerView;
    private TrackAdopter trackAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        name = findViewById(R.id.track_name);
        name.setText(data.getName());

        trackerRecyclerView = (RecyclerView) findViewById(R.id.tracker_recycler_view);
        trackerRecyclerView.setHasFixedSize(true);
        trackerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        trackerRecyclerView.setVisibility(View.GONE);

        updateTrackerUI();
    }

    private void updateTrackerUI() {
        ArrayList<Tracks> history = data.getTrackHistory();

        if(history != null) {
            trackAdopter = new TrackAdopter(history);
            trackerRecyclerView.setAdapter(trackAdopter);
        }
    }
}
