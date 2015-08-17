/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ec.com.smx.sic.cliente.common.articulo.EnumRegistroEdicionMasivaDatosLogisticos;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties( ignoreUnknown = true )
public class ArticuloEdicionMasivaDatosLogisticosVO implements Serializable {
	
	private String id;
	private Integer codigoCompania;
	protected String usuarioModificacion;
	protected Timestamp fechaModificacion;

	//datos del articulo
	private String codigoArticulo;
	private String codigoBarrasArticulo;
	private String codigoBarrasArticuloRelacionado;
	private String descripcion;	
	private String codigoClase;
	private String clasificacion;
	private String subClasificacion;

	private String valorTipoConservacion;
	private Integer codigoTipoConservacion;
	private String tipoConservacion;

	private Boolean isParent;
	
	private String event;
	
	private Map<Object, Object> noEditable;
	
	
	//coleccion de proveedores
	private Collection<ArticuloEdicionMasivaVO> proveedorCol;
	
	private Set<EnumRegistroEdicionMasivaDatosLogisticos> enumRegistroEdicionMasiva;
	
	private Map<String, Object> mapaDatosArticulos;
	
	private Map<String,Object> dynamicProperties;
	private Set<String> codigosAreasTrabajo;
	
	private Boolean validacionRegistroWarning = Boolean.FALSE;
	
	private Boolean validacionRegistroError = Boolean.FALSE;
	
	/************************************************
	 * DATOS EXTRA
	 ************************************************/
	private Long codigoUnidadManejo;
	
	private Double peso;

	private Double alto;

	private Double ancho;

	private Double profundidad;
	
	private Integer cantidadPallet;
	
	private Integer cantidad;
	
	
	private Integer codigoAreaAlmacenamiento;

	private String valorAreaAlmacenamiento;
	
	private String areaAlmacenamiento;
	
	
	private Boolean tieneTara;
	
	
	private Integer codigoTipoUbicacion;

	private String valorTipoUbicacion;
	
	private String tipoUbicacion;
	
	
	private Integer codigoTipoRelacion;

	private String valorTipoRelacion;
	
	private String tipoRelacion;
	
	private String estadoRelacion;
	
	/**
	 * 
	 */
	public ArticuloEdicionMasivaDatosLogisticosVO() {
		if( this.mapaDatosArticulos == null )
			this.mapaDatosArticulos = new HashMap<String, Object>();
	}
	
	private void costruirMap(String key, Object value){		
		this.mapaDatosArticulos.put(key, value);		
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
	}

	/**
	 * @return the enumRegistroEdicionMasiva
	 */
	public Set<EnumRegistroEdicionMasivaDatosLogisticos> getEnumRegistroEdicionMasiva() {
		return enumRegistroEdicionMasiva;
	}

	/**
	 * @param enumRegistroEdicionMasiva the enumRegistroEdicionMasiva to set
	 */
	public void setEnumRegistroEdicionMasiva(Set<EnumRegistroEdicionMasivaDatosLogisticos> enumRegistroEdicionMasiva) {
		this.enumRegistroEdicionMasiva = enumRegistroEdicionMasiva;
	}

	/**
	 * @return the mapaDatosArticulos
	 */
	public Map<String, Object> getMapaDatosArticulos() {
		return mapaDatosArticulos;
	}

	/**
	 * @param mapaDatosArticulos the mapaDatosArticulos to set
	 */
	public void setMapaDatosArticulos(Map<String, Object> mapaDatosArticulos) {
		this.mapaDatosArticulos = mapaDatosArticulos;
	}

	/**
	 * @return the dynamicProperties
	 */
	public Map<String, Object> getDynamicProperties() {
		return dynamicProperties;
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
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	/**
	 * @return the alto
	 */
	public Double getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(Double alto) {
		this.alto = alto;
	}

	/**
	 * @return the ancho
	 */
	public Double getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the profundidad
	 */
	public Double getProfundidad() {
		return profundidad;
	}

	/**
	 * @param profundidad the profundidad to set
	 */
	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}

	/**
	 * @return the cantidadPallet
	 */
	public Integer getCantidadPallet() {
		return cantidadPallet;
	}

	/**
	 * @param cantidadPallet the cantidadPallet to set
	 */
	public void setCantidadPallet(Integer cantidadPallet) {
		this.cantidadPallet = cantidadPallet;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the codigoAreaAlmacenamiento
	 */
	public Integer getCodigoAreaAlmacenamiento() {
		return codigoAreaAlmacenamiento;
	}

	/**
	 * @param codigoAreaAlmacenamiento the codigoAreaAlmacenamiento to set
	 */
	public void setCodigoAreaAlmacenamiento(Integer codigoAreaAlmacenamiento) {
		this.codigoAreaAlmacenamiento = codigoAreaAlmacenamiento;
	}

	/**
	 * @return the valorAreaAlmacenamiento
	 */
	public String getValorAreaAlmacenamiento() {
		return valorAreaAlmacenamiento;
	}

	/**
	 * @param valorAreaAlmacenamiento the valorAreaAlmacenamiento to set
	 */
	public void setValorAreaAlmacenamiento(String valorAreaAlmacenamiento) {
		this.valorAreaAlmacenamiento = valorAreaAlmacenamiento;
	}

	/**
	 * @return the tieneTara
	 */
	public Boolean getTieneTara() {
		return tieneTara;
	}

	/**
	 * @param tieneTara the tieneTara to set
	 */
	public void setTieneTara(Boolean tieneTara) {
		this.tieneTara = tieneTara;
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
	 * @return the codigoTipoRelacion
	 */
	public Integer getCodigoTipoRelacion() {
		return codigoTipoRelacion;
	}

	/**
	 * @param codigoTipoRelacion the codigoTipoRelacion to set
	 */
	public void setCodigoTipoRelacion(Integer codigoTipoRelacion) {
		this.codigoTipoRelacion = codigoTipoRelacion;
	}

	/**
	 * @return the valorTipoRelacion
	 */
	public String getValorTipoRelacion() {
		return valorTipoRelacion;
	}

	/**
	 * @param valorTipoRelacion the valorTipoRelacion to set
	 */
	public void setValorTipoRelacion(String valorTipoRelacion) {
		this.valorTipoRelacion = valorTipoRelacion;
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
	}
	
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
	 * @return the tipoConservacion
	 */
	public String getTipoConservacion() {
		return tipoConservacion;
	}

	/**
	 * @param tipoConservacion the tipoConservacion to set
	 */
	public void setTipoConservacion(String tipoConservacion) {
		this.tipoConservacion = tipoConservacion;
	}

	/**
	 * @return the areaAlmacenamiento
	 */
	public String getAreaAlmacenamiento() {
		return areaAlmacenamiento;
	}

	/**
	 * @param areaAlmacenamiento the areaAlmacenamiento to set
	 */
	public void setAreaAlmacenamiento(String areaAlmacenamiento) {
		this.areaAlmacenamiento = areaAlmacenamiento;
	}

	/**
	 * @return the tipoUbicacion
	 */
	public String getTipoUbicacion() {
		return tipoUbicacion;
	}

	/**
	 * @param tipoUbicacion the tipoUbicacion to set
	 */
	public void setTipoUbicacion(String tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}

	/**
	 * @return the tipoRelacion
	 */
	public String getTipoRelacion() {
		return tipoRelacion;
	}

	/**
	 * @param tipoRelacion the tipoRelacion to set
	 */
	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

	/**
	 * @return the codigoBarrasArticuloRelacionado
	 */
	public String getCodigoBarrasArticuloRelacionado() {
		return codigoBarrasArticuloRelacionado;
	}

	/**
	 * @param codigoBarrasArticuloRelacionado the codigoBarrasArticuloRelacionado to set
	 */
	public void setCodigoBarrasArticuloRelacionado(String codigoBarrasArticuloRelacionado) {
		this.codigoBarrasArticuloRelacionado = codigoBarrasArticuloRelacionado;
	}

	/**
	 * @return the estadoRelacion
	 */
	public String getEstadoRelacion() {
		return estadoRelacion;
	}

	/**
	 * @param estadoRelacion the estadoRelacion to set
	 */
	public void setEstadoRelacion(String estadoRelacion) {
		this.estadoRelacion = estadoRelacion;
	}

}
