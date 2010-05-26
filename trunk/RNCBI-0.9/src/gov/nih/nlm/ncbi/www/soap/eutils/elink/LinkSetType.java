/**
 * LinkSetType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.elink;

import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.databinding.ADBBean;

import de.hzi.infg.interfaces.TypeInterface;

/**
 * LinkSetType bean class
 */

public class LinkSetType implements org.apache.axis2.databinding.ADBBean, TypeInterface {
	/*
	 * This type was generated from the piece of schema that had name =
	 * LinkSetType Namespace URI = http://www.ncbi.nlm.nih.gov/soap/eutils/elink
	 * Namespace Prefix = ns5
	 */

	private static final long serialVersionUID = -4489589363776184985L;

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/elink")) {
			return "ns5";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for DbFrom
	 */

	protected java.lang.String localDbFrom;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDbFrom() {
		return localDbFrom;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param DbFrom
	 */
	public void setDbFrom(java.lang.String param) {

		this.localDbFrom = param;

	}

	/**
	 * field for IdList
	 */

	protected gov.nih.nlm.ncbi.www.soap.eutils.elink.IdListTypeE localIdList;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localIdListTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return gov.nih.nlm.ncbi.www.soap.eutils.elink.IdListTypeE
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.elink.IdListTypeE getIdList() {
		return localIdList;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param IdList
	 */
	public void setIdList(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdListTypeE param) {

		if (param != null) {
			// update the setting tracker
			localIdListTracker = true;
		} else {
			localIdListTracker = false;

		}

		this.localIdList = param;

	}

	/**
	 * field for LinkSetDb This was an Array!
	 */

	protected gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType[] localLinkSetDb;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localLinkSetDbTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType[]
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType[] getLinkSetDb() {
		return localLinkSetDb;
	}

	/**
	 * validate the array for LinkSetDb
	 */
	protected void validateLinkSetDb(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param LinkSetDb
	 */
	public void setLinkSetDb(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType[] param) {

		validateLinkSetDb(param);

		if (param != null) {
			// update the setting tracker
			localLinkSetDbTracker = true;
		} else {
			localLinkSetDbTracker = false;

		}

		this.localLinkSetDb = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType
	 */
	@SuppressWarnings("unchecked")
	public void addLinkSetDb(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType param) {
		if (localLinkSetDb == null) {
			localLinkSetDb = new gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType[] {};
		}

		// update the setting tracker
		localLinkSetDbTracker = true;

		java.util.List<ADBBean> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localLinkSetDb);
		list.add(param);
		this.localLinkSetDb = list.toArray(new gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType[list.size()]);

	}

	/**
	 * field for LinkSetDbHistory This was an Array!
	 */

	protected gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType[] localLinkSetDbHistory;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localLinkSetDbHistoryTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType[]
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType[] getLinkSetDbHistory() {
		return localLinkSetDbHistory;
	}

	/**
	 * validate the array for LinkSetDbHistory
	 */
	protected void validateLinkSetDbHistory(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param LinkSetDbHistory
	 */
	public void setLinkSetDbHistory(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType[] param) {

		validateLinkSetDbHistory(param);

		if (param != null) {
			// update the setting tracker
			localLinkSetDbHistoryTracker = true;
		} else {
			localLinkSetDbHistoryTracker = false;

		}

		this.localLinkSetDbHistory = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType
	 */
	@SuppressWarnings("unchecked")
	public void addLinkSetDbHistory(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType param) {
		if (localLinkSetDbHistory == null) {
			localLinkSetDbHistory = new gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType[] {};
		}

		// update the setting tracker
		localLinkSetDbHistoryTracker = true;

		java.util.List<ADBBean> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localLinkSetDbHistory);
		list.add(param);
		this.localLinkSetDbHistory = list.toArray(new gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType[list.size()]);

	}

	/**
	 * field for WebEnv
	 */

	protected java.lang.String localWebEnv;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localWebEnvTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getWebEnv() {
		return localWebEnv;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param WebEnv
	 */
	public void setWebEnv(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localWebEnvTracker = true;
		} else {
			localWebEnvTracker = false;

		}

		this.localWebEnv = param;

	}

	/**
	 * field for IdUrlList
	 */

	protected gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlListType localIdUrlList;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localIdUrlListTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlListType
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlListType getIdUrlList() {
		return localIdUrlList;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param IdUrlList
	 */
	public void setIdUrlList(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlListType param) {

		if (param != null) {
			// update the setting tracker
			localIdUrlListTracker = true;
		} else {
			localIdUrlListTracker = false;

		}

		this.localIdUrlList = param;

	}

	/**
	 * field for IdCheckList
	 */

	protected gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListType localIdCheckList;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localIdCheckListTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListType
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListType getIdCheckList() {
		return localIdCheckList;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param IdCheckList
	 */
	public void setIdCheckList(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListType param) {

		if (param != null) {
			// update the setting tracker
			localIdCheckListTracker = true;
		} else {
			localIdCheckListTracker = false;

		}

		this.localIdCheckList = param;

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
				LinkSetType.this.serialize(parentQName, factory, xmlWriter);
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
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":LinkSetType", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "LinkSetType", xmlWriter);
			}

		}

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "DbFrom", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "DbFrom");
			}

		} else {
			xmlWriter.writeStartElement("DbFrom");
		}

		if (localDbFrom == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("DbFrom cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localDbFrom);

		}

		xmlWriter.writeEndElement();
		if (localIdListTracker) {
			if (localIdList == null) {
				throw new org.apache.axis2.databinding.ADBException("IdList cannot be null!!");
			}
			localIdList.serialize(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdList"), factory, xmlWriter);
		}
		if (localLinkSetDbTracker) {
			if (localLinkSetDb != null) {
				for (int i = 0; i < localLinkSetDb.length; i++) {
					if (localLinkSetDb[i] != null) {
						localLinkSetDb[i].serialize(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkSetDb"), factory,
								xmlWriter);
					} else {

						// we don't have to do any thing since minOccures is zero

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("LinkSetDb cannot be null!!");

			}
		}
		if (localLinkSetDbHistoryTracker) {
			if (localLinkSetDbHistory != null) {
				for (int i = 0; i < localLinkSetDbHistory.length; i++) {
					if (localLinkSetDbHistory[i] != null) {
						localLinkSetDbHistory[i].serialize(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink",
								"LinkSetDbHistory"), factory, xmlWriter);
					} else {

						// we don't have to do any thing since minOccures is zero

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("LinkSetDbHistory cannot be null!!");

			}
		}
		if (localWebEnvTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "WebEnv", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "WebEnv");
				}

			} else {
				xmlWriter.writeStartElement("WebEnv");
			}

			if (localWebEnv == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("WebEnv cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localWebEnv);

			}

			xmlWriter.writeEndElement();
		}
		if (localIdUrlListTracker) {
			if (localIdUrlList == null) {
				throw new org.apache.axis2.databinding.ADBException("IdUrlList cannot be null!!");
			}
			localIdUrlList.serialize(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdUrlList"), factory, xmlWriter);
		}
		if (localIdCheckListTracker) {
			if (localIdCheckList == null) {
				throw new org.apache.axis2.databinding.ADBException("IdCheckList cannot be null!!");
			}
			localIdCheckList
					.serialize(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdCheckList"), factory, xmlWriter);
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

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "DbFrom"));

		if (localDbFrom != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDbFrom));
		} else {
			throw new org.apache.axis2.databinding.ADBException("DbFrom cannot be null!!");
		}
		if (localIdListTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdList"));

			if (localIdList == null) {
				throw new org.apache.axis2.databinding.ADBException("IdList cannot be null!!");
			}
			elementList.add(localIdList);
		}
		if (localLinkSetDbTracker) {
			if (localLinkSetDb != null) {
				for (int i = 0; i < localLinkSetDb.length; i++) {

					if (localLinkSetDb[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkSetDb"));
						elementList.add(localLinkSetDb[i]);
					} else {

						// nothing to do

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("LinkSetDb cannot be null!!");

			}

		}
		if (localLinkSetDbHistoryTracker) {
			if (localLinkSetDbHistory != null) {
				for (int i = 0; i < localLinkSetDbHistory.length; i++) {

					if (localLinkSetDbHistory[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkSetDbHistory"));
						elementList.add(localLinkSetDbHistory[i]);
					} else {

						// nothing to do

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("LinkSetDbHistory cannot be null!!");

			}

		}
		if (localWebEnvTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "WebEnv"));

			if (localWebEnv != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWebEnv));
			} else {
				throw new org.apache.axis2.databinding.ADBException("WebEnv cannot be null!!");
			}
		}
		if (localIdUrlListTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdUrlList"));

			if (localIdUrlList == null) {
				throw new org.apache.axis2.databinding.ADBException("IdUrlList cannot be null!!");
			}
			elementList.add(localIdUrlList);
		}
		if (localIdCheckListTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdCheckList"));

			if (localIdCheckList == null) {
				throw new org.apache.axis2.databinding.ADBException("IdCheckList cannot be null!!");
			}
			elementList.add(localIdCheckList);
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
		public static LinkSetType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			LinkSetType object = new LinkSetType();

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

						if (!"LinkSetType".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (LinkSetType) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				// commented
				// java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList<ADBBean> list3 = new java.util.ArrayList<ADBBean>();

				java.util.ArrayList<ADBBean> list4 = new java.util.ArrayList<ADBBean>();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "DbFrom").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setDbFrom(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdList").equals(reader.getName())) {

					object.setIdList(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdListTypeE.Factory.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkSetDb").equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list3.add(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType.Factory.parse(reader));

					// loop until we find a start element that is not part of this
					// array
					boolean loopDone3 = false;
					while (!loopDone3) {
						// We should be at the end element, but make sure
						while (!reader.isEndElement())
							reader.next();
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
							if (new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkSetDb").equals(reader.getName())) {
								list3.add(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType.Factory.parse(reader));

							} else {
								loopDone3 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setLinkSetDb((gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType[]) org.apache.axis2.databinding.utils.ConverterUtil
							.convertToArray(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbType.class, list3));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkSetDbHistory").equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list4.add(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType.Factory.parse(reader));

					// loop until we find a start element that is not part of this
					// array
					boolean loopDone4 = false;
					while (!loopDone4) {
						// We should be at the end element, but make sure
						while (!reader.isEndElement())
							reader.next();
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement() && !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting the xml
							// structure
							loopDone4 = true;
						} else {
							if (new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkSetDbHistory").equals(reader.getName())) {
								list4.add(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType.Factory.parse(reader));

							} else {
								loopDone4 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object
							.setLinkSetDbHistory((gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType[]) org.apache.axis2.databinding.utils.ConverterUtil
									.convertToArray(gov.nih.nlm.ncbi.www.soap.eutils.elink.LinkSetDbHistoryType.class, list4));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "WebEnv").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setWebEnv(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdUrlList").equals(reader.getName())) {

					object.setIdUrlList(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdUrlListType.Factory.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IdCheckList").equals(reader.getName())) {

					object.setIdCheckList(gov.nih.nlm.ncbi.www.soap.eutils.elink.IdCheckListType.Factory.parse(reader));

					reader.next();

				} // End of if for expected property start element

				else {

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
	 * <li>dbfrom - {@link String}</li>
	 * <li>idchecklist - {@link IdCheckListType}</li>
	 * <li>idlist - {@link IdListTypeE}</li>
	 * <li>urlidlist - {@link IdUrlListType}</li>
	 * <li>linksetdb - {@link LinkSetDbType}[]</li>
	 * <li>linksetdbhistory - {@link LinkSetDbHistoryType}[]</li>
	 * <li>webenv - {@link String}</li>
	 * </ul>
	 * 
	 * @return The map with all information.
	 */
	@Override
	public Map<String, Object> getParametersMap() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("dbfrom", localDbFrom);
		returnMap.put("idchecklist", localIdCheckList);
		returnMap.put("idlist", localIdList);
		returnMap.put("urlidlist", localIdUrlList);
		returnMap.put("linksetdb", localLinkSetDb);
		returnMap.put("linksetdbhistory", localLinkSetDbHistory);
		returnMap.put("webenv", localWebEnv);
		return returnMap;
	}

}
