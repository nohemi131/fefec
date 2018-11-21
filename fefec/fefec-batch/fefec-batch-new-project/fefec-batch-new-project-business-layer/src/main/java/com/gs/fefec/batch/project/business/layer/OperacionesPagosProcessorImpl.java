package com.gs.fefec.batch.project.business.layer;



import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gs.fefec.batch.entities.project.OperacionPagosTT;
import com.gs.fefec.batch.project.business.interfaces.IOperacionesPagosProcessorImpl;
import com.gs.fefec.batch.project.data.interfaces.IInsertOperacionesPagoDAO;


@Component("operacionesPagoProcessor")
public class OperacionesPagosProcessorImpl implements IOperacionesPagosProcessorImpl {

	private static Logger log = Logger.getLogger(OperacionesPagosProcessorImpl.class);
	
	@Autowired
	private IInsertOperacionesPagoDAO insertOperacionesPagoDAOImpl;
	
	@Override
	public OperacionPagosTT process(OperacionPagosTT operacionPagoTT) throws Exception {
		log.info("Processing..................................." + operacionPagoTT);
		//TODO .... 
		insertOperacionesPagoDAOImpl.insertOperacionesBanco(operacionPagoTT);
		return operacionPagoTT;
	}

}