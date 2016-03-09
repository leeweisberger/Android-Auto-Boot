package com.example.leeweisberger.boot;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

import java.util.Properties;

/**
 * Created by leeweisberger on 2/12/16.
 */
public class WifiUtil {


    public static final String WIFI_INFORMATION = "WifiInformation.properties";
    public static final String SSID_KEY = "SSID";
    public static final String PASSWORD_KEY = "password";

    public static void connectToWifi(Context context){
        turnOnWifi(context);
        String[] wifiInfo = getWifiInformation(context);
        String networkSSID = wifiInfo[0];
        String networkPass = wifiInfo[1];
//        KioskUtil.showToast(context, networkSSID);
//        KioskUtil.showToast(context, networkPass);

        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" + networkSSID + "\"";   // Please note the quotes. String should contain ssid in quotes
        conf.preSharedKey = "\""+ networkPass +"\"";
        WifiManager wifiManager = (WifiManager)context.getSystemService(context.WIFI_SERVICE);
        int netId = wifiManager.addNetwork(conf);
        wifiManager.disconnect();
        wifiManager.enableNetwork(netId, true);
        wifiManager.reconnect();

    }

    private static String[] getWifiInformation(Context context) {
        PropertiesFileReader propReader = new PropertiesFileReader(context);
        Properties p = propReader.getProperties(WIFI_INFORMATION);
        String[] wifiInfo = new String[2];
        wifiInfo[0] = p.getProperty(SSID_KEY);
        wifiInfo[1] = p.getProperty(PASSWORD_KEY);
        return wifiInfo;
    }

    private static void turnOnWifi(Context context){
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
    }
}
