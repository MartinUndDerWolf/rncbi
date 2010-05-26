/**
 * ObjUrlType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.elink;

import java.util.HashMap;
import java.util.Map;

import de.hzi.infg.interfaces.TypeInterface;

/**
 * ObjUrlType bean class
 */
public class ObjUrlType implements org.apache.axis2.databinding.ADBBean, TypeInterface {
	/*
	 * This type was generated from the piece of schema that had name =
	 * ObjUrlType Namespace URI = http://www.ncbi.nlm.nih.gov/soap/eutils/elink
	 * Namespace Prefix = ns5
	 */

	private static final long serialVersionUID = 3510315073772032395L;

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/elink")) {
			return "ns5";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for Url
	 */
	protected java.lang.String localUrl;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getUrl() {
		return localUrl;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Url
	 */
	public void setUrl(java.lang.String param) {

		this.localUrl = param;

	}

	/**
	 * field for IconUrl
	 */

	protected java.lang.String localIconUrl;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localIconUrlTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIconUrl() {
		return localIconUrl;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param IconUrl
	 */
	public void setIconUrl(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localIconUrlTracker = true;
		} else {
			localIconUrlTracker = false;

		}

		this.localIconUrl = param;

	}

	/**
	 * field for LinkName
	 */

	protected java.lang.String localLinkName;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localLinkNameTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getLinkName() {
		return localLinkName;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param LinkName
	 */
	public void setLinkName(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localLinkNameTracker = true;
		} else {
			localLinkNameTracker = false;

		}

		this.localLinkName = param;

	}

	/**
	 * field for SubjectType This was an Array!
	 */

	protected java.lang.String[] localSubjectType;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localSubjectTypeTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getSubjectType() {
		return localSubjectType;
	}

	/**
	 * validate the array for SubjectType
	 */
	protected void validateSubjectType(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param SubjectType
	 */
	public void setSubjectType(java.lang.String[] param) {

		validateSubjectType(param);

		if (param != null) {
			// update the setting tracker
			localSubjectTypeTracker = true;
		} else {
			localSubjectTypeTracker = false;

		}

		this.localSubjectType = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param java.lang.String
	 */
	@SuppressWarnings("unchecked")
	public void addSubjectType(java.lang.String param) {
		if (localSubjectType == null) {
			localSubjectType = new java.lang.String[] {};
		}

		// update the setting tracker
		localSubjectTypeTracker = true;

		java.util.List<String> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localSubjectType);
		list.add(param);
		this.localSubjectType = list.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * field for Category This was an Array!
	 */

	protected java.lang.String[] localCategory;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localCategoryTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getCategory() {
		return localCategory;
	}

	/**
	 * validate the array for Category
	 */
	protected void validateCategory(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Category
	 */
	public void setCategory(java.lang.String[] param) {

		validateCategory(param);

		if (param != null) {
			// update the setting tracker
			localCategoryTracker = true;
		} else {
			localCategoryTracker = false;

		}

		this.localCategory = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param java.lang.String
	 */
	@SuppressWarnings("unchecked")
	public void addCategory(java.lang.String param) {
		if (localCategory == null) {
			localCategory = new java.lang.String[] {};
		}

		// update the setting tracker
		localCategoryTracker = true;

		java.util.List<String> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localCategory);
		list.add(param);
		this.localCategory = list.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * field for Attribute This was an Array!
	 */

	protected java.lang.String[] localAttribute;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localAttributeTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getAttribute() {
		return localAttribute;
	}

	/**
	 * validate the array for Attribute
	 */
	protected void validateAttribute(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Attribute
	 */
	public void setAttribute(java.lang.String[] param) {

		validateAttribute(param);

		if (param != null) {
			// update the setting tracker
			localAttributeTracker = true;
		} else {
			localAttributeTracker = false;

		}

		this.localAttribute = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param java.lang.String
	 */
	@SuppressWarnings("unchecked")
	public void addAttribute(java.lang.String param) {
		if (localAttribute == null) {
			localAttribute = new java.lang.String[] {};
		}

		// update the setting tracker
		localAttributeTracker = true;

		java.util.List<String> list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localAttribute);
		list.add(param);
		this.localAttribute = list.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * field for Provider
	 */

	protected gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType localProvider;

	/**
	 * Auto generated getter method
	 * 
	 * @return gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType
	 */
	public gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType getProvider() {
		return localProvider;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Provider
	 */
	public void setProvider(gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType param) {

		this.localProvider = param;

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
				ObjUrlType.this.serialize(parentQName, factory, xmlWriter);
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
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":ObjUrlType", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ObjUrlType", xmlWriter);
			}

		}

		namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
		if (!namespace.equals("")) {
			prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				xmlWriter.writeStartElement(prefix, "Url", namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			} else {
				xmlWriter.writeStartElement(namespace, "Url");
			}

		} else {
			xmlWriter.writeStartElement("Url");
		}

		if (localUrl == null) {
			// write the nil attribute

			throw new org.apache.axis2.databinding.ADBException("Url cannot be null!!");

		} else {

			xmlWriter.writeCharacters(localUrl);

		}

		xmlWriter.writeEndElement();
		if (localIconUrlTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "IconUrl", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "IconUrl");
				}

			} else {
				xmlWriter.writeStartElement("IconUrl");
			}

			if (localIconUrl == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("IconUrl cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localIconUrl);

			}

			xmlWriter.writeEndElement();
		}
		if (localLinkNameTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "LinkName", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "LinkName");
				}

			} else {
				xmlWriter.writeStartElement("LinkName");
			}

			if (localLinkName == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("LinkName cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localLinkName);

			}

			xmlWriter.writeEndElement();
		}
		if (localSubjectTypeTracker) {
			if (localSubjectType != null) {
				namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
				boolean emptyNamespace = namespace == null || namespace.length() == 0;
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
				for (int i = 0; i < localSubjectType.length; i++) {

					if (localSubjectType[i] != null) {

						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "SubjectType", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);

							} else {
								xmlWriter.writeStartElement(namespace, "SubjectType");
							}

						} else {
							xmlWriter.writeStartElement("SubjectType");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubjectType[i]));

						xmlWriter.writeEndElement();

					} else {

						// we have to do nothing since minOccurs is zero

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("SubjectType cannot be null!!");

			}

		}
		if (localCategoryTracker) {
			if (localCategory != null) {
				namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
				boolean emptyNamespace = namespace == null || namespace.length() == 0;
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
				for (int i = 0; i < localCategory.length; i++) {

					if (localCategory[i] != null) {

						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "Category", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);

							} else {
								xmlWriter.writeStartElement(namespace, "Category");
							}

						} else {
							xmlWriter.writeStartElement("Category");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCategory[i]));

						xmlWriter.writeEndElement();

					} else {

						// we have to do nothing since minOccurs is zero

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("Category cannot be null!!");

			}

		}
		if (localAttributeTracker) {
			if (localAttribute != null) {
				namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/elink";
				boolean emptyNamespace = namespace == null || namespace.length() == 0;
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
				for (int i = 0; i < localAttribute.length; i++) {

					if (localAttribute[i] != null) {

						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "Attribute", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);

							} else {
								xmlWriter.writeStartElement(namespace, "Attribute");
							}

						} else {
							xmlWriter.writeStartElement("Attribute");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAttribute[i]));

						xmlWriter.writeEndElement();

					} else {

						// we have to do nothing since minOccurs is zero

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("Attribute cannot be null!!");

			}

		}
		if (localProvider == null) {
			throw new org.apache.axis2.databinding.ADBException("Provider cannot be null!!");
		}
		localProvider.serialize(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Provider"), factory, xmlWriter);

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

		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Url"));

		if (localUrl != null) {
			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUrl));
		} else {
			throw new org.apache.axis2.databinding.ADBException("Url cannot be null!!");
		}
		if (localIconUrlTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IconUrl"));

			if (localIconUrl != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIconUrl));
			} else {
				throw new org.apache.axis2.databinding.ADBException("IconUrl cannot be null!!");
			}
		}
		if (localLinkNameTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkName"));

			if (localLinkName != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLinkName));
			} else {
				throw new org.apache.axis2.databinding.ADBException("LinkName cannot be null!!");
			}
		}
		if (localSubjectTypeTracker) {
			if (localSubjectType != null) {
				for (int i = 0; i < localSubjectType.length; i++) {

					if (localSubjectType[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "SubjectType"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubjectType[i]));
					} else {

						// have to do nothing

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("SubjectType cannot be null!!");

			}

		}
		if (localCategoryTracker) {
			if (localCategory != null) {
				for (int i = 0; i < localCategory.length; i++) {

					if (localCategory[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Category"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCategory[i]));
					} else {

						// have to do nothing

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("Category cannot be null!!");

			}

		}
		if (localAttributeTracker) {
			if (localAttribute != null) {
				for (int i = 0; i < localAttribute.length; i++) {

					if (localAttribute[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Attribute"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAttribute[i]));
					} else {

						// have to do nothing

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException("Attribute cannot be null!!");

			}

		}
		elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Provider"));

		if (localProvider == null) {
			throw new org.apache.axis2.databinding.ADBException("Provider cannot be null!!");
		}
		elementList.add(localProvider);

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
		public static ObjUrlType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			ObjUrlType object = new ObjUrlType();

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

						if (!"ObjUrlType".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (ObjUrlType) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				// commented
				// java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList<String> list4 = new java.util.ArrayList<String>();

				java.util.ArrayList<String> list5 = new java.util.ArrayList<String>();

				java.util.ArrayList<String> list6 = new java.util.ArrayList<String>();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Url").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setUrl(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "IconUrl").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setIconUrl(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "LinkName").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setLinkName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "SubjectType").equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list4.add(reader.getElementText());

					// loop until we find a start element that is not part of this
					// array
					boolean loopDone4 = false;
					while (!loopDone4) {
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
							loopDone4 = true;
						} else {
							if (new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "SubjectType").equals(reader.getName())) {
								list4.add(reader.getElementText());

							} else {
								loopDone4 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setSubjectType(list4.toArray(new java.lang.String[list4.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Category").equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list5.add(reader.getElementText());

					// loop until we find a start element that is not part of this
					// array
					boolean loopDone5 = false;
					while (!loopDone5) {
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
							loopDone5 = true;
						} else {
							if (new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Category").equals(reader.getName())) {
								list5.add(reader.getElementText());

							} else {
								loopDone5 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setCategory(list5.toArray(new java.lang.String[list5.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Attribute").equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list6.add(reader.getElementText());

					// loop until we find a start element that is not part of this
					// array
					boolean loopDone6 = false;
					while (!loopDone6) {
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
							loopDone6 = true;
						} else {
							if (new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Attribute").equals(reader.getName())) {
								list6.add(reader.getElementText());

							} else {
								loopDone6 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setAttribute(list6.toArray(new java.lang.String[list6.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/elink", "Provider").equals(reader.getName())) {

					object.setProvider(gov.nih.nlm.ncbi.www.soap.eutils.elink.ProviderType.Factory.parse(reader));

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
	 * <li>attribute - {@link String}[]</li>
	 * <li>category - {@link String}[]</li>
	 * <li>iconurl - {@link String}</li>
	 * <li>linkname - {@link String}</li>
	 * <li>provider - {@link ProviderType}</li>
	 * <li>subjecttype - {@link String}[]</li>
	 * <li>url - {@link String}</li>
	 * </ul>
	 * 
	 * @return The map with all information.
	 */
	@Override
	public Map<String, Object> getParametersMap() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("attribute", localAttribute);
		returnMap.put("category", localCategory);
		returnMap.put("iconurl", localIconUrl);
		returnMap.put("linkname", localLinkName);
		returnMap.put("provider", localProvider);
		returnMap.put("subjecttype", localSubjectType);
		returnMap.put("url", localUrl);
		return returnMap;
	}

}
