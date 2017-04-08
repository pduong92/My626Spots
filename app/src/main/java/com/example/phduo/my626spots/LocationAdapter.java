package com.example.phduo.my626spots;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by phduo on 3/12/2017.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Activity content, ArrayList<Location> list) {
        super(content, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View locationView = convertView;
        if(locationView == null) {
            locationView = LayoutInflater.from(getContext()).inflate(R.layout.location_item, parent, false);
        }

        Location location = getItem(position);

        ImageView locationImage = (ImageView)locationView.findViewById(R.id.location_image);
        if(location.hasImage())
            locationImage.setImageResource(location.getImageID());

        TextView locationName = (TextView)locationView.findViewById(R.id.location_name);
        locationName.setText(location.getName());

        TextView locationAddressStreet = (TextView)locationView.findViewById(R.id.location_address_street);
        locationAddressStreet.setText(location.getAddressStreet());

        TextView locationAddressCity = (TextView)locationView.findViewById(R.id.location_address_city);
        locationAddressCity.setText(location.getAddressCity());

        ImageView locationMoreIcon = (ImageView)locationView.findViewById(R.id.location_more_icon);
        locationMoreIcon.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);

        return locationView;
    }
}
