/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ec.com.smx.sic.cliente.common.articulo.EnumRegistroEdicionMasiva;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionBase;

/**
 * @author guvidia, corbe
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties( ignoreUnknown = true )
public class ArticuloEdicionMasivaVO extends ArticuloEdicionBase {

	private String id;
	//datos del articulo
	private String codigoBarrasArticulo;
	private String descripcion;	
	private String codigoClase;
	private String clasificacion;
	private String subClasificacion;
	//fechas a asignar en la busqueda
	private Date fechaInicialTemporada;
	private Date fechaFinalTemporada;
	//marca comercial
	private String marcaComercial;
	private Long codigoMarcaComercial;
	//marca participacion
	private String marcaParticipacion;	
	//verificaFechaCaducidad
	private Boolean verificaFechaCaducidad;
	//pais origen
	private String paisOrigen;
	private String codigoPaisOrigen;
	//lugar compra
	private String lugarCompra;
	private Long codigoLugarCompra;
	//medida
	private String tamanio;
	//articulo proveedor
	private String codigoProveedor;
	private String referenciaInterna;	
	private String referenciaExterna;
	private String origenProveedor;
	private String esImportador;
	private Boolean esArticuloImportado;
	//agrupador
	private String agrupador;
	private Integer codigoTipoAgrupador;
	private String valorTipoAgrupador;
	//agrupador caracteristica especial
	private Collection<ArticuloEdicionMasivaVO> caracteristicasEspeciales;
	//duracion conservacion
	private Integer tiempoVidaUtil;
	private Integer tiempoRefrigeracion;	
	private Integer tiempoCongelacion;
	private Integer tiempoDuracionConservacion;
	private String valorTipoConservacion;
	private Integer codigoTipoConservacion;
	//articulo material
	private String material;
	//articulo importacion
	private BigDecimal costoMonedaOrigen;
	private Double porcentajeComision;
	//control precio
	private String tipoControlPrecio;
	private String codigoTipoControlPrecio;
	//prototipo
	private String prototipoAlcance;
	private Long codigoPrototipoAlcance;
	private Boolean existeCambioPrototipo = Boolean.FALSE;
	//PROPIDADES PARA EL USO DE IMPUESTOS
	private Boolean esParaVenta;
	private Boolean esParaCompra;
	private Integer codigoTipoImpuesto; 
	//coleccion de impuestos
	private Set<ArticuloEdicionMasivaVO> articuloImpuestoCol;
	
	private Map<Object, Object> impuestos;
	
	private Boolean isParent;
	
	private String event;
	private Map<Object, Object> noEditable;
	
	//coleccion de proveedores
	private Collection<ArticuloEdicionMasivaVO> proveedorCol;
	
	private Set<EnumRegistroEdicionMasiva> enumRegistroEdicionMasiva;
	
	private Map<String, Object> mapaDatosArticulos;
	
	private Map<String,Object> dynamicProperties;
	private Set<String> codigosAreasTrabajo;
	
	private Boolean validacionRegistroWarning = Boolean.FALSE;
	
	private Boolean validacionRegistroError = Boolean.FALSE;
	// variables para causal cambio de clase
	private String causal;
	private Boolean aplicaCausal;
	private Long secuencialArtCla;
	private Integer codigoTipoCausal;
	private String valorTipoCausal;
	private String claseArticuloAnterior;
	private ArticuloClaseDTO articuloClaseDTO;
	//coleccion que almacena los errores por la cual no se registra un articulo
	private Collection<String> erroresRegistro;
	
	//codigo de la opcion de la cual va a ser registrado el articulo
	private String codigoOpcion;
	
	/**
	 * 
	 */
	public ArticuloEdicionMasivaVO() {
		if( this.mapaDatosArticulos == null )
			this.mapaDatosArticulos = new HashMap<String, Object>();
	}
	
	private void costruirMap(String key, Object value){		
		this.mapaDatosArticulos.put(key, value);		
	}

	/**
	 * @return the mapaDatosArticulos
	 */
	public Map<String, Object> getMapaDatosArticulos() {
		return mapaDatosArticulos;
	}

	/**
	 * @return the codigoBarrasArticulo
	 */
	public String getCodigoBarrasArticulo() {
		return codigoBarrasArticulo;
	}


	/**
	 * @param codigoBarrasArticulo the codigoBarrasArticulo to set
	 */
	public void setCodigoBarrasArticulo(String codigoBarrasArticulo) {
		this.codigoBarrasArticulo = codigoBarrasArticulo;
		this.costruirMap("codigoBarrasArticulo", codigoBarrasArticulo);
	}

	public Boolean getAplicaCausal() {
		return aplicaCausal;
	}

	public void setAplicaCausal(Boolean aplicaCausal) {
		this.aplicaCausal = aplicaCausal;
	}

	/**
	 * @return the codigoPaisOrigen
	 */
	public String getCodigoPaisOrigen() {
		return codigoPaisOrigen;
	}

	/**
	 * @param codigoPaisOrigen the codigoPaisOrigen to set
	 */
	public void setCodigoPaisOrigen(String codigoPaisOrigen) {
		this.codigoPaisOrigen = codigoPaisOrigen;
		this.costruirMap("codigoPaisOrigen", codigoPaisOrigen);
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
		this.costruirMap("descripcion", descripcion);
	}


	/**
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}


	/**
	 * @param clase the clase to set
	 */
	public void setClase(String clase) {
		this.clase = clase;
		this.costruirMap("clase", clase);
	}


	/**
	 * @return the clasificacion
	 */
	public String getClasificacion() {
		return clasificacion;
	}


	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
		this.costruirMap("clasificacion", clasificacion);
	}


	/**
	 * @return the subClasificacion
	 */
	public String getSubClasificacion() {
		return subClasificacion;
	}


	/**
	 * @param subClasificacion the subClasificacion to set
	 */
	public void setSubClasificacion(String subClasificacion) {
		this.subClasificacion = subClasificacion;
		this.costruirMap("subClasificacion", subClasificacion);
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
		this.costruirMap("marcaComercial", marcaComercial);
	}


	/**
	 * @return the marcaParticipacion
	 */
	public String getMarcaParticipacion() {
		return marcaParticipacion;
	}


	/**
	 * @param marcaParticipacion the marcaParticipacion to set
	 */
	public void setMarcaParticipacion(String marcaParticipacion) {
		this.marcaParticipacion = marcaParticipacion;
		this.costruirMap("marcaParticipacion", marcaParticipacion);
	}


	/**
	 * @return the paisOrigen
	 */
	public String getPaisOrigen() {
		return paisOrigen;
	}


	/**
	 * @param paisOrigen the paisOrigen to set
	 */
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
		this.costruirMap("paisOrigen", paisOrigen);
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
		this.costruirMap("tamanio", tamanio);
	}


	/**
	 * @return the referenciaInterna
	 */
	public String getReferenciaInterna() {
		return referenciaInterna;
	}


	/**
	 * @param referenciaInterna the referenciaInterna to set
	 */
	public void setReferenciaInterna(String referenciaInterna) {
		this.referenciaInterna = referenciaInterna;
		this.costruirMap("referenciaInterna", referenciaInterna);
	}


	/**
	 * @return the agrupador
	 */
	public String getAgrupador() {
		return agrupador;
	}


	/**
	 * @param agrupador the agrupador to set
	 */
	public void setAgrupador(String agrupador) {
		this.agrupador = agrupador;
		this.costruirMap("agrupador", agrupador);
	}


	/**
	 * @return the tiempoVidaUtil
	 */
	public Integer getTiempoVidaUtil() {
		return tiempoVidaUtil;
	}


	/**
	 * @param tiempoVidaUtil the tiempoVidaUtil to set
	 */
	public void setTiempoVidaUtil(Integer tiempoVidaUtil) {
		this.tiempoVidaUtil = tiempoVidaUtil;
		this.costruirMap("tiempoVidaUtil", tiempoVidaUtil);
	}


	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}


	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
		this.costruirMap("material", material);
	}

	/**
	 * @return the tiempoRefrigeracion
	 */
	public Integer getTiempoRefrigeracion() {
		return tiempoRefrigeracion;
	}


	/**
	 * @param tiempoRefrigeracion the tiempoRefrigeracion to set
	 */
	public void setTiempoRefrigeracion(Integer tiempoRefrigeracion) {
		this.tiempoRefrigeracion = tiempoRefrigeracion;
		this.costruirMap("tiempoRefrigeracion", tiempoRefrigeracion);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
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
		this.costruirMap("codigoArticulo", codigoArticulo);
	}

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
		this.costruirMap("codigoCompania", codigoCompania);
	}


	/**
	 * @return the prototipoAlcance
	 */
	public String getPrototipoAlcance() {
		return prototipoAlcance;
	}

	/**
	 * @param prototipoAlcance the prototipoAlcance to set
	 */
	public void setPrototipoAlcance(String prototipoAlcance) {
		this.prototipoAlcance = prototipoAlcance;
		this.costruirMap("prototipoAlcance", prototipoAlcance);
	}
	


	/**
	 * @return the codigoPrototipoAlcance
	 */
	public Long getCodigoPrototipoAlcance() {
		return codigoPrototipoAlcance;
	}

	/**
	 * @param codigoPrototipoAlcance the codigoPrototipoAlcance to set
	 */
	public void setCodigoPrototipoAlcance(Long codigoPrototipoAlcance) {
		this.codigoPrototipoAlcance = codigoPrototipoAlcance;
		this.costruirMap("codigoPrototipoAlcance", codigoPrototipoAlcance);
	}

	/**
	 * @return the fechaInicioTemporada
	 */
	public String getFechaInicioTemporada() {
		return fechaInicioTemporada;
	}

	/**
	 * @param fechaInicioTemporada the fechaInicioTemporada to set
	 */
	public void setFechaInicioTemporada(String fechaInicioTemporada) {
		this.fechaInicioTemporada = fechaInicioTemporada;
		this.costruirMap("fechaInicioTemporada", fechaInicioTemporada);
	}

	/**
	 * @return the fechaFinTemporada
	 */
	public String getFechaFinTemporada() {
		return fechaFinTemporada;
	}

	/**
	 * @param fechaFinTemporada the fechaFinTemporada to set
	 */
	public void setFechaFinTemporada(String fechaFinTemporada) {
		this.fechaFinTemporada = fechaFinTemporada;
		this.costruirMap("fechaFinTemporada", fechaFinTemporada);
	}

	/**
	 * @return the verificaFechaCaducidad
	 */
	public Boolean getVerificaFechaCaducidad() {
		return verificaFechaCaducidad;
	}

	/**
	 * @param verificaFechaCaducidad the verificaFechaCaducidad to set
	 */
	public void setVerificaFechaCaducidad(Boolean verificaFechaCaducidad) {
		this.verificaFechaCaducidad = verificaFechaCaducidad;
		this.costruirMap("verificaFechaCaducidad", verificaFechaCaducidad);
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
		this.costruirMap("codigoProveedor", codigoProveedor);
	}

	/**
	 * @return the referenciaExterna
	 */
	public String getReferenciaExterna() {
		return referenciaExterna;
	}

	/**
	 * @param referenciaExterna the referenciaExterna to set
	 */
	public void setReferenciaExterna(String referenciaExterna) {
		this.referenciaExterna = referenciaExterna;
		this.costruirMap("referenciaExterna", referenciaExterna);
	}

	/**
	 * @return the costoMonedaOrigen
	 */
	public BigDecimal getCostoMonedaOrigen() {
		return costoMonedaOrigen;
	}

	/**
	 * @param costoMonedaOrigen the costoMonedaOrigen to set
	 */
	public void setCostoMonedaOrigen(BigDecimal costoMonedaOrigen) {
		this.costoMonedaOrigen = costoMonedaOrigen;
		this.costruirMap("costoMonedaOrigen", costoMonedaOrigen);
	}

	/**
	 * @return the porcentajeComision
	 */
	public Double getPorcentajeComision() {
		return porcentajeComision;
	}

	/**
	 * @param porcentajeComision the porcentajeComision to set
	 */
	public void setPorcentajeComision(Double porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
		this.costruirMap("porcentajeComision", porcentajeComision);
	}

	/**
	 * @return the tipoControlPrecio
	 */
	public String getTipoControlPrecio() {
		return tipoControlPrecio;
	}

	/**
	 * @param tipoControlPrecio the tipoControlPrecio to set
	 */
	public void setTipoControlPrecio(String tipoControlPrecio) {
		this.tipoControlPrecio = tipoControlPrecio;
		this.costruirMap("tipoControlPrecio", tipoControlPrecio);
	}

	/**
	 * @return the proveedorCol
	 */
	public Collection<ArticuloEdicionMasivaVO> getProveedorCol() {
		return proveedorCol;
	}

	/**
	 * @param proveedorCol the proveedorCol to set
	 */
	public void setProveedorCol(Collection<ArticuloEdicionMasivaVO> proveedorCol) {
		this.proveedorCol = proveedorCol;
		this.costruirMap("proveedorCol", proveedorCol);
	}

	/**
	 * @return the tiempoCongelacion
	 */
	public Integer getTiempoCongelacion() {
		return tiempoCongelacion;
	}

	/**
	 * @param tiempoCongelacion the tiempoCongelacion to set
	 */
	public void setTiempoCongelacion(Integer tiempoCongelacion) {
		this.tiempoCongelacion = tiempoCongelacion;
		this.costruirMap("tiempoCongelacion", tiempoCongelacion);
	}

	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @param mapaDatosArticulos the mapaDatosArticulos to set
	 */
	public void setMapaDatosArticulos(Map<String, Object> mapaDatosArticulos) {
		this.mapaDatosArticulos = mapaDatosArticulos;
	}
	
	/**
	 * @return the noEditable
	 */
	public Map<Object, Object> getNoEditable() {
		return noEditable;
	}

	/**
	 * @param noEditable the noEditable to set
	 */
	public void setNoEditable(Map<Object, Object> noEditable) {
		this.noEditable = noEditable;
	}

	/**
	 * @return the codigoMarcaComercial
	 */
	public Long getCodigoMarcaComercial() {
		return codigoMarcaComercial;
	}

	/**
	 * @param codigoMarcaComercial the codigoMarcaComercial to set
	 */
	public void setCodigoMarcaComercial(Long codigoMarcaComercial) {
		this.codigoMarcaComercial = codigoMarcaComercial;
		this.costruirMap("codigoMarcaComercial", codigoMarcaComercial);
	}

	/**
	 * @return the valorTipoConservacion
	 */
	public String getValorTipoConservacion() {
		return valorTipoConservacion;
	}

	/**
	 * @param valorTipoConservacion the valorTipoConservacion to set
	 */
	public void setValorTipoConservacion(String valorTipoConservacion) {
		this.valorTipoConservacion = valorTipoConservacion;
	}

	/**
	 * @return the codigoTipoConservacion
	 */
	public Integer getCodigoTipoConservacion() {
		return codigoTipoConservacion;
	}

	/**
	 * @param codigoTipoConservacion the codigoTipoConservacion to set
	 */
	public void setCodigoTipoConservacion(Integer codigoTipoConservacion) {
		this.codigoTipoConservacion = codigoTipoConservacion;
	}

	/**
	 * @return the tiempoDuracionConservacion
	 */
	public Integer getTiempoDuracionConservacion() {
		return tiempoDuracionConservacion;
	}

	/**
	 * @param tiempoDuracionConservacion the tiempoDuracionConservacion to set
	 */
	public void setTiempoDuracionConservacion(Integer tiempoDuracionConservacion) {
		this.tiempoDuracionConservacion = tiempoDuracionConservacion;
	}

	/**
	 * @return the enumRegistroEdicionMasiva
	 */
	public Set<EnumRegistroEdicionMasiva> getEnumRegistroEdicionMasiva() {
		return enumRegistroEdicionMasiva;
	}

	/**
	 * @param enumRegistroEdicionMasiva the enumRegistroEdicionMasiva to set
	 */
	public void setEnumRegistroEdicionMasiva(Set<EnumRegistroEdicionMasiva> enumRegistroEdicionMasiva) {
		this.enumRegistroEdicionMasiva = enumRegistroEdicionMasiva;
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
	 * @return the esImportador
	 */
	public String getEsImportador() {
		return esImportador;
	}

	/**
	 * @param esImportador the esImportador to set
	 */
	public void setEsImportador(String esImportador) {
		this.esImportador = esImportador;
	}

	/**
	 * @return the esArticuloImportado
	 */
	public Boolean getEsArticuloImportado() {
		return esArticuloImportado;
	}

	/**
	 * @param esArticuloImportado the esArticuloImportado to set
	 */
	public void setEsArticuloImportado(Boolean esArticuloImportado) {
		this.esArticuloImportado = esArticuloImportado;
	}
	
	public Boolean getEsParaVenta() {
		return esParaVenta;
	}

	public void setEsParaVenta(Boolean esParaVenta) {
		this.esParaVenta = esParaVenta;
		this.costruirMap("esParaVenta", esParaVenta);
	}
	
	public Boolean getEsParaCompra() {
		return esParaCompra;
	}

	public void setEsParaCompra(Boolean esParaCompra) {
		this.esParaCompra = esParaCompra;
		this.costruirMap("esParaCompra", esParaCompra);
	}
	
	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
		this.costruirMap("codigoTipoImpuesto", codigoTipoImpuesto);
	}

	public Collection<ArticuloEdicionMasivaVO> getArticuloImpuestoCol() {
		return articuloImpuestoCol;
	}

	public void setArticuloImpuestoCol(Set<ArticuloEdicionMasivaVO> articuloImpuestoCol) {
		this.articuloImpuestoCol = articuloImpuestoCol;
		this.costruirMap("articuloImpuestoCol", articuloImpuestoCol);
	}
	
	public String getCausal() {
		return causal;
	}

	public void setCausal(String causal) {
		this.causal = causal;
		this.costruirMap("causal", causal);
	}

	public Integer getCodigoTipoCausal() {
		return codigoTipoCausal;
	}

	public void setCodigoTipoCausal(Integer codigoTipoCausal) {
		this.codigoTipoCausal = codigoTipoCausal;
		this.costruirMap("codigoTipoCausal", codigoTipoCausal);
	}
	
	public String getValorTipoCausal() {
		if(this.valorTipoCausal == null && StringUtils.isNotEmpty(this.causal)){
			this.valorTipoCausal = StringUtils.substring(this.causal, 0, 3);
		}
		return valorTipoCausal;
	}

	public void setValorTipoCausal(String valorTipoCausal) {
		this.valorTipoCausal = valorTipoCausal;
		this.costruirMap("valorTipoCausal", valorTipoCausal);
	}

	public String getClaseArticuloAnterior() {
		return claseArticuloAnterior;
	}

	public void setClaseArticuloAnterior(String claseArticuloAnterior) {
		this.claseArticuloAnterior = claseArticuloAnterior;
	}
	
	public ArticuloClaseDTO getArticuloClaseDTO() {
		return articuloClaseDTO;
	}

	public void setArticuloClaseDTO(ArticuloClaseDTO articuloClaseDTO) {
		this.articuloClaseDTO = articuloClaseDTO;
	}
	
	public Long getSecuencialArtCla() {
		return secuencialArtCla;
	}

	public void setSecuencialArtCla(Long secuencialArtCla) {
		this.secuencialArtCla = secuencialArtCla;
	}
	
	public Map<Object, Object> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Map<Object, Object> impuestos) {
		this.impuestos = impuestos;
	}

	//-------------------------------------------------------
	//--------METODOS DE PROPIEDADES DINAMICAS
	//-------------------------------------------------------
	
	public<T> void addDynamicProperty(String name,T value){
		if(this.dynamicProperties == null){
			dynamicProperties = new HashMap<String,Object>();
		}
		dynamicProperties.put(name, value);
	}
	
	public Object getDynamicProperty(String name){
		if(this.dynamicProperties == null){
			return null;
		}
		
		return dynamicProperties.get(name);
	}
	
	public void removeDynamicProperty(String name){
		if(this.dynamicProperties != null){
			dynamicProperties.remove(name);
		}
		
	}
	
	public void setDynamicProperties(Map<String, Object> dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	
	public Boolean hasDynamicProperty(String name){
		if(this.dynamicProperties == null){
			return Boolean.FALSE;
		}
		return dynamicProperties.containsKey(name);
	}

	

	/**
	 * @return the codigosAreasTrabajo
	 */
	public Set<String> getCodigosAreasTrabajo() {
		return codigosAreasTrabajo;
	}

	/**
	 * @param codigosAreasTrabajo the codigosAreasTrabajo to set
	 */
	public void setCodigosAreasTrabajo(Set<String> codigosAreasTrabajo) {
		this.codigosAreasTrabajo = codigosAreasTrabajo;
	}

	/**
	 * @return the isParent
	 */
	public Boolean getIsParent() {
		return isParent;
	}

	/**
	 * @param isParent the isParent to set
	 */
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}


	/**
	 * @return the codigoTipoAgrupador
	 */
	public Integer getCodigoTipoAgrupador() {
		return codigoTipoAgrupador;
	}

	/**
	 * @param codigoTipoAgrupador the codigoTipoAgrupador to set
	 */
	public void setCodigoTipoAgrupador(Integer codigoTipoAgrupador) {
		this.codigoTipoAgrupador = codigoTipoAgrupador;
	}

	/**
	 * @return the valorTipoAgrupador
	 */
	public String getValorTipoAgrupador() {
		return valorTipoAgrupador;
	}

	/**
	 * @param valorTipoAgrupador the valorTipoAgrupador to set
	 */
	public void setValorTipoAgrupador(String valorTipoAgrupador) {
		this.valorTipoAgrupador = valorTipoAgrupador;
	}
	
	/**
	 * @return the codigoTipoControlPrecio
	 */
	public String getCodigoTipoControlPrecio() {
		return codigoTipoControlPrecio;
	}

	/**
	 * @param codigoTipoControlPrecio the codigoTipoControlPrecio to set
	 */
	public void setCodigoTipoControlPrecio(String codigoTipoControlPrecio) {
		this.codigoTipoControlPrecio = codigoTipoControlPrecio;
		this.costruirMap("codigoTipoControlPrecio", codigoTipoControlPrecio);
	}

	/**
	 * @return the existeCambioPrototipo
	 */
	public Boolean getExisteCambioPrototipo() {
		return existeCambioPrototipo;
	}

	/**
	 * @param existeCambioPrototipo the existeCambioPrototipo to set
	 */
	public void setExisteCambioPrototipo(Boolean existeCambioPrototipo) {
		this.existeCambioPrototipo = existeCambioPrototipo;
	}

	/**
	 * @return the fechaInicialTemporada
	 */
	public Date getFechaInicialTemporada() {
		return fechaInicialTemporada;
	}

	/**
	 * @param fechaInicialTemporada the fechaInicialTemporada to set
	 */
	public void setFechaInicialTemporada(Date fechaInicialTemporada) {
		this.fechaInicialTemporada = fechaInicialTemporada;
	}

	/**
	 * @return the fechaFinalTemporada
	 */
	public Date getFechaFinalTemporada() {
		return fechaFinalTemporada;
	}

	/**
	 * @param fechaFinalTemporada the fechaFinalTemporada to set
	 */
	public void setFechaFinalTemporada(Date fechaFinalTemporada) {
		this.fechaFinalTemporada = fechaFinalTemporada;
	}

	/**
	 * @return the codigoClase
	 */
	public String getCodigoClase() {
		return codigoClase;
	}

	/**
	 * @param codigoClase the codigoClase to set
	 */
	public void setCodigoClase(String codigoClase) {
		this.codigoClase = codigoClase;
	}

	/**
	 * @return the validacionRegistroWarning
	 */
	public Boolean getValidacionRegistroWarning() {
		return validacionRegistroWarning;
	}

	/**
	 * @param validacionRegistroWarning the validacionRegistroWarning to set
	 */
	public void setValidacionRegistroWarning(Boolean validacionRegistroWarning) {
		this.validacionRegistroWarning = validacionRegistroWarning;
	}

	/**
	 * @return the validacionRegistroError
	 */
	public Boolean getValidacionRegistroError() {
		return validacionRegistroError;
	}

	/**
	 * @param validacionRegistroError the validacionRegistroError to set
	 */
	public void setValidacionRegistroError(Boolean validacionRegistroError) {
		this.validacionRegistroError = validacionRegistroError;
	}
	
	public String getLugarCompra() {
		return lugarCompra;
	}

	public void setLugarCompra(String lugarCompra) {
		this.lugarCompra = lugarCompra;
		this.costruirMap("lugarCompra", lugarCompra);
	}

	public Long getCodigoLugarCompra() {
		return codigoLugarCompra;
	}

	public void setCodigoLugarCompra(Long codigoLugarCompra) {
		this.codigoLugarCompra = codigoLugarCompra;
	}

	/**
	 * @return the caracteristicasEspeciales
	 */
	public Collection<ArticuloEdicionMasivaVO> getCaracteristicasEspeciales() {
		return caracteristicasEspeciales;
	}

	/**
	 * @param caracteristicasEspeciales the caracteristicasEspeciales to set
	 */
	public void setCaracteristicasEspeciales(Collection<ArticuloEdicionMasivaVO> caracteristicasEspeciales) {
		this.caracteristicasEspeciales = caracteristicasEspeciales;
	}

	public String getCodigoOpcion() {
		return codigoOpcion;
	}

	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}

	public Collection<String> getErroresRegistro() {
		if(erroresRegistro == null){
			erroresRegistro = new ArrayList<String>();
		}
		return erroresRegistro;
	}

	public void setErroresRegistro(Collection<String> erroresRegistro) {
		this.erroresRegistro = erroresRegistro;
	}

}
