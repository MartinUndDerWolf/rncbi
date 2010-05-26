package de.hzi.infg;

import gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.elink.ELinkRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.elink.ELinkResult;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.exceptions.NoResultSoFarException;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.interfaces.RequestInterface;
import de.hzi.infg.interfaces.TypeInterface;
import de.hzi.infg.utilities.Utils;

/**
 * This class represents the operation run_eLink from the NCBI Web Service. It
 * will provide access to the operation and to the parameter of the request and
 * result.
 * 
 * @author Martin Schumann
 * 
 */
public class RequestELink implements RequestInterface {

	private ELinkRequest request;
	private ELinkResult result;
	/**
	 * Map with the parameter names as keys and their values as values.
	 */
	private Map<String, Object> resultMap;
	private static final String resultItemName = "linkset";

	public RequestELink(Map<String, String> arguments, EUtilsServiceStub service) throws ErrorFromWebserviceExeption, RemoteException {
		request = new ELinkRequest(arguments.keySet());
		resultMap = new HashMap<String, Object>();
		boolean somethingSet = false;
		Object[] idAr = null;
		boolean idToSet = false;
		for (String key : arguments.keySet()) {
			if (!arguments.get(key).isEmpty()) {
				// in this case, the id parameter is an array of strings
				// so we check whether there is the BREAKWORD and then split the
				// string
				if (key.equalsIgnoreCase("id")) {
					// this always have to be a string array!
					String tmpId = arguments.get(key);
					// split the string
					idAr = tmpId.split(RInterface.ESCAPED_BREAKWORD);
					idToSet = true;
				}
				// something was set
				somethingSet = true;
				// get getter method
				Method getMethod = Utils.getSetMethodByName(key, request.getClass());
				try {
					if (idToSet) {
						// create an object array with the array as init parameter
						getMethod.invoke(request, new Object[] { idAr });
						idToSet = false;
					} else {
						getMethod.invoke(request, arguments.get(key));
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		} // end for
		if (!somethingSet) {
			// no parameters for the operation were found
			throw new ErrorFromWebserviceExeption("All parameters are empty.");
		}
		// now we have set the parameters, time to make a request
		result = service.run_eLink(request);

		if (result.getERROR() != null) {
			// error occurred
			throw new ErrorFromWebserviceExeption("The request produced an error: " + result.getERROR());
		}
	}

	@Override
	public String[] getComplexType(String name) throws ParameterNotFoundException {
		// handle the errors.
		if (!name.equalsIgnoreCase(resultItemName)) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is not part of this result or is no complex type.");
		}
		// the list to append all the value strings, this will be returned later
		ArrayList<String> listToReturn = new ArrayList<String>();
		// a string for the first entry in the listToReturn
		String firstEntry = resultItemName;
		String values = "";
		Stack<String> ss = new Stack<String>();
		ss.push(resultItemName);
		values = Utils.recStructureBuild(values, result.getLinkSet(), new Stack<String>(), ss, false, 0);
		listToReturn.add(values);
		// add the list of the parameters as first element to the ArrayList
		listToReturn.add(0, firstEntry);
		return listToReturn.toArray(new String[listToReturn.size()]);
	}

	@Override
	public String[] getParameter() {
		// we now get all getter methods from result and according to their
		// return value, we but them in the tmpList with true or false
		// whether it is a complex type or not.
		Class<? extends ELinkResult> resClazz = result.getClass();
		return Utils.getParameter(resClazz);
	}

	@Override
	public String[] getParameterByName(String parameter) throws ParameterNotFoundException {
		// first create the result map!
		createResultMap();
		Object tmpObj = resultMap.get(parameter.toLowerCase());
		// Have to check, whether the resultMap contains the key or not, because
		// the resulting value can be null, too.
		if (!resultMap.containsKey(parameter.toLowerCase())) {
			throw new ParameterNotFoundException("The parameter \"" + parameter + "\" has no further parameters to get.");
		}
		// else we can work with tmpObj
		if (tmpObj instanceof String) {
			String[] tmp = { tmpObj.toString() };
			return tmp;
		}
		if (tmpObj == null) {
			// the resulting value of the parameter is null
			String[] tmpReturn = { RInterface.EMPTY_VALUE };
			return tmpReturn;
		}
		// finally the wanted result, tmpObj should be a complex type
		// get the first element of the array of objects, there are the names in
		// the
		// parametersMap
		Map<String, Object> tmpParaMap = ((TypeInterface) tmpObj).getParametersMap();
		return (String[]) tmpParaMap.keySet().toArray(new String[tmpParaMap.keySet().size()]);
	}

	@Override
	public Map<String, Object> getResultMap() throws NoResultSoFarException {
		if (result == null) {
			throw new NoResultSoFarException("There are no results to get.");
		}
		createResultMap();
		return resultMap;
	}

	@Override
	public String getSimpleType(String name) throws ParameterNotFoundException {
		createResultMap();
		Object stringToReturn = null;
		if (resultMap.containsKey(name)) {
			stringToReturn = resultMap.get(name);
			if (stringToReturn == null) {
				// an empty result
				stringToReturn = RInterface.EMPTY_VALUE;
			}
		}
		// error handling, if the string is still null
		if (stringToReturn == null) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is not part of this result.");
		} else if (!(stringToReturn instanceof String)) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is a complex type.");
		}
		return (String) stringToReturn;
	}

	/**
	 * This will create the result map for private use only.
	 */
	private void createResultMap() {
		// if there is already a resultMap, we don't need to create one.
		if (resultMap.size() != 0) {
			return;
		}
		String[] tmpParName = getParameter();
		// with the help of getParameter, we get the names of the parameters
		for (int i = 0; i < tmpParName.length; i += 2) {
			// now as we know the name, we fetch the parameters value for the
			// resultMap
			Method getMethod = Utils.getGetMethodByName(tmpParName[i], result.getClass());
			Object obj = null;
			try {
				obj = getMethod.invoke(result);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			resultMap.put(tmpParName[i], obj);
		}
	}

	public ELinkResult getResult() {
		return result;
	}

}
