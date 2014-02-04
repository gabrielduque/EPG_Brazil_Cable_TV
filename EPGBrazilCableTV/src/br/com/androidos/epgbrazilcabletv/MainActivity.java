package br.com.androidos.epgbrazilcabletv;

import br.com.androidos.epgbrazilcabletv.application.GetJsonTVShow;

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
	        
	        /*AsyncHttpClient client = new AsyncHttpClient();
	        RequestParams params = new RequestParams();
	        params.put("cep", "60823005");
	        params.put("formato", "json");
	        
	        
	        client.get("http://cep.republicavirtual.com.br/web_cep.php", params, new AsyncHttpResponseHandler() {
	            @Override
	            public void onSuccess(String response) {
	            	Log.d("CEP Web Services Response", response);
	            }
	        });*/
	        
	        //http://programacao.netcombo.com.br/gatekeeper/exibicao/select?q=id_cidade:96&callback=callbackShows&json.wrf=callbackShows&wt=json&rows=100000&sort=id_canal+asc%2Cdh_inicio+asc&fl=dh_fim+dh_inicio+st_titulo+titulo+id_programa+id_canal&fq=dh_inicio:[2014-02-04T00:30:00Z TO 2014-02-04T23:59:00Z] dh_fim:[2014-02-04T00:31:00Z TO 2014-02-05T00:00:00Z]
	        
	        /*AsyncHttpClient client = new AsyncHttpClient();
	        RequestParams params = new RequestParams();	        
	        
	        String httpGET = "http://programacao.netcombo.com.br/gatekeeper/exibicao/select?q=id_cidade:96&callback=callbackShows&json.wrf=callbackShows&wt=json&rows=100000&sort=id_canal+asc%2Cdh_inicio+asc&fl=dh_fim+dh_inicio+st_titulo+titulo+id_programa+id_canal&fq=dh_inicio:[2014-02-04T00:30:00Z TO 2014-02-04T23:59:00Z] dh_fim:[2014-02-04T00:31:00Z TO 2014-02-05T00:00:00Z]";
	        
	        client.get(httpGET, params, new AsyncHttpResponseHandler() {
	            @Override
	            public void onSuccess(String response) {
	            	Log.d("Json Response", response);
	            }
	        });*/
	        
	        GetJsonTVShow teste = new GetJsonTVShow(); 
	        
	        
	        
	        if(!teste.getJsonResponse().isEmpty()){
	        	Log.d("Json Result : ",teste.getJsonResponse());
	        }else{
	        	Log.d("Json Result : ","NO RESULTS!");
	        }
	        
	        
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
