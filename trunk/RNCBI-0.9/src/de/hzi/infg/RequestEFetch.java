/**
 * 
 */
package de.hzi.infg;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Map;

import org.apache.axis2.transport.http.HttpTransportProperties.ProxyProperties;

import de.hzi.infg.abstracts.EFetch;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.exceptions.NoResultSoFarException;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.interfaces.RequestInterface;

/**
 * This will encapsulate the efetch operation for each database. The methods
 * from the {@link RequestInterface} simply call the according method of the
 * {@link EFetch} object.
 * 
 * @author Martin Schumann
 * 
 */
public class RequestEFetch implements RequestInterface {

	/**
	 * The databases a service exists for. The order of the entries is mandatory.
	 */
	private static final String[] databases = { "pubmed", "nlmc", "taxon", "omim", "snp", "sequence", "journals", "gene" };
	/**
	 * The class names for each operation. Maps bijective to the
	 * {@link #databases} array.
	 */
	private static final String[] classNames = { "de.hzi.infg.efetch.EFetchPubmed", "de.hzi.infg.efetch.EFetchNlmc", "de.hzi.infg.efetch.EFetchTaxon",
			"de.hzi.infg.efetch.EFetchOmim", "de.hzi.infg.efetch.EFetchSNP", "de.hzi.infg.efetch.EFetchSequence", "de.hzi.infg.efetch.EFetchJournals",
			"de.hzi.infg.efetch.EFetchGene" };
	/**
	 * The properties of the proxy, if there is any.
	 */
	private ProxyProperties proxyProperties;
	/**
	 * The object for the current operation of efetch.
	 */
	private EFetch efetchObject;

	/**
	 * This constructor sets the database for the efetch operation. Depending on
	 * the database, the request parameter can be obtained.
	 * 
	 * @param db Database for the efetch operation.
	 * @throws ErrorFromWebserviceExeption
	 * @throws RemoteException
	 * @throws RuntimeException If the creation of the according efetch object
	 *            fails.
	 * @throws ClassNotFoundException If the creation of the according efetch
	 *            object fails.
	 * @throws NoSuchMethodException If the creation of the according efetch
	 *            object fails.
	 * @throws InvocationTargetException If the creation of the according efetch
	 *            object fails.
	 * @throws IllegalAccessException If the creation of the according efetch
	 *            object fails.
	 * @throws InstantiationException If the creation of the according efetch
	 *            object fails.
	 */
	public RequestEFetch(String db) throws ErrorFromWebserviceExeption, RemoteException, RuntimeException, ClassNotFoundException,
			NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		boolean databaseFound = false;
		// branching according to the database
		if ((db == null) || (db.isEmpty())) {
			throw new ErrorFromWebserviceExeption("No database selected.");
		}
		for (byte i = 0; i < databases.length; i++) {
			if (db.equalsIgnoreCase(databases[i])) {
				databaseFound = true;
				// create according object
				Class<?> eFetchClazz = Class.forName(classNames[i]);
				Constructor<?> con = eFetchClazz.getConstructor();
				// create the object for this efetch operation
				efetchObject = (EFetch) con.newInstance();
			}
		}
		if (!databaseFound) {
			// after we are through all possible databases and didn't find the one
			// from the argMap
			String dbOptions = "";
			for (int i = 0; i < databases.length; i++) {
				if (i == databases.length - 1) {
					dbOptions += databases[i];
				} else {
					dbOptions += databases[i] + ", ";
				}
			}
			throw new ErrorFromWebserviceExeption("Wrong database selected. Please select one from these databases:\n" + dbOptions);
		}
	}

	/**
	 * This method creates the call to the webservice<br>
	 * Depending on the database, that was set, it will call the correct efetch
	 * operation from the webservice.
	 * 
	 * @param argMap A map with the request parameters.
	 * @throws ErrorFromWebserviceExeption If the webservice can not be
	 *            initialized correctly (e.g. because db argument is missing) or
	 *            produces an error.
	 * @throws RemoteException Error with the service.
	 */
	public void CallService(Map<String, String> argMap) throws ErrorFromWebserviceExeption, RemoteException {
		// this should call the appropriate methods from the efetchObject to call
		// the service
		efetchObject.setRequestParameter(argMap);
		efetchObject.setProxyProperties(proxyProperties);
		efetchObject.fireRequest();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hzi.infg.interfaces.RequestInterface#getComplexType(java.lang.String)
	 */
	@Override
	public String[] getComplexType(String name) throws ParameterNotFoundException {
		return efetchObject.getComplexType(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.RequestInterface#getParameter()
	 */
	@Override
	public String[] getParameter() {
		return efetchObject.getParameter();
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
		return efetchObject.getParameterByName(parameter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hzi.infg.interfaces.RequestInterface#getResultMap()
	 */
	@Override
	public Map<String, Object> getResultMap() throws NoResultSoFarException {
		return efetchObject.getResultMap();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hzi.infg.interfaces.RequestInterface#getSimpleType(java.lang.String)
	 */
	@Override
	public String getSimpleType(String name) throws ParameterNotFoundException {
		return efetchObject.getSimpleType(name);
	}

	/**
	 * Returns the request parameter for the current efetch operation. This is
	 * only available, if a database name was provided.
	 * 
	 * @return The request parameter.
	 * @throws If the {@link #efetchObject} is <code>null</code>.
	 */
	public String[] getOperationParameter() throws IllegalStateException {
		if (efetchObject == null) {
			throw new IllegalStateException("Please initialize the eFetch operation first.");
		}
		return efetchObject.getOperationParameter();
	}

	public static String[] getDatabases() {
		String[] tmp = Arrays.copyOf(databases, databases.length);
		Arrays.sort(tmp, String.CASE_INSENSITIVE_ORDER);
		return tmp;
	}

	public void setProxyProperties(ProxyProperties proxyProperties) {
		this.proxyProperties = proxyProperties;
	}

	public ProxyProperties getProxyProperties() {
		return proxyProperties;
	}

	public Object getResult() {
		return efetchObject.getResult();
	}

}
