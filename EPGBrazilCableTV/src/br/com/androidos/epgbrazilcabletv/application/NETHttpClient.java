package br.com.androidos.epgbrazilcabletv.application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.annotation.SuppressLint;
import br.com.androidos.epgbrazilcabletv.util.HttpRequestDateFormatter;

import com.google.inject.Inject;
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
	@Inject
	private HttpRequestDateFormatter httpRequestDateFormatter;

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
        
        Date initialDate = (Date) new Date().clone();
        httpRequestDateFormatter.setStartingDate(initialDate);
        httpRequestDateFormatter.setEndingDate((Date) new Date(initialDate.getTime()+(24*60*60*1000)).clone());
        
        String startingDate = httpRequestDateFormatter.getStartingDate();
        
        String endingDate = httpRequestDateFormatter.getEndingDate();
        
        String httpGET = "http://programacao.netcombo.com.br/gatekeeper/exibicao/select?q=id_cidade:96&callback=callbackShows&json.wrf=callbackShows&wt=json&rows=100000&sort=id_canal+asc%2Cdh_inicio+asc&fl=dh_fim+dh_inicio+st_titulo+titulo+id_programa+id_canal&fq=dh_inicio:["+startingDate+"] dh_fim:["+endingDate+"]";
        
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
	

}