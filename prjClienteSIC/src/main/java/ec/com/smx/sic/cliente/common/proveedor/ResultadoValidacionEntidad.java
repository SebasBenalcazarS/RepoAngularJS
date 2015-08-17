/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import java.io.Serializable;

import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.framework.common.enumeration.TipoEmpresaEnum;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public abstract class ResultadoValidacionEntidad<ENTIDAD extends IBaseEntidad> implements Serializable {
	
	private TipoPersonaEntidad tipoPersonaEntidad;
	private TipoEmpresaEnum tipoEmpresa;
	private String numeroDocumento;
	private String numeroDocumentoFinanciero;
	private String valorTipoDocumento;
	private CodigoResultadoValidacionProveedor codigoResultadoValidacionProveedor;
	// TODO: Verificar si se puede eliminar estas variables, porque ya se consideran en la variable tipo IEntidad 
	private PersonaDTO persona;
	private Duplex<EmpresaDTO, LocalizacionDTO> empresaLocalizacion;
	private String nombreEntidad;
	private ENTIDAD entidad;
	


	/**
	 * @return the tipoPersonaProveedor
	 */
	public TipoPersonaEntidad getTipoPersonaEntidad() {
		return tipoPersonaEntidad;
	}

	/**
	 * @param tipoPersonaProveedor the tipoPersonaProveedor to set
	 */
	public void setTipoPersonaEntidad(TipoPersonaEntidad tipoPersonaEntidad) {
		this.tipoPersonaEntidad = tipoPersonaEntidad;
	}

	/**
	 * @return the tipoEmpresa
	 */
	public TipoEmpresaEnum getTipoEmpresa() {
		return tipoEmpresa;
	}

	/**
	 * @param tipoEmpresa the tipoEmpresa to set
	 */
	public void setTipoEmpresa(TipoEmpresaEnum tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
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
	 * @return the numeroDocumentoFinanciero
	 */
	public String getNumeroDocumentoFinanciero() {
		return numeroDocumentoFinanciero;
	}

	/**
	 * @param numeroDocumentoFinanciero the numeroDocumentoFinanciero to set
	 */
	public void setNumeroDocumentoFinanciero(String numeroDocumentoFinanciero) {
		this.numeroDocumentoFinanciero = numeroDocumentoFinanciero;
	}

	/**
	 * @return the valorTipoDocumento
	 */
	public String getValorTipoDocumento() {
		return valorTipoDocumento;
	}

	/**
	 * @param valorTipoDocumento the valorTipoDocumento to set
	 */
	public void setValorTipoDocumento(String valorTipoDocumento) {
		this.valorTipoDocumento = valorTipoDocumento;
	}

	/**
	 * @return the proveedor
	 */
	public ENTIDAD getEntidad() {
		return entidad;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setEntidad(ENTIDAD entidad) {
		this.entidad = entidad;
	}

	/**
	 * @return the codigoResultadoValidacionProveedor
	 */
	public CodigoResultadoValidacionProveedor getCodigoResultadoValidacionProveedor() {
		return codigoResultadoValidacionProveedor;
	}

	/**
	 * @param codigoResultadoValidacionProveedor the codigoResultadoValidacionProveedor to set
	 */
	public void setCodigoResultadoValidacionProveedor(
			CodigoResultadoValidacionProveedor codigoResultadoValidacionProveedor) {
		this.codigoResultadoValidacionProveedor = codigoResultadoValidacionProveedor;
	}

	/**
	 * @return the persona
	 */
	public PersonaDTO getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	/**
	 * @return the empresaLocalizacion
	 */
	public Duplex<EmpresaDTO, LocalizacionDTO> getEmpresaLocalizacion() {
		return empresaLocalizacion;
	}

	/**
	 * @param empresaLocalizacion the empresaLocalizacion to set
	 */
	public void setEmpresaLocalizacion(
			Duplex<EmpresaDTO, LocalizacionDTO> empresaLocalizacion) {
		this.empresaLocalizacion = empresaLocalizacion;
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
