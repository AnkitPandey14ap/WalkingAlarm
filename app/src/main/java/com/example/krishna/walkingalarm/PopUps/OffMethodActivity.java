package com.example.krishna.walkingalarm.PopUps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.krishna.walkingalarm.R;

public class OffMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off_method);


        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.x = -100;
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
//        params.y = -50;

        this.getWindow().setAttributes(params);




    }
}
