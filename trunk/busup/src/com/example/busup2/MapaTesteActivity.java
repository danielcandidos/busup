package com.example.busup2;

import android.os.Bundle;
import android.view.Menu;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


 

public class MapaTesteActivity extends MapActivity {
	private MapView mapa;
    private MapController controleMapa;
	 
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_mapa_teste);
	
        mapa = (MapView) findViewById(R.id.MapaTeste);
        
        controleMapa = mapa.getController();
        double latitude = -7.850833;
        double longitude = 35.254722;
        
        GeoPoint geoPoint = new GeoPoint(
        		            (int) (latitude * 1E6), 
        		            (int) (longitude * 1E6));
	    controleMapa.animateTo(geoPoint);
	    controleMapa.setZoom(18); 
	  
	  }
	  @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.mapa_teste, menu);
	    return true;
	  }
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	 
	}