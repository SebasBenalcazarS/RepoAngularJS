package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ArticuloInformacionNutricionalID  implements Serializable{
	
	/**
	 * codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * codigo componente nutricional
	 */
	@Column(name = "SECCOMNUT", nullable = false)
	private Integer codigoComponenteNutricional;
	
	/**
	 * Código del registro sanitario de artículo
	 *
	 */
	@Column(name = "CODIGOREGISTROSANITARIO", nullable = false)
	private String codigoRegistroSanitario;

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
	 * @return the codigoComponenteNutricional
	 */
	public Integer getCodigoComponenteNutricional() {
		return codigoComponenteNutricional;
	}

	/**
	 * @param codigoComponenteNutricional the codigoComponenteNutricional to set
	 */
	public void setCodigoComponenteNutricional(Integer codigoComponenteNutricional) {
		this.codigoComponenteNutricional = codigoComponenteNutricional;
	}

	/**
	 * @return the codigoRegistroSanitario
	 */
	public String getCodigoRegistroSanitario() {
		return codigoRegistroSanitario;
	}

	/**
	 * @param codigoRegistroSanitario the codigoRegistroSanitario to set
	 */
	public void setCodigoRegistroSanitario(String codigoRegistroSanitario) {
		this.codigoRegistroSanitario = codigoRegistroSanitario;
	}
	
}
