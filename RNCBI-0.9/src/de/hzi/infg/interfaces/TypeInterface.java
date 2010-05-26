package de.hzi.infg.interfaces;

import java.util.Map;

/**
 * This interface provides functions which should be common to all complex
 * types.
 * 
 * @author Martin Schumann
 * 
 */
public interface TypeInterface {
	/**
	 * Get a map with the name as key and an object as value. The values are
	 * either a string or a TypeInterface.
	 * 
	 * @return A Map to find the way.
	 */
	public Map<String, Object> getParametersMap();
}
