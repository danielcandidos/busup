package com.example.busup2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
 
public class FeedActivity extends Activity {
	
	ImageButton imagem1;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed);
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandableListView1);
		listView.setAdapter(new MeuAdapter(this));
		
		imagem1 = (ImageButton) findViewById(R.id.img1);
	}
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
 
}