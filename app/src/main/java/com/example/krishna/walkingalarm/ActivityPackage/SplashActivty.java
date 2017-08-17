package com.example.krishna.walkingalarm.ActivityPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.krishna.walkingalarm.R;

public class SplashActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activty);


        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    startActivity(new Intent(SplashActivty.this,MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

    }
}
