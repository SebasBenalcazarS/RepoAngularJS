package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;



/**
 * @author srodriguez
 * 2014-11-20
*/
@Embeddable
@SuppressWarnings("serial")
public class DatosAcumuladosID implements Serializable{
	
	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el codigo numerico los datos acumulados
	 */
	@Column(name = "CODIGODATOSACUMULADOS", nullable = false)
	private Long codigoDatosAcumulados;

	public static final String NOMBRE_SECUENCIA = "SCCEMSECDATACU";

	/* Metodo que retorna codigoCompania del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Integer codigoCompania 
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/* Metodo que asigna el codigoCompania del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoCompania parametro de tipo Integer
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/* Metodo que retorna codigoDatosAcumulados del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Long codigoDatosAcumulados 
	 */
	public Long getCodigoDatosAcumulados() {
		return codigoDatosAcumulados;
	}

	/* Metodo que asigna el codigoDatosAcumulados del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoDatosAcumulados parametro de tipo Long
	 */
	public void setCodigoDatosAcumulados(Long codigoDatosAcumulados) {
		this.codigoDatosAcumulados = codigoDatosAcumulados;
	}
	
}
