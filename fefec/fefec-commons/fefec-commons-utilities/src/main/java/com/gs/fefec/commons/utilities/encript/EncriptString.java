package com.gs.fefec.commons.utilities.encript;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import sun.misc.*;

@Repository
public class EncriptString {

		private Logger log= Logger.getLogger(EncriptString.class);

	   public String encryptSHA(String plaintext) {
	       MessageDigest md = null;
	       try {
	           md = MessageDigest.getInstance("SHA");
	       } catch (NoSuchAlgorithmException e) {
	    	   log.error("Message Error " +e.fillInStackTrace());
	       }
	       try {
	           md.update(plaintext.getBytes("UTF-8"));
	       } catch (UnsupportedEncodingException e) {
	    	   log.error("Message Error " +e.fillInStackTrace());
	       }
	       byte raw[] = md.digest();
	       @SuppressWarnings("restriction")
		String hash = (new BASE64Encoder()).encode(raw);
	       return hash;
	   }
	   
	   
}
