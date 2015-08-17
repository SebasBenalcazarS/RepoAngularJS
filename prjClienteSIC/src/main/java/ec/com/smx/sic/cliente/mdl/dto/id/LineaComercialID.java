package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class LineaComercialID implements Serializable{
	 /**
     * Codigo de la compania
     */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

    /**
     * Codigo que linea comercial
     *
     */
	@Column(name = "CODIGOLINEACOMERCIAL", nullable = false)
   // @SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECLINCOM")
    private Long codigoLineaComercial;

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
	 * @return the codigoLineaComercial
	 */
	public Long getCodigoLineaComercial() {
		return codigoLineaComercial;
	}

	/**
	 * @param codigoLineaComercial the codigoLineaComercial to set
	 */
	public void setCodigoLineaComercial(Long codigoLineaComercial) {
		this.codigoLineaComercial = codigoLineaComercial;
	}

}
