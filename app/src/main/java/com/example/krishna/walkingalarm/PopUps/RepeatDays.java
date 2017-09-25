package com.example.krishna.walkingalarm.PopUps;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.krishna.walkingalarm.R;

import java.util.ArrayList;

public class RepeatDays extends AppCompatActivity {


    private static final String TAG = "ANKIT";
    private RelativeLayout mRelativeLayout;
    private ImageView mondayImageView;

    private RelativeLayout tueRelativeLayout;
    private ImageView tueImageView;

    private RelativeLayout wedRelativeLayout;
    private ImageView wedImageView;

    private RelativeLayout thuRelativeLayout;
    private ImageView thuImageView;

    private RelativeLayout friRelativeLayout;
    private ImageView friImageView;

    private RelativeLayout satRelativeLayout;
    private ImageView satImageView;

    private RelativeLayout sunRelativeLayout;
    private ImageView sunImageView;

    private Button okButton;
    private Button cancelButton;

    private ArrayList<String> daysList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_days);


        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.x = -100;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
//        params.y = -50;

        this.getWindow().setAttributes(params);


        //initialise all the variables
        initialize();

        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day="monday";
                selectDay(mRelativeLayout,mondayImageView,day);
            }
        });

        tueRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day="tuesday";
                selectDay(tueRelativeLayout,tueImageView, day);
            }
        });

        wedRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day="wednesday";
                selectDay(wedRelativeLayout,wedImageView, day);
            }
        });

        thuRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day="thursday";
                selectDay(thuRelativeLayout,thuImageView, day);
            }
        });

        friRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day="friday";
                selectDay(friRelativeLayout,friImageView, day);
            }
        });

        satRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day="saturday";
                selectDay(satRelativeLayout,satImageView, day);
            }
        });

        sunRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day="sunday";
                selectDay(sunRelativeLayout,sunImageView, day);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent=new Intent();
                returnIntent.putStringArrayListExtra("DAYS", daysList);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        });


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent=new Intent();
                setResult(Activity.RESULT_CANCELED,returnIntent);
                finish();

            }
        });




    }

    private void selectDay(RelativeLayout mRelativeLayout, ImageView imageView, String day) {

        String imageName = String.valueOf(imageView.getTag());
        if(imageName.equals("on")){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.blank_circle));
            imageView.setTag("off");
            daysList.remove(day);
            Toast.makeText(this, "if"+daysList.size(), Toast.LENGTH_SHORT).show();
            Log.i(TAG, "if: "+ daysList.toString());
        }

        else{
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.checked_circle));
            imageView.setTag("on");
            daysList.add(day);
            Toast.makeText(this, "else"+daysList.size(), Toast.LENGTH_SHORT).show();
            Log.i(TAG, "else: "+ daysList.toString());

        }

    }

    void initialize(){
        mRelativeLayout = (RelativeLayout) findViewById(R.id.mRelativeLayout);
        mondayImageView = (ImageView) findViewById(R.id.mondayImageView);
        mondayImageView.setImageDrawable(getResources().getDrawable(R.drawable.checked_circle));


        tueRelativeLayout= (RelativeLayout) findViewById(R.id.tueRelativeLayout);
        tueImageView = (ImageView) findViewById(R.id.tueImageView);
        tueImageView.setImageDrawable(getResources().getDrawable(R.drawable.checked_circle));


        wedRelativeLayout= (RelativeLayout) findViewById(R.id.wedRelativeLayout);
        wedImageView= (ImageView) findViewById(R.id.wedImageView);
        wedImageView.setImageDrawable(getResources().getDrawable(R.drawable.checked_circle));


        thuRelativeLayout = (RelativeLayout) findViewById(R.id.thuRelativeLayout);
        thuImageView = (ImageView) findViewById(R.id.thuImageView);
        thuImageView.setImageDrawable(getResources().getDrawable(R.drawable.checked_circle));


        friRelativeLayout = (RelativeLayout) findViewById(R.id.friRelativeLayout);
        friImageView = (ImageView) findViewById(R.id.friImageView);
        friImageView.setImageDrawable(getResources().getDrawable(R.drawable.checked_circle));


        satRelativeLayout = (RelativeLayout) findViewById(R.id.satRelativeLayout);
        satImageView = (ImageView) findViewById(R.id.satImageView);
        satImageView.setImageDrawable(getResources().getDrawable(R.drawable.checked_circle));


        sunRelativeLayout = (RelativeLayout) findViewById(R.id.sunRelativeLayout);
        sunImageView= (ImageView) findViewById(R.id.sunImageView);
        sunImageView.setImageDrawable(getResources().getDrawable(R.drawable.checked_circle));

        okButton = (Button) findViewById(R.id.okButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        daysList.add("monday");
        daysList.add("tuesday");
        daysList.add("wednesday");
        daysList.add("thursday");
        daysList.add("friday");
        daysList.add("saturday");
        daysList.add("sunday");
    }
}
