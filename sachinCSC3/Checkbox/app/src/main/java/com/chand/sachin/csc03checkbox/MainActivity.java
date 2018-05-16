package com.chand.sachin.csc03checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void  onCheckboxClicked(View view){

        boolean checked = ((CheckBox) view).isChecked();
        TextView textView=findViewById(R.id.textView);
        int id1= R.id.checkBox;
        textView.setText(((CheckBox)view).getText().toString());

       /* switch(view.getId()) {
            case :
                if (checked)
                    textView.setText("Java");
            case R.id.checkBox2:
                if (checked)
                    textView.setText("python");
            case R.id.checkBox3:
                if (checked)
                    textView.setText("python");
            case R.id.checkBox4:
                if (checked)
                    textView.setText("python");
            default:
                 textView.setText("NULL");
                 break;


        }*/

    }
}
