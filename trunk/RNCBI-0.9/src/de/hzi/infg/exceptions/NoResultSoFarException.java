package de.hzi.infg.exceptions;

/**
 * Will be thrown, if someone requests something from a result and there is no
 * result yet.
 * 
 * @author Martin Schumann
 * 
 */
public class NoResultSoFarException extends Exception {

	private static final long serialVersionUID = 1191611812151777964L;

	public NoResultSoFarException() {
	}

	public NoResultSoFarException(String message) {
		super(message);
	}

	public NoResultSoFarException(Throwable cause) {
		super(cause);
	}

	public NoResultSoFarException(String message, Throwable cause) {
		super(message, cause);
	}
}
