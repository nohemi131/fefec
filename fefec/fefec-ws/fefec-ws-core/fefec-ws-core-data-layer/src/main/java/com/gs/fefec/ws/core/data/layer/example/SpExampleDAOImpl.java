package com.gs.fefec.ws.core.data.layer.example;


import oracle.jdbc.OracleTypes;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.gs.fefec.commons.utilities.time.TimeUtil;
import com.gs.fefec.commons.utilities.ws.constants.Constants;
import com.gs.fefec.ws.core.data.interfaces.example.ISpExampleDAO;
import com.gs.fefec.ws.core.entities.data.example.Example;



@Repository
public class SpExampleDAOImpl extends Constants implements ISpExampleDAO{
	
	private static Logger log= Logger.getLogger(SpExampleDAOImpl.class.getName());
			

	@Autowired
	private DataSource dataSource;
	
	private SimpleJdbcCall spExample;
	
	   
	@PostConstruct
	public void init(){	     
	    log.info("SpExampleDAOImpl.init()");
	  
	    this.spExample = new SimpleJdbcCall(this.dataSource)
	    .withSchemaName(SCHEMA)
	    .withProcedureName("SP_EXAMPLE")
	    .withoutProcedureColumnMetaDataAccess()
	    .declareParameters(new SqlParameter("VALOR1", OracleTypes.VARCHAR),	    				 					
	    				  //Out Parameters	
			   			  new SqlOutParameter("CODE",OracleTypes.INTEGER),
			   			  new SqlOutParameter("MESSAGE",OracleTypes.VARCHAR),
	    				  new SqlOutParameter("RETURN1",OracleTypes.VARCHAR));

	}
	
	
	
	@Override
	public Example invokeSpExample(String valor1) throws Exception {		
		Example example = new Example() ;
		double startTime = System.nanoTime();
		MapSqlParameterSource map = new MapSqlParameterSource();
		Map<?, ?> out = null;
		try {
			map.addValue("VALOR1", valor1, OracleTypes.VARCHAR);
			
			out=this.spExample.execute(map);
			
			example.setCode( (int)out.get("CODE"));
			example.setMessage((String) out.get("MESSAGE"));
			log.info(" Code: "+example.getCode() +" Message: "+ example.getMessage());
			if(example.getCode() == 0) {
				example.setReturn1((String) out.get("RETURN1"));
			}
		
		} catch (Throwable ex) {
			log.error("Mensaje Error " +ex.fillInStackTrace(),ex);
			example.setCode(-1);
			example.setMessage(ex.getMessage());
		}
		
		double elapsedTime = TimeUtil.getElapsedTime(startTime);
		log.info("Store ejecutado:{  "+SCHEMA+"SP_EXAMPLE" +elapsedTime+ " ms");
		return example;
	}	
}