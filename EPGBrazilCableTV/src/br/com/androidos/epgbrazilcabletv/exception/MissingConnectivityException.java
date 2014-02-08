package br.com.androidos.epgbrazilcabletv.exception;

public class MissingConnectivityException extends EPGBrazilCableTVException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 123670854593082945L;
	
	public MissingConnectivityException(String message) {
		super(message);
	}
	
	public MissingConnectivityException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
