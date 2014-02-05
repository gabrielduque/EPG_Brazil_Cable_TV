package br.com.androidos.epgbrazilcabletv;

import roboguice.activity.RoboActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import br.com.androidos.epgbrazilcabletv.application.HttpClientListener;
import br.com.androidos.epgbrazilcabletv.application.NETHttpClient;
import com.google.inject.Inject;

public class MainActivity extends RoboActivity implements HttpClientListener{
	
	@Inject
	private NETHttpClient netHttpClient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        netHttpClient.register(this);
	        netHttpClient.updateTvProgramming();
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void update() {
		Log.d("MainActivity - NET TV Programming => ", netHttpClient.getUpdate().toString());
		
	}

}
