package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.FacturaEstadoDescuentoID;

/**
 * Almacena los valores de diferentes descuentos como los que se aplica en la factura electronica del SRI, descuento total, descuento adicional a la tarifa doce
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITFACESTDES")
public class FacturaEstadoDescuentoDTO extends SimpleAuditDTO{

	@EmbeddedId
	private FacturaEstadoDescuentoID id = new FacturaEstadoDescuentoID();
	
	@Column(name="CODIGOFACTURAESTADO")
	private Long codigoFacturaEstado;
	
	@Column(name="CODIGOTIPOIMPUESTO")
	private Integer codigoTipoImpuesto;
	
	@Column(name="VALOR")
	private BigDecimal valor;
	
	@Column(name="CONCEPTO")
	@ComparatorTypeField
	private String concepto;
	
	@Column(name="CODIGOIMPUESTOSRI")
	@ComparatorTypeField
	private String codigoImpuestoSRI;
	
	@Column(name="PORCENTAJEIMPUESTOSRI")
	@ComparatorTypeField
	private String porcentajeImpuestoSRI;
	
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	@RegisterDateField
	@Column
	private java.util.Date fechaRegistro;

	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	@LastModificationDateField
	@Column(name="FECHAMODIFICACION")
	private java.util.Date fechaModificacion;

	public FacturaEstadoDescuentoID getId() {
		return id;
	}

	public void setId(FacturaEstadoDescuentoID id) {
		this.id = id;
	}

	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getCodigoImpuestoSRI() {
		return codigoImpuestoSRI;
	}

	public void setCodigoImpuestoSRI(String codigoImpuestoSRI) {
		this.codigoImpuestoSRI = codigoImpuestoSRI;
	}

	public String getPorcentajeImpuestoSRI() {
		return porcentajeImpuestoSRI;
	}

	public void setPorcentajeImpuestoSRI(String porcentajeImpuestoSRI) {
		this.porcentajeImpuestoSRI = porcentajeImpuestoSRI;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}