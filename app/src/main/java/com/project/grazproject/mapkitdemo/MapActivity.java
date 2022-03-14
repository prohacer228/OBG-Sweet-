package com.project.grazproject.mapkitdemo;

import android.app.Activity;
import android.os.Bundle;

import com.project.grazproject.R;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

/**
 * This is a basic example that displays a map and sets camera focus on the target location.
 * Note: When working on your projects, remember to request the required permissions.
 */
public class MapActivity extends Activity {
    /**
     * Replace "your_api_key" with a valid developer key.
     * You can get it at the https://developer.tech.yandex.ru/ website.
     */
    private final String MAPKIT_API_KEY = "af5de0ac-3857-4839-8579-e57e4f6b8983";
    //private final Point TARGET_LOCATION = new Point(59.945933, 30.320045);
    private final Point TARGET_LOCATION2 = new Point(53.229587, 50.200715);

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
        * Set the api key before calling initialize on MapKitFactory.
        * It is recommended to set api key in the Application.onCreate method,
        * but here we do it in each activity to make examples isolated.
        */
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        /**
        * Initialize the library to load required native libraries.
        * It is recommended to initialize the MapKit library in the Activity.onCreate method
        * Initializing in the Application.onCreate method may lead to extra calls and increased battery use.
        */
        MapKitFactory.initialize(this);
        // Now MapView can be created.
        setContentView(R.layout.map);
        super.onCreate(savedInstanceState);
        mapView = (MapView)findViewById(R.id.mapview);

        // And to show what can be done with it, we move the camera to the center of Saint Petersburg.
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION2, 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);
    }

    @Override
    protected void onStop() {
        // Activity onStop call must be passed to both MapView and MapKit instance.
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Activity onStart call must be passed to both MapView and MapKit instance.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
}
