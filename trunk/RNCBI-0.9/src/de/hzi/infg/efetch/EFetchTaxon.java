/**
 * 
 */
package de.hzi.infg.efetch;

import gov.nih.nlm.ncbi.www.soap.eutils.EFetchTaxonServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_taxonomy.EFetchRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_taxonomy.EFetchResult;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.axis2.client.Options;

import de.hzi.infg.abstracts.EFetch;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.utilities.Utils;

/**
 * Methods to generate and access the results of the efetch_taxon operation from
 * the ncbi webservice.
 * 
 * @author Martin Schumann
 * 
 */
public class EFetchTaxon extends EFetch {
	/**
	 * Request for the {@link EFetchTaxonServiceStub}.
	 */
	private EFetchRequest request;
	/**
	 * The service.
	 */
	private EFetchTaxonServiceStub taxonService;

	private Options options;

	/**
	 * This creates a request object to access the request parameter for this
	 * service.<br>
	 * After the creation of this object the request parameter are available. The
	 * request parameter should have been set before the {@link #fireRequest()}
	 * method is called.
	 */
	public EFetchTaxon() {
		// init the setter/getter methods name
		EFetchTaxon.GET_NAME = "get";
		EFetchTaxon.SET_NAME = "set";
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
		taxonService = new EFetchTaxonServiceStub();
		// get the options from the service object
		options = taxonService._getServiceClient().getOptions();
		setOptions(options);
		// now fill in the parameter values to the request
		Utils.setParameterToRequest(request, requestParameter);
		// now we have set the parameters, time to make a request
		result = taxonService.run_eFetch(request);
		if (((EFetchResult) result).getERROR() != null) {
			// error occurred
			throw new ErrorFromWebserviceExeption("The request produced an error: " + ((EFetchResult) result).getERROR());
		}
		// after we got the result, we can create the result map
		createResultMap(result);
	}

}
