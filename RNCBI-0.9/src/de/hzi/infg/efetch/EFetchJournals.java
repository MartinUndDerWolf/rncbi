/**
 * 
 */
package de.hzi.infg.efetch;

import gov.nih.nlm.ncbi.www.soap.eutils.EFetchJournalsServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_journals.EFetchRequestDocument;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_journals.EFetchResultDocument;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis2.client.Options;
import org.xml.sax.SAXException;

import de.hzi.infg.RInterface;
import de.hzi.infg.abstracts.EFetch;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.utilities.Utils;

/**
 * Methods to generate and access the results of the efetch_journals operation
 * from the ncbi webservice.
 * <p>
 * <b>This class uses the xmlbeans framework.</b>
 * </p>
 * 
 * @author Martin Schumann
 * 
 */
public class EFetchJournals extends EFetch {
	/**
	 * The request for the {@link EFetchJournalsServiceStub}
	 */
	private EFetchRequestDocument request;
	/**
	 * The service.
	 */
	private EFetchJournalsServiceStub journalsService;

	private Options options;

	/**
	 * This creates a request object to access the request parameter for this
	 * service.<br>
	 * After the creation of this object the request parameter are available. The
	 * request parameter should have been set before the {@link #fireRequest()}
	 * method is called.
	 */
	public EFetchJournals() {
		// the adb way
		// // init the setter/getter methods name
		// EFetchPMC.GET_NAME = "get";
		// EFetchPMC.SET_NAME = "set";
		// // create the request
		// request = new EFetchRequest();
		// // create the operation parameter
		// createOperationParameter(request.getClass());
		// // end, the parameter for the request are now available
		// the xmlbeans way
		// init the setter/getter methods name
		EFetchJournals.GET_NAME = "xget";
		EFetchJournals.SET_NAME = "xset";
		// create the request
		request = EFetchRequestDocument.Factory.newInstance();
		// add a new request
		request.addNewEFetchRequest();
		// create the operation parameter
		createOperationParameter(request.getEFetchRequest().getClass());
		// this ends with this, the parameter for the request are now available
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.EFetchInterface#fireRequest()
	 */
	@Override
	public void fireRequest() throws RemoteException, ErrorFromWebserviceExeption {
		// the adb way
		// // init result map
		// resultMap = new HashMap<String, Object>();
		// // create a service object for this efetch operation
		// journalsService = new EFetchJournalsServiceStub();
		// // get the options from the service
		// options = journalsService._getServiceClient().getOptions();
		// // set the options
		// setOptions(options);
		// // fill in the parameter values to the request
		// Utils.setParameterToRequest(request, requestParameter);
		// // now we have set the parameters, time to make a request
		// result = journalsService.run_eFetch(request);
		// if (((EFetchResult) result).getERROR() != null) {
		// throw new
		// ErrorFromWebserviceExeption("The request produced an error: "+((EFetchResult)
		// result).getERROR());
		// }
		// // we got the result, so we can create a map from it
		// createResultMap(result);
		// the xmlbeans way
		// init the result map
		resultMap = new HashMap<String, Object>();
		// create a service object for this efetch operation, the request should
		// already exist
		journalsService = new EFetchJournalsServiceStub();
		// get the options from the service object
		options = journalsService._getServiceClient().getOptions();
		setOptions(options);
		// now fill in the parameter values to the request
		Utils.setParameterToRequest(request.getEFetchRequest(), requestParameter);
		result = journalsService.run_eFetch(request);
		if (((EFetchResultDocument) result).getEFetchResult().getERROR() != null) {
			throw new ErrorFromWebserviceExeption("The request produced an error: " + ((EFetchResultDocument) result).getEFetchResult().getERROR());
		}
		// after we got the result, we can create the result map
		createResultMap(((EFetchResultDocument) result).getEFetchResult());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hzi.infg.interfaces.RequestInterface#getComplexType(java.lang.String)
	 */
	@Override
	public String[] getComplexType(String name) throws ParameterNotFoundException {
		Object firstObject = null;
		if (resultMap.containsKey(name)) {
			firstObject = resultMap.get(name.toLowerCase());
			if (firstObject == null) {
				// an empty result
				String[] tmpAr = { RInterface.EMPTY_VALUE };
				return tmpAr;
			}
		}
		// handle the errors.
		if (firstObject == null) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is not part of this result.");
		}
		if (firstObject instanceof String) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is not a complex type.");
		}
		// the list to append all the value strings, this will be returned later
		ArrayList<String> listToReturn = new ArrayList<String>();
		// a string for the first entry in the listToReturn
		String firstEntry = name;
		String values = "";
		Stack<String> ss = new Stack<String>();
		ss.push(name);
		// If we want to use this, take another recStructureBuild method, one
		// which calls getTypeMapSpecial
		values = Utils.recStructureBuildForXmlBeans(values, firstObject, new Stack<String>(), ss, false, 0);
		boolean xmlErrorOccured = false;
		if (RInterface.TIDY_XML) {
			String tidyValues = "";
			try {
				tidyValues = Utils.tidyXml(values);
			} catch (ParserConfigurationException e) {
				xmlErrorOccured = true;
				e.printStackTrace();
			} catch (SAXException e) {
				xmlErrorOccured = true;
				e.printStackTrace();
			} catch (IOException e) {
				xmlErrorOccured = true;
				e.printStackTrace();
			}
			listToReturn.add(tidyValues);
		} else if (xmlErrorOccured) {
			listToReturn.add(values);
		}

		// add the list of the parameters as first element to the ArrayList
		listToReturn.add(0, firstEntry);
		return listToReturn.toArray(new String[listToReturn.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.RequestInterface#getParameter()
	 */
	@Override
	public String[] getParameter() {
		// slightly different from the method for the adb classes
		Class<?> resClazz = ((EFetchResultDocument) result).getEFetchResult().getClass();
		return Utils.getParameter(resClazz);
	}

}
