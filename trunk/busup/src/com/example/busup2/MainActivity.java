package com.example.busup2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	ImageButton btComentar, btLocalizar, btfeed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		btComentar = (ImageButton) findViewById(R.id.btcomentar);
		btLocalizar = (ImageButton) findViewById(R.id.btlocalizar);
		btfeed = (ImageButton) findViewById(R.id.btfeed);
		
		btComentar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamarComentar ();
				
			}
		});
		
		btLocalizar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamarLocalizar ();
				
			}
		});
		
		btfeed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamarFeed();
				
			}
		});
	}
	
	
	public void chamarLocalizar () {
		Intent intent = new Intent (this, MapaActivity.class);
		startActivity(intent);
		
	}
	
	public void chamarComentar () {
		Intent intent = new Intent (this, FacebookActivity.class);
		startActivity(intent);
		
	}
	
	public void chamarFeed () {
		Intent intent = new Intent (this, FeedActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
