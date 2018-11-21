package com.gs.fefec.batch.project.data.interfaces;

import com.gs.fefec.batch.entities.project.OperacionPagosTT;

public interface IInsertOperacionesPagoDAO {

	public boolean insertOperacionesBanco(OperacionPagosTT operacionPagosTT) throws Exception;
}
