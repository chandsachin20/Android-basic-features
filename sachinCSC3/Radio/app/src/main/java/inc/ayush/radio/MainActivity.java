package inc.ayush.radio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public RadioButton r;
    public RadioGroup RG;
    public Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RG = (RadioGroup) findViewById(R.id.r);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select = RG.getCheckedRadioButtonId();
                r = (RadioButton) findViewById(select);
                TextView t = findViewById(R.id.textView2);
                t.setText(r.getText().toString());
            }


        });
    }}
