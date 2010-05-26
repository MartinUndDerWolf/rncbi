package de.hzi.infg.exceptions;

/**
 * This will indicate, that a requested operation is not found.
 * 
 * @author Martin Schumann
 * 
 */
public class OperationNotFoundException extends Exception {

	private static final long serialVersionUID = 7310123659077683405L;

	public OperationNotFoundException() {
	}

	public OperationNotFoundException(String message) {
		super(message);
	}

	public OperationNotFoundException(Throwable cause) {
		super(cause);
	}

	public OperationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
