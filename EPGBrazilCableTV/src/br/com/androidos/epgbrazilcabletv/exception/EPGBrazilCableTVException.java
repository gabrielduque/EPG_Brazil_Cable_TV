package br.com.androidos.epgbrazilcabletv.exception;


public class EPGBrazilCableTVException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 208021036528719247L;
	
	public EPGBrazilCableTVException(String message) {
		super(message);
	}
	
	public EPGBrazilCableTVException(String message, Throwable throwable) {
		super(message, throwable);
	}

}