/**
 * FieldType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.einfo;

import java.util.HashMap;
import java.util.Map;

import de.hzi.infg.interfaces.TypeInterface;

/**
 * FieldType bean class
 */

public class FieldType implements org.apache.axis2.databinding.ADBBean, TypeInterface {
	/*
	 * This type was generated from the piece of schema that had name = FieldType
	 * Namespace URI = http://www.ncbi.nlm.nih.gov/soap/eutils/einfo Namespace
	 * Prefix = ns2
	 */

	private static final long serialVersionUID = 7779460365803509261L;

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo")) {
			return "ns2";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for Name
	 */

	protected java.lang.String localName;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return localName;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Name
	 */
	public void setName(java.lang.String param) {

		this.localName = param;

	}

	/**
	 * field for FullName
	 */

	protected java.lang.String localFullName;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getFullName() {
		return localFullName;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param FullName
	 */
	public void setFullName(java.lang.String param) {

		this.localFullName = param;

	}

	/**
	 * field for Description
	 */

	protected java.lang.String localDescription;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDescription() {
		return localDescription;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Description
	 */
	public void setDescription(java.lang.String param) {

		this.localDescription = param;

	}

	/**
	 * field for TermCount
	 */

	protected java.lang.String localTermCount;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTermCount() {
		return localTermCount;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param TermCount
	 */
	public void setTermCount(java.lang.String param) {

		this.localTermCount = param;

	}

	/**
	 * field for IsDate
	 */

	protected java.lang.String localIsDate;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIsDate() {
		return localIsDate;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param IsDate
	 */
	public void setIsDate(java.lang.String param) {

		this.localIsDate = param;

	}

	/**
	 * field for IsNumerical
	 */

	protected java.lang.String localIsNumerical;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIsNumerical() {
		return localIsNumerical;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param IsNumerical
	 */
	public void setIsNumerical(java.lang.String param) {

		this.localIsNumerical = param;

	}

	/**
	 * field for SingleToken
	 */

	protected java.lang.String localSingleToken;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSingleToken() {
		return localSingleToken;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param SingleToken
	 */
	public void setSingleToken(java.lang.String param) {

		this.localSingleToken = param;

	}

	/**
	 * field for Hierarchy
	 */

	protected java.lang.String localHierarchy;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getHierarchy() {
		return localHierarchy;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Hierarchy
	 */
	public void setHierarchy(java.lang.String param) {

		this.localHierarchy = param;

	}

	/**
	 * field for IsHidden
	 */

	protected java.lang.String localIsHidden;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIsHidden() {
		return localIsHidden;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param IsHidden
	 */
	public void setIsHidden(java.lang.String param) {

		this.localIsHidden = param;

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
				FieldType.this.serialize(parentQName, factory, xmlWriter);
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

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":FieldType", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "FieldType", xmlWriter);
			}

		}

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "Name", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "Name");
			}

		} else {
			xmlWriter.writeStartElement("Name");
		}

		if (localName == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("Name cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localName);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "FullName", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "FullName");
			}

		} else {
			xmlWriter.writeStartElement("FullName");
		}

		if (localFullName == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("FullName cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localFullName);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "Description", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "Description");
			}

		} else {
			xmlWriter.writeStartElement("Description");
		}

		if (localDescription == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("Description cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localDescription);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "TermCount", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "TermCount");
			}

		} else {
			xmlWriter.writeStartElement("TermCount");
		}

		if (localTermCount == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("TermCount cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localTermCount);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "IsDate", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "IsDate");
			}

		} else {
			xmlWriter.writeStartElement("IsDate");
		}

		if (localIsDate == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("IsDate cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localIsDate);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "IsNumerical", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "IsNumerical");
			}

		} else {
			xmlWriter.writeStartElement("IsNumerical");
		}

		if (localIsNumerical == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("IsNumerical cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localIsNumerical);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "SingleToken", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "SingleToken");
			}

		} else {
			xmlWriter.writeStartElement("SingleToken");
		}

		if (localSingleToken == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("SingleToken cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localSingleToken);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "Hierarchy", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "Hierarchy");
			}

		} else {
			xmlWriter.writeStartElement("Hierarchy");
		}

		if (localHierarchy == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("Hierarchy cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localHierarchy);

		}

		xmlWriter.writeEndElement();

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/einfo";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "IsHidden", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "IsHidden");
			}

		} else {
			xmlWriter.writeStartElement("IsHidden");
		}

		if (localIsHidden == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("IsHidden cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localIsHidden);

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
	//
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
	//
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
	//
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

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "Name"));

		if (localName != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
		} else {
			throw new org.apache.axis2.databinding.ADBException("Name cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "FullName"));

		if (localFullName != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFullName));
		} else {
			throw new org.apache.axis2.databinding.ADBException("FullName cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "Description"));

		if (localDescription != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
		} else {
			throw new org.apache.axis2.databinding.ADBException("Description cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "TermCount"));

		if (localTermCount != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTermCount));
		} else {
			throw new org.apache.axis2.databinding.ADBException("TermCount cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "IsDate"));

		if (localIsDate != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsDate));
		} else {
			throw new org.apache.axis2.databinding.ADBException("IsDate cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "IsNumerical"));

		if (localIsNumerical != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNumerical));
		} else {
			throw new org.apache.axis2.databinding.ADBException("IsNumerical cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "SingleToken"));

		if (localSingleToken != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSingleToken));
		} else {
			throw new org.apache.axis2.databinding.ADBException("SingleToken cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "Hierarchy"));

		if (localHierarchy != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHierarchy));
		} else {
			throw new org.apache.axis2.databinding.ADBException("Hierarchy cannot be null!!");
		}

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "IsHidden"));

		if (localIsHidden != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsHidden));
		} else {
			throw new org.apache.axis2.databinding.ADBException("IsHidden cannot be null!!");
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
		public static FieldType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			FieldType object = new FieldType();

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

						if (!"FieldType".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (FieldType) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "Name").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "FullName").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setFullName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "Description").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setDescription(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "TermCount").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setTermCount(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "IsDate").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setIsDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "IsNumerical").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setIsNumerical(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "SingleToken").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setSingleToken(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "Hierarchy").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setHierarchy(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/einfo", "IsHidden").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setIsHidden(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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

	/**
	 * This takes all the information and puts them next to their names into a
	 * map. Returns a map with the following elements:<br/>
	 * <ul>
	 * <li>name - {@link String}</li>
	 * <li>fullname - {@link String}</li>
	 * <li>description - {@link String}</li>
	 * <li>termcount - {@link String}</li>
	 * <li>isdate - {@link String}</li>
	 * <li>isnumerical - {@link String}</li>
	 * <li>singletoken - {@link String}</li>
	 * <li>hierarchy - {@link String}</li>
	 * <li>ishidden - {@link String}</li>
	 * </ul>
	 * 
	 * @return The map with all information.
	 */
	@Override
	public Map<String, Object> getParametersMap() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("name", localName);
		returnMap.put("fullname", localFullName);
		returnMap.put("description", localDescription);
		returnMap.put("termcount", localTermCount);
		returnMap.put("isdate", localIsDate);
		returnMap.put("isnumerical", localIsNumerical);
		returnMap.put("singletoken", localSingleToken);
		returnMap.put("ishidden", localIsHidden);
		return returnMap;
	}

}
