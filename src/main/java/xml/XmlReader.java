package com.hdc.sysdev.xml;

import java.io.File;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

public final class XmlReader {
	private static Document controlsDoc;
	private SAXBuilder builder;
	public static Logger logger = Logger.getLogger(XmlReader.class);

	/**
	 * Parses XML control file
	 * 
	 * @param servletPath
	 * @param xmlFilePath
	 */
	public XmlReader(String servletPath, String xmlFilePath) {
		try {
			builder = new SAXBuilder();
			builder.setValidation(false);
			builder.setIgnoringElementContentWhitespace(true);
			controlsDoc = builder.build(new File(servletPath + xmlFilePath));
		} catch (Exception exception) {
			logger.error("XMLReader Exception : ", exception);
		}
	}

	/**
	 * Navigates threw XML document and to get the value of a controlAttribute
	 * for a specified ControlName
	 * 
	 * @param controlRoot
	 * @param controlName
	 * @param controlAttribute
	 * @return String
	 */
	public String getControls(String controlRoot, String controlName,
			String controlAttribute) {
		String status = null;
		try {
			status = ((Element) XPath.selectSingleNode(controlsDoc, "/" + controlRoot + "//" + controlName + "")).getAttributeValue(controlAttribute);
		} catch (Exception xmlException) {
			logger.error("XML Exception : ", xmlException);
		}
		return status;
	}

}