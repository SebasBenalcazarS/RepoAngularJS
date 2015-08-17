package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FacturaGastoEmbarqueContenedorImpID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACGASCON")
public class FacturaGastoEmbarqueContenedorImpDTO extends AuditoriaBaseDTO<FacturaGastoEmbarqueContenedorImpID> {

	@Column(name = "CODIGOFACTURAGASTOESTADO")
	private Long codigoFacturaGastoEstado;
	
	@Column(name = "CODIGOFACTURAGASTO")
	private Long codigoFacturaGasto;
	
	@Column(name = "FECHADESDE")
	private Timestamp fechaDesde;
	
	@Column(name = "FECHAHASTA")
	private Timestamp fechaHasta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUECONTENEDOR", referencedColumnName = "CODIGOEMBARQUECONTENEDOR", insertable = false, updatable = false)
	})
	private EmbarqueContenedorImpDTO embarqueContenedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAGASTOESTADO", referencedColumnName = "CODIGOFACTURAGASTOESTADO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAGASTO", referencedColumnName = "CODIGOFACTURAGASTO", insertable = false, updatable = false)
	})
	private FacturaGastoEmbarqueEstadoImpDTO facturaGastoEmbarqueEstado;
	
	/**
	 * @return the codigoFacturaGastoEstado
	 */
	public Long getCodigoFacturaGastoEstado() {
		return codigoFacturaGastoEstado;
	}

	/**
	 * @param codigoFacturaGastoEstado the codigoFacturaGastoEstado to set
	 */
	public void setCodigoFacturaGastoEstado(Long codigoFacturaGastoEstado) {
		this.codigoFacturaGastoEstado = codigoFacturaGastoEstado;
	}

	/**
	 * @return the codigoFacturaGasto
	 */
	public Long getCodigoFacturaGasto() {
		return codigoFacturaGasto;
	}

	/**
	 * @param codigoFacturaGasto the codigoFacturaGasto to set
	 */
	public void setCodigoFacturaGasto(Long codigoFacturaGasto) {
		this.codigoFacturaGasto = codigoFacturaGasto;
	}

	/**
	 * @return the embarqueContenedor
	 */
	public EmbarqueContenedorImpDTO getEmbarqueContenedor() {
		return embarqueContenedor;
	}

	/**
	 * @param embarqueContenedor the embarqueContenedor to set
	 */
	public void setEmbarqueContenedor(EmbarqueContenedorImpDTO embarqueContenedor) {
		this.embarqueContenedor = embarqueContenedor;
	}

	/**
	 * @return the facturaGastoEmbarqueEstado
	 */
	public FacturaGastoEmbarqueEstadoImpDTO getFacturaGastoEmbarqueEstado() {
		return facturaGastoEmbarqueEstado;
	}

	/**
	 * @param facturaGastoEmbarqueEstado the facturaGastoEmbarqueEstado to set
	 */
	public void setFacturaGastoEmbarqueEstado(FacturaGastoEmbarqueEstadoImpDTO facturaGastoEmbarqueEstado) {
		this.facturaGastoEmbarqueEstado = facturaGastoEmbarqueEstado;
	}

	/**
	 * @return the fechaDesde
	 */
	public Timestamp getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public void setFechaDesde(Timestamp fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @return the fechaHasta
	 */
	public Timestamp getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @param fechaHasta the fechaHasta to set
	 */
	public void setFechaHasta(Timestamp fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
}