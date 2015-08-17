/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.framework.ad.baseobjects.BaseConsultaVO;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class EntidadVO<T extends IBaseEntidad> extends BaseConsultaVO<T> {
	
	private TipoPersonaEntidad tipoEntidad;
	private String numeroRUCCorporativo;
	private DatoContactoPersonaLocalizacionDTO contactoPersonal;
	private String idUsuarioActual;
	private String codigoSistemaActual;
	private String nombreEntidad;
	
	//TODO: cambiar de nombre
	private String codigoJDE;

	/**
	 * @return the tipoEntidad
	 */
	public TipoPersonaEntidad getTipoEntidad() {
		return tipoEntidad;
	}

	/**
	 * @param tipoEntidad the tipoEntidad to set
	 */
	public void setTipoEntidad(TipoPersonaEntidad tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}
	
	/**
	 * @return the contactoPersonal
	 */
	public DatoContactoPersonaLocalizacionDTO getContactoPersonal() {
		return contactoPersonal;
	}

	/**
	 * @param contactoPersonal the contactoPersonal to set
	 */
	public void setContactoPersonal(
			DatoContactoPersonaLocalizacionDTO contactoPersonal) {
		this.contactoPersonal = contactoPersonal;
	}

	/**
	 * @return the numeroRUCCorporativo
	 */
	public String getNumeroRUCCorporativo() {
		return numeroRUCCorporativo;
	}

	/**
	 * @param numeroRUCCorporativo the numeroRUCCorporativo to set
	 */
	public void setNumeroRUCCorporativo(String numeroRUCCorporativo) {
		this.numeroRUCCorporativo = numeroRUCCorporativo;
	}

	/**
	 * @return the idUsuarioActual
	 */
	public String getIdUsuarioActual() {
		return idUsuarioActual;
	}

	/**
	 * @param idUsuarioActual the idUsuarioActual to set
	 */
	public void setIdUsuarioActual(String idUsuarioActual) {
		this.idUsuarioActual = idUsuarioActual;
	}

	/**
	 * @return the codigoSistemaActual
	 */
	public String getCodigoSistemaActual() {
		return codigoSistemaActual;
	}

	/**
	 * @param codigoSistemaActual the codigoSistemaActual to set
	 */
	public void setCodigoSistemaActual(String codigoSistemaActual) {
		this.codigoSistemaActual = codigoSistemaActual;
	}

	/**
	 * @return the codigoJDE
	 */
	public String getCodigoJDE() {
		return codigoJDE;
	}

	/**
	 * @param codigoJDE the codigoJDE to set
	 */
	public void setCodigoJDE(String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}

	/**
	 * @return the nombreEntidad
	 */
	public String getNombreEntidad() {
		return nombreEntidad;
	}

	/**
	 * @param nombreEntidad the nombreEntidad to set
	 */
	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}
	
	
	
	
}
