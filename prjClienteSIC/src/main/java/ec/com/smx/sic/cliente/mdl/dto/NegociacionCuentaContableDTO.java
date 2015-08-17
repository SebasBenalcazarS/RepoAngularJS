package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.NegociacionCuentaContableID;

@Entity
@Table(name="SCCEMTNEGCUECON")
public class NegociacionCuentaContableDTO implements Serializable{
	
	private static final long serialVersionUID = 7863262235394607247L;
	
	@EmbeddedId
	private NegociacionCuentaContableID id = new NegociacionCuentaContableID();
	@Column(name="CODIGODETALLENEGOCIACION")
	private Long codigoDetalleNegociacion;
	@Column(name="CODIGOCUENTACONTABLE")
	private Integer codigoCuentaContable;
	@Column(name="PORCENTAJEACREDITAR")
	private BigDecimal porcentajeAcreditar;
	@Column(name="VALORMONETARIOACREDITAR")
	private BigDecimal valorMonetarioAcreditar;
	@Column(name="ESTADO")
	private Boolean estado;
	@Column(name="IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	@Column(name="FECHAREGISTRO")
	private Date fechaRegistro;
	@Column(name="IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	@Column(name="FECHAMODIFICACION")
	private Date fechaModificacion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGODETALLENEGOCIACION", referencedColumnName = "CODIGODETALLENEGOCIACION", insertable = false, updatable = false) })
	private DetalleNegociacionDTO detalleNegociacionDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOCUENTACONTABLE", referencedColumnName = "CODIGOCUENTACONTABLE", insertable = false, updatable = false) })
	private CuentaContableDTO cuentaContableDTO;
	
	public NegociacionCuentaContableID getId() {
		return id;
	}
	public void setId(NegociacionCuentaContableID id) {
		this.id = id;
	}
	public Long getCodigoDetalleNegociacion() {
		return codigoDetalleNegociacion;
	}
	public void setCodigoDetalleNegociacion(Long codigoDetalleNegociacion) {
		this.codigoDetalleNegociacion = codigoDetalleNegociacion;
	}
	public Integer getCodigoCuentaContable() {
		return codigoCuentaContable;
	}
	public void setCodigoCuentaContable(Integer codigoCuentaContable) {
		this.codigoCuentaContable = codigoCuentaContable;
	}
	public BigDecimal getPorcentajeAcreditar() {
		return porcentajeAcreditar;
	}
	public void setPorcentajeAcreditar(BigDecimal porcentajeAcreditar) {
		this.porcentajeAcreditar = porcentajeAcreditar;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
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
	

	public DetalleNegociacionDTO getDetalleNegociacionDTO() {
		return detalleNegociacionDTO;
	}
	public void setDetalleNegociacionDTO(DetalleNegociacionDTO detalleNegociacionDTO) {
		this.detalleNegociacionDTO = detalleNegociacionDTO;
	}
	public CuentaContableDTO getCuentaContableDTO() {
		return cuentaContableDTO;
	}
	public void setCuentaContableDTO(CuentaContableDTO cuentaContableDTO) {
		this.cuentaContableDTO = cuentaContableDTO;
	}
	public BigDecimal getValorMonetarioAcreditar() {
		return valorMonetarioAcreditar;
	}
	public void setValorMonetarioAcreditar(BigDecimal valorMonetarioAcreditar) {
		this.valorMonetarioAcreditar = valorMonetarioAcreditar;
	}
	
}
