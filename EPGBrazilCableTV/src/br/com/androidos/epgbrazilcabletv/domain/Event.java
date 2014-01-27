package br.com.androidos.epgbrazilcabletv.domain;

import java.sql.Timestamp;
import br.com.androidos.epgbrazilcabletv.enums.Channel;
import br.com.androidos.epgbrazilcabletv.enums.Type;

public abstract class Event {

	private Channel channel;
	private Type type;
	private Integer duration;
	private Timestamp starting;
	private Timestamp ending;

	public Event(Channel channel, Type type, Integer duration,
			Timestamp starting, Timestamp ending) {
		super();
		this.channel = channel;
		this.type = type;
		this.duration = duration;
		this.starting = starting;
		this.ending = ending;
	}

	public Channel getChannel() {
		return channel;
	}

	public Integer getDuration() {
		return duration;
	}

	public Timestamp getStarting() {
		return starting;
	}

	public Timestamp getEnding() {
		return ending;
	}

	public Type getType() {
		return type;
	}
	

}