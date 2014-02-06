package br.com.androidos.epgbrazilcabletv.application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.inject.Singleton;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

@Singleton
public class NETHttpClient implements HttpClientEventNotifier{
	private String jsonResponse = "NO DATA";
	private Map<String,Object> requestParams;
	private static final int DEFAULT_REQUEST_TIMEOUT = 20000;
	private AsyncHttpClient client;
	private List<HttpClientListener> listenersList;
	private boolean hasReceivedReponse;

	public NETHttpClient(){
		this.requestParams = new HashMap<String, Object>();
		this.client = new AsyncHttpClient();
		this.client.setTimeout(DEFAULT_REQUEST_TIMEOUT);
		this.listenersList = new ArrayList<HttpClientListener>();
		hasReceivedReponse = false;
	}
	
    public void updateTvProgramming(){
    	hasReceivedReponse = false;
        RequestParams params = new RequestParams();		
        		
        /*String dh_inicio = "2014-02-04T00:30:00Z TO 2014-02-04T23:59:00Z";
        
        String dh_fim = "2014-02-04T00:31:00Z TO 2014-02-05T00:00:00Z";*/
        
        String dh_inicio = GenerateActualDate.dh_inicio;
        
        String dh_fim = GenerateActualDate.dh_fim;
        
        String httpGET = "http://programacao.netcombo.com.br/gatekeeper/exibicao/select?q=id_cidade:96&callback=callbackShows&json.wrf=callbackShows&wt=json&rows=100000&sort=id_canal+asc%2Cdh_inicio+asc&fl=dh_fim+dh_inicio+st_titulo+titulo+id_programa+id_canal&fq=dh_inicio:["+dh_inicio+"] dh_fim:["+dh_fim+"]";
        
    	this.client.get(httpGET, params, new AsyncHttpResponseHandler() {
           
    		@Override
            public void onSuccess(String response) {
    			hasReceivedReponse = true;
    			jsonResponse = response;
    			notifyListener();
            }
    		
        });
    	
    }
    
    public void setRequestParams(Map<String, Object> requestParams) {
		this.requestParams = requestParams;
	}

	@Override
	public void register(HttpClientListener httpClientListener) {
		this.listenersList.add(httpClientListener);
		
	}

	@Override
	public void notifyListener() {
		if (hasReceivedReponse) {
			for (HttpClientListener httpClientListener : listenersList) {
				httpClientListener.update();
			}
		}
	}

	@Override
	public void unRegister(HttpClientListener httpClientListener) {
		this.listenersList.remove(httpClientListener);
		
	}

	@Override
	public Object getUpdate() {
		Object changedState = null;
		if (hasReceivedReponse) {
			changedState = jsonResponse;
		}
		return changedState;
	}
	
	public static class GenerateActualDate{
			
	        private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        
	        private static Date date1 = new Date();
	        
	        private static Date date2 = new Date(date1.getTime()+(24*60*60*1000));
	        
	        public static String dh_inicio = String.format("%sT00:30:00Z TO %sT23:59:00Z", dateFormat.format(date1),dateFormat.format(date1));
	     
	        public static String dh_fim =    String.format("%sT00:31:00Z TO %sT00:00:00Z", dateFormat.format(date1),dateFormat.format(date2));

			public static String getDh_inicio() {
				return dh_inicio;
			}

			public static String getDh_fim() {
				return dh_fim;
			}
	        
	}

}