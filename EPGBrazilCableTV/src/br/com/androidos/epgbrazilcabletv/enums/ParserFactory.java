package br.com.androidos.epgbrazilcabletv.enums;

import java.util.HashMap;
import java.util.Map;
import br.com.androidos.epgbrazilcabletv.application.JsonToEventParser;
import br.com.androidos.epgbrazilcabletv.application.Parser;
import br.com.androidos.epgbrazilcabletv.domain.Event;

public enum ParserFactory {
	INSTANCE;

	private Map<Key, Parser<?, ?>> parsers;

	private ParserFactory() {
		parsers = new HashMap<Key, Parser<?, ?>>();
		parsers.put(new Key(String.class, Event.class), new JsonToEventParser());
	}

	public static ParserFactory getInstance() {
		return INSTANCE;
	}

	@SuppressWarnings("unchecked")
	public <F, T> Parser<F, T> getConverter(Class<F> fromType, Class<T> toType) {
		return (Parser<F, T>) parsers.get(new Key(fromType, toType));
	}

	private class Key {
		private Object class1;
		private Object class2;

		public Key(Object class1, Object class2) {
			this.class1 = class1;
			this.class2 = class2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((class1 == null) ? 0 : class1.hashCode());
			result = prime * result + ((class2 == null) ? 0 : class2.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj){
				return true;
			}
			
			if (obj == null){
				return false;
			}
			
			if (getClass() != obj.getClass()){
				return false;
			}
			
			Key other = (Key) obj;
			
			if (!getOuterType().equals(other.getOuterType())){
				return false;
			}
			
			if (class1 == null) {
				if (other.class1 != null)
					return false;
			} else if (!class1.equals(other.class1)){
				return false;
			}
			
			if (class2 == null) {
				if (other.class2 != null){
					return false;
				}
				
			} else if (!class2.equals(other.class2)){
				return false;
				
			}
			
			return true;
		}

		private ParserFactory getOuterType() {
			return ParserFactory.this;
		}

	}

}