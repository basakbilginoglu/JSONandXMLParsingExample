package jsonandxmlparsingexample.basak.example.com.jsonandxmlparsingexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by basak on 17.06.2017.
 */

public class MainActivity extends AppCompatActivity {

    private Button btnXML;

    private Button btnJSON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnXML = (Button) findViewById(R.id.btnXML);
        btnJSON = (Button) findViewById(R.id.btnJSON);

        btnXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ParseAndListActivity.class);

                intent.putExtra("Type", "XML");

                startActivity(intent);
            }
        });

        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ParseAndListActivity.class);

                intent.putExtra("Type", "JSON");

                startActivity(intent);
            }
        });


    }
}
