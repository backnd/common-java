package com.local.lib.utils;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

public class SecurityUtil {
	
	private static final Logger logger = Logger.getLogger(SecurityUtil.class);

	/**
	 * Gets the Encrypted String
	 * 
	 * @param string
	 * @return byte[]
	 */
	public static byte[] getEncryptedString(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1"); // 160 bit high encryption method
			String clearString = string;
			md.update(clearString.getBytes());
			byte[] digestedPassword = md.digest();
			return digestedPassword;
		} catch (java.security.NoSuchAlgorithmException exception) {
			logger.error("error ", exception);
			return null;
		}

	}

	/**
	 * Converts byte Array to HexString
	 * 
	 * @param b
	 * @return String
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return new String(sb).toUpperCase();
	}

	/**
	 * Converts HexString to byte of Array
	 * 
	 * @param s
	 * @return byte[]
	 */
	public static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}
	public static void main(String [] args){
		System.out.println("password = " +  SecurityUtil.byteArrayToHexString(SecurityUtil.getEncryptedString("passwordsuperadmin")));
	}
}