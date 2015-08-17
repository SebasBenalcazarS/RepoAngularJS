package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;
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
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEtiquetaMercanciaID;

/**
 * @author eharo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTETIMERC")
public class ArticuloEtiquetaMercanciaDTO extends SimpleAuditDTO{
	@EmbeddedId
	private ArticuloEtiquetaMercanciaID id = new ArticuloEtiquetaMercanciaID();
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	@ComparatorTypeField
	private String codigoArticulo;
	
	@Column(name = "NOMBREPRODUCTO", nullable = false)
	private String nombreProducto;
	
	@Column(name = "MARCACOMERCIAL", nullable = false)
	private String marcaComercial;
	
	@Column(name = "LOTE", nullable = false)
	private String lote;
	
	@Column(name = "MODELO", nullable = true)
	private String modelo;
	
	@Column(name = "CONTENIDONETO", nullable = true)
	private String contenidoNeto;
	
	/**
	 * Este campo sirve para la unidad de medida del contenido neto
	 */
	@Column(name = "CODIGOVALORTIPOUNIDADMEDIDA", nullable = true)
	private String codigoValorUnidadMedida;
	
	/**
	 * Este campo sirve para la unidad de medida del contenido neto
	 */
	@Column(name = "CODIGOTIPOUNIDADMEDIDA", nullable = true)
	private Integer codigoTipoUnidadMedida;
	
	/**
	 * ESTE CAMPOR ES FABRICADO POR SE RELIZO UN CAMBIO ANTES ERA RAZONSOCIALFABRICANTE
	 */
	@Column(name = "FABRICADOPOR", nullable = false)
	private String razonSocialFabricante;
	
	@Column(name = "DIRECCIONFABRICANTE", nullable = false)
	private String direccionFabricante;
	
	@Column(name = "RUCFABRICANTE", nullable = false)
	@ComparatorTypeField
	private String rucFabricante;
	
	@Column(name = "LISTACOMPONETES", nullable = true)
	private String listaComponentes;
	
	@Column(name = "CODIGODIVGEOPOL", nullable = false)
	private String codigoPaisFabricacion;
	
	@Column(name = "FECHAMAXIMAUSO", nullable = true)
	private Date fechaMaximoUso;
	
	@Column(name = "CONDICIONESCONSERVACION", nullable = true)
	private String condicionesConservacion;
	
	@Column(name = "NORMATECNICAREFERENCIA", nullable = true)
	private String normaTecnicaReferencia;
	
	@Column(name = "ADVERTENCIA", nullable = true)
	private String advertencia;
	
	@Column(name = "TIPOPRODUCTO", nullable = true)
	private String tipoProducto;
	
	/**
	 * ESTE CAMPO ES IMPORTADOPOR ANTES ESTA RAZONSOCIALIMPORTADOR
	 */
	@Column(name = "IMPORTADOPOR", nullable = false)
	private String razonSocialImportador;
	
	@Column(name = "DIRECCIONIMPORTADOR", nullable = false)
	private String direccionImportador;
	
	@Column(name = "RUCIMPORTADOR")
	@ComparatorTypeField
	private String rucImportador;
	
	@Column(name = "FECHAELABORACION")
	private Date fechaElaboracion;
	
	@Column(name = "TRADUCCION", nullable = true)
	private String traduccion;
	
	
	@Column(name = "INSTRUCCIONESDEUSO", nullable = true)
	private String instruccionesUso;
	
	@Column(name = "CARACTERISTICASESPECIALES", nullable = true)
	private String caracteristicasEspeciales;
	
	@Column(name = "ALTO")
	private String alto;
	
	@Column(name = "ANCHO")
	private String ancho;
	
	@Column(name = "PROFUNDIDAD")
	private String profundidad;
	
	@Column(name = "CODIGOVALORDIMENSIONES", nullable = true)
	private String codigoValorDimensiones;
	
	@Column(name = "CODIGOTIPODIMENSIONES", nullable = true)
	private Integer codigoTipoDimensiones;
	
	@Column(name = "CATEGORIA")
	private String categoria;
	
	@Column(name = "REGISTROSANITARIO")
	private String registroSanitario;
	
	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private String usuarioCreacion;
	
	@Column(name="IDUSUARIOMODIFICACION")
	@LastModifierUserIdField
	private String usuarioActualizacion;
	
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	private Timestamp fechaCreacion;
	
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	private Timestamp fechaUltimaActualizacion;
	
	
	
    
	/******************************************************************************************************************************/
    /***********TRANSIENT*********************************************************************************************************/
    /******************************************************************************************************************************/
	
	
	@Transient
	private String codigoBarras;
    
    @Transient
	private String numeroEtiquetas;
    
    @Transient
    private String paisFabricacionTras;
	
    @Transient
    private boolean eliminar;
    
    @Transient
	private String  descripcionTablaArticulo;
    
    @Transient
	private String  tamanio;
    
    @Transient
    private String dimension;

    
    /******************************************************************************************************************************/
    /***********RELACIONES*********************************************************************************************************/
    /******************************************************************************************************************************/
    
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOARTICULO",referencedColumnName="CODIGOARTICULO",insertable=false,updatable=false)})
	private ArticuloDTO articulo;
    
    
    @ManyToOne(fetch = LAZY)
	@JoinColumns(@JoinColumn(name="CODIGODIVGEOPOL", insertable=false, updatable=false, referencedColumnName="CODIGODIVGEOPOL"))
	private DivisionGeoPoliticaDTO paisFabricacion;
    
    
    
    /**
     * Relacion con el catalogo para las unidades de medida
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOVALORTIPOUNIDADMEDIDA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOUNIDADMEDIDA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private CatalogoValorDTO unidadMedidaCatalogo;

    
    
    /**
     * Relacion con el catalog para las dimensiones
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOVALORDIMENSIONES", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPODIMENSIONES", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private CatalogoValorDTO dimensionCatalogo;


    /***
     * Relacion intermedia entre mercancia y catalogo
     * @author ellinin
     */
    @OneToMany(mappedBy="articuloEtiquetaMercanciaDTO")
    private Collection<ArticuloEtiquetaMercanciaCatalogoDTO> articuloEtiquetaMercanciaCatalogoCol; 
    
    /******************************************************************************************************************************/
    /******************************************************************************************************************************/
    /******************************************************************************************************************************/
    
    
    
    /****************************************************************************************************************************************************/
    /****************************************************************************************************************************************************/
    /****************METODS******************************************************************************************************************************/
    /************************GETTER**********************************************************************************************************************/
    /********************************SETTER**************************************************************************************************************/
    /****************************************************************************************************************************************************/
    /****************************************************************************************************************************************************/
    

	/**
	 * @return the id
	 */
	public ArticuloEtiquetaMercanciaID getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloEtiquetaMercanciaID id) {
		this.id = id;
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
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}



	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}



	/**
	 * @return the marcaComercial
	 */
	public String getMarcaComercial() {
		return marcaComercial;
	}



	/**
	 * @param marcaComercial the marcaComercial to set
	 */
	public void setMarcaComercial(String marcaComercial) {
		this.marcaComercial = marcaComercial;
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
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}



	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	/**
	 * @return the contenidoNeto
	 */
	public String getContenidoNeto() {
		return contenidoNeto;
	}



	/**
	 * @param contenidoNeto the contenidoNeto to set
	 */
	public void setContenidoNeto(String contenidoNeto) {
		this.contenidoNeto = contenidoNeto;
	}



	/**
	 * @return the codigoValorUnidadMedida
	 */
	public String getCodigoValorUnidadMedida() {
		return codigoValorUnidadMedida;
	}



	/**
	 * @param codigoValorUnidadMedida the codigoValorUnidadMedida to set
	 */
	public void setCodigoValorUnidadMedida(String codigoValorUnidadMedida) {
		this.codigoValorUnidadMedida = codigoValorUnidadMedida;
	}



	/**
	 * @return the codigoTipoUnidadMedida
	 */
	public Integer getCodigoTipoUnidadMedida() {
		return codigoTipoUnidadMedida;
	}



	/**
	 * @param codigoTipoUnidadMedida the codigoTipoUnidadMedida to set
	 */
	public void setCodigoTipoUnidadMedida(Integer codigoTipoUnidadMedida) {
		this.codigoTipoUnidadMedida = codigoTipoUnidadMedida;
	}



	/**
	 * @return the razonSocialFabricante
	 */
	public String getRazonSocialFabricante() {
		return razonSocialFabricante;
	}



	/**
	 * @param razonSocialFabricante the razonSocialFabricante to set
	 */
	public void setRazonSocialFabricante(String razonSocialFabricante) {
		this.razonSocialFabricante = razonSocialFabricante;
	}



	/**
	 * @return the direccionFabricante
	 */
	public String getDireccionFabricante() {
		return direccionFabricante;
	}



	/**
	 * @param direccionFabricante the direccionFabricante to set
	 */
	public void setDireccionFabricante(String direccionFabricante) {
		this.direccionFabricante = direccionFabricante;
	}



	/**
	 * @return the rucFabricante
	 */
	public String getRucFabricante() {
		return rucFabricante;
	}



	/**
	 * @param rucFabricante the rucFabricante to set
	 */
	public void setRucFabricante(String rucFabricante) {
		this.rucFabricante = rucFabricante;
	}



	/**
	 * @return the listaComponentes
	 */
	public String getListaComponentes() {
		return listaComponentes;
	}



	/**
	 * @param listaComponentes the listaComponentes to set
	 */
	public void setListaComponentes(String listaComponentes) {
		this.listaComponentes = listaComponentes;
	}



	/**
	 * @return the codigoPaisFabricacion
	 */
	public String getCodigoPaisFabricacion() {
		return codigoPaisFabricacion;
	}



	/**
	 * @param codigoPaisFabricacion the codigoPaisFabricacion to set
	 */
	public void setCodigoPaisFabricacion(String codigoPaisFabricacion) {
		this.codigoPaisFabricacion = codigoPaisFabricacion;
	}



	/**
	 * @return the fechaMaximoUso
	 */
	public Date getFechaMaximoUso() {
		return fechaMaximoUso;
	}



	/**
	 * @param fechaMaximoUso the fechaMaximoUso to set
	 */
	public void setFechaMaximoUso(Date fechaMaximoUso) {
		this.fechaMaximoUso = fechaMaximoUso;
	}



	/**
	 * @return the condicionesConservacion
	 */
	public String getCondicionesConservacion() {
		return condicionesConservacion;
	}



	/**
	 * @param condicionesConservacion the condicionesConservacion to set
	 */
	public void setCondicionesConservacion(String condicionesConservacion) {
		this.condicionesConservacion = condicionesConservacion;
	}



	/**
	 * @return the normaTecnicaReferencia
	 */
	public String getNormaTecnicaReferencia() {
		return normaTecnicaReferencia;
	}



	/**
	 * @param normaTecnicaReferencia the normaTecnicaReferencia to set
	 */
	public void setNormaTecnicaReferencia(String normaTecnicaReferencia) {
		this.normaTecnicaReferencia = normaTecnicaReferencia;
	}



	/**
	 * @return the advertencia
	 */
	public String getAdvertencia() {
		return advertencia;
	}



	/**
	 * @param advertencia the advertencia to set
	 */
	public void setAdvertencia(String advertencia) {
		this.advertencia = advertencia;
	}



	/**
	 * @return the tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}



	/**
	 * @param tipoProducto the tipoProducto to set
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}



	/**
	 * @return the razonSocialImportador
	 */
	public String getRazonSocialImportador() {
		return razonSocialImportador;
	}



	/**
	 * @param razonSocialImportador the razonSocialImportador to set
	 */
	public void setRazonSocialImportador(String razonSocialImportador) {
		this.razonSocialImportador = razonSocialImportador;
	}



	/**
	 * @return the direccionImportador
	 */
	public String getDireccionImportador() {
		return direccionImportador;
	}



	/**
	 * @param direccionImportador the direccionImportador to set
	 */
	public void setDireccionImportador(String direccionImportador) {
		this.direccionImportador = direccionImportador;
	}



	/**
	 * @return the rucImportador
	 */
	public String getRucImportador() {
		return rucImportador;
	}



	/**
	 * @param rucImportador the rucImportador to set
	 */
	public void setRucImportador(String rucImportador) {
		this.rucImportador = rucImportador;
	}



	/**
	 * @return the fechaElaboracion
	 */
	public Date getFechaElaboracion() {
		return fechaElaboracion;
	}



	/**
	 * @param fechaElaboracion the fechaElaboracion to set
	 */
	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}



	/**
	 * @return the traduccion
	 */
	public String getTraduccion() {
		return traduccion;
	}



	/**
	 * @param traduccion the traduccion to set
	 */
	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}



	/**
	 * @return the instruccionesUso
	 */
	public String getInstruccionesUso() {
		return instruccionesUso;
	}



	/**
	 * @param instruccionesUso the instruccionesUso to set
	 */
	public void setInstruccionesUso(String instruccionesUso) {
		this.instruccionesUso = instruccionesUso;
	}



	/**
	 * @return the caracteristicasEspeciales
	 */
	public String getCaracteristicasEspeciales() {
		return caracteristicasEspeciales;
	}



	/**
	 * @param caracteristicasEspeciales the caracteristicasEspeciales to set
	 */
	public void setCaracteristicasEspeciales(String caracteristicasEspeciales) {
		this.caracteristicasEspeciales = caracteristicasEspeciales;
	}



	/**
	 * @return the alto
	 */
	public String getAlto() {
		return alto;
	}



	/**
	 * @param alto the alto to set
	 */
	public void setAlto(String alto) {
		this.alto = alto;
	}



	/**
	 * @return the ancho
	 */
	public String getAncho() {
		return ancho;
	}



	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(String ancho) {
		this.ancho = ancho;
	}



	/**
	 * @return the profundidad
	 */
	public String getProfundidad() {
		return profundidad;
	}



	/**
	 * @param profundidad the profundidad to set
	 */
	public void setProfundidad(String profundidad) {
		this.profundidad = profundidad;
	}



	/**
	 * @return the codigoValorDimensiones
	 */
	public String getCodigoValorDimensiones() {
		return codigoValorDimensiones;
	}



	/**
	 * @param codigoValorDimensiones the codigoValorDimensiones to set
	 */
	public void setCodigoValorDimensiones(String codigoValorDimensiones) {
		this.codigoValorDimensiones = codigoValorDimensiones;
	}



	/**
	 * @return the codigoTipoDimensiones
	 */
	public Integer getCodigoTipoDimensiones() {
		return codigoTipoDimensiones;
	}



	/**
	 * @param codigoTipoDimensiones the codigoTipoDimensiones to set
	 */
	public void setCodigoTipoDimensiones(Integer codigoTipoDimensiones) {
		this.codigoTipoDimensiones = codigoTipoDimensiones;
	}



	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}



	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	/**
	 * @return the registroSanitario
	 */
	public String getRegistroSanitario() {
		return registroSanitario;
	}



	/**
	 * @param registroSanitario the registroSanitario to set
	 */
	public void setRegistroSanitario(String registroSanitario) {
		this.registroSanitario = registroSanitario;
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
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}



	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}



	/**
	 * @return the numeroEtiquetas
	 */
	public String getNumeroEtiquetas() {
		return numeroEtiquetas;
	}



	/**
	 * @param numeroEtiquetas the numeroEtiquetas to set
	 */
	public void setNumeroEtiquetas(String numeroEtiquetas) {
		this.numeroEtiquetas = numeroEtiquetas;
	}



	/**
	 * @return the paisFabricacionTras
	 */
	public String getPaisFabricacionTras() {
		return paisFabricacionTras;
	}



	/**
	 * @param paisFabricacionTras the paisFabricacionTras to set
	 */
	public void setPaisFabricacionTras(String paisFabricacionTras) {
		this.paisFabricacionTras = paisFabricacionTras;
	}



	/**
	 * @return the eliminar
	 */
	public boolean isEliminar() {
		return eliminar;
	}



	/**
	 * @param eliminar the eliminar to set
	 */
	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}



	/**
	 * @return the descripcionTablaArticulo
	 */
	public String getDescripcionTablaArticulo() {
		return descripcionTablaArticulo;
	}



	/**
	 * @param descripcionTablaArticulo the descripcionTablaArticulo to set
	 */
	public void setDescripcionTablaArticulo(String descripcionTablaArticulo) {
		this.descripcionTablaArticulo = descripcionTablaArticulo;
	}



	/**
	 * @return the tamanio
	 */
	public String getTamanio() {
		return tamanio;
	}



	/**
	 * @param tamanio the tamanio to set
	 */
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}



	/** 
	 * @return the dimension
	 */
	public String getDimension() {		
		return this.dimension;
	}

	/**
	 * Metodo obtenerDimension concatena Alto, Ancho, profundidad y Unidad de medida
	 * @return the dimension
	 */
	public String getObtenerDimension(){
		this.dimension = StringUtils.EMPTY;
		if (this.alto != null && this.ancho != null && this.profundidad != null && this.codigoValorDimensiones != null ) {
			this.dimension =  this.alto.concat("x").concat(this.ancho).concat("x").concat(this.profundidad).concat(this.codigoValorDimensiones);
		}		
		return this.dimension;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}



	/**
	 * @return the articulo
	 */
	public ArticuloDTO getArticulo() {
		return articulo;
	}



	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}



	/**
	 * @return the paisFabricacion
	 */
	public DivisionGeoPoliticaDTO getPaisFabricacion() {
		return paisFabricacion;
	}



	/**
	 * @param paisFabricacion the paisFabricacion to set
	 */
	public void setPaisFabricacion(DivisionGeoPoliticaDTO paisFabricacion) {
		this.paisFabricacion = paisFabricacion;
	}



	/**
	 * @return the unidadMedidaCatalogo
	 */
	public CatalogoValorDTO getUnidadMedidaCatalogo() {
		return unidadMedidaCatalogo;
	}



	/**
	 * @param unidadMedidaCatalogo the unidadMedidaCatalogo to set
	 */
	public void setUnidadMedidaCatalogo(CatalogoValorDTO unidadMedidaCatalogo) {
		this.unidadMedidaCatalogo = unidadMedidaCatalogo;
	}



	/**
	 * @return the dimensionCatalogo
	 */
	public CatalogoValorDTO getDimensionCatalogo() {
		return dimensionCatalogo;
	}



	/**
	 * @param dimensionCatalogo the dimensionCatalogo to set
	 */
	public void setDimensionCatalogo(CatalogoValorDTO dimensionCatalogo) {
		this.dimensionCatalogo = dimensionCatalogo;
	}



	/**
	 * @return the articuloEtiquetaMercanciaCatalogoCol
	 */
	public Collection<ArticuloEtiquetaMercanciaCatalogoDTO> getArticuloEtiquetaMercanciaCatalogoCol() {
		return articuloEtiquetaMercanciaCatalogoCol;
	}



	/**
	 * @param articuloEtiquetaMercanciaCatalogoCol the articuloEtiquetaMercanciaCatalogoCol to set
	 */
	public void setArticuloEtiquetaMercanciaCatalogoCol(Collection<ArticuloEtiquetaMercanciaCatalogoDTO> articuloEtiquetaMercanciaCatalogoCol) {
		this.articuloEtiquetaMercanciaCatalogoCol = articuloEtiquetaMercanciaCatalogoCol;
	}
	
	
}