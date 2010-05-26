/**
 * SpelledQuery_type0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.espell;

import java.util.HashMap;
import java.util.Map;

import de.hzi.infg.interfaces.TypeInterface;

/**
 * SpelledQuery_type0 bean class
 */
public class SpelledQuery_type0 implements org.apache.axis2.databinding.ADBBean, TypeInterface {
	/*
	 * This type was generated from the piece of schema that had name =
	 * SpelledQuery_type0 Namespace URI =
	 * http://www.ncbi.nlm.nih.gov/soap/eutils/espell Namespace Prefix = ns6
	 */

	private static final long serialVersionUID = -6892054746538615994L;

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/espell")) {
			return "ns6";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for SpelledQueryChoice This was an Array!
	 */
	protected gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE[] localSpelledQueryChoice;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localSpelledQueryChoiceTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE[]
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE[] getSpelledQueryChoice() {
		return localSpelledQueryChoice;
	}

	/**
	 * validate the array for SpelledQueryChoice
	 */
	protected void validateSpelledQueryChoice(gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param SpelledQueryChoice
	 */
	public void setSpelledQueryChoice(gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE[] param) {

		validateSpelledQueryChoice(param);

		if (param != null) {
			// update the setting tracker
			localSpelledQueryChoiceTracker = true;
		} else {
			localSpelledQueryChoiceTracker = false;

		}

		this.localSpelledQueryChoice = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE
	 */
	@SuppressWarnings("unchecked")
	public void addSpelledQueryChoice(gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE param) {
		if (localSpelledQueryChoice == null) {
			localSpelledQueryChoice = new gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE[] {};
		}

		// update the setting tracker
		localSpelledQueryChoiceTracker = true;

		java.util.List<SpelledQueryChoiceE> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localSpelledQueryChoice);
		list.add(param);
		this.localSpelledQueryChoice = list.toArray(new gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE[list.size()]);

	}

	/**
	 * isReaderMTOMAware
	 * 
	 * @return true if the reader supports MTOM
	 */
	public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
		boolean isReaderMTOMAware = false;

		try {
			isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
		} catch (java.lang.IllegalArgumentException e) {
			isReaderMTOMAware = false;
		}
		return isReaderMTOMAware;
	}

	/**
	 * 
	 * @param parentQName
	 * @param factory
	 * @return org.apache.axiom.om.OMElement
	 */
	public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
			throws org.apache.axis2.databinding.ADBException {

		org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

			public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
					throws javax.xml.stream.XMLStreamException {
				SpelledQuery_type0.this.serialize(parentQName, factory, xmlWriter);
			}
		};
		return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);

	}

	public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
			org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {
		serialize(parentQName, factory, xmlWriter, false);
	}

	public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory,
			org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter, boolean serializeType)
			throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

		java.lang.String prefix = null;
		java.lang.String namespace = null;

		prefix = parentQName.getPrefix();
		namespace = parentQName.getNamespaceURI();

		if ((namespace != null) && (namespace.trim().length() > 0)) {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
			} else {
				if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		} else {
			xmlWriter.writeStartElement(parentQName.getLocalPart());
		}

		if (serializeType) {

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://www.ncbi.nlm.nih.gov/soap/eutils/espell");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":SpelledQuery_type0", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "SpelledQuery_type0", xmlWriter);
			}

		}
		if (localSpelledQueryChoiceTracker) {

			if (localSpelledQueryChoice != null) {
				for (int i = 0; i < localSpelledQueryChoice.length; i++) {
					if (localSpelledQueryChoice[i] != null) {
						localSpelledQueryChoice[i].serialize(null, factory, xmlWriter);
					} else {

						// we don't have to do any thing since minOccures is zero

					}

				}
			} else {
				throw new org.apache.axis2.databinding.ADBException("SpelledQueryChoice cannot be null!!");
			}
		}
		xmlWriter.writeEndElement();

	}

	/**
	 * Util method to write an attribute with the ns prefix
	 */
	private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
		if (xmlWriter.getPrefix(namespace) == null) {
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);

		}

		xmlWriter.writeAttribute(namespace, attName, attValue);

	}

	// commented
	// /**
	// * Util method to write an attribute without the ns prefix
	// */
	// private void writeAttribute(java.lang.String namespace, java.lang.String
	// attName, java.lang.String attValue,
	// javax.xml.stream.XMLStreamWriter xmlWriter) throws
	// javax.xml.stream.XMLStreamException {
	// if (namespace.equals("")) {
	// xmlWriter.writeAttribute(attName, attValue);
	// } else {
	// registerPrefix(xmlWriter, namespace);
	// xmlWriter.writeAttribute(namespace, attName, attValue);
	// }
	// }
	//
	// /**
	// * Util method to write an attribute without the ns prefix
	// */
	// private void writeQNameAttribute(java.lang.String namespace,
	// java.lang.String attName, javax.xml.namespace.QName qname,
	// javax.xml.stream.XMLStreamWriter xmlWriter) throws
	// javax.xml.stream.XMLStreamException {
	//
	// java.lang.String attributeNamespace = qname.getNamespaceURI();
	// java.lang.String attributePrefix =
	// xmlWriter.getPrefix(attributeNamespace);
	// if (attributePrefix == null) {
	// attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
	// }
	// java.lang.String attributeValue;
	// if (attributePrefix.trim().length() > 0) {
	// attributeValue = attributePrefix + ":" + qname.getLocalPart();
	// } else {
	// attributeValue = qname.getLocalPart();
	// }
	//
	// if (namespace.equals("")) {
	// xmlWriter.writeAttribute(attName, attributeValue);
	// } else {
	// registerPrefix(xmlWriter, namespace);
	// xmlWriter.writeAttribute(namespace, attName, attributeValue);
	// }
	// }
	//
	// /**
	// * method to handle Qnames
	// */
	//
	// private void writeQName(javax.xml.namespace.QName qname,
	// javax.xml.stream.XMLStreamWriter xmlWriter) throws
	// javax.xml.stream.XMLStreamException {
	// java.lang.String namespaceURI = qname.getNamespaceURI();
	// if (namespaceURI != null) {
	// java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
	// if (prefix == null) {
	// prefix = generatePrefix(namespaceURI);
	// xmlWriter.writeNamespace(prefix, namespaceURI);
	// xmlWriter.setPrefix(prefix, namespaceURI);
	// }
	//
	// if (prefix.trim().length() > 0) {
	// xmlWriter.writeCharacters(prefix + ":" +
	// org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
	// } else {
	// // i.e this is the default namespace
	// xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
	// }
	//
	// } else {
	// xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
	// }
	// }
	//
	// private void writeQNames(javax.xml.namespace.QName[] qnames,
	// javax.xml.stream.XMLStreamWriter xmlWriter) throws
	// javax.xml.stream.XMLStreamException {
	//
	// if (qnames != null) {
	// // we have to store this data until last moment since it is not possible
	// // to write any
	// // namespace data after writing the charactor data
	// java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
	// java.lang.String namespaceURI = null;
	// java.lang.String prefix = null;
	//
	// for (int i = 0; i < qnames.length; i++) {
	// if (i > 0) {
	// stringToWrite.append(" ");
	// }
	// namespaceURI = qnames[i].getNamespaceURI();
	// if (namespaceURI != null) {
	// prefix = xmlWriter.getPrefix(namespaceURI);
	// if ((prefix == null) || (prefix.length() == 0)) {
	// prefix = generatePrefix(namespaceURI);
	// xmlWriter.writeNamespace(prefix, namespaceURI);
	// xmlWriter.setPrefix(prefix, namespaceURI);
	// }
	//
	// if (prefix.trim().length() > 0) {
	// stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
	// } else {
	// stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
	// }
	// } else {
	// stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
	// }
	// }
	// xmlWriter.writeCharacters(stringToWrite.toString());
	// }
	//
	// }

	/**
	 * Register a namespace prefix
	 */
	private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String prefix = xmlWriter.getPrefix(namespace);

		if (prefix == null) {
			prefix = generatePrefix(namespace);

			while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
				prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
			}

			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}

		return prefix;
	}

	/**
	 * databinding method to get an XML representation of this object
	 * 
	 */
	public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {

		java.util.ArrayList<Object> elementList = new java.util.ArrayList<Object>();
		java.util.ArrayList<Object> attribList = new java.util.ArrayList<Object>();

		if (localSpelledQueryChoiceTracker) {
			if (localSpelledQueryChoice != null) {
				for (int i = 0; i < localSpelledQueryChoice.length; i++) {

					if (localSpelledQueryChoice[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "SpelledQueryChoice"));
						elementList.add(localSpelledQueryChoice[i]);
					} else {

						// nothing to do

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("SpelledQueryChoice cannot be null!!");

			}

		}

		return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

	}

	/**
	 * Factory class that keeps the parse method
	 */
	public static class Factory {

		/**
		 * static method to create the object Precondition: If this object is an
		 * element, the current or next start element starts this object and any
		 * intervening reader events are ignorable If this object is not an
		 * element, it is a complex type and the reader is at the event just after
		 * the outer start element Postcondition: If this object is an element,
		 * the reader is positioned at its end element If this object is a complex
		 * type, the reader is positioned at the end element of its outer element
		 */
		public static SpelledQuery_type0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			SpelledQuery_type0 object = new SpelledQuery_type0();

			// commented
			// int event;
			// java.lang.String nillableValue = null;
			// java.lang.String prefix = "";
			// java.lang.String namespaceuri = "";
			try {

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
					java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
					if (fullTypeName != null) {
						java.lang.String nsPrefix = null;
						if (fullTypeName.indexOf(":") > -1) {
							nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
						}
						nsPrefix = nsPrefix == null ? "" : nsPrefix;

						java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

						if (!"SpelledQuery_type0".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (SpelledQuery_type0) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				// commented
				// java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList<SpelledQueryChoiceE> list1 = new java.util.ArrayList<SpelledQueryChoiceE>();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				try {

					if (reader.isStartElement()) {

						// Process the array and step past its final element's end.
						list1.add(gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE.Factory.parse(reader));
						// loop until we find a start element that is not part of this
						// array
						boolean loopDone1 = false;
						while (!loopDone1) {

							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are exiting the
								// xml
								// structure
								loopDone1 = true;
							} else {
								list1.add(gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE.Factory.parse(reader));
							}
						}
						// call the converter utility to convert and set the array
						object
								.setSpelledQueryChoice((gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE[]) org.apache.axis2.databinding.utils.ConverterUtil
										.convertToArray(gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQueryChoiceE.class, list1));

					} // End of if for expected property start element

					else {

					}

				} catch (java.lang.Exception e) {
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing
					// invalid
					// property
					throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());

			} catch (javax.xml.stream.XMLStreamException e) {
				throw new java.lang.Exception(e);
			}

			return object;
		}

	}// end of factory class

	/**
	 * This takes all the information and puts them next to their names into a
	 * map. Returns a map with the following elements:<br/>
	 * <ul>
	 * <li>spelledquerychoice - {@link SpelledQueryChoiceE}[]</li>
	 * </ul>
	 * 
	 * @return The map with all information.
	 */
	@Override
	public Map<String, Object> getParametersMap() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("spelledquerychoice", localSpelledQueryChoice);
		return returnMap;
	}

}
