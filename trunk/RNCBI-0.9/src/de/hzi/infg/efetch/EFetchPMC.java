/**
 * 
 */
package de.hzi.infg.efetch;

//import gov.nih.nlm.ncbi.www.soap.eutils.EFetchPmcServiceStub;
//import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchRequestDocument;
//import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchResultDocument;
//import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.SecDocument.Sec;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Stack;

import org.apache.axis2.client.Options;

import de.hzi.infg.RInterface;
import de.hzi.infg.abstracts.EFetch;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.utilities.Utils;

/**
 * Methods to access the result of the efetch_pmc operation from the ncbi
 * webservice. This class is nearly empty and should not be used.
 * <p>
 * The pmc service seems to provide information for a website, not for a R user!
 * </p>
 * <p>
 * <b>This class uses the xmlbeans framework.</b>
 * </p>
 * 
 * @author Martin Schumann
 * @deprecated Don't use this class!
 */
public class EFetchPMC extends EFetch {

	/**
	 * The options.
	 */
	@SuppressWarnings("unused")
	private Options options;

	/**
	 * The request object.
	 */
	// private EFetchRequestDocument request;
	// /**
	// * The service.
	// */
	// private EFetchPmcServiceStub pmcService;

	/**
	 * Creates a request object for this efetch operation and gets the request
	 * parameter this operation expects.
	 * 
	 * @throws ErrorFromWebserviceExeption If something went wrong with the
	 *            webservice.
	 */
	public EFetchPMC() throws ErrorFromWebserviceExeption {
		// // init the setter/getter methods name
		// EFetchPMC.GET_NAME = "xget";
		// EFetchPMC.SET_NAME = "xset";
		// // create the request
		// request = EFetchRequestDocument.Factory.newInstance();
		// // add a new request
		// request.addNewEFetchRequest();
		// // create the operation parameter
		// createOperationParameter(request.getEFetchRequest().getClass());
		// // this ends with this, the parameter for the request are now available
	}

	@Override
	public void fireRequest() throws RemoteException, ErrorFromWebserviceExeption {
		// // init the result map
		// resultMap = new HashMap<String, Object>();
		// // create a service object for this efetch operation, the request
		// should already exist
		// pmcService = new EFetchPmcServiceStub();
		// // get the options from the service object
		// options = pmcService._getServiceClient().getOptions();
		// setOptions(options);
		// // now fill in the parameter values to the request
		// Utils.setParameterToRequest(request.getEFetchRequest(),
		// requestParameter);
		// result = pmcService.run_eFetch(request);
		// if (((EFetchResultDocument) result).getEFetchResult().getERROR() !=
		// null) {
		// throw new
		// ErrorFromWebserviceExeption("The request produced an error: "+((EFetchResultDocument)
		// result).getEFetchResult().getERROR());
		// }
		// // after we got the result, we can create the result map
		// createResultMap(((EFetchResultDocument) result).getEFetchResult());
		// // Maybe we can manage to get a better result by keep an eye on the Sec
		// array. Each Sec element should be a string like this:
		// .toString().replace("efet:", "")
		// Sec[] secAr = ((EFetchResultDocument)
		// result).getEFetchResult().getPmcArticleset().getArticleArray()[0].getBody().getSecArray();
		// for (Sec sec : secAr) {
		// System.out.println("Sec: \n"+sec.toString().replace("efet:", ""));
		// }
		// // File file = new File("eFetchExampleResult.out");
		// // try {
		// // FileUtils.writeStringToFile(file, ((EFetchResultDocument)
		// result).getEFetchResult().toString());
		// // } catch (IOException e) {
		// // e.printStackTrace();
		// // }
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
		// Remove me and the others below me, too
		// Map<String, Object> tmpMap = Utils.getTypeMapForXmlBeans(firstObject);
		// System.out.println("Size of TypeMap: "+tmpMap.size());
		// if (tmpMap.size() > 1) {
		// // if the size is greater than one, this complex type has multiple
		// types, like ESearch
		// // in most cases this will be one type, which is an array or something
		// like that
		// throw new
		// ParameterNotFoundException("OMG - Need to implement a loop over the TypeMap in getComplexType method");
		// }
		// If we want to use this, take another recStructureBuild method, one
		// which calls getTypeMapSpecial
		values = Utils.recStructureBuildForXmlBeans(values, firstObject, new Stack<String>(), ss, false, 0);
		listToReturn.add(values);
		// add the list of the parameters as first element to the ArrayList
		listToReturn.add(0, firstEntry);
		return listToReturn.toArray(new String[listToReturn.size()]);
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see de.hzi.infg.interfaces.RequestInterface#getParameter()
	// */
	// @Override
	// public String[] getParameter() {
	// // slightly different from the method for the adb classes
	// Class<?> resClazz = ((EFetchResultDocument)
	// result).getEFetchResult().getClass();
	// return Utils.getParameter(resClazz);
	// }

}
