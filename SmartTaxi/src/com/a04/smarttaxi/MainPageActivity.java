package com.a04.smarttaxi;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainPageActivity extends ActionBarActivity {
	
	public void scan (View view){
		Intent intent = new Intent(this, QRCode.class);
		startActivity(intent);
	}
	
	public void viewMyProfile(View view){
		Intent intent = new Intent(this, ProfilePage.class);
		startActivity(intent);
	}
	
	public void viewOffers(View view){
		Intent intent = new Intent(this, ViewOffers.class);
		startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_page);
		Intent intent = getIntent();
		String uname = intent.getStringExtra(MainActivity.USERNAME);
		String pwd = intent.getStringExtra(MainActivity.PASSWORD);
		if (!uname.equals("Bob") && !pwd.equals("bob")){
			Intent redirect = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			this.startActivity(redirect);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
