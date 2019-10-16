package com.example.client4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);


        img = (ImageView)findViewById(R.id.button_img);
        txt = (TextView)findViewById(R.id.button_text);

        img.setOnClickListener(new View.OnClickListener() {
            int flag = 1;
            @Override
            public void onClick(View v) {
                if (flag == 1) {
                    img.setImageDrawable(getResources().getDrawable(R.drawable.ic_running));
                    txt.setText("Running");
                    flag = 2;
                }
                else if (flag == 2) {
                    img.setImageDrawable(getResources().getDrawable(R.drawable.ic_paused));
                    txt.setText("Paused");
                    flag = 1;
                }
            }
        });
    }
}
