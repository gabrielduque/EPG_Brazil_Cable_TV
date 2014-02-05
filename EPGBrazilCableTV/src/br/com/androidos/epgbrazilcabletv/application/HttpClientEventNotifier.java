package br.com.androidos.epgbrazilcabletv.application;

public interface HttpClientEventNotifier {
	
	void register(HttpClientListener httpClientListener);
	 
	void notifyListener();
	
    void unRegister(HttpClientListener httpClientListener);
	 
	Object getUpdate();

}
