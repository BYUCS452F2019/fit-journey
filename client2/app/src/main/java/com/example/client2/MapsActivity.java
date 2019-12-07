package com.example.client2;

import Model.Data;
import Request.AddRunRequest;
import Response.AddRunResponse;
import androidx.fragment.app.FragmentActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import net.ServerProxy;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Chronometer chronometer;
    private boolean isStart;
    private String user_id;
    Calendar calendar;
    String start_time;
    String end_time;
    SimpleDateFormat simpleDateFormat;
    TextView tv_start;
    TextView tv_end;
    long lStart;
    long lEnd;
    long lElapsed;
    Data data = Data.getData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        user_id = data.getUser_id();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        tv_start = (TextView) findViewById(R.id.timer_start);
        tv_end = (TextView) findViewById(R.id.timer_end);

        chronometer = findViewById(R.id.chronometer);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });
    }

    public void startChronometer(View view){
        if(isStart) {
            chronometer.stop();
            isStart = false;
            ((Button)view).setText("Start");

            calendar = Calendar.getInstance();
            lEnd = new Date().getTime();
            lElapsed = lEnd - lStart;
            simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            end_time = simpleDateFormat.format(calendar.getTime());
            tv_end.setText("End Time: " + end_time);

            // TODO: Use this function to save data temporariliy
//            storeTimer(start_time, end_time, lElapsed);
            RunRequestAsyncTask runRequestAsyncTask = new RunRequestAsyncTask();
            runRequestAsyncTask.execute();
        } else{
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            isStart = true;
            ((Button)view).setText("Stop");

            calendar = Calendar.getInstance();
            lStart = new Date().getTime();
            simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            start_time = simpleDateFormat.format(calendar.getTime());
            tv_start.setText("Start Time: " + start_time);
        }
    }



//    public void storeTimer(String start_time, String end_time, long lElapsed) {
//        RunModel track = new RunModel();
//        track.setRun_id(UUID.randomUUID().toString());
//        track.setStart_time(start_time);
//        track.setEnd_time(end_time);
//        track.setDistance(0);
//        track.setCalories_burned(0);
//        track.setPace(0);
//
//        data.getRunsHistory().add(track);
//    }

    private class RunRequestAsyncTask extends AsyncTask<Void, String, AddRunResponse> {
        @Override
        protected AddRunResponse doInBackground(Void... voids) {
            System.out.println("I am here");
            UUID run_id = UUID.randomUUID();
            AddRunRequest addRunRequest = new AddRunRequest(run_id.toString(), user_id, 0, start_time, end_time, 0, 0, "Unknown");
            publishProgress("Adding a new run");

            ServerProxy serverProxy = new ServerProxy();
            return serverProxy.addRun(run_id.toString(),addRunRequest);
        }
        @Override
        protected void onProgressUpdate(String... toast) {
            Toast.makeText(MapsActivity.this, toast[0], Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onPostExecute (AddRunResponse runResponse){
            try {
                if (runResponse.getUser_id() == null) {
                    Toast.makeText(MapsActivity.this, runResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
