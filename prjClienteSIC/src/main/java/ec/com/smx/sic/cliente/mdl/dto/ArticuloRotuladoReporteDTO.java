/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloRotuladoReporteID;

/**
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADVARTICULOROTULADOREPORTE")
public class ArticuloRotuladoReporteDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ArticuloRotuladoReporteID  id = new ArticuloRotuladoReporteID();

	private String descripcionArticulo;
	
	private java.sql.Timestamp fechaRegistro;
	
	private java.sql.Timestamp fechaModificacion;
	
	private java.sql.Timestamp fechaAuditoria;
	
	private String codigoBarras;
	
	private String codigoClasificacion;
	
	private String codigoProveedor;
	
	private String codigoJDEProveedor;
	
	private String nombreProveedor;
	
	private String referenciaMedida;
	
	private Integer codigoPadre;
	
	@Column(name = "USERNOM")
	private String userName;
	
	@Column(name = "USERNOMAUDITOR")
	private String userNameAuditor;
	
	@Column(name = "USERNOMMODIFICACION")
	private String userNameModificacion;
	
	@Column(name = "NOVEDAD")
	private String novedadAuditoria;
	
	@Column(name = "VALORCUMPLE", nullable = false)
	private String valorCumple;
	
	@Column(name = "VALOROBSERVACION")
	private String valorObservacion;
	
	@Column(name = "VALORAUDITORIA")
	private String valorAuditoria;
	
	@Column(name = "NOMBRECAMPOPLANTILLA")
	private String valorPregunta;

	/**
	 * @return the id
	 */
	public ArticuloRotuladoReporteID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloRotuladoReporteID id) {
		this.id = id;
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
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the novedadAuditoria
	 */
	public String getNovedadAuditoria() {
		return novedadAuditoria;
	}

	/**
	 * @param novedadAuditoria the novedadAuditoria to set
	 */
	public void setNovedadAuditoria(String novedadAuditoria) {
		this.novedadAuditoria = novedadAuditoria;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the userNameAuditor
	 */
	public String getUserNameAuditor() {
		return userNameAuditor;
	}

	/**
	 * @param userNameAuditor the userNameAuditor to set
	 */
	public void setUserNameAuditor(String userNameAuditor) {
		this.userNameAuditor = userNameAuditor;
	}

	/**
	 * @return the valorCumple
	 */
	public String getValorCumple() {
		return valorCumple;
	}

	/**
	 * @param valorCumple the valorCumple to set
	 */
	public void setValorCumple(String valorCumple) {
		this.valorCumple = valorCumple;
	}

	/**
	 * @return the valorObservacion
	 */
	public String getValorObservacion() {
		return valorObservacion;
	}

	/**
	 * @param valorObservacion the valorObservacion to set
	 */
	public void setValorObservacion(String valorObservacion) {
		this.valorObservacion = valorObservacion;
	}

	/**
	 * @return the valorPregunta
	 */
	public String getValorPregunta() {
		return valorPregunta;
	}

	/**
	 * @param valorPregunta the valorPregunta to set
	 */
	public void setValorPregunta(String valorPregunta) {
		this.valorPregunta = valorPregunta;
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
	}

	/**
	 * @return the valorAuditoria
	 */
	public String getValorAuditoria() {
		return valorAuditoria;
	}

	/**
	 * @param valorAuditoria the valorAuditoria to set
	 */
	public void setValorAuditoria(String valorAuditoria) {
		this.valorAuditoria = valorAuditoria;
	}

	/**
	 * @return the fechaAuditoria
	 */
	public java.sql.Timestamp getFechaAuditoria() {
		return fechaAuditoria;
	}

	/**
	 * @param fechaAuditoria the fechaAuditoria to set
	 */
	public void setFechaAuditoria(java.sql.Timestamp fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	/**
	 * @return the userNameModificacion
	 */
	public String getUserNameModificacion() {
		return userNameModificacion;
	}

	/**
	 * @param userNameModificacion the userNameModificacion to set
	 */
	public void setUserNameModificacion(String userNameModificacion) {
		this.userNameModificacion = userNameModificacion;
	}

	/**
	 * @return the codigoPadre
	 */
	public Integer getCodigoPadre() {
		return codigoPadre;
	}

	/**
	 * @param codigoPadre the codigoPadre to set
	 */
	public void setCodigoPadre(Integer codigoPadre) {
		this.codigoPadre = codigoPadre;
	}

	/**
	 * @return the codigoJDEProveedor
	 */
	public String getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	/**
	 * @param codigoJDEProveedor the codigoJDEProveedor to set
	 */
	public void setCodigoJDEProveedor(String codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}
		
}
