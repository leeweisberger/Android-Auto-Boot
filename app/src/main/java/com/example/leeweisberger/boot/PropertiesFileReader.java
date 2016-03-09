package com.example.leeweisberger.boot;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by leeweisberger on 2/12/16.
 */
public class PropertiesFileReader {
    private Context context;
    private Properties properties;

    public PropertiesFileReader(Context context) {
        this.context = context;
        properties = new Properties();
    }

    public Properties getProperties(String FileName) {

        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(FileName);
            properties.load(inputStream);

        } catch (IOException e) {
            Log.e("AssetsPropertyReader", e.toString());
        }
        return properties;

    }

}
