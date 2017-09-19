package jsonandxmlparsingexample.basak.example.com.jsonandxmlparsingexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by basak on 17.06.2017.
 */



public class ParseAndListActivity extends AppCompatActivity {

    public static ListView listViewParse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_and_list);

        listViewParse = (ListView) findViewById(R.id.listViewParse);

        String type = getIntent().getExtras().get("Type").toString();

        if (type.equals("JSON")) {

            new GeoNamesJSONParsing(ParseAndListActivity.this).execute();

        } else {

            new GeoNamesXMLParsing(ParseAndListActivity.this).execute();

        }
    }
}
