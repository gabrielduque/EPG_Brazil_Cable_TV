package br.com.androidos.epgbrazilcabletv.application;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class GetJsonTVShow {
	
	AsyncHttpClient client = new AsyncHttpClient();
    RequestParams params = new RequestParams();	        
    
    String jsonResponse = "NO DATA";
    
    String httpGET = "http://programacao.netcombo.com.br/gatekeeper/exibicao/select?q=id_cidade:96&callback=callbackShows&json.wrf=callbackShows&wt=json&rows=100000&sort=id_canal+asc%2Cdh_inicio+asc&fl=dh_fim+dh_inicio+st_titulo+titulo+id_programa+id_canal&fq=dh_inicio:[2014-02-04T00:30:00Z TO 2014-02-04T23:59:00Z] dh_fim:[2014-02-04T00:31:00Z TO 2014-02-05T00:00:00Z]";
    
    public String getJsonResponse(){
    	
    	/*
    		AsyncHttpClient client = new AsyncHttpClient();
			 client.get("http://www.google.com", new ResponseHandlerInterface() {
			     @Override
			     public void onSuccess(String response) {
			         System.out.println(response);
			     }
			 });
    	 */
    	
    	client.get(httpGET, params, new AsyncHttpResponseHandler() {
           
    		@Override
            public void onSuccess(String response) {
            	jsonResponse = response;
            }
    		
        });
    	
    	
    	
    	return jsonResponse;
    	
    }

}
