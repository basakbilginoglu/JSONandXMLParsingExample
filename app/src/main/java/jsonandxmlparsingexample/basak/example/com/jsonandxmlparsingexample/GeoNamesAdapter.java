package jsonandxmlparsingexample.basak.example.com.jsonandxmlparsingexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by basak on 17.06.2017.
 */

public class GeoNamesAdapter extends BaseAdapter{

    public LayoutInflater layoutInflater;
    public List<GeoNames> geoNamesList;

    public GeoNamesAdapter(Activity activity, List<GeoNames> geoNamesList) {
        layoutInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.geoNamesList = geoNamesList;
    }

    @Override
    public int getCount() {
        return geoNamesList.size();
    }

    @Override
    public Object getItem(int i) {
        return geoNamesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView;

        rowView = layoutInflater.inflate(R.layout.list_item_row, null);

        TextView toponymName = (TextView) rowView.findViewById(R.id.tvToponymName);
        TextView name = (TextView) rowView.findViewById(R.id.tvName);
        TextView lat = (TextView) rowView.findViewById(R.id.tvLat);
        TextView lng = (TextView) rowView.findViewById(R.id.tvLng);
        TextView geonameId = (TextView) rowView.findViewById(R.id.tvGeonameId);
        TextView countryCode = (TextView) rowView.findViewById(R.id.tvCountryCode);
        TextView populationOrCountryName = (TextView) rowView.findViewById(R.id.tvPopulationOrCountryName);
        TextView fcl = (TextView) rowView.findViewById(R.id.tvFcl);
        TextView fcode = (TextView) rowView.findViewById(R.id.tvFcode);


        toponymName.setText(geoNamesList.get(position).getToponymName());
        name.setText(geoNamesList.get(position).getName());
        lat.setText(String.valueOf(geoNamesList.get(position).getLat()));
        lng.setText(String.valueOf(geoNamesList.get(position).getLng()));
        geonameId.setText(String.valueOf(geoNamesList.get(position).getGeonameId()));
        countryCode.setText(geoNamesList.get(position).getCountryCode());
        fcl.setText(geoNamesList.get(position).getFcl());
        fcode.setText(geoNamesList.get(position).getFcode());

        if (geoNamesList.get(position).getCountryName() != null) {
            populationOrCountryName.setText(geoNamesList.get(position).getCountryName());
        } else {
            populationOrCountryName.setText(String.valueOf(geoNamesList.get(position).getPopulation()));
        }


        return rowView;
    }

}
