/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.INRestriction;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.articulo.adicional.ArticuloInformacionAdicionalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.auditoria.ArticuloAuditoriaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloLeyMercadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.DetalleListaDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.DetalleListaRecetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.ContenedorArticulo;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.resources.SICMessages;

/**
 * @author fmunoz
 * <b>TIPOS DE REGLAS</b>
 * 	<ul>
 *  <li>Si el art&iacute;culo tiene alcance en el local para venta se puede vender</li>
 *	<li>Si el art&iacute;culo tiene configurado un margen en el local de venta con fechas adecuadas se vende con el precio del margen,
 *  	caso contrario se vende con el precio del maestro.</li>
 *  <li>Si el art&iacute;culo tiene activado un precio de caja en el local se puede vender con ese precio, tomando como referencia un
 *  	precio base ya sea del maestro o de un margen.</li>
 *  <li>Si el art&iacute;culo tiene activado un precio de mayorista en el local se puede vender con ese precio, tomando como referencia un
 *  	precio base ya sea del maestro o de un margen.</li>
 *  <li>En un local solo puede estar activado el precio de caja o mayorista no ambos.</li> 
 *  </ul>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETARTICULO")
public class ArticuloDTO extends ArticuloTransient implements ContenedorArticulo, Cloneable
{
	@EmbeddedId
	private ArticuloID id;
	@ComparatorTypeField
	@Column(name="CODIGOTIPOARTICULO")
	private String codigoTipoArticulo;
	@ComparatorTypeField
	
	@Column(name="CODIGOCLASIFICACION")
	private String codigoClasificacion;
	@ComparatorTypeField
	@Column(name="CODIGOSUBCLASIFICACION")
	private String codigoSubClasificacion;
	@Column(name="CODIGOGRUPOALCANCE")
	private Long codigoGrupoAlcance;
	private String descripcionArticulo;
	private String leyendaArticulo;
	@ComparatorTypeField
	private String estadoArticulo;
	@ComparatorTypeField
	@Column(name="CLASEARTICULO")
	private String claseArticulo;
	@ComparatorTypeField
	@Column(name="REGISTROSANITARIO")
	private String codigoRegistroSanitario;
	@Deprecated
	private Boolean aplicaRegistroSanitario;
	private Integer cantidadRegistroSanitario;
	
	@Column(updatable=false)
	private String codigoSistemaOrigen;
	@Deprecated
	private Boolean esComercializado;
	/**
	 * c&oacute;digo del art&iacute;culo desde el cual se genera un nuevo art&iacute;culo
	 */
	@Column(name="CODIGOARTICULOORIGINAL")
	private String codigoArticuloOriginal;
	@RegisterUserIdField
	@Column(name="USUARIOCREACION")
	private String usuarioCreacion;
	@LastModifierUserIdField
	@Column(name="USUARIOACTUALIZACION")
	private String usuarioActualizacion;
	@RegisterDateField
	private Timestamp fechaCreacion;
	@LastModificationDateField
	private Timestamp fechaUltimaActualizacion;
	@Deprecated
	private Double costoBrutoArticulo;
	@Deprecated
	@Column(name="CODIGOARTICULOPADRE")
	private String codigoArticuloPadre;
	@ComparatorTypeField
	@Column(name="CODIGOESTADO")
	private String codigoEstado;
	@ComparatorTypeField
	@Column(name="VALORESTADOTRANSGENICO")
	private String valorEstadoTransgenico;
	@Column(name="CODIGOESTADOTRANSGENICO")
	private Integer codigoEstadoTransgenico;
	//Verifica transgenico
	private Boolean aplicaTransgenico;
	
	@ComparatorTypeField
	@Column(name="VALORAPLICAREGISTROSANITARIO",nullable=false)
	private String valorAplicaRegistroSanitario;
	
	@Column(name="CODIGOAPLICAREGISTROSANITARIO",nullable=false)
	private Integer codigoAplicaRegistroSanitario;
	
	@Column(name="ARTICULOPLANTILLA",nullable=true)
	private String codigoArticuloPlantilla;
	
	@Column(name = "IMPORTANCIA")
	private Integer importancia;
	
	@Column(name = "INDICADORI")
	private Boolean indicadorI;
	
	@Column(name = "CODIGOCLIENTEIMPORTACION")
	private Long codigoClienteImportacion;
	
	@Column(name="VALORTIPOESTADOREGISTRO")
	private String valorTipoEstadoRegistro;
	
	@Column(name="CODIGOBARRAS")
	private String codigoBarras;
	
	@ComparatorTypeField
	@Column(name="CODIGOBARRASPOS")
	private String codigoBarrasPOS;
	
	@ComparatorTypeField
	@Column(name="CODIGOTIPOCODIGOARTICULO")
	private String codigoTipoCodigoArticulo;
	
	@Column(name="FECHAPRIMERAENTREGA")
	private Timestamp fechaPrimeraEntrega;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloBitacoraCodigoBarrasDTO> artBitCodBarCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloAgrupadorDTO> articuloAgrupadorCol;
	
//	@ManyToOne(fetch = LAZY)
//	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
//				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
//	private ArticuloAuditoriaDTO articuloAuditoriaDTO;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloBitacoraEstadoDTO> articuloBitacoraEstadoCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloClaseDTO articuloClaseDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloComercialDTO articuloComercialDTO;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloCuotaDTO> articuloCuotaDTOSet;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloDefinicionArchivoDTO> articuloDefinicionArchivoCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloDuracionConservacionDTO> articuloDuracionConservacionCol;

	@OneToMany(mappedBy = "articuloDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloEstablecimientoDTO> articuloEstablecimientoCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloEtiquetaDTO> articuloEtiquetaCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloEtiquetaMercanciaDTO> articuloEtiquetaMercanciaCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloGarantiaDTO articuloGarantiaDTO;

	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloImpuestoDTO> articuloImpuestoCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloInformacionAdicionalDTO articuloInformacionAdicionalDTO;
		
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloInternetDTO articuloInternetDTO;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloLeyendaDTO> articuloLeyendaCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloLeyMercadoDTO articuloLeyMercadoDTO;//Entidad que maneja la informacion de los estados segun la ley de control de poder de mercado
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloLocalDTO> articuloLocalCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloLocalGestionPrecioDTO> articuloLocalGestionPrecioCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloMaterialDTO> articuloMaterialDTOs;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloMedidaDTO articuloMedidaDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		          @JoinColumn(name = "CODIGOARTICULOORIGINAL", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false)})
	private ArticuloDTO articuloOriginal;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		          @JoinColumn(name = "CODIGOARTICULOPADRE", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false)})
	@Deprecated
	private ArticuloDTO articuloPadre;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloPrecioDTO> articuloPrecioCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		          @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloProcesoLogisticoDTO articuloProcesoLogisticoDTO;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<ArticuloProveedorDTO> articuloProveedorCol;
	
	/**
	 * Art&iacute;culos relacionados secundarios
	 */
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloRelacionDTO> articuloRelacionCol;
	
	/**
	 * Art&iacute;culos relacionados principales
	 */
	@OneToMany(mappedBy = "articuloRelacion")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloRelacionDTO> articuloRelacionPadreCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloTemporadaDTO articuloTemporadaDTO;

	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloUsoDTO> articuloUsoCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloGestionPrecioDTO> campanias;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<CaracteristicaDTO> caracteristicaDTOSet;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CLASEARTICULO", referencedColumnName="CODIGOCLASEARTICULO", insertable=false, updatable=false)})
	private ClaseArticuloDTO claseArticuloDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOCLASIFICACION", referencedColumnName="CODIGOCLASIFICACION", insertable=false, updatable=false)})
	private ClasificacionDTO clasificacionDTO;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClienteArticuloDTO> clientes;
	
	@OneToMany(mappedBy = "articuloDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenedorDetalleDTO> contenedorDetalleDTOCol;
	
	@OneToMany(mappedBy = "articulo")
	private Set<DescuentoVentaArticuloDTO> descuentoVentaArticuloCol;
	
	////RELACIONES OBJETOS SIC (asistente de compras)  /////
	@OneToMany(mappedBy = "articuloDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleListaDTO> detalleListaDtoCol;
	
	@OneToMany(mappedBy = "articuloDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleListaRecetaDTO> detalleListaRecetaDtoCol;
   ////RELACIONES OBJETOS SIC (asistente de compras)  /////
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	@Transient
	private Collection<ArticuloEnvaseDTO> envases;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="IMPORTANCIA", referencedColumnName="CODIGOESTABLECIMIENTO", insertable=false, updatable=false)})
	private EstablecimientoDTO establecimientoDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOESTADO", referencedColumnName="CODIGOESTADO", insertable=false, updatable=false)})
	@Deprecated
	private EstadoCodificacionArticuloDTO estadoCodificacionArticuloDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOESTADO", referencedColumnName="CODIGOESTADO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOARTICULO", referencedColumnName="CODIGOTIPOARTICULO", insertable=false, updatable=false)})
	private EstadoTipoArticuloDTO estadoTipoArticulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORESTADOTRANSGENICO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
				  @JoinColumn(name="CODIGOESTADOTRANSGENICO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO estadoTransgenico;
	
	@OneToMany(mappedBy = "articuloDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION) 
	private Collection<ArticuloEstructuraComercialDTO> estructuraComercialClienteCol; 
	
	@OneToMany(mappedBy = "articuloDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<FrecuenciaArticuloDTO> frecuenciaArticuloCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOGRUPOALCANCE", referencedColumnName="CODIGOGRUPOTRABAJO", insertable=false, updatable=false)})
	private GrupoTrabajoDTO grupoAlcanceDTO;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RelacionArticuloRegistroSanitarioDTO> registroSanitarioCol;
	
	@OneToMany(mappedBy = "articulo")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION) 
	private Collection<SegmentoCreacionArticuloDTO> segmentoCreacionArticulos;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOSUBCLASIFICACION", referencedColumnName="CODIGOSUBCLASIFICACION", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOCLASIFICACION", referencedColumnName="CODIGOCLASIFICACION", insertable=false, updatable=false)})
	private SubClasificacionDTO subClasificacionDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOTIPOARTICULO", referencedColumnName="CODIGOTIPOARTICULO", insertable=false, updatable=false)})
	@Deprecated
	private TipoArticuloDTO tipoArticuloDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="USUARIOACTUALIZACION", referencedColumnName="USERID", insertable=false, updatable=false)
	private UserDto usuarioActualizacionDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="USUARIOCREACION", referencedColumnName="USERID", insertable=false, updatable=false)
	private UserDto usuarioCreacionDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
				  @JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloAuditoriaDTO articuloAuditoria;
	
	/**
	 * coleccion para registrar el alcance a oficinas del articulo
	 */
	@Transient
	private Collection<ArticuloLocalDTO> articuloOficinaCol;
	
	/**
	 * coleccion para registrar el alcance a bodegas del articulo
	 */
	@Transient
	private Collection<ArticuloLocalDTO> articuloBodegaCol;
	
	/**
	 * campo para determinar si un articulo es o no implemento
	 */
	@Transient	
	private String npImplemento;
	
	/**
	 * campo en el que se muestra si es o no perecible en receta
	 */
	@Transient
	private String estadoPerecibleReceta;
	
	/**
	 * Objeto que contiene el c&oacute;digo de barras activo del art&iacute;culo, &uacute;til para ser usado en nuevas transacciones sobre el art&iacute;culo
	 */
	@Transient
	private ArticuloBitacoraCodigoBarrasDTO codigoBarrasActivo;
	/**
	 * Este objeto ser&aacute; util cuando la busqueda sobre el art&iacute;culo se haya realizado en base una fecha de referencia para obtener el c&oacute;digo de barras
	 */
	@Transient
	private ArticuloBitacoraCodigoBarrasDTO codigoBarrasHistorico;
	/**
	 * Campo para busqueda IN de clasificaciones
	 */
	@INRestriction(field="codigoClasificacion")
	@Transient
	private Collection<String> npClasificaciones;
	/**
	 * Campo para busqueda IN de clases
	 */
	@INRestriction(field="claseArticulo")
	@Transient
	private Collection<String> npClases;
	
	/**
	 * Campo para busquedas IN a nivel de codigo de articulo
	 */
	@INRestriction(field="id.codigoArticulo")
	@Transient
	private Collection<String> npCodigosArticulosFiltro;
	
	@Transient
	private Map<String, Object> caracteristicaEspecial;
	
	@Transient
	private String codRefIntProv;
	
	@Transient
	private String varNombreEtiqueta; //variable usada para identificar etiqueta, en historial de cambios
	
	public ArticuloDTO(){
		this.id = new ArticuloID();
	}
	public ArticuloDTO(Boolean initID){
		this.id = new ArticuloID(initID);
	}
	/**
	 * @return the id
	 */
	public ArticuloID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloID id) {
		this.id = id;
	}
	/**
	 * @return the codigoTipoArticulo
	 */
	public String getCodigoTipoArticulo() {
		return codigoTipoArticulo;
	}
	/**
	 * @param codigoTipoArticulo the codigoTipoArticulo to set
	 */
	public void setCodigoTipoArticulo(String codigoTipoArticulo) {
		this.codigoTipoArticulo = codigoTipoArticulo;
	}
	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	/**
	 * @return the codigoSubClasificacion
	 */
	public String getCodigoSubClasificacion() {
		return codigoSubClasificacion;
	}
	/**
	 * @param codigoSubClasificacion the codigoSubClasificacion to set
	 */
	public void setCodigoSubClasificacion(String codigoSubClasificacion) {
		this.codigoSubClasificacion = codigoSubClasificacion;
	}
	
	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo != null ? descripcionArticulo.toUpperCase() : null;
	}
	/**
	 * @return the estadoArticulo
	 */
	public String getEstadoArticulo() {
		return estadoArticulo;
	}
	/**
	 * @param estadoArticulo the estadoArticulo to set
	 */
	public void setEstadoArticulo(String estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}
	/**
	 * @return the claseArticulo
	 */
	public String getClaseArticulo() {
		return claseArticulo;
	}
	/**
	 * @param claseArticulo the claseArticulo to set
	 */
	public void setClaseArticulo(String claseArticulo) {
		this.claseArticulo = claseArticulo;
	}
	/**
	 * @return the tipoArticuloDTO
	 */
	@Deprecated
	public TipoArticuloDTO getTipoArticuloDTO() {
		return tipoArticuloDTO;
	}

	/**
	 * @param tipoArticuloDTO the tipoArticuloDTO to set
	 */
	@Deprecated
	public void setTipoArticuloDTO(TipoArticuloDTO tipoArticuloDTO) {
		this.tipoArticuloDTO = tipoArticuloDTO;
	}

	/**
	 * @return the claseArticuloDTO
	 */
	public ClaseArticuloDTO getClaseArticuloDTO() {
		return claseArticuloDTO;
	}

	/**
	 * @param claseArticuloDTO the claseArticuloDTO to set
	 */
	public void setClaseArticuloDTO(ClaseArticuloDTO claseArticuloDTO) {
		this.claseArticuloDTO = claseArticuloDTO;
	}

	/**
	 * @return the subClasificacionDTO
	 */
	public SubClasificacionDTO getSubClasificacionDTO() {
		return subClasificacionDTO;
	}

	/**
	 * @param subClasificacionDTO the subClasificacionDTO to set
	 */
	public void setSubClasificacionDTO(SubClasificacionDTO subClasificacionDTO) {
		this.subClasificacionDTO = subClasificacionDTO;
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
	 * @return the fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaUltimaActualizacion
	 */
	public Timestamp getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	/**
	 * @return the clasificacionDTO
	 */
	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}
	/**
	 * @param clasificacionDTO the clasificacionDTO to set
	 */
	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}
	/**
	 * @return the articuloComercialDTO
	 */
	public ArticuloComercialDTO getArticuloComercialDTO() {
		return articuloComercialDTO;
	}
	/**
	 * @param articuloComercialDTO the articuloComercialDTO to set
	 */
	public void setArticuloComercialDTO(ArticuloComercialDTO articuloComercialDTO) {
		this.articuloComercialDTO = articuloComercialDTO;
	}
	/**
	 * @return the articuloGarantiaDTO
	 */
	public ArticuloGarantiaDTO getArticuloGarantiaDTO() {
		return articuloGarantiaDTO;
	}
	/**
	 * @param articuloGarantiaDTO the articuloGarantiaDTO to set
	 */
	public void setArticuloGarantiaDTO(ArticuloGarantiaDTO articuloGarantiaDTO) {
		this.articuloGarantiaDTO = articuloGarantiaDTO;
	}
	/**
	 * @return the articuloInternetDTO
	 */
	public ArticuloInternetDTO getArticuloInternetDTO() {
		return articuloInternetDTO;
	}
	/**
	 * @param articuloInternetDTO the articuloInternetDTO to set
	 */
	public void setArticuloInternetDTO(ArticuloInternetDTO articuloInternetDTO) {
		this.articuloInternetDTO = articuloInternetDTO;
	}
	
	/**
	 * @param articuloUnidadManejoCol the articuloUnidadManejoCol to set
	 */
	public void setArticuloUnidadManejoCol(Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoCol) {
		this.articuloUnidadManejoCol = articuloUnidadManejoCol;
	}
	/**
	 * @return the articuloUnidadManejoCol
	 */
	public Collection<ArticuloUnidadManejoDTO> getArticuloUnidadManejoCol() {
		return articuloUnidadManejoCol;
	}
	
	/**
	 * @return the articuloDefinicionArchivoCol
	 */
	public Collection<ArticuloDefinicionArchivoDTO> getArticuloDefinicionArchivoCol() {
		return articuloDefinicionArchivoCol;
	}
	/**
	 * @param articuloDefinicionArchivoCol the articuloDefinicionArchivoCol to set
	 */
	public void setArticuloDefinicionArchivoCol(Collection<ArticuloDefinicionArchivoDTO> articuloDefinicionArchivoCol) {
		this.articuloDefinicionArchivoCol = articuloDefinicionArchivoCol;
	}
	
	
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con clasificaciones
	 * @return
	 */
	public Boolean getTieneClasificacion() {
		return isLoaded(this.clasificacionDTO);
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloComercial
	 * @return
	 */
	public Boolean getTieneArticuloComercial() {
		return isLoaded(this.articuloComercialDTO);
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloEtiqueta
	 * @return
	 */
	public Boolean getTieneArticuloEtiqueta() {
		return isLoaded(this.articuloEtiquetaCol) && !this.articuloEtiquetaCol.isEmpty();
	}
	
	public Boolean getTieneArticuloEtiquetaMercnacia(){
		return isLoaded(this.articuloEtiquetaMercanciaCol) && !this.articuloEtiquetaMercanciaCol.isEmpty();
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloUso
	 * @return
	 */
	public Boolean getTieneArticuloUso() {
		return isLoaded(this.articuloUsoCol) && !this.articuloUsoCol.isEmpty();
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con los envases
	 * @return
	 */
	public Boolean getTieneEnvases() {
		return isLoaded(this.envases);
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloInternet
	 * @return
	 */
	public Boolean getTieneArticuloInternet() {
		return isLoaded(this.articuloInternetDTO);
	}
	
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloInformacionAdicional
	 * @return
	 */
	public Boolean getTieneArticuloInformacionAdicional() {
		return isLoaded(this.articuloInformacionAdicionalDTO);
	}
	
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloMedida
	 * @return
	 */
	public Boolean getTieneArticuloMedida() {
		return isLoaded(this.articuloMedidaDTO);
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloDespacho
	 * @return
	 */
	public Boolean getTieneArticuloProcesoLogistico() {
		return isLoaded(this.articuloProcesoLogisticoDTO);
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloGarantia
	 * @return
	 */
	public Boolean getTieneArticuloGarantia() {
		return isLoaded(this.articuloGarantiaDTO);
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con ArticuloTemporada
	 * @return
	 */
	public Boolean getTieneArticuloTemporada() {
		return isLoaded(this.articuloTemporadaDTO);
	}
	/**
	 * Valida si existen asignadas unidades de manejo
	 * @return
	 */
	public Boolean getTieneUnidadManejoCol() {
		return isLoaded(this.articuloUnidadManejoCol) && !CollectionUtils.isEmpty(this.articuloUnidadManejoCol);
	}
	/**
	 * Valida si existen seteadas SubClasificaciones
	 * @return
	 */
	public Boolean getTieneSubClasificacion() {
		return isLoaded(this.subClasificacionDTO);
	}
	
	/**
	 * Valida si existen seteadas SubClasificaciones
	 * @return
	 */
	public Boolean getTieneClaseArticulo() {
		return isLoaded(this.claseArticuloDTO);
	}
	
	/**
	 * Valida si existen seteadas SubClasificaciones
	 * @return
	 */
	public Boolean getTieneTipoArticulo() {
		return isLoaded(this.tipoArticuloDTO);
	}
	
	public Boolean getTieneEstadoCodificacionArticulo(){
		return isLoaded(this.estadoCodificacionArticuloDTO);
	}

	/**
	 * Valida si existen asignadas las bitacoras de c&oacute;digos de barra
	 * @return
	 */
	public Boolean getTieneArtBitCodBar() {
		return isLoaded(this.artBitCodBarCol) && !this.artBitCodBarCol.isEmpty();
	}
	/**
	 * Valida si existe la relaci&oacute;n con los precios
	 * @return
	 */
	public Boolean getTieneArticuloPrecio() {
		return isLoaded(this.articuloPrecioCol) && !this.articuloPrecioCol.isEmpty();
	}
	/**
	 * Valida si existe la relaci&oacute;n con los precios
	 * @return
	 */
	public Boolean getTieneArticuloProveedor() {
		return isLoaded(this.articuloProveedorCol) && !this.articuloProveedorCol.isEmpty();
	}
	/**
	 * Valida si existe la relaci&oacute;n con los precios
	 * @return
	 */
	public Boolean getTieneArticuloDefinicionArchivo() {
		return isLoaded(this.articuloDefinicionArchivoCol) && !this.articuloDefinicionArchivoCol.isEmpty();
	}
	/**
	 * Valida si existe la relaci&oacute;n con los descuentos de venta
	 * @return
	 */
	public Boolean getTieneDescuentoVentaArticulo(){
		return isLoaded(this.descuentoVentaArticuloCol) && !this.descuentoVentaArticuloCol.isEmpty();
	}
	/**
	 * Valida si existe la relaci&oacute;n con los registros sanitarios
	 * @return
	 */
	public Boolean getTieneRegistroSanitario(){
		return isLoaded(this.registroSanitarioCol) && !this.registroSanitarioCol.isEmpty();
	}
	
	/**
	 * @return the articuloLocalCol
	 */
	public Collection<ArticuloLocalDTO> getArticuloLocalCol() {
		return articuloLocalCol;
	}
	/**
	 * @param articuloLocalCol the articuloLocalCol to set
	 */
	public void setArticuloLocalCol(Collection<ArticuloLocalDTO> articuloLocalCol) {
		this.articuloLocalCol = articuloLocalCol;
	}
	/**
	 * Valida si existen asignados art&iacute;culos por local
	 * @return
	 */
	public Boolean getTieneArticuloLocal() {
		return isLoaded(this.articuloLocalCol);
	}
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n y existen datos en la relaci&oacute;n
	 * @return
	 */
	public Boolean getTieneArticuloImpuestoCol() {
		return isLoaded(this.articuloImpuestoCol) && !this.articuloImpuestoCol.isEmpty();
	}
	
	/**
	 * Valida si existen asignados materiales al art&iacute;culo
	 * @return
	 */
	public Boolean getTieneArticuloMaterial() {
		return isLoaded(this.articuloMaterialDTOs) && !this.articuloMaterialDTOs.isEmpty();
	}
	/**
	 * @return the codigoBarrasActivo
	 */
	public ArticuloBitacoraCodigoBarrasDTO getCodigoBarrasActivo() {
		if(this.codigoBarrasActivo == null && this.getTieneArtBitCodBar()){
			for(ArticuloBitacoraCodigoBarrasDTO abcb : this.artBitCodBarCol){
				if(abcb.getEstadoArticuloBitacora().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)){
					this.codigoBarrasActivo = abcb;
					break;
				}
			}
		}
		return codigoBarrasActivo;
	}
	
	public Boolean getTieneArticuloLeyenda(){
		return isLoaded(this.articuloLeyendaCol) && CollectionUtils.isNotEmpty(this.articuloLeyendaCol);
	}

	
	/**
	 * @return
	 */
	public Boolean getTieneArticuloClase() {
		return isLoaded(this.articuloClaseDTO);
	}
	
	public Boolean getTieneCaracteristicasCol() {
		return isLoaded(this.caracteristicaDTOSet) && !CollectionUtils.isEmpty(this.caracteristicaDTOSet);
	}

	/**
	 * @return the codigoBarrasHistorico
	 */
	public ArticuloBitacoraCodigoBarrasDTO getCodigoBarrasHistorico() {
		if(this.codigoBarrasHistorico == null && this.getTieneArtBitCodBar()){
			codigoBarrasHistorico = this.artBitCodBarCol.iterator().next();
		}
		return codigoBarrasHistorico;
	}

	/**
	 * @return the articuloPrecioCol
	 */
	public Collection<ArticuloPrecioDTO> getArticuloPrecioCol() {
		return articuloPrecioCol;
	}
	/**
	 * @param articuloPrecioCol the articuloPrecioCol to set
	 */
	public void setArticuloPrecioCol(Collection<ArticuloPrecioDTO> articuloPrecioCol) {
		this.articuloPrecioCol = articuloPrecioCol;
	}
	/**
	 * Obtiene la unidad de manejo para el art&iacute;culo con precio de caja
	 * @return
	 */
	public Integer getUnidadManejoPrecioCaja(){
		if(this.getTienePrecioCaja()){
			for(ArticuloPrecioDTO ap: articuloPrecioCol){
				if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA)){
					if(ap.getArticuloUnidadManejo() != null){
						return SICArticuloCalculo.getInstancia().calcularUnidadManejoVenta(ap.getArticuloUnidadManejo(), getPrecioBaseImp());
					}
				}
			}
		}
		return null;
	}
	/**
	 * Obtiene la cantidad m&iacute;nima de mayoreo para el art&iacute;culo
	 * @return
	 */
	public Integer getCantidadMayoreo(){
		if(this.getTienePrecioMayoreo()){
			for(ArticuloPrecioDTO ap: articuloPrecioCol){
				if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA)){
					if(ap.getArticuloUnidadManejo() != null){
						return ap.getArticuloUnidadManejo().getValorUnidadManejo();
					}
				}
			}
		}
		return null;
	}
	
	public Boolean getTienePrecioCaja(){
		return tieneTipoPrecio(SICArticuloConstantes.TIPO_PRECIO_CAJA);
	}
	
	public Boolean getTienePrecioMayoreo(){
		return tieneTipoPrecio(SICArticuloConstantes.TIPO_PRECIO_MAYORISTA);
	}
	
	private Boolean tieneTipoPrecio(String tipo){
		Boolean tieneTipoPrecio = Boolean.FALSE;
		if(this.getTieneArticuloPrecio()){
			for(ArticuloPrecioDTO ap: articuloPrecioCol){
				if(StringUtils.equals(ap.getId().getCodigoTipoPrecio(), tipo) 
						&& StringUtils.equals(ap.getEstadoPrecio(), SICConstantes.ESTADO_ACTIVO_NUMERICO)
						&& ap.getTieneArticuloUnidadManejo()
						&& StringUtils.equals(ap.getArticuloUnidadManejo().getEstadoUnidadManejo(), SICConstantes.ESTADO_ACTIVO_NUMERICO)
						&& ap.getArticuloUnidadManejo().getTieneUsoVenta()){
					tieneTipoPrecio = Boolean.TRUE;
					break;
				}
			}
		}
		return tieneTipoPrecio;
	}
	
	/**
	 * Indica si el art&iacute;culo tiene precio de caja en el local relacionado
	 * @return
	 */
	public Boolean getHabilitadoPrecioCaja(){
		Boolean habilitadoPrecioCaja = Boolean.FALSE;
		EnumTipoPrecio enumTipoPrecio = this.getEnumTipoPrecio();
		if(enumTipoPrecio != null && enumTipoPrecio.compareTo(EnumTipoPrecio.PRECIO_CAJA) == 0 && this.tieneTipoPrecio(SICArticuloConstantes.TIPO_PRECIO_CAJA)){
			habilitadoPrecioCaja = Boolean.TRUE;
		}
		return habilitadoPrecioCaja;
	}
	/**
	 * Indica si el art&iacute;culo tiene precio de mayoreo en el local relacionado
	 * @return
	 */
	public Boolean getHabilitadoPrecioMayoreo(){
		Boolean habilitadoPrecioMayorista = Boolean.FALSE;
		EnumTipoPrecio enumTipoPrecio = this.getEnumTipoPrecio();
		if(enumTipoPrecio != null && enumTipoPrecio.compareTo(EnumTipoPrecio.PRECIO_MAYORISTA) == 0 && this.tieneTipoPrecio(SICArticuloConstantes.TIPO_PRECIO_MAYORISTA)){
			habilitadoPrecioMayorista = Boolean.TRUE;
		}
		return habilitadoPrecioMayorista;
	}
	
	private Double obtenerPrecio(String tipo){
		if(getTieneArticuloPrecio()){
			for(ArticuloPrecioDTO ap : articuloPrecioCol){
				if(ap.getId().getCodigoTipoPrecio().equals(tipo)){
					return ap.getValorActualCalculado();
				}
			}
		}
		return null;
	}
	
	private Double obtenerPrecioNoAfiliado(String tipo){
		if(getTieneArticuloPrecio()){
			for(ArticuloPrecioDTO ap : articuloPrecioCol){
				if(ap.getId().getCodigoTipoPrecio().equals(tipo)){
					return ap.getValorActualNA();
				}
			}
		}
		return null;
	}
	
	private Double obtenerPrecioImpuesto(String tipo,Boolean esValorActual){
		if(getTieneArticuloPrecio()){
			for(ArticuloPrecioDTO ap : articuloPrecioCol){
				if(ap.getId().getCodigoTipoPrecio().equals(tipo)){
					if(esValorActual){
						return ap.getValorActualImp();
					}
					return ap.getValorAnteriorImp();
				}
			}
		}
		return null;
	}
	
	private Double obtenerPrecioNoAfiliadoImpuesto(String tipo,Boolean esValorActual){
		if(getTieneArticuloPrecio()){
			for(ArticuloPrecioDTO ap : articuloPrecioCol){
				if(ap.getId().getCodigoTipoPrecio().equals(tipo)){
					if(esValorActual){
						return ap.getValorActualNAImp();
					}
					return ap.getValorAnteriorNAImp();
				}
			}
		}
		return null;
	}
	
	public Double getPVP(){
		return obtenerPrecio(SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP);
	}
	public Double getPVPImp(){
		return obtenerPrecioImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP,Boolean.TRUE);
	}
	
	public Double getPrecioBase(){
		return obtenerPrecio(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE);
	}
	public Double getPrecioBaseImp(){
		return obtenerPrecioImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE,Boolean.TRUE);
	}
	
	public Double getPrecioFinalCupon(){
		Double valorCalculado = null;
		DescuentoVentaArticuloDTO descuentoVentaArticuloDTO = this.getDescuentoVentaCupon();
		if(this.getTieneArticuloRelacionado() && this.getArticuloRelacionCol().size() == 1 && descuentoVentaArticuloDTO != null){
			ArticuloRelacionDTO articuloRelacionDTO = this.getArticuloRelacionCol().iterator().next();				
			if(descuentoVentaArticuloDTO.getValorDescuento() != null && descuentoVentaArticuloDTO.getValorDescuento() > 0){
				valorCalculado = SICUtil.getInstance().roundNumber((articuloRelacionDTO.getArticuloRelacion().getPrecioBaseImp() - descuentoVentaArticuloDTO.getValorDescuento()), SICConstantes.getInstancia().CANTIDADDECIMALFINAL);
			}else if(descuentoVentaArticuloDTO.getPorcentajeDescuento() != null){
				valorCalculado = SICUtil.getInstance().roundNumber((articuloRelacionDTO.getArticuloRelacion().getPrecioBaseImp() * (1 - descuentoVentaArticuloDTO.getPorcentajeDescuento()/100)), SICConstantes.getInstancia().CANTIDADDECIMALFINAL);
			}			
		}else {
			valorCalculado = this.getPrecioBaseImp();
		}		
		return valorCalculado;
	}
	
	public DescuentoVentaArticuloDTO getDescuentoVentaCupon(){
		if(this.getTieneDescuentoVentaArticulo()){
			
			for(DescuentoVentaArticuloDTO descuentoVentaArticuloDTO : this.getDescuentoVentaArticuloCol()){
				
				if(StringUtils.equals(descuentoVentaArticuloDTO.getAsignacionTipoDescuento().getCodigoTipoDescuento(), SICArticuloConstantes.getInstancia().TIPODESCUENTO_CUPON)
						&& StringUtils.equals(descuentoVentaArticuloDTO.getAsignacionTipoDescuento().getValorAplicacionTipoDescuento(), EnumTipoAplicacionDescuento.VENTA.getValorTipoAplicacionDescuento())
						&& StringUtils.equals(descuentoVentaArticuloDTO.getEstado(), SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)){
					return  descuentoVentaArticuloDTO;
				}
			}
		}
		return null;
	}
	public Double getPrecioBaseNoAfi(){
		return obtenerPrecioNoAfiliado(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE);
	}
	public Double getPrecioBaseNoAfiImp(){
		return obtenerPrecioNoAfiliadoImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE,Boolean.TRUE);
	}
	
	public Double getPrecioBaseAnteriorImp(){
		return obtenerPrecioImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE,Boolean.FALSE);
	}	
	
	public Double getPrecioBaseAnteriorNoAfiImp(){
		return obtenerPrecioNoAfiliadoImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE,Boolean.FALSE);
	}
	
	public Double getPrecioCaja(){
		return obtenerPrecio(SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA);
	}
	public Double getPrecioCajaImp(){
		return obtenerPrecioImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA,Boolean.TRUE);
	}
	public Double getPrecioCajaNoAfi(){
		return obtenerPrecioNoAfiliado(SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA);
	}
	public Double getPrecioCajaNoAfiImp(){
		return obtenerPrecioNoAfiliadoImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA,Boolean.TRUE);
	}
	
	public Double getPrecioMayorista(){
		return obtenerPrecio(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA);
	}
	public Double getPrecioMayoristaImp(){
		return obtenerPrecioImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA,Boolean.TRUE);
	}
	public Double getPrecioMayoristaNoAfi(){
		return obtenerPrecioNoAfiliado(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA);
	}
	public Double getPrecioMayoristaNoAfiImp(){
		return obtenerPrecioNoAfiliadoImpuesto(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA,Boolean.TRUE);
	}
	
	/**
	 * Obtiene el valor total del I.V.A. en la venta, es ncesario que est&aacute; cargada la relaci&oacute;n con los impuestos
	 * @return
	 */
	public Double getTotalIVAVenta(){
		Double total = 0d;
		for(ArticuloImpuestoDTO ai : articuloImpuestoCol){
			if(ai.getTipoImpuestoArticulo().getCodigoGrupoImpuesto().equals(SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_IVA)
					&& ai.getEstadoArticuloImpuesto().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO) && ai.getEsParaVenta())
				total = total + ai.getTipoImpuestoArticulo().getPorcentajeImpuesto();
		}
		return total;
	}
	
	/**
	 * Obtiene el valor total del I.V.A. en la compra, es ncesario que est&aacute; cargada la relaci&oacute;n con los impuestos
	 * @return
	 */
	public Double getTotalIVACompra(){
		Double total = 0d;
		for(ArticuloImpuestoDTO ai : articuloImpuestoCol){
			if(ai.getTipoImpuestoArticulo().getCodigoGrupoImpuesto().equals(SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_IVA)
					&& ai.getEstadoArticuloImpuesto().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO) && ai.getEsParaCompra())
				total = total + ai.getTipoImpuestoArticulo().getPorcentajeImpuesto();
		}
		return total;
	}
	
	/**
	 * Verifica si el articulo tiene I.V.A. en la compra
	 * @return
	 */
	public Boolean getTieneIVACompra(){
		return getTotalIVACompra() > 0 ? Boolean.TRUE :Boolean.FALSE;
	}
	
	/**
	 * Verifica si el articulo tiene I.V.A. en la venta
	 * @return
	 */
	public Boolean getTieneIVAVenta(){
		return getTotalIVAVenta() > 0 ? Boolean.TRUE : Boolean.FALSE;
	}
	
	/**
	 * Obtiene el valor total de los impuestos para venta, es necsario que est&aacute; cargada la relaci&oacute;n con los impuestos
	 * @return
	 */
	public Map<String, Double> getTotalImpuestosVenta(){
		return getTotalImpuestos(Boolean.TRUE);
	}
	
	/**
	 * Obtiene el valor total de los impuestos para la compra, es necsario que est&aacute; cargada la relaci&oacute;n con los impuestos
	 * @return
	 */
	public Map<String, Double> getTotalImpuestosCompra(){
		return getTotalImpuestos(Boolean.FALSE);
	}
	
	/**
	 * Obtiene el valor total de los impuestos, es necsario que est&aacute; cargada la relaci&oacute;n con los impuestos
	 * @param  esParaVenta	- Indicador para obtener los tipos de impuesto para venta/compra
	 * @return
	 */
	private Map<String, Double> getTotalImpuestos(Boolean esParaVenta){
		return SICArticuloCalculo.getInstancia().obtenerValoresImpuesto(this, esParaVenta);
	}
	
	/**
	 * Determina si el art&iacute;culo tiene impuestos en general
	 * @return
	 */
	public Boolean getAplicaImpuestos(){
		if(articuloImpuestoCol != null && !isLazy(articuloImpuestoCol)){
			for(ArticuloImpuestoDTO ai : articuloImpuestoCol){
				if(ai.getEstadoArticuloImpuesto().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO))
					return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		return null;
	}
	
	/**
	 * Determina si el art&iacute;culo tiene impuestos en la compra
	 * @return
	 */
	public Boolean getAplicaImpuestoCompra(){
		if(articuloImpuestoCol != null && !isLazy(articuloImpuestoCol)){
			for(ArticuloImpuestoDTO ai : articuloImpuestoCol){
				if(ai.getEstadoArticuloImpuesto().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO) && ai.getEsParaCompra())
					return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		return null;
	}
	
	/**
	 * Determina si el art&iacute;culo tiene impuestos en la venta
	 * @return
	 */
	public Boolean getAplicaImpuestoVenta(){
		if(articuloImpuestoCol != null && !isLazy(articuloImpuestoCol)){
			for(ArticuloImpuestoDTO ai : articuloImpuestoCol){
				if(ai.getEstadoArticuloImpuesto().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO) && ai.getEsParaVenta())
					return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		return null;
	}
	
	/**
	 * Obtiene el tipo de calculo para obtener el precio total de venta de un art&iacute;culo
	 * @return
	 * 		0 = PRECIO X CANTIDAD <br/>
	 * 		1 = PRECIO X CANTIDAD X PESO <br/>
	 * 		2 = PRECIO X PESOTOTAL <br/>
	 */
	public String getTipoCalculoPrecio(){
		if(getTieneArticuloComercial()){
			if(articuloComercialDTO.getValorTipoControlCosto().equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPES)
					|| articuloComercialDTO.getValorTipoControlCosto().equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PESPES)
					|| articuloComercialDTO.getValorTipoControlCosto().equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPESUM)){
				if(articuloComercialDTO.getPesoAproximadoVenta() != null && articuloComercialDTO.getPesoAproximadoVenta() > 0){
					return SICArticuloConstantes.getInstancia().TIPOCALCULOPRECIOCANTIDADPESO;
				}
				return SICArticuloConstantes.getInstancia().TIPOCALCULOPRECIOPESO;
			}
			return SICArticuloConstantes.getInstancia().TIPOCALCULOPRECIOCANTIDAD;
		}
		return null;
	}
	
	/**
	 * @return the articuloImpuestoCol
	 */
	public Collection<ArticuloImpuestoDTO> getArticuloImpuestoCol() {
		return articuloImpuestoCol;
	}
	/**
	 * @param articuloImpuestoCol the articuloImpuestoCol to set
	 */
	public void setArticuloImpuestoCol(Collection<ArticuloImpuestoDTO> articuloImpuestoCol) {
		this.articuloImpuestoCol = articuloImpuestoCol;
	}
	/**
	 * @return the articuloTemporadaDTO
	 */
	public ArticuloTemporadaDTO getArticuloTemporadaDTO() {
		return articuloTemporadaDTO;
	}
	/**
	 * @param articuloTemporadaDTO the articuloTemporadaDTO to set
	 */
	public void setArticuloTemporadaDTO(ArticuloTemporadaDTO articuloTemporadaDTO) {
		this.articuloTemporadaDTO = articuloTemporadaDTO;
	}
	/**
	 * @return the articuloMedidaDTO
	 */
	public ArticuloMedidaDTO getArticuloMedidaDTO() {
		return articuloMedidaDTO;
	}
	/**
	 * @param articuloMedidaDTO the articuloMedidaDTO to set
	 */
	public void setArticuloMedidaDTO(ArticuloMedidaDTO articuloMedidaDTO) {
		this.articuloMedidaDTO = articuloMedidaDTO;
	}

	/**
	 * @return the descuentoVentaArticuloCol
	 */
	public Set<DescuentoVentaArticuloDTO> getDescuentoVentaArticuloCol() {
		return descuentoVentaArticuloCol;
	}
	/**
	 * @param descuentoVentaArticuloCol the descuentoVentaArticuloCol to set
	 */
	public void setDescuentoVentaArticuloCol(Set<DescuentoVentaArticuloDTO> descuentoVentaArticuloCol) {
		this.descuentoVentaArticuloCol = descuentoVentaArticuloCol;
	}
	/**
	 * @return the codigoRegistroSanitario
	 */
	public String getCodigoRegistroSanitario() {
		return codigoRegistroSanitario;
	}
	/**
	 * @param codigoRegistroSanitario the codigoRegistroSanitario to set
	 */
	public void setCodigoRegistroSanitario(String codigoRegistroSanitario) {
		this.codigoRegistroSanitario = codigoRegistroSanitario;
	}
	/**
	 * @return the aplicaRegistroSanitario
	 */
	public Boolean getAplicaRegistroSanitario() {
		return aplicaRegistroSanitario;
	}
	/**
	 * @param aplicaRegistroSanitario the aplicaRegistroSanitario to set
	 */
	public void setAplicaRegistroSanitario(Boolean aplicaRegistroSanitario) {
		this.aplicaRegistroSanitario = aplicaRegistroSanitario;
	}
	/**
	 * @return the registroSanitarioCol
	 */
	public Collection<RelacionArticuloRegistroSanitarioDTO> getRegistroSanitarioCol() {
		return registroSanitarioCol;
	}
	/**
	 * @param registroSanitarioCol the registroSanitarioCol to set
	 */
	public void setRegistroSanitarioCol(Collection<RelacionArticuloRegistroSanitarioDTO> registroSanitarioCol) {
		this.registroSanitarioCol = registroSanitarioCol;
	}
	public Collection<ArticuloProveedorDTO> getArticuloProveedorCol() {
		return articuloProveedorCol;
	}
	public void setArticuloProveedorCol(
			Collection<ArticuloProveedorDTO> articuloProveedorCol) {
		this.articuloProveedorCol = articuloProveedorCol;
	}
	/**
	 * @return the articuloEtiquetaCol
	 */
	public Collection<ArticuloEtiquetaDTO> getArticuloEtiquetaCol() {
		return articuloEtiquetaCol;
	}
	/**
	 * @param articuloEtiquetaCol the articuloEtiquetaCol to set
	 */
	public void setArticuloEtiquetaCol(Collection<ArticuloEtiquetaDTO> articuloEtiquetaCol) {
		this.articuloEtiquetaCol = articuloEtiquetaCol;
	}
	/**
	 * @return the articuloUsoCol
	 */
	public Collection<ArticuloUsoDTO> getArticuloUsoCol() {
		return articuloUsoCol;
	}
	/**
	 * @param articuloUsoCol the articuloUsoCol to set
	 */
	public void setArticuloUsoCol(Collection<ArticuloUsoDTO> articuloUsoCol) {
		this.articuloUsoCol = articuloUsoCol;
	}
	/**
	 * @return the codigoSistemaOrigen
	 */
	public String getCodigoSistemaOrigen() {
		return codigoSistemaOrigen;
	}
	/**
	 * @param codigoSistemaOrigen the codigoSistemaOrigen to set
	 */
	public void setCodigoSistemaOrigen(String codigoSistemaOrigen) {
		this.codigoSistemaOrigen = codigoSistemaOrigen;
	}
	/**
	 * @return the esComercializado
	 */
	@Deprecated
	public Boolean getEsComercializado() {
		return esComercializado;
	}
	/**
	 * @param esComercializado the esComercializado to set
	 */
	@Deprecated
	public void setEsComercializado(Boolean esComercializado) {
		this.esComercializado = esComercializado;
	}
	public Collection<ArticuloBitacoraCodigoBarrasDTO> getArtBitCodBarCol() {
		return artBitCodBarCol;
	}
	public void setArtBitCodBarCol(
			Collection<ArticuloBitacoraCodigoBarrasDTO> artBitCodBarCol) {
		this.artBitCodBarCol = artBitCodBarCol;
	}
	/**
	 * @return the articuloMaterialDTOs
	 */
	public Collection<ArticuloMaterialDTO> getArticuloMaterialDTOs() {
		return articuloMaterialDTOs;
	}
	/**
	 * @param articuloMaterialDTOs the articuloMaterialDTOs to set
	 */
	public void setArticuloMaterialDTOs(Collection<ArticuloMaterialDTO> articuloMaterialDTOs) {
		this.articuloMaterialDTOs = articuloMaterialDTOs;
	}
	/**
	 * @param codigoBarrasActivo the codigoBarrasActivo to set
	 */
	public void setCodigoBarrasActivo(ArticuloBitacoraCodigoBarrasDTO codigoBarrasActivo) {
		this.codigoBarrasActivo = codigoBarrasActivo;
	}
	public Collection<FrecuenciaArticuloDTO> getFrecuenciaArticuloCol() {
		return frecuenciaArticuloCol;
	}
	public void setFrecuenciaArticuloCol(
			Collection<FrecuenciaArticuloDTO> frecuenciaArticuloCol) {
		this.frecuenciaArticuloCol = frecuenciaArticuloCol;
	}
	/**
	 * @return the codigoArticuloOriginal
	 */
	public String getCodigoArticuloOriginal() {
		return codigoArticuloOriginal;
	}
	/**
	 * @param codigoArticuloOriginal the codigoArticuloOriginal to set
	 */
	public void setCodigoArticuloOriginal(String codigoArticuloOriginal) {
		this.codigoArticuloOriginal = codigoArticuloOriginal;
	}
	
	
	
	/**
	 * @return the estructuraComercialClienteCol
	 */
	public Collection<ArticuloEstructuraComercialDTO> getEstructuraComercialClienteCol() {
		return estructuraComercialClienteCol;
	}
	/**
	 * @param estructuraComercialClienteCol the estructuraComercialClienteCol to set
	 */
	public void setEstructuraComercialClienteCol(Collection<ArticuloEstructuraComercialDTO> estructuraComercialClienteCol) {
		this.estructuraComercialClienteCol = estructuraComercialClienteCol;
	}
	@Deprecated
	public ArticuloDTO getArticuloPadre() {
		return articuloPadre;
	}
	@Deprecated
	public void setArticuloPadre(ArticuloDTO articuloPadre) {
		this.articuloPadre = articuloPadre;
	}
	@Deprecated
	public String getCodigoArticuloPadre() {
		return codigoArticuloPadre;
	}
	@Deprecated
	public void setCodigoArticuloPadre(String codigoArticuloPadre) {
		this.codigoArticuloPadre = codigoArticuloPadre;
	}	
	
	public Collection<ArticuloRelacionDTO> getArticuloRelacionCol() {
		return articuloRelacionCol;
	}
	public void setArticuloRelacionCol(
			Collection<ArticuloRelacionDTO> articuloRelacionCol) {
		this.articuloRelacionCol = articuloRelacionCol;
	}
	
	public String getLeyendaArticulo() {
		return leyendaArticulo;
	}
	public void setLeyendaArticulo(String leyendaArticulo) {
		this.leyendaArticulo = leyendaArticulo;
	}

	
	/**
	 * @return the articuloDuracionConservacionCol
	 */
	public Collection<ArticuloDuracionConservacionDTO> getArticuloDuracionConservacionCol() {
		return articuloDuracionConservacionCol;
	}
	/**
	 * @param articuloDuracionConservacionCol the articuloDuracionConservacionCol to set
	 */
	public void setArticuloDuracionConservacionCol(Collection<ArticuloDuracionConservacionDTO> articuloDuracionConservacionCol) {
		this.articuloDuracionConservacionCol = articuloDuracionConservacionCol;
	}
	
	public Boolean getTieneArticuloDuracionConservacion(){
		return isLoaded(articuloDuracionConservacionCol) && !articuloDuracionConservacionCol.isEmpty();
	}
	/**
	 * @return the npClasificaciones
	 */
	public Collection<String> getNpClasificaciones() {
		return npClasificaciones;
	}
	/**
	 * @param npClasificaciones the npClasificaciones to set
	 */
	public void setNpClasificaciones(Collection<String> npClasificaciones) {
		this.npClasificaciones = npClasificaciones;
	}
	/**
	 * @return the npClases
	 */
	public Collection<String> getNpClases() {
		return npClases;
	}
	/**
	 * @param npClases the npClases to set
	 */
	public void setNpClases(Collection<String> npClases) {
		this.npClases = npClases;
	}
	/**
	 * @return the articuloCuotaDTOSet
	 */
	public Collection<ArticuloCuotaDTO> getArticuloCuotaDTOSet() {
		return articuloCuotaDTOSet;
	}
	/**
	 * @param articuloCuotaDTOSet the articuloCuotaDTOSet to set
	 */
	public void setArticuloCuotaDTOSet(Collection<ArticuloCuotaDTO> articuloCuotaDTOSet) {
		this.articuloCuotaDTOSet = articuloCuotaDTOSet;
	}
	/**
	 * @return the caracteristicaDTOSet
	 */
	public Collection<CaracteristicaDTO> getCaracteristicaDTOSet() {
		return caracteristicaDTOSet;
	}
	/**
	 * @param caracteristicaDTOSet the caracteristicaDTOSet to set
	 */
	public void setCaracteristicaDTOSet(Collection<CaracteristicaDTO> caracteristicaDTOSet) {
		this.caracteristicaDTOSet = caracteristicaDTOSet;
	}
	
	public Collection<String> getNpCodigosArticulosFiltro() {
		return npCodigosArticulosFiltro;
	}
	public void setNpCodigosArticulosFiltro(
			Collection<String> npCodigosArticulosFiltro) {
		this.npCodigosArticulosFiltro = npCodigosArticulosFiltro;
	}	
	
	/////////////////////////
	////	METODOS SISPE
	////////////////////////	
	
	
	/**
	 * Metodo que me permite devolver el codigo del departamento-descripcion de un articulo
	 * @return
	 */
	public String getNpDepartamento() {
		if(this.getTieneClasificacion() && this.clasificacionDTO.getTieneClasificacionPadre()){
			return this.clasificacionDTO.getClasificacionPadre().getId().getCodigoClasificacion().concat("-").concat(this.clasificacionDTO.getClasificacionPadre().getDescripcionClasificacion());
		}
		return null;
	}

	/**
	 * Metodo que me permite devolver el tipo de bodega
	 * @return
	 */
	public String getNpTipoBodega() {
		if(this.getTieneClasificacion() && this.getClasificacionDTO().getTieneBodegaDTO()){
			return this.getClasificacionDTO().getBodegaDTO().getTipoBodega();
		}
		return null;
	}
	
	/**
	 * Metodo que me permite devolver si un articulo es implemento '1' y caso contrario '0'
	 * @return
	 */
	public String getNpImplemento() {
		if(npImplemento == null){
			ParametroDTO parametroDTO = new ParametroDTO();
			parametroDTO.getId().setCodigoParametro(SICMessages.getInstancia().getString("ec.com.smx.sic.parametro.codigoArticuloImplemento"));
			parametroDTO.getId().setCodigoCompania(this.id.getCodigoCompania());
			parametroDTO = SICFactory.getInstancia().administracion.getDataService().findUnique(parametroDTO);
			String codClasImplArray[] = parametroDTO.getValorParametro().split(",") ;
			for(String codClasImpl:codClasImplArray){
				if(StringUtils.equals(this.codigoClasificacion,codClasImpl)){
					this.npImplemento = SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO;
					break;
				}
				this.npImplemento = SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO;
			}
		}		
		return npImplemento;
	}
	
	public void setNpImplemento(String npImplemento) {
		this.npImplemento = npImplemento;
	}
	
	/**
	 * Metodo que me retorna '1' si un articulo es perecible en receta y '0' si no es perecible en receta
	 * @return
	 */
	public String getEstadoPerecibleReceta() {
		if(estadoPerecibleReceta == null){
			CaracteristicaDinamicaDTO caracteristicaDinamicaDTO = new CaracteristicaDinamicaDTO();
			caracteristicaDinamicaDTO.setCodigoTipoCaracteristica(TipoCatalogoArticulo.CARACTERISTICA_NOPERMITIDOENRECETA);
			caracteristicaDinamicaDTO.setCodigoClasificacion(codigoClasificacion);
			caracteristicaDinamicaDTO = SICFactory.getInstancia().administracion.getDataService().findUnique(caracteristicaDinamicaDTO);
			if(caracteristicaDinamicaDTO != null){
				this.estadoPerecibleReceta = SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO;
			}else{
				this.estadoPerecibleReceta = SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO;
			}
		}
		return estadoPerecibleReceta;
	}
	
	public void setEstadoPerecibleReceta(String estadoPerecibleReceta) {
		this.estadoPerecibleReceta = estadoPerecibleReceta;
	}
	
	/**
	 * Metodo que me devuelve el codigo del tipo de descuento de un articulo y en caso de no tenerlo retorna '0'
	 * @return
	 */
	public String getNpCodigoTipoDescuento() {
		if(getTieneClasificacion() && this.clasificacionDTO.getTieneTipoDescuentoClasificacion()){
			if(!CollectionUtils.isEmpty(this.clasificacionDTO.getTipoDescuentoClasificacionCol())){
				return this.clasificacionDTO.getTipoDescuentoClasificacionCol().iterator().next().getId().getCodigoTipoDescuento();
			}
			return SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO;
		}
		return null;
	}
	
	/**
	 * Metodo que me retorna la imagen de un articulo
	 * @return
	 */
	public byte[] getDatoImagen(){
		byte[] imagen = null;
		for(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO: this.articuloDefinicionArchivoCol){
			if(articuloDefinicionArchivoDTO.getTieneArticuloArchivo() && StringUtils.equals(articuloDefinicionArchivoDTO.getValorTipoArchivo(),SICConstantes.getInstancia().IMAGEN_GENERAL)){
				return articuloDefinicionArchivoDTO.getArticuloArchivo().getContenidoArchivo();
			}
		}
		return imagen;		
	}
	
	/**
	 * Metodo que me retorna la imagen de codigo de barras de un articulo
	 * @return
	 */
	public byte[] getDatoImagenCodigoBarras(){
		byte[] imagenCodigoBarras = null;
		for(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO: this.articuloDefinicionArchivoCol){
			if(articuloDefinicionArchivoDTO.getTieneArticuloArchivo() && StringUtils.equals(articuloDefinicionArchivoDTO.getValorTipoArchivo(),SICConstantes.getInstancia().IMAGEN_CODIGO_BARRAS)){
				return articuloDefinicionArchivoDTO.getArticuloArchivo().getContenidoArchivo();
			}
		}
		return imagenCodigoBarras;
	}
	
	/**
	 * Metodo que me retorna la imagen del regitro sanitario de un articulo
	 * @return
	 */
	public byte[] getDatoImagenRegistroSanitario(){
		byte[] imagenRegistroSanitario = null;
		for(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO: this.articuloDefinicionArchivoCol){
			if(articuloDefinicionArchivoDTO.getTieneArticuloArchivo() && StringUtils.equals(articuloDefinicionArchivoDTO.getValorTipoArchivo(),SICConstantes.getInstancia().IMAGEN_REGISTRO_SANITARIO)){
				return articuloDefinicionArchivoDTO.getArticuloArchivo().getContenidoArchivo();
			}
		}
		return imagenRegistroSanitario;		
	}
	
	/**
	 * Metodo que me retorna el documento de registro sanitario
	 * @return
	 */
	public byte[] getDatoDocumentoRegistroSanitario(){
		byte[] resultado = null;
		for(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO: this.articuloDefinicionArchivoCol){
			if(articuloDefinicionArchivoDTO.getTieneArticuloArchivo() && StringUtils.equals(articuloDefinicionArchivoDTO.getValorTipoArchivo(),SICConstantes.getInstancia().DOCUMENTO_REGISTRO_SANITARIO)){
				return articuloDefinicionArchivoDTO.getArticuloArchivo().getContenidoArchivo();
			}
		}
		return resultado;		
	}
	
	/**
	 * Metodo que me retorna los codigos de referencia de los articulos por proveedor separados por ',' 
	 * @return
	 */
	public String getCodigoInternoProveedor(){
		StringBuilder codigosInterProveedor = new StringBuilder();
		if(CollectionUtils.isNotEmpty(this.getArticuloProveedorCol())){
			for(ArticuloProveedorDTO articuloProveedorDTO : this.getArticuloProveedorCol()){
				if(StringUtils.isNotEmpty(articuloProveedorDTO.getCodigoReferenciaProveedor())){
					codigosInterProveedor.append(articuloProveedorDTO.getCodigoReferenciaProveedor());
					if(this.getArticuloProveedorCol().size() > 1){
						codigosInterProveedor.append(", ");
					}
				}
			}
			return codigosInterProveedor.toString();
		}
		return null;
	}
	
	/**
	 * Metodo que me devuelve los codigosJde de un proveedor'-'nombre de proveedor separados por ','
	 * @return
	 */
	public String getCodigoNombreProveedores(){
		if(getTieneArticuloProveedor()){
			StringBuilder codigoNombreProveedores =new StringBuilder();
			if(this.getArticuloProveedorCol().size() > 1){
				for(ArticuloProveedorDTO articuloProveedorDTO : this.getArticuloProveedorCol()){
					codigoNombreProveedores.append(articuloProveedorDTO.getVistaProveedor().getCodigoJDEProveedor()).append("-").append(articuloProveedorDTO.getVistaProveedor().getNombreProveedor());
					codigoNombreProveedores.append(", ");
				}
				return codigoNombreProveedores.toString();
			}
			ArticuloProveedorDTO articuloProveedorDTO = this.getArticuloProveedorCol().iterator().next();
			codigoNombreProveedores.append(articuloProveedorDTO.getVistaProveedor().getCodigoJDEProveedor()).append("-").append(articuloProveedorDTO.getVistaProveedor().getNombreProveedor());
			return codigoNombreProveedores.toString();
		}
		return null;		
	}
	
	/**
	 * M&eacute;todo que me retorna el c&oacute;digo de referencia del primer proveedor
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getCodigoReferenciaExternaProveedorPrincipal(){
		Collection<ArticuloProveedorDTO> apCol = ColeccionesUtil.sort(this.getArticuloProveedorCol(), ColeccionesUtil.ORDEN_ASC, "fechaRegistro");
		for(ArticuloProveedorDTO dto : apCol){
			if(StringUtils.isNotEmpty(dto.getCodigoReferenciaProveedor()) && StringUtils.equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO, dto.getEstadoArticuloProveedor())){
				return dto.getCodigoReferenciaProveedor();
			}
		}
		return null;
	}
	
	/**
	 * @return the unidadManejo
	 */
	public Integer getUnidadManejo() {
		if(getTieneUnidadManejoCol()){
			for(ArticuloUnidadManejoDTO dto : articuloUnidadManejoCol){
				if(esUnidadManejoDespacho(dto) && dto.getPrioridad()!=null && dto.getPrioridad().intValue() == 1 && dto.getEstadoUnidadManejo().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO))
					return dto.getValorUnidadManejo();
			}
		}
		return null;
	}
	
	private Boolean esUnidadManejoDespacho(ArticuloUnidadManejoDTO aum){
		for(ArticuloUnidadManejoUsoDTO dto : aum.getArticuloUnidadManejoUsoCol()){
			if(dto.getId().getValorTipoUso().equals(SICArticuloConstantes.getInstancia().VALORUSOUNIMANDESPACHO) && SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(dto.getEstado()))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * @return the unidadManejoVenta
	 */
	public Integer getUnidadManejoVentaPorPrioridad() {
		if(getTieneUnidadManejoCol()){
			articuloUnidadManejoCol = ColeccionesUtil.sort(articuloUnidadManejoCol, ColeccionesUtil.ORDEN_ASC, "prioridad");
			for(ArticuloUnidadManejoDTO dto : articuloUnidadManejoCol){
				if(dto.getPrioridad()!=null 
						&& SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(dto.getEstadoUnidadManejo()) && dto.getTieneUsoVenta()
						&& !StringUtils.equals(dto.getValorTipoUnidadEmpaque(), SICArticuloConstantes.getInstancia().TIPOEMPAQUE_MAYORISTA))
					return dto.getValorUnidadManejo();
			}
		}
		return null;
	}
	
	/**
	 * @return the unidadManejoVenta
	 */
	public Integer getUnidadManejoVenta() {
		if(getTieneUnidadManejoCol()){
			for(ArticuloUnidadManejoDTO dto : articuloUnidadManejoCol){
				if(esUnidadManejoVenta(dto) && dto.getPrioridad()!=null && dto.getPrioridad().intValue() == 1 
						&& SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(dto.getEstadoUnidadManejo()))
					return dto.getValorUnidadManejo();
			}
		}
		return null;
	}
	
	/**
	 * Metodo que devuelve el valor de la unidad de manejo de venta segun los casos correspondientes a precios de caja y mayorista
	 * @author mgranda
	 * @return Integer 
	 */
	public Integer getNpUnidadManejoVenta(){
		if(this.npUnidadManejoVenta == null){
			if(this.getHabilitadoPrecioCaja()){
				this.npUnidadManejoVenta = this.getUnidadManejoPrecioCaja();
			}else{
				this.npUnidadManejoVenta =  this.getUnidadManejoVentaPorPrioridad() != null ? this.getUnidadManejoVentaPorPrioridad() : this.getUnidadManejo();
			}
		}
		return this.npUnidadManejoVenta;
	}
	
	public String getNombreTipoEmpaqueVenta() {
		if(getTieneUnidadManejoCol()){
			for(ArticuloUnidadManejoDTO dto : articuloUnidadManejoCol){
				if(esUnidadManejoVenta(dto) && dto.getPrioridad()!=null && dto.getPrioridad().intValue() == 1 
						&& SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(dto.getEstadoUnidadManejo()) && dto.getTieneTipoUnidadEmpaque())
					return dto.getTipoUnidadEmpaque().getNombreCatalogoValor();
			}
		}
		return null;
	}

	private Boolean esUnidadManejoVenta(ArticuloUnidadManejoDTO aum){
		for(ArticuloUnidadManejoUsoDTO dto : aum.getArticuloUnidadManejoUsoCol()){
			if(dto.getId().getValorTipoUso().equals(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA) && dto.getEstado().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * @return the costoBrutoArticulo
	 */
	@Deprecated
	public Double getCostoBrutoArticulo() {
		return costoBrutoArticulo;
	}
	/**
	 * @param costoBrutoArticulo the costoBrutoArticulo to set
	 */
	@Deprecated
	public void setCostoBrutoArticulo(Double costoBrutoArticulo) {
		this.costoBrutoArticulo = costoBrutoArticulo;
	}
	@Override
	public ArticuloDTO getArticuloContenido() {
		return this;
	}
	
	public Boolean getTieneArticuloRelacionado(){
		return isLoaded(articuloRelacionCol) && !CollectionUtils.isEmpty(articuloRelacionCol);
	}

	/**
	 * @return the estadoCodificacionArticulo
	 */
	@Deprecated
	public EstadoCodificacionArticuloDTO getEstadoCodificacionArticuloDTO() {
		return estadoCodificacionArticuloDTO;
	}
	/**
	 * @param estadoCodificacionArticulo the estadoCodificacionArticulo to set
	 */
	@Deprecated
	public void setEstadoCodificacionArticuloDTO(EstadoCodificacionArticuloDTO estadoCodificacionArticulo) {
		this.estadoCodificacionArticuloDTO = estadoCodificacionArticulo;
	}
	/**
	 * @return the segmentoCreacionArticulos
	 */
	public Collection<SegmentoCreacionArticuloDTO> getSegmentoCreacionArticulos() {
		return segmentoCreacionArticulos;
	}
	/**
	 * @param segmentoCreacionArticulos the segmentoCreacionArticulos to set
	 */
	public void setSegmentoCreacionArticulos(Collection<SegmentoCreacionArticuloDTO> segmentoCreacionArticulos) {
		this.segmentoCreacionArticulos = segmentoCreacionArticulos;
	}
	
	public Boolean getTieneSegmentoCreacionArticulo(){
		return isLoaded(segmentoCreacionArticulos) && !segmentoCreacionArticulos.isEmpty();
	}
	/**
	 * @return the articuloOriginal
	 */
	public ArticuloDTO getArticuloOriginal() {
		return articuloOriginal;
	}
	/**
	 * @param articuloOriginal the articuloOriginal to set
	 */
	public void setArticuloOriginal(ArticuloDTO articuloOriginal) {
		this.articuloOriginal = articuloOriginal;
	}
	
	public Boolean getTieneEtiquetas(){
		return isLoaded(articuloEtiquetaCol) && CollectionUtils.isNotEmpty(articuloEtiquetaCol);
	}
	
	public Boolean getTieneUsos(){
		return isLoaded(articuloUsoCol) && CollectionUtils.isNotEmpty(articuloUsoCol);
	}
	
	public Boolean getTieneDuracionConservacion(){
		return isLoaded(articuloDuracionConservacionCol) && CollectionUtils.isNotEmpty(articuloDuracionConservacionCol);
	}
	
	public Boolean getTieneEstructuraComercialCliente(){
		return isLoaded(estructuraComercialClienteCol) && CollectionUtils.isNotEmpty(estructuraComercialClienteCol);
	}
	
	public UserDto getUsuarioCreacionDTO() {
		return usuarioCreacionDTO;
	}
	public void setUsuarioCreacionDTO(UserDto usuarioCreacionDTO) {
		this.usuarioCreacionDTO = usuarioCreacionDTO;
	}
	/**
	 * @return the articuloRelacionPadreCol
	 */
	public Collection<ArticuloRelacionDTO> getArticuloRelacionPadreCol() {
		return articuloRelacionPadreCol;
	}
	/**
	 * @param articuloRelacionPadreCol the articuloRelacionPadreCol to set
	 */
	public void setArticuloRelacionPadreCol(
			Collection<ArticuloRelacionDTO> articuloRelacionPadreCol) {
		this.articuloRelacionPadreCol = articuloRelacionPadreCol;
	}
	
	public Boolean tieneAlcanceAreaTrabajo(Integer codigoAreaTrabajo){
		if(articuloLocalCol != null && !isLazy(articuloLocalCol)){
			for(ArticuloLocalDTO al : articuloLocalCol){
				if(codigoAreaTrabajo.equals(al.getId().getCodigoLocal())){
					return Boolean.TRUE;
				}
			}
			return Boolean.FALSE;
		}
		return null;
	}
	
	public Boolean getTieneAlcanceAreaTrabajo(){
		if(getNpCodigoLocal() != null){
			return tieneAlcanceAreaTrabajo(getNpCodigoLocal());
		}
		return null;
	}

	public Boolean getTieneGrupoAlcance(){
		return isLoaded(grupoAlcanceDTO);
	}
	/**
	 * @return the grupoAlcanceDTO
	 */
	public GrupoTrabajoDTO getGrupoAlcanceDTO() {
		return grupoAlcanceDTO;
	}
	/**
	 * @param grupoAlcanceDTO the grupoAlcanceDTO to set
	 */
	public void setGrupoAlcanceDTO(GrupoTrabajoDTO grupoAlcanceDTO) {
		this.grupoAlcanceDTO = grupoAlcanceDTO;
	}
	/**
	 * @return the codigoGrupoAlcance
	 */
	public Long getCodigoGrupoAlcance() {
		return codigoGrupoAlcance;
	}
	/**
	 * @param codigoGrupoAlcance the codigoGrupoAlcance to set
	 */
	public void setCodigoGrupoAlcance(Long codigoGrupoAlcance) {
		this.codigoGrupoAlcance = codigoGrupoAlcance;
	}
	/**
	 * @return the articuloProcesoLogisticoDTO
	 */
	public ArticuloProcesoLogisticoDTO getArticuloProcesoLogisticoDTO() {
		return articuloProcesoLogisticoDTO;
	}
	/**
	 * @param articuloProcesoLogisticoDTO the articuloProcesoLogisticoDTO to set
	 */
	public void setArticuloProcesoLogisticoDTO(ArticuloProcesoLogisticoDTO articuloProcesoLogisticoDTO) {
		this.articuloProcesoLogisticoDTO = articuloProcesoLogisticoDTO;
	}
	/**
	 * @return the codigoEstado
	 */
	public String getCodigoEstado() {
		return codigoEstado;
	}
	/**
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	public Collection<ArticuloEstablecimientoDTO> getArticuloEstablecimientoCol() {
		return articuloEstablecimientoCol;
	}
	public void setArticuloEstablecimientoCol(
			Collection<ArticuloEstablecimientoDTO> articuloEstablecimientoCol) {
		this.articuloEstablecimientoCol = articuloEstablecimientoCol;
	}
	/**
	 * @return the articuloAgrupadorCol
	 */
	public Collection<ArticuloAgrupadorDTO> getArticuloAgrupadorCol() {
		return articuloAgrupadorCol;
	}
	/**
	 * @param articuloAgrupadorCol the articuloAgrupadorCol to set
	 */
	public void setArticuloAgrupadorCol(Collection<ArticuloAgrupadorDTO> articuloAgrupadorCol) {
		this.articuloAgrupadorCol = articuloAgrupadorCol;
	}
	
	public boolean getTieneArticuloAgrupador(){
		return isLoaded(articuloAgrupadorCol) && CollectionUtils.isNotEmpty(articuloAgrupadorCol);
	}
	/**
	 * @return the articuloBitacoraEstadoCol
	 */
	public Collection<ArticuloBitacoraEstadoDTO> getArticuloBitacoraEstadoCol() {
		return articuloBitacoraEstadoCol;
	}
	/**
	 * @param articuloBitacoraEstadoCol the articuloBitacoraEstadoCol to set
	 */
	public void setArticuloBitacoraEstadoCol(
			Collection<ArticuloBitacoraEstadoDTO> articuloBitacoraEstadoCol) {
		this.articuloBitacoraEstadoCol = articuloBitacoraEstadoCol;
	}
	
	/**
	 * @return the campanias
	 */
	public Collection<ArticuloGestionPrecioDTO> getCampanias() {
		return campanias;
	}
	/**
	 * @param campanias the campanias to set
	 */
	public void setCampanias(Collection<ArticuloGestionPrecioDTO> campanias) {
		this.campanias = campanias;
	}
	
	public Boolean getTieneCampanias(){
		return isLoaded(campanias);
	}
	
	public String getEstructuraComercialCliente(){
		if(!clasificacionDTO.getClasificacionRelacionadaPrincipal().isEmpty()){
			return clasificacionDTO.getClasificacionRelacionadaPrincipal().iterator().next().getCodigoClasificacionRelacionada();
		}
		return null;
	}
	
	/**
	 * @return the clientes
	 */
	public Collection<ClienteArticuloDTO> getClientes() {
		return clientes;
	}
	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(Collection<ClienteArticuloDTO> clientes) {
		this.clientes = clientes;
	}
	public String getValorEstadoTransgenico() {
		return valorEstadoTransgenico;
	}
	public void setValorEstadoTransgenico(String valorEstadoTransgenico) {
		this.valorEstadoTransgenico = valorEstadoTransgenico;
	}
	public Integer getCodigoEstadoTransgenico() {
		return codigoEstadoTransgenico;
	}
	public void setCodigoEstadoTransgenico(Integer codigoEstadoTransgenico) {
		this.codigoEstadoTransgenico = codigoEstadoTransgenico;
	}
	public CatalogoValorDTO getEstadoTransgenico() {
		return estadoTransgenico;
	}
	public void setEstadoTransgenico(CatalogoValorDTO estadoTransgenico) {
		this.estadoTransgenico = estadoTransgenico;
	}
	public Collection<ArticuloEnvaseDTO> getEnvases() {
		return envases;
	}
	public void setEnvases(Collection<ArticuloEnvaseDTO> envases) {
		this.envases = envases;
	}
	public EstadoTipoArticuloDTO getEstadoTipoArticulo() {
		return estadoTipoArticulo;
	}
	public void setEstadoTipoArticulo(EstadoTipoArticuloDTO estadoTipoArticulo) {
		this.estadoTipoArticulo = estadoTipoArticulo;
	}
	public Collection<ArticuloLeyendaDTO> getArticuloLeyendaCol() {
		return articuloLeyendaCol;
	}
	public void setArticuloLeyendaCol(Collection<ArticuloLeyendaDTO> articuloLeyendaCol) {
		this.articuloLeyendaCol = articuloLeyendaCol;
	}
	public Integer getCantidadRegistroSanitario() {
		return cantidadRegistroSanitario;
	}
	public void setCantidadRegistroSanitario(Integer cantidadRegistroSanitario) {
		this.cantidadRegistroSanitario = cantidadRegistroSanitario;
	}
	public Boolean getAplicaTransgenico() {
		return aplicaTransgenico;
	}
	public void setAplicaTransgenico(Boolean aplicaTransgenico) {
		this.aplicaTransgenico = aplicaTransgenico;
	}
	public Collection<DetalleListaRecetaDTO> getDetalleListaRecetaDtoCol() {
		return detalleListaRecetaDtoCol;
	}
	public void setDetalleListaRecetaDtoCol(Collection<DetalleListaRecetaDTO> detalleListaRecetaDtoCol) {
		this.detalleListaRecetaDtoCol = detalleListaRecetaDtoCol;
	}
	public Collection<DetalleListaDTO> getDetalleListaDtoCol() {
		return detalleListaDtoCol;
	}
	public void setDetalleListaDtoCol(Collection<DetalleListaDTO> detalleListaDtoCol) {
		this.detalleListaDtoCol = detalleListaDtoCol;
	}
	
	public ArticuloDTO clone() throws CloneNotSupportedException{
		ArticuloDTO arClone = (ArticuloDTO)super.clone();
		arClone.setId(id.clone());
		return arClone;
	}
	public Integer getCodigoAplicaRegistroSanitario() {
		return codigoAplicaRegistroSanitario;
	}
	public void setCodigoAplicaRegistroSanitario(Integer codigoAplicaRegistroSanitario) {
		this.codigoAplicaRegistroSanitario = codigoAplicaRegistroSanitario;
	}
	public String getValorAplicaRegistroSanitario() {
		return valorAplicaRegistroSanitario;
	}
	public void setValorAplicaRegistroSanitario(String valorAplicaRegistroSanitario) {
		this.valorAplicaRegistroSanitario = valorAplicaRegistroSanitario;
	}
	
	/**
	 * @return the contenedorDetalleDTOCol
	 */
	public Collection<ContenedorDetalleDTO> getContenedorDetalleDTOCol() {
		return contenedorDetalleDTOCol;
	}
	/**
	 * @param contenedorDetalleDTOCol the contenedorDetalleDTOCol to set
	 */
	public void setContenedorDetalleDTOCol(Collection<ContenedorDetalleDTO> contenedorDetalleDTOCol) {
		this.contenedorDetalleDTOCol = contenedorDetalleDTOCol;
	}
	public String getCodigoArticuloPlantilla() {
		return codigoArticuloPlantilla;
	}
	public void setCodigoArticuloPlantilla(String codigoArticuloPlantilla) {
		this.codigoArticuloPlantilla = codigoArticuloPlantilla;
	}
	public Collection<ArticuloEtiquetaMercanciaDTO> getArticuloEtiquetaMercanciaCol() {
		return articuloEtiquetaMercanciaCol;
	}
	public void setArticuloEtiquetaMercanciaCol(Collection<ArticuloEtiquetaMercanciaDTO> articuloEtiquetaMercanciaCol) {
		this.articuloEtiquetaMercanciaCol = articuloEtiquetaMercanciaCol;
	}
	
	/**
	 * @return importancia
	 */
	public Integer getImportancia() {
		return importancia;
	}
	
	/**
	 * @param importancia
	 */
	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}
	
	/**
	 * @return establecimientoDTO
	 */
	public EstablecimientoDTO getEstablecimientoDTO() {
		return establecimientoDTO;
	}
	
	/**
	 * @param establecimientoDTO
	 */
	public void setEstablecimientoDTO(EstablecimientoDTO establecimientoDTO) {
		this.establecimientoDTO = establecimientoDTO;
	}
	
	/**
	 * @return indicadori
	 */
	public Boolean getIndicadorI() {
		return indicadorI;
	}
	
	public void setIndicadorI(Boolean indicadorI) {
		this.indicadorI = indicadorI;
	}
	
	/**
	 * @return the usuarioActualizacionDTO
	 */
	public UserDto getUsuarioActualizacionDTO() {
		return usuarioActualizacionDTO;
	}
	/**
	 * @param usuarioActualizacionDTO the usuarioActualizacionDTO to set
	 */
	public void setUsuarioActualizacionDTO(UserDto usuarioActualizacionDTO) {
		this.usuarioActualizacionDTO = usuarioActualizacionDTO;
	}
	
	public Collection<ArticuloLocalGestionPrecioDTO> getArticuloLocalGestionPrecioCol() {
		return articuloLocalGestionPrecioCol;
	}
	
	public void setArticuloLocalGestionPrecioCol(Collection<ArticuloLocalGestionPrecioDTO> articuloLocalGestionPrecioCol) {
		this.articuloLocalGestionPrecioCol = articuloLocalGestionPrecioCol;
	}
	
	public ArticuloInformacionAdicionalDTO getArticuloInformacionAdicionalDTO() {
		return articuloInformacionAdicionalDTO;
	}
	public void setArticuloInformacionAdicionalDTO(ArticuloInformacionAdicionalDTO articuloInformacionAdicionalDTO) {
		this.articuloInformacionAdicionalDTO = articuloInformacionAdicionalDTO;
	}
	public ArticuloClaseDTO getArticuloClaseDTO() {
		return articuloClaseDTO;
	}
	public void setArticuloClaseDTO(ArticuloClaseDTO articuloClaseDTO) {
		this.articuloClaseDTO = articuloClaseDTO;
	}
	public Collection<ArticuloLocalDTO> getArticuloOficinaCol() {
		return articuloOficinaCol;
	}
	public void setArticuloOficinaCol(Collection<ArticuloLocalDTO> articuloOficinaCol) {
		this.articuloOficinaCol = articuloOficinaCol;
	}
	public Collection<ArticuloLocalDTO> getArticuloBodegaCol() {
		return articuloBodegaCol;
	}
	public void setArticuloBodegaCol(Collection<ArticuloLocalDTO> articuloBodegaCol) {
		this.articuloBodegaCol = articuloBodegaCol;
	}
	public Long getCodigoClienteImportacion() {
		return codigoClienteImportacion;
	}
	public void setCodigoClienteImportacion(Long codigoClienteImportacion) {
		this.codigoClienteImportacion = codigoClienteImportacion;
	}
	public ArticuloLeyMercadoDTO getArticuloLeyMercadoDTO() {
		return articuloLeyMercadoDTO;
	}
	public void setArticuloLeyMercadoDTO(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) {
		this.articuloLeyMercadoDTO = articuloLeyMercadoDTO;
	}
	/**
	 * @return the caracteristicaEspecial
	 */
	public Map<String, Object> getCaracteristicaEspecial() {
		return caracteristicaEspecial;
	}
	/**
	 * @param caracteristicaEspecial the caracteristicaEspecial to set
	 */
	public void setCaracteristicaEspecial(Map<String, Object> caracteristicaEspecial) {
		this.caracteristicaEspecial = caracteristicaEspecial;
	}
	/**
	 * @return the codRefIntProv
	 */
	public String getCodRefIntProv() {
		return codRefIntProv;
	}
	/**
	 * @param codRefIntProv the codRefIntProv to set
	 */
	public void setCodRefIntProv(String codRefIntProv) {
		this.codRefIntProv = codRefIntProv;
	}
	public String getVarNombreEtiqueta() {
		return varNombreEtiqueta;
	}
	public void setVarNombreEtiqueta(String varNombreEtiqueta) {
		this.varNombreEtiqueta = varNombreEtiqueta;
	}
	public ArticuloAuditoriaDTO getArticuloAuditoria() {
		return articuloAuditoria;
	}
	public void setArticuloAuditoria(ArticuloAuditoriaDTO articuloAuditoria) {
		this.articuloAuditoria = articuloAuditoria;
	}
	
	/**
	 * 
	 * @return valorTipoEstadoRegistro
	 */
	public String getValorTipoEstadoRegistro() {
		return valorTipoEstadoRegistro;
	}
	/**
	 * 
	 * @param valorTipoEstadoRegistro
	 */
	public void setValorTipoEstadoRegistro(String valorTipoEstadoRegistro) {
		this.valorTipoEstadoRegistro = valorTipoEstadoRegistro;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getCodigoBarrasPOS() {
		return codigoBarrasPOS;
	}
	
	public void setCodigoBarrasPOS(String codigoBarrasPOS) {
		this.codigoBarrasPOS = codigoBarrasPOS;
	}
	
	public String getCodigoTipoCodigoArticulo() {
		return codigoTipoCodigoArticulo;
	}
	
	public void setCodigoTipoCodigoArticulo(String codigoTipoCodigoArticulo) {
		this.codigoTipoCodigoArticulo = codigoTipoCodigoArticulo;
	}
	
	public Timestamp getFechaPrimeraEntrega() {
		return fechaPrimeraEntrega;
	}
	
	public void setFechaPrimeraEntrega(Timestamp fechaPrimeraEntrega) {
		this.fechaPrimeraEntrega = fechaPrimeraEntrega;
	}
}