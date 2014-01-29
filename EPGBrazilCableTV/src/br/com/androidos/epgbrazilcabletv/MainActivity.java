package br.com.androidos.epgbrazilcabletv;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        AsyncHttpClient client = new AsyncHttpClient();
	        RequestParams params = new RequestParams();
	        params.put("cep", "60823005");
	        params.put("formato", "json");
	        
	        
	        client.get("http://cep.republicavirtual.com.br/web_cep.php", params, new AsyncHttpResponseHandler() {
	            @Override
	            public void onSuccess(String response) {
	            	Log.d("CEP Web Services Response", response);
	            }
	        });
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
