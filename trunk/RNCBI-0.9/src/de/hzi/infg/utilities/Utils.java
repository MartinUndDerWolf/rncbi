package de.hzi.infg.utilities;

import gov.nih.nlm.ncbi.www.soap.eutils.esearch.TranslationStackTypeChoice;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis2.databinding.types.NMToken;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import de.hzi.infg.RInterface;
import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;
import de.hzi.infg.interfaces.TypeInterface;

/**
 * A class full of static tools!
 * 
 * @author Martin Schumann
 * 
 */
public class Utils {

	/**
	 * Non instantiable utility class
	 */
	private Utils() {
		throw new AssertionError("Do not instantiate this class!");
	}

	/**
	 * Retrieves the get methods for the given name from the given class.
	 * 
	 * @param name The name of the get method
	 * @param clazz The class to retrieve from.
	 * @return A getter method of the given class or null, if not found.
	 */
	public static Method getGetMethodByName(String name, Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		Method meth = null;
		String getMethodName = "get" + name;
		for (Method method : methods) {
			// get methods should have no parameter
			if (method.getGenericParameterTypes().length > 0) {
				continue;
			}
			if (method.getName().startsWith("get") && method.getName().toLowerCase().equals(getMethodName.toLowerCase())) {
				// System.out.println("Get found: "+method.getName());
				meth = method;
				break;
			}
		}
		return meth;
	}

	/**
	 * Retrieves the set methods for the given name from the given class.
	 * 
	 * @param name The name of the set method
	 * @param clazz The class to retrieve from.
	 * @return A setter method of the given class or null, if not found.
	 */
	public static Method getSetMethodByName(String name, Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		Method meth = null;
		for (Method method : methods) {
			if (method.getName().startsWith("set") && method.getName().toLowerCase().endsWith(name.toLowerCase())) {
				// System.out.println("Set found: "+method.getName());
				meth = method;
				// found what we were looking for
				break;
			}
		}
		return meth;
	}

	/**
	 * The recursive method to parse complex types of arbitrary deep.<br>
	 * The returned string contains the sub types. <br>
	 * e.g. In the case of eSearch the "translationstacktypechoice"
	 * {@link TranslationStackTypeChoice} consists of the string "op" and the
	 * complex type "termset". If the termset is empty, the string will have
	 * "termset - empty". If one sub type ends, the {@link RInterface#END}
	 * keyword is set.
	 * 
	 * @param values The string to elongate.
	 * @param thisObject The object, which can be null, a string, an array or a
	 *           class from the ncbi package.
	 * @param subTypeStack A stack with the sub type elements inside. On top is
	 *           always the recent sub type.
	 * @param isArray If the call comes from the loop of an array.
	 * @param deepness The deepness of the recursion.
	 * @return A string with the sub types in reverse order in front of the
	 *         values itself.
	 * @deprecated Use the xml string creating method
	 *             {@link #recStructureBuild(String, Object, Stack, Stack, boolean, int)}
	 */
	public static String recursiveMethod(String values, Object thisObject, Stack<String> subTypeStack, boolean isArray, int deepness) {
		String prefix = "";
		for (int i = 0; i < deepness; i++) {
			prefix += i + "\t";
		}
		// four possible cases: null, String, Array, NCBI Class
		if (thisObject == null) {
			System.out.println(prefix + "Empty: " + getStackOld(subTypeStack, false) + " = empty");
			// in this case, we return the EMPTY_VALUE string from RInterface
			return values + RInterface.BREAKWORD + RInterface.EMPTY_VALUE + getStackOld(subTypeStack, !isArray);
		} else if (thisObject instanceof String) {
			System.out.println(prefix + "String: " + getStackOld(subTypeStack, false) + " " + thisObject);
			// a simple string
			return values + RInterface.BREAKWORD + thisObject + getStackOld(subTypeStack, !isArray);
		} else if (thisObject.getClass().isArray()) {
			System.out.println(prefix + "Array of: " + thisObject.getClass().getName() + " length: " + ((Object[]) thisObject).length);
			// this is an array, we don't know what data type the elements are,
			// so we simply call this method with the each object of the array.
			Object[] recurObject = (Object[]) thisObject;
			for (Object object : recurObject) {
				values = recursiveMethod(values, object, subTypeStack, true, deepness + 1);
			}
			if (subTypeStack.size() > 0) {
				subTypeStack.pop();
			}
			System.out.println(prefix + getStackOld(subTypeStack, false) + " END ARRAY");
			return values;
		} else if (thisObject.getClass().getPackage().getName().startsWith(RInterface.NCBI_PACKAGE)) {
			System.out.println(prefix + "NCBI object: " + thisObject.getClass().getName() + " " + getStackOld(subTypeStack, false));
			// this is an object of the NCBI package
			// so we use getParametersMap and call this method for each parameter
			Map<String, Object> recursiveMap = ((TypeInterface) thisObject).getParametersMap();
			for (String recKey : recursiveMap.keySet()) {
				// put this key on the stack, it is the subtype
				subTypeStack.push(RInterface.SUBSET + recKey);
				values = recursiveMethod(values, recursiveMap.get(recKey), subTypeStack, false, deepness + 1);
			}
			System.out.println(prefix + getStackOld(subTypeStack, false) + " END");
			if ((subTypeStack.size() > 0) && !isArray) {
				subTypeStack.pop();
			}
			// this will indicate the end of the subset
			return values + RInterface.END;
		}
		return values;
	}

	/**
	 * This is to reduce the complexity of the recursive method a little bit. It
	 * returns all elements of the given stack and removes the element on top of
	 * the stack (it pops). If we have an array, the element on top will not be
	 * removed, because it will be always the same for every item in the array.
	 * 
	 * @param subTypeStack The stack to get the elements from.
	 * @param pop If the element on top should be removed. This will be false in
	 *           case of arrays.
	 * @return A string concatenated with all elements from the stack, leaving
	 *         all elements but the first (on top).
	 * @deprecated Used by a deprecated recursive method.
	 */
	private static String getStackOld(Stack<String> subTypeStack, boolean pop) {
		String retString = "";
		for (String string : subTypeStack) {
			// prevent subtypes to appear multiple times
			// this is due to the fact, that we have to regard arrays.
			retString += string;
		}
		if (pop) {
			subTypeStack.pop();
		}
		return retString;
	}

	/**
	 * New version of the recursive function. This will create an xml string now.
	 * 
	 * @param values The string to elongate.
	 * @param thisObject The object, which will be checked.
	 * @param arrayStack The stack for the array types.
	 * @param subTypeStack The stack for the subtypes.
	 * @param isArray Boolean whether an array will be checked.
	 * @param deepness The deepness of the recursion.
	 * @return An xml string with the structure of the given object.
	 */
	public static String recStructureBuild(String values, Object thisObject, Stack<String> arrayStack, Stack<String> subTypeStack, boolean isArray,
			int deepness) {
		String prefix = "";
		// could be a \n for better reading the output
		String suffix = "";
		// for (int i = 0; i < deepness; i++) {
		// prefix += "\t";
		// }
		// four possible cases: null, String, Array, NCBI Class
		if (thisObject == null) {
			// in this case, we return the EMPTY_VALUE string from RInterface
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), true, false, true, 0) + RInterface.EMPTY_VALUE
					+ getXMLElement("", false, false, true, 0) + suffix;
			return values;
		} else if ((thisObject instanceof String) || (thisObject instanceof Integer) || (thisObject instanceof BigInteger)
				|| (thisObject instanceof Double) || (thisObject instanceof Boolean)) {
			// a simple String or Integer or Double or BigInteger or Boolean
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), true, false, true, 0) + thisObject
					+ getXMLElement("", false, false, true, 0) + suffix;
			return values;
		} else if (thisObject.getClass().isArray()) {
			boolean removeFromStack = false;
			// set the class as name, if there is nothing on the stack
			String tmp = thisObject.getClass().getSimpleName().toLowerCase();
			if (!getStack(subTypeStack, false).isEmpty()) {
				tmp = getStack(subTypeStack, false);
			}
			values += prefix + getXMLElement(tmp, true, true, false, ((Object[]) thisObject).length) + suffix;
			// this is an array, we don't know what data type the elements are,
			// so we simply call this method with the each object of the array.
			Object[] recurObject = (Object[]) thisObject;
			arrayStack.push(tmp);
			for (int i = 0; i < recurObject.length; i++) {
				Object object = recurObject[i];
				values = recStructureBuild(values, object, arrayStack, subTypeStack, true, deepness + 1);
				// remove from stack, if this is the last element in the array
				if (i == recurObject.length - 1) {
					removeFromStack = true;
				}
			}
			// usually this is not necessary with the boolean, but without strange
			// results occured
			// remove from the stack
			if (removeFromStack) {
				getStack(subTypeStack, true);
			}
			values += prefix + getXMLElement(arrayStack.pop(), false, true, false, 0) + suffix;
			return values;
		} else if (thisObject.getClass().getPackage().getName().startsWith(RInterface.NCBI_PACKAGE)) {
			values += prefix + getXMLElement(getStack(subTypeStack, false), true, false, false, 0) + suffix;
			// this is an object of the NCBI package
			// so we use getParametersMap and call this method for each parameter
			Map<String, Object> recursiveMap = ((TypeInterface) thisObject).getParametersMap();
			for (String recKey : recursiveMap.keySet()) {
				subTypeStack.push(recKey);
				values = recStructureBuild(values, recursiveMap.get(recKey), arrayStack, subTypeStack, false, deepness + 1);
			}
			// this will indicate the end of the subset
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), false, false, false, 0) + suffix;
			return values;
		} else {
			try {
				throw new Exception("Unhandled object: " + thisObject.getClass().getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return values;
	}

	/**
	 * This will return an opening or closing xml tag.
	 * 
	 * @param name The name of the subtype.
	 * @param open Boolean which indicates to open or close.
	 * @param isArray Boolean which indicates whether an array tag or not.
	 * @param isEntry Boolean to indicate whether this will be an entry tag or
	 *           not.
	 * @param length The length of the array, if this will be one, else this will
	 *           be zero.
	 * @return The xml tag as a string.
	 */
	private static String getXMLElement(String name, boolean open, boolean isArray, boolean isEntry, int length) {
		String retString = "";
		if (open) {
			retString += "<";

			if (isArray) {
				retString += RInterface.XML_ARRAY_INDICATOR;
				retString += " " + RInterface.XML_NAME_ATTRIBUTE + "=\"" + name + "\"";
				retString += " " + RInterface.XML_LENGTH_ATTRIBUTE + "=\"" + Integer.toString(length) + "\"";
			} else if (isEntry) {
				retString += RInterface.XML_ENTRY_INDICATOR;
				retString += " " + RInterface.XML_NAME_ATTRIBUTE + "=\"" + name + "\"";
			} else {
				retString += RInterface.XML_OBJECT_INDICATOR;
				retString += " " + RInterface.XML_NAME_ATTRIBUTE + "=\"" + name + "\"";
			}
			retString += ">";
		} else {
			retString += "</";
			if (isArray) {
				retString += RInterface.XML_ARRAY_INDICATOR;
			} else if (isEntry) {
				retString += RInterface.XML_ENTRY_INDICATOR;
			} else {
				retString += RInterface.XML_OBJECT_INDICATOR;
			}
			retString += ">";
		}
		return retString;
	}

	/**
	 * This returns the element on top of the given stack. If pop is true, then
	 * the element will be removed and returned. Else it will be leaved on the
	 * stack and returned.
	 * 
	 * @param subTypeStack The stack to work with.
	 * @param pop Boolean, whether remove the element on top or not.
	 * @return The element on top of the stack.
	 */
	private static String getStack(Stack<String> subTypeStack, boolean pop) {
		String retString = "";
		if (subTypeStack.size() > 0) {
			if (pop) {
				retString = subTypeStack.pop();
			} else {
				retString = subTypeStack.peek();
			}
		}
		return retString;
	}

	/**
	 * This method creates a string array with the the parameters of the result. <br>
	 * Every second value in the array shows whether the parameter is a complex
	 * type or not.
	 * 
	 * @param resClazz The class for which the parameters should be returned.
	 *           This should be a result from the ncbi webservice.
	 * @return A string array with name and a boolean next to it, whether it is a
	 *         complex type or not. e.g. {Name,false,LinkList,true}
	 */
	public static String[] getParameter(Class<?> resClazz) {
		ArrayList<String> tmpList = new ArrayList<String>();
		Method[] methods = resClazz.getMethods();
		// iterate through the methods, only set methods, because these are the
		// parameters.
		for (Method method : methods) {
			// this is for the xmlbeans classes, but also works for the adb classes
			if (method.getDeclaringClass().getName().startsWith(RInterface.NCBI_PACKAGE)) {
				// we use the setter methods, because there are no methods like the
				// "getPullParser" method
				if (method.getName().startsWith("set") && !method.getName().equalsIgnoreCase("seterror")) {
					Class<?>[] parameterTypes = method.getParameterTypes();
					for (Class<?> type : parameterTypes) {
						// remove the set from the method name and transform to lower
						// case
						String tmpParName = method.getName().substring(3).toLowerCase();
						if (type.isArray()) {
							tmpList.add(tmpParName);
							tmpList.add(RInterface.VALUE_TRUE);
						} else if (type.getPackage().getName().startsWith(RInterface.NCBI_PACKAGE)) {
							tmpList.add(tmpParName);
							tmpList.add(RInterface.VALUE_TRUE);
						} else {
							tmpList.add(tmpParName);
							tmpList.add(RInterface.VALUE_FALSE);
						}
					}
				}
			}
		}
		return (String[]) tmpList.toArray(new String[tmpList.size()]);
	}

	/**
	 * Checks whether the parameter which were supplied are correct for this
	 * operation.
	 * 
	 * @param paraSet The set of parameter to check.
	 * @param operationParameter The parameter the request expects.
	 * @return Whether the parameter set fits to the operations or not.
	 */
	public static boolean checkParameter(Set<String> paraSet, String[] operationParameter) {
		Set<String> tmpSet = new HashSet<String>();
		for (String string : operationParameter) {
			tmpSet.add(string);
		}
		if (paraSet.size() != tmpSet.size()) {
			return false;
		}
		for (String para : paraSet) {
			if (!tmpSet.contains(para.toLowerCase()))
				return false;
		}
		return true;
	}

	/**
	 * This takes a setter method name and transforms it to better fit the common
	 * used parameter names. This means all low cases and "set" removed. E.g. the
	 * method name is "setQuery_key", which will be transformed to "query_key".
	 * 
	 * @param name The name of the setter method.
	 * @param startsWith The string, with which the method name starts.
	 * @return The name of the parameter conformed to the common used ones.
	 */
	public static String transformMethodName(String name, String startsWith) {
		String retString = "";
		// first remove set or get
		retString = name.substring(startsWith.length(), name.length()).toLowerCase();
		// retString = retString.replace("_", "");
		return retString;
	}

	/**
	 * This method parses the arguments map and invokes the appropriate setter
	 * methods of the request object. This method only supports setId method,
	 * which take a string as argument. If the setId method takes an array, don't
	 * use this method.
	 * 
	 * @param request The request which should recieve the parameter.
	 * @param arguments The parameter and values to set.
	 * @throws ErrorFromWebserviceExeption If something was wrong with the
	 *            parameter.
	 */
	public static void setParameterToRequest(Object request, Map<String, String> arguments) throws ErrorFromWebserviceExeption {
		boolean somethingSet = false;
		String idString = "";
		boolean idToSet = false;
		for (String key : arguments.keySet()) {
			if (!arguments.get(key).isEmpty()) {
				String[] idAr;
				// in this case, the id parameter is an array of strings
				// so we check whether there is the BREAKWORD and then split the
				// string
				if (key.equalsIgnoreCase("id")) {
					// this always have to be a string array!
					String tmpId = arguments.get(key);
					// split the string
					idAr = tmpId.split(RInterface.ESCAPED_BREAKWORD);
					for (int i = 0; i < idAr.length; i++) {
						if (i == idAr.length - 1) {
							idString += idAr[i];
						} else {
							idString += idAr[i] + ",";
						}
					}
					idToSet = true;
				}
				// something was set
				somethingSet = true;
				// get setter method
				Method setMethod = Utils.getSetMethodByName(key, request.getClass());
				try {
					if (idToSet) {
						// create an object array with the array as init parameter
						setMethod.invoke(request, idString);
						idToSet = false;
					} else {
						setMethod.invoke(request, arguments.get(key));
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
	}

	/**
	 * This is nearly the same as the recursive method
	 * {@link #recStructureBuild(String, Object, Stack, Stack, boolean, int)},
	 * with the one difference, that there is no {@link TypeInterface} anymore.
	 * Instead of this, we have to get the sub objects on our own from the class
	 * with the {@link #getTypeMap(Object)} method.
	 * 
	 * @param values The string to elongate.
	 * @param thisObject The object, which will be checked.
	 * @param arrayStack The stack for the array types.
	 * @param subTypeStack The stack for the subtypes.
	 * @param isArray Boolean whether an array will be checked.
	 * @param deepness The deepness of the recursion.
	 * @return An xml string with the structure of the given object.
	 */
	public static String recStructureBuildEFetch(String values, Object thisObject, Stack<String> arrayStack, Stack<String> subTypeStack,
			boolean isArray, int deepness) {
		String prefix = "";
		// could be a \n for better reading the output
		String suffix = "";
		// for (int i = 0; i < deepness; i++) {
		// prefix += "\t";
		// }
		// four possible cases: null, String, Array, NCBI Class
		if (thisObject == null) {
			// in this case, we return the EMPTY_VALUE string from RInterface
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), true, false, true, 0) + RInterface.EMPTY_VALUE
					+ getXMLElement("", false, false, true, 0) + suffix;
			return values;
		} else if ((thisObject instanceof String)) {
			// a simple String
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), true, false, true, 0) + StringEscapeUtils.escapeXml((String) thisObject)
					+ getXMLElement("", false, false, true, 0) + suffix;
			return values;
		} else if ((thisObject instanceof Integer) || (thisObject instanceof BigInteger) || (thisObject instanceof Double)
				|| (thisObject instanceof Boolean)) {
			// a simple Integer or Double or BigInteger or Boolean
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), true, false, true, 0) + thisObject
					+ getXMLElement("", false, false, true, 0) + suffix;
			return values;
		} else if (thisObject.getClass().isArray()) {
			boolean removeFromStack = false;
			// set the class as name, if there is nothing on the stack
			String tmp = thisObject.getClass().getSimpleName().toLowerCase();
			if (!getStack(subTypeStack, false).isEmpty()) {
				tmp = getStack(subTypeStack, false);
			}
			if (((Object[]) thisObject).length > 0) {
				values += prefix + getXMLElement(tmp, true, true, false, ((Object[]) thisObject).length) + suffix;
			}
			// this is an array, we don't know what data type the elements are,
			// so we simply call this method with the each object of the array.
			Object[] recurObject = (Object[]) thisObject;
			arrayStack.push(tmp);
			for (int i = 0; i < recurObject.length; i++) {
				Object object = recurObject[i];
				values = recStructureBuildEFetch(values, object, arrayStack, subTypeStack, true, deepness + 1);
				// remove from stack, if this is the last element in the array
				if (i == recurObject.length - 1) {
					removeFromStack = true;
				}
			}
			// usually this is not necessary with the boolean, but without strange
			// results occured
			// remove from the stack
			if (removeFromStack) {
				getStack(subTypeStack, true);
			}
			if (((Object[]) thisObject).length > 0) {
				values += prefix + getXMLElement(arrayStack.pop(), false, true, false, 0) + suffix;
			}
			return values;
		} else if (thisObject.getClass().getPackage().getName().startsWith(RInterface.NCBI_PACKAGE)) {
			values += prefix + getXMLElement(getStack(subTypeStack, false), true, false, false, 0) + suffix;
			// this is an object of the NCBI package
			// so we use getParametersMap and call this method for each parameter
			Map<String, Object> recursiveMap = getTypeMap(thisObject);
			for (String recKey : recursiveMap.keySet()) {
				// // value is the result of a getValue method
				// if (recKey.equalsIgnoreCase("value")) {
				// // this will remove objects, if there are two getValue methods in
				// a row
				// // System.out.println(recKey+" - "+recursiveMap.get(recKey));
				// continue;
				// }
				subTypeStack.push(recKey);
				values = recStructureBuildEFetch(values, recursiveMap.get(recKey), arrayStack, subTypeStack, false, deepness + 1);
			}
			// this will indicate the end of the subset
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), false, false, false, 0) + suffix;
			return values;
		} else {
			try {
				throw new Exception("Unhandled object: " + thisObject.getClass().getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return values;
	}

	/**
	 * This is nearly the same as the recursive method
	 * {@link #recStructureBuildEFetch(String, Object, Stack, Stack, boolean, int)}
	 * , with the one difference, that it uses another method for
	 * {@link #getTypeMapForXmlBeans(Object)}.
	 * 
	 * @param values The string to elongate.
	 * @param thisObject The object, which will be checked.
	 * @param arrayStack The stack for the array types.
	 * @param subTypeStack The stack for the subtypes.
	 * @param isArray Boolean whether an array will be checked.
	 * @param deepness The deepness of the recursion.
	 * @return An xml string with the structure of the given object.
	 */
	public static String recStructureBuildForXmlBeans(String values, Object thisObject, Stack<String> arrayStack, Stack<String> subTypeStack,
			boolean isArray, int deepness) {
		String prefix = "";
		// could be a \n for better reading the output
		String suffix = "";
		// for (int i = 0; i < deepness; i++) {
		// prefix += "\t";
		// }
		// four possible cases: null, String, Array, NCBI Class
		if (thisObject == null) {
			// in this case, we return the EMPTY_VALUE string from RInterface
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), true, false, true, 0) + RInterface.EMPTY_VALUE
					+ getXMLElement("", false, false, true, 0) + suffix;
			return values;
		} else if (thisObject instanceof XmlAnySimpleType) {
			// a simple String or Integer or Double or BigInteger or Boolean
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), true, false, true, 0) + ((XmlAnySimpleType) thisObject).getStringValue()
					+ getXMLElement("", false, false, true, 0) + suffix;
			return values;
		} else if ((thisObject instanceof String) || (thisObject instanceof Integer) || (thisObject instanceof BigInteger)
				|| (thisObject instanceof Double) || (thisObject instanceof Boolean)) {
			// a simple String or Integer or Double or BigInteger or Boolean
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), true, false, true, 0) + thisObject
					+ getXMLElement("", false, false, true, 0) + suffix;
			return values;
		} else if (thisObject.getClass().isArray()) {
			boolean removeFromStack = false;
			// set the class as name, if there is nothing on the stack
			String tmp = thisObject.getClass().getSimpleName().toLowerCase();
			if (!getStack(subTypeStack, false).isEmpty()) {
				tmp = getStack(subTypeStack, false);
			}
			if (((Object[]) thisObject).length > 0) {
				values += prefix + getXMLElement(tmp, true, true, false, ((Object[]) thisObject).length) + suffix;
			}
			// this is an array, we don't know what data type the elements are,
			// so we simply call this method with the each object of the array.
			Object[] recurObject = (Object[]) thisObject;
			arrayStack.push(tmp);
			for (int i = 0; i < recurObject.length; i++) {
				Object object = recurObject[i];
				values = recStructureBuildForXmlBeans(values, object, arrayStack, subTypeStack, true, deepness + 1);
				// remove from stack, if this is the last element in the array
				if (i == recurObject.length - 1) {
					removeFromStack = true;
				}
			}
			// usually this is not necessary with the boolean, but without strange
			// results occured
			// remove from the stack
			if (removeFromStack) {
				getStack(subTypeStack, true);
			}
			if (((Object[]) thisObject).length > 0) {
				values += prefix + getXMLElement(arrayStack.pop(), false, true, false, 0) + suffix;
			}
			return values;
		} else if (thisObject.getClass().getPackage().getName().startsWith(RInterface.NCBI_PACKAGE)) {
			values += prefix + getXMLElement(getStack(subTypeStack, false), true, false, false, 0) + suffix;
			// this is an object of the NCBI package
			// so we use getParametersMap and call this method for each parameter
			Map<String, Object> recursiveMap = getTypeMapForXmlBeans(thisObject);
			for (String recKey : recursiveMap.keySet()) {
				subTypeStack.push(recKey);
				values = recStructureBuildForXmlBeans(values, recursiveMap.get(recKey), arrayStack, subTypeStack, false, deepness + 1);
			}
			// this will indicate the end of the subset
			values += prefix + getXMLElement(getStack(subTypeStack, !isArray), false, false, false, 0) + suffix;
			return values;
		} else {
			try {
				throw new Exception("Unhandled object: " + thisObject.getClass().getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return values;
	}

	/**
	 * The same as {@link #getTypeMap(Object)}, but for the classes of the
	 * xmlbeans data binding. This means some differences, like:
	 * <ul>
	 * <li>Use getter methods, instead of setters to get the names and objects.</li>
	 * <li>Ignore getDtdVersion method.</li>
	 * <li>If there is a method with return parameter from
	 * {@link RInterface#XMLBEANS_PACKAGE}, this should be handled as a string.</li>
	 * </ul>
	 * 
	 * @param object The object, which getter methods are checked.
	 * @return A map with the name of the objects and the object itself, the
	 *         provided object contains.
	 */
	public static Map<String, Object> getTypeMapForXmlBeans(Object object) {
		Map<String, Object> mapToReturn = new HashMap<String, Object>();
		Method[] methods = object.getClass().getDeclaredMethods();
		for (Method method : methods) {
			// boolean isXmlBeansClass = false;
			if (method.getName().equalsIgnoreCase("getdtdversion") || method.getName().equalsIgnoreCase("geterror")
					|| method.getName().equalsIgnoreCase("getlang") || method.getName().equalsIgnoreCase("getstringvalue")) {
				continue;
			}
			// either it is a getValue method or a setter method, never both
			if (method.getName().equalsIgnoreCase("getvalue")) {
				// if there is a getValue method, this must be a NMToken, so get the
				// value and put it as string into the map
				Object tmpObj = null;
				try {
					tmpObj = method.invoke(object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				String val = "";
				if (tmpObj instanceof NMToken) {
					val = ((NMToken) tmpObj).toString();
				}
				String name = object.getClass().getSimpleName().toLowerCase();
				mapToReturn.put(name, val);
			} else if (method.getName().startsWith("get")) {
				// test whether this get expects parameter
				if (method.getGenericParameterTypes().length > 0) {
					continue;
				}
				// // get the return type of the getter
				// String returnType = method.getReturnType().getName();
				// if
				// (returnType.toString().startsWith(RInterface.XMLBEANS_PACKAGE)) {
				// // this method returns an object from the xmlbeans package
				// isXmlBeansClass = true;
				// }
				// this is a getter method, invoke it and use the result
				Object tmpObj = null;
				try {
					tmpObj = method.invoke(object);
					String tmpString = getValueForXmlBeans(tmpObj);
					if (!tmpString.isEmpty()) {
						tmpObj = tmpString;
					}
					// if (isXmlBeansClass && tmpObj != null) {
					// Class<?>[] arg = null;
					// // now invoke the objects get
					// Method getStringValueMethod =
					// tmpObj.getClass().getMethod("getStringValue", arg);
					// tmpObj = getStringValueMethod.invoke(tmpObj);
					// }
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				// replace with empty keyword
				if (tmpObj == null) {
					tmpObj = RInterface.EMPTY_VALUE;
				}
				// put the name and the corresponding object in the map
				mapToReturn.put(transformMethodName(method.getName(), "get"), tmpObj);
			}
		}
		return mapToReturn;
	}

	/**
	 * Creates a map with the name of the objects and the objects itself, the
	 * provided object contains. This replaces the {@link TypeInterface}, to be
	 * more dynamic. This will only work for the classes from the axis data
	 * binding (ADB).
	 * 
	 * @param object The object which objects are retrieved.
	 * @return The map with all the objects from the provided object.
	 */
	public static Map<String, Object> getTypeMap(Object object) {
		Map<String, Object> mapToReturn = new HashMap<String, Object>();
		Method[] methods = object.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase("setnil") || method.getName().equalsIgnoreCase("seterror")) {
				continue;
			}
			// either it is a getValue method or a setter method, never both
			if (method.getName().equalsIgnoreCase("getvalue")) {
				// if there is a getValue method, this must be a NMToken, so get the
				// value and put it as string into the map
				try {
					// this should never happen, but who knows!
					throw new IllegalStateException("Found not handled getValue method.");
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}

			} else if (method.getName().startsWith("set")) {
				if (method.getName().equalsIgnoreCase("setValue")) {
					// ignore getValue methods, because they should already be
					// handled.
					continue;
				}
				// a set method, search if there is a getter with the same name, but
				// remove the set before
				String methodName = method.getName().substring(3, method.getName().length()).toLowerCase();
				// String getMethodName = "get"+methodName;
				Method getMethod = getGetMethodByName(methodName, object.getClass());
				if (getMethod != null) {
					// if a method returned, invoke it and add the resulting object
					// to the map
					Object tmpObj = null;
					try {
						tmpObj = getMethod.invoke(object);
						String tmpString = getGetValue(tmpObj);
						if (!tmpString.isEmpty()) {
							tmpObj = tmpString;
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					// Replace null with the empty keyword from RInterface
					if (tmpObj == null) {
						tmpObj = RInterface.EMPTY_VALUE;
					}
					mapToReturn.put(methodName, tmpObj);
				}
			}
		}
		return mapToReturn;
	}

	/**
	 * This checks whether an object, which most likely was returned from a
	 * getter method, has a getValue method or not. If there is one, the method
	 * is invoked and the resulting String is returned. In some cases, the
	 * returned object of a getValue method is not a {@link NMToken}. In this
	 * case, the resulting object will be invoked and this result should have a
	 * getValue method.<br>
	 * This is a little bit expensive, but will result in a better xml document,
	 * which can be passed to R.
	 * 
	 * @param object An object, which will be checked for getValue methods.
	 * @return An empty string, if there are no getValue methods or the String
	 *         from the getValue method, if there was one.
	 */
	private static String getGetValue(Object object) {
		if (object == null) {
			return "";
		}
		// get the methods of this object
		Method[] methods = object.getClass().getMethods();
		// System.out.println(Arrays.toString(methNames.toArray(new
		// String[methNames.size()])));
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase("getvalue")) {
				Object tmpObj = null;
				try {
					tmpObj = method.invoke(object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				String val = "";
				if (tmpObj instanceof NMToken) {
					val = ((NMToken) tmpObj).toString();
				} else if (tmpObj instanceof String) {
					val = (String) tmpObj;
				} else {
					// another getValue method for this object
					// until now, this is only the case for the eFetchOmim Service!
					try {
						Class<?>[] arg1 = null;
						Method getValueMethod = tmpObj.getClass().getMethod("getValue", arg1);
						tmpObj = getValueMethod.invoke(tmpObj);
						if (tmpObj instanceof NMToken) {
							val = ((NMToken) tmpObj).toString();
						} else if (tmpObj instanceof String) {
							val = (String) tmpObj;
						} else {
							try {
								// this should never happen, but who knows!
								throw new IllegalStateException("Found not handled returned value from getValue method. Objects class name: "
										+ tmpObj.getClass().getName());
							} catch (IllegalStateException e) {
								e.printStackTrace();
							}
						}

					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
				return val;
			}
		}
		return "";
	}

	/**
	 * Same as {@link #getGetValue(Object)}, but for xmlbeans classes.
	 * 
	 * @param object An object, which will be checked for getValue methods or
	 *           something that returns values.
	 * @return An empty string, if there are no getValue methods or the String
	 *         from the getValue method, if there was one.
	 */
	private static String getValueForXmlBeans(Object object) {
		if (object == null) {
			return "";
		}
		// get the methods of this object
		Method[] methods = object.getClass().getMethods();
		for (Method method : methods) {
			String returnType = method.getReturnType().getName();
			if (returnType.toLowerCase().endsWith("enum")) {
				String stringToReturn = object.toString();
				// this is the case for the efetch_gene operation
				if (stringToReturn.contains("<")) {
					// search for a getValue method
					for (Method method2 : methods) {
						if (method2.getName().equalsIgnoreCase("getvalue")) {
							// invoke this method
							Object tmpObj = null;
							try {
								tmpObj = method2.invoke(object);
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
							return tmpObj.toString();
						}
					}
				}
				return stringToReturn;
			}
		}
		return "";
	}

	/**
	 * This goes through the xml, which is meant to be passed to R. If there are
	 * elements which are empty or arrays with only one element, then they will
	 * be removed.
	 * 
	 * @return The tidy xml string.
	 * @throws ParserConfigurationException As the name tells.
	 * @throws IOException If the string is a bad {@link InputSource}.
	 * @throws SAXException As the name tells.
	 */
	public static String tidyXml(String xml) throws ParserConfigurationException, SAXException, IOException {
		TidyXml tidy = new TidyXml(xml);
		return tidy.getTidyXml();
	}

}
