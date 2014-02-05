package br.com.androidos.epgbrazilcabletv.application;

import br.com.androidos.epgbrazilcabletv.domain.Event;

public class JsonToEventParser implements Parser<String, Event>{
	
	private String name;
	
	public JsonToEventParser(){
		 this.name = JsonToEventParser.class.getSimpleName(); 
	}

	@Override
	public Event convert(String jsonAsString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
