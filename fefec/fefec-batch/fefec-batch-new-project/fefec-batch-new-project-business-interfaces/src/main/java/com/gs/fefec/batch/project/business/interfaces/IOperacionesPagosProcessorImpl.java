package com.gs.fefec.batch.project.business.interfaces;

import org.springframework.batch.item.ItemProcessor;

import com.gs.fefec.batch.entities.project.OperacionPagosTT;

public interface IOperacionesPagosProcessorImpl extends ItemProcessor<OperacionPagosTT, OperacionPagosTT>{

	public OperacionPagosTT process(OperacionPagosTT operacionPagoTT) throws Exception;
}
