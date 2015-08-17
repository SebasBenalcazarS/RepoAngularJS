package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloUnidadManejoInformacionRecepcionID;

@Entity
public class VistaArticuloUnidadManejoInformacionRecepcionDTO {
	@EmbeddedId
	VistaArticuloUnidadManejoInformacionRecepcionID id = new VistaArticuloUnidadManejoInformacionRecepcionID();
	
	private String codigoBarrasUnidadManejo;
	private Integer valorUnidadManejo;
	private String valorTipoUnidadEmpaque;
	private Double peso;
	private Double alto;
	private Double ancho;
	private Double profundidad; 
	private String codigoBarrasArticulo;
//	private String estadoArticuloBitacora;
	private String referenciaMedida;
	private String descripcionArticulo;	

	//Indicador para saber si se debe exigir una fecha de caducidad en la recepci�n de mercader�a
	private Boolean verFecCadRec;
	//Campos para verificar si aplica la fecha de caducidad del registro sanitario
	private String valorAplicaRegistroSanitario;
	private Integer codigoAplicaRegistroSanitario;	
	private String valorEstadoTransgenico; 
	private Integer codigoEstadoTransgenico;
	// Valor actual del precio
	private Double valorActual;
	//Codigo unidad manejo padre
	private Long codigoUnidadManejoContenida;
	
	//Campos del articulo comercial
	private String tipoControlCosto;
	
	//cantidad Recibida en pallet
	@Transient
	private Integer cantidadTotalRecibida;
	
	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	/**
	 * @return the alto
	 */
	public Double getAlto() {
		return alto;
	}
	/**
	 * @param alto the alto to set
	 */
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	/**
	 * @return the ancho
	 */
	public Double getAncho() {
		return ancho;
	}
	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	/**
	 * @return the profundidad
	 */
	public Double getProfundidad() {
		return profundidad;
	}
	/**
	 * @param profundidad the profundidad to set
	 */
	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}
		
	/**
	 * @return the codigoBarrasUnidadManejo
	 */
	public String getCodigoBarrasUnidadManejo() {
		return codigoBarrasUnidadManejo;
	}
	/**
	 * @param codigoBarrasUnidadManejo the codigoBarrasUnidadManejo to set
	 */
	public void setCodigoBarrasUnidadManejo(String codigoBarrasUnidadManejo) {
		this.codigoBarrasUnidadManejo = codigoBarrasUnidadManejo;
	}
	
	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}
	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}
	/**
	 * @return the valorTipoUnidadEmpaque
	 */
	public String getValorTipoUnidadEmpaque() {
		return valorTipoUnidadEmpaque;
	}
	/**
	 * @param valorTipoUnidadEmpaque the valorTipoUnidadEmpaque to set
	 */
	public void setValorTipoUnidadEmpaque(String valorTipoUnidadEmpaque) {
		this.valorTipoUnidadEmpaque = valorTipoUnidadEmpaque;
	}
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarrasArticulo() {
		return codigoBarrasArticulo;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarrasArticulo(String codigoBarras) {
		this.codigoBarrasArticulo = codigoBarras;
	}
//	/**
//	 * @return the estadoArticuloBitacora
//	 */
//	public String getEstadoArticuloBitacora() {
//		return estadoArticuloBitacora;
//	}
//	/**
//	 * @param estadoArticuloBitacora the estadoArticuloBitacora to set
//	 */
//	public void setEstadoArticuloBitacora(String estadoArticuloBitacora) {
//		this.estadoArticuloBitacora = estadoArticuloBitacora;
//	}
	/**
	 * @return the referenciaMedida
	 */
	public String getReferenciaMedida() {
		return referenciaMedida;
	}
	/**
	 * @param referenciaMedida the referenciaMedida to set
	 */
	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}
	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	public VistaArticuloUnidadManejoInformacionRecepcionID getId() {
		return id;
	}
	public void setId(VistaArticuloUnidadManejoInformacionRecepcionID id) {
		this.id = id;
	}
	/**
	 * @return the verFecCadRec
	 */
	public Boolean getVerFecCadRec() {
		return verFecCadRec;
	}
	/**
	 * @param verFecCadRec the verFecCadRec to set
	 */
	public void setVerFecCadRec(Boolean verFecCadRec) {
		this.verFecCadRec = verFecCadRec;
	}
	/**
	 * @return the valorAplicaRegistroSanitario
	 */
	public String getValorAplicaRegistroSanitario() {
		return valorAplicaRegistroSanitario;
	}
	/**
	 * @param valorAplicaRegistroSanitario the valorAplicaRegistroSanitario to set
	 */
	public void setValorAplicaRegistroSanitario(String valorAplicaRegistroSanitario) {
		this.valorAplicaRegistroSanitario = valorAplicaRegistroSanitario;
	}
	/**
	 * @return the codigoAplicaRegistroSanitario
	 */
	public Integer getCodigoAplicaRegistroSanitario() {
		return codigoAplicaRegistroSanitario;
	}
	/**
	 * @param codigoAplicaRegistroSanitario the codigoAplicaRegistroSanitario to set
	 */
	public void setCodigoAplicaRegistroSanitario(Integer codigoAplicaRegistroSanitario) {
		this.codigoAplicaRegistroSanitario = codigoAplicaRegistroSanitario;
	}
	/**
	 * @return the valorActual
	 */
	public Double getValorActual() {
		return valorActual;
	}
	/**
	 * @param valorActual the valorActual to set
	 */
	public void setValorActual(Double valorActual) {
		this.valorActual = valorActual;
	}
	/**
	 * @return the codigoUnidadManejoContenida
	 */
	public Long getCodigoUnidadManejoContenida() {
		return codigoUnidadManejoContenida;
	}
	/**
	 * @param codigoUnidadManejoContenida the codigoUnidadManejoContenida to set
	 */
	public void setCodigoUnidadManejoContenida(Long codigoUnidadManejoContenida) {
		this.codigoUnidadManejoContenida = codigoUnidadManejoContenida;
	}
	/**
	 * @return the cantidadTotalRecibida
	 */
	public Integer getCantidadTotalRecibida() {
		return cantidadTotalRecibida;
	}
	/**
	 * @param cantidadTotalRecibida the cantidadTotalRecibida to set
	 */
	public void setCantidadTotalRecibida(Integer cantidadTotalRecibida) {
		this.cantidadTotalRecibida = cantidadTotalRecibida;
	}
	/**
	 * @return the valorEstadoTransgenico
	 */
	public String getValorEstadoTransgenico() {
		return valorEstadoTransgenico;
	}
	/**
	 * @param valorEstadoTransgenico the valorEstadoTransgenico to set
	 */
	public void setValorEstadoTransgenico(String valorEstadoTransgenico) {
		this.valorEstadoTransgenico = valorEstadoTransgenico;
	}
	/**
	 * @return the codigoEstadoTransgenico
	 */
	public Integer getCodigoEstadoTransgenico() {
		return codigoEstadoTransgenico;
	}
	/**
	 * @param codigoEstadoTransgenico the codigoEstadoTransgenico to set
	 */
	public void setCodigoEstadoTransgenico(Integer codigoEstadoTransgenico) {
		this.codigoEstadoTransgenico = codigoEstadoTransgenico;
	}
	/**
	 * @return the tipoControlCosto
	 */
	public String getTipoControlCosto() {
		return tipoControlCosto;
	}
	/**
	 * @param tipoControlCosto the tipoControlCosto to set
	 */
	public void setTipoControlCosto(String tipoControlCosto) {
		this.tipoControlCosto = tipoControlCosto;
	}

	
		
}

