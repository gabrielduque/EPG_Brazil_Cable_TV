package br.com.androidos.epgbrazilcabletv.domain;

import java.sql.Timestamp;
import br.com.androidos.epgbrazilcabletv.enums.Channel;
import br.com.androidos.epgbrazilcabletv.enums.Type;

public class TVSerie extends Event{

	public TVSerie(Channel channel, Type type, Integer duration,
			Timestamp starting, Timestamp ending) {
		super(channel, type, duration, starting, ending);
		// TODO Auto-generated constructor stub
	}

}
