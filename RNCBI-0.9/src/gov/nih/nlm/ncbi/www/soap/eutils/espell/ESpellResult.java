/**
 * ESpellResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.espell;

/**
 * ESpellResult bean class
 */
public class ESpellResult implements org.apache.axis2.databinding.ADBBean {

	private static final long serialVersionUID = -7185011456358606227L;
	public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell",
			"eSpellResult", "ns6");

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/espell")) {
			return "ns6";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for Database
	 */
	protected java.lang.String localDatabase;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDatabase() {
		return localDatabase;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Database
	 */
	public void setDatabase(java.lang.String param) {

		this.localDatabase = param;

	}

	/**
	 * field for Query
	 */

	protected java.lang.String localQuery;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getQuery() {
		return localQuery;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Query
	 */
	public void setQuery(java.lang.String param) {

		this.localQuery = param;

	}

	/**
	 * field for CorrectedQuery
	 */

	protected java.lang.String localCorrectedQuery;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCorrectedQuery() {
		return localCorrectedQuery;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param CorrectedQuery
	 */
	public void setCorrectedQuery(java.lang.String param) {

		this.localCorrectedQuery = param;

	}

	/**
	 * field for SpelledQuery
	 */

	protected gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQuery_type0 localSpelledQuery;

	/**
	 * Auto generated getter method
	 * 
	 * @return gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQuery_type0
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQuery_type0 getSpelledQuery() {
		return localSpelledQuery;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param SpelledQuery
	 */
	public void setSpelledQuery(gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQuery_type0 param) {

		this.localSpelledQuery = param;

	}

	/**
	 * field for ERROR
	 */

	protected java.lang.String localERROR;

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

		org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

			public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
					throws javax.xml.stream.XMLStreamException {
				ESpellResult.this.serialize(MY_QNAME, factory, xmlWriter);
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

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://www.ncbi.nlm.nih.gov/soap/eutils/espell");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":eSpellResult", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "eSpellResult", xmlWriter);
			}

		}

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/espell";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "Database", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "Database");
			}

		} else {
			xmlWriter.writeStartElement("Database");
		}

		if (localDatabase == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("Database cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localDatabase);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/espell";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "Query", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "Query");
			}

		} else {
			xmlWriter.writeStartElement("Query");
		}

		if (localQuery == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("Query cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localQuery);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/espell";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "CorrectedQuery", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "CorrectedQuery");
			}

		} else {
			xmlWriter.writeStartElement("CorrectedQuery");
		}

		if (localCorrectedQuery == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("CorrectedQuery cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localCorrectedQuery);

		}

		xmlWriter.writeEndElement();

		if (localSpelledQuery == null) {
			throw new org.apache.axis2.databinding.ADBException("SpelledQuery cannot be null!!");
		}
		localSpelledQuery
				.serialize(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "SpelledQuery"), factory, xmlWriter);

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/espell";
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

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "Database"));

		if (localDatabase != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDatabase));
		} else {
			throw new org.apache.axis2.databinding.ADBException("Database cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "Query"));

		if (localQuery != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuery));
		} else {
			throw new org.apache.axis2.databinding.ADBException("Query cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "CorrectedQuery"));

		if (localCorrectedQuery != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCorrectedQuery));
		} else {
			throw new org.apache.axis2.databinding.ADBException("CorrectedQuery cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "SpelledQuery"));

		if (localSpelledQuery == null) {
			throw new org.apache.axis2.databinding.ADBException("SpelledQuery cannot be null!!");
		}
		elementList.add(localSpelledQuery);

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "ERROR"));

		if (localERROR != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localERROR));
		} else {
			throw new org.apache.axis2.databinding.ADBException("ERROR cannot be null!!");
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
		public static ESpellResult parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			ESpellResult object = new ESpellResult();

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

						if (!"eSpellResult".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (ESpellResult) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "Database").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setDatabase(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter
					// was passed
					throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "Query").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setQuery(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter
					// was passed
					throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "CorrectedQuery").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setCorrectedQuery(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter
					// was passed
					throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "SpelledQuery").equals(reader.getName())) {

					object.setSpelledQuery(gov.nih.nlm.ncbi.www.soap.eutils.espell.SpelledQuery_type0.Factory.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter
					// was passed
					throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/espell", "ERROR").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setERROR(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter
					// was passed
					throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
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

}
