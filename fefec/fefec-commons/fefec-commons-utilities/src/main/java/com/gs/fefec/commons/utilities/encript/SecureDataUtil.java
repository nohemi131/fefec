package com.gs.fefec.commons.utilities.encript;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.KeyPair;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
@Configuration
@PropertySource(value = {"file:${path_commons}security.properties"})
@SuppressWarnings("restriction")
public class SecureDataUtil {

	@Autowired
	Environment env;
	
	private static String ciphervar;
	private static String skfvar;
	
	@PostConstruct
	public void init(){
		ciphervar= env.getProperty("cipher.instance");
		skfvar= env.getProperty("skf.instance");
		java.security.Security.addProvider(new BouncyCastleProvider());
	
	}
	
	private static final String KEY_GEN = "CGT37511022SB@6025e7TS3RV1C763Z";
	private static SecretKeyFactory skf;
	private static DESKeySpec kspec;

    public static String cryptData(Key key, Cipher cipher, String text) throws InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String data = text;
        byte[] stringBytes = data.getBytes("UTF8");
        byte[] raw = cipher.doFinal(stringBytes);
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = encoder.encode(raw);
        return base64;
    }

    public static String decryptData (Key key, Cipher cipher, String text) throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] raw = decoder.decodeBuffer(text);
        byte[] stringBytes = cipher.doFinal(raw);
        String result = new String(stringBytes, "UTF8");
        return result;
    }

    public static Key getKey() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
    	skf = SecretKeyFactory.getInstance(skfvar);
        kspec = new DESKeySpec(KEY_GEN.getBytes());
        SecretKey ks = skf.generateSecret(kspec);
        return ks;
    }

    public static Cipher getCipherInstance() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance(ciphervar);

        return cipher;
    }
    
    /**
	 * Return public RSA key exponent
	 *
	 * @param keyPair
	 *            RSA keys
	 * @return public exponent value as hex string
	 */
	public static String getPublicKeyExponent(KeyPair keyPair) {
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		return publicKey.getPublicExponent().toString(16);
	}
	
	/**
	 * Return public RSA key modulus
	 *
	 * @param keyPair
	 *            RSA keys
	 * @return modulus value as hex string
	 */
	public static String getPublicKeyModulus(KeyPair keyPair) {
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		return publicKey.getModulus().toString(16);
	}
	/**
	 * Max block size with given key length
	 *
	 * @param keyLength
	 *            length of key
	 * @return numeber of digits
	 */
	public static int getMaxDigits(int keyLength) {
		return ((keyLength * 2) / 16) + 3;
	}
	/**
	 * Generates the Keypair with the given keyLength.
	 *
	 * @param keyLength
	 *            length of key
	 * @return KeyPair object
	 * @throws RuntimeException
	 *             if the RSA algorithm not supported
	 */
	public KeyPair generateKeypair(int keyLength) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(keyLength);
			KeyPair keyPair = kpg.generateKeyPair();
			return keyPair;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("RSA algorithm not supported", e);
		}
	}
	
	/**
	 * Decrypts a given string with the RSA keys
	 *
	 * @param encrypted
	 *            full encrypted text
	 * @param keys
	 *            RSA keys
	 * @return decrypted text
	 * @throws RuntimeException
	 *             if the RSA algorithm not supported or decrypt operation failed
	 */
	public static String decrypt(String encrypted, KeyPair keys) {
		Cipher dec;
		try {
			java.security.Security.addProvider(new BouncyCastleProvider());
			
			dec = Cipher.getInstance("RSA");
			dec.init(Cipher.DECRYPT_MODE, keys.getPrivate());
		} catch (GeneralSecurityException e) {
			throw new RuntimeException("RSA algorithm not supported", e);
		}
		String[] blocks = encrypted.split("\\s");

		StringBuffer result = new StringBuffer();
		try {
			for (int i = blocks.length - 1; i >= 0; i--) {
				byte[] data = hexStringToByteArray(blocks[i]);
				byte[] decryptedBlock = dec.doFinal(data);
				result.append(new String(decryptedBlock));
			}
		} catch (GeneralSecurityException e) {
			throw new RuntimeException("Decrypt error", e);
		}
		/**
		 * Some code is getting added in first 2 digits with Jcryption need to investigate
		 */
		return result.reverse().toString().substring(2);
	}
	

	/**
	 * Convert hex string to byte array
	 *
	 * @param data
	 *            input string data
	 * @return bytes
	 */
	public static byte[] hexStringToByteArray(String data) {
		int k = 0;
		byte[] results = new byte[data.length() / 2];
		for (int i = 0; i < data.length();) {
			results[k] = (byte) (Character.digit(data.charAt(i++), 16) << 4);
			results[k] += (byte) (Character.digit(data.charAt(i++), 16));
			k++;
		}
		return results;
	}
}
