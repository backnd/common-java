package com.hdc.sysdev.common;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class Translator {
	private static boolean isLoaded              = false;
	private static Properties propTranslation    = null;
	public static Logger logger = Logger.getLogger(Translator.class);

	/**
	 * Get Bundles to charge the properties file
	 *  
	 * @param servletPath
	 * @param xmlFilePath
	 */
	public static void getBundle(String servletPath, String xmlFilePath) {
		if (!isLoaded) {
			propTranslation = new Properties();
			try {
				propTranslation.loadFromXML(new FileInputStream(servletPath + xmlFilePath));
				isLoaded = true;
			} catch (InvalidPropertiesFormatException exception) {
				logger.error("error",exception);
			} catch (FileNotFoundException exception) {
				logger.error("error",exception);
			} catch (IOException exception) {
				logger.error("error",exception);
			}
		}
	}

	/**
	 * Translates Strings
	 * 
	 * @param keyValue
	 * @param lang
	 * @return translated String
	 */
	public static String translate(String keyValue, String lang) {
		try
		{
			return propTranslation.getProperty(keyValue + "_" + lang);
		}
		catch (Exception exception)
		{
			logger.error("error reading  the key " + keyValue,exception);
			return "";
		}
	}

	/**
	 * Checks if the properties file is loaded or not
	 * @return boolean
	 */
	public static boolean isLoaded() {
		return isLoaded;
	}
}
