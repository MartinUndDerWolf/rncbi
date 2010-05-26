package de.hzi.infg;

import gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.egquery.EGQueryResultType;
import gov.nih.nlm.ncbi.www.soap.eutils.egquery.EGqueryRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.egquery.Result;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.exceptions.NoResultSoFarException;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.interfaces.RequestInterface;
import de.hzi.infg.utilities.Utils;

/**
 * This class represents the operation run_eGQuery from the NCBI Web Service. It
 * will provide access to the operation and to the parameter of the request and
 * result.
 * 
 * @author Martin Schumann
 * 
 */
public class RequestEGQuery implements RequestInterface {

	private EGqueryRequest request;
	private Result result;
	private EGQueryResultType resultType;
	private static final String resultItemName = "resultitem";

	/**
	 * This method runs the "run_eGquery" operation from the web service.
	 */
	public RequestEGQuery(Map<String, String> arguments, EUtilsServiceStub service) throws ErrorFromWebserviceExeption, RemoteException {
		request = new EGqueryRequest(arguments.keySet());
		// set the parameter and values in the request
		Utils.setParameterToRequest(request, arguments);
		// now we have set the parameters, time to make a request
		result = service.run_eGquery(request);
		// after getting the result, we can close the connection to the webservice
		service.cleanup();
		resultType = result.getEGQueryResult();

		if (result.getEGQueryResult().getERROR() != null) {
			// error occurred
			throw new ErrorFromWebserviceExeption("The request produced an error: " + result.getEGQueryResult().getERROR());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.RequestInterface#getParameter()
	 */
	@Override
	public String[] getParameter() {
		// this will create an array, with true and false, if the name is a
		// complex type
		ArrayList<String> tmpList = new ArrayList<String>();
		// add the term from the result
		tmpList.add("term");
		tmpList.add(RInterface.VALUE_FALSE);
		// add the resultitem from the result
		tmpList.add(resultItemName);
		tmpList.add(RInterface.VALUE_TRUE);
		return (String[]) tmpList.toArray(new String[tmpList.size()]);
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
		if (!parameter.equalsIgnoreCase(resultItemName)) {
			throw new ParameterNotFoundException("The parameter \"" + parameter + "\" has no further parameters to get.");
		}
		Map<String, Object> tmpMap = resultType.getResultItem()[0].getParametersMap();
		Set<String> tmpKeySet = tmpMap.keySet();
		return tmpKeySet.toArray(new String[tmpKeySet.size()]);
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
		// the map to return
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("term", result.getTerm());
		returnMap.put("resultitem", resultType.getResultItem());
		return returnMap;
	}

	// this will be realized with the recursive method now
	// @Override
	// public String[] getComplexType(String name) throws
	// ParameterNotFoundException {
	// ArrayList<String> listToReturn = new ArrayList<String>();
	// TypeInterface[] resultItem = resultType.getResultItem();
	// // handle the errors.
	// if (!name.equalsIgnoreCase(resultItemName)) {
	// throw new ParameterNotFoundException("The parameter \"" + name +
	// "\" is not part of this result or is no complex type.");
	// }
	// // to access the get methods of the complex type
	// Class<?> complexTypSubClass = resultItem[0].getClass();
	// // we are sure, that this is a complex type, so we can get the sub
	// parameters of this type
	// String[] subParameterNames = getParameterByName(name);
	// String parNames = "";
	// // this is necessary to keep the order if the names like the final string
	// in parNames
	// ArrayList<String> orderedNames = new ArrayList<String>();
	// // we need the getter methods and the corresponding names
	// HashMap<String, Method> getters = new HashMap<String, Method>();
	// // we add the sub parameter names to parNames and
	// // additionally we add the getter methods to the HashMap
	// // to retrieve them later easily
	// for (int i = 0; i < subParameterNames.length; i++) {
	// getters.put(subParameterNames[i],
	// Utils.getGetMethodByName(subParameterNames[i], complexTypSubClass));
	// orderedNames.add(subParameterNames[i]);
	// if (i == subParameterNames.length - 1) {
	// // the last element doesn't need the break word at the end
	// parNames += subParameterNames[i];
	// } else {
	// parNames += subParameterNames[i] + RInterface.BREAKWORD;
	// }
	// }
	// // now add this to the return array
	// listToReturn.add(parNames);
	// // build the arrays for each parameter of the complex type
	// // keep an eye on the order, so that it fits to the parNames
	// HashMap<String, ArrayList<Object>> tmpMap = new HashMap<String,
	// ArrayList<Object>>();
	// for (Object object : resultItem) {
	// // invoke the getters to get each parameter.
	// for (String methodName : getters.keySet()) {
	// ArrayList<Object> tmpArrList = tmpMap.get(methodName);
	// if (tmpArrList == null) {
	// tmpArrList = new ArrayList<Object>();
	// tmpMap.put(methodName, tmpArrList);
	// }
	// Object returnOfGet;
	// try {
	// returnOfGet = getters.get(methodName).invoke(object);
	// } catch (IllegalArgumentException e) {
	// e.printStackTrace();
	// throw new
	// ParameterNotFoundException("Something is wrong with the parameter \"" +
	// name
	// + "\". Could not find get methods for this complex type");
	// } catch (IllegalAccessException e) {
	// e.printStackTrace();
	// throw new
	// ParameterNotFoundException("Something is wrong with the parameter \"" +
	// name
	// + "\". Could not find get methods for this complex type");
	// } catch (InvocationTargetException e) {
	// e.printStackTrace();
	// throw new
	// ParameterNotFoundException("Something is wrong with the parameter \"" +
	// name
	// + "\". Could not find get methods for this complex type");
	// }
	// tmpArrList.add(returnOfGet);
	// }
	// }
	//
	// // now build the string and add it to the returnList
	// for (int j = 0; j < orderedNames.size(); j++) {
	// // the values of the parameter are in this array, after the parNames
	// // string
	// String tmpString = "";
	// // if there is already something appended to the returnList, then we get
	// // this
	// if (listToReturn.size() > j + 1) {
	// tmpString = listToReturn.get(j + 1);
	// }
	// // this should be contained in the tmpMap
	// ArrayList<Object> tmpArrList = tmpMap.get(orderedNames.get(j));
	// for (int i = 0; i < tmpArrList.size(); i++) {
	// if (i == tmpArrList.size() - 1) {
	// tmpString += tmpArrList.get(i);
	// } else {
	// tmpString += tmpArrList.get(i) + RInterface.BREAKWORD;
	// }
	// }
	// listToReturn.add(j + 1, tmpString);
	// }
	// return listToReturn.toArray(new String[listToReturn.size()]);
	// }

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
		values = Utils.recStructureBuild(values, resultType.getResultItem(), new Stack<String>(), ss, false, 0);
		if (values.startsWith(RInterface.BREAKWORD)) {
			values = values.substring(RInterface.BREAKWORD.length(), values.length());
		} else if (values.startsWith(RInterface.SUBSET)) {
			values = values.substring(RInterface.SUBSET.length(), values.length());
		}
		listToReturn.add(values);
		// add the list of the parameters as first element to the ArrayList
		listToReturn.add(0, firstEntry);
		return listToReturn.toArray(new String[listToReturn.size()]);
	}

	@Override
	public String getSimpleType(String name) throws ParameterNotFoundException {
		if (name.equalsIgnoreCase("term")) {
			return result.getTerm();
		}
		throw new ParameterNotFoundException("The parameter \"" + name + "\" is not part of this result.");
	}

}
