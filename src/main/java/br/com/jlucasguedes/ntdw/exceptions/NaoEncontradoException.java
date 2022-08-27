package br.com.jlucasguedes.ntdw.exceptions;


public class NaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024598371808368471L;

	public NaoEncontradoException(String message) {
		super(message);
	}

	public NaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

}
