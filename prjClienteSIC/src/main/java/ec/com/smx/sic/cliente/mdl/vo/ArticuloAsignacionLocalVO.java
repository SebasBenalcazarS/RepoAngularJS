package ec.com.smx.sic.cliente.mdl.vo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;


@SuppressWarnings("serial")
public class ArticuloAsignacionLocalVO extends ArticuloLocalAlcanceVO{
	
	private Integer cantidad;

	private Timestamp fechaInicio;
	
	private Timestamp fechaFin;
	
	private String estado;
	
	@Transient
	private Date fechaInicial;
	
	@Transient
	private Date fechaFinal;
	
	@Transient
	private Boolean esCreacion = Boolean.TRUE;
	
	private Map<String,Object> dynamicProperties;
	// Variable para agrupar los locales en los establecimientos
	private Integer orden;
	
	private Integer numeroLocales;

	//-------------------------------------------------------
	//--------METODOS DE PROPIEDADES DINAMICAS
	//-------------------------------------------------------
	
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
	 * @return the fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the dynamicProperties
	 */
	public Map<String, Object> getDynamicProperties() {
		return dynamicProperties;
	}

	/**
	 * @param dynamicProperties the dynamicProperties to set
	 */
	public void setDynamicProperties(Map<String, Object> dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
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
	
	public Boolean hasDynamicProperty(String name){
		if(this.dynamicProperties == null){
			return Boolean.FALSE;
		}
		return dynamicProperties.containsKey(name);
	}

	/**
	 * @return the esCreacion
	 */
	public Boolean getEsCreacion() {
		return esCreacion;
	}

	/**
	 * @param esCreacion the esCreacion to set
	 */
	public void setEsCreacion(Boolean esCreacion) {
		this.esCreacion = esCreacion;
	}

	/**
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
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
	 * @return the numeroLocales
	 */
	public Integer getNumeroLocales() {
		return numeroLocales;
	}

	/**
	 * @param numeroLocales the numeroLocales to set
	 */
	public void setNumeroLocales(Integer numeroLocales) {
		this.numeroLocales = numeroLocales;
	}
	
}
