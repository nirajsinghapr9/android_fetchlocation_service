package com.example.someshwara_assignment;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);

    @Test
    public void testGPS() {
        MainActivity activity = rule.getActivity();
        LocationManager lm = (LocationManager) activity
                .getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy( Criteria.ACCURACY_COARSE );
        String provider = lm.getBestProvider( criteria, true );

        if ( provider == null ) {
            Log.e( "TAG", "No location provider found!" );
            return;
        }

        Location lastLocation = lm.getLastKnownLocation(provider);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}