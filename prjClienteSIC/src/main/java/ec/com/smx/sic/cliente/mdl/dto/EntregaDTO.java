package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.EntregaID;

/**
 * Almacena informacion referente a la entrega
 * 
 * @author guvidia
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITENTREGA")
public class EntregaDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla Entrega
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.EntregaID id = new ec.com.smx.sic.cliente.mdl.dto.id.EntregaID();

	/**
	 * representa el codigo de bodega
	 * 
	 */
	@Transient
	@Column
	private String codigoBodega;

	/**
	 * codigo asignado a un area de trabajo.
	 * 
	 */
	@Column
	private Integer codigoAreaTrabajoEntrega;

	/**
	 * Representa el codigo del Proveedor.
	 * 
	 */
	@ComparatorTypeField
	@Column(nullable = false)
	private String codigoProveedor;
	
	/**
	 * Representa la descripcion de la entrega.
	 * 
	 */
	@Column
	private String observacionEntrega;
	
	/**
	 * Representa las horas de la entrega
	 */
	@Transient
	private  Collection<Time>  horasEntrega;
	
	/**
	 * Representa el numero de andenes para la entrega.
	 * 
	 */
	@Transient
	@Deprecated
	@Column (name = "ANDENES", nullable = false)
	private Integer andenes;
	
	/**
	 * Representa si ya se validaron los andenes.
	 */
	@Transient
	@Column (name = "VALIDACIONANDENES")
	private Integer validacionAndenes;
	
	/**
	 * codigo catalogo valor entrega
	 */

	@Column//(nullable = false)
	private String valorTipoEntrega;

	/**
	 * codigo del tipo catalogo entrega
	 */
	@Column//(nullable = false)
	private Integer codigoTipoEntrega;
	
	/**
	 * Representa el estado.
	 * 
	 */
	@Column
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Columna para controlar el proceso de integracion con el SIC, valores:
	 * <p>1: Entrega procesada correctamente en el SIC</p>
	 * <p>0: Entrega no procesada en el SIC</p>
	 */
	@Column(name = "INTEGRADO")
	private String integrado;

	/**
	 * Fecha en la que se va a realiza la entrega del proveedor. La fecha debe tener el formato yyyy-MM-dd
	 * 
	 */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEntrega;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(nullable = false)
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="IDUSUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;

	/**
	 * Columna para determinar el proceso de recepcion en el SIC, valores:
	 * <p>0: Entrega con proceso ANTIGUO de recepcion</p>
	 * <p>1: Entrega con proceso FACTURA DIGITAL de recepcion</p>
	 */
	@Column(name = "PROCESORECEPCIONSIC")
	private String procesoRecepcionSic;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioActualizacion;

	/**
	 * Referencia con la tabla AreaTrabajo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOAREATRABAJOENTREGA", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoEntrega;
	
	/**
	 * Referencia con la tabla catalogo valor Estado de la entrega
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOTIPOENTREGA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "VALORTIPOENTREGA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO tipoEntrega;
	
	/**
	 * Referencia con la tabla Proveedor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false) })
	private ProveedorDTO proveedorDTO;
	
	/**
	 * Referencia con la vista Proveedor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor;
	
	/**
	 * Referencia a los estados de la entrega
	 */
	@OneToMany(mappedBy = "entregaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<EntregaEstadoDTO> entregaEstadoDTOCol;
	
	/**
	 * Referencia a los estados de la factura
	 */
	@OneToMany(mappedBy = "entregaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<EntregaRecepcionProveedorDTO> entregaRecepcionProveedorDTOCol;

	/**
	 * Collecion de EntregaOrdenCompraEstadoDTO
	 * 
	 */
	@OneToMany(mappedBy = "entrega")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<EntregaOrdenCompraEstadoDTO> entregaOrdenCompraEstadoCol;
	
	/**
	 * Collecion de EntregaDetalleCalendarioProveedorDTO
	 * 
	 */
	@OneToMany(mappedBy = "entregaDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<EntregaDetalleCalendarioProveedorDTO> entregaDetalleCalendarioProveedorDTOCol;
	
	/**
	 * Obtiene la relacion con los detalles de la tarea
	 */
	@OneToMany(mappedBy = "entregaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<FacturaDTO> facturaDTOCol;
	
	@Transient
	public EntregaEstadoDTO entregaEstadoDTOActivo;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public EntregaID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(EntregaID id1) {
		this.id = id1;
	}

	/**
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}

	/**
	 * @param codigoBodega
	 *            the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor
	 *            the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the codigoAreaTrabajoEntrega
	 */
	public Integer getCodigoAreaTrabajoEntrega() {
		return codigoAreaTrabajoEntrega;
	}

	/**
	 * @param codigoAreaTrabajoEntrega
	 *            the codigoAreaTrabajoEntrega to set
	 */
	public void setCodigoAreaTrabajoEntrega(Integer codigoAreaTrabajoEntrega) {
		this.codigoAreaTrabajoEntrega = codigoAreaTrabajoEntrega;
	}

	/**
	 * @return the proveedorDTO
	 */
	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	/**
	 * @param proveedorDTO the proveedorDTO to set
	 */
	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>
	 * .
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}
	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioActualizacion() {
		return this.idUsuarioActualizacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioActualizacion(String idUsuarioActualizacion1) {
		this.idUsuarioActualizacion = idUsuarioActualizacion1;

		if (idUsuarioActualizacion != null
				&& idUsuarioActualizacion.length() > 32) {
			idUsuarioActualizacion = idUsuarioActualizacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * 
	 * @param usuarioCreacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion(
			ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion1) {
		this.usuarioCreacion = usuarioCreacion1;
	}

	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>usuarioModificacion</code>.
	 * 
	 * @param usuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioModificacion</code>.
	 */
	public void setUsuarioActualizacion(
			ec.com.smx.framework.security.dto.UserDto usuarioActualizacion1) {
		this.usuarioActualizacion = usuarioActualizacion1;
	}

	/**
	 * @return the entregaOrdenCompraEstadoCol
	 */
	public Collection<EntregaOrdenCompraEstadoDTO> getEntregaOrdenCompraEstadoCol() {
		return entregaOrdenCompraEstadoCol;
	}

	/**
	 * @param entregaOrdenCompraEstadoCol
	 *            the entregaOrdenCompraEstadoCol to set
	 */
	public void setEntregaOrdenCompraEstadoCol(
			Collection<EntregaOrdenCompraEstadoDTO> entregaOrdenCompraEstadoCol) {
		this.entregaOrdenCompraEstadoCol = entregaOrdenCompraEstadoCol;
	}

	/**
	 * @return the facturaDTOCol
	 */
	public Collection<FacturaDTO> getFacturaDTOCol() {
		return facturaDTOCol;
	}

	/**
	 * @param facturaDTOCol the facturaDTOCol to set
	 */
	public void setFacturaDTOCol(Collection<FacturaDTO> facturaDTOCol) {
		this.facturaDTOCol = facturaDTOCol;
	}

	/**
	 * @return the vistaProveedor
	 */
	public ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO getVistaProveedor() {
		return vistaProveedor;
	}

	/**
	 * @param vistaProveedor the vistaProveedor to set
	 */
	public void setVistaProveedor(ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor) {
		this.vistaProveedor = vistaProveedor;
	}

	/**
	 * @return the entregaEstadoDTOCol
	 */
	public Collection<EntregaEstadoDTO> getEntregaEstadoDTOCol() {
		return entregaEstadoDTOCol;
	}

	/**
	 * @param entregaEstadoDTOCol the entregaEstadoDTOCol to set
	 */
	public void setEntregaEstadoDTOCol(Collection<EntregaEstadoDTO> entregaEstadoDTOCol) {
		this.entregaEstadoDTOCol = entregaEstadoDTOCol;
	}

	/**
	 * @return the entregaEstadoDTOActivo
	 */
	public EntregaEstadoDTO getEntregaEstadoDTOActivo() {
		if(this.getTieneEntregaEstadoDTOCol()){
			for(EntregaEstadoDTO ee : this.entregaEstadoDTOCol){
				if(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(ee.getEstado()) && ee.getFechaFin() == null){
					this.entregaEstadoDTOActivo = ee;
					break;
				}
			}
		}
		return entregaEstadoDTOActivo;
	}


	/**
	 * @return the fechaEntrega
	 */
	public java.util.Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(java.util.Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public java.util.Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * @return the areaTrabajoEntrega
	 */
	public AreaTrabajoDTO getAreaTrabajoEntrega() {
		return areaTrabajoEntrega;
	}

	/**
	 * @param areaTrabajoEntrega the areaTrabajoEntrega to set
	 */
	public void setAreaTrabajoEntrega(AreaTrabajoDTO areaTrabajoEntrega) {
		this.areaTrabajoEntrega = areaTrabajoEntrega;
	}

	/**
	 * @return the observacionEntrega
	 */
	public String getObservacionEntrega() {
		return observacionEntrega;
	}

	/**
	 * @param observacionEntrega the observacionEntrega to set
	 */
	public void setObservacionEntrega(String observacionEntrega) {
		this.observacionEntrega = observacionEntrega;
	}

	/**
	 * @return the andenes
	 */
	public Integer getAndenes() {
		return andenes;
	}

	/**
	 * @param andenes the andenes to set
	 */
	public void setAndenes(Integer andenes) {
		this.andenes = andenes;
	}

	/**
	 * @return the entregaRecepcionProveedorDTOCol
	 */
	public Collection<EntregaRecepcionProveedorDTO> getEntregaRecepcionProveedorDTOCol() {
		return entregaRecepcionProveedorDTOCol;
	}

	/**
	 * @param entregaRecepcionProveedorDTOCol the entregaRecepcionProveedorDTOCol to set
	 */
	public void setEntregaRecepcionProveedorDTOCol(Collection<EntregaRecepcionProveedorDTO> entregaRecepcionProveedorDTOCol) {
		this.entregaRecepcionProveedorDTOCol = entregaRecepcionProveedorDTOCol;
	}
	
	/**
	 * @return the tieneEntregaEstadoDTOCol
	 */
	public Boolean getTieneEntregaEstadoDTOCol() {
		return isLoaded(this.entregaEstadoDTOCol) && !this.entregaEstadoDTOCol.isEmpty();
	}
	
	/**
	 * @return the tieneEntregaEstadoDTOCol
	 */
	public Boolean getTieneFacturaDTOCol() {
		return isLoaded(this.facturaDTOCol ) && !this.facturaDTOCol.isEmpty();
	}
	
	/**
	 * Valida si tiene la coleccion entregaOrdenCompraEstadoCol
	 * @return
	 */
	public Boolean getTieneEntregaOrdenCompraEstadoCol() {
		return isLoaded(this.entregaOrdenCompraEstadoCol) && !this.entregaOrdenCompraEstadoCol.isEmpty();
	}
	
	/**
	 * Valida si tiene la coleccion entregaOrdenCompraEstadoCol
	 * @return
	 */
	public Boolean getTieneEntregaDetalleCalendarioProveedorDTOCol() {
		return isLoaded(this.entregaDetalleCalendarioProveedorDTOCol) && !this.entregaDetalleCalendarioProveedorDTOCol.isEmpty();
	}

	/**
	 * @return the validacionAndenes
	 */
	public Integer getValidacionAndenes() {
		return validacionAndenes;
	}

	/**
	 * @param validacionAndenes the validacionAndenes to set
	 */
	public void setValidacionAndenes(Integer validacionAndenes) {
		this.validacionAndenes = validacionAndenes;
	}

	/**
	 * @return the tipoEntrega
	 */
	public CatalogoValorDTO getTipoEntrega() {
		return tipoEntrega;
	}

	/**
	 * @param tipoEntrega the tipoEntrega to set
	 */
	public void setTipoEntrega(CatalogoValorDTO tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	/**
	 * Valida si tiene la coleccion entregaRecepcionProveedorDTOCol
	 * @return
	 */
	public Boolean getTieneEntregaRecepcionProveedorDTOCol() {
		return isLoaded(this.entregaRecepcionProveedorDTOCol) && !this.entregaRecepcionProveedorDTOCol.isEmpty();
	}

	/**
	 * @return the valorTipoEntrega
	 */
	public String getValorTipoEntrega() {
		return valorTipoEntrega;
	}

	/**
	 * @param valorTipoEntrega the valorTipoEntrega to set
	 */
	public void setValorTipoEntrega(String valorTipoEntrega) {
		this.valorTipoEntrega = valorTipoEntrega;
	}

	/**
	 * @return the codigoTipoEntrega
	 */
	public Integer getCodigoTipoEntrega() {
		return codigoTipoEntrega;
	}

	/**
	 * @return the entregaDetalleCalendarioProveedorDTOCol
	 */
	public Collection<EntregaDetalleCalendarioProveedorDTO> getEntregaDetalleCalendarioProveedorDTOCol() {
		return entregaDetalleCalendarioProveedorDTOCol;
	}

	/**
	 * @param entregaDetalleCalendarioProveedorDTOCol the entregaDetalleCalendarioProveedorDTOCol to set
	 */
	public void setEntregaDetalleCalendarioProveedorDTOCol(Collection<EntregaDetalleCalendarioProveedorDTO> entregaDetalleCalendarioProveedorDTOCol) {
		this.entregaDetalleCalendarioProveedorDTOCol = entregaDetalleCalendarioProveedorDTOCol;
	}

	/**
	 * @param codigoTipoEntrega the codigoTipoEntrega to set
	 */
	public void setCodigoTipoEntrega(Integer codigoTipoEntrega) {
		this.codigoTipoEntrega = codigoTipoEntrega;
	}

	/**
	 * @return the horasEntrega
	 */
	public Collection<Time> getHorasEntrega() {
		return horasEntrega;
	}

	/**
	 * @param horasEntrega the horasEntrega to set
	 */
	public void setHorasEntrega(Collection<Time> horasEntrega) {
		this.horasEntrega = horasEntrega;
	}

	/**
	 * Columna para controlar el proceso de integracion con el SIC, valores:
	 * <p>1: Entrega procesada correctamente en el SIC</p>
	 * <p>0: Entrega no procesada en el SIC</p>
	 */
	public String getIntegrado() {
		return integrado;
	}

	/**
	 * @param integrado
	 */
	public void setIntegrado(String integrado) {
		this.integrado = integrado;
	}

	/**
	 * @return the procesoRecepcionSic
	 */
	public String getProcesoRecepcionSic() {
		return procesoRecepcionSic;
	}

	/**
	 * @param procesoRecepcionSic the procesoRecepcionSic to set
	 */
	public void setProcesoRecepcionSic(String procesoRecepcionSic) {
		this.procesoRecepcionSic = procesoRecepcionSic;
	}
}