package br.com.androidos.epgbrazilcabletv.application;

public interface HttpClientEvent {
	
	void register(HttpClientListener httpClientListener);
	 
	void notifyListener();
	
    void unRegister(HttpClientListener httpClientListener);
	 
	Object getUpdate();

}
