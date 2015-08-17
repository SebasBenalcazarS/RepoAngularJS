package ec.com.smx.sic.cliente.mdl.nopersistente;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * 
 * @author cherrera
 *
 */

@SuppressWarnings("serial")
@Entity
public class TransferenciaCountTrasient extends SimpleAuditDTO {

	/**
	 * DECLARACION DE VARIABLES
	 */
	@Id
	private Integer codigoProcesoLogistico;
	private String codigoCatalogoValorActual;
	private Integer codigoCatalogoTipoOrigen;
	private Integer codigoCatalogoTipoActual;
	private String nombreCatalogoValor;
	private Integer totalContenedor;
	
	/**
	 * DECLARACION DE GETTERS Y SETTERS
	 */
	
	/**
	 * @return the codigoProcesoLogistico
	 */
	public Integer getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Integer codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}
	
	/**
	 * @return the codigoCatalogoTipoOrigen
	 */
	public Integer getCodigoCatalogoTipoOrigen() {
		return codigoCatalogoTipoOrigen;
	}
	
	/**
	 * @param codigoCatalogoTipoOrigen the codigoCatalogoTipoOrigen to set
	 */
	public void setCodigoCatalogoTipoOrigen(Integer codigoCatalogoTipoOrigen) {
		this.codigoCatalogoTipoOrigen = codigoCatalogoTipoOrigen;
	}
	
	/**
	 * @return the codigoCatalogoValorActual
	 */
	public String getCodigoCatalogoValorActual() {
		return codigoCatalogoValorActual;
	}
	
	/**
	 * @param codigoCatalogoValorActual the codigoCatalogoValorActual to set
	 */
	public void setCodigoCatalogoValorActual(String codigoCatalogoValorActual) {
		this.codigoCatalogoValorActual = codigoCatalogoValorActual;
	}
	
	/**
	 * @return the codigoCatalogoTipoActual
	 */
	public Integer getCodigoCatalogoTipoActual() {
		return codigoCatalogoTipoActual;
	}
	
	/**
	 * @param codigoCatalogoTipoActual the codigoCatalogoTipoActual to set
	 */
	public void setCodigoCatalogoTipoActual(Integer codigoCatalogoTipoActual) {
		this.codigoCatalogoTipoActual = codigoCatalogoTipoActual;
	}
	
	/**
	 * @return the nombreCatalogoValor
	 */
	public String getNombreCatalogoValor() {
		return nombreCatalogoValor;
	}
	
	/**
	 * @param nombreCatalogoValor the nombreCatalogoValor to set
	 */
	public void setNombreCatalogoValor(String nombreCatalogoValor) {
		this.nombreCatalogoValor = nombreCatalogoValor;
	}

	/**
	 * @return the totalContenedor
	 */
	public Integer getTotalContenedor() {
		return totalContenedor;
	}
	/**
	 * @param totalContenedor the totalContenedor to set
	 */
	public void setTotalContenedor(Integer totalContenedor) {
		this.totalContenedor = totalContenedor;
	}
}
