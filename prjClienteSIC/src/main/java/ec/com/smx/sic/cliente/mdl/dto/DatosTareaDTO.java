
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.sql.Types;
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
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Almacena informacion referente a los datos de la tarea 
 *
 * @author guvidia
 */
@SuppressWarnings({ "serial" })
@Entity
@Table(name="SBLOGTDATTAR")
public class DatosTareaDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla DatosTarea
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaID id = new ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaID();	
	
	/**
	 * Codigo de articulo, almacena el codigo secuencial de un articulo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	/**
	 * Secuencial de la unidad de manejo por articulo
	 */
	@Column(name = "CODIGOUNIDADMANEJO", nullable = false)
	private Long codigoUnidadManejo;
	
	/**
	 * Secuencial de la unidad de manejo por articulo
	 */
	@Column(name = "CODIGORECEPCIONPROVEEDORARTICULO", nullable = false)
	private Long codigoRecepcionProveedorArticulo;
	
	/**
	 * Cantidad de articulos que estan en el contenedor
	 */
	@Column 
	private Integer cantidad;
	
	/**
	 * Peso total neto que se recibio en el pallet
	 */
	@Column 
	private BigDecimal peso;
	
	/**
	 * Peso de una aproximado con el que se recibio el pallet
	 */
	@Column 
	private BigDecimal pesoAproximado;

	/**
	 *  Peso total Bruto que se recibio en el pallet
	 *  
	 */
	@Column 
	private BigDecimal pesoBruto;
	
	/**
	 * Peso total solo de las jabas que se recibe en el pallet (sin peso del articulo)
	 * Peso total de las taras de las jabas que estan en el pallet
	 * 
	 */
	@Column 
	private BigDecimal pesoJabas;

	/**
	 * Representa el codigo de barras del contenedor.
	 *
	 */
	@Column
	@ComparatorTypeField
	private String codigoBarras ;		
	
	/**
	 * Representa la fecha de caducidad del producto que se lleva en el pallet.
	 *
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaCaducidad ;
	
	/**
	 * Representa la fecha de elaboracion del producto que se lleva en el pallet.
	 *
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaElaboracion ;

	/**
	 * Fecha en la que se realiza el registro
	 *

	 */
	@Column
	@RegisterDateField
	private java.util.Date fechaRegistro ;

	/**
	 * Campo para guardar el lote cuando el Pallet es ubicado 
	 * 
	 */
	@Column
	private String lote;
	
	/**
	 * Campo para guardar la referencia  con el articulo que es tipo pallet
	 * 
	 */
	@Column
	private String codigoArticuloContenedor;
	
	/**
	 * Campo para almacenar el codigo detalle seccion del anden
	 */
	@Column
	private Long codigoDetalleSeccionAnden;
	
	/**
	 * Campo para almacenar el codigo detalle seccion de la nave
	 */
	@Column(name = "CODIGODETALLESECCIONNAVE")
	private Long codigoDetalleSeccionNave;
	
	/**
	 * Campo para almacenar el codigo detalle seccion de la subnave
	 */
	@Column(name = "CODIGODETALLESECCIONSUBNAVE")
	private Long codigoDetalleSeccionSubNave;
	
	/**
	 * Campo para registrar la feha y hora de registro de cada pallet
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaInicio ;
	
	/**
	 * Campo para registrar la feha y hora que finaliza el registro
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaFin ;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 *
	 */
	
	@Column
	@RegisterUserIdField
	private String idUsuarioRegistro ;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 *

	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaModificacion ;
	
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 *

	 */
	@Column
	@LastModifierUserIdField
	private String idUsuarioModificacion ;
	
	/**
	 * Codigo del area de trabajo para el CD
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
	 * Campo no persistente
	 * Obtener el estado activo de DatosTarea
	 */
	@Transient
	public DatosTareaEstadoDTO datosTareaEstadoDTOActivo;
	
	/**
	 * Campo no persistente
	 * Codigo de la tarea que esta procesando el pallet
	 */
	@Transient
	public Long codigoTarea;
	
	/**
	 * Codigo proceso logistico
	 *
	 */
	@Column
	private Long codigoProcesoLogistico;
	
	/**
	 * Valor del tipo de control de costo
	 * 
	 */	
	@Column(name="VALORTIPOCONTROLCOSTO")
	private String valorTipoControlCosto;

	/**
	 * Codigo del tipo de peso en el catalogo
	 * 
	 */
	@Column(name="CODIGOTIPOCONTROLCOSTO")
	private Integer codigoTipoControlCosto;
	
	/**
	 * Valor para marca del pallet
	 * 
	 */	
	@Column(name="VALORTIPOMARCA")
	private String valorTipoMarca;

	/**
	 * Codigo para marca del pallet
	 * 
	 */
	@Column(name="CODIGOTIPOMARCA")
	private Integer codigoTipoMarca;
	
	/**
	 * 
	 */
	@Transient
	private Boolean seleccionado = Boolean.FALSE; 
	
	/**
	 * Relacion con Tarea 
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGORECEPCIONPROVEEDORARTICULO", referencedColumnName = "CODIGORECEPCIONPROVEEDORARTICULO", insertable = false, updatable = false)
	})
	private RecepcionProveedorArticuloDTO recepcionProveedorArticuloDTO;
	
	/**
	 * Relacion con detalleSeccion 
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGODETALLESECCIONANDEN", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)
	})
	private DetalleSeccionDTO detalleSeccionDTO;
	
	/**
	 * Relacion con detalleSeccion Nave
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGODETALLESECCIONNAVE", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)
	})
	private DetalleSeccionDTO detalleSeccionNaveDTO;
	
	/**
	 * Relacion con detalleSeccion SubNave 
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGODETALLESECCIONSUBNAVE", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)
	})
	private DetalleSeccionDTO detalleSeccionSubNaveDTO;
	
	/**
	 * Referencia para el tipo de control de costos
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOCONTROLCOSTO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOCONTROLCOSTO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoControlCosto;
	
	/**
	 * Referencia para el tipo de marca del pallet
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOMARCA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOMARCA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoMarcaPallet;
	
	/**
	 * Referencia con la tabla tarea
	 *
	 */
	@Transient
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOTAREA", referencedColumnName = "CODIGOTAREA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.TareaDTO tarea;

	/**
	 * Referencia con la tabla Articulo
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULOCONTENEDOR", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articuloContenedor;
	
	/**
	 * Especifica la relacion con ArticuloUnidadManejo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO;
	

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
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

	/**
	 * Referencia al detalle de los datos de la tarea(Un palet puede tener 1 o mas articulos de diferentes ordenes de compra)
	 */
	@OneToMany(mappedBy = "datosTarea")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleDatosTareaDTO> detalleDatosTareaDTOCol;
	
	/**
	 * Referencia al detalle de los recipientes del pallet
	 */
	@OneToMany(mappedBy = "datosTareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DatosTareaDetalleRecipienteDTO> datosTareaDetalleRecipienteCol;
	
	/**
	 * Obtiene la relacion con los datos de la tabla tarea datos tarea
	 */
	@OneToMany(mappedBy = "datosTareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TareaDatosTareaDTO> tareaDatosTareaDTOCol;
	
	/**
	 * Referencia a los estados del datos tarea
	 */
	@OneToMany(mappedBy = "datosTareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DatosTareaEstadoDTO> datosTareaEstadoDTOCol;
	
	/**
	 * Referencia con la tabla AreaTrabajo CD
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoDTO;
	
	/**
	 * Referencia con la tabla AreaTrabajo BOD
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOAREATRABAJOBODEGA", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoBodega;
	
	/**
	 * Referencia con la tabla AreaTrabajo SBO
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOAREATRABAJOSUBBODEGA", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoSubbodega;
	
	/*
	 * Inicio campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * 
	 * */
	@Column(name="SECUENCIALDATOSTAREA") 
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, 
						   name = "SBLOGSECDATTARSEC" , 
						   sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
						   castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long secuencialDatosTarea;
	
	@Column(name="CODIGOESTADODATOSTAREA")
	private Integer codigoEstadoDatosTarea;
	
	@Column(name="VALORESTADODATOSTAREA")
	private String valorEstadoDatosTarea;
	
	/**
	 * Secuencial de la tabla <code>DetalleSeccionDTO</code> para idenficar la ubicacion actual del pallet mientras cambia de ubicacion
	 */
	@Column(name="UBICACIONACTUAL")
	private Long ubicacionActual;
	
	/**
	 * Secuencial de la tabla <code>DetalleSeccionDTO</code> para idenficar la ubicacion origen del pallet
	 */
	@Column(name="UBICACIONDESTINO")
	private Long ubicacionDestino;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOESTADODATOSTAREA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "VALORESTADODATOSTAREA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO estadoDatosTarea;
	
	/**
	 * Referencia con la tabla ProcesoLogistico
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOPROCESOLOGISTICO", referencedColumnName = "CODIGOPROCESOLOGISTICO", insertable = false, updatable = false) })
	private ProcesoLogisticoDTO procesoLogisticoDTO;
	
	/*
	 * Fin campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * 
	 * */
	
	// Secuencial datos Tarea
	public static final String NOMBRE_SECUENCIA_DATOS_TAREA = "SBLOGSECDATTARSEC";
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaID id1 ){
		this.id=id1;
	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.util.Date getFechaRegistro(){
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * @param fechaRegistro1 
	 *		El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro( java.util.Date fechaRegistro1 ){
		this.fechaRegistro=fechaRegistro1;
		
	}	

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro(){
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * @param idUsuarioRegistro1 
	 *		El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro( String idUsuarioRegistro1 ){
		this.idUsuarioRegistro=idUsuarioRegistro1;
		
		if(idUsuarioRegistro!=null && idUsuarioRegistro.length()>32){
			idUsuarioRegistro = idUsuarioRegistro.substring(0,32);
		}		
	}


	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.util.Date getFechaModificacion(){
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * @param fechaModificacion1 
	 *		El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion( java.util.Date fechaModificacion1 ){
		this.fechaModificacion=fechaModificacion1;
		
	}


	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion(){
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * @param idUsuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion( String idUsuarioModificacion1 ){
		this.idUsuarioModificacion=idUsuarioModificacion1;
		
		if(idUsuarioModificacion!=null && idUsuarioModificacion.length()>32){
			idUsuarioModificacion = idUsuarioModificacion.substring(0,32);
		}
					
	}

		
	/**
	 * Retorna valor de propiedad <code>tarea</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>tarea</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.TareaDTO getTarea(){
		return this.tarea;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tarea</code>.
	 * @param tarea1 
	 *		El valor a establecer para la propiedad <code>tarea</code>.
	 */
	public void setTarea( ec.com.smx.sic.cliente.mdl.dto.TareaDTO tarea1 ){
		this.tarea=tarea1;
	}	


	/**
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion(){
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * @param usuarioCreacion1 
	 *		El valor a establecer para la propiedad <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion( ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion1 ){
		this.usuarioCreacion=usuarioCreacion1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion(){
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * @param usuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion( ec.com.smx.framework.security.dto.UserDto usuarioModificacion1 ){
		this.usuarioModificacion=usuarioModificacion1;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaCaducidad
	 */
	public java.util.Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(java.util.Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * @return the detalleDatosTareaDTOCol
	 */
	public Collection<DetalleDatosTareaDTO> getDetalleDatosTareaDTOCol() {
		return detalleDatosTareaDTOCol;
	}

	/**
	 * @param detalleDatosTareaDTOCol the detalleDatosTareaDTOCol to set
	 */
	public void setDetalleDatosTareaDTOCol(Collection<DetalleDatosTareaDTO> detalleDatosTareaDTOCol) {
		this.detalleDatosTareaDTOCol = detalleDatosTareaDTOCol;
	}

	/**
	 * @return the datosTareaEstadoDTOCol
	 */
	public Collection<DatosTareaEstadoDTO> getDatosTareaEstadoDTOCol() {
		return datosTareaEstadoDTOCol;
	}

	/**
	 * @param datosTareaEstadoDTOCol the datosTareaEstadoDTOCol to set
	 */
	public void setDatosTareaEstadoDTOCol(Collection<DatosTareaEstadoDTO> datosTareaEstadoDTOCol) {
		this.datosTareaEstadoDTOCol = datosTareaEstadoDTOCol;
	}

	/**
	 * @return the tareaDatosTareaDTOCol
	 */
	public Collection<TareaDatosTareaDTO> getTareaDatosTareaDTOCol() {
		return tareaDatosTareaDTOCol;
	}

	/**
	 * @param tareaDatosTareaDTOCol the tareaDatosTareaDTOCol to set
	 */
	public void setTareaDatosTareaDTOCol(Collection<TareaDatosTareaDTO> tareaDatosTareaDTOCol) {
		this.tareaDatosTareaDTOCol = tareaDatosTareaDTOCol;
	}
	
	/**
	 * @return the entregaEstadoDTOActivo
	 */
	public DatosTareaEstadoDTO getDatosTareaEstadoDTOActivo() {
		if(this.getTieneEstadoDatosTareaDTOCol()){
			for(DatosTareaEstadoDTO ee : this.datosTareaEstadoDTOCol){
				if(ee.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && ee.getFechaFin() == null){
					this.datosTareaEstadoDTOActivo = ee;
					break;
				}
			}
		}
		return datosTareaEstadoDTOActivo;
	}
	
	public void setDatosTareaEstadoDTOActivo(DatosTareaEstadoDTO datosTareaEstadoDTO){
		this.datosTareaEstadoDTOActivo = datosTareaEstadoDTO;
	}
	
	/**
	 * @return the tieneEstadoProcesoDTOCol
	 */
	public Boolean getTieneEstadoDatosTareaDTOCol() {
		return isLoaded(this.datosTareaEstadoDTOCol) && !this.datosTareaEstadoDTOCol.isEmpty();
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
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
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
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}

	/**
	 * @return the codigoArticuloContenedor
	 */
	public String getCodigoArticuloContenedor() {
		return codigoArticuloContenedor;
	}

	/**
	 * @param codigoArticuloContenedor the codigoArticuloContenedor to set
	 */
	public void setCodigoArticuloContenedor(String codigoArticuloContenedor) {
		this.codigoArticuloContenedor = codigoArticuloContenedor;
	}

	/**
	 * @return the articuloContenedor
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticuloContenedor() {
		return articuloContenedor;
	}

	/**
	 * @param articuloContenedor the articuloContenedor to set
	 */
	public void setArticuloContenedor(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articuloContenedor) {
		this.articuloContenedor = articuloContenedor;
	}

	/**
	 * @return the fechaElaboracion
	 */
	public java.util.Date getFechaElaboracion() {
		return fechaElaboracion;
	}

	/**
	 * @param fechaElaboracion the fechaElaboracion to set
	 */
	public void setFechaElaboracion(java.util.Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the articuloUnidadManejoDTO
	 */
	public ArticuloUnidadManejoDTO getArticuloUnidadManejoDTO() {
		return articuloUnidadManejoDTO;
	}

	/**
	 * @param articuloUnidadManejoDTO the articuloUnidadManejoDTO to set
	 */
	public void setArticuloUnidadManejoDTO(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
	}

	/**
	 * @return the secuencialDatosTarea
	 */
	public Long getSecuencialDatosTarea() {
		return secuencialDatosTarea;
	}

	/**
	 * @param secuencialDatosTarea the secuencialDatosTarea to set
	 */
	public void setSecuencialDatosTarea(Long secuencialDatosTarea) {
		this.secuencialDatosTarea = secuencialDatosTarea;
	}

	/**
	 * @return the codigoEstadoDatosTarea
	 */
	public Integer getCodigoEstadoDatosTarea() {
		return codigoEstadoDatosTarea;
	}

	/**
	 * @param codigoEstadoDatosTarea the codigoEstadoDatosTarea to set
	 */
	public void setCodigoEstadoDatosTarea(Integer codigoEstadoDatosTarea) {
		this.codigoEstadoDatosTarea = codigoEstadoDatosTarea;
	}

	/**
	 * @return the valorEstadoDatosTarea
	 */
	public String getValorEstadoDatosTarea() {
		return valorEstadoDatosTarea;
	}

	/**
	 * @param valorEstadoDatosTarea the valorEstadoDatosTarea to set
	 */
	public void setValorEstadoDatosTarea(String valorEstadoDatosTarea) {
		this.valorEstadoDatosTarea = valorEstadoDatosTarea;
	}

	/**
	 * @return the ubicacionActual
	 */
	public Long getUbicacionActual() {
		return ubicacionActual;
	}

	/**
	 * @param ubicacionActual the ubicacionActual to set
	 */
	public void setUbicacionActual(Long ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}

	/**
	 * @return the estadoDatosTarea
	 */
	public CatalogoValorDTO getEstadoDatosTarea() {
		return estadoDatosTarea;
	}

	/**
	 * @param estadoDatosTarea the estadoDatosTarea to set
	 */
	public void setEstadoDatosTarea(CatalogoValorDTO estadoDatosTarea) {
		this.estadoDatosTarea = estadoDatosTarea;
	}

	/**
	 * @return the ubicacionDestino
	 */
	public Long getUbicacionDestino() {
		return ubicacionDestino;
	}

	/**
	 * @param ubicacionDestino the ubicacionDestino to set
	 */
	public void setUbicacionDestino(Long ubicacionDestino) {
		this.ubicacionDestino = ubicacionDestino;
	}

	/**
	 * @return the codigoTarea
	 */
	public Long getCodigoTarea() {
		return codigoTarea;
	}

	/**
	 * @param codigoTarea the codigoTarea to set
	 */
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	/**
	 * @return the valorTipoControlCosto
	 */
	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}

	/**
	 * @param valorTipoControlCosto the valorTipoControlCosto to set
	 */
	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}

	/**
	 * @return the codigoTipoControlCosto
	 */
	public Integer getCodigoTipoControlCosto() {
		return codigoTipoControlCosto;
	}

	/**
	 * @param codigoTipoControlCosto the codigoTipoControlCosto to set
	 */
	public void setCodigoTipoControlCosto(Integer codigoTipoControlCosto) {
		this.codigoTipoControlCosto = codigoTipoControlCosto;
	}

	/**
	 * @return the tipoControlCosto
	 */
	public CatalogoValorDTO getTipoControlCosto() {
		return tipoControlCosto;
	}

	/**
	 * @param tipoControlCosto the tipoControlCosto to set
	 */
	public void setTipoControlCosto(CatalogoValorDTO tipoControlCosto) {
		this.tipoControlCosto = tipoControlCosto;
	}

	/**
	 * @return the peso
	 */
	public BigDecimal getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	/**
	 * @return the pesoAproximado
	 */
	public BigDecimal getPesoAproximado() {
		return pesoAproximado;
	}

	/**
	 * @param pesoAproximado the pesoAproximado to set
	 */
	public void setPesoAproximado(BigDecimal pesoAproximado) {
		this.pesoAproximado = pesoAproximado;
	}

	/**
	 * @return the pesoBruto
	 */
	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	/**
	 * @param pesoBruto the pesoBruto to set
	 */
	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	/**
	 * @return the valorTipoMarca
	 */
	public String getValorTipoMarca() {
		return valorTipoMarca;
	}

	/**
	 * @param valorTipoMarca the valorTipoMarca to set
	 */
	public void setValorTipoMarca(String valorTipoMarca) {
		this.valorTipoMarca = valorTipoMarca;
	}

	/**
	 * @return the codigoTipoMarca
	 */
	public Integer getCodigoTipoMarca() {
		return codigoTipoMarca;
	}

	/**
	 * @param codigoTipoMarca the codigoTipoMarca to set
	 */
	public void setCodigoTipoMarca(Integer codigoTipoMarca) {
		this.codigoTipoMarca = codigoTipoMarca;
	}

	/**
	 * @return the tipoMarcaPallet
	 */
	public CatalogoValorDTO getTipoMarcaPallet() {
		return tipoMarcaPallet;
	}

	/**
	 * @param tipoMarcaPallet the tipoMarcaPallet to set
	 */
	public void setTipoMarcaPallet(CatalogoValorDTO tipoMarcaPallet) {
		this.tipoMarcaPallet = tipoMarcaPallet;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}
	

	/**
	 * @return the recepcionProveedorArticuloDTO
	 */
	public RecepcionProveedorArticuloDTO getRecepcionProveedorArticuloDTO() {
		return recepcionProveedorArticuloDTO;
	}

	/**
	 * @param recepcionProveedorArticuloDTO the recepcionProveedorArticuloDTO to set
	 */
	public void setRecepcionProveedorArticuloDTO(RecepcionProveedorArticuloDTO recepcionProveedorArticuloDTO) {
		this.recepcionProveedorArticuloDTO = recepcionProveedorArticuloDTO;
	}
	

	/**
	 * @return the datosTareaDetalleRecipienteCol
	 */
	public Collection<DatosTareaDetalleRecipienteDTO> getDatosTareaDetalleRecipienteCol() {
		return datosTareaDetalleRecipienteCol;
	}

	/**
	 * @param datosTareaDetalleRecipienteCol the datosTareaDetalleRecipienteCol to set
	 */
	public void setDatosTareaDetalleRecipienteCol(Collection<DatosTareaDetalleRecipienteDTO> datosTareaDetalleRecipienteCol) {
		this.datosTareaDetalleRecipienteCol = datosTareaDetalleRecipienteCol;
	}
	
	/**
	 * @return the pesoJabas
	 */
	public BigDecimal getPesoJabas() {
		return pesoJabas;
	}

	/**
	 * @param pesoJabas the pesoJabas to set
	 */
	public void setPesoJabas(BigDecimal pesoJabas) {
		this.pesoJabas = pesoJabas;
	}

	/**
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the procesoLogisticoDTO
	 */
	public ProcesoLogisticoDTO getProcesoLogisticoDTO() {
		return procesoLogisticoDTO;
	}

	/**
	 * @param procesoLogisticoDTO the procesoLogisticoDTO to set
	 */
	public void setProcesoLogisticoDTO(ProcesoLogisticoDTO procesoLogisticoDTO) {
		this.procesoLogisticoDTO = procesoLogisticoDTO;
	}

	/**
	 * @return the codigoDetalleSeccionAnden
	 */
	public Long getCodigoDetalleSeccionAnden() {
		return codigoDetalleSeccionAnden;
	}

	/**
	 * @param codigoDetalleSeccionAnden the codigoDetalleSeccionAnden to set
	 */
	public void setCodigoDetalleSeccionAnden(Long codigoDetalleSeccionAnden) {
		this.codigoDetalleSeccionAnden = codigoDetalleSeccionAnden;
	}

	/**
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}

	/**
	 * @return the codigoDetalleSeccionNave
	 */
	public Long getCodigoDetalleSeccionNave() {
		return codigoDetalleSeccionNave;
	}

	/**
	 * @param codigoDetalleSeccionNave the codigoDetalleSeccionNave to set
	 */
	public void setCodigoDetalleSeccionNave(Long codigoDetalleSeccionNave) {
		this.codigoDetalleSeccionNave = codigoDetalleSeccionNave;
	}

	/**
	 * @return the codigoDetalleSeccionSubNave
	 */
	public Long getCodigoDetalleSeccionSubNave() {
		return codigoDetalleSeccionSubNave;
	}

	/**
	 * @param codigoDetalleSeccionSubNave the codigoDetalleSeccionSubNave to set
	 */
	public void setCodigoDetalleSeccionSubNave(Long codigoDetalleSeccionSubNave) {
		this.codigoDetalleSeccionSubNave = codigoDetalleSeccionSubNave;
	}

	/**
	 * @return the detalleSeccionNaveDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionNaveDTO() {
		return detalleSeccionNaveDTO;
	}

	/**
	 * @param detalleSeccionNaveDTO the detalleSeccionNaveDTO to set
	 */
	public void setDetalleSeccionNaveDTO(DetalleSeccionDTO detalleSeccionNaveDTO) {
		this.detalleSeccionNaveDTO = detalleSeccionNaveDTO;
	}

	/**
	 * @return the detalleSeccionSubNaveDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionSubNaveDTO() {
		return detalleSeccionSubNaveDTO;
	}

	/**
	 * @param detalleSeccionSubNaveDTO the detalleSeccionSubNaveDTO to set
	 */
	public void setDetalleSeccionSubNaveDTO(DetalleSeccionDTO detalleSeccionSubNaveDTO) {
		this.detalleSeccionSubNaveDTO = detalleSeccionSubNaveDTO;
	}
	
}