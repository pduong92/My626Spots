package com.example.phduo.my626spots;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class CafeActivity extends AppCompatActivity {

    private ArrayList<Location> locations;

    //Testing hours
    private double[][] testHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        testHours = new double[7][2];
        for(int i = 0; i < testHours.length; i++) {
            if(i == 0 || i == 6) {
                testHours[i][0] = 12;
                testHours[i][1] = 20;
            }
            else {
                testHours[i][0] = 9.5;
                testHours[i][1] = 22;
            }
        }

        locations = new ArrayList<Location>();

        URL site = null;
        try{
            site = new URL("http://bonappeteacafe.com/");
        } catch(MalformedURLException e) {
            Log.e("URL Exception", e.getMessage());
        }

        locations.add(new Location("Bon Appetea Cafe",
                                    "7 S 2nd St",
                                    "Alhambra",
                                    "CA",
                                    91801,
                                    "626281226",
                                    testHours,
                                    site,
                                    R.drawable.ic_bon_appeatea_cafe));

        TypedArray cafeList = getResources().obtainTypedArray(R.array.cafes);

        String[] cafe;
        int resID;

        for(int i = 0; i < cafeList.length(); i++) {
            resID = cafeList.getResourceId(i, -1);
            Log.i("CafeList", "item[" + i + "] reID =" + resID);
            if(resID < 0)
                continue;
            else {
                cafe = getResources().getStringArray(resID);
                locations.add(new Location(cafe[0],
                        cafe[1],
                        cafe[2],
                        cafe[3],
                        cafe[4],
                        cafe[5]));

                Log.i("CafeList", "Cafe successfully added.");
            }
        }


/*
        locations.add(new Location("Ladybug Tea House",
                                    "1457 E Valley Blvd",
                                    "Alhambra",
                                    "CA",
                                    91801,
                                    "6263163197"));

        locations.add(new Location("Factory Tea Bar",
                                    "323 S Mission Dr",
                                    "San Gabriel",
                                    "CA",
                                    91776,
                                    "6268722969"));
*/
        LocationAdapter listadapter = new LocationAdapter(CafeActivity.this, locations);

        ListView listview = (ListView)findViewById(R.id.activity_cafe);
        listview.setAdapter(listadapter);

    }
}
