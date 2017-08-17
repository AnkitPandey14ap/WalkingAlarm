package com.example.krishna.walkingalarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by krishna pandey on 22-07-2017.
 */

class MyCustomAdapter extends BaseAdapter implements ListAdapter {

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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_alarm_view, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.timeTextView);
        TextView timeLeftTextView = (TextView) view.findViewById(R.id.timeLeftTextView);
        ImageView imageView = (ImageView) view.findViewById(R.id.circleImageView);

        textView.setText(alarmList.get(position));


        //imageView.setImageResource(Integer.parseInt(iconList.get(position)));



        return view;
    }
}
