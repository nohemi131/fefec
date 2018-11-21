package com.gs.fefec.batch.project.business.layer;



import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.gs.fefec.batch.entities.project.OperacionPagosTT;



@Component
public class OperacionesPagosFieldSetMapper implements FieldSetMapper<OperacionPagosTT> {
	
	private static Logger log = Logger.getLogger(OperacionesPagosFieldSetMapper.class);
	
	@Override
	public OperacionPagosTT mapFieldSet(FieldSet fieldSet) throws BindException {
		log.info("OperacionesPagosFieldSetMapper.mapFieldSet()---------------------------------------------------------------------------");
		OperacionPagosTT operacionPagosTT = new OperacionPagosTT();
		if(!fieldSet.readString(0).contains("EOF")) {
		
			operacionPagosTT.setTipoRegistro(fieldSet.readString(0));
			operacionPagosTT.setNumeroSecuencia(fieldSet.readString(1));
			operacionPagosTT.setClaveBanco(fieldSet.readString(2));
			operacionPagosTT.setLineaCaptura(fieldSet.readString(3));
			operacionPagosTT.setImportePagadoOperacion(fieldSet.readString(4));
			operacionPagosTT.setPatente(fieldSet.readString(5));
			operacionPagosTT.setPedimento(fieldSet.readString(6));
			operacionPagosTT.setAduana(fieldSet.readString(7));
			operacionPagosTT.setFechaOperacion(fieldSet.readString(8));
			operacionPagosTT.setHoraOperacion(fieldSet.readString(9));
			operacionPagosTT.setNumeroOperacionBancaria(fieldSet.readString(10));
			operacionPagosTT.setMedioRecepcion(fieldSet.readString(11));
			operacionPagosTT.setFormaPago(fieldSet.readString(12));
			operacionPagosTT.setVersion(fieldSet.readString(13));		
		}
	
		return operacionPagosTT;		
	}

}