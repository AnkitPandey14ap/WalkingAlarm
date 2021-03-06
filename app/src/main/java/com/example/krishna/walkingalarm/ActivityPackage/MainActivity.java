package com.example.krishna.walkingalarm.ActivityPackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.krishna.walkingalarm.AdapterPackage.MyCustomAdapter;
import com.example.krishna.walkingalarm.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Ankit";
    private ListView listView;
    private MyCustomAdapter myCustomAdapter;

    private TextView timeTextView;
    private TextView timeLeftTextView;
    private ImageView circleImageView;

    private static ArrayList<String> alarmList = new ArrayList<>();
    private int request =1;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem item = menu.findItem(R.id.action_settings);



        return super.onCreateOptionsMenu(menu);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        getSupportActionBar().setTitle("Alarm");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                alarmList.add("03:35 am");
                saveArray(MainActivity.this);
                myCustomAdapter.notifyDataSetChanged();*/

                Intent intent = new Intent(MainActivity.this, AlarmDetails.class);
                startActivityForResult(intent, request);


            }
        });

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEdit1 = sp.edit();
        mEdit1.clear().commit();






        initialize();

        loadArray(this);


        listView.setAdapter(myCustomAdapter);
        registerForContextMenu(listView);



    }

    private void initialize() {
        listView = (ListView) findViewById(R.id.listView);
        myCustomAdapter = new MyCustomAdapter(this, alarmList);

    }


    public static boolean saveArray(Context context)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor mEdit1 = sp.edit();
    /* alarmList is an array */
        mEdit1.putInt("Status_size", alarmList.size());

        for(int i=0;i<alarmList.size();i++)
        {
            mEdit1.remove("Status_" + i);
            mEdit1.putString("Status_" + i, alarmList.get(i));
        }

        return mEdit1.commit();
    }

    public static void loadArray(Context mContext)
    {
        SharedPreferences mSharedPreference1 =   PreferenceManager.getDefaultSharedPreferences(mContext);
        alarmList.clear();
        int size = mSharedPreference1.getInt("Status_size", 0);

        for(int i=0;i<size;i++)
        {
            alarmList.add(mSharedPreference1.getString("Status_" + i, null));
        }

        alarmList.add("03:10 AM");
        alarmList.add("03:10 AM");
        alarmList.add("03:10 AM");
        alarmList.add("03:10 AM");
    }


}
