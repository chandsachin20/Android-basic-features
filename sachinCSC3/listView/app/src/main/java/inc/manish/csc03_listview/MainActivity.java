package inc.manish.csc03_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import inc.manish.csc03_listview.R;

public class MainActivity extends AppCompatActivity {

    String[] array = {"A","B","C"};
    ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView l=(ListView)findViewById(R.id.a);
        aa=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,array);
        l.setAdapter(aa);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String s=aa.getItem(position);


                Toast.makeText(MainActivity.this,"item selected"+aa.getItem(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
