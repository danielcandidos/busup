package com.example.busup2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class LocalOverlay extends Overlay{
	
	private GeoPoint geopoint;
	private int cor;
	private Paint paint;
	
	
	
	public LocalOverlay (GeoPoint geopoint, int cor) {
		this.geopoint = geopoint;
		this.cor = cor;
	}
	
	public void draw (Canvas canvas, MapView mapview, boolean shadow) {
		
		super.draw (canvas, mapview, shadow);
		
		if (geopoint != null) {
			
			paint.setColor(cor);
			
			//converter latitude e logintude do ponto para pixels.
			Point point = mapview.getProjection().toPixels(geopoint, null);
			
			//desenhando círculo na tela
			canvas.drawCircle(point.x, point.y, 6, paint);
		}
	}
	

	
}