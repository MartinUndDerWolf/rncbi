/**
 * 
 */
package de.hzi.infg.efetch;

import gov.nih.nlm.ncbi.www.soap.eutils.EFetchPubmedServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EFetchRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EFetchResult;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.axis2.client.Options;

import de.hzi.infg.abstracts.EFetch;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.utilities.Utils;

/**
 * Methods to generate and access the results of the efetch_pubmed operation
 * from the ncbi webservice.
 * 
 * @author Martin Schumann
 * 
 */
public class EFetchPubmed extends EFetch {
	/**
	 * The request for the {@link EFetchPubmedServiceStub}.
	 */
	private EFetchRequest request;
	/**
	 * The service itself.
	 */
	private EFetchPubmedServiceStub pubmedService;
	/**
	 * The options of the service.
	 */
	private Options options;

	/**
	 * Creates a request object for this efetch operation and gets the request
	 * parameter this operation expects.
	 * 
	 * @throws ErrorFromWebserviceExeption If something went wrong with the
	 *            webservice.
	 */
	public EFetchPubmed() {
		// init the setter/getter methods name
		EFetchPubmed.GET_NAME = "get";
		EFetchPubmed.SET_NAME = "set";
		// create a request
		request = new EFetchRequest();
		// create the operation parameter set
		createOperationParameter(request.getClass());
		// this ends with this, the parameter for the request are now available
	}

	@Override
	public void fireRequest() throws RemoteException, ErrorFromWebserviceExeption {
		// init the result map
		resultMap = new HashMap<String, Object>();
		// create a service object for this efetch operation, the request should
		// already exist
		pubmedService = new EFetchPubmedServiceStub();
		options = pubmedService._getServiceClient().getOptions();
		setOptions(options);
		// now fill in the parameter values to the request
		Utils.setParameterToRequest(request, requestParameter);
		// now we have set the parameters, time to make a request
		result = pubmedService.run_eFetch(request);
		if (((EFetchResult) result).getERROR() != null) {
			// error occurred
			throw new ErrorFromWebserviceExeption("The request produced an error: " + ((EFetchResult) result).getERROR());
		}
		// after we got the result, we can create the result map
		createResultMap(result);
	}

}
