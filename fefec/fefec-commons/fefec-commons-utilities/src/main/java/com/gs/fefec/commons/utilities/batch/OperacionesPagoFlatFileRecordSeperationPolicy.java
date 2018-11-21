package com.gs.fefec.commons.utilities.batch;



import org.apache.log4j.Logger;
import org.springframework.batch.item.file.separator.SimpleRecordSeparatorPolicy;


public class OperacionesPagoFlatFileRecordSeperationPolicy  extends SimpleRecordSeparatorPolicy {
	private static Logger log = Logger.getLogger(OperacionesPagoFlatFileRecordSeperationPolicy.class);
    public static final String EOF = "EOF";


    @Override
    public boolean isEndOfRecord(String line) {    
    
        return true; 
    }
    
    @Override
    public String preProcess(String line) {
    	  if(line.matches(EOF)){
    		  log.info("remplazando OEF por contenido valido");
              return "\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|";
          }  
          return super.preProcess(line);
    }
    @Override
    public String postProcess(String record) {
    	  if(record.matches(EOF)){
              return "\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|\\|";
          }  
           return super.postProcess(record);
    }
}