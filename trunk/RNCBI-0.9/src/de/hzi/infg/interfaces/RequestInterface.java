package de.hzi.infg.interfaces;

import java.util.Map;

import de.hzi.infg.RInterface;
import de.hzi.infg.exceptions.NoResultSoFarException;
import de.hzi.infg.exceptions.ParameterNotFoundException;

/**
 * This interface provides several methods, which have to be present in every
 * request class of the web service.
 * 
 * @author Martin Schumann
 * 
 */
public interface RequestInterface {
	/**
	 * This method should always return the parameters of the result of a
	 * request. <br>
	 * As second value, it will show whether the parameter is a complex type or
	 * not.
	 * 
	 * @return An array with name and a boolean next to it, whether it is a
	 *         complex type or not. e.g. {Name,false,LinkList,true}
	 */
	public String[] getParameter();

	/**
	 * This should return a parameter with the given name. </br> The parameter
	 * should be part of the result and a complex type.
	 * 
	 * @param parameter The parameter, preferably a complex type.
	 * @return An array of strings with the parameters of the complex type.
	 * @throws ParameterNotFoundException If the parameter is not part of the
	 *            result.
	 */
	public String[] getParameterByName(String parameter) throws ParameterNotFoundException;

	/**
	 * This map contains all the information from the result. If there is a
	 * complex type, the object is an array of {@link TypeInterface} else it is a
	 * string.
	 * 
	 * @return One map to rule them all.
	 * @throws NoResultSoFarException If the user calls this though there was no
	 *            request before.
	 */
	public Map<String, Object> getResultMap() throws NoResultSoFarException;

	/**
	 * Returns the complex types of the last result in an array. <br/>
	 * The array will look like this:<br/>
	 * Every element will be separated with a break word
	 * {@link RInterface#BREAKWORD}.
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
	 * @return The complex types serialized to an array of strings or null, if
	 *         the parameter was wrong.
	 * @throws ParameterNotFoundException If the parameter is not a complex type
	 *            or it was simply not found.
	 */
	public String[] getComplexType(String name) throws ParameterNotFoundException;

	/**
	 * As the name implies, this returns a simple type, which is identified by
	 * the argument.
	 * 
	 * @param name The name for the simple type.
	 * @return The value of the simple type. Or <code>null</code> if not found.
	 * @throws ParameterNotFoundException If the parameter was not found.
	 */
	public String getSimpleType(String name) throws ParameterNotFoundException;
}
