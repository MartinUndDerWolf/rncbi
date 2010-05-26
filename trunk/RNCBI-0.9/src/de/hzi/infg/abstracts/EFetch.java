/**
 * 
 */
package de.hzi.infg.abstracts;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis2.Constants;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties.ProxyProperties;
import org.xml.sax.SAXException;

import de.hzi.infg.RInterface;
import de.hzi.infg.efetch.EFetchPubmed;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.exceptions.NoResultSoFarException;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.interfaces.EFetchInterface;
import de.hzi.infg.interfaces.TypeInterface;
import de.hzi.infg.utilities.Utils;

/**
 * This abstract class provides some function all the EFetch classes should have
 * in common. In addition it implements the {@link EFetchInterface}, which all
 * the EFetch classes should also implement.
 * 
 * @author Martin Schumann
 */
public abstract class EFetch implements EFetchInterface {

	/**
	 * The name of the getter methods.
	 */
	protected static String GET_NAME;
	/**
	 * The name of the setter methods.
	 */
	protected static String SET_NAME;

	/**
	 * The parameter a request of this efetch operation expects.
	 */
	protected Set<String> operationParameter;
	/**
	 * The parameter for the request with their values for this efetch operation.
	 */
	protected Map<String, String> requestParameter;
	/**
	 * The properties of the proxy, if there is any.
	 */
	private ProxyProperties proxyProperties;
	/**
	 * If the proxy information was set, then we have to use the proxy settings.
	 */
	private boolean useProxy = false;
	/**
	 * A map for the result.
	 */
	protected HashMap<String, Object> resultMap;
	/**
	 * The result for each operation of eFetch.
	 * 
	 * @see EFetchPubmed
	 */
	protected Object result;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.RequestInterface#getParameter()
	 */
	@Override
	public String[] getParameter() {
		Class<?> resClazz = result.getClass();
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
		return resultMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hzi.infg.interfaces.RequestInterface#getSimpleType(java.lang.String)
	 */
	@Override
	public String getSimpleType(String name) throws ParameterNotFoundException {
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
		values = Utils.recStructureBuildEFetch(values, firstObject, new Stack<String>(), ss, false, 0);
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

	/**
	 * This will create the result map for private use only.
	 */
	protected void createResultMap(Object result) {
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

	/**
	 * Creates the set of operation parameter for a request. <br>
	 * Uses the set methods of the request class to get the names of the
	 * parameter for the request.
	 * 
	 * @param reqClazz The class of the request.
	 */
	protected void createOperationParameter(Class<?> reqClazz) {
		operationParameter = new HashSet<String>();
		Method[] methods = reqClazz.getMethods();
		// iterate through the methods, only set methods, because these are the
		// parameters.
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase("seterror") || method.getName().equalsIgnoreCase("setnil")) {
				continue;
			}
			// we use the setter methods, because there are no methods like the
			// "getPullParser" method
			if (method.getName().startsWith(EFetch.SET_NAME)) {
				// if (method.getName().toLowerCase().contains("id")) {
				// Type[] types = method.getGenericParameterTypes();
				// for (Type type : types) {
				// System.out.println("The argument type of setId: "+type);
				// }
				// }
				operationParameter.add(Utils.transformMethodName(method.getName(), EFetch.SET_NAME));
			}
		}
	}

	/**
	 * Sets the options to the option object provided. The client does not accept
	 * chunked streams, so we set this to false. And if {@link #useProxy} is
	 * true, we set the {@link ProxyProperties}.
	 * 
	 * @param options The options object.
	 */
	protected void setOptions(Options options) {
		// client doesn't accept chunked streams
		options.setProperty(HTTPConstants.CHUNKED, Constants.VALUE_FALSE);
		if (useProxy) {
			// set the proxy properties, they should not be null
			options.setProperty(HTTPConstants.PROXY, proxyProperties);
		}
	}

	/**
	 * Checks whether the parameter which were supplied are correct for this
	 * operation.
	 * 
	 * @param paraSet The set of parameter to check.
	 * @throws ErrorFromWebserviceExeption If something is wrong with the
	 *            parameter for this request.
	 */
	private void checkParameter(Set<String> paraSet) throws ErrorFromWebserviceExeption {
		Set<String> tmpSet = new HashSet<String>();
		for (String string : operationParameter) {
			tmpSet.add(string);
		}
		if (paraSet.size() != tmpSet.size()) {
			throw new ErrorFromWebserviceExeption("Wrong arguments for this operation supplied.");
		}
		for (String para : paraSet) {
			if (!tmpSet.contains(para.toLowerCase()))
				throw new ErrorFromWebserviceExeption("Wrong arguments for this operation supplied.");
		}
	}

	/**
	 * Returns the operation parameter for each efetch operation.
	 */
	public String[] getOperationParameter() {
		return operationParameter.toArray(new String[operationParameter.size()]);
	}

	/**
	 * Set the parameter for the request. And checks whether they fit or not.
	 * 
	 * @param arguments The parameter with their values.
	 * @throws ErrorFromWebserviceExeption If the parameter do not fit to this
	 *            operation.
	 */
	public void setRequestParameter(Map<String, String> arguments) throws ErrorFromWebserviceExeption {
		checkParameter(arguments.keySet());
		requestParameter = arguments;
	}

	public ProxyProperties getProxyProperties() {
		return proxyProperties;
	}

	public void setProxyProperties(ProxyProperties proxyProperties) {
		if (proxyProperties != null) {
			useProxy = true;
			this.proxyProperties = proxyProperties;
		}
	}

	public static String getGET_NAME() {
		return GET_NAME;
	}

	public static String getSET_NAME() {
		return SET_NAME;
	}

	public Object getResult() {
		return result;
	}
}
