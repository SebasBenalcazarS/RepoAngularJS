/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * Clase para mapear los proveedores a los que se va crear una recepcion con un proceso spring batch
 * @author wcaiza
 *
 */
@Entity
@SuppressWarnings("serial")
public class VistaRecepcionPereciblesBatchDTO extends SearchDTO {

	@Id
	private String codigoProveedor;
	private Integer codigoCompania;

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
	
}
