package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Tabla para guadar la fecha y hora de llegada para realizar la recepcion de la
 * mercaderia del proveeedor
 * 
 * @author acaiza
 * @author guvidia
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTRECPRO")
	
public class RecepcionProveedorDTO extends SimpleAuditDTO {
	/*********************************************************/
	/*CAMPOS PERSISTENTES*/
	/*********************************************************/

	/**
	 * Clave primaria de la tabla AsignacionProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorID();

	/**
	 * Representa el codigo del Proveedor.
	 * 
	 */
	@Column(nullable = false)
	@ComparatorTypeField
	private String codigoProveedor;

	/**
	 * Codigo del area de trabajo CENTRO DE DISTRIBUCION
	 * 
	 */
	@Column(name = "CODIGOAREATRABAJO")
	private Integer codigoAreaTrabajo;
	
	/**
	 * Codigo del area de trabajo de la SUBBODEGA
	 */	
	@Column(name = "CODIGOAREATRABAJOSUBBODEGA")
	private Integer codigoAreaTrabajoSubBodega;
	
	/**
	 * Codigo del area de trabajo de la BODEGA
	 */
	@Column(name = "CODIGOAREATRABAJOBODEGA")
	private Integer codigoAreaTrabajoBodega;
	
	/**
	 * Catalogo valor para el tipo de recepcion.
	 * 
	 */
	@Column(name="VALORTIPORECEPCION")
	@ComparatorTypeField
	private String valorTipoRecepcion;

	/**
	 * Catalogo valor para el tipo de recepcion.
	 * 
	 */
	@Column(name="CODIGOTIPORECEPCION")
	private Integer codigoTipoRecepcion;

	/**
	 * Codigo del proceso logistico
	 * 
	 */
	@Column(name = "CODIGOPROCESOLOGISTICO")
	private Long codigoProcesoLogistico;
	
	
	/**
	 * Tiempo estimado de recepcion en Milisegundos
	 */
	@Column(name = "TIEMPOESTIMADORECEPCION")
	private Long tiempoEstimadoRecepcion;
	
	/**
	 * Identifica una agrupacion de procesos logisticos para el registro de las novedades de oficina
	 */
	@Transient
	private Long codigoGrupoNovedadArticulo; 
	
	/**
	 * Fecha de la recepcion del proveedor
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHARECEPCION")
	private java.util.Date fechaRecepcion;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@Column
	@ComparatorTypeField
	private String estado;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@ComparatorTypeField
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaModificacion;
	
	@Column(name = "ESTADOIMPRESION")
	private Boolean estadoImpresion;

	/**
	 * Especifica si la recepcion permite escaneo manual
	 * 
	 */
	@Column(name = "ACTIVARESCANEOMANUAL")
	private Boolean activarEscaneoManual;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

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
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor;
	
	
	/**
	 * Referencia con la DatoBasicoProveedor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.DatoBasicoProveedorDTO datoBasicoProveedorDTO;
	
	/**
	 * Referencia con la tabla AreaTrabajo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoDTO;
	
	/**
	 * Referencia con la tabla AreaTrabajo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOAREATRABAJOBODEGA", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoBodega;
	
	/**
	 * Referencia con la tabla AreaTrabajo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOAREATRABAJOSUBBODEGA", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoSubbodega;

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
	 * Representa el estado actual del proceso
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPORECEPCION", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALOR"),
		@JoinColumn(name = "CODIGOTIPORECEPCION", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO")
	})
	private CatalogoValorDTO tipoRecepcion;
	
	/**
	 * Referencia con la tabla EntregaRecepcionProveedor
	 */
	@OneToMany(mappedBy="recepcionProveedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<EntregaRecepcionProveedorDTO> entregaRecepcionProveedorDTOCol;
	
	/**
	 * Referencia con la tabla RecepcionProveedorArticuloDTO
	 */
	@OneToMany(mappedBy="recepcionProveedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RecepcionProveedorArticuloDTO> recepcionProveedorArticuloDTOs;
	
	/**
	 * Obtiene la relacion con la tabla facturas FacturaDTO
	 */
	@OneToMany(mappedBy = "recepcionProveedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RecepcionProveedorFacturaDTO> recepcionProveedorFacturaCol;
	
	/*Analizar cambio RecepcionProveedorFurgon*/
//	/**
//	 * Obtiene la relacion con la tabla RecepcionProveedorFurgon
//	 */
//	@OneToMany(mappedBy = "recepcionProveedorDTO")
//	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
//	private Collection<RecepcionProveedorFurgonDTO> recepcionProveedorFurgonDTOCol;
	
	@OneToMany(mappedBy = "recepcionProveedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleRecepcionProveedorDTO> detalleRecepcionProveedorDTOCol;
	
	/**
	 * Secuencial para optimizar los procesos de actualizacion de registros
	 */
	@Column(name="SECUENCIALRECEPCIONPROVEEDOR")	
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECRECPROSEC" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long secuencialRecepcionProveedor;
	
	/**
	 * Cantidad de articulos de la recepcion
	 */
	@Column(name="TOTALITEMS")
	private Integer totalItems;
	
	/**
	 * Total de bultos planificados de la recepcion
	 */
	@Column(name="TOTALBULTOSPLANIFICADOS")
	private Integer totalBultosPlanificados;
	
	/**
	 * Total de bultos recibidos de la recepcion
	 */
	@Column(name="TOTALBULTOSRECIBIDOS")
	private Integer totalBultosRecibidos;
	
	/**
	 * Total de pallets de la recepcion
	 */
	@Column(name="TOTALPALLETSRECEPCION")
	private Integer totalPalletsRecepcion;
	
	/**
	 * Total de facturas de la recepcion
	 */
	@Column(name="TOTALFACTURASRECEPCION")
	private Integer totalFacturasRecepcion;
	
	/**
	 * Total de andes asignados al proveedor para la recepcion
	 */
	@Column(name="TOTALANDENES")
	private Integer totalAndenes;
	
	/**
	 * Peso total recibido en la recepcion
	 */
	@Column(name="TOTALPESORECIBIDO")
	private BigDecimal totalPesoRecibido;
	
	/**
	 * Peso total planificado para la recepcion
	 */
	@Column(name="TOTALPESOPLANIFICADO")
	private BigDecimal totalPesoPlanificado;
	
	/**
	 * <code>Codigo identificador de una ubicacion de anden</code>
	 */
	@Column(name="ANDENREFERENCIA")
	private String andenReferencia;
	
	/**
	 * Campo valida el proceso de disponibilidad sobre la Orden de Compra
	 */
	@Column(name="PRODISORDCOM")
	private String procesoDisponibilidadOrdenCompra;
	
	/*********************************************************/
	/*CAMPOS NO PERSISTENTES*/
	/*********************************************************/
	
	/**
	 * Codigo de la subbodega
	 */
	@Transient
	@Column(name = "CODIGOSUBBODEGA")
	@ComparatorTypeField
	private String codigoSubBodega;
	
	@Transient
	private Collection<RecepcionProveedorControlRecipienteDTO> recepcionProveedorcontrolRecipienteCol;
	
	@Transient
	private Collection<ControlRecipienteDTO> controlRecipienteCol;
	
	/**
	 * EntregaRecepcionProveedorDTO no persistente
	 */
	@Transient
	private EntregaRecepcionProveedorDTO entregaRecepcionProveedorDTO;
	
	/**
	 * 
	 */
	@Transient
	private Collection<FacturaDTO> facturaDTOCol;
	
	/**
	 * Referencia con la vista Proveedor
	 * 
	 */
	@Transient
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOSUBBODEGA", referencedColumnName = "CODIGOBODEGA", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.BodegaDTO subBodega;
	
	@Transient
	private Collection<ControlRecipienteDetalleDTO> detalleRecipientesCol;
	
	/*********************************************************/
	/*SET and GET*/
	/*********************************************************/
	
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
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO
	 *            the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

	/**
	 * @return the procesoLogisticoDTO
	 */
	public ProcesoLogisticoDTO getProcesoLogisticoDTO() {
		return procesoLogisticoDTO;
	}

	/**
	 * @param procesoLogisticoDTO
	 *            the procesoLogisticoDTO to set
	 */
	public void setProcesoLogisticoDTO(ProcesoLogisticoDTO procesoLogisticoDTO) {
		this.procesoLogisticoDTO = procesoLogisticoDTO;
	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.util.Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.util.Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>
	 * .
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

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
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null
				&& idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}


	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * 
	 * @param estado1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado1) {
		this.estado = estado1;

		if (estado != null && estado.length() > 1) {
			estado = estado.substring(0, 1);
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
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>usuarioModificacion</code>.
	 * 
	 * @param usuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion(
			ec.com.smx.framework.security.dto.UserDto usuarioModificacion1) {
		this.usuarioModificacion = usuarioModificacion1;
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
	 * @return the proveedorDTO
	 */
	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	/**
	 * @param proveedorDTO
	 *            the proveedorDTO to set
	 */
	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	/**
	 * @return the vistaProveedor
	 */
	public ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO getVistaProveedor() {
		return vistaProveedor;
	}

	/**
	 * @param vistaProveedor
	 *            the vistaProveedor to set
	 */
	public void setVistaProveedor(
			ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor) {
		this.vistaProveedor = vistaProveedor;
	}

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorID id) {
		this.id = id;
	}

	/**
	 * @return the codigoAreaTrabajoSubBodega
	 */
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}

	/**
	 * @param codigoAreaTrabajoSubBodega the codigoAreaTrabajoSubBodega to set
	 */
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico
	 *            the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the entregaRecepcionProveedorDTO
	 */
	public EntregaRecepcionProveedorDTO getEntregaRecepcionProveedorDTO() {
		entregaRecepcionProveedorDTO = null;
		if (CollectionUtils.isNotEmpty(entregaRecepcionProveedorDTOCol)) {
			entregaRecepcionProveedorDTO = entregaRecepcionProveedorDTOCol.iterator().next();
		}
		return entregaRecepcionProveedorDTO;
	}

	/**
	 * @param entregaRecepcionProveedorDTO the entregaRecepcionProveedorDTO to set
	 */
	public void setEntregaRecepcionProveedorDTO(EntregaRecepcionProveedorDTO entregaRecepcionProveedorDTO) {
		this.entregaRecepcionProveedorDTO = entregaRecepcionProveedorDTO;
	}

	/**
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}

	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}

	/**
	 * @return the codigoSubBodega
	 */
	public String getCodigoSubBodega() {
		return codigoSubBodega;
	}

	/**
	 * @param codigoSubBodega the codigoSubBodega to set
	 */
	public void setCodigoSubBodega(String codigoSubBodega) {
		this.codigoSubBodega = codigoSubBodega;
	}

	/**
	 * @return the valorTipoRecepcion
	 */
	public String getValorTipoRecepcion() {
		return valorTipoRecepcion;
	}

	/**
	 * @param valorTipoRecepcion the valorTipoRecepcion to set
	 */
	public void setValorTipoRecepcion(String valorTipoRecepcion) {
		this.valorTipoRecepcion = valorTipoRecepcion;
	}

	/**
	 * @return the subBodega
	 */
	public ec.com.smx.sic.cliente.mdl.dto.BodegaDTO getSubBodega() {
		return subBodega;
	}

	/**
	 * @param subBodega the subBodega to set
	 */
	public void setSubBodega(ec.com.smx.sic.cliente.mdl.dto.BodegaDTO subBodega) {
		this.subBodega = subBodega;
	}

	/**
	 * @return the codigoTipoRecepcion
	 */
	public Integer getCodigoTipoRecepcion() {
		return codigoTipoRecepcion;
	}

	/**
	 * @param codigoTipoRecepcion the codigoTipoRecepcion to set
	 */
	public void setCodigoTipoRecepcion(Integer codigoTipoRecepcion) {
		this.codigoTipoRecepcion = codigoTipoRecepcion;
	}
	
	/**
	 * Valida si existe asignadas las recepciones del proveedor
	 * @return
	 */
	public Boolean getTieneEntregaRecepcionProveedorDTO() {
		return isLoaded(this.entregaRecepcionProveedorDTOCol) && !this.entregaRecepcionProveedorDTOCol.isEmpty();
	}
	
	/*Analizar cambio RecepcionProveedorFurgon*/
//	/**
//	 * Valida si existe asignadas las recepciones del proveedor
//	 * @return
//	 */
//	public Boolean getTieneRecepcionProveedorFurgonDTOCol() {
//		return isLoaded(this.recepcionProveedorFurgonDTOCol) && !this.recepcionProveedorFurgonDTOCol.isEmpty();
//	}
	
	public Boolean getTieneDetalleRecepcionProveedorDTOCol() {
		return isLoaded(this.detalleRecepcionProveedorDTOCol) && !this.detalleRecepcionProveedorDTOCol.isEmpty();
	}
	
	/**
	 * Valida si existe la subbodega
	 * @return
	 */
	public Boolean getTieneSubBodega() {
		return isLoaded(this.subBodega);
	}

	/**
	 * @return the datoBasicoProveedorDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DatoBasicoProveedorDTO getDatoBasicoProveedorDTO() {
		return datoBasicoProveedorDTO;
	}

	/**
	 * @param datoBasicoProveedorDTO the datoBasicoProveedorDTO to set
	 */
	public void setDatoBasicoProveedorDTO(ec.com.smx.sic.cliente.mdl.dto.DatoBasicoProveedorDTO datoBasicoProveedorDTO) {
		this.datoBasicoProveedorDTO = datoBasicoProveedorDTO;
	}

	/**
	 * @return the fechaRecepcion
	 */
	public java.util.Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(java.util.Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	/**
	 * @return the facturaDTOCol
	 */
	public Collection<FacturaDTO> getFacturaDTOCol() {
		if(isLoaded(this.recepcionProveedorFacturaCol)){
			this.facturaDTOCol = new ArrayList<FacturaDTO>();
			for (RecepcionProveedorFacturaDTO recepcionProveedorFactura : recepcionProveedorFacturaCol) {
				this.facturaDTOCol.add(recepcionProveedorFactura.getFacturaDTO());
			}
		}
		return this.facturaDTOCol;
	}

	/**
	 * @param facturaDTOCol the facturaDTOCol to set
	 oid setFacturaDTOCol(Collection<FacturaDTO> facturaDTOCol) {
		this.facturaDTOCol = facturaDTOCol;
	}*/

	/**
	 * @return the detalleRecepcionProveedorDTOCol
	 */
	public Collection<DetalleRecepcionProveedorDTO> getDetalleRecepcionProveedorDTOCol() {
		return detalleRecepcionProveedorDTOCol;
	}

	/**
	 * @param detalleRecepcionProveedorDTOCol the detalleRecepcionProveedorDTOCol to set
	 */
	public void setDetalleRecepcionProveedorDTOCol(Collection<DetalleRecepcionProveedorDTO> detalleRecepcionProveedorDTOCol) {
		this.detalleRecepcionProveedorDTOCol = detalleRecepcionProveedorDTOCol;
	}

	public Collection<RecepcionProveedorFacturaDTO> getRecepcionProveedorFacturaCol() {
		return recepcionProveedorFacturaCol;
	}

	public void setRecepcionProveedorFacturaCol(Collection<RecepcionProveedorFacturaDTO> recepcionProveedorFacturaCol) {
		this.recepcionProveedorFacturaCol = recepcionProveedorFacturaCol;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the areaTrabajoBodega
	 */
	public AreaTrabajoDTO getAreaTrabajoBodega() {
		return areaTrabajoBodega;
	}

	/**
	 * @param areaTrabajoBodega the areaTrabajoBodega to set
	 */
	public void setAreaTrabajoBodega(AreaTrabajoDTO areaTrabajoBodega) {
		this.areaTrabajoBodega = areaTrabajoBodega;
	}

	/**
	 * @return the areaTrabajoSubbodega
	 */
	public AreaTrabajoDTO getAreaTrabajoSubbodega() {
		return areaTrabajoSubbodega;
	}

	/**
	 * @param areaTrabajoSubbodega the areaTrabajoSubbodega to set
	 */
	public void setAreaTrabajoSubbodega(AreaTrabajoDTO areaTrabajoSubbodega) {
		this.areaTrabajoSubbodega = areaTrabajoSubbodega;
	}

	/**
	 * @return the secuencialRecepcionProveedor
	 */
	public Long getSecuencialRecepcionProveedor() {
		return secuencialRecepcionProveedor;
	}

	/**
	 * @param secuencialRecepcionProveedor the secuencialRecepcionProveedor to set
	 */
	public void setSecuencialRecepcionProveedor(Long secuencialRecepcionProveedor) {
		this.secuencialRecepcionProveedor = secuencialRecepcionProveedor;
	}

	/**
	 * @return the totalItemsInteger
	 */
	public Integer getTotalItems() {
		return totalItems;
	}

	/**
	 * @param totalItemsInteger the totalItemsInteger to set
	 */
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	/**
	 * @return the totalBultosPlanificados
	 */
	public Integer getTotalBultosPlanificados() {
		return totalBultosPlanificados;
	}

	/**
	 * @param totalBultosPlanificados the totalBultosPlanificados to set
	 */
	public void setTotalBultosPlanificados(Integer totalBultosPlanificados) {
		this.totalBultosPlanificados = totalBultosPlanificados;
	}

	/**
	 * @return the totalBultosRecibidos
	 */
	public Integer getTotalBultosRecibidos() {
		return totalBultosRecibidos;
	}

	/**
	 * @param totalBultosRecibidos the totalBultosRecibidos to set
	 */
	public void setTotalBultosRecibidos(Integer totalBultosRecibidos) {
		this.totalBultosRecibidos = totalBultosRecibidos;
	}

	/**
	 * @return the totalPalletsRecepcion
	 */
	public Integer getTotalPalletsRecepcion() {
		return totalPalletsRecepcion;
	}

	/**
	 * @param totalPalletsRecepcion the totalPalletsRecepcion to set
	 */
	public void setTotalPalletsRecepcion(Integer totalPalletsRecepcion) {
		this.totalPalletsRecepcion = totalPalletsRecepcion;
	}

	/**
	 * @return the totalFacturasRecepcion
	 */
	public Integer getTotalFacturasRecepcion() {
		return totalFacturasRecepcion;
	}

	/**
	 * @param totalFacturasRecepcion the totalFacturasRecepcion to set
	 */
	public void setTotalFacturasRecepcion(Integer totalFacturasRecepcion) {
		this.totalFacturasRecepcion = totalFacturasRecepcion;
	}

	/**
	 * @return the totalAndenes
	 */
	public Integer getTotalAndenes() {
		return totalAndenes;
	}

	/**
	 * @param totalAndenes the totalAndenes to set
	 */
	public void setTotalAndenes(Integer totalAndenes) {
		this.totalAndenes = totalAndenes;
	}

	/**
	 * @return the andenReferencia
	 */
	public String getAndenReferencia() {
		return andenReferencia;
	}

	/**
	 * @param andenReferencia the andenReferencia to set
	 */
	public void setAndenReferencia(String andenReferencia) {
		this.andenReferencia = andenReferencia;
	}
	
	
	/**
	 * @return the totalPesoRecibido
	 */
	public BigDecimal getTotalPesoRecibido() {
		return totalPesoRecibido;
	}

	/**
	 * @param totalPesoRecibido the totalPesoRecibido to set
	 */
	public void setTotalPesoRecibido(BigDecimal totalPesoRecibido) {
		this.totalPesoRecibido = totalPesoRecibido;
	}

	/**
	 * @return the totalPesoPlanificado
	 */
	public BigDecimal getTotalPesoPlanificado() {
		return totalPesoPlanificado;
	}

	/**
	 * @param totalPesoPlanificado the totalPesoPlanificado to set
	 */
	public void setTotalPesoPlanificado(BigDecimal totalPesoPlanificado) {
		this.totalPesoPlanificado = totalPesoPlanificado;
	}

	/**
	 * 
	 * @return
	 */
	public Collection<RecepcionProveedorControlRecipienteDTO> getRecepcionProveedorcontrolRecipienteCol() {
		return recepcionProveedorcontrolRecipienteCol;
	}

	/**
	 * 
	 * @param recepcionProveedorcontrolRecipienteCol
	 */
	public void setRecepcionProveedorcontrolRecipienteCol(Collection<RecepcionProveedorControlRecipienteDTO> recepcionProveedorcontrolRecipienteCol) {
		this.recepcionProveedorcontrolRecipienteCol = recepcionProveedorcontrolRecipienteCol;
	}

	/**
	 * 
	 * @return
	 */
	public Collection<ControlRecipienteDTO> getControlRecipienteCol() {
		return controlRecipienteCol;
	}

	/**
	 * 
	 * @param controlRecipienteCol
	 */
	public void setControlRecipienteCol(Collection<ControlRecipienteDTO> controlRecipienteCol) {
		this.controlRecipienteCol = controlRecipienteCol;
	}

	/**
	 * @return the recepcionProveedorArticuloDTOs
	 */
	public Collection<RecepcionProveedorArticuloDTO> getRecepcionProveedorArticuloDTOs() {
		return recepcionProveedorArticuloDTOs;
	}

	/**
	 * @param recepcionProveedorArticuloDTOs the recepcionProveedorArticuloDTOs to set
	 */
	public void setRecepcionProveedorArticuloDTOs(Collection<RecepcionProveedorArticuloDTO> recepcionProveedorArticuloDTOs) {
		this.recepcionProveedorArticuloDTOs = recepcionProveedorArticuloDTOs;
	}

	/**
	 * @param facturaDTOCol the facturaDTOCol to set
	 */
	public void setFacturaDTOCol(Collection<FacturaDTO> facturaDTOCol) {
		this.facturaDTOCol = facturaDTOCol;
	}

	public Boolean getEstadoImpresion() {
		return estadoImpresion;
	}

	public void setEstadoImpresion(Boolean estadoImpresion) {
		this.estadoImpresion = estadoImpresion;
	}

	public Collection<ControlRecipienteDetalleDTO> getDetalleRecipientesCol() {
		return detalleRecipientesCol;
	}

	public void setDetalleRecipientesCol(Collection<ControlRecipienteDetalleDTO> detalleRecipientesCol) {
		this.detalleRecipientesCol = detalleRecipientesCol;
	}

	/**
	 * @return the activarEscaneoManual
	 */
	public Boolean getActivarEscaneoManual() {
		return activarEscaneoManual;
	}

	/**
	 * @param activarEscaneoManual the activarEscaneoManual to set
	 */
	public void setActivarEscaneoManual(Boolean activarEscaneoManual) {
		this.activarEscaneoManual = activarEscaneoManual;
	}

	/**
	 * @return the codigoGrupoNovedadArticulo
	 */
	public Long getCodigoGrupoNovedadArticulo() {
		return codigoGrupoNovedadArticulo;
	}

	/**
	 * @param codigoGrupoNovedadArticulo the codigoGrupoNovedadArticulo to set
	 */
	public void setCodigoGrupoNovedadArticulo(Long codigoGrupoNovedadArticulo) {
		this.codigoGrupoNovedadArticulo = codigoGrupoNovedadArticulo;
	}

	/**
	 * @return the procesoDisponibilidadOrdenCompra
	 */
	public String getProcesoDisponibilidadOrdenCompra() {
		return procesoDisponibilidadOrdenCompra;
	}

	/**
	 * @param procesoDisponibilidadOrdenCompra the procesoDisponibilidadOrdenCompra to set
	 */
	public void setProcesoDisponibilidadOrdenCompra(String procesoDisponibilidadOrdenCompra) {
		this.procesoDisponibilidadOrdenCompra = procesoDisponibilidadOrdenCompra;
	}

	/**
	 * @return the tiempoEstimadoRecepcion
	 */
	public Long getTiempoEstimadoRecepcion() {
		return tiempoEstimadoRecepcion;
	}

	/**
	 * @param tiempoEstimadoRecepcion the tiempoEstimadoRecepcion to set
	 */
	public void setTiempoEstimadoRecepcion(Long tiempoEstimadoRecepcion) {
		this.tiempoEstimadoRecepcion = tiempoEstimadoRecepcion;
	}

	
}
