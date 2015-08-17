package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.DocumentoCorpDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenSalidaRecipienteID;

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTORDSAL")
public class OrdenSalidaRecipienteDTO implements Serializable {
	
	/**
	 * Clave primaria
	 */
	@EmbeddedId
	private OrdenSalidaRecipienteID id = new OrdenSalidaRecipienteID();
	
	/**
	 * Codigo del proceso logistico
	 * 
	 */
	@Column(name = "CODIGOPROCESOLOGISTICO")
	private Long codigoProcesoLogistico;
	
	/**
	 * Codigo area de trabajo
	 */
	@Column(name="CODIGOAREATRABAJO")
	private Integer codigoAreaTrabajo;
	
	/**
	 * Numero de documento
	 */
	@Column(name = "NUMEROORDENSALIDA")
	private String numeroDocumento;
	/**
	 * Codigo del proveedor
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	/**
	 * Codigo de documento
	 */
	@Column(name = "CODIGODOCUMENTO")
	private Integer codDocumento;
	/**
	 * Tipo Origen
	 */
	@Column(name = "VALORTIPOORDEN")
	private String valorTipoOrigen;
	
	@Column(name = "CODIGOTIPOORDEN")
	private Integer codigoTipoOrigen;
	/**
	 * Estado
	 */
	@Column(name = "ESTADO")
	private String estado;
	/**
	 * Datos de auditoria
	 */
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;
		
	/**
	 * Referencia CatalogoValorDTO ESTADOS
	 */
	@ManyToOne(fetch = LAZY)
    @JoinColumns({
    	@JoinColumn(name = "VALORTIPOORDEN", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOTIPOORDEN", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO tipoOrigenDTO;
	
	/**
	 * Collection OrdenSalidaDetalleDTO
	 */
	@OneToMany(mappedBy="ordenSalidaRecipienteDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<OrdenSalidaRecipienteDetalleDTO> ordenSalidaRecipienteDetalleCol;
	
	
	/**
	 * Referencia con la tabla ProcesoLogistico
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOPROCESOLOGISTICO", referencedColumnName = "CODIGOPROCESOLOGISTICO", insertable = false, updatable = false) })
	private ProcesoLogisticoDTO procesoLogisticoDTO;
	/**
	 * Referencia con la tabla Area Trabajo
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)})
	private AreaTrabajoDTO areaTrabajoDTO;
	
	/**
	 * Referencia con la tabla de DocumentoCorpDTO
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGODOCUMENTO", referencedColumnName = "CODIGODOCUMENTO", insertable = false, updatable = false)})
	private DocumentoCorpDTO documentoCorpDTO;
	
	/**
	 * Referencia con la tabla Proveedor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false) })
	private ProveedorDTO proveedorDTO;
	
	
	
	public OrdenSalidaRecipienteID getId() {
		return id;
	}

	public void setId(OrdenSalidaRecipienteID id) {
		this.id = id;
	}

	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getValorTipoOrigen() {
		return valorTipoOrigen;
	}

	public void setValorTipoOrigen(String valorTipoOrigen) {
		this.valorTipoOrigen = valorTipoOrigen;
	}

	public Integer getCodigoTipoOrigen() {
		return codigoTipoOrigen;
	}

	public void setCodigoTipoOrigen(Integer codigoTipoOrigen) {
		this.codigoTipoOrigen = codigoTipoOrigen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}

	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}

	public CatalogoValorDTO getTipoOrigenDTO() {
		return tipoOrigenDTO;
	}

	public void setTipoOrigenDTO(CatalogoValorDTO tipoOrigenDTO) {
		this.tipoOrigenDTO = tipoOrigenDTO;
	}

	public Collection<OrdenSalidaRecipienteDetalleDTO> getOrdenSalidaRecipienteDetalleCol() {
		return ordenSalidaRecipienteDetalleCol;
	}

	public void setOrdenSalidaRecipienteDetalleCol(Collection<OrdenSalidaRecipienteDetalleDTO> ordenSalidaRecipienteDetalleCol) {
		this.ordenSalidaRecipienteDetalleCol = ordenSalidaRecipienteDetalleCol;
	}

	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	public ProcesoLogisticoDTO getProcesoLogisticoDTO() {
		return procesoLogisticoDTO;
	}

	public void setProcesoLogisticoDTO(ProcesoLogisticoDTO procesoLogisticoDTO) {
		this.procesoLogisticoDTO = procesoLogisticoDTO;
	}

	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Integer getCodDocumento() {
		return codDocumento;
	}

	public void setCodDocumento(Integer codDocumento) {
		this.codDocumento = codDocumento;
	}

	public DocumentoCorpDTO getDocumentoCorpDTO() {
		return documentoCorpDTO;
	}

	public void setDocumentoCorpDTO(DocumentoCorpDTO documentoCorpDTO) {
		this.documentoCorpDTO = documentoCorpDTO;
	}

	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}
}
