package com.example.krishna.walkingalarm.DataPackage;

import java.util.ArrayList;

/**
 * Created by krishna on 17/8/17.
 */

public class AlarmData {
    String time;
    ArrayList<String> days = new ArrayList<>();
    String ringtonePath;
    String Lable;
    String offMethod;
    boolean vibrate;
    boolean status=false;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public void setDays(ArrayList<String> days) {
        this.days = days;
    }

    public String getRingtonePath() {
        return ringtonePath;
    }

    public void setRingtonePath(String ringtonePath) {
        this.ringtonePath = ringtonePath;
    }

    public String getLable() {
        return Lable;
    }

    public void setLable(String lable) {
        Lable = lable;
    }

    public String getOffMethod() {
        return offMethod;
    }

    public void setOffMethod(String offMethod) {
        this.offMethod = offMethod;
    }

    public boolean isVibrate() {
        return vibrate;
    }

    public void setVibrate(boolean vibrate) {
        this.vibrate = vibrate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public AlarmData(String time, ArrayList<String> days, String ringtonePath, String lable, String offMethod, boolean vibrate, boolean status) {
        this.time = time;
        this.days = days;
        this.ringtonePath = ringtonePath;
        Lable = lable;
        this.offMethod = offMethod;
        this.vibrate = vibrate;
        this.status = status;
    }

    public AlarmData() {

    }
}
