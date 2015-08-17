package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.sql.Timestamp;
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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.DetalleListaDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.DetalleListaRecetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.EspecialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.sispe.TipoDescuentoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ClasificacionTransient;

/**
 * @author fmunoz
 *
 */
@Entity
@Table(name="SCSPETCLASIFICACION")
@SuppressWarnings("serial")
public class ClasificacionDTO extends ClasificacionTransient
{
	@EmbeddedId
	private ClasificacionID id;
	
	@ComparatorTypeField
	@Column(name="CODIGOCLASIFICACIONPADRE")
	private String codigoClasificacionPadre;
	
	@ComparatorTypeField
	@Column(name="CODIGOTIPOCLASIFICACION")
	private String codigoTipoClasificacion;
	
	@ComparatorTypeField
	@Column(name="CODIGOBODEGA")
	private String codigoBodega;
	
	@ComparatorTypeField
	@Column(name="CODIGOCOMPRADOR")
	private String codigoComprador;
	
	private String descripcionClasificacion;
	
	private Long nivelClasificacion;
	
	@ComparatorTypeField
	private String estadoClasificacion;
	
	@LastModificationDateField
	private Timestamp fechaUltimaActualizacion;
	
	@LastModifierUserIdField
	@ComparatorTypeField
	private String usuarioActualizacion;
	
	@RegisterDateField
	private Timestamp fechaCreacion;
	
	@RegisterUserIdField
	@ComparatorTypeField
	private String usuarioCreacion;
	
	@Deprecated
	private Boolean aplicaRegistroSanitario;
	@Transient
	private String codigoDescripcionClasificacion;
	@Transient
	private boolean mostrarListaClasificacion;
	
	/**
	 * Indica el porcentaje del precio no afiliado por clasificacion
	 */
	private Double porcentajeNoAfiliado;
	/** 
	 * Indicador de publicaci&oacute;n en internet, solo se usa a nivel de departamento
	 */
	private Boolean esPublicadoInternet;
	/**
	 * Descripci&oacute;n para la publicaci&oacute;n en internet
	 */
	private String descripcionPublicacionInternet;
	
	@ComparatorTypeField
	@Column(name="VALORTIPODEDUCIBLE")
	private String valorTipoDeducible;
	
	@Column(name="CODIGOTIPODEDUCIBLE")
	private Integer codigoTipoDeducible;
	
	@ComparatorTypeField
	@Column(name="VALORTIPODISTRIBUCION")
	private String valorTipoDistribucion;
	
	@Column(name="CODIGOTIPODISTRIBUCION")
	private Integer codigoTipoDistribucion;
	
	//por definir si este campo sera persistente
	@Transient
	private String codigoTipoArticulo;
	
	@ComparatorTypeField
	@Column(name="VALORTIPOESTRUCTURA")
	private String valorTipoEstructura = CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL;
	@Column(name="CODIGOTIPOESTRUCTURA")
	private Integer codigoTipoEstructura = TiposCatalogoConstantes.TIPO_ESTRUCTURA;
	
	@ComparatorTypeField
	@Column(name="VALORAPLICAREGISTROSANITARIO")
	private String valorAplicaRegistroSanitario;
	
	@Column(name="CODIGOAPLICAREGISTROSANITARIO")
	private Integer codigoAplicaRegistroSanitario;
	
	private Integer orden;
	@ComparatorTypeField
	private String codigoReferencia;
	private String url;
	
	@Column(name="UNIFICARCOSTOPROVEEDOR")
	private Boolean unificarCostoProveedor;
	
	private Boolean aplicaTransgenico;
	//relaciones
	
	
	//////////////////////////////////////////////////////////////
	////	RELACIONS OBJETOS SIC (asistente de compras)    //////
	//////////////////////////////////////////////////////////////
	@OneToMany(fetch=FetchType.LAZY,mappedBy="clasificacionDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleListaRecetaDTO> detalleListaRecetaDtoCol;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="clasificacionDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleListaDTO> detalleListaDtoCol;
	
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="clasificacionDto")
//	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
//	private Collection<InscripcionNotificacionDTO> inscripcionNotificacionDtoCol;
	
	@OneToMany(mappedBy = "clasificacionRelacionada")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDtoCol;
	//////////////////////////////////////////////////////////////
	//// FIN RELACIONS OBJETOS SIC (asistente de compras)    /////
	//////////////////////////////////////////////////////////////
	
	@OneToMany(mappedBy = "clasificacionDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<ArticuloDTO> articuloCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOBODEGA", referencedColumnName = "CODIGOBODEGA", insertable = false, updatable = false)})
	private BodegaDTO bodegaDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOCLASIFICACIONPADRE", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)})
	private ClasificacionDTO clasificacionPadre;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOCOMPRADOR", referencedColumnName = "CODIGOCOMPRADOR", insertable = false, updatable = false)})
	private CompradorDTO compradorDTO;

	@OneToMany(mappedBy = "clasificacionDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<SubClasificacionDTO> subClasificacionCol;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOTIPOCLASIFICACION", referencedColumnName = "CODIGOTIPOCLASIFICACION", insertable = false, updatable = false)})
	private TipoClasificacionDTO tipoClasificacionDTO;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPODEDUCIBLE", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPODEDUCIBLE", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoDeducible;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORAPLICAREGISTROSANITARIO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOAPLICAREGISTROSANITARIO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO catalogoAplicaRegistroSanitario;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="clasificacionDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenedorDTO> contenedorDTOCol;
	
	
	@OneToMany(mappedBy = "clasificacionDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClasificacionArchivoDTO> clasificacionArchivoCol;
	
	
	@Transient
	private Collection<SubClasificacionDTO> subClasificacionCol2;
	@Transient
	private Boolean isSelected = Boolean.FALSE;
	@Transient
	private Collection<ClasificacionDTO> clasificacionCol;
	@Transient
	private Boolean esAsignado = Boolean.FALSE;
	@Transient
	private Boolean desplegar = Boolean.TRUE;
	@Transient
	private Boolean desplegado = Boolean.FALSE;
	
	/**
	 * variable de conteo de sub clasificaciones
	 */
	@Transient
	private Integer numeroSubClasificacion=0;
	
	@OneToMany(mappedBy = "clasificacionPadre")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<ClasificacionDTO> clasificacionDTOs;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTRUCTURA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOESTRUCTURA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoEstructura;
	
	@OneToMany(mappedBy = "clasificacion")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaPrincipal;
	
	@OneToMany(mappedBy = "clasificacionRelacionada")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaSecundaria;
	
	/////////////////////////////////////////
	////	RELACIONS OBJETOS SISPE
	////////////////////////////////////////
	@OneToMany(mappedBy = "clasificacionDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<EspecialClasificacionDTO> especialClasificacionCol;
	
	@OneToMany(mappedBy = "clasificacionDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<TipoDescuentoClasificacionDTO> tipoDescuentoClasificacionCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPODISTRIBUCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPODISTRIBUCION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoDistribucion;

	
	@OneToMany(mappedBy = "clasificacion")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ProveedorClasificacionDTO> proveedorClasificacionCol;
	
	/**
	 * Posee el calculo del valor por departamento de la nota de ingreso
	 */
	@Transient
	private BigDecimal valorTotal;
	
	/**
	 * 
	 */
	public ClasificacionDTO(){
		id = new ClasificacionID();
	}
	
	public ClasificacionDTO(Boolean iniID){
		id = new ClasificacionID(iniID);
	}
	/**
	 * @return Devuelve codigoClasificacionPadre.
	 */
	public String getCodigoClasificacionPadre()
	{
		return codigoClasificacionPadre;
	}
	/**
	 * @return Devuelve nivelClasificacion.
	 */
	public Long getNivelClasificacion()
	{
		return nivelClasificacion;
	}
	/**
	 * @param nivelClasificacion El nivelClasificacion a establecer.
	 */
	public void setNivelClasificacion(Long nivelClasificacion)
	{
		this.nivelClasificacion = nivelClasificacion;
	}
	/**
	 * @return Devuelve estadoClasificacion.
	 */
	public String getEstadoClasificacion()
	{
		return estadoClasificacion;
	}
	/**
	 * @param estadoClasificacion El estadoClasificacion a establecer.
	 */
	public void setEstadoClasificacion(String estadoClasificacion)
	{
		this.estadoClasificacion = estadoClasificacion;
	}
	/**
	 * @param codigoClasificacionPadre El codigoClasificacionPadre a establecer.
	 */
	public void setCodigoClasificacionPadre(String codigoClasificacionPadre)
	{
		this.codigoClasificacionPadre = codigoClasificacionPadre;
	}
	/**
	 * @return Devuelve codigoTipoClasificacion.
	 */
	public String getCodigoTipoClasificacion()
	{
		return codigoTipoClasificacion;
	}
	/**
	 * @param codigoTipoClasificacion El codigoTipoClasificacion a establecer.
	 */
	public void setCodigoTipoClasificacion(String codigoTipoClasificacion)
	{
		this.codigoTipoClasificacion = codigoTipoClasificacion;
	}
	/**
	 * @return Devuelve codigoBodega.
	 */
	public String getCodigoBodega()
	{
		return codigoBodega;
	}
	/**
	 * @param codigoBodega El codigoBodega a establecer.
	 */
	public void setCodigoBodega(String codigoBodega)
	{
		this.codigoBodega = codigoBodega;
	}
	/**
	 * @return Devuelve codigoComprador.
	 */
	public String getCodigoComprador()
	{
		return codigoComprador;
	}
	/**
	 * @param codigoComprador El codigoComprador a establecer.
	 */
	public void setCodigoComprador(String codigoComprador)
	{
		this.codigoComprador = codigoComprador;
	}
	/**
	 * @return Devuelve descripcionClasificacion.
	 */
	public String getDescripcionClasificacion()
	{
		return descripcionClasificacion;
	}
	/**
	 * @param descripcionClasificacion El descripcionClasificacion a establecer.
	 */
	public void setDescripcionClasificacion(String descripcionClasificacion)
	{
		this.descripcionClasificacion = descripcionClasificacion != null ? descripcionClasificacion.toUpperCase() : null;
	}
	/**
	 * @return Devuelve id.
	 */
	public ClasificacionID getId()
	{
		return id;
	}
	/**
	 * @param id El id a establecer.
	 */
	public void setId(ClasificacionID id)
	{
		this.id = id;
	}

	/**
	 * @return el fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion el fechaCreacion a establecer
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return el usuarioActualizacion
	 */
	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	/**
	 * @param usuarioActualizacion el usuarioActualizacion a establecer
	 */
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	/**
	 * @return el usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion el usuarioCreacion a establecer
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
	/**
	 * 
	 * @param codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania){
		this.id.setCodigoCompania(codigoCompania);
	}
	
	/**
	 * 
	 * @param codigoClasificacion
	 */
	public void setCodigoClasificacion(String codigoClasificacion){
		this.id.setCodigoClasificacion(codigoClasificacion);
	}

	

	/**
	 * @return the tipoClasificacionDTO
	 */
	public TipoClasificacionDTO getTipoClasificacionDTO() {
		return tipoClasificacionDTO;
	}

	/**
	 * @param tipoClasificacionDTO the tipoClasificacionDTO to set
	 */
	public void setTipoClasificacionDTO(TipoClasificacionDTO tipoClasificacionDTO) {
		this.tipoClasificacionDTO = tipoClasificacionDTO;
	}

	/**
	 * @return the bodegaDTO
	 */
	public BodegaDTO getBodegaDTO() {
		return bodegaDTO;
	}

	/**
	 * @param bodegaDTO the bodegaDTO to set
	 */
	public void setBodegaDTO(BodegaDTO bodegaDTO) {
		this.bodegaDTO = bodegaDTO;
	}

	public CompradorDTO getCompradorDTO() {
		return compradorDTO;
	}

	public void setCompradorDTO(CompradorDTO compradorDTO) {
		this.compradorDTO = compradorDTO;
	}

	/**
	 * @return the clasificacionCol
	 */
	public Collection<ClasificacionDTO> getClasificacionCol() {
		return clasificacionCol;
	}

	/**
	 * @param clasificacionCol the clasificacionCol to set
	 */
	public void setClasificacionCol(Collection<ClasificacionDTO> clasificacionCol) {
		this.clasificacionCol = clasificacionCol;
	}

	/**
	 * @return the clasificacionPadre
	 */
	public ClasificacionDTO getClasificacionPadre() {
		return clasificacionPadre;
	}

	/**
	 * @param clasificacionPadre the clasificacionPadre to set
	 */
	public void setClasificacionPadre(ClasificacionDTO clasificacionPadre) {
		this.clasificacionPadre = clasificacionPadre;
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
	
	public Boolean getTieneTipoClasificacionDTO(){
		return isLoaded(tipoClasificacionDTO);
	}
	
//	public Boolean getTieneLineaComercialDTO(){
//		return isLoaded(lineaComercialDTO);
//	}
	
	public Boolean getTieneBodegaDTO(){
		return isLoaded(bodegaDTO);
	}
	public Boolean getTieneCompradorDTO(){
		return isLoaded(compradorDTO);
	}
	
	public Boolean getTieneClasificacionPadre(){
		return isLoaded(clasificacionPadre);
	}
	
	
	/**
	 * @return the subClasificacionCol
	 */
	public Collection<SubClasificacionDTO> getSubClasificacionCol() {
		return subClasificacionCol;
	}

	/**
	 * @param subClasificacionCol the subClasificacionCol to set
	 */
	public void setSubClasificacionCol(
			Collection<SubClasificacionDTO> subClasificacionCol) {
		this.subClasificacionCol = subClasificacionCol;
	}
	
	
	/**
	 * @return the subClasificacionCol2
	 */
	public Collection<SubClasificacionDTO> getSubClasificacionCol2() {
		return subClasificacionCol2;
	}
	

	/**
	 * @param subClasificacionCol2 the subClasificacionCol2 to set
	 */
	public void setSubClasificacionCol2(Collection<SubClasificacionDTO> subClasificacionCol2) {
		this.subClasificacionCol2 = subClasificacionCol2;
	}


	/**
	 * @return the isSelected
	 */
	public Boolean getIsSelected() {
		return isSelected;
	}


	/**
	 * @param isSelected the isSelected to set
	 */
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}


	public Collection<EspecialClasificacionDTO> getEspecialClasificacionCol() {
		return especialClasificacionCol;
	}


	public void setEspecialClasificacionCol(
			Collection<EspecialClasificacionDTO> especialClasificacionCol) {
		this.especialClasificacionCol = especialClasificacionCol;
	}


	public Collection<TipoDescuentoClasificacionDTO> getTipoDescuentoClasificacionCol() {
		return tipoDescuentoClasificacionCol;
	}


	public void setTipoDescuentoClasificacionCol(
			Collection<TipoDescuentoClasificacionDTO> tipoDescuentoClasificacionCol) {
		this.tipoDescuentoClasificacionCol = tipoDescuentoClasificacionCol;
	}
	
	public Boolean getTieneTipoDescuentoClasificacion(){
		return 	isLoaded(this.tipoDescuentoClasificacionCol);
	}
	
	public Boolean getTieneEspecialClasificacion(){
		return 	isLoaded(this.especialClasificacionCol) && !this.especialClasificacionCol.isEmpty();
	}

	public Collection<ArticuloDTO> getArticuloCol() {
		return articuloCol;
	}

	public void setArticuloCol(Collection<ArticuloDTO> articuloCol) {
		this.articuloCol = articuloCol;
	}

	/**
	 * @return the descripcionPublicacionInternet
	 */
	public String getDescripcionPublicacionInternet() {
		return descripcionPublicacionInternet;
	}

	/**
	 * @param descripcionPublicacionInternet the descripcionPublicacionInternet to set
	 */
	public void setDescripcionPublicacionInternet(String descripcionPublicacionInternet) {
		this.descripcionPublicacionInternet = descripcionPublicacionInternet;
	}

	/**
	 * @return the esPublicadoInternet
	 */
	public Boolean getEsPublicadoInternet() {
		return esPublicadoInternet;
	}

	/**
	 * @param esPublicadoInternet the esPublicadoInternet to set
	 */
	public void setEsPublicadoInternet(Boolean esPublicadoInternet) {
		this.esPublicadoInternet = esPublicadoInternet;
	}

	/**
	 * @return the valorTipoDeducible
	 */
	public String getValorTipoDeducible() {
		return valorTipoDeducible;
	}

	/**
	 * @param valorTipoDeducible the valorTipoDeducible to set
	 */
	public void setValorTipoDeducible(String valorTipoDeducible) {
		this.valorTipoDeducible = valorTipoDeducible;
	}

	/**
	 * @return the codigoTipoDeducible
	 */
	public Integer getCodigoTipoDeducible() {
		return codigoTipoDeducible;
	}

	/**
	 * @param codigoTipoDeducible the codigoTipoDeducible to set
	 */
	public void setCodigoTipoDeducible(Integer codigoTipoDeducible) {
		this.codigoTipoDeducible = codigoTipoDeducible;
	}

	/**
	 * @return the valorTipoDistribucion
	 */
	public final String getValorTipoDistribucion() {
		return valorTipoDistribucion;
	}

	/**
	 * @param valorTipoDistribucion the valorTipoDistribucion to set
	 */
	public final void setValorTipoDistribucion(String valorTipoDistribucion) {
		this.valorTipoDistribucion = valorTipoDistribucion;
	}

	/**
	 * @return the codigoTipoDistribucion
	 */
	public final Integer getCodigoTipoDistribucion() {
		return codigoTipoDistribucion;
	}

	/**
	 * @param codigoTipoDistribucion the codigoTipoDistribucion to set
	 */
	public final void setCodigoTipoDistribucion(Integer codigoTipoDistribucion) {
		this.codigoTipoDistribucion = codigoTipoDistribucion;
	}

	/**
	 * @return the tipoDeducible
	 */
	public CatalogoValorDTO getTipoDeducible() {
		return tipoDeducible;
	}

	/**
	 * @param tipoDeducible the tipoDeducible to set
	 */
	public void setTipoDeducible(CatalogoValorDTO tipoDeducible) {
		this.tipoDeducible = tipoDeducible;
	}

	public Collection<ClasificacionDTO> getClasificacionDTOs() {
		return clasificacionDTOs;
	}

	public void setClasificacionDTOs(Collection<ClasificacionDTO> clasificacionDTOs) {
		this.clasificacionDTOs = clasificacionDTOs;
	}

	/**
	 * @return the porcentajeNoAfiliado
	 */
	public Double getPorcentajeNoAfiliado() {
		return porcentajeNoAfiliado;
	}

	/**
	 * @param porcentajeNoAfiliado the porcentajeNoAfiliado to set
	 */
	public void setPorcentajeNoAfiliado(Double porcentajeNoAfiliado) {
		this.porcentajeNoAfiliado = porcentajeNoAfiliado;
	}

	/**
	 * @return the tipoDistribucion
	 */
	public CatalogoValorDTO getTipoDistribucion() {
		return tipoDistribucion;
	}

	/**
	 * @param tipoDistribucion the tipoDistribucion to set
	 */
	public void setTipoDistribucion(CatalogoValorDTO tipoDistribucion) {
		this.tipoDistribucion = tipoDistribucion;
	}


	/**
	 * @return the proveedorClasificacionCol
	 */
	public Collection<ProveedorClasificacionDTO> getProveedorClasificacionCol() {
		return proveedorClasificacionCol;
	}

	/**
	 * @param proveedorClasificacionCol the proveedorClasificacionCol to set
	 */
	public void setProveedorClasificacionCol(
			Collection<ProveedorClasificacionDTO> proveedorClasificacionCol) {
		this.proveedorClasificacionCol = proveedorClasificacionCol;
	}

	/**
	 * @return the esAsignado
	 */
	public Boolean getEsAsignado() {
		return esAsignado;
	}

	/**
	 * @param esAsignado the esAsignado to set
	 */
	public void setEsAsignado(Boolean esAsignado) {
		this.esAsignado = esAsignado;
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
	 * @return the valorTipoEstructura
	 */
	public String getValorTipoEstructura() {
		return valorTipoEstructura;
	}

	/**
	 * @param valorTipoEstructura the valorTipoEstructura to set
	 */
	public void setValorTipoEstructura(String valorTipoEstructura) {
		this.valorTipoEstructura = valorTipoEstructura;
	}

	/**
	 * @return the codigoTipoEstructura
	 */
	public Integer getCodigoTipoEstructura() {
		return codigoTipoEstructura;
	}

	/**
	 * @param codigoTipoEstructura the codigoTipoEstructura to set
	 */
	public void setCodigoTipoEstructura(Integer codigoTipoEstructura) {
		this.codigoTipoEstructura = codigoTipoEstructura;
	}

	/**
	 * @return the tipoEstructura
	 */
	public CatalogoValorDTO getTipoEstructura() {
		return tipoEstructura;
	}

	/**
	 * @param tipoEstructura the tipoEstructura to set
	 */
	public void setTipoEstructura(CatalogoValorDTO tipoEstructura) {
		this.tipoEstructura = tipoEstructura;
	}

	/**
	 * @return the clasificacionRelacionadaPrincipal
	 */
	public Collection<ClasificacionRelacionadaDTO> getClasificacionRelacionadaPrincipal() {
		return clasificacionRelacionadaPrincipal;
	}

	/**
	 * @param clasificacionRelacionadaPrincipal the clasificacionRelacionadaPrincipal to set
	 */
	public void setClasificacionRelacionadaPrincipal(Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaPrincipal) {
		this.clasificacionRelacionadaPrincipal = clasificacionRelacionadaPrincipal;
	}

	/**
	 * @return the clasificacionRelacionadaSecundaria
	 */
	public Collection<ClasificacionRelacionadaDTO> getClasificacionRelacionadaSecundaria() {
		return clasificacionRelacionadaSecundaria;
	}

	/**
	 * @param clasificacionRelacionadaSecundaria the clasificacionRelacionadaSecundaria to set
	 */
	public void setClasificacionRelacionadaSecundaria(Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaSecundaria) {
		this.clasificacionRelacionadaSecundaria = clasificacionRelacionadaSecundaria;
	}

	public Integer getNumeroSubClasificacion() {
		return numeroSubClasificacion;
	}

	public void setNumeroSubClasificacion(Integer numeroSubClasificacion) {
		this.numeroSubClasificacion = numeroSubClasificacion;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getDesplegar() {
		return desplegar;
	}

	public void setDesplegar(Boolean desplegar) {
		this.desplegar = desplegar;
	}

	/**
	 * @return the codigoDescripcionClasificacion
	 */
	public String getCodigoDescripcionClasificacion() {
		codigoDescripcionClasificacion = this.getId().getCodigoClasificacion().concat(" ").concat(this.getDescripcionClasificacion());
		return codigoDescripcionClasificacion;
	}

	/**
	 * @param codigoDescripcionClasificacion the codigoDescripcionClasificacion to set
	 */
	public void setCodigoDescripcionClasificacion(String codigoDescripcionClasificacion) {
		this.codigoDescripcionClasificacion = this.getId().getCodigoClasificacion().concat(" ").concat(this.descripcionClasificacion);
	}

	public Boolean getDesplegado() {
		return desplegado;
	}

	public void setDesplegado(Boolean desplegado) {
		this.desplegado = desplegado;
	}

	public Boolean getAplicaRegistroSanitario() {
		return aplicaRegistroSanitario;
	}

	public void setAplicaRegistroSanitario(Boolean aplicaRegistroSanitario) {
		this.aplicaRegistroSanitario = aplicaRegistroSanitario;
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

//	public Collection<InscripcionNotificacionDTO> getInscripcionNotificacionDtoCol() {
//		return inscripcionNotificacionDtoCol;
//	}
//
//	public void setInscripcionNotificacionDtoCol(Collection<InscripcionNotificacionDTO> inscripcionNotificacionDtoCol) {
//		this.inscripcionNotificacionDtoCol = inscripcionNotificacionDtoCol;
//	}

	public Collection<ClasificacionRelacionadaDTO> getClasificacionRelacionadaDtoCol() {
		return clasificacionRelacionadaDtoCol;
	}

	public void setClasificacionRelacionadaDtoCol(Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDtoCol) {
		this.clasificacionRelacionadaDtoCol = clasificacionRelacionadaDtoCol;
	}

	public String getValorAplicaRegistroSanitario() {
		return valorAplicaRegistroSanitario;
	}

	public void setValorAplicaRegistroSanitario(String valorAplicaRegistroSanitario) {
		this.valorAplicaRegistroSanitario = valorAplicaRegistroSanitario;
	}

	public Integer getCodigoAplicaRegistroSanitario() {
		return codigoAplicaRegistroSanitario;
	}

	public void setCodigoAplicaRegistroSanitario(Integer codigoAplicaRegistroSanitario) {
		this.codigoAplicaRegistroSanitario = codigoAplicaRegistroSanitario;
	}

	public CatalogoValorDTO getCatalogoAplicaRegistroSanitario() {
		return catalogoAplicaRegistroSanitario;
	}

	public void setCatalogoAplicaRegistroSanitario(CatalogoValorDTO catalogoAplicaRegistroSanitario) {
		this.catalogoAplicaRegistroSanitario = catalogoAplicaRegistroSanitario;
	}
	
	public Collection<ContenedorDTO> getContenedorDTOCol() {
		return contenedorDTOCol;
	}

	public void setContenedorDTOCol(Collection<ContenedorDTO> contenedorDTOCol) {
		this.contenedorDTOCol = contenedorDTOCol;
	}

	/**
	 * @return the unificarCostoProveedor
	 */
	public Boolean getUnificarCostoProveedor() {
		return unificarCostoProveedor;
	}

	/**
	 * @param unificarCostoProveedor the unificarCostoProveedor to set
	 */
	public void setUnificarCostoProveedor(Boolean unificarCostoProveedor) {
		this.unificarCostoProveedor = unificarCostoProveedor;
	}

	/**
	 * @return the clasificacionArchivoCol
	 */
	public Collection<ClasificacionArchivoDTO> getClasificacionArchivoCol() {
		return clasificacionArchivoCol;
	}

	/**
	 * @param clasificacionArchivoCol the clasificacionArchivoCol to set
	 */
	public void setClasificacionArchivoCol(Collection<ClasificacionArchivoDTO> clasificacionArchivoCol) {
		this.clasificacionArchivoCol = clasificacionArchivoCol;
	}

	public boolean isMostrarListaClasificacion() {
		return mostrarListaClasificacion;
	}

	public void setMostrarListaClasificacion(boolean mostrarListaClasificacion) {
		this.mostrarListaClasificacion = mostrarListaClasificacion;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
