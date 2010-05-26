/**
 * 
 */
package de.hzi.infg.exceptions;

/**
 * This is thrown, if a parameter is requested, which is not part of the current
 * result.
 * 
 * @author Martin Schumann
 * 
 */
public class ParameterNotFoundException extends Exception {

	private static final long serialVersionUID = 1415061519044956457L;

	public ParameterNotFoundException() {
	}

	public ParameterNotFoundException(String message) {
		super(message);
	}

	public ParameterNotFoundException(Throwable cause) {
		super(cause);
	}

	public ParameterNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
