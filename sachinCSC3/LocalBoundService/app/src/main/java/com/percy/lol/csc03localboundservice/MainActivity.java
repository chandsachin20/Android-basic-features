package com.percy.lol.csc03localboundservice;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    MyService s;
    ServiceConnection sc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sc = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MyService.MyBinder m = (MyService.MyBinder)iBinder;
                s=m.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName){
                s=null;
            }
        };


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Activity Service",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, sc, BIND_AUTO_CREATE);
    }

    public void buttonclick(View view){


        String msg = s.onbutton();
        Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show();
        TextView textView=findViewById(R.id.textView);
        textView.setText(msg.toString());
    }

}
