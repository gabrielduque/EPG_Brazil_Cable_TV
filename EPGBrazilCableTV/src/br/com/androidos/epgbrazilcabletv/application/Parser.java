package br.com.androidos.epgbrazilcabletv.application;


public interface Parser <FROM,TO>{
	
	TO convert ( FROM aFromObject );
	
	String getName();

}
