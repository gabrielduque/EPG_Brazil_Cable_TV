package br.com.androidos.epgbrazilcabletv.domain;

import java.sql.Timestamp;
import br.com.androidos.epgbrazilcabletv.enums.Channel;
import br.com.androidos.epgbrazilcabletv.enums.Type;

public class Movie extends Event implements Observable{
	
	private Cast cast;

	public Movie(Channel channel, Type type, Integer duration,
			Timestamp starting, Timestamp ending, Cast cast) {
		super(channel, type, duration, starting, ending);
		this.cast = cast;
		
	}
	
	
	public Cast getCast() {
		return cast;
	}
	
}
