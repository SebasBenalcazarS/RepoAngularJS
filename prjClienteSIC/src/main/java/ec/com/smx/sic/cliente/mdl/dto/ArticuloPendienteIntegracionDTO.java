package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;

/**
 * Entidad que almacena los art&iacute;culos pendientes de enviar por integraci&oacute;n
 * 
 * @author fmunoz
 */
@Entity
@Table(name="SCARTTARTPENINT")
@SuppressWarnings("serial")
public class ArticuloPendienteIntegracionDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPendienteIntegracionID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPendienteIntegracionID();
	@ComparatorTypeField
	private String codigoArticulo;
	@ComparatorTypeField
	private String estado;
	private String observacion;
	@ComparatorTypeField
	private String valorTipoProceso;
	private Integer codigoTipoProceso;
	
	/**
	 * Especifica si se debe o no notificar informacion
	 */
	@Column(name = "NOTIFICAR")
	private String notificar;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;
	
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOPROCESO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOPROCESO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoProceso;

	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPendienteIntegracionID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPendienteIntegracionID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getValorTipoProceso() {
		return valorTipoProceso;
	}

	public void setValorTipoProceso(String valorTipoProceso) {
		this.valorTipoProceso = valorTipoProceso;
	}

	public Integer getCodigoTipoProceso() {
		return codigoTipoProceso;
	}

	public void setCodigoTipoProceso(Integer codigoTipoProceso) {
		this.codigoTipoProceso = codigoTipoProceso;
	}
	
	public String getNotificar() {
		return notificar;
	}

	public void setNotificar(String notificar) {
		this.notificar = notificar;
	}

	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public CatalogoValorDTO getTipoProceso() {
		return tipoProceso;
	}

	public void setTipoProceso(CatalogoValorDTO tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	
}
