package com.async.httpokreq;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String uri="https://reqres.in/api/users?page=2";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.listView);
        OkHttpClient client= new OkHttpClient();
        Request.Builder reqBuilder= new Request.Builder();
        Request req=reqBuilder.url(uri).build();
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resp=response.body().string();
                final ArrayList<String> names= new ArrayList<>();
                final ArrayList<Uri> images=new ArrayList<>();
                try{
                    JSONObject obj= new JSONObject(resp);
                    JSONArray users= obj.getJSONArray("data");
                    for(int i=0;i<users.length();i++){
                        JSONObject j= users.getJSONObject(i);
                        String name=j.getString("first_name");
                        Uri uri= Uri.parse(j.getString("avatar"));
                        names.add(name);
                        images.add(uri);
                        Log.d("msg2",name+uri.toString());
                    }

                    Log.d("msg2","done");
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            CustomAdapter customAdapter= new CustomAdapter(getApplicationContext(),images,names);
                            listView.setAdapter(customAdapter);
                        }
                    });
                }
                catch(JSONException je){}
            }
        });
    }
}