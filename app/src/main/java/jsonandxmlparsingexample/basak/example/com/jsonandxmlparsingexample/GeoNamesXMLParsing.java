package jsonandxmlparsingexample.basak.example.com.jsonandxmlparsingexample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by basak on 17.06.2017.
 */

public class GeoNamesXMLParsing extends AsyncTask<Void, Void, Boolean> {

    private Activity activity;

    private Context context;

    private ProgressDialog progressDialog;

    private Document document;

    public List<GeoNames> geoNamesList;

    public GeoNamesXMLParsing(Activity activity) {
        this.activity = activity;
        context = activity;
        this.progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        this.progressDialog.setMessage("Değerler Yükleniyor...");
        this.progressDialog.show();
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setCancelable(false);
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        try {
            document = Jsoup.connect("http://api.geonames.org/cities?north=44.1&south=-9.9&east=-22.4&west=55.2&username=webservices1").get();

            Log.e("DOCUMENT", document.text());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Boolean success) {

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();

            geoNamesList = new ArrayList<>();

            int id = 0;

            for (int i = 0; i < document.getElementsByTag("geoname").size(); i++) {

                id = i + 1;
                GeoNames geoNames = new GeoNames(
                        document.getElementsByTag("toponymName").get(i).text(),
                        document.getElementsByTag("name").get(i).text(),
                        Double.parseDouble(document.getElementsByTag("lat").get(i).text()),
                        Double.parseDouble(document.getElementsByTag("lng").get(i).text()),
                        Integer.parseInt(document.getElementsByTag("geonameId").get(i).text()),
                        document.getElementsByTag("countryCode").get(i).text(),
                        document.getElementsByTag("countryName").get(i).text(),
                        document.getElementsByTag("fcl").get(i).text(),
                        document.getElementsByTag("fcode").get(i).text());

                geoNamesList.add(geoNames);

            }

            GeoNamesAdapter geoNamesAdapter = new GeoNamesAdapter(activity, geoNamesList);

            ParseAndListActivity.listViewParse.setAdapter(geoNamesAdapter);


        }

    }
}
