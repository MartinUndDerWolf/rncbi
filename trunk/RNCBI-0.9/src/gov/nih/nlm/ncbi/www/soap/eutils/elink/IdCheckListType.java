/**
 * IdCheckListType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.elink;

import java.util.HashMap;
import java.util.Map;

import de.hzi.infg.interfaces.TypeInterface;

/**
 * IdCheckListType bean class
 */
public class IdCheckListType implements org.apache.axis2.databinding.ADBBean, TypeInterface {
	/*
	 * This type was generated from the piece of schema that had name =
	 * IdCheckListType Namespace URI =
	 * http://www.ncbi.nlm.nih.gov/soap/eutils/elink Namespace Prefix = ns5
	 */

	private static final long serialVersionUID = -5671462347671178280L;

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/elink")) {
			return "ns5";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for IdCheckListTypeChoice_type0 This was an Array!
	 */
	protected gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0[] localIdCheckListTypeChoice_type0;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localIdCheckListTypeChoice_type0Tracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return 
	 *         gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0[
	 *         ]
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0[] getIdCheckListTypeChoice_type0() {
		return localIdCheckListTypeChoice_type0;
	}

	/**
	 * validate the array for IdCheckListTypeChoice_type0
	 */
	protected void validateIdCheckListTypeChoice_type0(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param IdCheckListTypeChoice_type0
	 */
	public void setIdCheckListTypeChoice_type0(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0[] param) {

		validateIdCheckListTypeChoice_type0(param);

		if (param != null) {
			// update the setting tracker
			localIdCheckListTypeChoice_type0Tracker = true;
		} else {
			localIdCheckListTypeChoice_type0Tracker = false;

		}

		this.localIdCheckListTypeChoice_type0 = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param 
	 *           gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0
	 */
	@SuppressWarnings("unchecked")
	public void addIdCheckListTypeChoice_type0(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0 param) {
		if (localIdCheckListTypeChoice_type0 == null) {
			localIdCheckListTypeChoice_type0 = new gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0[] {};
		}

		// update the setting tracker
		localIdCheckListTypeChoice_type0Tracker = true;

		java.util.List<IdCheckListTypeChoice_type0> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localIdCheckListTypeChoice_type0);
		list.add(param);
		this.localIdCheckListTypeChoice_type0 = list.toArray(new gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0[list.size()]);

	}

	/**
	 * field for ERROR
	 */

	protected java.lang.String localERROR;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localERRORTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getERROR() {
		return localERROR;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param ERROR
	 */
	public void setERROR(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localERRORTracker = true;
		} else {
			localERRORTracker = false;

		}

		this.localERROR = param;

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
				IdCheckListType.this.serialize(parentQName, factory, xmlWriter);
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

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://www.ncbi.nlm.nih.gov/soap/eutils/elink");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":IdCheckListType", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "IdCheckListType", xmlWriter);
			}

		}
		if (localIdCheckListTypeChoice_type0Tracker) {

			if (localIdCheckListTypeChoice_type0 != null) {
				for (int i = 0; i < localIdCheckListTypeChoice_type0.length; i++) {
					if (localIdCheckListTypeChoice_type0[i] != null) {
						localIdCheckListTypeChoice_type0[i].serialize(null, factory, xmlWriter);
					} else {

						// we don't have to do any thing since minOccures is zero

					}

				}
			} else {
				throw new org.apache.axis2.databinding.ADBException("IdCheckListTypeChoice_type0 cannot be null!!");
			}
		}
		if (localERRORTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "ERROR", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "ERROR");
				}

			} else {
				xmlWriter.writeStartElement("ERROR");
			}

			if (localERROR == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("ERROR cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localERROR);

			}

			xmlWriter.writeEndElement();
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

		if (localIdCheckListTypeChoice_type0Tracker) {
			if (localIdCheckListTypeChoice_type0 != null) {
				for (int i = 0; i < localIdCheckListTypeChoice_type0.length; i++) {

					if (localIdCheckListTypeChoice_type0[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdCheckListTypeChoice_type0"));
						elementList.add(localIdCheckListTypeChoice_type0[i]);
					} else {

						// nothing to do

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("IdCheckListTypeChoice_type0 cannot be null!!");

			}

		}
		if (localERRORTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "ERROR"));

			if (localERROR != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localERROR));
			} else {
				throw new org.apache.axis2.databinding.ADBException("ERROR cannot be null!!");
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
		public static IdCheckListType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			IdCheckListType object = new IdCheckListType();

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

						if (!"IdCheckListType".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (IdCheckListType) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				// commented
				// java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList<IdCheckListTypeChoice_type0> list1 = new java.util.ArrayList<IdCheckListTypeChoice_type0>();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				try {

					if (reader.isStartElement()) {

						// Process the array and step past its final element's end.
						list1.add(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0.Factory.parse(reader));
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
								list1.add(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0.Factory.parse(reader));
							}
						}
						// call the converter utility to convert and set the array
						object
								.setIdCheckListTypeChoice_type0((gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0[]) org.apache.axis2.databinding.utils.ConverterUtil
										.convertToArray(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListTypeChoice_type0.class, list1));

					} // End of if for expected property start element

					else {

					}

				} catch (java.lang.Exception e) {
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "ERROR").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setERROR(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

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
	 * <li>idchecklisttypechoice_type0 - {@link IdCheckListTypeChoice_type0}[]</li>
	 * </ul>
	 * 
	 * @return The map with all information.
	 */
	@Override
	public Map<String, Object> getParametersMap() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("idchecklisttypechoice_type0", localIdCheckListTypeChoice_type0);
		return returnMap;
	}

}
