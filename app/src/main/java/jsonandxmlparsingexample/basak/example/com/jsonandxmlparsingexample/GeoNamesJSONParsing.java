package jsonandxmlparsingexample.basak.example.com.jsonandxmlparsingexample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by basak on 17.06.2017.
 */

public class GeoNamesJSONParsing extends AsyncTask<Void, Void, Boolean> {

    private Activity activity;

    private Context context;

    private ProgressDialog progressDialog;

    private JSONObject rootJsonObject;

    private List<GeoNames> geoNamesList;

    public GeoNamesJSONParsing(Activity activity) {
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
    protected Boolean doInBackground(Void... params) {

        try {

            URL url = new URL("http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=webservices1");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));


            StringBuffer json = new StringBuffer(1024);
            String tmp = "";

            while ((tmp = bufferedReader.readLine()) != null)
                json.append(tmp).append("\n");
            bufferedReader.close();

            httpURLConnection.disconnect();

            rootJsonObject = new JSONObject(json.toString());

            Log.e("LIST", rootJsonObject.toString());

        } catch (Exception e) {
            Log.e("Exeption", e.getMessage());
            return null;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Boolean success) {

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();

            if (rootJsonObject != null) {

                geoNamesList = new ArrayList<>();

                try {
                    JSONArray jsonArray = rootJsonObject.getJSONArray("geonames");

                    Log.e("Array", jsonArray.toString());

                    for (int i = 0; i < jsonArray.length(); i++) {

                        geoNamesList.add(new GeoNames(
                                jsonArray.getJSONObject(i).getString("toponymName"),
                                jsonArray.getJSONObject(i).getString("name"),
                                Double.parseDouble(jsonArray.getJSONObject(i).getString("lat")),
                                Double.parseDouble(jsonArray.getJSONObject(i).getString("lng")),
                                Integer.parseInt(jsonArray.getJSONObject(i).getString("geonameId")),
                                jsonArray.getJSONObject(i).getString("countrycode"),
                                Integer.parseInt(jsonArray.getJSONObject(i).getString("population")),
                                jsonArray.getJSONObject(i).getString("fcl"),
                                jsonArray.getJSONObject(i).getString("fcode")));

                    }

                    GeoNamesAdapter geoNamesAdapter = new GeoNamesAdapter(activity, geoNamesList);

                    ParseAndListActivity.listViewParse.setAdapter(geoNamesAdapter);

                } catch (JSONException e) {
                    Log.e("Exception", e.getMessage());
                }
            }
        }

        return;
    }

}
