/*
 * Creado el 11/09/2006
 *
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.corporativo.admparamgeneral.dto.PersonaDTO;
import ec.com.smx.corporativo.gestionservicios.dto.LocalizacionDTO;
import ec.com.smx.corpv2.dto.CompaniaDTO;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Auditable;
import ec.com.smx.frameworkv2.auditoria.common.util.AuditLogConstant;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.ProveedorTransient;

/**
 * Entidad que almacena los datos de los proveedores
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETPROVEEDOR")
public class ProveedorDTO extends ProveedorTransient {

	private String nombreProveedor;
	private String razonSocialProveedor;
	private Long codigoEmpresaProveedor;
	private Long codigoEntidadProveedor;
	private String valorTipoEntidadProveedor;
	private Integer codigoTipoEntidadProveedor;
	private String numeroDocumentoProveedor;
	
	
	@Transient
	private DatoContactoPersonaLocalizacionDTO contactoPrincipal;
	
	@Override
	public Long getCodigoEmpresaProveedor() {
		return this.codigoEmpresaProveedor;
	}

	@Override
	public void setCodigoEmpresaProveedor(Long codigoEmpresaProveedor) {
		this.codigoEmpresaProveedor = codigoEmpresaProveedor;
	}

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false)
	private CompaniaDTO compania;
	
	@OneToMany(mappedBy = "proveedor")
	@CollectionTypeInfo(name = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ProveedorMarcaDTO> proveedorMarcas;	
	
	
	/**
	 * Referencia a la tabla Recepcion Proveedor
	 */
	@OneToMany(mappedBy = "proveedorDTO")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<RecepcionProveedorDTO> recepcionProveedorDTOCol;
	
	/**
	 * Referencia a la tabla Oferta Proveedor
	 */
	@OneToMany(mappedBy = "proveedor")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<OfertaProveedorDTO> ofertaProveedor;
	
	@Transient
	private ProveedorOficinaExteriorDTO proveedorOficinaExterior;
	
	@Transient
	private Collection<ProveedorOficinaExteriorDTO> proveedorOficinaExteriorCol2;
 
	public CompaniaDTO getCompania(){
		return this.compania;
	}

	public void setCompania( CompaniaDTO compania1 ){
		this.compania=compania1;
	}

	public ProveedorOficinaExteriorDTO getProveedorOficinaExterior() {
		return proveedorOficinaExterior;
	}

	public void setProveedorOficinaExterior(
			ProveedorOficinaExteriorDTO proveedorOficinaExterior) {
		this.proveedorOficinaExterior = proveedorOficinaExterior;
	}

	public Collection<ProveedorOficinaExteriorDTO> getProveedorOficinaExteriorCol2() {
		return proveedorOficinaExteriorCol2;
	}

	public void setProveedorOficinaExteriorCol2(
			Collection<ProveedorOficinaExteriorDTO> proveedorOficinaExteriorCol2) {
		this.proveedorOficinaExteriorCol2 = proveedorOficinaExteriorCol2;
	}

	@Override
	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	@Override
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	@Override
	public String getNumeroDocumentoProveedor() {
		return this.numeroDocumentoProveedor;
	}

	@Override
	public void setNumeroDocumentoProveedor(String numeroDocumentoProveedor) {
		this.numeroDocumentoProveedor = numeroDocumentoProveedor;
	}
	
	/**
	 * @return the proveedorMarcas
	 */
	public Collection<ProveedorMarcaDTO> getProveedorMarcas() {
		return proveedorMarcas;
	}

	/**
	 * @param proveedorMarcas the proveedorMarcas to set
	 */
	public void setProveedorMarcas(Collection<ProveedorMarcaDTO> proveedorMarcas) {
		this.proveedorMarcas = proveedorMarcas;
	}

	@Override
	public void setCodigoTipoEntidadProveedor(Integer codigoTipoEntidadProveedor) {
		this.codigoTipoEntidadProveedor = codigoTipoEntidadProveedor;
		
	}

	@Override
	public Integer getCodigoTipoEntidadProveedor() {
		return this.codigoTipoEntidadProveedor;
	}

	@Override
	public void setValorTipoEntidadProveedor(String valorTipoEntidadProveedor) {
		this.valorTipoEntidadProveedor = valorTipoEntidadProveedor;
	}

	@Override
	public String getValorTipoEntidadProveedor() {
		return this.valorTipoEntidadProveedor;
	}

	@Override
	public PersonaDTO getPersonaDTO() {
		throw new SICException("Metodo no soportado");
	}

	@Override
	public void setPersonaDTO(PersonaDTO personaDTO) {
		throw new SICException("Metodo no soportado");
		
	}

	@Override
	public LocalizacionDTO getLocalizacionDTO() {
		throw new SICException("Metodo no soportado");
	}

	@Override
	public void setLocalizacionDTO(LocalizacionDTO localizacionDTO) {
		throw new SICException("Metodo no soportado");
	}
	
	@Override
	public void setCodigoEntidadProveedor(Long codigoEntidadProveedor) {
		this.codigoEntidadProveedor = codigoEntidadProveedor;
	}

	@Override
	public Long getCodigoEntidadProveedor() {
		return this.codigoEntidadProveedor;
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

	@Override
	public String getRazonSocialProveedor() {
		return this.razonSocialProveedor;
	}

	@Override
	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}
	
	@Auditable(id=AuditLogConstant.MAX_PROVEEDOR)
	@Override
	public DatoContactoPersonaLocalizacionDTO getContactoPrincipal() {
		return this.contactoPrincipal;
	}

	@Override
	public void setContactoPrincipal(
			DatoContactoPersonaLocalizacionDTO contactoPrincipal) {
		this.contactoPrincipal = contactoPrincipal; 
	}

	public Collection<RecepcionProveedorDTO> getRecepcionProveedorDTOCol() {
		return recepcionProveedorDTOCol;
	}

	public void setRecepcionProveedorDTOCol(Collection<RecepcionProveedorDTO> recepcionProveedorDTOCol) {
		this.recepcionProveedorDTOCol = recepcionProveedorDTOCol;
	}

	public Collection<OfertaProveedorDTO> getOfertaProveedor() {
		return ofertaProveedor;
	}

	public void setOfertaProveedor(Collection<OfertaProveedorDTO> ofertaProveedor) {
		this.ofertaProveedor = ofertaProveedor;
	}
}

