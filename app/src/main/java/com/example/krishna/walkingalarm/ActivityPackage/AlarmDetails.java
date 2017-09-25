package com.example.krishna.walkingalarm.ActivityPackage;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.krishna.walkingalarm.PopUps.OffMethodActivity;
import com.example.krishna.walkingalarm.PopUps.RepeatDays;
import com.example.krishna.walkingalarm.R;

import java.util.ArrayList;
import java.util.Calendar;

public class AlarmDetails extends AppCompatActivity {

    private static final String TAG = "ANKIT";
    LinearLayout timeLinearLayout;
    LinearLayout repeatLinearLayout;
    LinearLayout ringtoneLinearLayout;
    LinearLayout offMethodLinearLayout;
    LinearLayout vibrateLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_details);

        timeLinearLayout = (LinearLayout) findViewById(R.id.timeLinearLayout);
        repeatLinearLayout = (LinearLayout) findViewById(R.id.repeatLinearLayout);
        ringtoneLinearLayout = (LinearLayout) findViewById(R.id.ringtoneLinearLayout);
        offMethodLinearLayout = (LinearLayout) findViewById(R.id.offMethodLinearLayout);
        vibrateLinearLayout = (LinearLayout) findViewById(R.id.vibrateLinearLayout);


        timeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime();
            }
        });

        repeatLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmDetails.this, RepeatDays.class);

                startActivityForResult(intent,1);
                //startActivity(new Intent(AlarmDetails.this, RepeatDays.class));
            }
        });
        offMethodLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlarmDetails.this, OffMethodActivity.class));
            }
        });





    }



    public void setTime() {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        final int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(AlarmDetails.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String hour = String.valueOf(selectedHour);
                String minutes= String.valueOf(selectedMinute);
                if(selectedHour<10) {
                    hour = "0" + selectedHour;
                }if(selectedMinute<0) {
                    minutes = "0" + selectedMinute;
                }

            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(this, "return ok", Toast.LENGTH_SHORT).show();
                ArrayList<String> daysList = new ArrayList<>();
                daysList = data.getStringArrayListExtra("DAYS");
                Log.i(TAG, "onActivityResult: "+daysList.size());
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "return canceled", Toast.LENGTH_SHORT).show();

                //Write your code if there's no result
            }
        }
    }

}
