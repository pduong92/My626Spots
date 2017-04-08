package com.example.phduo.my626spots;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DessertsActivity extends AppCompatActivity {

    private ArrayList<Location> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        locations = new ArrayList<Location>();

        TypedArray dessertList = getResources().obtainTypedArray(R.array.desserts);
        String[] dessert;
        int resID;

        for(int i = 0; i < dessertList.length(); i++) {
            resID = dessertList.getResourceId(i, -1);
            if(resID < 0)
                continue;
            else {
                dessert = getResources().getStringArray(resID);
                locations.add(new Location(dessert[0],
                        dessert[1],
                        dessert[2],
                        dessert[3],
                        dessert[4],
                        dessert[5]));
            }
        }

        LocationAdapter listadapter = new LocationAdapter(DessertsActivity.this, locations);

        ListView listview = (ListView)findViewById(R.id.activity_desserts);
        listview.setAdapter(listadapter);
    }
}
