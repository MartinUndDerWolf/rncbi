/**
 * ESearchRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package gov.nih.nlm.ncbi.www.soap.eutils.esearch;

import java.util.HashSet;
import java.util.Set;

import de.hzi.infg.exceptions.ErrorFromWebserviceExeption;

/**
 * ESearchRequest bean class
 */
public class ESearchRequest implements org.apache.axis2.databinding.ADBBean {

	/**
	 * The parameter this operation expects.
	 */
	private final static String[] operationParameter = { "db", "term", "webenv", "query_key", "usehistory", "tool", "email", "field", "reldate",
			"mindate", "maxdate", "datetype", "retstart", "retmax", "rettype", "sort" };

	private static final long serialVersionUID = -5834319502610165809L;

	public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch",
			"eSearchRequest", "ns3");

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch")) {
			return "ns3";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * Compares the given set with the parameters for this operation.
	 * 
	 * @param paraSet Set of parameters, which should be the same as this
	 *           operation requests.
	 * @throws ErrorFromWebserviceExeption If the parameter are wrong for this
	 *            operation.
	 */
	public ESearchRequest(Set<String> paraSet) throws ErrorFromWebserviceExeption {
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
	 * Empty constructor.
	 */
	public ESearchRequest() {
	}

	/**
	 * field for Db
	 */
	protected java.lang.String localDb;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localDbTracker = false;

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
	 * field for Term
	 */

	protected java.lang.String localTerm;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localTermTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTerm() {
		return localTerm;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Term
	 */
	public void setTerm(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localTermTracker = true;
		} else {
			localTermTracker = false;

		}

		this.localTerm = param;

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
	 * field for QueryKey
	 */

	protected java.lang.String localQueryKey;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localQueryKeyTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getQueryKey() {
		return localQueryKey;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param QueryKey
	 */
	public void setQueryKey(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localQueryKeyTracker = true;
		} else {
			localQueryKeyTracker = false;

		}

		this.localQueryKey = param;

	}

	/**
	 * field for Usehistory
	 */

	protected java.lang.String localUsehistory;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localUsehistoryTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getUsehistory() {
		return localUsehistory;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Usehistory
	 */
	public void setUsehistory(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localUsehistoryTracker = true;
		} else {
			localUsehistoryTracker = false;

		}

		this.localUsehistory = param;

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
	 * field for Field
	 */

	protected java.lang.String localField;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localFieldTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getField() {
		return localField;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Field
	 */
	public void setField(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localFieldTracker = true;
		} else {
			localFieldTracker = false;

		}

		this.localField = param;

	}

	/**
	 * field for Reldate
	 */

	protected java.lang.String localReldate;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localReldateTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getReldate() {
		return localReldate;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Reldate
	 */
	public void setReldate(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localReldateTracker = true;
		} else {
			localReldateTracker = false;

		}

		this.localReldate = param;

	}

	/**
	 * field for Mindate
	 */

	protected java.lang.String localMindate;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localMindateTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMindate() {
		return localMindate;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Mindate
	 */
	public void setMindate(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localMindateTracker = true;
		} else {
			localMindateTracker = false;

		}

		this.localMindate = param;

	}

	/**
	 * field for Maxdate
	 */

	protected java.lang.String localMaxdate;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localMaxdateTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMaxdate() {
		return localMaxdate;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Maxdate
	 */
	public void setMaxdate(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localMaxdateTracker = true;
		} else {
			localMaxdateTracker = false;

		}

		this.localMaxdate = param;

	}

	/**
	 * field for Datetype
	 */

	protected java.lang.String localDatetype;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localDatetypeTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDatetype() {
		return localDatetype;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Datetype
	 */
	public void setDatetype(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localDatetypeTracker = true;
		} else {
			localDatetypeTracker = false;

		}

		this.localDatetype = param;

	}

	/**
	 * field for RetStart
	 */

	protected java.lang.String localRetStart;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localRetStartTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getRetStart() {
		return localRetStart;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param RetStart
	 */
	public void setRetStart(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localRetStartTracker = true;
		} else {
			localRetStartTracker = false;

		}

		this.localRetStart = param;

	}

	/**
	 * field for RetMax
	 */

	protected java.lang.String localRetMax;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localRetMaxTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getRetMax() {
		return localRetMax;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param RetMax
	 */
	public void setRetMax(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localRetMaxTracker = true;
		} else {
			localRetMaxTracker = false;

		}

		this.localRetMax = param;

	}

	/**
	 * field for Rettype
	 */

	protected java.lang.String localRettype;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localRettypeTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getRettype() {
		return localRettype;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Rettype
	 */
	public void setRettype(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localRettypeTracker = true;
		} else {
			localRettypeTracker = false;

		}

		this.localRettype = param;

	}

	/**
	 * field for Sort
	 */

	protected java.lang.String localSort;

	/*
	 * This tracker boolean wil be used to detect whether the user called the set
	 * method for this attribute. It will be used to determine whether to include
	 * this field in the serialized XML
	 */
	protected boolean localSortTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSort() {
		return localSort;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param Sort
	 */
	public void setSort(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localSortTracker = true;
		} else {
			localSortTracker = false;

		}

		this.localSort = param;

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
				ESearchRequest.this.serialize(MY_QNAME, factory, xmlWriter);
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

			java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch");
			if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":eSearchRequest", xmlWriter);
			} else {
				writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "eSearchRequest", xmlWriter);
			}

		}
		if (localDbTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
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
		if (localTermTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "term", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "term");
				}

			} else {
				xmlWriter.writeStartElement("term");
			}

			if (localTerm == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("term cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localTerm);

			}

			xmlWriter.writeEndElement();
		}
		if (localWebEnvTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
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
		if (localQueryKeyTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "QueryKey", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "QueryKey");
				}

			} else {
				xmlWriter.writeStartElement("QueryKey");
			}

			if (localQueryKey == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("QueryKey cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localQueryKey);

			}

			xmlWriter.writeEndElement();
		}
		if (localUsehistoryTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "usehistory", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "usehistory");
				}

			} else {
				xmlWriter.writeStartElement("usehistory");
			}

			if (localUsehistory == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("usehistory cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localUsehistory);

			}

			xmlWriter.writeEndElement();
		}
		if (localToolTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
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
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
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
		if (localFieldTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "field", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "field");
				}

			} else {
				xmlWriter.writeStartElement("field");
			}

			if (localField == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("field cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localField);

			}

			xmlWriter.writeEndElement();
		}
		if (localReldateTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "reldate", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "reldate");
				}

			} else {
				xmlWriter.writeStartElement("reldate");
			}

			if (localReldate == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("reldate cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localReldate);

			}

			xmlWriter.writeEndElement();
		}
		if (localMindateTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "mindate", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "mindate");
				}

			} else {
				xmlWriter.writeStartElement("mindate");
			}

			if (localMindate == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("mindate cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localMindate);

			}

			xmlWriter.writeEndElement();
		}
		if (localMaxdateTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "maxdate", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "maxdate");
				}

			} else {
				xmlWriter.writeStartElement("maxdate");
			}

			if (localMaxdate == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("maxdate cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localMaxdate);

			}

			xmlWriter.writeEndElement();
		}
		if (localDatetypeTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "datetype", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "datetype");
				}

			} else {
				xmlWriter.writeStartElement("datetype");
			}

			if (localDatetype == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("datetype cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localDatetype);

			}

			xmlWriter.writeEndElement();
		}
		if (localRetStartTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "RetStart", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "RetStart");
				}

			} else {
				xmlWriter.writeStartElement("RetStart");
			}

			if (localRetStart == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("RetStart cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localRetStart);

			}

			xmlWriter.writeEndElement();
		}
		if (localRetMaxTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "RetMax", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "RetMax");
				}

			} else {
				xmlWriter.writeStartElement("RetMax");
			}

			if (localRetMax == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("RetMax cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localRetMax);

			}

			xmlWriter.writeEndElement();
		}
		if (localRettypeTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "rettype", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "rettype");
				}

			} else {
				xmlWriter.writeStartElement("rettype");
			}

			if (localRettype == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("rettype cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localRettype);

			}

			xmlWriter.writeEndElement();
		}
		if (localSortTracker) {
			namespace = "http://www.ncbi.nlm.nih.gov/soap/eutils/esearch";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "sort", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "sort");
				}

			} else {
				xmlWriter.writeStartElement("sort");
			}

			if (localSort == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("sort cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localSort);

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

		if (localDbTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "db"));

			if (localDb != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDb));
			} else {
				throw new org.apache.axis2.databinding.ADBException("db cannot be null!!");
			}
		}
		if (localTermTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "term"));

			if (localTerm != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTerm));
			} else {
				throw new org.apache.axis2.databinding.ADBException("term cannot be null!!");
			}
		}
		if (localWebEnvTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "WebEnv"));

			if (localWebEnv != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWebEnv));
			} else {
				throw new org.apache.axis2.databinding.ADBException("WebEnv cannot be null!!");
			}
		}
		if (localQueryKeyTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "QueryKey"));

			if (localQueryKey != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQueryKey));
			} else {
				throw new org.apache.axis2.databinding.ADBException("QueryKey cannot be null!!");
			}
		}
		if (localUsehistoryTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "usehistory"));

			if (localUsehistory != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUsehistory));
			} else {
				throw new org.apache.axis2.databinding.ADBException("usehistory cannot be null!!");
			}
		}
		if (localToolTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "tool"));

			if (localTool != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTool));
			} else {
				throw new org.apache.axis2.databinding.ADBException("tool cannot be null!!");
			}
		}
		if (localEmailTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "email"));

			if (localEmail != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmail));
			} else {
				throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");
			}
		}
		if (localFieldTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "field"));

			if (localField != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField));
			} else {
				throw new org.apache.axis2.databinding.ADBException("field cannot be null!!");
			}
		}
		if (localReldateTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "reldate"));

			if (localReldate != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReldate));
			} else {
				throw new org.apache.axis2.databinding.ADBException("reldate cannot be null!!");
			}
		}
		if (localMindateTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "mindate"));

			if (localMindate != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMindate));
			} else {
				throw new org.apache.axis2.databinding.ADBException("mindate cannot be null!!");
			}
		}
		if (localMaxdateTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "maxdate"));

			if (localMaxdate != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxdate));
			} else {
				throw new org.apache.axis2.databinding.ADBException("maxdate cannot be null!!");
			}
		}
		if (localDatetypeTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "datetype"));

			if (localDatetype != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDatetype));
			} else {
				throw new org.apache.axis2.databinding.ADBException("datetype cannot be null!!");
			}
		}
		if (localRetStartTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "RetStart"));

			if (localRetStart != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRetStart));
			} else {
				throw new org.apache.axis2.databinding.ADBException("RetStart cannot be null!!");
			}
		}
		if (localRetMaxTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "RetMax"));

			if (localRetMax != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRetMax));
			} else {
				throw new org.apache.axis2.databinding.ADBException("RetMax cannot be null!!");
			}
		}
		if (localRettypeTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "rettype"));

			if (localRettype != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRettype));
			} else {
				throw new org.apache.axis2.databinding.ADBException("rettype cannot be null!!");
			}
		}
		if (localSortTracker) {
			elementList.add(new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "sort"));

			if (localSort != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSort));
			} else {
				throw new org.apache.axis2.databinding.ADBException("sort cannot be null!!");
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
		public static ESearchRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			ESearchRequest object = new ESearchRequest();

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

						if (!"eSearchRequest".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							return (ESearchRequest) gov.nih.nlm.ncbi.www.soap.eutils.egquery.ExtensionMapper.getTypeObject(nsUri, type, reader);
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
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "db").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setDb(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "term").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setTerm(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "WebEnv").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setWebEnv(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "QueryKey").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setQueryKey(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "usehistory").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setUsehistory(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "tool").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setTool(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "email").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setEmail(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "field").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setField(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "reldate").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setReldate(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "mindate").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setMindate(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "maxdate").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setMaxdate(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "datetype").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setDatetype(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "RetStart").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setRetStart(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "RetMax").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setRetMax(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "rettype").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setRettype(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("http://www.ncbi.nlm.nih.gov/soap/eutils/esearch", "sort").equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setSort(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
