package de.hzi.infg;

import gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchResult;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.exceptions.NoResultSoFarException;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.interfaces.RequestInterface;
import de.hzi.infg.interfaces.TypeInterface;
import de.hzi.infg.utilities.Utils;

/**
 * This class represents the operation run_eSearch from the NCBI Web Service. It
 * will provide access to the operation and to the parameter of the request and
 * result.
 * 
 * @author Martin Schumann
 * 
 */
public class RequestESearch implements RequestInterface {

	private ESearchRequest request;
	private ESearchResult result;
	/**
	 * Map with the parameter names as keys and their values as values.
	 */
	private HashMap<String, Object> resultMap;

	/**
	 * This will run the "run_eSearch" operation from the web service.
	 * 
	 * @param arguments The arguments of "run_eSearch" inside a map. With the name
	 *           of the argument as key.
	 * @throws RemoteException In case of a fail during the call to the web
	 *            service.
	 * @throws WrongArgumentsSuppliedException If the arguments are not suitable
	 *            for this operation.
	 */
	public RequestESearch(Map<String, String> arguments, EUtilsServiceStub service) throws ErrorFromWebserviceExeption, RemoteException {
		request = new ESearchRequest(arguments.keySet());
		resultMap = new HashMap<String, Object>();
		// set the parameter and values in the request
		Utils.setParameterToRequest(request, arguments); // now we have set the
		// parameters, time to
		// make a request
		result = service.run_eSearch(request);

		if (result.getERROR() != null) {
			// error occurred
			throw new ErrorFromWebserviceExeption("The request produced an error: " + result.getERROR());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hzi.infg.interfaces.RequestInterface#getComplexType(java.lang.String)
	 */
	@Override
	public String[] getComplexType(String name) throws ParameterNotFoundException {
		createResultMap();
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
		// errors handled, get the parametersMap for firstObject, because it is
		// definitely a complex type.
		Map<String, Object> firstMap = ((TypeInterface) firstObject).getParametersMap();
		// a list with the names of the parameter in order
		ArrayList<String> orderedNames = new ArrayList<String>();
		// a string for the first entry in the listToReturn
		String firstEntry = "";
		// iterate through the keys of the first map
		Iterator<String> firstKeyIter = firstMap.keySet().iterator();
		while (firstKeyIter.hasNext()) {
			// a string to hold the values
			String values = "";
			String firstKey = firstKeyIter.next();
			if (firstKeyIter.hasNext())
				firstEntry += firstKey + RInterface.BREAKWORD;
			else
				firstEntry += firstKey;
			// to keep an eye on the order of the parameter
			orderedNames.add(firstKey);
			// get the second object
			Object secondObject = firstMap.get(firstKey);
			// the first subType is empty, because we are at the root here
			Stack<String> ss = new Stack<String>();
			ss.push(firstKey);
			values = Utils.recStructureBuild(values, secondObject, new Stack<String>(), ss, false, 0);
			// System.out.println(name+" 1st: "+firstKey+" "+secondObject.getClass().getName());
			// System.out.println("Values: "+values);
			// corrections of the listToReturn
			// the first words in each string must not be a special word from
			// RInterface
			// either the BREAKWORD is first or the SUBSET, never both
			// if (values.startsWith(RInterface.BREAKWORD)) {
			// values = values.substring(RInterface.BREAKWORD.length(),
			// values.length());
			// } else if (values.startsWith(RInterface.SUBSET)) {
			// values = values.substring(RInterface.SUBSET.length(),
			// values.length());
			// }
			listToReturn.add(values);
		}
		// add the list of the parameters as first element to the ArrayList
		listToReturn.add(0, firstEntry);

		return listToReturn.toArray(new String[listToReturn.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hzi.infg.interfaces.RequestInterface#getSimpleType(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.RequestInterface#getParameter()
	 */
	@Override
	public String[] getParameter() {
		// we now get all getter methods from result and according to their
		// return value, we but them in the tmpList with true or false
		// whether it is a complex type or not.
		Class<? extends ESearchResult> resClazz = result.getClass();
		return Utils.getParameter(resClazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hzi.infg.interfaces.RequestInterface#getParameterByName(java.lang.String
	 * )
	 */
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
			// this happens for the errorlist and the warninglist
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.RequestInterface#getResultMap()
	 */
	@Override
	public Map<String, Object> getResultMap() throws NoResultSoFarException {
		if (result == null) {
			throw new NoResultSoFarException("There are no results to get.");
		}
		createResultMap();
		return resultMap;
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

	public ESearchResult getResult() {
		return result;
	}

}
