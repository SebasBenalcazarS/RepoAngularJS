/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Id;

import org.hibernate.annotations.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * @author jmontenegro
 *
 */
@Entity
@SuppressWarnings("serial")
public class VistaUbicacionArticuloDTO extends SearchDTO  {

	private Integer codigoAreatrabajo ;
	private String descripcionAreaTrabajo;
	private String nave; 
	private String subNave; 
	private String pasillo;
	private String ubicacion;
	private String rack;
	private Integer tipoAlmacenamiento;
	private String valorAlmacenamiento;
	private Integer tipoUbicacion;	
	private String valorUbicacion;
	private String existUbV;
	private String codigoBarras;
	private String codigoArticulo;
	private Integer cantidad;
	private Timestamp fechaCaducidad;
	private String descripcionArticulo;
	private String codigoBarrasUnidadManejo;
	private Integer valorUnidadManejo;
	private Integer valorUniManArt;
	private Long codigoUnidadManejo;
	private Integer codigoReferencia;
	private String referenciaMedida;
	private Long codigoSeccionUbicacion ;
	private Long codigoDetalleSeccionRack ;
	private String nombreArea;
	private Long codigoDetalleSeccionArea ;
	private Date fechaRecepcion;
	
	@Id
	private java.lang.Long id;//codigoDetalleSeccionUbicacion;
	
	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}
	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	/**
	 * @return the pasillo
	 */
	public String getPasillo() {
		return pasillo;
	}
	/**
	 * @param pasillo the pasillo to set
	 */
	public void setPasillo(String pasillo) {
		this.pasillo = pasillo;
	}
	/**
	 * @return the rack
	 */
	public String getRack() {
		return rack;
	}
	/**
	 * @param rack the rack to set
	 */
	public void setRack(String rack) {
		this.rack = rack;
	}
	
	/**
	 * @return the codigoAreatrabajo
	 */
	public Integer getCodigoAreatrabajo() {
		return codigoAreatrabajo;
	}
	/**
	 * @param codigoAreatrabajo the codigoAreatrabajo to set
	 */
	public void setCodigoAreatrabajo(Integer codigoAreatrabajo) {
		this.codigoAreatrabajo = codigoAreatrabajo;
	}
	/**
	 * @return the descripcionAreaTrabajo
	 */
	public String getDescripcionAreaTrabajo() {
		return descripcionAreaTrabajo;
	}
	/**
	 * @param descripcionAreaTrabajo the descripcionAreaTrabajo to set
	 */
	public void setDescripcionAreaTrabajo(String descripcionAreaTrabajo) {
		this.descripcionAreaTrabajo = descripcionAreaTrabajo;
	}
	
	/**
	 * @return the valorAlmacenamiento
	 */
	public String getValorAlmacenamiento() {
		return valorAlmacenamiento;
	}
	/**
	 * @param valorAlmacenamiento the valorAlmacenamiento to set
	 */
	public void setValorAlmacenamiento(String valorAlmacenamiento) {
		this.valorAlmacenamiento = valorAlmacenamiento;
	}
	/**
	 * @return the valorUbicacion
	 */
	public String getValorUbicacion() {
		return valorUbicacion;
	}
	/**
	 * @param valorUbicacion the valorUbicacion to set
	 */
	public void setValorUbicacion(String valorUbicacion) {
		this.valorUbicacion = valorUbicacion;
	}
	/**
	 * @return the id
	 */
	public java.lang.Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	/**
	 * @return the subNave
	 */
	public String getSubNave() {
		return subNave;
	}
	/**
	 * @param subNave the subNave to set
	 */
	public void setSubNave(String subNave) {
		this.subNave = subNave;
	}
	/**
	 * @return the existUbV
	 */
	public String getExistUbV() {
		return existUbV;
	}
	/**
	 * @param existUbV the existUbV to set
	 */
	public void setExistUbV(String existUbV) {
		this.existUbV = existUbV;
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
	 * @return the fechaCaducidad
	 */
	public Timestamp getFechaCaducidad() {
		return fechaCaducidad;
	}
	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(Timestamp fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
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
		this.descripcionArticulo = descripcionArticulo;
	}
	/**
	 * @return the codigoBarrasUnidadManejo
	 */
	public String getCodigoBarrasUnidadManejo() {
		return codigoBarrasUnidadManejo;
	}
	/**
	 * @param codigoBarrasUnidadManejo the codigoBarrasUnidadManejo to set
	 */
	public void setCodigoBarrasUnidadManejo(String codigoBarrasUnidadManejo) {
		this.codigoBarrasUnidadManejo = codigoBarrasUnidadManejo;
	}
	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}
	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
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
	 * @return the codigoReferencia
	 */
	public Integer getCodigoReferencia() {
		return codigoReferencia;
	}
	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(Integer codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	/**
	 * @return the valorUniManArt
	 */
	public Integer getValorUniManArt() {
		return valorUniManArt;
	}
	/**
	 * @param valorUniManArt the valorUniManArt to set
	 */
	public void setValorUniManArt(Integer valorUniManArt) {
		this.valorUniManArt = valorUniManArt;
	}
	/**
	 * @return the referenciaMedida
	 */
	public String getReferenciaMedida() {
		return referenciaMedida;
	}
	/**
	 * @param referenciaMedida the referenciaMedida to set
	 */
	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}
	/**
	 * @return the codigoSeccionUbicacion
	 */
	public Long getCodigoSeccionUbicacion() {
		return codigoSeccionUbicacion;
	}
	/**
	 * @param codigoSeccionUbicacion the codigoSeccionUbicacion to set
	 */
	public void setCodigoSeccionUbicacion(Long codigoSeccionUbicacion) {
		this.codigoSeccionUbicacion = codigoSeccionUbicacion;
	}
	/**
	 * @return the codigoDetalleSeccionRack
	 */
	public Long getCodigoDetalleSeccionRack() {
		return codigoDetalleSeccionRack;
	}
	/**
	 * @param codigoDetalleSeccionRack the codigoDetalleSeccionRack to set
	 */
	public void setCodigoDetalleSeccionRack(Long codigoDetalleSeccionRack) {
		this.codigoDetalleSeccionRack = codigoDetalleSeccionRack;
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
	 * @return the nave
	 */
	public String getNave() {
		return nave;
	}
	/**
	 * @param nave the nave to set
	 */
	public void setNave(String nave) {
		this.nave = nave;
	}
	/**
	 * @return the nombreArea
	 */
	public String getNombreArea() {
		return nombreArea;
	}
	/**
	 * @param nombreArea the nombreArea to set
	 */
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	/**
	 * @return the codigoDetalleSeccionArea
	 */
	public Long getCodigoDetalleSeccionArea() {
		return codigoDetalleSeccionArea;
	}
	/**
	 * @param codigoDetalleSeccionArea the codigoDetalleSeccionArea to set
	 */
	public void setCodigoDetalleSeccionArea(Long codigoDetalleSeccionArea) {
		this.codigoDetalleSeccionArea = codigoDetalleSeccionArea;
	}
	/**
	 * @return the tipoAlmacenamiento
	 */
	public Integer getTipoAlmacenamiento() {
		return tipoAlmacenamiento;
	}
	/**
	 * @param tipoAlmacenamiento the tipoAlmacenamiento to set
	 */
	public void setTipoAlmacenamiento(Integer tipoAlmacenamiento) {
		this.tipoAlmacenamiento = tipoAlmacenamiento;
	}
	/**
	 * @return the tipoUbicacion
	 */
	public Integer getTipoUbicacion() {
		return tipoUbicacion;
	}
	/**
	 * @param tipoUbicacion the tipoUbicacion to set
	 */
	public void setTipoUbicacion(Integer tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}
	/**
	 * @return the fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	
}
