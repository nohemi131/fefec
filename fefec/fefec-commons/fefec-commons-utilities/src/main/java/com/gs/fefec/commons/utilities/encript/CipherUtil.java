package com.gs.fefec.commons.utilities.encript;



import org.apache.log4j.Logger;

public class CipherUtil {
	
	public static Logger log = Logger.getLogger(CipherUtil.class);

	public static String doCipher(String textoClaro) {
		String ciphered = "";
		try {
			ciphered = SecureDataUtil.cryptData(SecureDataUtil.getKey(),SecureDataUtil.getCipherInstance(), textoClaro);
		} catch (Exception e) {
			log.error("Message Error " +e.fillInStackTrace());
			log.error("Error al cifrar el texto " + textoClaro);
		}
		return ciphered;
	}

	public static String doUnCipher(String textoCifrado) {
		String ciphered = "";
		try {
			ciphered = SecureDataUtil.decryptData(SecureDataUtil.getKey(),SecureDataUtil.getCipherInstance(), textoCifrado);
		} catch (Exception e) {
			log.error("Message Error " +e.fillInStackTrace());
			log.error("Error al decifrar el texto " + textoCifrado);
		}
		return ciphered;
	}

	public static void main(String[] args) {
		String pass = "8jcgQCsHhnNv24SH3pk5ybOnfWX6k5s8vIm4UH6gYC4=";
		log.info(doUnCipher(pass));
	}
}
