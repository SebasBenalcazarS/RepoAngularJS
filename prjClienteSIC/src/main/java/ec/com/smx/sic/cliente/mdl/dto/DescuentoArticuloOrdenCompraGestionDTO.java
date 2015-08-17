package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.DescuentoArticuloOrdenCompraGestionID;

/**
 * @author Marcelo Hidalgo
 * 
 */
@Entity
@Table(name = "SCPRETDESARTORDCOMGES")
@SuppressWarnings("serial")
public class DescuentoArticuloOrdenCompraGestionDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private DescuentoArticuloOrdenCompraGestionID id = new DescuentoArticuloOrdenCompraGestionID();
	
	@Column(name = "PORCENTAJEDESCUENTO", nullable = false)
	private BigDecimal porcentajeDescuento;
	
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	@Column(name = "CODIGOORDENCOMPRAGESTION", nullable = false)
	private Long codigoOrdenCompraGestion;
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	
	@Column(name = "SECUENCIALASITIPDES", nullable = false)
	private Integer secuencialAsignacionTipoDescuento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
	@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
	@JoinColumn(name = "CODIGOORDENCOMPRAGESTION", referencedColumnName = "CODIGOORDENCOMPRAGESTION", insertable = false, updatable = false) })
	private ArticuloOrdenCompraGestionDTO articuloOrdenCompraGestion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "SECUENCIALASITIPDES", referencedColumnName = "SECUENCIALASITIPDES", insertable = false, updatable = false)
	})
	private AsignacionTipoDescuentoDTO asignacionTipoDescuento;

	public DescuentoArticuloOrdenCompraGestionID getId() {
		return id;
	}

	public void setId(DescuentoArticuloOrdenCompraGestionID id) {
		this.id = id;
	}

	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArticuloOrdenCompraGestionDTO getArticuloOrdenCompraGestion() {
		return articuloOrdenCompraGestion;
	}

	public void setArticuloOrdenCompraGestion(ArticuloOrdenCompraGestionDTO articuloOrdenCompraGestion) {
		this.articuloOrdenCompraGestion = articuloOrdenCompraGestion;
	}

	public Long getCodigoOrdenCompraGestion() {
		return codigoOrdenCompraGestion;
	}

	public void setCodigoOrdenCompraGestion(Long codigoOrdenCompraGestion) {
		this.codigoOrdenCompraGestion = codigoOrdenCompraGestion;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Integer getSecuencialAsignacionTipoDescuento() {
		return secuencialAsignacionTipoDescuento;
	}

	public void setSecuencialAsignacionTipoDescuento(Integer secuencialAsignacionTipoDescuento) {
		this.secuencialAsignacionTipoDescuento = secuencialAsignacionTipoDescuento;
	}

	public AsignacionTipoDescuentoDTO getAsignacionTipoDescuento() {
		return asignacionTipoDescuento;
	}

	public void setAsignacionTipoDescuento(AsignacionTipoDescuentoDTO asignacionTipoDescuento) {
		this.asignacionTipoDescuento = asignacionTipoDescuento;
	}

}
