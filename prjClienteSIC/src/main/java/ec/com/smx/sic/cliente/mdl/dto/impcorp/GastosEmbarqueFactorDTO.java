/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.GastosEmbarqueFactorID;


/**
 * @author rhidalgo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SISIMVGASEMBFCT")
public class GastosEmbarqueFactorDTO extends AuditoriaBaseDTO<GastosEmbarqueFactorID>{
	
		
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	
	
	@Column(name = "VALOR")
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE",  insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUEESTADO", referencedColumnName = "CODIGOEMBARQUEESTADO", insertable = false, updatable = false)
	})
	private VistaEmbarqueDTO reporteEmbarque;
	
	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public VistaEmbarqueDTO getReporteEmbarque() {
		return reporteEmbarque;
	}

	public void setReporteEmbarque(VistaEmbarqueDTO reporteEmbarque) {
		this.reporteEmbarque = reporteEmbarque;
	}

	
	
	
	
}
