/**
 * WarningListType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.esearch;

import java.util.HashMap;
import java.util.Map;

import de.hzi.infg.interfaces.TypeInterface;

/**
 * WarningListType bean class
 */
public class WarningListType implements org.apache.axis2.databinding.ADBBean, TypeInterface {

	private static final long serialVersionUID = 8717791383713160779L;

	/**
	 * This type was generated from the piece of schema that had name =
	 * WarningListType Namespace URI =
	 * http://www.ncbi.nlm.nih.gov/soap/eutils/esearch Namespace Prefix = ns3
	 */
	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch")) {
			return "ns3";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for PhraseIgnored This was an Array!
	 */
	protected java.lang.String[] localPhraseIgnored;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localPhraseIgnoredTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getPhraseIgnored() {
		return localPhraseIgnored;
	}

	/**
	 * validate the array for PhraseIgnored
	 */
	protected void validatePhraseIgnored(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param PhraseIgnored
	 */
	public void setPhraseIgnored(java.lang.String[] param) {

		validatePhraseIgnored(param);

		if (param != null) {
			// update the setting tracker
			localPhraseIgnoredTracker = true;
		} else {
			localPhraseIgnoredTracker = false;

		}

		this.localPhraseIgnored = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param java.lang.String
	 */
	@SuppressWarnings("unchecked")
	public void addPhraseIgnored(java.lang.String param) {
		if (localPhraseIgnored == null) {
			localPhraseIgnored = new java.lang.String[] {};
		}

		// update the setting tracker
		localPhraseIgnoredTracker = true;

		java.util.List<String> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localPhraseIgnored);
		list.add(param);
		this.localPhraseIgnored = list.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * field for QuotedPhraseNotFound This was an Array!
	 */

	protected java.lang.String[] localQuotedPhraseNotFound;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localQuotedPhraseNotFoundTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getQuotedPhraseNotFound() {
		return localQuotedPhraseNotFound;
	}

	/**
	 * validate the array for QuotedPhraseNotFound
	 */
	protected void validateQuotedPhraseNotFound(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param QuotedPhraseNotFound
	 */
	public void setQuotedPhraseNotFound(java.lang.String[] param) {

		validateQuotedPhraseNotFound(param);

		if (param != null) {
			// update the setting tracker
			localQuotedPhraseNotFoundTracker = true;
		} else {
			localQuotedPhraseNotFoundTracker = false;

		}

		this.localQuotedPhraseNotFound = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param java.lang.String
	 */
	@SuppressWarnings("unchecked")
	public void addQuotedPhraseNotFound(java.lang.String param) {
		if (localQuotedPhraseNotFound == null) {
			localQuotedPhraseNotFound = new java.lang.String[] {};
		}

		// update the setting tracker
		localQuotedPhraseNotFoundTracker = true;

		java.util.List<String> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localQuotedPhraseNotFound);
		list.add(param);
		this.localQuotedPhraseNotFound = list.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * field for OutputMessage This was an Array!
	 */

	protected java.lang.String[] localOutputMessage;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localOutputMessageTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getOutputMessage() {
		return localOutputMessage;
	}

	/**
	 * validate the array for OutputMessage
	 */
	protected void validateOutputMessage(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param OutputMessage
	 */
	public void setOutputMessage(java.lang.String[] param) {

		validateOutputMessage(param);

		if (param != null) {
			// update the setting tracker
			localOutputMessageTracker = true;
		} else {
			localOutputMessageTracker = false;

		}

		this.localOutputMessage = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param java.lang.String
	 */
	@SuppressWarnings("unchecked")
	public void addOutputMessage(java.lang.String param) {
		if (localOutputMessage == null) {
			localOutputMessage = new java.lang.String[] {};
		}

		// update the setting tracker
		localOutputMessageTracker = true;

		java.util.List<String> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localOutputMessage);
		list.add(param);
		this.localOutputMessage = list.toArray(new java.lang.String[list.size()]);

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
				WarningListType.this.serialize(parentQName, factory, xmlWriter);
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

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":WarningListType", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "WarningListType", xmlWriter);
			}

		}
		if (localPhraseIgnoredTracker) {
			if (localPhraseIgnored != null) {
				namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
				boolean emptyNamespace = namespace == null || namespace.length() == 0;
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
				for (int i = 0; i < localPhraseIgnored.length; i++) {

					if (localPhraseIgnored[i] != null) {

						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "PhraseIgnored", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);

							} else {
								xmlWriter.writeStartElement(namespace, "PhraseIgnored");
							}

						} else {
							xmlWriter.writeStartElement("PhraseIgnored");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhraseIgnored[i]));

						xmlWriter.writeEndElement();

					} else {

						// we have to do nothing since minOccurs is zero

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("PhraseIgnored cannot be null!!");

			}

		}
		if (localQuotedPhraseNotFoundTracker) {
			if (localQuotedPhraseNotFound != null) {
				namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
				boolean emptyNamespace = namespace == null || namespace.length() == 0;
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
				for (int i = 0; i < localQuotedPhraseNotFound.length; i++) {

					if (localQuotedPhraseNotFound[i] != null) {

						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "QuotedPhraseNotFound", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);

							} else {
								xmlWriter.writeStartElement(namespace, "QuotedPhraseNotFound");
							}

						} else {
							xmlWriter.writeStartElement("QuotedPhraseNotFound");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuotedPhraseNotFound[i]));

						xmlWriter.writeEndElement();

					} else {

						// we have to do nothing since minOccurs is zero

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("QuotedPhraseNotFound cannot be null!!");

			}

		}
		if (localOutputMessageTracker) {
			if (localOutputMessage != null) {
				namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
				boolean emptyNamespace = namespace == null || namespace.length() == 0;
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
				for (int i = 0; i < localOutputMessage.length; i++) {

					if (localOutputMessage[i] != null) {

						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "OutputMessage", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);

							} else {
								xmlWriter.writeStartElement(namespace, "OutputMessage");
							}

						} else {
							xmlWriter.writeStartElement("OutputMessage");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOutputMessage[i]));

						xmlWriter.writeEndElement();

					} else {

						// we have to do nothing since minOccurs is zero

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("OutputMessage cannot be null!!");

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

		if (localPhraseIgnoredTracker) {
			if (localPhraseIgnored != null) {
				for (int i = 0; i < localPhraseIgnored.length; i++) {

					if (localPhraseIgnored[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "PhraseIgnored"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhraseIgnored[i]));
					} else {

						// have to do nothing

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("PhraseIgnored cannot be null!!");

			}

		}
		if (localQuotedPhraseNotFoundTracker) {
			if (localQuotedPhraseNotFound != null) {
				for (int i = 0; i < localQuotedPhraseNotFound.length; i++) {

					if (localQuotedPhraseNotFound[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "QuotedPhraseNotFound"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuotedPhraseNotFound[i]));
					} else {

						// have to do nothing

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("QuotedPhraseNotFound cannot be null!!");

			}

		}
		if (localOutputMessageTracker) {
			if (localOutputMessage != null) {
				for (int i = 0; i < localOutputMessage.length; i++) {

					if (localOutputMessage[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "OutputMessage"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOutputMessage[i]));
					} else {

						// have to do nothing

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("OutputMessage cannot be null!!");

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
		public static WarningListType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			WarningListType object = new WarningListType();

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

						if (!"WarningListType".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (WarningListType) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				// commented
				// java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList<String> list1 = new java.util.ArrayList<String>();

				java.util.ArrayList<String> list2 = new java.util.ArrayList<String>();

				java.util.ArrayList<String> list3 = new java.util.ArrayList<String>();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "PhraseIgnored").equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list1.add(reader.getElementText());

					// loop until we find a start element that is not part of this
					// array
					boolean loopDone1 = false;
					while (!loopDone1) {
						// Ensure we are at the EndElement
						while (!reader.isEndElement()) {
							reader.next();
						}
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement() && !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting the xml
							// structure
							loopDone1 = true;
						} else {
							if (new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "PhraseIgnored").equals(reader.getName())) {
								list1.add(reader.getElementText());

							} else {
								loopDone1 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setPhraseIgnored(list1.toArray(new java.lang.String[list1.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "QuotedPhraseNotFound")
								.equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list2.add(reader.getElementText());

					// loop until we find a start element that is not part of this
					// array
					boolean loopDone2 = false;
					while (!loopDone2) {
						// Ensure we are at the EndElement
						while (!reader.isEndElement()) {
							reader.next();
						}
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement() && !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting the xml
							// structure
							loopDone2 = true;
						} else {
							if (new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "QuotedPhraseNotFound").equals(reader
									.getName())) {
								list2.add(reader.getElementText());

							} else {
								loopDone2 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setQuotedPhraseNotFound(list2.toArray(new java.lang.String[list2.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "OutputMessage").equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list3.add(reader.getElementText());

					// loop until we find a start element that is not part of this
					// array
					boolean loopDone3 = false;
					while (!loopDone3) {
						// Ensure we are at the EndElement
						while (!reader.isEndElement()) {
							reader.next();
						}
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement() && !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting the xml
							// structure
							loopDone3 = true;
						} else {
							if (new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "OutputMessage").equals(reader.getName())) {
								list3.add(reader.getElementText());

							} else {
								loopDone3 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setOutputMessage(list3.toArray(new java.lang.String[list3.size()]));

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
	 * <li>outputmessage - {@link String}[]</li>
	 * <li>phraseignored - {@link String}[]</li>
	 * <li>quotedphrasenotfound - {@link String}[]</li>
	 * </ul>
	 * 
	 * @return The map with all information.
	 */
	@Override
	public Map<String, Object> getParametersMap() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("outputmessage", localOutputMessage);
		returnMap.put("phraseignored", localPhraseIgnored);
		returnMap.put("quotedphrasenotfound", localQuotedPhraseNotFound);
		return returnMap;
	}

}
