/**
 * 
 */
package de.hzi.infg.efetch;

import gov.nih.nlm.ncbi.www.soap.eutils.EFetchNlmcServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_nlmcatalog.EFetchRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_nlmcatalog.EFetchResult;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.axis2.client.Options;

import de.hzi.infg.abstracts.EFetch;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.utilities.Utils;

/**
 * Methods to generate and access the results of the efetch_nlmc operation from
 * the ncbi webservice.
 * 
 * @author Martin Schumann
 * 
 */
public class EFetchNlmc extends EFetch {

	/**
	 * Request for the {@link EFetchNlmcServiceStub}.
	 */
	private EFetchRequest request;
	/**
	 * The service.
	 */
	private EFetchNlmcServiceStub nlmcService;

	private Options options;

	public EFetchNlmc() {
		// init the setter/getter methods name
		EFetchNlmc.GET_NAME = "get";
		EFetchNlmc.SET_NAME = "set";
		// create the request
		request = new EFetchRequest();
		// create the operation parameter
		createOperationParameter(request.getClass());
		// this ends with this, the parameter for the request are now available
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.EFetchInterface#fireRequest()
	 */
	@Override
	public void fireRequest() throws RemoteException, ErrorFromWebserviceExeption {
		// init the result map
		resultMap = new HashMap<String, Object>();
		// create a service object for this efetch operation, the request should
		// already exist
		nlmcService = new EFetchNlmcServiceStub();
		// get the options from the service object
		options = nlmcService._getServiceClient().getOptions();
		setOptions(options);
		// now fill in the parameter values to the request
		Utils.setParameterToRequest(request, requestParameter);
		// now we have set the parameters, time to make a request
		result = nlmcService.run_eFetch(request);
		if (((EFetchResult) result).getERROR() != null) {
			// error occurred
			throw new ErrorFromWebserviceExeption("The request produced an error: " + ((EFetchResult) result).getERROR());
		}
		// after we got the result, we can create the result map
		createResultMap(result);
	}

}
