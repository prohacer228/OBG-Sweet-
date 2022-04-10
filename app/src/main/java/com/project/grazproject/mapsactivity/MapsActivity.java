package com.project.grazproject.mapsactivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.project.grazproject.R;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.layers.GeoObjectTapEvent;
import com.yandex.mapkit.layers.GeoObjectTapListener;
import com.yandex.mapkit.layers.ObjectEvent;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.GeoObjectSelectionMetadata;
import com.yandex.mapkit.map.InputListener;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.user_location.UserLocationLayer;
import com.yandex.mapkit.user_location.UserLocationObjectListener;
import com.yandex.mapkit.user_location.UserLocationView;
import com.yandex.runtime.image.ImageProvider;

/**
 * This is a basic example that displays a map and sets camera focus on the target location.
 * Note: When working on your projects, remember to request the required permissions.
 */
public class MapsActivity extends Activity implements UserLocationObjectListener,GeoObjectTapListener, InputListener {

    private final String MAPKIT_API_KEY = "af5de0ac-3857-4839-8579-e57e4f6b8983";
    //private final Point TARGET_LOCATION = new Point(59.945933, 30.320045);
    private final Point TARGET_LOCATION2 = new Point(53.229587, 50.200715);
    private MapView mapView;
    private MapView mapView1;
    private UserLocationLayer userLocationLayer;
    private Button butplus;
    private Button butmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_maps);
        super.onCreate(savedInstanceState);
        mapView = findViewById(R.id.mapview);
        mapView1 = findViewById(R.id.mapview);
        mapView.getMap().setRotateGesturesEnabled(false);
        mapView1.getMap().setRotateGesturesEnabled(true);
        float i= 15;
        mapView.getMap().move(new CameraPosition(new Point(0, 0), 0, 0, 0));
        mapView1.getMap().move(new CameraPosition(new Point(0, 0), 15, 0, 0));
        MapKit mapKit = MapKitFactory.getInstance();
        userLocationLayer = mapKit.createUserLocationLayer(mapView.getMapWindow());
        userLocationLayer.setVisible(true);
        userLocationLayer.setHeadingEnabled(true);
        userLocationLayer.setObjectListener(this);

        mapView.getMap().addTapListener(this);
        mapView.getMap().addInputListener(this);

        butplus = findViewById(R.id.button_plus);
        butmin =  findViewById(R.id.button_minus);

        butplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapView1.getMap().move(new CameraPosition(mapView1.getMap().getCameraPosition().getTarget(),
                                mapView1.getMap().getCameraPosition().getZoom()+1, 0.0f, 0.0f),
                        new Animation(Animation.Type.SMOOTH, 1),
                        null);
            }
        });

        butmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapView1.getMap().move(new CameraPosition(mapView1.getMap().getCameraPosition().getTarget(),
                                mapView1.getMap().getCameraPosition().getZoom()-1, 0.0f, 0.0f),
                        new Animation(Animation.Type.SMOOTH, 1),
                        null);
            }
        });
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
        mapView1.onStart();

    }

    @Override
    public void onObjectAdded(UserLocationView userLocationView) {
        userLocationLayer.setAnchor(
                new PointF((float)(mapView.getWidth() * 0.5), (float)(mapView.getHeight() * 0.5)),
                new PointF((float)(mapView.getWidth() * 0.5), (float)(mapView.getHeight() * 0.83)));
        userLocationView.getArrow().setIcon(ImageProvider.fromResource(
                this, R.drawable.user_arrow));
        userLocationView.getAccuracyCircle().setFillColor(Color.BLUE & 0x99ffffff);

    }

    @Override
    public void onObjectRemoved(UserLocationView view) {
    }

    @Override
    public void onObjectUpdated(UserLocationView view, ObjectEvent event) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    //Тапы на карту
    @Override
    public boolean onObjectTap(@NonNull GeoObjectTapEvent geoObjectTapEvent) {
        final GeoObjectSelectionMetadata selectionMetadata = geoObjectTapEvent
                .getGeoObject()
                .getMetadataContainer()
                .getItem(GeoObjectSelectionMetadata.class);

        if (selectionMetadata != null) {
            mapView.getMap().selectGeoObject(selectionMetadata.getId(), selectionMetadata.getLayerId());
        }

        return selectionMetadata != null;
    }

    @Override
    public void onMapTap(@NonNull Map map, @NonNull Point point) {
        mapView.getMap().deselectGeoObject();
        userLocationLayer.resetAnchor();

    }

    @Override
    public void onMapLongTap(@NonNull Map map, @NonNull Point point) {
//Сюда добавить менюшку с надписью "добавить событие?" и Да Нет, если Да переход на окно составления события

    }
}
