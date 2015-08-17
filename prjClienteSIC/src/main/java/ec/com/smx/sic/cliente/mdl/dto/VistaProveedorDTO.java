/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.corporativo.admparamgeneral.dto.PersonaDTO;
import ec.com.smx.corporativo.gestionservicios.dto.LocalizacionDTO;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ProveedorTransient;

/**
 * @author Mario Braganza
 * 
 * @author Luis Yachirema
 *
 */
@Entity
@Deprecated
@SuppressWarnings("serial")
@Table(name="SCSPETPROVEEDOR")
public class VistaProveedorDTO extends ProveedorTransient {

	private String nombreProveedor;
	private String numeroDocumentoProveedor;
	private Integer codigoTipoEntidadProveedor;
	private String valorTipoEntidadProveedor;
	private Long codigoEntidadProveedor;
	private String razonSocialProveedor;	
	private Long codigoEmpresaProveedor;
	
	
	@Transient
	private Boolean tieneUsuarioFuncionarioB2B;
	@Transient
	private DatoContactoPersonaLocalizacionDTO contactoPrincipal;
	
	@OneToMany(mappedBy = "vistaProveedor", fetch = FetchType.LAZY)
	private List<ProveedorOficinaExteriorDTO> oficinasExteriorPredeterminadas;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOLOCALIZACIONPROVEEDOR", referencedColumnName = "CODIGOLOCALIZACION", insertable = false, updatable = false)
		})
	@Deprecated
	private LocalizacionDTO localizacionDTO;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOPERSONA", referencedColumnName = "CODIGOPERSONA", insertable = false, updatable = false)
	@Deprecated
	private PersonaDTO personaDTO;
	
	/**
	 * @return Devuelve codigoCompania.
	 */
	public Integer getCodigoCompania()
	{
		if (this.getId() != null){
			return this.getId().getCodigoCompania();
		}
		return null;
	}
	
	
	/**
	 * @param codigoCompania El codigoCompania a establecer.
	 */
	public void setCodigoCompania(Integer codigoCompania){
		if (this.getId() != null){
			this.getId().setCodigoCompania(codigoCompania);
		}
	}
	
	
	/**
	 * @return Devuelve codigoProveedor.
	 */
	public String getCodigoProveedor(){
		if (this.getId() != null){
			return this.getId().getCodigoProveedor();
		}
		return null;
	}
	/**
	 * @param codigoProveedor El codigoProveedor a establecer.
	 */
	public void setCodigoProveedor(String codigoProveedor){
		if (this.getId() != null){
			this.getId().setCodigoProveedor(codigoProveedor);
		}
	}
	
	
	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor != null ? nombreProveedor.toUpperCase() : nombreProveedor;
	}

	/**
	 * @return the numeroDocumentoProveedor
	 */
	public String getNumeroDocumentoProveedor() {
		return numeroDocumentoProveedor;
	}

	/**
	 * @param numeroDocumentoProveedor the numeroDocumentoProveedor to set
	 */
	public void setNumeroDocumentoProveedor(String numeroDocumentoProveedor) {
		this.numeroDocumentoProveedor = numeroDocumentoProveedor;
	}

	

	/**
	 * @return the codigoTipoEntidadProveedor
	 */
	public Integer getCodigoTipoEntidadProveedor() {
		return codigoTipoEntidadProveedor;
	}

	/**
	 * @param codigoTipoEntidadProveedor the codigoTipoEntidadProveedor to set
	 */
	public void setCodigoTipoEntidadProveedor(Integer codigoTipoEntidadProveedor) {
		this.codigoTipoEntidadProveedor = codigoTipoEntidadProveedor;
	}

	/**
	 * @return the valorTipoEntidadProveedor
	 */
	public String getValorTipoEntidadProveedor() {
		return valorTipoEntidadProveedor;
	}

	/**
	 * @param valorTipoEntidadProveedor the valorTipoEntidadProveedor to set
	 */
	public void setValorTipoEntidadProveedor(String valorTipoEntidadProveedor) {
		this.valorTipoEntidadProveedor = valorTipoEntidadProveedor;
	}

	/*
	 * Metodo para compatibilidad de proyectos anteriores que usan la version
	 * anterior de Corporativo y Framework, en proyectos nuevos (que usan
	 * la version 2 de Corporativo y Framework, por ejemplo MAX) usar el metodo
	 * getPersona()
	 * 
	 */
	@Deprecated
	@Override
	public PersonaDTO getPersonaDTO() {
		return this.personaDTO;
	}

	/*
	 * Metodo para compatibilidad de proyectos anteriores que usan la version
	 * anterior de Corporativo y Framework, en proyectos nuevos (que usan
	 * la version 2 de Corporativo y Framework, por ejemplo MAX) usar el metodo
	 * setPersona(ec.com.smx.corpv2.dto.PersonaDTO persona)
	 * 
	 */
	@Deprecated
	@Override
	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
		
	}

	/*
	 * Metodo para compatibilidad de proyectos anteriores que usan la version
	 * anterior de Corporativo y Framework, en proyectos nuevos (que usan
	 * la version 2 de Corporativo y Framework, por ejemplo MAX) usar el metodo
	 * getLocalizacion()
	 * 
	 */
	@Deprecated
	@Override
	public LocalizacionDTO getLocalizacionDTO() {
		return this.localizacionDTO;
	}

	/*
	 * Metodo para compatibilidad de proyectos anteriores que usan la version
	 * anterior de Corporativo y Framework, en proyectos nuevos (que usan
	 * la version 2 de Corporativo y Framework, por ejemplo MAX) usar el metodo
	 * setLocalizacion(ec.com.smx.corpv2.dto.LocalizacionDTO localizacion)
	 * 
	 */
	@Deprecated
	@Override
	public void setLocalizacionDTO(LocalizacionDTO localizacionDTO) {
		this.localizacionDTO = localizacionDTO;
	}
	
	
	/**
	 * @deprecated hasta cambiar el nombre de la columna codigoLocalizacionProveedor
	 * de la tabla proveedor
	 */
	@Override
	@Deprecated
	public void setCodigoLocalizacion(Long codigoLocalizacion) {
		this.setCodigoLocalizacionProveedor(codigoLocalizacion);
		
	}

	/**
	 * @deprecated hasta cambiar el nombre de la columna codigoLocalizacionProveedor
	 * de la tabla proveedor
	 */
	@Override
	@Deprecated
	public Long getCodigoLocalizacion() {
		return this.getCodigoLocalizacionProveedor();
	}


	/**
	 * @return the razonSocialProveedor
	 */
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}


	/**
	 * @param razonSocialProveedor the razonSocialProveedor to set
	 */
	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}


	/**
	 * @return the codigoEmpresaProveedor
	 */
	public Long getCodigoEmpresaProveedor() {
		return codigoEmpresaProveedor;
	}


	/**
	 * @param codigoEmpresaProveedor the codigoEmpresaProveedor to set
	 */
	public void setCodigoEmpresaProveedor(Long codigoEmpresaProveedor) {
		this.codigoEmpresaProveedor = codigoEmpresaProveedor;
	}


	/**
	 * @return the codigoEntidadProveedor
	 */
	public Long getCodigoEntidadProveedor() {
		return codigoEntidadProveedor;
	}


	/**
	 * @param codigoEntidadProveedor the codigoEntidadProveedor to set
	 */
	public void setCodigoEntidadProveedor(Long codigoEntidadProveedor) {
		this.codigoEntidadProveedor = codigoEntidadProveedor;
	}


	/**
	 * @return the oficinasExteriorPredeterminadas
	 * @throws Exception 
	 */
	public List<ProveedorOficinaExteriorDTO> getOficinasExteriorPredeterminadas() throws Exception {
		return oficinasExteriorPredeterminadas;
	}


	/**
	 * @param oficinasExteriorPredeterminadas the oficinasExteriorPredeterminadas to set
	 */
	public void setOficinasExteriorPredeterminadas(
			List<ProveedorOficinaExteriorDTO> oficinasExteriorPredeterminadas) {
		this.oficinasExteriorPredeterminadas = oficinasExteriorPredeterminadas;
	}

	@Override
	public DatoContactoPersonaLocalizacionDTO getContactoPrincipal() {
		return this.contactoPrincipal;
	}

	@Override
	public void setContactoPrincipal(
			DatoContactoPersonaLocalizacionDTO contactoPrincipal) {
		this.contactoPrincipal = contactoPrincipal; 
	}

	/**
	 * @return the tieneUsuarioFuncionarioB2B
	 */
	public Boolean getTieneUsuarioFuncionarioB2B() {
		return tieneUsuarioFuncionarioB2B;
	}

	/**
	 * @param tieneUsuarioFuncionarioB2B the tieneUsuarioFuncionarioB2B to set
	 */
	public void setTieneUsuarioFuncionarioB2B(Boolean tieneUsuarioFuncionarioB2B) {
		this.tieneUsuarioFuncionarioB2B = tieneUsuarioFuncionarioB2B;
	}

	public Integer getCodigoJDEProveedorInt() {
		if (StringUtils.isNotEmpty(super.getCodigoJDEProveedor()))
			return Integer.parseInt(super.getCodigoJDEProveedor());
		else
			return null;		
	}

}
