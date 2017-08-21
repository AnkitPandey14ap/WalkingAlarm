package com.example.krishna.walkingalarm.ActivityPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.krishna.walkingalarm.PopUps.RepeatDays;
import com.example.krishna.walkingalarm.R;

public class AlarmDetails extends AppCompatActivity {

    LinearLayout repeatLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_details);

        repeatLinearLayout = (LinearLayout) findViewById(R.id.repeatLinearLayout);
        repeatLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlarmDetails.this, RepeatDays.class));
            }
        });


    }

}
