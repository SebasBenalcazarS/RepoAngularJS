/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;


/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
public class VistaIntegracionRecepcionPalletDetalleDTO extends SearchDTO{
	
	@Id
	private Long codigoDatosTarea;
	
	private Integer codigoCompania;
	
	private String codigoBarrasPallet;
	
	private String codigoArticulo;
	private String codigoBarrasArticulo;
	
	private Integer valorUnidadManejo;
	
	private Integer cantidad;
	private BigDecimal peso;

	private Integer codigoAreaTrabajo;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubbodega;
	
	private String codigoProveedor;
	
	private String idUsuarioRecibidor;
	
	private String anden;
	
	/**
	 * 
	 */
	private BigDecimal pesoPalletJack;
	
	private String ubicacionActual;
	
	private String ubicacionDestino;
	
	private Integer tipoControlCosto;

	private Integer numeroPalletJack;
	
	private Integer taraArticulo;
	
	private BigDecimal pesoTaraArticulo;
	
	private BigDecimal pesoBrutoPallet;
	
	
	/********************************************************************************
	 * SETTERS & GETTERS
	 ********************************************************************************/
	
	/**
	 * @return the codigoDatosTarea
	 */
	public Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}
	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoBarrasPallet
	 */
	public String getCodigoBarrasPallet() {
		return codigoBarrasPallet;
	}
	/**
	 * @param codigoBarrasPallet the codigoBarrasPallet to set
	 */
	public void setCodigoBarrasPallet(String codigoBarrasPallet) {
		this.codigoBarrasPallet = codigoBarrasPallet;
	}
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the codigoBarrasArticulo
	 */
	public String getCodigoBarrasArticulo() {
		return codigoBarrasArticulo;
	}
	/**
	 * @param codigoBarrasArticulo the codigoBarrasArticulo to set
	 */
	public void setCodigoBarrasArticulo(String codigoBarrasArticulo) {
		this.codigoBarrasArticulo = codigoBarrasArticulo;
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
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the peso
	 */
	public BigDecimal getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}
	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
	/**
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}
	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}
	/**
	 * @return the codigoAreaTrabajoSubbodega
	 */
	public Integer getCodigoAreaTrabajoSubbodega() {
		return codigoAreaTrabajoSubbodega;
	}
	/**
	 * @param codigoAreaTrabajoSubbodega the codigoAreaTrabajoSubbodega to set
	 */
	public void setCodigoAreaTrabajoSubbodega(Integer codigoAreaTrabajoSubbodega) {
		this.codigoAreaTrabajoSubbodega = codigoAreaTrabajoSubbodega;
	}
	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	/**
	 * @return the idUsuarioRecibidor
	 */
	public String getIdUsuarioRecibidor() {
		return idUsuarioRecibidor;
	}
	/**
	 * @param idUsuarioRecibidor the idUsuarioRecibidor to set
	 */
	public void setIdUsuarioRecibidor(String idUsuarioRecibidor) {
		this.idUsuarioRecibidor = idUsuarioRecibidor;
	}
	/**
	 * @return the anden
	 */
	public String getAnden() {
		return anden;
	}
	/**
	 * @param anden the anden to set
	 */
	public void setAnden(String anden) {
		this.anden = anden;
	}
	
	
}
