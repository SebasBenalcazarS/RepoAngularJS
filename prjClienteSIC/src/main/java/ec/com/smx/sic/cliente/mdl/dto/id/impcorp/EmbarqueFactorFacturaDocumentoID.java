package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

/**
 * 
 */


import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class EmbarqueFactorFacturaDocumentoID extends BaseID{
	
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOEMBARQUEFACTOR")
	private Long codigoEmbarqueFactor;
	
	@Column(name = "CODIGOFACTURA")
	private Long codigoFactura;
	
	@Column(name = "CODIGOFACTURAESTADO")
	private Long codigoFacturaEstado;

	@Column(name = "CODIGODOCUMENTO")
	private Long codigoDocumento;

	/**
	 * @return devuelve el valor de la propiedad codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania establece el valor a la propiedad codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarqueFactor
	 */
	public Long getCodigoEmbarqueFactor() {
		return codigoEmbarqueFactor;
	}

	/**
	 * @param codigoEmbarqueFactor establece el valor a la propiedad codigoEmbarqueFactor
	 */
	public void setCodigoEmbarqueFactor(Long codigoEmbarqueFactor) {
		this.codigoEmbarqueFactor = codigoEmbarqueFactor;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFactura
	 */
	public Long getCodigoFactura() {
		return codigoFactura;
	}

	/**
	 * @param codigoFactura establece el valor a la propiedad codigoFactura
	 */
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFacturaEstado
	 */
	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	/**
	 * @param codigoFacturaEstado establece el valor a la propiedad codigoFacturaEstado
	 */
	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoDocumento
	 */
	public Long getCodigoDocumento() {
		return codigoDocumento;
	}

	/**
	 * @param codigoDocumento establece el valor a la propiedad codigoDocumento
	 */
	public void setCodigoDocumento(Long codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	
}
