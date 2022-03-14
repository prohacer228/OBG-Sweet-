package com.project.grazproject.mapkitdemo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.project.grazproject.R;

public class MainActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main);
    }
}
