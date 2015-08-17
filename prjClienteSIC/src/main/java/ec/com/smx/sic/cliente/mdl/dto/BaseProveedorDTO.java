/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Auditable;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Etiqueta;
import ec.com.smx.frameworkv2.auditoria.common.util.AuditLogConstant;
import ec.com.smx.frameworkv2.multicompany.dto.SystemDto;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseProveedorDTO extends BaseEntidadDTO<ProveedorID> implements IProveedor {
	
	@ComparatorTypeField
	private String codigoJDEProveedor;
	private String valortipoDocumento;

	public String getCodigoJDEProveedor() {
		if (StringUtils.isEmpty(this.codigoJDEProveedor) && StringUtils.isNotEmpty(this.getId().getCodigoProveedor())) {
			return String.valueOf(Integer.valueOf(this.getId().getCodigoProveedor()));			
		} else {
			return this.codigoJDEProveedor;
		}
	}

	public void setCodigoJDEProveedor(String codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}
	
	public String getValortipoDocumento() {
		return TipoPersonaEntidad.transformarValorTipoDocumentoPorTipoPersonaEntidad(
				TipoPersonaEntidad.obtenerTipoPersonaEntidad(this),this.valortipoDocumento);
	}

	public void setValortipoDocumento(String valortipoDocumento) {
		this.valortipoDocumento = valortipoDocumento;
	}

	/**
	 * Indica el tipo de proveedor de acuerdo a la actividad a la que se dedica, los valores, con el código interno y el codigo externo son:

		[OTR] [4] Otro
		[COM] [3] Comerciante
		[DIS] [2] Distribuidor
		[FAB] [1] Fabricante

		El valor por defecto es OTR
	 */
	private String condicionProveedor;
	
	/**
	 * Codigo del catalogo para los valores de las condiciones del proveedor
	 */
	private Integer codigoCondicionProveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CONDICIONPROVEEDOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCONDICIONPROVEEDOR", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaCondicionProveedor;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOLOCALIZACIONPROVEEDOR", referencedColumnName = "CODIGOLOCALIZACION", insertable = false, updatable = false)
	})
	private LocalizacionDTO localizacion;

	
	private Long codigoLocalizacionProveedor;
	
	
	/**
	 * Indica el origen de los artículos de un proveedor, sus valores pueden ser:
		[N] Nacional
		[I] Importado
	 */
	private String origenProveedor;

	/**
	 * Codigo del catalogo para los valores de origen del proveedor
	 */
	private Integer codigoOrigenProveedor;


	/**
	 * Abreviatura del nombre del proveedor
	 *
	 */
	private String abreviaturaNombreProveedor; 


	/**
	 * Estado del proveedor.
	 * Los valores permitidos son:
	 * [0] Inactivo
	 * [1] Activo
	 */
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	private String estadoProveedor ;


	/**
	 *Indica el codigo desde el sistema en el que se crea el proveedor 
	 */
	private String codigoSistemaOrigenProveedor;


	/**
	 * Indica el usuario que creó el proveedor
	 *
	 */
	@RegisterUserIdField
	private String usuarioCreacion ;


	/**
	 * Indica la fecha en que fue creado el proveedor
	 *
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaCreacion ;


	/**
	 * El usuario que relizó la última actualización sobre el registro.
	 *
	 */
	@LastModifierUserIdField
	private String usuarioActualizacion ;



	/**
	 * Fecha de última actualización del registro.
	 *

	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaUltimaActualizacion ;


	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "USUARIOACTUALIZACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioActualizacionDTO;



	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "USUARIOCREACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioCreacionDTO;



	/**
	 * Retorna valor de propiedad <code>usuarioActualizacionDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioActualizacionDTO</code>
	 */
	public UserDto getUsuarioActualizacionDTO(){
		return this.usuarioActualizacionDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioActualizacionDTO</code>.
	 * @param usuarioActualizacionDTO1 
	 *		El valor a establecer para la propiedad <code>usuarioActualizacionDTO</code>.
	 */
	public void setUsuarioActualizacionDTO(UserDto usuarioActualizacionDTO1 ){
		this.usuarioActualizacionDTO=usuarioActualizacionDTO1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioCreacionDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioCreacionDTO</code>
	 */
	public UserDto getUsuarioCreacionDTO(){
		return this.usuarioCreacionDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacionDTO</code>.
	 * @param usuarioCreacionDTO1 
	 *		El valor a establecer para la propiedad <code>usuarioCreacionDTO</code>.
	 */
	public void setUsuarioCreacionDTO(UserDto usuarioCreacionDTO1 ){
		this.usuarioCreacionDTO=usuarioCreacionDTO1;
	}






	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "ORIGENPROVEEDOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORIGENPROVEEDOR", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaOrigenProveedor;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="vistaProveedor")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private List<ArticuloProveedorDTO> articulosProveedor;
	
	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOSISTEMAORIGENPROVEEDOR", referencedColumnName = "SYSID", insertable = false, updatable = false)
	private SystemDto sistemaOrigenProveedor;


	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorFinancieroDTO proveedorFinanciero;


	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorB2BDTO proveedorB2B;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorNegociacionDTO proveedorNegociacion;


	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorComercialDTO proveedorComercial;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="proveedor")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private List<CaracteristicaProveedorDTO> caracteristicasProveedor;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorImportadoDTO proveedorImportado;


	@OneToMany(mappedBy = "proveedor")
	private Set<ProveedorOficinaExteriorDTO> proveedorOficinaExteriorCol;

	@OneToMany(mappedBy = "proveedor")
	private Set<TipoProveedorDTO> tiposProveedor;

	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	private Collection<ProveedorClasificacionDTO> clasificacionesProveedor;
	
	@OneToMany(mappedBy = "proveedor")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<BitacoraPrecioDTO> bitacorasPrecio;
	/**
	 * @return the proveedorOficinaExteriorCol
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR)
	@Etiqueta(etiquetaRelacion="Oficinas en el Exterior")
	public Set<ProveedorOficinaExteriorDTO> getProveedorOficinaExteriorCol() {
		return proveedorOficinaExteriorCol;
	}
	
	/**
	 * @param proveedorOficinaExteriorCol the proveedorOficinaExteriorCol to set
	 */
	public void setProveedorOficinaExteriorCol(
			Set<ProveedorOficinaExteriorDTO> proveedorOficinaExteriorCol) {
		this.proveedorOficinaExteriorCol = proveedorOficinaExteriorCol;
	}


	/**
	 * @return the codigoOrigenProveedor
	 */
	public Integer getCodigoOrigenProveedor() {
		return codigoOrigenProveedor;
	}
	/**
	 * @param codigoOrigenProveedor the codigoOrigenProveedor to set
	 */
	public void setCodigoOrigenProveedor(Integer codigoOrigenProveedor) {
		this.codigoOrigenProveedor = codigoOrigenProveedor;
	}
	/**
	 * @return the origenProveedor
	 */
	public String getOrigenProveedor() {
		return origenProveedor;
	}
	/**
	 * @param origenProveedor the origenProveedor to set
	 */
	public void setOrigenProveedor(String origenProveedor) {
		this.origenProveedor = origenProveedor;
	}
	/**
	 * @return the estadoProveedor
	 */
	public String getEstadoProveedor() {
		return estadoProveedor;
	}
	/**
	 * @param estadoProveedor the estadoProveedor to set
	 */
	public void setEstadoProveedor(String estadoProveedor) {
		this.estadoProveedor = estadoProveedor;
	}
	
	
	

	/**
	 * @return the caracteristicaOrigenProveedor
	 */
	public CatalogoValorDTO getCaracteristicaOrigenProveedor() {
		return caracteristicaOrigenProveedor;
	}
	/**
	 * @param caracteristicaOrigenProveedor the caracteristicaOrigenProveedor to set
	 */
	public void setCaracteristicaOrigenProveedor(
			CatalogoValorDTO caracteristicaOrigenProveedor) {
		this.caracteristicaOrigenProveedor = caracteristicaOrigenProveedor;
	}
	
	
	/**
	 * @return the proveedorFinanciero
	 */
	public ProveedorFinancieroDTO getProveedorFinanciero() {
		return proveedorFinanciero;
	}
	/**
	 * @param proveedorFinanciero the proveedorFinanciero to set
	 */
	public void setProveedorFinanciero(ProveedorFinancieroDTO proveedorFinanciero) {
		this.proveedorFinanciero = proveedorFinanciero;
	}

	/**
	 * @return the proveedorB2B
	 */
	@Auditable(id=AuditLogConstant.MAX_PROVEEDOR)
	@Etiqueta(etiquetaRelacion="Proveedor B2B")
	public ProveedorB2BDTO getProveedorB2B() {
		return proveedorB2B;
	}
	/**
	 * @param proveedorB2B the proveedorB2B to set
	 */
	public void setProveedorB2B(ProveedorB2BDTO proveedorB2B) {
		this.proveedorB2B = proveedorB2B;
	}
	/**
	 * @return the proveedorNegociacion
	 */
	public ProveedorNegociacionDTO getProveedorNegociacion() {
		return proveedorNegociacion;
	}
	/**
	 * @param proveedorNegociacion the proveedorNegociacion to set
	 */
	public void setProveedorNegociacion(ProveedorNegociacionDTO proveedorNegociacion) {
		this.proveedorNegociacion = proveedorNegociacion;
	}
	/**
	 * @return the proveedorComercial
	 */
	@Auditable(id=AuditLogConstant.MAX_PROVEEDOR)
	public ProveedorComercialDTO getProveedorComercial() {
		return proveedorComercial;
	}
	/**
	 * @param proveedorComercial the proveedorComercial to set
	 */
	public void setProveedorComercial(ProveedorComercialDTO proveedorComercial) {
		this.proveedorComercial = proveedorComercial;
	}

	/**
	 * @return the abreviaturaNombreProveedor
	 */
	public String getAbreviaturaNombreProveedor() {
		return abreviaturaNombreProveedor;
	}

	/**
	 * @param abreviaturaNombreProveedor the abreviaturaNombreProveedor to set
	 */
	public void setAbreviaturaNombreProveedor(String abreviaturaNombreProveedor) {
		this.abreviaturaNombreProveedor = abreviaturaNombreProveedor;
	}

	/**
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	/**
	 * @return the fechaCreacion
	 */
	public java.sql.Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(java.sql.Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the usuarioActualizacion
	 */
	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}
	/**
	 * @param usuarioActualizacion the usuarioActualizacion to set
	 */
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}
	/**
	 * @return the fechaUltimaActualizacion
	 */
	public java.sql.Timestamp getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}
	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(
			java.sql.Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}
	/**
	 * @return the tiposProveedor
	 */
	public Set<TipoProveedorDTO> getTiposProveedor() {
		return tiposProveedor;
	}
	/**
	 * @param tiposProveedor the tiposProveedor to set
	 */
	public void setTiposProveedor(Set<TipoProveedorDTO> tiposProveedor) {
		this.tiposProveedor = tiposProveedor;
	}
	/**
	 * @return the codigoSistemaOrigenProveedor
	 */
	public String getCodigoSistemaOrigenProveedor() {
		return codigoSistemaOrigenProveedor;
	}
	/**
	 * @param codigoSistemaOrigenProveedor the codigoSistemaOrigenProveedor to set
	 */
	public void setCodigoSistemaOrigenProveedor(String codigoSistemaOrigenProveedor) {
		this.codigoSistemaOrigenProveedor = codigoSistemaOrigenProveedor;
	}
	/**
	 * @return the sistemaOrigenProveedor
	 */
	public SystemDto getSistemaOrigenProveedor() {
		return sistemaOrigenProveedor;
	}
	/**
	 * @param sistemaOrigenProveedor the sistemaOrigenProveedor to set
	 */
	public void setSistemaOrigenProveedor(SystemDto sistemaOrigenProveedor) {
		this.sistemaOrigenProveedor = sistemaOrigenProveedor;
	}
	/**
	 * @return the proveedorImportado
	 */
	public ProveedorImportadoDTO getProveedorImportado() {
		return proveedorImportado;
	}
	/**
	 * @param proveedorImportado the proveedorImportado to set
	 */
	public void setProveedorImportado(ProveedorImportadoDTO proveedorImportado) {
		this.proveedorImportado = proveedorImportado;
	}
	
	/**
	 * @return the clasificacionesProveedor
	 */
	public Collection<ProveedorClasificacionDTO> getClasificacionesProveedor() {
		return clasificacionesProveedor;
	}
	/**
	 * @param clasificacionesProveedor the clasificacionesProveedor to set
	 */
	public void setClasificacionesProveedor(
			Collection<ProveedorClasificacionDTO> clasificacionesProveedor) {
		this.clasificacionesProveedor = clasificacionesProveedor;
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#getIdUsuarioRegistro()
	 */
	@Override
	public String getIdUsuarioRegistro() {
		return this.usuarioCreacion;
	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#setIdUsuarioRegistro(java.lang.String)
	 */
	@Override
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.usuarioCreacion = idUsuarioRegistro;

	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#getFechaRegistro()
	 */
	@Override
	public Timestamp getFechaRegistro() {
		return this.fechaCreacion;
	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#setFechaRegistro(java.sql.Timestamp)
	 */
	@Override
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaCreacion = fechaRegistro;

	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#getIdUsuarioModificacion()
	 */
	@Override
	public String getIdUsuarioModificacion() {
		return this.usuarioActualizacion;
	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#setIdUsuarioModificacion(java.lang.String)
	 */
	@Override
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.usuarioActualizacion = idUsuarioModificacion;

	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#getFechaModificacion()
	 */
	@Override
	public Timestamp getFechaModificacion() {
		return this.fechaUltimaActualizacion;
	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#setFechaModificacion(java.sql.Timestamp)
	 */
	@Override
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaUltimaActualizacion = fechaModificacion;

	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#getUsuarioRegistro()
	 */
	@Override
	public UserDto getUsuarioRegistro() {
		return this.getUsuarioCreacionDTO();
	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#setUsuarioRegistro(ec.com.smx.frameworkv2.security.dto.UserDto)
	 */
	@Override
	public void setUsuarioRegistro(UserDto usuarioRegistro) {
		this.setUsuarioCreacionDTO(usuarioRegistro);

	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#getUsuarioModificacion()
	 */
	@Override
	public UserDto getUsuarioModificacion() {
		return this.getUsuarioActualizacionDTO();
	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.auditoria.IAuditoriaBase#setUsuarioModificacion(ec.com.smx.frameworkv2.security.dto.UserDto)
	 */
	@Override
	public void setUsuarioModificacion(UserDto usuarioModificacion) {
		this.setUsuarioActualizacionDTO(usuarioModificacion);

	}

	/**
	 * @return the codigoLocalizacionProveedor
	 */
	public Long getCodigoLocalizacionProveedor() {
		return codigoLocalizacionProveedor;
	}

	/**
	 * @param codigoLocalizacionProveedor the codigoLocalizacionProveedor to set
	 */
	public void setCodigoLocalizacionProveedor(Long codigoLocalizacionProveedor) {
		this.codigoLocalizacionProveedor = codigoLocalizacionProveedor;
	}

	/**
	 * @return the localizacion
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR)
	public LocalizacionDTO getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(LocalizacionDTO localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * @return the condicionProveedor
	 */
	public String getCondicionProveedor() {
		return condicionProveedor;
	}

	/**
	 * @param condicionProveedor the condicionProveedor to set
	 */
	public void setCondicionProveedor(String condicionProveedor) {
		this.condicionProveedor = condicionProveedor;
	}

	/**
	 * @return the codigoCondicionProveedor
	 */
	public Integer getCodigoCondicionProveedor() {
		return codigoCondicionProveedor;
	}

	/**
	 * @param codigoCondicionProveedor the codigoCondicionProveedor to set
	 */
	public void setCodigoCondicionProveedor(Integer codigoCondicionProveedor) {
		this.codigoCondicionProveedor = codigoCondicionProveedor;
	}
	
	

	/**
	 * @return the caracteristicaCondicionProveedor
	 */
	public CatalogoValorDTO getCaracteristicaCondicionProveedor() {
		return caracteristicaCondicionProveedor;
	}

	/**
	 * @param caracteristicaCondicionProveedor the caracteristicaCondicionProveedor to set
	 */
	public void setCaracteristicaCondicionProveedor(
			CatalogoValorDTO caracteristicaCondicionProveedor) {
		this.caracteristicaCondicionProveedor = caracteristicaCondicionProveedor;
	}

	/**
	 * @return the caracteristicasProveedor
	 */
	public List<CaracteristicaProveedorDTO> getCaracteristicasProveedor() {
		return caracteristicasProveedor;
	}

	/**
	 * @param caracteristicasProveedor the caracteristicasProveedor to set
	 */
	public void setCaracteristicasProveedor(List<CaracteristicaProveedorDTO> caracteristicasProveedor) {
		this.caracteristicasProveedor = caracteristicasProveedor;
	}

	/**
	 * @return the bitacorasPrecio
	 */
	public Collection<BitacoraPrecioDTO> getBitacorasPrecio() {
		return bitacorasPrecio;
	}

	/**
	 * @param bitacorasPrecio the bitacorasPrecio to set
	 */
	public void setBitacorasPrecio(Collection<BitacoraPrecioDTO> bitacorasPrecio) {
		this.bitacorasPrecio = bitacorasPrecio;
	}

	/**
	 * @return the articulosProveedor
	 */
	public List<ArticuloProveedorDTO> getArticulosProveedor() {
		return articulosProveedor;
	}

	/**
	 * @param articulosProveedor the articulosProveedor to set
	 */
	public void setArticulosProveedor(List<ArticuloProveedorDTO> articulosProveedor) {
		this.articulosProveedor = articulosProveedor;
	}

}
