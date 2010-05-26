package de.hzi.infg.utilities;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.hzi.infg.RInterface;

/**
 * This class goes through the xml, which is meant to be passed to R. If there
 * are elements which are empty then they will be removed.
 * 
 * @author Martin Schumann
 * 
 */
public class TidyXml extends DefaultHandler {

	/**
	 * Entry element has started.
	 */
	private boolean entry;
	/**
	 * The document without all the garbage.
	 */
	private Document newDoc;
	private Stack<Element> docStack;
	private String entryString = "";

	/**
	 * This uses DOM, because we need information about the structure of the xml.
	 * Whether a node has childs or not and such stuff.
	 * 
	 * @param xml The xml as a string.
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public TidyXml(String xml) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory spFactory = SAXParserFactory.newInstance();
		// get parser instance
		SAXParser parser = spFactory.newSAXParser();
		parser.parse(new InputSource(new StringReader(xml)), this);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		docBuilder.parse(new InputSource(new StringReader(xml)));
	}

	@Override
	public void startDocument() throws SAXException {
		docStack = new Stack<Element>();
		docStack.push(null);
		try {
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = df.newDocumentBuilder();
			newDoc = db.newDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// create new element
		Element currEl = newDoc.createElement(qName);
		// System.out.println("Start: "+localName+" "+qName+" "+attributes.getLength());
		for (int i = 0; i < attributes.getLength(); i++) {
			// System.out.println("\t"+attributes.getQName(i)+"="+attributes.getValue(i));
			currEl.setAttribute(attributes.getQName(i), attributes.getValue(i));
		}
		docStack.push(currEl);
		if (qName.equalsIgnoreCase("entry")) {
			entry = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		boolean dontSetEntryString = false;
		Element currEl = docStack.pop();
		Element parentEl = docStack.peek();
		if (entry && qName.equalsIgnoreCase("entry")) {
			if (entryString.equalsIgnoreCase(RInterface.EMPTY_VALUE)) {
				// this should not be part of the new document
				dontSetEntryString = true;
			}
			// write the characters to the current object
			currEl.setTextContent(entryString);
			// delete the previous content
			entryString = "";
			entry = false;
		}
		if (!dontSetEntryString) {
			if (parentEl != null) {
				// System.out.println("parent #childs: "+parentEl.getChildNodes().getLength()+" name="+parentEl.getAttribute("name"));
				parentEl.appendChild(currEl);
			} else {
				newDoc.appendChild(currEl);
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (entry) {
			// append to the entry string, because a \n will cause this event to
			// happen twice in a row.
			entryString += new String(ch, start, length);
			// System.out.println("String: "+new String(ch, start, length));
		}
	}

	/**
	 * The new xml without needless elements as a String.
	 * 
	 * @return The xml without empty entries.
	 */
	public String getTidyXml() {
		// return the newDoc as string
		// write to string, can be formatted, but doesn't has to be
		// OutputFormat format = new OutputFormat(document);
		// format.setLineWidth(65);
		// format.setIndenting(true);
		// format.setIndent(2);
		// Writer out = new StringWriter();
		// XMLSerializer serializer = new XMLSerializer(out, format);
		// serializer.serialize(document);
		String xmlString = "";
		// set up a transformer
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans;
		try {
			trans = tf.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			// create string from xml
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(newDoc);
			trans.transform(source, result);
			xmlString = sw.toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return xmlString;
	}

}
