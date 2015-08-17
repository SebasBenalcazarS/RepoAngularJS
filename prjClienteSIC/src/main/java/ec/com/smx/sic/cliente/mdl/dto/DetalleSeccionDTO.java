
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.DetalleSeccionID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Especifica el detalle de la seccion de la estructura logistica
 *
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDETSEC")
public class DetalleSeccionDTO extends AuditoriaBaseDTO {

	/**
	 * Clave primaria de la tabla DetalleSeccion
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DetalleSeccionID id = new ec.com.smx.sic.cliente.mdl.dto.id.DetalleSeccionID();
	
	/**
	 *
	 * Especifica el codigo de la seccion
	 */
	@Column
	private java.lang.Long codigoSeccion ;

	/**
	 * Nombre de la seccion
	 * 
	 */
	@Column
	private String nombre ;
	
	/**
	 * Especifica el nombre del detalle de la seccion
	 *
	 */
	@Column
	private String descripcion ;

	/**
	 * Especifica el orden del detalle de la seccion
	 *
	 */
	@Column
	private Integer orden ;

	/**
	 * Especifica el valor del detalle de la seccion
	 *
	 */
	@Column
	private String valor ;
	
	/**
	 * Codigo del tipo de ubicacion de la estructura logistica en el catalogo
	 *
	 */
	@Column
	private Integer codigoTipoUbicacion ;

	/**
	 * Valor del tipo de ubicacion de la estructura logistica en el catalogo (Valores R-> Real - V -> Virtual)
	 *
	 */
	@Column
	@ComparatorTypeField
	private String valorTipoUbicacion ;

	/**
	 * Codigo del tipo de almacenamiento de la estructura logistica en el cat�logo
	 */
	@Column
	private Integer codigoTipoAlmacenamiento ;


	/**
	 * Valor del tipo de almacenamiento de la estructura logistica en el catalogo (Valores S-> Surtido - R -> Reserva)
	 */
	@Column
	@ComparatorTypeField
	private String valorTipoAlmacenamiento ;
	
	/**
	 * Codigo del tipo de sentido del pasillo estructura logistica en el catalogo
	 *
	 */
	@Column
	private Integer codigoTipoSentido ;


	/**
	 * Valor del tipo de sentido del pasillo de la estructura logistica en el catalogo (Valores E-> Entrada - S -> Salida)
	 *
	 */
	@Column
	@ComparatorTypeField
	private String valorTipoSentido ;
	
	/**
	 * Codigo del tipo de lado del rack de la estructura logistica en el catalogo 
	 */
	@Column
	private Integer codigoTipoLado;
    
	/**
	 * Valor del tipo de lado del rack de la estructura logistica en el catalogo (Valores PAR-> Derecha - NON-> Izqioerda) 
	 *
	 */
	@Column
	@ComparatorTypeField
	private String valorTipoLado ;
	
	/**
	 * Codigo del tipo de Area de la estructura logistica en el catalogo 
	 */
	@Column
	private Integer codigoTipoArea;
    
	/**
	 * Valor del tipo de Area de la estructura logistica en el catalogo (Valores B-> Bascula - R-> Recepcion - D-> Despacho - T-> Transito ) 
	 *
	 */
	@Column
	@ComparatorTypeField
	private String valorTipoArea;


	/**
	 * Muestra el tipo de asignacion para los andenes proveedor o local
	 */
	@Column
	private Integer codigoTipoAsignacion;
	
	@Column
	@ComparatorTypeField
	private String valorTipoAsignacion;
	
	/**
	 * muestra el estado del anden 
	 */
	@Column
	private Integer codigoEstadoDetalleSeccion;
	
	@Column
	@ComparatorTypeField
	private String estadoDetalleSeccion;
	
	@Column(name = "SECUENCIALDETALLESECCION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECSECUENCIALDETSEC")
	private java.lang.Long secuencialDetalleSeccion;
	
	/**
	 * Especifica la secuencia para la definicion de la estructura logistica
	 *
	 */
	@Column(name = "CODDEFESTLOG")
	private java.lang.Long codigoDefinicionEstructura ;

	/**
	 * Especifica la ubicacion
	 *
	 */
	@Column
	private String identificador ;
	
	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Especifica el orden del detalle de la seccion
	 *
	 */
	@Column
	private Long ordenar ;
	
	/**
	 * Contabiliza el numero de detalles del detalle seccion
	 */
	@Transient
	private Integer contarSubDetalleSeccion = 0;
	
	/**
	 * Variable para indicar si un detalle secci&oacute;n tipo and&eacute;n 
	 * esta disponible para la asignaci&oacute;n de andenes.
	 */
	@Transient
	private Boolean npAndenDisponible = Boolean.TRUE;
	
	@Transient
	private Boolean npTieneHijos;
	
	/**
	 * Especifica la relacion con la seccion de la estructura logistica
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOSECCION", referencedColumnName = "CODIGOSECCION", insertable = false, updatable = false)})
	private SeccionDTO seccionDTO;
	
	/**
	 * Especifica la relacion con la definicion estructura logistica
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODDEFESTLOG", referencedColumnName = "CODIGODEFINICIONESTLOG", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DefinicionEstructuraLogisticaDTO definicionEstructuraLogisticaDTO;

	
	/**
	 * Obtiene la relacion con el catalogo del tipo de ubicaciones
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOUBICACION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOUBICACION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoUbicacionDTO;

	
	/**
	 * Obtiene la relacion con el catalogo del tipo de almacenamiento
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOALMACENAMIENTO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOALMACENAMIENTO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoAlmacenamientoDTO;
	

	/**
	 * Obtiene la relacion con el catalogo del tipo de sentido
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOSENTIDO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOSENTIDO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoSentidoDTO;
	
	/**
	 * Obtiene la relacion con el catalogo del tipo lado
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOLADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOLADO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoLadoDTO;

	/**
	 * Obtiene la relacion con el catalogo del tipo lado
	 *
	 */
	@ManyToOne(fetch = LAZY)
		@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)})
	private BalanzaDetalleSeccionDTO balanzaDetalleSeccionDTO;
	
	/**
	 * Obtiene la relacion con el catalogo del tipo area
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOAREA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOAREA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoAreaDTO;
	
	/**
	 * Obtiene la relacion con el catalogo del estado detalle seccion
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="ESTADODETALLESECCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOESTADODETALLESECCION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoEstadoDTO;
	
	/**
	 * Obtiene la coleccion de asignacion de articulo unidad de manejo
	 */
	@OneToMany(mappedBy = "detalleSeccionDTO")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<AsignacionArticuloUnidadManejoDTO> asignacionArticuloUnidadManejoCol;

	/**
	 * Obtiene la coleccion de relacion seccion de los padres
	 */
	@OneToMany(mappedBy = "detalleSeccionPadreDTO")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<RelacionSeccionDTO> relacionSeccionPadreCol;
	
	/**
	 * Obtiene la coleccion de relacion seccion de los hijos
	 */
	@OneToMany(mappedBy = "detalleSeccionDTO")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<RelacionSeccionDTO> relacionSeccionCol;
	
	/**
	 * Obtiene la coleccion de caracteristicas dinamicas de un detalle seccion
	 */
	@OneToMany(mappedBy = "detalleSeccionDTO")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<CaracteristicaDetalleSeccionDTO> caracteristicaDetalleSeccionDTOCol;
	
	/**
	 * Obtiene la relacion ProveedorDetalleSeccionDTO
	 */
	@OneToMany(mappedBy = "detalleSeccionDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ProveedorDetalleSeccionDTO> proveedorDetalleSeccionDTOCol;
	
	/**
	 * Referencia con la tabla detalleRecepcionEntrega
	*/ 
	@OneToMany(mappedBy = "detalleSeccion")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleRecepcionEntregaDTO> detalleRecepcionEntregaDTOCol;

	/**
	 * Obtiene la coleccion de contenedor
	 */
	@OneToMany(mappedBy = "detalleSeccionDTO")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ContenedorDTO> contenedorDTOCol;
	
	/**
	 * Obtiene la coleccion de funcionario relacionado con la seccion
	 */
	@Transient
	@OneToMany(mappedBy = "detalleSeccionDTO")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FuncionarioPerfilDetalleSeccionDTO> funcionarioPerfilDetalleSeccionDTOCol;
	
	
	/**
	 * Referencia a la tabla detalleTarea
	 */
	@OneToMany(mappedBy = "detalleSeccionOrigen")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<DetalleTareaDTO> detalleTareaDTOCol;
	

	public DetalleSeccionDTO(){
		
	}
	
	//variable que permite plegar o no los hijos
	@Transient
	private Boolean plegar=Boolean.FALSE;
	//Variable que permite definir si un detalle esta en modo de edicion o no
	@Transient
	private Boolean edicion = Boolean.FALSE;
	//Indica si un detalle ha sido seleccionado o no
	@Transient
	private Boolean seleccionado = Boolean.FALSE;
	
	@Transient
	private Collection<AsignacionArticuloUnidadManejoDTO> subAsignacionArticuloUnidadManejoDTOCol;
	
	/**
	 * Muestra o guarda el codigo de ubicacion
	 */
	@Transient 
	private Long codigoUbicacion;
	/**
	 * Muestra o guarda la ubicacion
	 */
	@Transient 
	private String ubicacion;
	/**
	 * Colocar bajo demanda la coleccion del detalleSeccion obtenido
	 */
	@Transient
	private Collection<DetalleSeccionDTO> subDetalleSeccionDTOCol;
	/**
	 * permite obtener el identificador de padre
	 */
	@Transient 
	private DetalleSeccionDTO detalleSeccionPadre;
	
	@Transient 
	private String nombreProveedor;
	
	@Transient 
	private String codigoProveedor;
	
	/**
	 * Retorna valor de propiedad <code>codigoSeccion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoSeccion</code>
	 */
	public java.lang.Long getCodigoSeccion(){
		return this.codigoSeccion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoSeccion</code>.
	 * @param codigoSeccion1 
	 *		El valor a establecer para la propiedad <code>codigoSeccion</code>.
	 */
	public void setCodigoSeccion( java.lang.Long codigoSeccion1 ){
		this.codigoSeccion=codigoSeccion1;
		
	}
	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Retorna valor de propiedad <code>orden</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>orden</code>
	 */
	public Integer getOrden(){
		return this.orden;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>orden</code>.
	 * @param orden1 
	 *		El valor a establecer para la propiedad <code>orden</code>.
	 */
	public void setOrden( Integer orden1 ){
		this.orden=orden1;
		
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the codigoTipoUbicacion
	 */
	public Integer getCodigoTipoUbicacion() {
		return codigoTipoUbicacion;
	}

	/**
	 * @param codigoTipoUbicacion the codigoTipoUbicacion to set
	 */
	public void setCodigoTipoUbicacion(Integer codigoTipoUbicacion) {
		this.codigoTipoUbicacion = codigoTipoUbicacion;
	}

	/**
	 * @return the valorTipoUbicacion
	 */
	public String getValorTipoUbicacion() {
		return valorTipoUbicacion;
	}

	/**
	 * @param valorTipoUbicacion the valorTipoUbicacion to set
	 */
	public void setValorTipoUbicacion(String valorTipoUbicacion) {
		this.valorTipoUbicacion = valorTipoUbicacion;
	}

	/**
	 * @return the codigoDefinicionEstructura
	 */
	public java.lang.Long getCodigoDefinicionEstructura() {
		return codigoDefinicionEstructura;
	}

	/**
	 * @param codigoDefinicionEstructura the codigoDefinicionEstructura to set
	 */
	public void setCodigoDefinicionEstructura(
			java.lang.Long codigoDefinicionEstructura) {
		this.codigoDefinicionEstructura = codigoDefinicionEstructura;
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
	 * @return the seccionDTO
	 */
	public SeccionDTO getSeccionDTO() {
		return seccionDTO;
	}

	/**
	 * @param seccionDTO the seccionDTO to set
	 */
	public void setSeccionDTO(ec.com.smx.sic.cliente.mdl.dto.SeccionDTO seccionDTO) {
		this.seccionDTO = seccionDTO;
	}

	/**
	 * @return the definicionEstructuraLogisticaDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DefinicionEstructuraLogisticaDTO getDefinicionEstructuraLogisticaDTO() {
		return definicionEstructuraLogisticaDTO;
	}

	/**
	 * @param definicionEstructuraLogisticaDTO the definicionEstructuraLogisticaDTO to set
	 */
	public void setDefinicionEstructuraLogisticaDTO(
			ec.com.smx.sic.cliente.mdl.dto.DefinicionEstructuraLogisticaDTO definicionEstructuraLogisticaDTO) {
		this.definicionEstructuraLogisticaDTO = definicionEstructuraLogisticaDTO;
	}

	/**
	 * @return the id
	 */
	public DetalleSeccionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(DetalleSeccionID id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the codigoTipoAlmacenamiento
	 */
	public Integer getCodigoTipoAlmacenamiento() {
		return codigoTipoAlmacenamiento;
	}

	/**
	 * @param codigoTipoAlmacenamiento the codigoTipoAlmacenamiento to set
	 */
	public void setCodigoTipoAlmacenamiento(Integer codigoTipoAlmacenamiento) {
		this.codigoTipoAlmacenamiento = codigoTipoAlmacenamiento;
	}

	/**
	 * @return the valorTipoAlmacenamiento
	 */
	public String getValorTipoAlmacenamiento() {
		return valorTipoAlmacenamiento;
	}

	/**
	 * @param valorTipoAlmacenamiento the valorTipoAlmacenamiento to set
	 */
	public void setValorTipoAlmacenamiento(String valorTipoAlmacenamiento) {
		this.valorTipoAlmacenamiento = valorTipoAlmacenamiento;
	}

	/**
	 * @return the tipoUbicacionDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoUbicacionDTO() {
		return tipoUbicacionDTO;
	}

	/**
	 * @param tipoUbicacionDTO the tipoUbicacionDTO to set
	 */
	public void setTipoUbicacionDTO(
			ec.com.smx.corpv2.dto.CatalogoValorDTO tipoUbicacionDTO) {
		this.tipoUbicacionDTO = tipoUbicacionDTO;
	}

	/**
	 * @return the tipoAlmacenamientoDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoAlmacenamientoDTO() {
		return tipoAlmacenamientoDTO;
	}

	/**
	 * @param tipoAlmacenamientoDTO the tipoAlmacenamientoDTO to set
	 */
	public void setTipoAlmacenamientoDTO(
			ec.com.smx.corpv2.dto.CatalogoValorDTO tipoAlmacenamientoDTO) {
		this.tipoAlmacenamientoDTO = tipoAlmacenamientoDTO;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Boolean getPlegar() {
		return plegar;
	}

	public void setPlegar(Boolean plegar) {
		this.plegar = plegar;
	}

	public Collection<DetalleSeccionDTO> getSubDetalleSeccionDTOCol() {
		return subDetalleSeccionDTOCol;
	}

	public void setSubDetalleSeccionDTOCol(
			Collection<DetalleSeccionDTO> subDetalleSeccionDTOCol) {
		this.subDetalleSeccionDTOCol = subDetalleSeccionDTOCol;
	}

	public Collection<AsignacionArticuloUnidadManejoDTO> getAsignacionArticuloUnidadManejoCol() {
		return asignacionArticuloUnidadManejoCol;
	}

	public void setAsignacionArticuloUnidadManejoCol(
			Collection<AsignacionArticuloUnidadManejoDTO> asignacionArticuloUnidadManejoCol) {
		this.asignacionArticuloUnidadManejoCol = asignacionArticuloUnidadManejoCol;
	}

	/**
	 * @return the codigoTipoSentido
	 */
	public Integer getCodigoTipoSentido() {
		return codigoTipoSentido;
	}

	/**
	 * @param codigoTipoSentido the codigoTipoSentido to set
	 */
	public void setCodigoTipoSentido(Integer codigoTipoSentido) {
		this.codigoTipoSentido = codigoTipoSentido;
	}

	/**
	 * @return the valorTipoSentido
	 */
	public String getValorTipoSentido() {
		return valorTipoSentido;
	}

	/**
	 * @param valorTipoSentido the valorTipoSentido to set
	 */
	public void setValorTipoSentido(String valorTipoSentido) {
		this.valorTipoSentido = valorTipoSentido;
	}

	
	/**
	 * 
	 * @return the valorTipoLado
	 */
	public String getValorTipoLado() {
		return valorTipoLado;
	}

	/**
	 * 
	 * @param valorTipoLado the tipo lado to set
	 */
	public void setValorTipoLado(String valorTipoLado) {
		this.valorTipoLado = valorTipoLado;
	}

	/**
	 * @return the tipoSentidoDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoSentidoDTO() {
		return tipoSentidoDTO;
	}
	
	/**
	 * @param tipoSentidoDTO the tipoSentidoDTO to set
	 */
	public void setTipoSentidoDTO(
			ec.com.smx.corpv2.dto.CatalogoValorDTO tipoSentidoDTO) {
		this.tipoSentidoDTO = tipoSentidoDTO;
	}

	/**
	 * @return the contarSubDetalleSeccion
	 */
	public Integer getContarSubDetalleSeccion() {
		return contarSubDetalleSeccion;
	}

	/**
	 * @param contarSubDetalleSeccion the contarSubDetalleSeccion to set
	 */
	public void setContarSubDetalleSeccion(Integer contarSubDetalleSeccion) {
		this.contarSubDetalleSeccion = contarSubDetalleSeccion;
	}

	/**
	 * @return the relacionSeccionPadreCol
	 */
	public Collection<RelacionSeccionDTO> getRelacionSeccionPadreCol() {
		return relacionSeccionPadreCol;
	}

	/**
	 * @param relacionSeccionPadreCol the relacionSeccionPadreCol to set
	 */
	public void setRelacionSeccionPadreCol(
			Collection<RelacionSeccionDTO> relacionSeccionPadreCol) {
		this.relacionSeccionPadreCol = relacionSeccionPadreCol;
	}

	/**
	 * @return the relacionSeccionCol
	 */
	public Collection<RelacionSeccionDTO> getRelacionSeccionCol() {
		return relacionSeccionCol;
	}

	/**
	 * @param relacionSeccionCol the relacionSeccionCol to set
	 */
	public void setRelacionSeccionCol(
			Collection<RelacionSeccionDTO> relacionSeccionCol) {
		this.relacionSeccionCol = relacionSeccionCol;
	}

	public void setSubAsignacionArticuloUnidadManejoDTOCol(
			Collection<AsignacionArticuloUnidadManejoDTO> subAsignacionArticuloUnidadManejoDTOCol) {
		this.subAsignacionArticuloUnidadManejoDTOCol = subAsignacionArticuloUnidadManejoDTOCol;
	}

	public Collection<AsignacionArticuloUnidadManejoDTO> getSubAsignacionArticuloUnidadManejoDTOCol() {
		return subAsignacionArticuloUnidadManejoDTOCol;
	}

	/**
	 * @return the caracteristicaDetalleSeccionDTOCol
	 */
	public Collection<CaracteristicaDetalleSeccionDTO> getCaracteristicaDetalleSeccionDTOCol() {
		return caracteristicaDetalleSeccionDTOCol;
	}

	/**
	 * @param caracteristicaDetalleSeccionDTOCol the caracteristicaDetalleSeccionDTOCol to set
	 */
	public void setCaracteristicaDetalleSeccionDTOCol(Collection<CaracteristicaDetalleSeccionDTO> caracteristicaDetalleSeccionDTOCol) {
		this.caracteristicaDetalleSeccionDTOCol = caracteristicaDetalleSeccionDTOCol;
	}

	public Boolean getEdicion() {
		return edicion;
	}

	public void setEdicion(Boolean edicion) {
		this.edicion = edicion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Long getCodigoUbicacion() {
		return codigoUbicacion;
	}

	public void setCodigoUbicacion(Long codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}
	
	/**
	 * @return the proveedorDetalleSeccionDTOCol
	 */
	public Collection<ProveedorDetalleSeccionDTO> getProveedorDetalleSeccionDTOCol() {
		return proveedorDetalleSeccionDTOCol;
	}

	/**
	 * @param proveedorDetalleSeccionDTOCol the proveedorDetalleSeccionDTOCol to set
	 */
	public void setProveedorDetalleSeccionDTOCol(Collection<ProveedorDetalleSeccionDTO> proveedorDetalleSeccionDTOCol) {
		this.proveedorDetalleSeccionDTOCol = proveedorDetalleSeccionDTOCol;
	}

	/**
	 * @return the npAndenDisponible
	 */
	public Boolean getNpAndenDisponible() {
		return npAndenDisponible;
	}

	/**
	 * @param npAndenDisponible the npAndenDisponible to set
	 */
	public void setNpAndenDisponible(Boolean npAndenDisponible) {
		this.npAndenDisponible = npAndenDisponible;
	}

	
	/**
	 * @return the npTieneHijos
	 */
	public Boolean getNpTieneHijos() {
		return npTieneHijos;
	}

	/**
	 * @param npTieneHijos the npTieneHijos to set
	 */
	public void setNpTieneHijos(Boolean npTieneHijos) {
		this.npTieneHijos = npTieneHijos;
	}

	/**
	 * @return the detalleRecepcionEntregaDTOCol
	 */
	public Collection<DetalleRecepcionEntregaDTO> getDetalleRecepcionEntregaDTOCol() {
		return detalleRecepcionEntregaDTOCol;
	}

	/**
	 * @param detalleRecepcionEntregaDTOCol the detalleRecepcionEntregaDTOCol to set
	 */
	public void setDetalleRecepcionEntregaDTOCol(Collection<DetalleRecepcionEntregaDTO> detalleRecepcionEntregaDTOCol) {
		this.detalleRecepcionEntregaDTOCol = detalleRecepcionEntregaDTOCol;
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
	 * @return the contenedorDTOCol
	 */
	public Collection<ContenedorDTO> getContenedorDTOCol() {
		return contenedorDTOCol;
	}

	/**
	 * @param contenedorDTOCol the contenedorDTOCol to set
	 */
	public void setContenedorDTOCol(Collection<ContenedorDTO> contenedorDTOCol) {
		this.contenedorDTOCol = contenedorDTOCol;
	}

	/**
	 * @return the codigoTipoLado
	 */
	public Integer getCodigoTipoLado() {
		return codigoTipoLado;
	}

	/**
	 * @param codigoTipoLado the codigoTipoLado to set
	 */
	public void setCodigoTipoLado(Integer codigoTipoLado) {
		this.codigoTipoLado = codigoTipoLado;
	}

	/**
	 * @return the codigoTipoArea
	 */
	public Integer getCodigoTipoArea() {
		return codigoTipoArea;
	}

	/**
	 * @param codigoTipoArea the codigoTipoArea to set
	 */
	public void setCodigoTipoArea(Integer codigoTipoArea) {
		this.codigoTipoArea = codigoTipoArea;
	}

	/**
	 * @return the valorTipoArea
	 */
	public String getValorTipoArea() {
		return valorTipoArea;
	}

	/**
	 * @param valorTipoArea the valorTipoArea to set
	 */
	public void setValorTipoArea(String valorTipoArea) {
		this.valorTipoArea = valorTipoArea;
	}

	/**
	 * @return the tipoLadoDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoLadoDTO() {
		return tipoLadoDTO;
	}

	/**
	 * @param tipoLadoDTO the tipoLadoDTO to set
	 */
	public void setTipoLadoDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoLadoDTO) {
		this.tipoLadoDTO = tipoLadoDTO;
	}

	/**
	 * @return the tipoAreaDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoAreaDTO() {
		return tipoAreaDTO;
	}

	/**
	 * @param tipoAreaDTO the tipoAreaDTO to set
	 */
	public void setTipoAreaDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoAreaDTO) {
		this.tipoAreaDTO = tipoAreaDTO;
	}

	/**
	 * @return the funcionarioPerfilDetalleSeccionDTOCol
	 */
	public Collection<FuncionarioPerfilDetalleSeccionDTO> getFuncionarioPerfilDetalleSeccionDTOCol() {
		return funcionarioPerfilDetalleSeccionDTOCol;
	}

	/**
	 * @param funcionarioPerfilDetalleSeccionDTOCol the funcionarioPerfilDetalleSeccionDTOCol to set
	 */
	public void setFuncionarioPerfilDetalleSeccionDTOCol(Collection<FuncionarioPerfilDetalleSeccionDTO> funcionarioPerfilDetalleSeccionDTOCol) {
		this.funcionarioPerfilDetalleSeccionDTOCol = funcionarioPerfilDetalleSeccionDTOCol;
	}

	/**
	 * @return the codigoTipoAsignacion
	 */
	public Integer getCodigoTipoAsignacion() {
		return codigoTipoAsignacion;
	}

	/**
	 * @param codigoTipoAsignacion the codigoTipoAsignacion to set
	 */
	public void setCodigoTipoAsignacion(Integer codigoTipoAsignacion) {
		this.codigoTipoAsignacion = codigoTipoAsignacion;
	}

	/**
	 * @return the valorTipoAsignacion
	 */
	public String getValorTipoAsignacion() {
		return valorTipoAsignacion;
	}

	/**
	 * @param valorTipoAsignacion the valorTipoAsignacion to set
	 */
	public void setValorTipoAsignacion(String valorTipoAsignacion) {
		this.valorTipoAsignacion = valorTipoAsignacion;
	}

	/**
	 * @return the detalleSeccionPadre
	 */
	public DetalleSeccionDTO getDetalleSeccionPadre() {
		return detalleSeccionPadre;
	}

	/**
	 * @param detalleSeccionPadre the detalleSeccionPadre to set
	 */
	public void setDetalleSeccionPadre(DetalleSeccionDTO detalleSeccionPadre) {
		this.detalleSeccionPadre = detalleSeccionPadre;
	}

	/**
	 * @return the balanzaDetalleSeccionDTO
	 */
	public BalanzaDetalleSeccionDTO getBalanzaDetalleSeccionDTO() {
		return balanzaDetalleSeccionDTO;
	}

	/**
	 * @param balanzaDetalleSeccionDTO the balanzaDetalleSeccionDTO to set
	 */
	public void setBalanzaDetalleSeccionDTO(BalanzaDetalleSeccionDTO balanzaDetalleSeccionDTO) {
		this.balanzaDetalleSeccionDTO = balanzaDetalleSeccionDTO;
	}

	/**
	 * @return the ordenar
	 */
	public Long getOrdenar() {
		return ordenar;
	}

	/**
	 * @param ordenar the ordenar to set
	 */
	public void setOrdenar(Long ordenar) {
		this.ordenar = ordenar;
	}

	/**
	 * @return the codigoEstadoDetalleSeccion
	 */
	public Integer getCodigoEstadoDetalleSeccion() {
		return codigoEstadoDetalleSeccion;
	}

	/**
	 * @param codigoEstadoDetalleSeccion the codigoEstadoDetalleSeccion to set
	 */
	public void setCodigoEstadoDetalleSeccion(Integer codigoEstadoDetalleSeccion) {
		this.codigoEstadoDetalleSeccion = codigoEstadoDetalleSeccion;
	}

	/**
	 * @return the estadoDetalleSeccion
	 */
	public String getEstadoDetalleSeccion() {
		return estadoDetalleSeccion;
	}

	/**
	 * @param estadoDetalleSeccion the estadoDetalleSeccion to set
	 */
	public void setEstadoDetalleSeccion(String estadoDetalleSeccion) {
		this.estadoDetalleSeccion = estadoDetalleSeccion;
	}

	/**
	 * @return the tipoEstadoDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoEstadoDTO() {
		return tipoEstadoDTO;
	}

	/**
	 * @param tipoEstadoDTO the tipoEstadoDTO to set
	 */
	public void setTipoEstadoDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoEstadoDTO) {
		this.tipoEstadoDTO = tipoEstadoDTO;
	}
	
	public Collection<DetalleTareaDTO> getDetalleTareaDTOCol() {
		return detalleTareaDTOCol;
	}

	public void setDetalleTareaDTOCol(Collection<DetalleTareaDTO> detalleTareaDTOCol) {
		this.detalleTareaDTOCol = detalleTareaDTOCol;
	}

	/**
	 * @return the secuencialDetalleSeccion
	 */
	public java.lang.Long getSecuencialDetalleSeccion() {
		return secuencialDetalleSeccion;
	}

	/**
	 * @param secuencialDetalleSeccion the secuencialDetalleSeccion to set
	 */
	public void setSecuencialDetalleSeccion(java.lang.Long secuencialDetalleSeccion) {
		this.secuencialDetalleSeccion = secuencialDetalleSeccion;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	
}