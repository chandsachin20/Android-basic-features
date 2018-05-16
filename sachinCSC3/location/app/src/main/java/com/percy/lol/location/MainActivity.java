package com.percy.lol.location;

import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView V = findViewById(R.id.v1);
        V.setVideoURI(Uri.parse("andriod.resource://"+getPackageName()+"/"+R.raw.aa));

        MediaController m = new MediaController(this);
        m.setAnchorView(V);
        m.setMediaPlayer(V);
        V.setMediaController(m);
        V.start();
    }
}
