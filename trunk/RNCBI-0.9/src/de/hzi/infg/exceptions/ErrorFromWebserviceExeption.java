package de.hzi.infg.exceptions;

/**
 * Indicates that the arguments for the operation of the webservice are not
 * those we would expect. Furthermore it indicates, if something went wrong
 * during the call to the webservice.
 * 
 * @author Martin Schumann
 * 
 */
public class ErrorFromWebserviceExeption extends Exception {

	/**
	 * A serial version uid.
	 */
	private static final long serialVersionUID = 2801335836648237373L;

	public ErrorFromWebserviceExeption() {
	}

	public ErrorFromWebserviceExeption(String message) {
		super(message);
	}

	public ErrorFromWebserviceExeption(Throwable cause) {
		super(cause);
	}

	public ErrorFromWebserviceExeption(String message, Throwable cause) {
		super(message, cause);
	}

}
