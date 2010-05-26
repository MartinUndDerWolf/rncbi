/**
 * 
 */
package de.hzi.infg.interfaces;

import java.rmi.RemoteException;

import de.hzi.infg.abstracts.EFetch;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;

/**
 * This interface provides methods which have to be present in every class for
 * each efetch database.
 * 
 * @author Martin Schumann
 * 
 */
public interface EFetchInterface extends RequestInterface {
	/**
	 * The parameter for the current request.
	 * 
	 * @return The parameter inside a string array.
	 */
	public String[] getOperationParameter();

	/**
	 * This calls the webservice with the parameter from
	 * {@link EFetch#requestParameter}.<br>
	 * The parameter values for the request should have been set, before this
	 * method is called.
	 * 
	 * @throws RemoteException Error with the service.
	 * @throws ErrorFromWebserviceExeption Error with the parameter.
	 */
	public void fireRequest() throws RemoteException, ErrorFromWebserviceExeption;

}
