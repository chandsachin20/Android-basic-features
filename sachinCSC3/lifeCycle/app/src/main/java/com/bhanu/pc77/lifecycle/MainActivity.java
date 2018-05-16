package com.bhanu.pc77.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onResume() {
        super.onResume();
        Log.d("Resumed","App has Resumed");
    }

    protected void onPause() {
        super.onPause();
        Log.d("Pause","App has Paused");
    }
    protected void onRestart() {
        super.onRestart();
        Log.d("ReStart","App has Restarted");
    }
    protected void onStart() {
        super.onStart();
        Log.d("Start","App has Started");
    }
    protected void onStop() {
        super.onStop();
        Log.d("Stop","App stopped");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroyed","App has Destroyed");
    }
}
