package br.com.androidos.epgbrazilcabletv.application;

import br.com.androidos.epgbrazilcabletv.domain.Event;

public interface EventParser {
	
	Event parse(String xmlTv);

}
