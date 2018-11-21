package com.gs.fefec.commons.utilities.encript;



import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import com.gs.fefec.ws.core.entities.annotation.Cipher;


public class CipherReflection {
	
	private static Logger log= Logger.getLogger(CipherReflection.class);

	@SuppressWarnings("unchecked")
	public static <T> T encript(Object  object) {
		try{
			Field[] fields = object.getClass().getDeclaredFields();	
			for (Field field : fields) {	
				if (field.isAnnotationPresent(Cipher.class)) {
					field=setValueEnable(field);		
					field.set(object, CipherUtil.doCipher((String)field.get(object)));	
				}
			}
		}catch(Throwable e){
			log.error("Message Error " +e.fillInStackTrace());
		}
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T desencript(Object object) {
		try{
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {		
				if (field.isAnnotationPresent(Cipher.class)) {
					field=setValueEnable(field);
					field.set(object, CipherUtil.doUnCipher((String)field.get(object)));			    			
				}
			}
		}catch(Throwable e){
			log.error("Message Error " +e.fillInStackTrace());
		}
		
		return (T) object;
	}	
	
	private static Field setValueEnable(Field field){
		field.setAccessible(true);
		return field;
	}
}
