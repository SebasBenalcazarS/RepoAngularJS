/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor.bean;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class InformacionDocumentoProveedor implements Serializable {
	
	private String numeroDocumento;
	private String tipoDocumentoProveedor;
	private TipoPersonaEntidad tipoPersonaEntidad;
	
	
	
	/**
	 * 
	 * @param numeroDocumento
	 * @param tipoDocumentoProveedor
	 * @param tipoPersonaProveedor
	 */
	public InformacionDocumentoProveedor(String numeroDocumento,
			String tipoDocumentoProveedor,
			TipoPersonaEntidad tipoPersonaEntidad) {
	
		this.numeroDocumento = numeroDocumento;
		this.tipoDocumentoProveedor = tipoDocumentoProveedor;
		this.tipoPersonaEntidad = tipoPersonaEntidad;
	}
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the tipoDocumentoProveedor
	 */
	public String getTipoDocumentoProveedor() {
		return tipoDocumentoProveedor;
	}
	/**
	 * @param tipoDocumentoProveedor the tipoDocumentoProveedor to set
	 */
	public void setTipoDocumentoProveedor(String tipoDocumentoProveedor) {
		this.tipoDocumentoProveedor = tipoDocumentoProveedor;
	}
	/**
	 * @return the tipoPersonaProveedor
	 */
	public TipoPersonaEntidad getTipoPersonaEntidad() {
		return tipoPersonaEntidad;
	}
	/**
	 * @param tipoPersonaProveedor the tipoPersonaProveedor to set
	 */
	public void setTipoPersonaProveedor(TipoPersonaEntidad tipoPersonaEntidad) {
		this.tipoPersonaEntidad = tipoPersonaEntidad;
	}
	
	

}
