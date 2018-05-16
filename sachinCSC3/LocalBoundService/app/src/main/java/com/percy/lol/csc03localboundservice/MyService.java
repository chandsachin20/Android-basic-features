package com.percy.lol.csc03localboundservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by pc77 on 4/4/18.
 */

class MyService extends Service{


    public String onbutton() {
        //TextView tv=findViewById()
       Toast.makeText(this,"Loading....;.",Toast.LENGTH_SHORT).show();
        String name="hello";
        return name;
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this ;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return  new MyBinder();
    }
}


