package com.google.firebase.udacity.friendlychat;

import android.content.Intent;

/**
 * Created by Toshiba on 11/30/2017.
 */

public class Subject {
    private String name;
    private Intent intentToLaunch;


    public Subject(String name){
        this.name=name;
        this.intentToLaunch=null;
    }

    public Subject(String name, Intent intentToLaunch) {
        this.name = name;
        this.intentToLaunch = intentToLaunch;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intent getIntentToLaunch() {
        return intentToLaunch;
    }

    public void setIntentToLaunch(Intent intentToLaunch) {
        this.intentToLaunch = intentToLaunch;
    }
}
