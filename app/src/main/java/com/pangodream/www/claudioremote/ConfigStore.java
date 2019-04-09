package com.pangodream.www.claudioremote;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ConfigStore {
    Context context = null;
    public ConfigStore(Context parContext){
        context = parContext;
    }

    public void setHostIP(String hostIP){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("host_ip", hostIP);
        editor.commit();
    }
    public String getHostIP(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String hostIP = prefs.getString("host_ip", "0.0.0.0");
        return hostIP;
    }
    public void setHostPort(String hostPort){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("host_port", hostPort);
        editor.commit();
    }
    public String getHostPort(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String hostPort = prefs.getString("host_port", "1234");
        return hostPort;
    }
}