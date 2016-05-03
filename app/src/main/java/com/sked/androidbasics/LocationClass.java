package com.sked.androidbasics;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by verma on 3/31/2016.
 */
public class LocationClass implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {
        if(location != null){
            Log.i("latitude",""+location.getLatitude());
            Log.e("longitude", "" + location.getLongitude());
            /*LocationActivity.lang.append("" + location.getLongitude());
            LocationActivity.lat.append(""+location.getLongitude());*/

        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
