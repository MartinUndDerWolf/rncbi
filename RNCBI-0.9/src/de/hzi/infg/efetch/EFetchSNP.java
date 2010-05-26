/**
 * 
 */
package de.hzi.infg.efetch;

import gov.nih.nlm.ncbi.www.soap.eutils.EFetchSnpServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_snp.EFetchRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_snp.EFetchResult;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.axis2.client.Options;

import de.hzi.infg.abstracts.EFetch;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.utilities.Utils;

/**
 * Methods to generate and access the results of the efetch_snp operation from
 * the ncbi webservice.
 * 
 * @author Martin Schumann
 * 
 */
public class EFetchSNP extends EFetch {
	/**
	 * The request for the {@link EFetchSnpServiceStub}
	 */
	private EFetchRequest request;
	/**
	 * The service.
	 */
	private EFetchSnpServiceStub snpService;

	private Options options;

	/**
	 * This creates a request object to access the request parameter for this
	 * service.<br>
	 * After the creation of this object the request parameter are available. The
	 * request parameter should have been set before the {@link #fireRequest()}
	 * method is called.
	 */
	public EFetchSNP() {
		// init the setter/getter methods name
		EFetchSNP.GET_NAME = "get";
		EFetchSNP.SET_NAME = "set";
		// create the request
		request = new EFetchRequest();
		// create the operation parameter
		createOperationParameter(request.getClass());
		// end, the parameter for the request are now available
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.EFetchInterface#fireRequest()
	 */
	@Override
	public void fireRequest() throws RemoteException, ErrorFromWebserviceExeption {
		// init result map
		resultMap = new HashMap<String, Object>();
		// create a service object for this efetch operation
		snpService = new EFetchSnpServiceStub();
		// get the options from the service
		options = snpService._getServiceClient().getOptions();
		// set the options
		setOptions(options);
		// fill in the parameter values to the request
		Utils.setParameterToRequest(request, requestParameter);
		// now we have set the parameters, time to make a request
		result = snpService.run_eFetch(request);
		if (((EFetchResult) result).getERROR() != null) {
			throw new ErrorFromWebserviceExeption("The request produced an error: " + ((EFetchResult) result).getERROR());
		}
		// we got the result, so we can create a map from it
		createResultMap(result);
	}

}
