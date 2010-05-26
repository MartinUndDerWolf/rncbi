/**
 * 
 */
package de.hzi.infg.efetch;

import gov.nih.nlm.ncbi.www.soap.eutils.EFetchGeneServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_gene.EFetchRequestDocument;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_gene.EFetchResultDocument;

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
 * Methods to generate and access the results of the efetch_gene operation from
 * the ncbi webservice.
 * <p>
 * <b>This class uses the xmlbeans framework.</b>
 * </p>
 * 
 * @author Martin Schumann
 * 
 */
public class EFetchGene extends EFetch {
	/**
	 * The request for the {@link EFetchGeneServiceStub}
	 */
	private EFetchRequestDocument request;
	/**
	 * The service.
	 */
	private EFetchGeneServiceStub geneService;

	private Options options;

	/**
	 * This creates a request object to access the request parameter for this
	 * service.<br>
	 * After the creation of this object the request parameter are available. The
	 * request parameter should have been set before the {@link #fireRequest()}
	 * method is called.
	 */
	public EFetchGene() {
		EFetchGene.GET_NAME = "xget";
		EFetchGene.SET_NAME = "xset";
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
		// init the result map
		resultMap = new HashMap<String, Object>();
		// create a service object for this efetch operation, the request should
		// already exist
		geneService = new EFetchGeneServiceStub();
		// get the options from the service object
		options = geneService._getServiceClient().getOptions();
		setOptions(options);
		// now fill in the parameter values to the request
		Utils.setParameterToRequest(request.getEFetchRequest(), requestParameter);
		result = geneService.run_eFetch(request);
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
			// take the unmodified values, if the xml could not be parsed
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
