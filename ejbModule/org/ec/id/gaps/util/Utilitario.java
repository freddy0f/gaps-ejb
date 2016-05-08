package org.ec.id.gaps.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class Utilitario {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public static synchronized String getMD5_Base64(String input) {
		MessageDigest digest = null;

		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (digest == null) {
			return input;
		}

		// now everything is ok, go ahead
		try {
			digest.update(input.getBytes("UTF-8"));
		} catch (java.io.UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		byte[] rawData = digest.digest();
		BASE64Encoder bencoder = new BASE64Encoder();
		return bencoder.encode(rawData);
	}
	public static void main(String[] arg) {
		System.out.println(Utilitario.getMD5_Base64("freddy"));
	}

}
