package com.example.busup2;

import java.util.ArrayList;

import org.w3c.dom.Document;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.MapController;
import com.google.android.gms.location.LocationClient;


 

public class MapaActivity extends FragmentActivity {
	  private LatLng location = new LatLng(-7.850833, -35.254722);
	  private LatLng location2 = new LatLng(-8.053889, -34.881111);
	  private LatLng location3 = new LatLng(-7.896667, -35.179722);
	  private GoogleMap map;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_mapa);
	    
	    //mapController = map.getController;
        
      //  map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
	 
	    map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
	    
	    map.addMarker(new MarkerOptions().
	    		icon(BitmapDescriptorFactory.
	    	    fromResource(R.drawable.onibus19x24)).
	    	    anchor(0.0f, 1.0f).title("Carpina City").
	    	    position(location).snippet("Zona da Mata Norte"));
	    
	    map.addMarker(new MarkerOptions().
	    		icon(BitmapDescriptorFactory.
	    				fromResource(R.drawable.onibus19x24)).
	    				position(location2).title("Recife").snippet("Região Metropolitana"));
	    
	    map.addMarker(new MarkerOptions().
	    		icon(BitmapDescriptorFactory.
	    				fromResource(R.drawable.onibus19x24)).
	    				position(location3).title("Paudalho").snippet("Zona da Mata Norte"));
	    

      /*  CameraPosition cameraPosition = CameraPosition.builder()
                .target(location2)
                .zoom(13)
                .bearing(90)
                .build();
        
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                2000, null);*/
	    
	    map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 20));
	    
	    map.animateCamera(CameraUpdateFactory.zoomTo(10),2000, null);
	    
	    // map.setOnMyLocationButtonClickListener();
	    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	    map.setMyLocationEnabled(true);
	    map.getUiSettings().setRotateGesturesEnabled(true);
	  /*  GMapV2Direction md = new GMapV2Direction();
	    
	    Document doc = md.getDocument(location, location2, GMapV2Direction.MODE_DRIVING);
	    ArrayList<LatLng> directionPoint = md.getDirection(doc);
	    PolylineOptions rectLine = new PolylineOptions().width(3).color(Color.RED);

	    for(int i = 0 ; i < directionPoint.size() ; i++) {          
	    rectLine.add(directionPoint.get(i));
	    }

	    map.addPolyline(rectLine);*/
	    
	    

	  }
	  @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.mapa, menu);
	    return true;
	  }
	 
	}