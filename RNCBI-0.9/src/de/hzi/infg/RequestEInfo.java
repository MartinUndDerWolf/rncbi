package de.hzi.infg;

import gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.einfo.DbInfoType;
import gov.nih.nlm.ncbi.www.soap.eutils.einfo.DbListType;
import gov.nih.nlm.ncbi.www.soap.eutils.einfo.EInfoRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.einfo.EInfoResult;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hzi.infg.exceptions.NoResultSoFarException;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.interfaces.RequestInterface;
import de.hzi.infg.interfaces.TypeInterface;
import de.hzi.infg.utilities.Utils;

/**
 * This class represents the operation run_eInfo from the NCBI Web Service. It
 * will provide access to the operation and to the parameter of the request and
 * result.
 * 
 * @author Martin Schumann
 * 
 */
public class RequestEInfo implements RequestInterface {

	/**
	 * An array of the data base names of the web service.
	 */
	private String[] dbNames;
	/**
	 * A map with the information about one data base. It is provided by
	 * {@link DbInfoType}.
	 * 
	 * @see DbInfoType#getParametersMap()
	 */
	private Map<String, Object> dbInfoMap;
	/**
	 * Whether it is a dbInfo, if false the names of all data bases is it.
	 */
	private boolean isDbInfo = false;
	/**
	 * The result from the request.
	 */
	private EInfoResult result;
	private EInfoRequest request;

	/**
	 * This method runs the "run_eInfo" operation from the web service.
	 * 
	 * @param arguments The arguments of "run_eInfo" inside a map. With the name
	 *           of the argument as key.
	 * @throws RemoteException In case of a fail during the call to the web
	 *            service.
	 * @throws WrongArgumentsSuppliedException If the arguments are not suitable
	 *            for this operation.
	 */
	public RequestEInfo(Map<String, String> arguments, EUtilsServiceStub service) throws ErrorFromWebserviceExeption, RemoteException {
		// if the db argument is empty, we expect a list of database names
		if (arguments.get("db").isEmpty()) {
			request = new EInfoRequest(arguments.keySet());
			// set the other parameter for the request
			if (!arguments.get("email").isEmpty()) {
				request.setEmail(arguments.get("email"));
			}
			if (!arguments.get("tool").isEmpty()) {
				request.setTool(arguments.get("tool"));
			}
			result = service.run_eInfo(request);
			// after getting the result, we can close the connection to the
			// webservice
			service.cleanup();
			DbListType dbList = result.getDbList();
			dbNames = dbList.getDbName();
			// this is not a dbInfo, these are only the names of the data bases
			isDbInfo = false;
			// System.out.println(dbNames.length);
		} else {
			// else the db argument is not empty, so we expect a DbInfoType as
			// result
			EInfoRequest request = new EInfoRequest(arguments.keySet());
			// set the arguments
			request.setDb(arguments.get("db"));
			if (!arguments.get("email").isEmpty()) {
				request.setEmail(arguments.get("email"));
			}
			if (!arguments.get("tool").isEmpty()) {
				request.setTool(arguments.get("tool"));
			}
			result = service.run_eInfo(request);
			// after getting the result, we can close the connection to the
			// webservice
			service.cleanup();
			if (result.getERROR() != null) {
				throw new ErrorFromWebserviceExeption("The request produced an error: " + result.getERROR());
			} else {
				dbInfoMap = result.getDbInfo().getParametersMap();
				isDbInfo = true;
			}
		}
	}

	public String[] getDbNames() {
		return dbNames;
	}

	public Map<String, Object> getDbInfoMap() {
		return dbInfoMap;
	}

	public boolean isDbInfo() {
		return isDbInfo;
	}

	@Override
	public String[] getParameterByName(String parameter) throws ParameterNotFoundException {
		if (!isDbInfo) {
			// if this is not a dbInfo, then simply return null
			return null;
		}
		// else we look for the parameter name and return a String[]
		Object tmpObj = dbInfoMap.get(parameter.toLowerCase());
		if (tmpObj == null) {
			throw new ParameterNotFoundException("The parameter \"" + parameter + "\" has no further parameters to get.");
		}
		// else we can work with tmpObj
		if (tmpObj instanceof String) {
			String[] tmp = { tmpObj.toString() };
			return tmp;
		}
		// finally the wanted result, tmpObj should be a complex type
		// get the first element of the array of objects, there are the names in
		// the
		// parametersMap
		Object[] objAr = ((Object[]) tmpObj);
		Map<String, Object> tmpParaMap = ((TypeInterface) objAr[0]).getParametersMap();
		return (String[]) tmpParaMap.keySet().toArray(new String[tmpParaMap.keySet().size()]);
	}

	/**
	 * Creates an array with the names of the parameters for this operations
	 * result. </br> If you would like to call this function yourself, make sure
	 * {@link #isDbInfo} is true!
	 * 
	 * @return An array with name and a boolean next to it, whether it is a
	 *         complex type or not. e.g. {Name,false,LinkList,true}
	 */
	public String[] getParameter() {
		// Maybe we should pass the data type of the parameter instead of whether
		// it is a complex type or not.
		// Or we can add the data type information as 3rd value.
		// Not necessary I think, because it is always a string data type
		ArrayList<String> tmpList = new ArrayList<String>();
		for (String name : dbInfoMap.keySet()) {
			// System.out.print(name + ": ");
			Object obj = dbInfoMap.get(name);
			if (!(obj instanceof String)) {
				// must be an array / complex type
				tmpList.add(name);
				tmpList.add(RInterface.VALUE_TRUE);
			} else {
				// must be a string
				tmpList.add(name);
				tmpList.add(RInterface.VALUE_FALSE);
			}
		}
		// return the array of Strings
		return (String[]) tmpList.toArray(new String[tmpList.size()]);
	}

	@Override
	public String[] getComplexType(String name) throws ParameterNotFoundException {
		ArrayList<String> listToReturn = new ArrayList<String>();
		Object tmpObj = dbInfoMap.get(name.toLowerCase());
		// handle the errors.
		if (tmpObj == null) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is not part of this result.");
		}
		if (tmpObj instanceof String) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is not a complex type.");
		}
		// go on
		Object[] objAr = ((Object[]) tmpObj);
		// to access the get methods of the complex type
		Class<?> complexTypSubClass = objAr[0].getClass();
		// we are sure, that this is a complex type
		String[] tmpAr = getParameterByName(name);
		String parNames = "";
		// this is necessary to keep the order if the names like the final string
		// in
		// parNames
		ArrayList<String> orderedNames = new ArrayList<String>();
		// we need the getter methods and the corresponding names
		HashMap<String, Method> getters = new HashMap<String, Method>();
		for (int i = 0; i < tmpAr.length; i++) {
			getters.put(tmpAr[i], Utils.getGetMethodByName(tmpAr[i], complexTypSubClass));
			orderedNames.add(tmpAr[i]);
			if (i == tmpAr.length - 1) {
				// the last element doesn't need the break word at the end
				parNames += tmpAr[i];
			} else {
				parNames += tmpAr[i] + RInterface.BREAKWORD;
			}
		}
		// now add this to the return array
		listToReturn.add(parNames);
		// build the arrays for each parameter of the complex type
		// keep an eye on the order, so that it fits to the parNames
		HashMap<String, ArrayList<Object>> tmpMap = new HashMap<String, ArrayList<Object>>();
		for (Object object : objAr) {
			// invoke the getters to get each parameter.
			for (String methodName : getters.keySet()) {
				ArrayList<Object> tmpArrList = tmpMap.get(methodName);
				if (tmpArrList == null) {
					tmpArrList = new ArrayList<Object>();
					tmpMap.put(methodName, tmpArrList);
				}
				Object returnOfGet;
				try {
					returnOfGet = getters.get(methodName).invoke(object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					throw new ParameterNotFoundException("Something is wrong with the parameter \"" + name
							+ "\". Could not find get methods for this complex type");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					throw new ParameterNotFoundException("Something is wrong with the parameter \"" + name
							+ "\". Could not find get methods for this complex type");
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					throw new ParameterNotFoundException("Something is wrong with the parameter \"" + name
							+ "\". Could not find get methods for this complex type");
				}
				tmpArrList.add(returnOfGet);
			}
		}

		// now build the string and add it to the returnList
		for (int j = 0; j < orderedNames.size(); j++) {
			// the values of the parameter are in this array, after the parNames
			// string
			String tmpString = "";
			// if there is already something appended to the returnList, then we
			// get
			// this
			if (listToReturn.size() > j + 1) {
				tmpString = listToReturn.get(j + 1);
			}
			// this should be contained in the tmpMap
			ArrayList<Object> tmpArrList = tmpMap.get(orderedNames.get(j));
			for (int i = 0; i < tmpArrList.size(); i++) {
				if (i == tmpArrList.size() - 1) {
					tmpString += tmpArrList.get(i);
				} else {
					tmpString += tmpArrList.get(i) + RInterface.BREAKWORD;
				}
			}
			listToReturn.add(j + 1, tmpString);
		}
		return listToReturn.toArray(new String[listToReturn.size()]);
	}

	@Override
	public String getSimpleType(String name) throws ParameterNotFoundException {
		Object stringToReturn = null;
		stringToReturn = dbInfoMap.get(name);
		if (stringToReturn == null) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is not part of this result.");
		} else if (!(stringToReturn instanceof String)) {
			throw new ParameterNotFoundException("The parameter \"" + name + "\" is a complex type.");
		}
		return (String) stringToReturn;
	}

	@Override
	public Map<String, Object> getResultMap() throws NoResultSoFarException {
		return null;
	}

}
