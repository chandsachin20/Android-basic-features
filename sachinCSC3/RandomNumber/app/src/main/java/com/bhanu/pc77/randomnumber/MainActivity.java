package com.bhanu.pc77.randomnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int a=new Random().nextInt(10);
    public void onClick(View view){

        int b;
        EditText e=(EditText)findViewById(R.id.editText);
        b=Integer.parseInt(e.getText().toString());
        TextView t1=(TextView)findViewById(R.id.textView2);
        TextView t2=(TextView)findViewById(R.id.textView3);

        if(a<b){
            t1.setText("Enter small number..."+a );
        }
        else if(a>b){
            t1.setText("Enter large number..."+a);
        } else {
            t1.setText("You found The number..."+a);

        }

    }
}
