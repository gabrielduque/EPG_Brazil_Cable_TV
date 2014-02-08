package br.com.androidos.epgbrazilcabletv.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import br.com.androidos.epgbrazilcabletv.exception.MissingConnectivityException;
import com.google.inject.Inject;
import com.google.inject.Singleton;


@Singleton
public class ApplicationConnectivityManager {
	private static final String DEFAULT_ERROR_MESSAGE = "No internet connection available!";
	
	@Inject
	private Context context;
	
	public void checkConnectivity(){
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		checkConnectionType(connectivityManager.getActiveNetworkInfo());
	}
	
	private void checkConnectionType(NetworkInfo activeNetwork){
		if (null != activeNetwork) {
			if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                Log.d("WiFi Connection Status => ", activeNetwork.getDetailedState().toString());
			}
			
            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
            	Log.d("Mobile Connection Status => ", activeNetwork.getDetailedState().toString());
            }
			
		} else {
			throw new MissingConnectivityException(DEFAULT_ERROR_MESSAGE);
		}
	}

}