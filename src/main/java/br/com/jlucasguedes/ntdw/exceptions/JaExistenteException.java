package br.com.jlucasguedes.ntdw.exceptions;


public class JaExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024598371808368471L;

	public JaExistenteException(String message) {
		super(message);
	}

	public JaExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

}
