package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloNovedadCuponID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTNOVCUP")
public class ArticuloNovedadCuponDTO implements Serializable {
	
	@EmbeddedId
	private ArticuloNovedadCuponID id;
	
	@Column(name="CODIGOCLASIFICACION")
	private String codigoClasificacion;
	
	@Column(name="CODIGOSUBCLASIFICACION")
	private String codigoSubClasificacion;
	
	@Column(name="CODIGOCLASIFICACIONRELACIONADA")
	private String codigoClasificacionRelacionada;
	
	@Column(name="ESTADO", nullable=false)
	private String estado;
	
	@Column(name="MENSAJE")
	private String mensaje;
	
	@Column(name="OBSERVACION")
	private String observacion;
	
	public ArticuloNovedadCuponDTO() {
		this.id = new ArticuloNovedadCuponID();
	}
	
	/**
	 * @return the id
	 */
	public ArticuloNovedadCuponID getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloNovedadCuponID id) {
		this.id = id;
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
	 * @return the codigoClasificacionRelacionada
	 */
	public String getCodigoClasificacionRelacionada() {
		return codigoClasificacionRelacionada;
	}
	
	/**
	 * @param codigoClasificacionRelacionada the codigoClasificacionRelacionada to set
	 */
	public void setCodigoClasificacionRelacionada(String codigoClasificacionRelacionada) {
		this.codigoClasificacionRelacionada = codigoClasificacionRelacionada;
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
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
