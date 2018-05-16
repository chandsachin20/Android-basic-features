package com.async.cscdbdrivenapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Databasehelper mydb;
    EditText name,last,course;
    Button addbttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new Databasehelper(this);

    name= findViewById(R.id.edt1);
    last=findViewById(R.id.edt2);
    course=findViewById(R.id.edt3);
    addbttn=(Button)findViewById(R.id.addbttn);
    adddata();

    }
    public void adddata(){
        addbttn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = mydb.insertData(name.getText().toString(),
                           last.getText().toString(),
                            course.getText().toString() );
                    if(isInserted == true)
                        Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
    );


    }
}



