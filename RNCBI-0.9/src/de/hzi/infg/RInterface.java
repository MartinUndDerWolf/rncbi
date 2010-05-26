package de.hzi.infg;

import gov.nih.nlm.ncbi.www.soap.eutils.EUtilsServiceStub;
import gov.nih.nlm.ncbi.www.soap.eutils.egquery.EGqueryRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.einfo.EInfoRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.elink.ELinkRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.elink.ELinkResult;
import gov.nih.nlm.ncbi.www.soap.eutils.epost.EPostRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.esearch.ESearchResult;
import gov.nih.nlm.ncbi.www.soap.eutils.espell.ESpellRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.esummary.ESummaryRequest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties.ProxyProperties;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.exceptions.NoResultSoFarException;
import de.hzi.infg.exceptions.OperationNotFoundException;
import de.hzi.infg.exceptions.ParameterNotFoundException;
import de.hzi.infg.interfaces.RequestInterface;
import de.hzi.infg.interfaces.TypeInterface;
import de.hzi.infg.utilities.Utils;

/**
 * An interface to R. This will provide methods, which are necessary to
 * access the operations of the NCBI webservice and their requests and results
 * respectively.
 * 
 * @author Martin Schumann
 * 
 */
public class RInterface {

	/**
	 * A boolean as a string, to pass it to R.
	 * <p>
	 * Value: {@value #VALUE_TRUE}
	 */
	public static final String VALUE_TRUE = "true";
	/**
	 * A boolean as a string. This is to pass booleans to R.
	 * <p>
	 * Value: {@value #VALUE_FALSE}
	 */
	public static final String VALUE_FALSE = "false";
	/**
	 * A word, which will separate the elements in a string array. In this the
	 * brackets are escaped.
	 * <p>
	 * Value: {@value #ESCAPED_BREAKWORD}
	 */
	public static final String ESCAPED_BREAKWORD = "\\{bw\\}";
	/**
	 * A word, which will separate the elements in a string.
	 * <p>
	 * Value: {@value #BREAKWORD} array.
	 */
	public static final String BREAKWORD = "{bw}";
	/**
	 * A word to separate the elements in a string array. This will separate
	 * different subsets from each other.
	 * <p>
	 * Value: {@value #SUBSET}
	 */
	public static final String SUBSET = "{ss}";
	/**
	 * This will end a subset.
	 * <p>
	 * Value: {@value #END}
	 */
	public static final String END = "{end}";
	/**
	 * The package for the ncbi classes.
	 * <p>
	 * Value: {@value #NCBI_PACKAGE}
	 */
	public static final String NCBI_PACKAGE = "gov.nih.nlm.ncbi.www.soap.eutils";
	/**
	 * The package for the xmlbeans classes.
	 * <p>
	 * Value: {@value #XMLBEANS_PACKAGE}
	 */
	public static final String XMLBEANS_PACKAGE = "org.apache.xmlbeans";
	/**
	 * This constant represents the an empty value in the resultMap. If this is
	 * returned, the complex type is null. <br>
	 * e.g. The errorlist of the run_eSearch operation is most of the time empty.
	 * <p>
	 * Value: {@value #EMPTY_VALUE}
	 */
	public static final String EMPTY_VALUE = "empty";
	/**
	 * The xml tag for an array.
	 */
	public static final String XML_ARRAY_INDICATOR = "arr";
	/**
	 * The xml tag for an object of the NCBI class.
	 */
	public static final String XML_OBJECT_INDICATOR = "obj";
	/**
	 * The xml tag for an entry.
	 */
	public static final String XML_ENTRY_INDICATOR = "entry";
	/**
	 * The xml tag attribute for the name of an array, object or entry.
	 */
	public static final String XML_NAME_ATTRIBUTE = "name";
	/**
	 * The xml tag attribute for the length of an array.
	 */
	public static final String XML_LENGTH_ATTRIBUTE = "length";
	/**
	 * The max deep of the parameters
	 */
	public static final int MAX_DEEP = 3;
	/**
	 * The ncbi web service as a service object.
	 */
	private static EUtilsServiceStub service;
	/**
	 * The options of the service stub.
	 */
	private Options options;
	/**
	 * Port of the proxy.
	 */
	private int proxyPort;
	/**
	 * Host of the proxy.
	 */
	private String proxyHost;
	/**
	 * An internal list with the called operations.
	 */
	private List<RequestInterface> opList;
	/**
	 * The operation, which was called before. To provide information to
	 * {@link #getResultParameter()}.
	 */
	private byte lastCalled = -1;
	/**
	 * Indicates, whether an error was caused or not.
	 */
	private boolean errorCaused = false;
	/**
	 * Whether to debug or not to debug. Default is <code>false</code>.
	 */
	public static boolean DEBUG = false;
	/**
	 * Whether to remove the empty elements or not. Default is <code>true</code>.
	 */
	public static boolean TIDY_XML = true;
	/**
	 * For the logging.
	 */
	private Logger defaultLogger;
	/**
	 * Global eFetch request.
	 */
	private RequestEFetch eFetch;
	/**
	 * The properties of the proxy. This will be set, if there was information for the proxy provided.
	 */
	private ProxyProperties proxyProperties;
	/**
	 * A list of operations.
	 */
	private static final String[] operations = { "run_eGquery", "run_eInfo", "run_eSearch", "run_eSummary", "run_eLink", "run_eSpell", "run_ePost",
			"run_eFetch" };

	/**
	 * Constructor with proxy informations.
	 * 
	 * @param proxyAddress The address of the proxy as string. This should be
	 *           formatted like http://host:port.
	 * @param debug To debug or to not debug.
	 * @param tidy Create a tidy xml to pass to R or not. If not, all elements
	 *           will be in the result, even the empty ones. The empty elements
	 *           will have the {@link RInterface#EMPTY_VALUE} keyword.
	 */
	public RInterface(String proxyAddress, boolean debug, boolean tidy) {
		RInterface.DEBUG = debug;
		RInterface.TIDY_XML = tidy;
		initLogger();
		initRInterface();
		if (checkProxy(proxyAddress)) {
			proxyProperties = new ProxyProperties();
			proxyProperties.setProxyName(proxyHost);
			// proxyProperties.setDomain(proxyAddress);
			proxyProperties.setProxyPort(proxyPort);
			options.setProperty(HTTPConstants.PROXY, proxyProperties);
		}
	}

	/**
	 * Helper method to set the proxy, if there is any.
	 * 
	 * @param proxyAddress The address for the proxy.
	 * @return True/False, whether the proxy was set or not.
	 */
	private boolean checkProxy(String proxyAddress) {
		// if the address is empty, there is no proxy to set
		if (proxyAddress.equals("")) {
			return false;
		}
		URI tmpURI = null;
		try {
			tmpURI = new URI(proxyAddress);
		} catch (URISyntaxException e) {
			// wrong proxy settings, can not be parsed
			defaultLogger.debug(e);
		}
		if (tmpURI != null) {
			// set the proxyHost and proxyPort
			proxyHost = tmpURI.getHost();
			proxyPort = tmpURI.getPort();
			defaultLogger.info("The String: " + proxyAddress);
			defaultLogger.info("Proxy Host: " + proxyHost);
			defaultLogger.info("Proxy Port: " + proxyPort);
			return true;
		}
		return false;
	}

	/**
	 * Initiates service/options and sets chunked=false for the service options.
	 * Because the NCBI web service doesn't accept chunked streams.
	 */
	private void initRInterface() {
		// init the list
		opList = new ArrayList<RequestInterface>(operations.length);
		for (int i = 0; i < operations.length; i++) {
			opList.add(i, null);
		}
		try {
			service = new EUtilsServiceStub();
		} catch (AxisFault e) {
			defaultLogger.debug(e);
		}
		options = service._getServiceClient().getOptions();
		// client doesn't accept chunked streams
		options.setProperty(HTTPConstants.CHUNKED, Constants.VALUE_FALSE);
	}

	/**
	 * Initiates the logger, if debug is true.
	 */
	private void initLogger() {
		defaultLogger = Logger.getLogger(this.getClass());
		if (DEBUG) {
			// the log file will be placed in the tmp directory of the system
			String path = System.getProperty("java.io.tmpdir");
			String logFile = path + System.getProperty("file.separator") + "rncbiplugin.log";
			System.out.println("Logging to: " + logFile);
			defaultLogger.setLevel(Level.DEBUG);
			String pattern = "%d{dd MMM yyyy HH:mm:ss } %m %n";
			PatternLayout layout = new PatternLayout(pattern);
			// not very nice, but only for debug reasons
			FileAppender fileApp = null;
			try {
				fileApp = new FileAppender(layout, logFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			defaultLogger.addAppender(fileApp);
		} else {
			// TODO Change to Level.OFF on release day.
			defaultLogger.setLevel(Level.INFO);
		}
	}

	/**
	 * This is the interface for the "run_eGQuery" operation from the NCBI web
	 * service.
	 * 
	 * @param arguments The parameter for the call to the operation.
	 */
	public void EGQueryInterface(String[] arguments) {
		// due to the operations array, it is the 1st entry, zero based indexing
		lastCalled = 0;
		// new chance to cause an error
		errorCaused = false;
		Map<String, String> argMap = parseArguments(arguments);
		try {
			RequestEGQuery eGQuery = new RequestEGQuery(argMap, service);
			opList.set(lastCalled, eGQuery);
		} catch (RemoteException e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (ErrorFromWebserviceExeption e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		}
	}

	/**
	 * This is the interface for the "run_eInfo" operation from the NCBI web
	 * service.
	 * 
	 * @param arguments The arguments for the operation. This is a string array
	 *           with the parameter.
	 */
	public void EInfoInterface(String[] arguments) {
		// due to the operations array, it is the 2nd entry, zero based indexing
		lastCalled = 1;
		// new chance to cause an error
		errorCaused = false;
		Map<String, String> argMap = parseArguments(arguments);
		try {
			RequestEInfo eInfo = new RequestEInfo(argMap, service);
			opList.set(lastCalled, eInfo);
		} catch (RemoteException e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (ErrorFromWebserviceExeption e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		}
	}

	/**
	 * This is the interface for the "run_eSearch" operation from the NCBI web
	 * service.
	 * 
	 * @param arguments The arguments for the operation. This is a string array
	 *           with the parameter.
	 */
	public void ESearchInterface(String[] arguments) {
		// due to the operations array, it is the 3rd entry, zero based indexing
		lastCalled = 2;
		// new chance to cause an error
		errorCaused = false;
		Map<String, String> argMap = parseArguments(arguments);
		try {
			RequestESearch eSearch = new RequestESearch(argMap, service);
			opList.set(lastCalled, eSearch);
		} catch (RemoteException e) {
			defaultLogger.error("Error occured: ", e);
		} catch (ErrorFromWebserviceExeption e) {
			defaultLogger.error("Error occured: ", e);
		}
	}

	/**
	 * This is the interface for the "run_eSummary" operation from the NCBI web
	 * service.
	 * 
	 * @param arguments The arguments for the operation. This is a string array
	 *           with the parameter.
	 */
	public void ESummaryInterface(String[] arguments) {
		// due to the operations array, it is the 4th entry, zero based indexing
		lastCalled = 3;
		// new chance to cause an error
		errorCaused = false;
		Map<String, String> argMap = parseArguments(arguments);
		try {
			RequestESummary eSummary = new RequestESummary(argMap, service);
			opList.set(lastCalled, eSummary);
		} catch (RemoteException e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (ErrorFromWebserviceExeption e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		}
	}

	/**
	 * This is the interface for the "run_eLink" operation from the NCBI web
	 * service.
	 * 
	 * @param arguments The arguments for the operation. This is a string array
	 *           with the parameter.
	 */
	public void ELinkInterface(String[] arguments) {
		// due to the operations array, it is the 5th entry, zero based indexing
		lastCalled = 4;
		// new chance to cause an error
		errorCaused = false;
		Map<String, String> argMap = parseArguments(arguments);
		try {
			RequestELink eLink = new RequestELink(argMap, service);
			opList.set(lastCalled, eLink);
		} catch (RemoteException e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (ErrorFromWebserviceExeption e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		}
	}

	/**
	 * This is the interface for the "run_eSpell" operation from the NCBI web
	 * service.
	 * 
	 * @param arguments The arguments for the operation. This is a string array
	 *           with the parameter.
	 */
	public void ESpellInterface(String[] arguments) {
		// due to the operations array, it is the 6th entry, zero based indexing
		lastCalled = 5;
		// new chance to cause an error
		errorCaused = false;
		Map<String, String> argMap = parseArguments(arguments);
		try {
			RequestESpell eSpell = new RequestESpell(argMap, service);
			opList.set(lastCalled, eSpell);
		} catch (RemoteException e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (ErrorFromWebserviceExeption e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		}
	}

	/**
	 * This is the interface for the "run_ePost" operation from the NCBI web
	 * service.
	 * 
	 * @param arguments The arguments for the operation. This is a string array
	 *           with the parameter.
	 */
	public void EPostInterface(String[] arguments) {
		// due to the operations array, it is the 7th entry, zero based indexing
		lastCalled = 6;
		// new chance to cause an error
		errorCaused = false;
		Map<String, String> argMap = parseArguments(arguments);
		try {
			RequestEPost ePost = new RequestEPost(argMap, service);
			opList.set(lastCalled, ePost);
		} catch (RemoteException e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (ErrorFromWebserviceExeption e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		}
	}

	/**
	 * This is the interface for the "run_eFetch" operations from the NCBI web
	 * service. The operation is divided in separate operation for each database
	 * of the efetch request. The database has to be set before this method was
	 * called.
	 * 
	 * @param arguments The arguments for the operation. This is a string array
	 *           with the parameter.
	 */
	public void EFetchInterface(String[] arguments) {
		Map<String, String> argMap = parseArguments(arguments);
		// simply call the callService method from the eFetch object
		try {
			eFetch.setProxyProperties(proxyProperties);
			eFetch.CallService(argMap);
		} catch (ErrorFromWebserviceExeption e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (RemoteException e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		}
	}

	/**
	 * Initiates the efetch object depending on the provided database.
	 * 
	 * @param db The database for which the efetch operation should be initiated.
	 */
	public void initEFetchOperation(String db) {
		// due to the operations array, it is the 8th entry, zero based indexing
		lastCalled = 7;
		// new chance to cause an error
		errorCaused = false;
		try {
			eFetch = new RequestEFetch(db);
			opList.set(lastCalled, eFetch);
			// the operation parameter of the efetch operation should be available
			// now
		} catch (RemoteException e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (ErrorFromWebserviceExeption e) {
			errorCaused = true;
			defaultLogger.error("Error occured: ", e);
		} catch (ClassNotFoundException e) {
			errorCaused = true;
			defaultLogger.error("Error occured while initializing EFetch class: ", e);
		} catch (RuntimeException e) {
			errorCaused = true;
			defaultLogger.error("Error occured while initializing EFetch class: ", e);
		} catch (NoSuchMethodException e) {
			errorCaused = true;
			defaultLogger.error("Error occured while initializing EFetch class: ", e);
		} catch (InstantiationException e) {
			errorCaused = true;
			defaultLogger.error("Error occured while initializing EFetch class: ", e);
		} catch (IllegalAccessException e) {
			errorCaused = true;
			defaultLogger.error("Error occured while initializing EFetch class: ", e);
		} catch (InvocationTargetException e) {
			errorCaused = true;
			defaultLogger.error("Error occured while initializing EFetch class: ", e);
		}
	}

	/**
	 * Parses the arguments from a string array and returns a map with them. <br>
	 * The array is build like this: {argName01, value01, argName02, value02}.
	 * 
	 * @param arguments The string array of arguments.
	 * @return The map with the arguments in it.
	 */
	private Map<String, String> parseArguments(String[] arguments) {
		Map<String, String> argMap = new HashMap<String, String>();
		// parse the string array and save to the map
		for (int i = 0; i < arguments.length; i += 2) {
			argMap.put(arguments[i], arguments[i + 1]);
		}
		return argMap;
	}

	/**
	 * Provides a list of the operations of the NCBI web service.
	 * 
	 * @return An array of operation names.
	 */
	public String[] getOperations() {
		return operations;
	}

	/**
	 * Returns a string array with the parameters, the given operation expects.
	 * 
	 * @param req The operation.
	 * @return The array of strings with the parameters inside or null, if the
	 *         parameter was not found.
	 */
	public String[] getRequestParameter(String req) {
		if (!req.startsWith("run_")) {
			// append the run_ part of the operation, if not provided
			req = "run_" + req;
		}
		try {
			// take a look at the operations array
			if (req.equalsIgnoreCase(operations[0])) {
				// eGquery
				return EGqueryRequest.getOperationParameter();
			}
			if (req.equalsIgnoreCase(operations[1])) {
				// eInfo
				return EInfoRequest.getOperationParameter();
			}
			if (req.equalsIgnoreCase(operations[2])) {
				// eSearch
				return ESearchRequest.getOperationParameter();
			}
			if (req.equalsIgnoreCase(operations[3])) {
				// eSummary
				return ESummaryRequest.getOperationParameter();
			}
			if (req.equalsIgnoreCase(operations[4])) {
				// eLink
				return ELinkRequest.getOperationParameter();
			}
			if (req.equalsIgnoreCase(operations[5])) {
				// eSpell
				return ESpellRequest.getOperationParameter();
			}
			if (req.equalsIgnoreCase(operations[6])) {
				// ePost
				return EPostRequest.getOperationParameter();
			}
			if (req.equalsIgnoreCase(operations[7])) {
				if (eFetch != null) {
					// eFetch
					return eFetch.getOperationParameter();	
				} else {
					throw new IllegalStateException("No EFetch database selected yet.");
				}
			}
			// if this method is still active, the operation was not found.
			throw new OperationNotFoundException("Operation \"" + req + "\" not found");
		} catch (OperationNotFoundException e) {
			defaultLogger.error("Error occured: ", e);
		} catch (IllegalStateException e) {
			defaultLogger.error("Error occured: ", e);
		}
		return null;
	}

	/**
	 * Returns the parameter of the result from the last called operation.
	 * 
	 * @return The parameter of the result from the last called operation as
	 *         String[].
	 */
	public String[] getResultParameter() {
		// The only accessible methods are provided by the RequestInterface,
		// together with lastCalled we can simply access the getParameters method,
		// through the List.
		if (lastCalled == -1) {
			return null;
		}
		return ((RequestInterface) opList.get(lastCalled)).getParameter();
	}

	/**
	 * This will return the parameter for the given parameter name. It should be
	 * a complex object. <br>
	 * If the parameter is not part of the current result, the return value will
	 * be <code>null</code>.
	 * 
	 * @param name The complex object, the user desires the parameter names for.
	 * @return The parameter names of the complex object, else <code>null</code>.
	 */
	public String[] getResultParameterByName(String name) {
		try {
			if (lastCalled == -1) {
				throw new NoResultSoFarException("No operation yet called.");
			}
			return ((RequestInterface) opList.get(lastCalled)).getParameterByName(name);
		} catch (ParameterNotFoundException e) {
			defaultLogger.error("Error occured: ", e);
		} catch (NoResultSoFarException e) {
			defaultLogger.error("Error occured: ", e);
		}
		return null;
	}

	/**
	 * Returns the complex types of the last result in an array. <br/>
	 * The array will look like this:<br/>
	 * Every element will be separated with a break word {@link #BREAKWORD}.
	 * <ol>
	 * <li>1st element: The parameter names of the complex types. Separated by
	 * the break word.</li>
	 * <li>2nd element: Values of the first parameter</li>
	 * <li>3rd element: Values of the second parameter</li>
	 * <li>...</li>
	 * <li>nth element: Values of the (n-1)th parameter</li>
	 * </ol>
	 * 
	 * @param name The name of the complex type.
	 * @return The complex types serialized to an array of strings or null.
	 */
	public String[] getComplexType(String name) {
		try {
			return ((RequestInterface) opList.get(lastCalled)).getComplexType(name);
		} catch (ParameterNotFoundException e) {
			defaultLogger.error("Error occured: ", e);
		}
		return null;
	}

	/**
	 * As the name implies, this returns a simple type, which is identified by
	 * the argument.
	 * 
	 * @param name The name for the simple type.
	 * @return The value of the simple type. Or <code>null</code> if not found.
	 */
	public String getSimpleType(String name) {
		try {
			return ((RequestInterface) opList.get(lastCalled)).getSimpleType(name);
		} catch (ParameterNotFoundException e) {
			defaultLogger.error("Error occured: ", e);
		}
		return null;
	}

	/**
	 * This provides the caller with a map, which contains all the result
	 * parameters as keys and their values as values. This map contains only
	 * complex types, the value will NOT be an instance of String but of
	 * {@link TypeInterface}[].
	 * 
	 * @return A map. If exception was thrown, <code>null</code> will be
	 *         returned.
	 * @deprecated We use the string solution.
	 */
	public Map<String, TypeInterface[]> getComplexResultMap() {
		try {
			Map<String, TypeInterface[]> returnMap = new HashMap<String, TypeInterface[]>();
			Map<String, Object> tmpMap = ((RequestInterface) opList.get(lastCalled)).getResultMap();
			for (String key : tmpMap.keySet()) {
				if (!(tmpMap.get(key) instanceof String)) {
					returnMap.put(key, (TypeInterface[]) tmpMap.get(key));
				}
			}
			return returnMap;
		} catch (NoResultSoFarException e) {
			defaultLogger.error("Error occured: ", e);
		}
		return null;
	}

	/**
	 * This provides the caller with a map, which contains all the result
	 * parameters as keys and their values as values. This map contains only
	 * complex types, the value will NOT be an instance of String but of
	 * {@link TypeInterface}[].
	 * 
	 * @return A map. If exception was thrown, <code>null</code> will be
	 *         returned.
	 * @deprecated We use the string solution.
	 */
	public Map<String, String> getSimpleResultMap() {
		try {
			Map<String, String> returnMap = new HashMap<String, String>();
			Map<String, Object> tmpMap = ((RequestInterface) opList.get(lastCalled)).getResultMap();
			for (String key : tmpMap.keySet()) {
				if ((tmpMap.get(key) instanceof String)) {
					returnMap.put(key, (String) tmpMap.get(key));
				}
			}
			return returnMap;
		} catch (NoResultSoFarException e) {
			defaultLogger.error("Error occured: ", e);
		}
		return null;
	}

	/**
	 * Returns a map with all parameters and their values.
	 * 
	 * @return The map or null.
	 */
	public Map<String, Object> getResultMap() {
		try {
			return ((RequestInterface) opList.get(lastCalled)).getResultMap();
		} catch (NoResultSoFarException e) {
			defaultLogger.error("Error occured: ", e);
		}
		return null;
	}

	/**
	 * Necessary for the R function.
	 * 
	 * @return Whether the result from eInfo is a list of dbNames or a dbInfo
	 *         object.
	 */
	public boolean isDbInfo() {
		return ((RequestEInfo) opList.get(1)).isDbInfo();
	}

	public String[] getDbNames() {
		return ((RequestEInfo) opList.get(1)).getDbNames();
	}

	public boolean isErrorCaused() {
		return errorCaused;
	}

	/**
	 * The word to break the string.
	 * 
	 * @return The breakword.
	 */
	public static String getBreakword() {
		return BREAKWORD;
	}

	public static String getTrue() {
		return VALUE_TRUE;
	}

	public static String getFalse() {
		return VALUE_FALSE;
	}

	public static String getSubset() {
		return SUBSET;
	}

	public static String getEmptyValue() {
		return EMPTY_VALUE;
	}

	public static String getEnd() {
		return END;
	}

	public static String getXmlArrayIndicator() {
		return XML_ARRAY_INDICATOR;
	}

	public static String getXmlObjectIndicator() {
		return XML_OBJECT_INDICATOR;
	}

	public static String getXmlEntryIndicator() {
		return XML_ENTRY_INDICATOR;
	}

	public static String getXmlNameAttribute() {
		return XML_NAME_ATTRIBUTE;
	}

	public static String getXmlLengthAttribute() {
		return XML_LENGTH_ATTRIBUTE;
	}

	/**
	 * Returns the databases, which can be accessed by the eFetch operation.
	 * 
	 * @return The databases is sorted order.
	 */
	public static String[] getEFetchDatabases() {
		return RequestEFetch.getDatabases();
	}

	/**
	 * Sets the user name and password to the {@link ProxyProperties} object.
	 * 
	 * @param username Name of the user.
	 * @param password Password of the user.
	 */
	public void setProxyUser(String username, String password) {
		proxyProperties.setUserName(username);
		if (!password.isEmpty()) {
			proxyProperties.setPassWord(password);
		}
	}

	public void storeResult(String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			if (filename.equalsIgnoreCase("eLinkResult")) {
				out.writeObject(((RequestELink) opList.get(4)).getResult());
			}
			if (filename.equalsIgnoreCase("eSearchResult")) {
				out.writeObject(((RequestESearch) opList.get(2)).getResult());
			}
			if (filename.equalsIgnoreCase("eFetchResult")) {
				out.writeObject(((RequestEFetch) opList.get(7)).getResult());
			}
			out.close();
		} catch (FileNotFoundException e) {
			defaultLogger.error("Error occured: ", e);
		} catch (IOException e) {
			defaultLogger.error("Error occured: ", e);
		}
	}

	public String getComplFromStoredResult(boolean elink) {
		String values = "";
		String fileName = "";
		ESearchResult sResult = null;
		ELinkResult lResult = null;
		// load the object from the ncbi result
		if (elink) {
			fileName = "/home/master/work-workspace/R-NCBI-Plugin/eLinkResult";
		} else {
			fileName = "/home/master/work-workspace/R-NCBI-Plugin/eSearchResult";
		}
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fis);
			if (elink) {
				lResult = (ELinkResult) oin.readObject();
			} else {
				sResult = (ESearchResult) oin.readObject();
			}
		} catch (FileNotFoundException e) {
			defaultLogger.error("Error occured: ", e);
		} catch (IOException e) {
			defaultLogger.error("Error occured: ", e);
		} catch (ClassNotFoundException e) {
			defaultLogger.error("Error occured: ", e);
		}
		if (elink) {
			Stack<String> sse = new Stack<String>();
			sse.push("linkset");
			values = Utils.recStructureBuild(values, lResult.getLinkSet(), new Stack<String>(), sse, false, 0);
		} else {
			Stack<String> ss = new Stack<String>();
			ss.push("translationstack");
			values = Utils.recStructureBuild(values, sResult.getTranslationStack(), new Stack<String>(), ss, false, 0);
		}
		if (values.startsWith(RInterface.BREAKWORD)) {
			values = values.substring(RInterface.BREAKWORD.length(), values.length());
		} else if (values.startsWith(RInterface.SUBSET)) {
			values = values.substring(RInterface.SUBSET.length(), values.length());
		}
		return values;
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			service.cleanup();
		} finally {
			super.finalize();
		}
	}
}
