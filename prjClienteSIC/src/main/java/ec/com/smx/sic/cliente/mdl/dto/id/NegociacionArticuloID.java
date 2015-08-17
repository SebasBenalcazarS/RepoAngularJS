package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author srodriguez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class NegociacionArticuloID implements Serializable{
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	@Column(name="CODIGONEGOCIACIONARTICULO")
	private Long codigoNegociacionArticulo;
	public static final String NOMBRE_SECUENCIA="SCCEMSECNEGART";
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/* Metodo que retorna codigoNegociacionArticulo del objeto
	 * @author srodriguez
	 * 10/1/2015
	 * @return Long codigoNegociacionArticulo 
	 */
	public Long getCodigoNegociacionArticulo() {
		return codigoNegociacionArticulo;
	}
	/* Metodo que asigna el codigoNegociacionArticulo del objeto
	 * @author srodriguez
	 * 10/1/2015
	 * @param codigoNegociacionArticulo parametro de tipo Long
	 */
	public void setCodigoNegociacionArticulo(Long codigoNegociacionArticulo) {
		this.codigoNegociacionArticulo = codigoNegociacionArticulo;
	}
}
