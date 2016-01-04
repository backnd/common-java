/*
 * Copyright
 * ------------------------------------------------------------------------
 * (C) Copyright 2006, Xperteam
 *
 * Xperteam retains all ownership rights to this source code. No
 * warranty is expressed or implied by Xperteam, if Xperteam grants
 * the right to use or re-use this source code.
 * ------------------------------------------------------------------------
 */
package com.local.lib.utils;

import org.apache.log4j.Logger;

public class StringUtil {
	private static final Logger logger = Logger.getLogger(StringUtil.class);

	/**
	 * Removes the commas from a given string
	 * @param aNum
	 * @return
	 */
	public String removeCommas(String aNum) {
		String aNumReturned = "";
		if ((aNum != null) && (aNum.trim().length() > 0) && (aNum != "")) {
			//remove any commas
			aNumReturned = aNum.replace(",", "");
		}

		return aNumReturned;
	}

	/**
	 * Takes a String and strip from it whatever is in the delimiter string
	 * and returns a new string with these chars removed.
	 * 
	 * @param stringToStrip
	 * @param whatArray
	 * @param withArray
	 * @return
	 */
	public static String replaceInString(String stringToStrip, String[] whatArray, String[] withArray) {
		String copyOfString = stringToStrip;
		String stringPart1;
		String stringPart2;
		for (int i = 0; i < whatArray.length; i++) {
			if (copyOfString.indexOf(whatArray[i]) != -1) {
				stringPart1 = copyOfString.substring(0, copyOfString.indexOf(whatArray[i]));
				stringPart2 = copyOfString.substring(copyOfString.indexOf(whatArray[i]) + whatArray[i].length());
				copyOfString = stringPart1 + withArray[i] + replaceInString(stringPart2, whatArray, withArray);
			}
		}

		return copyOfString;
	}

	/**
	 * Takes a String and strip from it whatever is in the delimeter string
	 * and returns a new string with these chars removed.
	 *
	 * @see #replaceInString(String stringToStrip, String[] whatArray, String[] withArray)
	 */
	public static String replaceInString(String stringToStrip, String what, String with) {
		return replaceInString(stringToStrip, new String[] { what }, new String[] { with });
	}

	/**
	 * Replaces the null string with empty
	 * 
	 * @param obj
	 * @return
	 */
	public static String nullToEmpty(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}

	/**
	 * Returns a default value if object is null
	 * 
	 * @param obj
	 * @param value
	 * @return
	 */
	public static String nullToString(Object obj, String value) {
		if (obj == null) {
			return value;
		} else {
			return obj.toString();
		}
	}
	
	/**
	 * Returns a default value if object is null or empty
	 * 
	 * @param obj
	 * @param value
	 * @return
	 */
	public static String nullOrEmptyToString(Object obj, String defaultValue) {
		if (obj == null || obj.toString().equals("")) {
			return defaultValue;
		} else {
			return obj.toString();
		}
	}

	/**
	 * Returns Arabic string in good format coming from database where the
	 * encoding is ISO8859_1 <br>
	 * Cp1252 , if we change the database we must change the database encoding
	 * ISO8859_1 related to it
	 * @param originalString
	 *            String to path
	 * @param browserEncoding
	 *            encoding Cp1256 to support arabic
	 * @param databaseEncoding
	 *            ISO8859_1 as databaseEncoding
	 * @return String in Arabic well formated
	 */
	public static String getEncodedString(String originalString, String browserEncoding, String databaseEncoding) {
		try {
			if (originalString == null) {
				return "";
			}
			String result = "";
			if ((originalString.trim().length() > 0)
					&& (browserEncoding != null)
					&& (browserEncoding.trim().length() > 0)
					&& (databaseEncoding != null)
					&& (databaseEncoding.trim().length() > 0)) {
				result = new String(originalString.getBytes(databaseEncoding),
						browserEncoding); // Database Encoding = ISO8859_1 or
				// Cp1252

				return result;
			} else {
				return originalString;
			}
		} catch (Exception exception) {
			logger.error("error", exception);
			return "";
		}
	}

	/**
	 * Searches  the elementSearched in  a string completeString where elements
	 * are separated by the separator
	 * 
	 * @param decryptedString
	 * @return
	 */
	public static boolean searchElement(String completeString, String separator, String elementSearched) {

		String[] st = completeString.split(separator);

		for (int i = 0; i < st.length; i++) {
			if (st[i].equals(elementSearched)) {
				return true;
			}

		}
		return false;
	}
}