package com.gs.fefec.batch.project.data.layer;


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

import com.gs.fefec.batch.entities.project.OperacionPagosTT;
import com.gs.fefec.batch.project.data.interfaces.IInsertOperacionesPagoDAO;
import com.gs.fefec.commons.utilities.time.TimeUtil;

import oracle.jdbc.OracleTypes;

@Repository
public class InsertOperacionesPagoDAOImpl implements IInsertOperacionesPagoDAO{

	private static Logger log = Logger.getLogger(InsertOperacionesPagoDAOImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	private SimpleJdbcCall spInsertOperacionesBancoTT;
	
	private static String SCHEMA;
	   
	@PostConstruct
	public void init(){	     
	    log.info("InsertOperacionesPagoDAO.init()");	    
		SCHEMA = "";
	    this.spInsertOperacionesBancoTT = new SimpleJdbcCall(this.dataSource)
	    .withSchemaName(SCHEMA)
	    .withCatalogName("BATCH")
	    .withProcedureName("INSERTAR_OPERACIONES_BANCO").withoutProcedureColumnMetaDataAccess()
	   .declareParameters(new SqlParameter("CS_TIPO_REGISTRO", OracleTypes.VARCHAR),	    				 					
	    				  //Out Parameters	    				 					
	    				  new SqlOutParameter("CODIGO",OracleTypes.VARCHAR));

	}	
	
	public boolean insertOperacionesBanco(OperacionPagosTT operacionPagosTT) throws Exception {
		
		boolean isInsert=false;

		double startTime = System.nanoTime();
		MapSqlParameterSource map = new MapSqlParameterSource();
		Map<?, ?> out = null;
		try {
			map.addValue("CS_TIPO_REGISTRO", operacionPagosTT.getTipoRegistro(), OracleTypes.VARCHAR);
			
			out=this.spInsertOperacionesBancoTT.execute(map);
			String codigo	= (String) out.get("CODIGO");
			if(codigo.contains("0")) {
				isInsert=true;
			}
		
		} catch (Throwable ex) {
			log.error("Mensaje Error " +ex.fillInStackTrace());
			return isInsert;
		}
		
		double elapsedTime = TimeUtil.getElapsedTime(startTime);
		log.info("Store ejecutado:{ BATCH.INSERTAR_OPERACIONES_BANCO " +elapsedTime+ " ms");
		return isInsert;
	}	
}