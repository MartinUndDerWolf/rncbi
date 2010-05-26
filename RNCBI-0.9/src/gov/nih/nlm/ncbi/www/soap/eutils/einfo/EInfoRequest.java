/**
 * EInfoRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.einfo;

import java.util.HashSet;
import java.util.Set;

import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;

/**
 * EInfoRequest bean class
 */

public class EInfoRequest implements org.apache.axis2.databinding.ADBBean {

	/**
	 * The parameter this operation expects.
	 */
	private final static String[] operationParameter = { "db", "tool", "email" };

	private static final long serialVersionUID = -3984438456094731844L;

	public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo",
			"eInfoRequest", "ns2");

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo")) {
			return "ns2";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for Db
	 */
	protected java.lang.String localDb;

	/*
	 * This tracker boolean will be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localDbTracker = false;

	/**
	 * Compares the given set with the parameters for this operation.
	 * 
	 * @param paraSet Set of parameters, which should be the same as this
	 *           operation requests.
	 * @throws ErrorFromWebserviceExeption If the parameter are wrong for this
	 *            operation.
	 */
	public EInfoRequest(Set<String> paraSet) throws ErrorFromWebserviceExeption {
		// initialize the operation parameter
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
	 * Default constructor, does nothing. Only present for good looking!
	 */
	public EInfoRequest() {
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDb() {
		return localDb;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Db
	 */
	public void setDb(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localDbTracker = true;
		} else {
			localDbTracker = false;

		}

		this.localDb = param;

	}

	/**
	 * field for Tool
	 */

	protected java.lang.String localTool;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localToolTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTool() {
		return localTool;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Tool
	 */
	public void setTool(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localToolTracker = true;
		} else {
			localToolTracker = false;

		}

		this.localTool = param;

	}

	/**
	 * field for Email
	 */

	protected java.lang.String localEmail;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localEmailTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getEmail() {
		return localEmail;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Email
	 */
	public void setEmail(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localEmailTracker = true;
		} else {
			localEmailTracker = false;

		}

		this.localEmail = param;

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

		org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

			public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
					throws javax.xml.stream.XMLStreamException {
				EInfoRequest.this.serialize(MY_QNAME, factory, xmlWriter);
			}
		};
		return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

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

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":eInfoRequest", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "eInfoRequest", xmlWriter);
			}

		}
		if (localDbTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "db", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "db");
				}

			} else {
				xmlWriter.writeStartElement("db");
			}

			if (localDb == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("db cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localDb);

			}

			xmlWriter.writeEndElement();
		}
		if (localToolTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "tool", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "tool");
				}

			} else {
				xmlWriter.writeStartElement("tool");
			}

			if (localTool == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("tool cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localTool);

			}

			xmlWriter.writeEndElement();
		}
		if (localEmailTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "email", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "email");
				}

			} else {
				xmlWriter.writeStartElement("email");
			}

			if (localEmail == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localEmail);

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
	// private void writeAttribute(java.lang.String namespace,
	// java.lang.String attName, java.lang.String attValue,
	// javax.xml.stream.XMLStreamWriter xmlWriter)
	// throws javax.xml.stream.XMLStreamException {
	// if (namespace.equals("")) {
	// xmlWriter.writeAttribute(attName, attValue);
	// } else {
	// registerPrefix(xmlWriter, namespace);
	// xmlWriter.writeAttribute(namespace, attName, attValue);
	// }
	// }
	// commented
	// /**
	// * Util method to write an attribute without the ns prefix
	// */
	// private void writeQNameAttribute(java.lang.String namespace,
	// java.lang.String attName, javax.xml.namespace.QName qname,
	// javax.xml.stream.XMLStreamWriter xmlWriter)
	// throws javax.xml.stream.XMLStreamException {
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
	// commented
	// /**
	// * method to handle Qnames
	// */
	// private void writeQName(javax.xml.namespace.QName qname,
	// javax.xml.stream.XMLStreamWriter xmlWriter)
	// throws javax.xml.stream.XMLStreamException {
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
	// xmlWriter.writeCharacters(prefix
	// + ":"
	// + org.apache.axis2.databinding.utils.ConverterUtil
	// .convertToString(qname));
	// } else {
	// // i.e this is the default namespace
	// xmlWriter
	// .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
	// .convertToString(qname));
	// }
	//
	// } else {
	// xmlWriter
	// .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
	// .convertToString(qname));
	// }
	// }
	// commented
	// private void writeQNames(javax.xml.namespace.QName[] qnames,
	// javax.xml.stream.XMLStreamWriter xmlWriter)
	// throws javax.xml.stream.XMLStreamException {
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
	// stringToWrite.append(prefix).append(":").append(
	// org.apache.axis2.databinding.utils.ConverterUtil
	// .convertToString(qnames[i]));
	// } else {
	// stringToWrite
	// .append(org.apache.axis2.databinding.utils.ConverterUtil
	// .convertToString(qnames[i]));
	// }
	// } else {
	// stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
	// .convertToString(qnames[i]));
	// }
	// }
	// xmlWriter.writeCharacters(stringToWrite.toString());
	// }
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

		if (localDbTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "db"));

			if (localDb != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDb));
			} else {
				throw new org.apache.axis2.databinding.ADBException("db cannot be null!!");
			}
		}
		if (localToolTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "tool"));

			if (localTool != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTool));
			} else {
				throw new org.apache.axis2.databinding.ADBException("tool cannot be null!!");
			}
		}
		if (localEmailTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "email"));

			if (localEmail != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmail));
			} else {
				throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");
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
		public static EInfoRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			EInfoRequest object = new EInfoRequest();
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

						if (!"eInfoRequest".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (EInfoRequest) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				// commented
				// java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "db").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setDb(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "tool").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setTool(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "email").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setEmail(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
	 * Provides the names of the parameter this operation expects.
	 * 
	 * @return An array of parameter names.
	 */
	public static String[] getOperationParameter() {
		return operationParameter;
	}

}
