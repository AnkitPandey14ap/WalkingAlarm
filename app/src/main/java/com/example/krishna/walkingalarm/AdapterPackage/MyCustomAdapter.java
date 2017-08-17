package com.example.krishna.walkingalarm.AdapterPackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.krishna.walkingalarm.R;

import java.util.ArrayList;

/**
 * Created by krishna pandey on 22-07-2017.
 */

public class MyCustomAdapter extends BaseAdapter implements ListAdapter {

    private final Context context;
    private final ArrayList<String> alarmList;


    public MyCustomAdapter(Context context, ArrayList<String> alarmList) {
        this.context = context;
        this.alarmList= alarmList;

    }

    @Override
    public int getCount() {
        return alarmList.size();
    }

    @Override
    public Object getItem(int position) {
        return alarmList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_alarm_view, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.timeTextView);
        TextView timeLeftTextView = (TextView) view.findViewById(R.id.timeLeftTextView);
        final ImageView imageView = (ImageView) view.findViewById(R.id.circleImageView);

        textView.setText(alarmList.get(position));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.checked_circle));
                Toast.makeText(context, "clicked "+position, Toast.LENGTH_SHORT).show();
            }
        });

        //imageView.setImageResource(Integer.parseInt(iconList.get(position)));



        return view;
    }
}
