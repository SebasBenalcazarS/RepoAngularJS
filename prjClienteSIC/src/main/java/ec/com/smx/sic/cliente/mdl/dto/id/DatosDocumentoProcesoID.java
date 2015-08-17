package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class DatosDocumentoProcesoID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	@Column(name = "CODIGOFACTURAESTADO", nullable = false)
	private Long codigoFacturaEstado;
		
	@Column(name = "CODIGOPROCESO", nullable = false)
	private Long codigoProceso;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoFacturaEstado
	 */
	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	/**
	 * @param codigoFacturaEstado the codigoFacturaEstado to set
	 */
	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}
}
