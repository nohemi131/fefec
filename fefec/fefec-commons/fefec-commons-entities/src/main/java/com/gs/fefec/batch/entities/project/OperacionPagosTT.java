package com.gs.fefec.batch.entities.project;



import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Repository;

@Repository("operacionesPagosTT")
@XmlRootElement(name = "operacionesPagosTT")
public class OperacionPagosTT {

	private String tipoRegistro;
	private String numeroSecuencia;
	private String claveBanco;
	private String lineaCaptura;
	private String importePagadoOperacion;
	private String patente;
	private String pedimento;
	private String aduana;
	private String fechaOperacion;
	private String horaOperacion;
	private String numeroOperacionBancaria;
	private String medioRecepcion;
	private String formaPago;
	private String version;
	private String vacio;
	
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getNumeroSecuencia() {
		return numeroSecuencia;
	}
	public void setNumeroSecuencia(String numeroSecuencia) {
		this.numeroSecuencia = numeroSecuencia;
	}
	public String getClaveBanco() {
		return claveBanco;
	}
	public void setClaveBanco(String claveBanco) {
		this.claveBanco = claveBanco;
	}
	public String getLineaCaptura() {
		return lineaCaptura;
	}
	public void setLineaCaptura(String lineaCaptura) {
		this.lineaCaptura = lineaCaptura;
	}
	public String getImportePagadoOperacion() {
		return importePagadoOperacion;
	}
	public void setImportePagadoOperacion(String importePagadoOperacion) {
		this.importePagadoOperacion = importePagadoOperacion;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getPedimento() {
		return pedimento;
	}
	public void setPedimento(String pedimento) {
		this.pedimento = pedimento;
	}
	public String getAduana() {
		return aduana;
	}
	public void setAduana(String aduana) {
		this.aduana = aduana;
	}
	public String getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	public String getHoraOperacion() {
		return horaOperacion;
	}
	public void setHoraOperacion(String horaOperacion) {
		this.horaOperacion = horaOperacion;
	}
	public String getNumeroOperacionBancaria() {
		return numeroOperacionBancaria;
	}
	public void setNumeroOperacionBancaria(String numeroOperacionBancaria) {
		this.numeroOperacionBancaria = numeroOperacionBancaria;
	}
	public String getMedioRecepcion() {
		return medioRecepcion;
	}
	public void setMedioRecepcion(String medioRecepcion) {
		this.medioRecepcion = medioRecepcion;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVacio() {
		return vacio;
	}
	public void setVacio(String vacio) {
		this.vacio = vacio;
	}
	@Override
	public String toString() {
		return "{\"tipoRegistro\":\"" + tipoRegistro + "\", numeroSecuencia\":\"" + numeroSecuencia
				+ "\", claveBanco\":\"" + claveBanco + "\", lineaCaptura\":\"" + lineaCaptura
				+ "\", importePagadoOperacion\":\"" + importePagadoOperacion + "\", patente\":\"" + patente
				+ "\", pedimento\":\"" + pedimento + "\", aduana\":\"" + aduana + "\", fechaOperacion\":\""
				+ fechaOperacion + "\", horaOperacion\":\"" + horaOperacion + "\", numeroOperacionBancaria\":\""
				+ numeroOperacionBancaria + "\", medioRecepcion\":\"" + medioRecepcion + "\", formaPago\":\""
				+ formaPago + "\", version\":\"" + version + "\", vacio\":\"" + vacio + "}";
	}
	
	
	
}