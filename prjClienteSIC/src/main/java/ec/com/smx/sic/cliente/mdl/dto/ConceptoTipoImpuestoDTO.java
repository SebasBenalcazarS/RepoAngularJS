package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConceptoTipoImpuestoID;

/**
 * 
 * @author aquingaluisa
 * 2015-10-01
*/
@SuppressWarnings("serial")
@Entity
@Table(name = "SCCEMTCONTIPIMP")
public class ConceptoTipoImpuestoDTO extends SearchDTO implements Serializable{

	@EmbeddedId
	private ConceptoTipoImpuestoID id = new ConceptoTipoImpuestoID();
	
	@Column(name = "CODIGOTIPOIMPUESTO")
	private Integer codigoTipoImpuesto;
	
	@Column(name = "CODIGOCONCEPTO")
	private Long codigoConcepto;
	
	@Column(name = "CODIGOVALORFORMAVENTA")
	private String codigoValorFormaVenta;
	
	@Column(name = "CODIGOTIPOFORMAVENTA")
	private Integer codigoTipoFormaVenta;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
	
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;


	public ConceptoTipoImpuestoID getId() {
		return id;
	}

	public void setId(ConceptoTipoImpuestoID id) {
		this.id = id;
	}

	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}

	public Long getCodigoConcepto() {
		return codigoConcepto;
	}

	public void setCodigoConcepto(Long codigoConcepto) {
		this.codigoConcepto = codigoConcepto;
	}

	public String getCodigoValorFormaVenta() {
		return codigoValorFormaVenta;
	}

	public void setCodigoValorFormaVenta(String codigoValorFormaVenta) {
		this.codigoValorFormaVenta = codigoValorFormaVenta;
	}

	public Integer getCodigoTipoFormaVenta() {
		return codigoTipoFormaVenta;
	}

	public void setCodigoTipoFormaVenta(Integer codigoTipoFormaVenta) {
		this.codigoTipoFormaVenta = codigoTipoFormaVenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
}
